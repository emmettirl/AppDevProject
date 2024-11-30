INSERT INTO household (eircode, number_occupants, max_occupants, owner_occupied) VALUES
  ('EIR123', 3, 5, TRUE),
  ('EIR124', 1, 3, FALSE),
  ('EIR125', 0, 4, TRUE);

INSERT INTO pet (name, animal_type, breed, age, household_eircode) VALUES
 ('Buddy', 'Dog', 'Golden Retriever', 3, 'EIR123'),
 ('Mittens', 'Cat', 'Tabby', 2, 'EIR123'),
 ('Goldie', 'Fish', 'Goldfish', 1, 'EIR124');
