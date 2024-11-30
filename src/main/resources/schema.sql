CREATE TABLE IF NOT EXISTS household (
    eircode VARCHAR(255) PRIMARY KEY,
    number_occupants INT NOT NULL,
    max_occupants INT NOT NULL,
    owner_occupied BOOLEAN NOT NULL
    );

CREATE TABLE IF NOT EXISTS pet (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    animal_type VARCHAR(255) NOT NULL,
    breed VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    household_eircode VARCHAR(255),
    CONSTRAINT fk_household FOREIGN KEY (household_eircode) REFERENCES household (eircode)
    );
