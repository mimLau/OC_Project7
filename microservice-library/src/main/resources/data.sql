INSERT INTO members(id, account_owner_email, account_owner_firstname, account_owner_lastname, account_owner_pass, account_owner_phone_nb, active_account, registration_date, barcode, nb_of_currents_borrowings )   VALUES
( 1, 'lam99@hotmail.fr', 'Maryam', 'Launois', 'maryam', '0388324567', 1, '2019/02/10', 'LAUNMAR1-1', 2);
INSERT INTO members( id, account_owner_email, account_owner_firstname, account_owner_lastname, account_owner_pass, account_owner_phone_nb, active_account, registration_date, barcode, nb_of_currents_borrowings ) VALUES
( 2, 'sofie.a@gmail.com', 'Sophie', 'Richt', 'sophie', '0388324567', 1, '2019/02/10', 'RICHSOP1-2', 1);
INSERT INTO members( id, account_owner_email, account_owner_firstname, account_owner_lastname, account_owner_pass, account_owner_phone_nb, active_account, registration_date, barcode, nb_of_currents_borrowings ) VALUES
( 3, 'est@hotmail.fr', 'Estelle', 'Velsin', 'estelle', '0388324567', 1, '2019/02/10', 'VELSEST2-2', 0);
INSERT INTO members( id, account_owner_email, account_owner_firstname, account_owner_lastname, account_owner_pass, account_owner_phone_nb, active_account, registration_date, barcode, nb_of_currents_borrowings ) VALUES
( 4, 'admin@gmail.com','Safia', 'Chouaib', 'safia', '0388324567', 1, '2019/02/10',  'CHOUSAF3-1', 0);


INSERT INTO AUTHORS (id, alias, firstname, lastname) VALUES (1, NULL, 'Victor', 'Hugo');
INSERT INTO AUTHORS (id, alias, firstname, lastname) VALUES (2, NULL, 'Guy', 'De Maupassant');
INSERT INTO AUTHORS (id, alias, firstname, lastname) VALUES (3, NULL, 'Gustave', 'Flaubert');
INSERT INTO AUTHORS (id, alias, firstname, lastname) VALUES (4, 'Molière', 'Jean-Baptiste', 'oquelin');

INSERT INTO libraries (id, address, name) VALUES (1, '10 rue des écrivains', 'Le coin des lecteurs' );
INSERT INTO libraries (id, address, name) VALUES (2, '5 avenue de normandie', 'BMS' );
INSERT INTO libraries (id, address, name) VALUES (3, '2 rue Charles Péguy', 'Librairie Kleber');

INSERT INTO books ( id, nb_of_available_copies, nb_total_ofcopies, category, editor, isbn, publishing_date, title, author_fk ) Values
( 1, 1, 1, 'NOVEL', 'Ldp Jeunesse', '2010008995', '2014', 'Les misérables', 1 );
INSERT INTO books ( id, nb_of_available_copies, nb_total_ofcopies, category, editor, isbn, publishing_date, title, author_fk ) Values
( 2, 1, 1, 'POETRY', 'Gallimard', '2070321908', '2015', 'Odes et Ballades', 1 );
INSERT INTO books ( id, nb_of_available_copies, nb_total_ofcopies, category, editor, isbn, publishing_date, title, author_fk ) Values
( 3, 1, 1, 'NOVEL', 'Belin Éducation', '2701151589', '2019', 'Bel-Ami', 2 );
INSERT INTO books ( id, nb_of_available_copies, nb_total_ofcopies, category, editor, isbn, publishing_date, title, author_fk ) Values
( 4, 1, 1, 'THEATER', 'Nathan', ' 978-2-09-188737-1', '2018', 'Le médecin malgé lui', 4);


INSERT INTO REVIEWS(id, nb_of_available_copies, nb_total_ofcopies, name, release_date ) VALUES
(1, 1, 1,'Geo', '01/20' );
INSERT INTO REVIEWS(id, nb_of_available_copies, nb_total_ofcopies, name, release_date ) VALUES
(2, 1, 1,'Geo', '01/20' );
INSERT INTO REVIEWS(id, nb_of_available_copies, nb_total_ofcopies, name, release_date ) VALUES
(3, 1, 1,'L\'Obs', '01/20' );

INSERT INTO news_papers(id, nb_of_available_copies, nb_total_ofcopies, name, release_date ) VALUES
(1, 2, 3,'Le Monde', '01/20' );
INSERT INTO news_papers(id, nb_of_available_copies, nb_total_ofcopies, name, release_date ) VALUES
(2, 1, 1,'Le Monde', '02/20' );



