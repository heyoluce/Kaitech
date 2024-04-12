INSERT INTO users (name, username, password, date_of_birth, phone_number, enabled, image_url, last_visit_date, status)
VALUES ('Amantur', 'admin', '$2a$12$Wdd4qDYvNGbo/gF97LqqM.rYb7mr/V/EqSLkeqBPj0fb4S/unHS5y', '2004-09-09', '+996771328181', true, 'admin.jpg', CURRENT_TIMESTAMP, 'ACTIVE');

INSERT INTO users_roles (user_id, role)
SELECT id, 'ROLE_ADMIN'
FROM users
WHERE username = 'admin';