
insert into authority_list
( authority,librarian,student) values
('ROLE_ADD_BOOK',1,0),
('ROLE_DELETE_BOOK',1,0),
('ROLE_GET_BOOK',1,0),
('ROLE_UPDATE_BOOK',1,0),
('ROLE_SEARCH_BOOK',1,0);
insert into users
(username,password,enabled,user_id,user_type) values
('l1','{noop}123',1,1,'librarian'),
('l2','{noop}1234',1,2,'librarian');

insert into librarians (name, surname, phone, birthday) 
VALUES ('l1', 'Lib1', '099', '2021-02-05'),
       ('l2', 'Lib2', '098', '2020-02-05');


insert into authorities (username,authority)
select 'l1',authority from authority_list where librarian=1;

insert into authorities (username,authority)
select 'l2',authority from authority_list where librarian=2;


INSERT INTO books
(name, description, price, author, color, page_count, quantity, weight, publish_date, librarian_code) 
VALUES
('Java 21', 'James yazdı 21', 60.5, 'Emin, Yusif', 'red', 300, 150, 3, '2020-10-10', 1),
('CSS3', 'James yazdı 21', 60.5, 'Emin, Yusif', 'red', 233, 150, 3, '2020-10-10', 1),
('HTML 5', 'James yazdı 21', 60.5, 'Emin, Yusif', 'red', 676, 150, 3, '2020-10-10', 2),
('Python', 'James yazdı 21', 60.5, 'Emin, Yusif', 'red', 676, 150, 3, '2020-10-10', 2),
('Docker', 'James yazdı 21', 60.5, 'Emin, Yusif', 'red', 676, 150, 3, '2020-10-10', 2),
('Kubernetes', 'James yazdı 21', 60.5, 'Emin, Yusif', 'red', 676, 150, 3, '2020-10-10', 2),
('Java 21', 'James yazdı 21', 23, 'Emin, Yusif', 'red', 300, 150, 3, '2020-10-10', 1),
('CSS3', 'James yazdı 21', 45, 'Emin, Yusif', 'red', 233, 150, 3, '2020-10-10', 1),
('HTML 5', 'James yazdı 21', 47, 'Emin, Yusif', 'red', 676, 150, 3, '2020-10-10', 1),
('Python', 'James yazdı 21', 57, 'Emin, Yusif', 'red', 676, 150, 3, '2020-10-10', 1),
('Docker', 'James yazdı 21', 88, 'Emin, Yusif', 'red', 676, 150, 3, '2020-10-10', 1),
('Kubernetes', 'James yazdı 21', 99, 'Emin, Yusif', 'red', 676, 150, 3, '2020-10-10', 1);



insert into authority_list
(authority, librarian, student) values
('ROLE_SEARCH_BOOK', 0, 1);


insert into users
(username, password, enabled, user_id, user_type) values
('s1', '{noop}pass1', 1, 3, 'student'),
('s2', '{noop}pass2', 1, 4, 'student');


insert into students (name, surname, phone, birthday) 
VALUES ('s1', 'Stud1', '077', '2003-05-12'),
       ('s2', 'Stud2', '076', '2002-08-19');


insert into authorities (username, authority)
select 's1', authority from authority_list where student=1;

insert into authorities (username, authority)
select 's2', authority from authority_list where student=2;
