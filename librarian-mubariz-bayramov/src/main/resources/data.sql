insert into roles (name, librarian, student) values
('ROLE_ADD_STUDENT', 1, 0),
('ROLE_DELETE_STUDENT', 1, 0),
('ROLE_UPDATE_STUDENT', 1, 0),
('ROLE_SEARCH_STUDENT', 1, 0),
('ROLE_ADD_BOOK', 1, 0),
('ROLE_DELETE_BOOK', 1, 0),
('ROLE_GET_BOOK', 1, 0),
('ROLE_UPDATE_BOOK', 1, 0),
('ROLE_SEARCH_BOOK', 1, 0),
('ROLE_GIVE_BOOK', 1, 0),
('ROLE_RETURN_BOOK', 1, 0),
('ROLE_GET_GIVEN_BOOKS', 1, 0),
('ROLE_GET_RETURNED_BOOKS', 1, 0),
('ROLE_GET_DELAYED_BOOKS', 1, 0);


insert into users (username, password, enabled, user_id, user_type) values
('l1', '{noop}123', 1, 1, 'librarian'),
('l2', '{noop}1234', 1, 2, 'librarian'),
('s1', '{noop}pass1', 1, 1, 'student'),
('s2', '{noop}pass2', 1, 2, 'student');


insert into librarians (name, surname, phone, birthday) values
('l1', 'Lib1', '099', '2021-02-05'),
('l2', 'Lib2', '098', '2020-02-05');


insert into students (name, surname, email, age, librarian_code) values
('s1', 'Stud1', 'email1@example.com', 20, 1),
('s2', 'Stud2', 'email2@example.com', 24, 1),
('s3', 'Stud3', 'email3@example.com', 25, 1),
('s4', 'Stud4', 'email4@example.com', 22, 1),
('s5', 'Stud5', 'email5@example.com', 23, 1),
('s6', 'Stud6', 'email6@example.com', 21, 1);


insert into user_roles (user_id, role_id)
select 1, id from roles where librarian = 1;

insert into user_roles (user_id, role_id)
select 2, id from roles where librarian = 1;

insert into user_roles (user_id, role_id)
select 3, id from roles where student = 1;

insert into user_roles (user_id, role_id)
select 4, id from roles where student = 1;


insert into books (name, description, price, author, color, page_count, quantity, weight, publish_date, librarian_code, category_id) values
('Java 21', 'James yazdı 21', 60.5, 'Emin, Yusif', 'red', 300, 150, 3, '2020-10-10', 1, 1),
('CSS3', 'James yazdı 21', 60.5, 'Emin, Yusif', 'red', 233, 150, 3, '2020-10-10', 1, 1),
('HTML 5', 'James yazdı 21', 60.5, 'Emin, Yusif', 'red', 676, 150, 3, '2020-10-10', 2, 1),
('Python', 'James yazdı 21', 60.5, 'Emin, Yusif', 'red', 676, 150, 3, '2020-10-10', 2, 1),
('Docker', 'James yazdı 21', 60.5, 'Emin, Yusif', 'red', 676, 150, 3, '2020-10-10', 2, 1),
('Kubernetes', 'James yazdı 21', 60.5, 'Emin, Yusif', 'red', 676, 150, 3, '2020-10-10', 2, 1),
('Java 21', 'James yazdı 21', 23, 'Emin, Yusif', 'red', 300, 150, 3, '2020-10-10', 1, 1),
('CSS3', 'James yazdı 21', 45, 'Emin, Yusif', 'red', 233, 150, 3, '2020-10-10', 1, 1),
('HTML 5', 'James yazdı 21', 47, 'Emin, Yusif', 'red', 676, 150, 3, '2020-10-10', 1, 1),
('Python', 'James yazdı 21', 57, 'Emin, Yusif', 'red', 676, 150, 3, '2020-10-10', 1, 1),
('Docker', 'James yazdı 21', 88, 'Emin, Yusif', 'red', 676, 150, 3, '2020-10-10', 1, 1),
('Kubernetes', 'James yazdı 21', 99, 'Emin, Yusif', 'red', 676, 150, 3, '2020-10-10', 1, 1);


insert into translates (language, word, translate) values
('en','file','File'),
('en','edit','Edit'),
('az','file','Fayl'),
('az','edit','Redakte'),
('tr','file','Fayl'),
('tr','Dosya','Düzenleme');


drop table if exists librarians_book_count;
create view librarians_book_count as
select
    l.name as librarian_name,
    l.surname as librarian_surname,
    count(b.id) as book_count
from librarians l
left join books b on l.id = b.librarian_code
group by l.id, l.name, l.surname;
