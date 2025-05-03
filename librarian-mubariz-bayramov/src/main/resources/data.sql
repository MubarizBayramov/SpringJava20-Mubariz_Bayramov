
insert into authority_list (authority, librarian, student) values
('ROLE_ADD_STUDENT', 1, 0),
('ROLE_DELETE_STUDENT', 1, 0),
('ROLE_UPDATE_STUDENT', 1, 0),
('ROLE_SEARCH_STUDENT', 1, 0),
('ROLE_ADD_BOOK',1,0),
('ROLE_DELETE_BOOK',1,0),
('ROLE_GET_BOOK',1,0),
('ROLE_UPDATE_BOOK',1,0),
('ROLE_SEARCH_BOOK',1,0);


insert into users
(username,password,enabled,user_id,user_type) values
('l1','{noop}123',1,1,'librarian'),
('l2','{noop}1234',1,2,'librarian'),
('s1', '{noop}pass1', 1, 1, 'student'),
('s2', '{noop}pass2', 1, 2, 'student');



insert into librarians (name, surname, phone, birthday) 
VALUES ('l1', 'Lib1', '099', '2021-02-05'),
       ('l2', 'Lib2', '098', '2020-02-05');

       
insert into students (name, surname, email, age, librarian_code) 
VALUES 
('s1', 'Stud1', 'email1@example.com', 20, 1), 
('s2', 'Stud2', 'email2@example.com', 24, 1),
('s3', 'Stud3', 'email3@example.com', 25, 1),
('s4', 'Stud4', 'email4@example.com', 22, 1),
('s5', 'Stud5', 'email5@example.com', 23, 1),
('s6', 'Stud6', 'email6@example.com', 21, 1);




INSERT INTO books
(name, description, price, author, color, page_count, quantity, weight, publish_date, librarian_code, category_id) 
VALUES
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


insert into authorities (username, authority)
select 'l1', authority from authority_list where librarian = 1;

insert into authorities (username, authority)
select 'l2', authority from authority_list where librarian = 1;

insert into authorities (username, authority)
select 's1', authority from authority_list where student = 1;

insert into authorities (username, authority)
select 's2', authority from authority_list where student = 1;

insert into authorities (username, authority) values 
('l1', 'ROLE_GIVE_BOOK'),
('l1', 'ROLE_RETURN_BOOK'),
('l1', 'ROLE_GET_GIVEN_BOOKS'),
('l1', 'ROLE_GET_RETURNED_BOOKS'),
('l1', 'ROLE_GET_DELAYED_BOOKS'),
('l2', 'ROLE_GIVE_BOOK'),
('l2', 'ROLE_RETURN_BOOK'),
('l2', 'ROLE_GET_GIVEN_BOOKS'),
('l2', 'ROLE_GET_RETURNED_BOOKS'),
('l2', 'ROLE_GET_DELAYED_BOOKS');



insert into translates
( language,word,translate) values
('en','file','File'),
('en','edit','Edit'),

('az','file','Fayl'),
('az','edit','Redakte'),

('tr','file','Fayl'),
('tr','Dosya','Düzenleme');



 Drop table librarians_book_count;
   Create view librarians_book_count as( 
    SELECT 
        l.name AS librarian_name,
        l.surname AS librarian_surname,
        COUNT(b.id) AS book_count
    FROM librarians l
    LEFT JOIN books b ON l.id = b.librarian_code
    GROUP BY l.id, l.name, l.surname )

    
    


    
    
    
    
    

