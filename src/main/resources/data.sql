USE grocery_app;
INSERT INTO roles (id, name) VALUES (1, 'ROLE_ADMIN')
    ON DUPLICATE KEY UPDATE name = VALUES(name);

INSERT INTO roles (id, name) VALUES (2, 'ROLE_USER')
    ON DUPLICATE KEY UPDATE name = VALUES(name);
