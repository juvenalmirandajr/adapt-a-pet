import React, { useState } from "react"
import AdoptMeForm from "./AdoptMeForm"

const AnimalInfo = (props) => {
  const [formReveal, setFormReveal] = useState(false)
  const {
    adoption_story,
    age,
    id,
    img_url,
    name,
    vaccination_status,
  } = props.pet

  const onClickHandler = (event) => {
    setFormReveal(true)
  }

  if (id) {
    return (
      <div>
        <div className="portfolio-resume-scrolling-container row">
          <div
            className="columns small-12 medium-5 portfolio-resume-overview"
            style={{
              backgroundSize: "cover",
              zIndex: 0,
              backgroundImage: `url(${img_url})`,
            }}
          >
            <div className="portfolio-resume-overview-content"></div>
          </div>
          <div className="columns small-12 medium-7 portfolio-resume-scrolling">
            <h3>{name}</h3>
            <h5><strong>Age:</strong> {age}</h5>
            <h5><strong>Vaccination Status:</strong> {vaccination_status === true ? "Up to Date" : "Out of Date"}</h5>
            <h5><strong>Adoption Story:</strong> {adoption_story}</h5>
            <button
              className="button primary expanded"
              type="button"
              onClick={onClickHandler}
            >
              Adopt Me
            </button>
          </div>
        </div>
        <div>
          <AdoptMeForm formReveal={formReveal} petId={id} />
        </div>
      </div>
    )
  } else {
    return ""
  }
}

export default AnimalInfo
