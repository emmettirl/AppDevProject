-- Insert Roles
INSERT INTO role (name) VALUES ('ROLE_USER');
INSERT INTO role (name) VALUES ('ROLE_ADMIN');

-- Insert Users with BCrypt-encoded passwords
-- Passwords: admin123 and user123 respectively
INSERT INTO users (username, password, enabled) VALUES ('admin', '$2a$10$7Q5j/OYaUpLUNxOeJN.N6.c5e1aY/YJPKB9dH9UrTdf6WkP12a8iy', true);  -- Password: admin123
INSERT INTO users (username, password, enabled) VALUES ('user1', '$2a$10$dXIvdbToocHBdWD8pBLffO/a0A2XBWnBKHZBjF7odD7pWxMQa1MZa', true);  -- Password: user123
INSERT INTO users (username, password, enabled) VALUES ('user2', '$2a$10$dXIvdbToocHBdWD8pBLffO/a0A2XBWnBKHZBjF7odD7pWxMQa1MZa', true);  -- Password: user123

-- Assign Roles to Users
INSERT INTO user_roles (user_id, role_id) VALUES ((SELECT id FROM users WHERE username='admin'), (SELECT id FROM role WHERE name='ROLE_ADMIN'));
INSERT INTO user_roles (user_id, role_id) VALUES ((SELECT id FROM users WHERE username='user1'), (SELECT id FROM role WHERE name='ROLE_USER'));
INSERT INTO user_roles (user_id, role_id) VALUES ((SELECT id FROM users WHERE username='user2'), (SELECT id FROM role WHERE name='ROLE_USER'));

-- Insert Pets
INSERT INTO pet (name, animal_type, breed, age) VALUES ('Bella', 'Dog', 'Golden Retriever', 5);
INSERT INTO pet (name, animal_type, breed, age) VALUES ('Max', 'Cat', 'Siamese', 3);

-- Insert Households
INSERT INTO household (eircode, number_occupants, max_occupants, owner_occupied) VALUES ('A12BCD3', 3, 5, true);
INSERT INTO household (eircode, number_occupants, max_occupants, owner_occupied) VALUES ('B34CDE5', 2, 4, false);
