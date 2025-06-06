INSERT INTO roles (name, lessor, tourist) VALUES 
('ROLE_ADD_OBJECT', 1, 0),
('ROLE_DELETE_OBJECT', 1, 0),
('ROLE_GET_OBJECT', 1, 0),
('ROLE_UPDATE_OBJECT', 1, 0),
('ROLE_SEARCH_OBJECT', 1, 0);





insert into users
(username,password,enabled,user_id,user_type) values
('s1','$2a$12$AXXj9t.V73x5iCEmRD0X..AboDocEu7aK12Xaf1dbNmN137CvcDZG',1,1,'lessor'),
('s2','$2a$12$AXXj9t.V73x5iCEmRD0X..AboDocEu7aK12Xaf1dbNmN137CvcDZG',1,2,'lessor');


insert into lessors
(name,surname,phone,birthday) values
('Emil','Abbasli','920','1988-11-11'),
('Orxan','Eliyev','912','1990-02-05');


insert into user_roles (user_id,role_id)
select 1,id from roles where lessor=1;

insert into user_roles (user_id,role_id)
select 2,id from roles where lessor=1;


insert into objects 
(name, description, price, address, room_count, area, floor, lessor_code, category_id) 
values
('Sea View Villa', 'Denizə baxışlı lüks villa', 230, 'Bakı, Nərimanov', 5, 250, 2, 1, 1),
('City Apartment', 'Şəhərin mərkəzində rahat mənzil', 120, 'Bakı, Yasamal', 3, 90, 5, 1, 2),
('Mountain House', 'Dağ mənzərəli ev', 150, 'Qəbələ, mərkəz', 4, 180, 1, 2, 1),
('Cozy Studio', 'Tək şəxslər üçün studio', 75, 'Sumqayıt, 9-cu mikrorayon', 1, 45, 7, 2, 2),
('Modern Cottage', 'Ailəvi istirahət üçün modern kottec', 180, 'Şamaxı', 3, 130, 1, 1, 1),
('Old Town Flat', 'Tarixi bölgədə kirayə mənzil', 110, 'İçərişəhər', 2, 70, 3, 1, 2);


insert into translates
( language,word,translate) values
('en','file','File'),
('en','edit','Edit'),

('az','file','Fayl'),
('az','edit','Redakte');



 

