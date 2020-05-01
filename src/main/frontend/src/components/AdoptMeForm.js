import React, { useState } from "react"
import _ from "lodash"
import ErrorList from "./ErrorList"

const AdoptMeForm = props => {
  const defaultFormValue = {
    name: "",
    phone_number: "",
    email: "",
    home_status: "",
    application_status: "Pending",
    petId: `${props.petId}`
  }

  const [newApplication, setNewApplication] = useState(defaultFormValue)
  const [errors, setErrors] = useState({})
  const [submitted, setSubmitted] = useState(false)
  const [toHome, setToHome] = useState(false)

  const validForSubmission = () => {
    let submitErrors = {}
    const requiredFields = ["name", "phone_number", "email", "home_status"]

    requiredFields.forEach(field => {
      if (newApplication[field] === "") {
        submitErrors = {
          ...submitErrors,
          [field]: "is required"
        }
      }
    })

    setErrors(submitErrors)
    return _.isEmpty(submitErrors)
  }

  const handleInputChange = event => {
    setNewApplication({
      ...newApplication,
      [event.currentTarget.id]: event.currentTarget.value
    })
  }

  const onSubmitHandler = event => {
    event.preventDefault()
    if (validForSubmission()) {
      submitForm(newApplication)
    }
  }

  const submitForm = event => {
    event.preventDefault()
    if (validForSubmission()) {
      fetch("/api/v1/adoptionApplications", {
        method: "POST",
        body: JSON.stringify(newApplication),
        headers: { "Content-Type": "application/json" }
      })
        .then(response => {
          console.log(response)
          if (response.ok) {
            setSubmitted(true)
          } else {
            let errorMessage = `${response.statues} (${response.statusText})`,
              error = new Error(errorMessage)
            throw error
          }
        })
        .catch(error => console.error(`Error in fetch: ${error.message}`))
    }
  }

  const homeList = ["Own", "Rent"]
  const homeStatus = [""].concat(homeList).map(status => {
    return (
      <option key={status} value={status}>
        {status}
      </option>
    )
  })

  if (props.formReveal === true) {
    if (submitted === false) {
      return (
        <form
          autoComplete="off"
          id="adoptMeForm"
          className="callout form-format"
          onSubmit={submitForm}
        >
          <h1 className="header-title">Adopt Me!</h1>
          <ErrorList errors={errors} />
          <div>
            <label htmlFor="name">Name:</label>
            <input
              type="text"
              id="name"
              name="name"
              value={newApplication.name}
              onChange={handleInputChange}
            />
          </div>

          <div>
            <label htmlFor="phone_number">Phone Number:</label>
            <input
              type="text"
              id="phone_number"
              name="phone_number"
              value={newApplication.phoneNumber}
              onChange={handleInputChange}
            />
          </div>

          <div>
            <label htmlFor="email">Email:</label>
            <input
              type="text"
              id="email"
              name="email"
              value={newApplication.email}
              onChange={handleInputChange}
            />
          </div>

          <div>
            <label htmlFor="home_status">Home Status:</label>
            <select
              id="home_status"
              onChange={handleInputChange}
              value={newApplication.homeStatus}
            >
              {homeStatus}
            </select>
          </div>

          <input
            type="hidden"
            name="application_status"
            id="application_status"
            value="Pending"
          />

          <input type="hidden" name="petId" id="petId" value={props.petId} />

          <input type="submit" className="button" value="submit" />
        </form>
      )
    } else {
      return <h3 id="surrender-review">Your application is pending review.</h3>
    }
  } else {
    return ""
  }
}

export default AdoptMeForm