INSERT INTO copies(id, available, barcode, return_date, book_id, library_id, newspaper_id, review_id)
VALUES (1, 0, 'RVICTM-1-1', '2020/02/21', 1, 1, NULL, NULL );
INSERT INTO copies(id, available, barcode, return_date, book_id, library_id, newspaper_id, review_id)
VALUES (2, 0, 'RVICTM-1-2', '2020/02/21', 1, 1, NULL, NULL);
INSERT INTO copies(id, available, barcode, return_date, book_id, library_id, newspaper_id, review_id)
VALUES (3, 1, 'RVICTM-2-1', NULL, 1, 2, NULL, NULL);
INSERT INTO copies(id, available, barcode, return_date, book_id, library_id, newspaper_id, review_id)
VALUES (4, 1, 'PVICTO-2-1', NULL, 2, 2, NULL, NULL );
INSERT INTO copies(id, available, barcode, return_date, book_id, library_id, newspaper_id, review_id)
VALUES (5, 1, 'PVICTO-2-2', NULL, 2, 2, NULL, NULL );
INSERT INTO copies(id, available, barcode, return_date, book_id, library_id, newspaper_id, review_id)
VALUES (6, 0, 'RGUYDB-2-1', '2020/02/21', 3, 2, NULL, NULL );
INSERT INTO copies(id, available, barcode, return_date, book_id, library_id, newspaper_id, review_id)
VALUES (7, 0, 'RGUYDB-3-1', '2020/02/21', 3, 3, NULL, NULL );
INSERT INTO copies(id, available, barcode, return_date, book_id, library_id, newspaper_id, review_id)
VALUES (8, 0, 'TMOLIM-1-1', '2020/02/21', 4, 1, NULL, NULL );
INSERT INTO copies(id, available, barcode, return_date, book_id, library_id, newspaper_id, review_id)
VALUES (9, 0, 'TMOLIM-2-1', '2020/02/21', 4, 2, NULL, NULL );
INSERT INTO copies(id, available, barcode, return_date, book_id, library_id, newspaper_id, review_id)
VALUES (10, 1, 'TMOLIM-2-2', NULL, 4, 4, NULL, NULL );
INSERT INTO copies(id, available, barcode, return_date, book_id, library_id, newspaper_id, review_id)
VALUES (11, 1, 'TMOLIM-3-1', NULL, 4, 3, NULL, NULL );
INSERT INTO copies(id, available, barcode, return_date, book_id, library_id, newspaper_id, review_id)
VALUES (12, 0, 'GEO-01-20-2-1', '2020/02/21', NULL, 2, NULL, 1);
INSERT INTO copies(id, available, barcode, return_date, book_id, library_id, newspaper_id, review_id)
VALUES (13, 1, 'GEO-01-20-2-2', NULL, NULL, 2, NULL, 2);
INSERT INTO copies(id, available, barcode, return_date, book_id, library_id, newspaper_id, review_id)
VALUES (14,1, 'OBS-05-19-2-1', NULL, NULL, 2, NULL, 3);
INSERT INTO copies(id, available, barcode, return_date, book_id, library_id, newspaper_id, review_id)
VALUES (15, 0, 'MOND-01-20-1-1', '2020/02/21', NULL, 1, 1, NULL );
INSERT INTO copies(id, available, barcode, return_date, book_id, library_id, newspaper_id, review_id)
VALUES ( 16, 1, 'MOND-01-20-2-1', NULL, NULL, 2, 1, NULL );
INSERT INTO copies(id, available, barcode, return_date, book_id, library_id, newspaper_id, review_id)
VALUES ( 17, 1, 'MOND-01-20-2-2', NULL, NULL, 2, 1, NULL );
INSERT INTO copies(id, available, barcode, return_date, book_id, library_id, newspaper_id, review_id)
VALUES ( 18, 1, 'MOND-02-20-3-1', NULL, NULL, 3, 2, NULL );
INSERT INTO copies(id, available, barcode, return_date, book_id, library_id, newspaper_id, review_id)
VALUES ( 19, 0, 'MOND-02-20-3-2', '2020/02/21', NULL, 3, 2, NULL );



INSERT INTO borrowings(id, borrowing_date, borrowing_status, extented, reminder_nb, return_date, copy_id, member_id)
VALUES (1, '10/02/20', 'INPROGRESS', 0, 0, '2020/02/21', 1, 1);

INSERT INTO borrowings(id, borrowing_date, borrowing_status, extented, reminder_nb, return_date, copy_id, member_id)
VALUES (2, '10/02/20', 'INPROGRESS', 0, 0, '2020/02/21', 2, 1);

INSERT INTO borrowings(id, borrowing_date, borrowing_status, extented, reminder_nb, return_date, copy_id, member_id)
VALUES (3, '10/02/20', 'INPROGRESS', 0, 0, '2020/02/21', 6, 2);