
INSERT INTO roles (name, lessor, tourist) VALUES
('ROLE_ADD_OBJECT', 1, 0),
('ROLE_DELETE_OBJECT', 1, 0),
('ROLE_GET_OBJECT', 1, 0),
('ROLE_UPDATE_OBJECT', 1, 0),
('ROLE_SEARCH_OBJECT', 1, 0);


INSERT INTO lessors (name, surname, phone, birthday, email) VALUES
('Emil', 'Abbasli', '920', '1988-11-11', 'emil@mail.com'),
('Orxan', 'Eliyev', '912', '1990-02-05', 'orxan@mail.com');


INSERT INTO users (username, password, enabled, user_id, user_type) VALUES
('l1', '{bcrypt}$2a$10$examplehash1...', true, 1, 'lessor'),
('l2', '{bcrypt}$2a$10$examplehash2...', true, 2, 'lessor');


INSERT INTO user_roles (user_id, role_id)
SELECT u.id, r.id FROM users u JOIN roles r ON r.lessor = 1 WHERE u.username = 'l1';

INSERT INTO user_roles (user_id, role_id)
SELECT u.id, r.id FROM users u JOIN roles r ON r.lessor = 1 WHERE u.username = 'l2';


INSERT INTO objects (name, description, price, address, room_count, area, floor, lessor_code, category_id, price_per_night) VALUES
('Sea View Villa', 'Denizə baxışlı lüks villa', 230, 'Bakı, Nərimanov', 5, 250, 2, 1, 1, 200),
('City Apartment', 'Şəhərin mərkəzində rahat mənzil', 120, 'Bakı, Yasamal', 3, 90, 5, 1, 2, 130),
('Mountain House', 'Dağ mənzərəli ev', 150, 'Qəbələ, mərkəz', 4, 180, 1, 2, 1, 310),
('Cozy Studio', 'Tək şəxslər üçün studio', 75, 'Sumqayıt, 9-cu mikrorayon', 1, 45, 7, 2, 2, 400),
('Modern Cottage', 'Ailəvi istirahət üçün modern kottec', 180, 'Şamaxı', 3, 130, 1, 1, 1, 150),
('Old Town Flat', 'Tarixi bölgədə kirayə mənzil', 110, 'İçərişəhər', 2, 70, 3, 1, 2, 250);
