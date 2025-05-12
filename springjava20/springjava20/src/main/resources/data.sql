INSERT INTO roles (name,seller,customer) VALUES 
( 'ROLE_ADD_BOOK',1,0),( 'ROLE_DELETE_BOOK',1,0),( 'ROLE_GET_BOOK',1,0),( 'ROLE_UPDATE_BOOK',1,0),( 'ROLE_SEARCH_BOOK',1,0);


insert into users
(username,password,enabled,user_id,user_type) values
('s1','$2a$12$AXXj9t.V73x5iCEmRD0X..AboDocEu7aK12Xaf1dbNmN137CvcDZG',1,1,'seller'),
('s2','$2a$12$AXXj9t.V73x5iCEmRD0X..AboDocEu7aK12Xaf1dbNmN137CvcDZG',1,2,'seller');

insert into sellers
(name,surname,phone,birthday) values
('Abbas','Abbaszade','099','2021-02-05'),
('Emin','Eliyev','098','2020-02-05');

insert into user_roles (user_id,role_id)
select 1,id from roles where seller=1;

insert into user_roles (user_id,role_id)
select 2,id from roles where seller=1;

 

insert into books
(name,description,price,author,color,page_count,quantity,weight,publish_date,seller_code,category_id) values
('Java 21','James yazdi 21','23','Emin, Yusif','red',300,150,3,'2020-10-10',1,1),
('Cssa3','James yazdi 21','45','Emin, Yusif','red',233,150,3,'2020-10-10',1,1),
('Html 5','James yazdi 21','47','Emin, Yusif','red',676,150,3,'2020-10-10',1,1),
('Pytahon','James yazdi 21','57','Emin, Yusif','red',676,150,3,'2020-10-10',2,1),
('Docaker','James yazdi 21','88','Emin, Yusif','red',676,150,3,'2020-10-10',1,1),
('Kubernetes','James yazdi 21','99','Emin, Yusif','red',676,150,3,'2020-10-10',2,1);

insert into translates
( language,word,translate) values
('en','file','File'),
('en','edit','Edit'),

('az','file','Fayl'),
('az','edit','Redakte');

drop table sellers_book_count;

create view sellers_book_count as
(select s.id,s.name,count(b.name) as count from sellers s inner join books b
on s.id=b.seller_code group by s.name)

 