import React, { useState } from "react"
import { Redirect } from "react-router-dom"
import _ from "lodash"
import ErrorList from "./ErrorList"

const SurrenderForm = (props) => {
  const defaultFormValues = {
    name: "",
    phone_number: "",
    email: "",
    pet_name: "",
    pet_age: "",
    pet_type_id: "",
    pet_img_url: "",
    vaccination_status: "",
    application_status: "Pending",
  }

  const [newSurrender, setNewSurrender] = useState(defaultFormValues)
  const [errors, setErrors] = useState({})
  const [submitted, setSubmitted] = useState(false)
  const [toHome, setToHome] = useState(false)

  const validForSubmission = () => {
    let submitErrors = {}
    const requiredFields = [
      "name",
      "phone_number",
      "email",
      "pet_name",
      "pet_age",
      "pet_type_id",
      "pet_img_url",
      "vaccination_status",
    ]

    requiredFields.forEach((field) => {
      if (newSurrender[field] === "") {
        submitErrors = {
          ...submitErrors,
          [field]: "is required",
        }
      }
    })

    setErrors(submitErrors)
    return _.isEmpty(submitErrors)
  }

  const handleInputChange = (event) => {
    setNewSurrender({
      ...newSurrender,
      [event.currentTarget.id]: event.currentTarget.value,
    })
  }

  const onSubmitHandler = (event) => {
    event.preventDefault()
    if (validForSubmission()) {
      submitForm(newSurrender)
    }
  }

  const submitForm = () => {
    fetch("/api/v1/surrenderApplications", {
      method: "POST",
      body: JSON.stringify(newSurrender),
      headers: { "Content-Type": "application/json" },
    })
      .then((response) => {
        if (response.ok) {
          setSubmitted(true)
        } else {
          let errorMessage = `${response.status} (${response.statusText})`,
            error = new Error(errorMessage)
          throw error
        }
      })
      .catch((error) => console.error(`Error in fetch: ${error.message}`))
  }

  if (submitted === false) {
    return (
      <form
        autoComplete="off"
        id="surrenderForm"
        className="callout form-format"
        onSubmit={onSubmitHandler}
      >
        <h1 className="header-title">Surrender a Pet</h1>
        <ErrorList errors={errors} />
        <div>
          <label htmlFor="name">Name:</label>
          <input
            type="text"
            id="name"
            name="name"
            value={newSurrender.name}
            onChange={handleInputChange}
          />
        </div>

        <div>
          <label htmlFor="phone_number">Phone Number:</label>
          <input
            type="tel"
            id="phone_number"
            name="phone_number"
            pattern="^\(?(\d{3})\)?[- ]?(\d{3})[- ]?(\d{4})$"
            placeholder="333-444-5555"
            title="333-444-5555"
            value={newSurrender.phone_number}
            onChange={handleInputChange}
          />
        </div>

        <div>
          <label htmlFor="email">Email:</label>
          <input
            type="text"
            id="email"
            name="email"
            pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"
            placeholder="someone@domain.com"
            title="someone@domain.com"
            value={newSurrender.email}
            onChange={handleInputChange}
          />
        </div>

        <div>
          <label htmlFor="pet_name">Pet Name:</label>
          <input
            type="text"
            id="pet_name"
            name="pet_name"
            value={newSurrender.pet_name}
            onChange={handleInputChange}
          />
        </div>

        <div>
          <label htmlFor="pet_age">Pet Age:</label>
          <input
            type="number"
            id="pet_age"
            name="pet_age"
            value={newSurrender.pet_age}
            onChange={handleInputChange}
          />
        </div>

        <div>
          <label htmlFor="pet_type_id">Pet Type:</label>
          <select
            id="pet_type_id"
            onChange={handleInputChange}
            value={newSurrender.pet_type_id}
          >
            <option value=""></option>
            <option value="1">Guinea Pig</option>
            <option value="2">Reptile</option>
          </select>
        </div>

        <div>
          <label htmlFor="pet_img_url">Image URL:</label>
          <input
            type="text"
            id="pet_img_url"
            name="pet_img_url"
            value={newSurrender.pet_img_url}
            onChange={handleInputChange}
          />
        </div>

        <div>
          <label htmlFor="vaccination_status">Vaccination Status:</label>
          <select
            id="vaccination_status"
            onChange={handleInputChange}
            value={newSurrender.vaccination_status}
          >
            <option value=""></option>
            <option value="true">Yes</option>
            <option value="false">No</option>
          </select>
        </div>

        <input
          type="hidden"
          name="applicationStatus"
          id="applicationStatus"
          value="pending"
        />

        <input type="submit" className="button" value="submit" />
      </form>
    )
  } else {
    return (
      <div className="callout success">
        <h3 id="surrender-review">Your request is in process.</h3>
        <div id="hidden">
          {setTimeout(() => setToHome(true), 3000)}
          {toHome ? <Redirect to="/pets" /> : null}
        </div>
      </div>
    )
  }
}

export default SurrenderForm
