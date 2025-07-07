INSERT INTO roles (name, lessor, tourist) VALUES
( 'ROLE_ADD_OBJECT',1,0),( 'ROLE_DELETE_OBJECT',1,0),( 'ROLE_GET_OBJECT',1,0),( 'ROLE_UPDATE_OBJECT',1,0),( 'ROLE_SEARCH_OBJECT',1,1);

insert into users
(username,password,enabled,user_id,user_type) values
('l1', '$2a$12$YwsKC9KDsJOcEOyjXcD5AuiMWx4FS5DiFSTXEOUOn/52lIGHGJT/W', 1, 1, 'lessor'),
('l2', '$2a$12$mO48VtW61525hUVz.DfOR.teZnBxsZCWZE71JY5Extl9/TvKDv1bm', 1, 2, 'lessor');

INSERT INTO lessors (name, surname, phone, birthday, email) VALUES
('Emil', 'Abbasli', '920', '1988-11-11', 'emil@mail.com'),
('Orxan', 'Eliyev', '912', '1990-02-05', 'orxan@mail.com');

INSERT INTO tourists (name, surname, phone, birthday, email) VALUES
('Anar', 'Bayramov', '924', '1988-10-18', 'anar@mail.com'),
('Elnur', 'Alxan', '915', '1990-06-08', 'elnur@mail.com');

INSERT INTO user_roles (user_id, role_id)
select 1,id from roles where lessor=1;

insert into user_roles (user_id,role_id)
select 2,id from roles where lessor=1;


INSERT INTO objects (name, description, price, address, room_count, area, floor, lessor_code, category_id, price_per_night) VALUES
('Sea View Villa', 'Denizə baxışlı lüks villa', 230, 'Bakı, Nərimanov', 5, 250, 2, 1, 1, 200),
('City Apartment', 'Şəhərin mərkəzində rahat mənzil', 120, 'Bakı, Yasamal', 3, 90, 5, 1, 2, 130),
('Mountain House', 'Dağ mənzərəli ev', 150, 'Qəbələ, mərkəz', 4, 180, 1, 2, 1, 310),
('Cozy Studio', 'Tək şəxslər üçün studio', 75, 'Sumqayıt, 9-cu mikrorayon', 1, 45, 7, 2, 2, 400),
('Modern Cottage', 'Ailəvi istirahət üçün modern kottec', 180, 'Şamaxı', 3, 130, 1, 1, 1, 150),
('Old Town Flat', 'Tarixi bölgədə kirayə mənzil', 110, 'İçərişəhər', 2, 70, 3, 1, 2, 250);
