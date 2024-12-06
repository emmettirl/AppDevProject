-- Create Roles Table
CREATE TABLE IF NOT EXISTS role (
                                    id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                    name VARCHAR(255) NOT NULL
    );

-- Create Users Table
CREATE TABLE IF NOT EXISTS users (
                                     id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                     username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    enabled BOOLEAN NOT NULL
    );

-- Create User-Roles Relationship Table
CREATE TABLE IF NOT EXISTS user_roles (
                                          user_id BIGINT NOT NULL,
                                          role_id BIGINT NOT NULL,
                                          FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (role_id) REFERENCES role(id)
    );

-- Create Pets Table
CREATE TABLE IF NOT EXISTS pet (
                                   id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                   name VARCHAR(255) NOT NULL,
    animal_type VARCHAR(255),
    breed VARCHAR(255),
    age INT
    );

-- Create Households Table
CREATE TABLE IF NOT EXISTS household (
                                         eircode VARCHAR(255) PRIMARY KEY,
    number_occupants INT,
    max_occupants INT,
    owner_occupied BOOLEAN
    );
