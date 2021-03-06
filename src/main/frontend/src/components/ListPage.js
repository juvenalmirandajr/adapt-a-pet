import React from "react"
import { Link } from "react-router-dom"

const ListPage = props => {
	const { img_url, name, vaccination_status, age, id } = props.data
	const type = props.petType.replace(" ", "");

	return (
		<div className="row add-pets-section">
			<div className="small-12 medium-6 columns about-pets">
				<div className="about-pets-avatar">
					<Link to={`/pets/${type}/${id}`}>
						<img className="avatar-image test" src={img_url} alt={name} />
					</Link>
				</div>
				<div className="about-pets-author">
					<Link to={`/pets/${type}/${id}`}>
						<p className="author-name">{name}</p>
					</Link>
					<p className="author-location"><strong>Age:</strong> {age}</p>
					<p className="author-mutual">
						<strong>Up to Date on Shots?</strong>{" "}
						{vaccination_status == true ? "Yes" : "No"}
					</p>
				</div>
			</div>
			<div className="small-12 medium-6 columns add-friend">
				<div className="add-friend-action">
					<Link to={`/pets/${type}/${id}`}>
						<button className="button primary small">Adopt Me</button>
					</Link>
				</div>
			</div>
		</div>
	)
}

export default ListPage
