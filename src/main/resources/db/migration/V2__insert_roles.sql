INSERT INTO users (name, username, password, date_of_birth, phone_number)
VALUES ('Admin', 'admin', 'admin', '1990-01-01', '+996771328181');

INSERT INTO users_roles (user_id, role)
VALUES ((SELECT id FROM users WHERE username = 'admin'), 'ROLE_ADMIN');
