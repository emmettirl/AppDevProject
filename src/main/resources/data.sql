INSERT INTO household (eircode, number_occupants, max_number_occupants, owner_occupied) VALUES
                                                                                            ('EIR123', 2, 4, true),
                                                                                            ('EIR456', 0, 3, false);

INSERT INTO pet (name, animal_type, breed, age, household_eircode) VALUES
                                                                       ('Buddy', 'Dog', 'Labrador', 3, 'EIR123'),
                                                                       ('Mittens', 'Cat', 'Siamese', 2, 'EIR123');