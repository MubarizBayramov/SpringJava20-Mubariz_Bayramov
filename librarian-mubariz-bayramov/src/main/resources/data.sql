
insert into authority_list
( authority,librarian,student) values
('ROLE_ADD_BOOK',1,0),
('ROLE_DELETE_BOOK',1,0),
('ROLE_GET_BOOK',1,0),
('ROLE_UPDATE_BOOK',1,0) ;

insert into users
(username,password,enabled,user_id,user_type) values
('l1','{noop}1',1,1,'librarian'),
('l2','{noop}1',1,2,'librarian');

insert into librarians
(name,surname,phone,birthday) values
('l1','Lib1','099','2021-02-05'),
('l2','Lib2','098','2020-02-05');

insert into authorities (username,authority)
select 'l1',authority from authority_list where librarian=1;

insert into authorities (username,authority)
select 'l2',authority from authority_list where librarian=1;


insert into books
(name,description,price,author,color,page_count,quantity,weight,publish_date,librarian_code) values
('Java 21','James yazdi 21','60.5','Emin, Yusif','red',300,150,3,'2020-10-10',1),
('Css3','James yazdi 21','60.5','Emin, Yusif','red',233,150,3,'2020-10-10',1),
('Html 5','James yazdi 21','60.5','Emin, Yusif','red',676,150,3,'2020-10-10',2);