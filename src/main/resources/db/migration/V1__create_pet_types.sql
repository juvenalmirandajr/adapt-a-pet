CREATE TABLE pet_types(
    id SERIAL PRIMARY KEY,
    type VARCHAR(255) NOT NULL,
    description VARCHAR(255)
);

CREATE UNIQUE INDEX idx_pet_types_type ON pet_types(type);