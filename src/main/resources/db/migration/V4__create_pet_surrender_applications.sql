CREATE TABLE pet_surrender_applications (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    phone_number VARCHAR(15) NOT NULL,
    email VARCHAR(255) NOT NULL,
    pet_name VARCHAR(255) NOT NULL,
    pet_age INTEGER,
    pet_type_id INTEGER REFERENCES pet_types(id) NOT NULL,
    pet_img_url VARCHAR(255),
    vaccination_status BOOLEAN,
    application_status VARCHAR(255) NOT NULL
);

CREATE UNIQUE INDEX idx_pet_surrender_applications_name ON pet_surrender_applications(name);