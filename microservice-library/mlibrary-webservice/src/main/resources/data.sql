INSERT INTO accounts( id, user_type, account_owner_email, account_owner_firstname, account_owner_lastname, account_owner_pass, account_owner_phone_nb, active_account, registration_date, role, barcode, nb_of_currents_Loans) VALUES
( 1,'Member', 'mimi@gmail.com', 'mimi', 'mimi', 'mimi', '0388324567', 1, '2019/02/10', 'USER', 'LAUNMAR1-1', 2);
INSERT INTO accounts( id, user_type, account_owner_email, account_owner_firstname, account_owner_lastname, account_owner_pass, account_owner_phone_nb, active_account, registration_date, role, barcode, nb_of_currents_Loans) VALUES
( 2,'Member', 'sofie.a@gmail.com', 'Sophie', 'Sophie', 'sophie', '0388324567', 1, '2019/02/10', 'USER', 'RICHSOP1-2', 1);
INSERT INTO accounts( id, user_type, account_owner_email, account_owner_firstname, account_owner_lastname, account_owner_pass, account_owner_phone_nb, active_account, registration_date, role, barcode, nb_of_currents_Loans) VALUES
( 3,'Member', 'est@hotmail.fr', 'Fanny', 'Fanny', 'fanny', '0388324567', 1, '2019/02/10', 'USER', 'VELSEST2-2', 0);
INSERT INTO accounts( id, user_type, account_owner_email, account_owner_firstname, account_owner_lastname, account_owner_pass, account_owner_phone_nb, active_account, registration_date, role, barcode, nb_of_currents_Loans) VALUES
( 4,'Employee',  'lib@gmail.com','Esthel', 'Esthel', 'esthel', '0388324567', 1, '2019/02/10', 'LIBRARY',  NULL, 0);
INSERT INTO accounts( id, user_type, account_owner_email, account_owner_firstname, account_owner_lastname, account_owner_pass, account_owner_phone_nb, active_account, registration_date, role, barcode, nb_of_currents_Loans) VALUES
( 5,'Employee',  'admin@gmail.com','admin', 'admin', 'admin', '0388324567', 1, '2019/02/10', 'ADMIN',  NULL, 0);



INSERT INTO AUTHORS (id, alias, firstname, lastname) VALUES (1, NULL, 'Victor', 'Hugo');
INSERT INTO AUTHORS (id, alias, firstname, lastname) VALUES (2, NULL, 'Guy', 'De Maupassant');
INSERT INTO AUTHORS (id, alias, firstname, lastname) VALUES (3, NULL, 'Gustave', 'Flaubert');
INSERT INTO AUTHORS (id, alias, firstname, lastname) VALUES (4, 'Molière', 'Jean-Baptiste', 'oquelin');

INSERT INTO libraries (id, address, name) VALUES (1, '10 rue des écrivains', 'Le coin des lecteurs' );
INSERT INTO libraries (id, address, name) VALUES (2, '5 avenue de normandie', 'BMS' );
INSERT INTO libraries (id, address, name) VALUES (3, '2 rue Charles Péguy', 'Librairie Kleber');

INSERT INTO editors(id, name) VALUES (1, 'Ldp Jeunesse');
INSERT INTO editors(id, name) VALUES (2, 'Gallimard');
INSERT INTO editors(id, name) VALUES (3, 'Belin Éducation');
INSERT INTO editors(id, name) VALUES (4, 'Nathan');

INSERT INTO PUBLICATIONS(id, category, sub_category, identification_nb, nb_of_available_copies, nb_total_ofcopies, publication_date, title, author_fk, edithor_fk) VALUES
( 1, 'BOOK', 'NOVEL', '2010008995', 1, 3, '2014/01/01', 'Les misérables', 1, 1 );
INSERT INTO PUBLICATIONS(id, category, sub_category, identification_nb, nb_of_available_copies, nb_total_ofcopies, publication_date, title, author_fk, edithor_fk) VALUES
( 2, 'BOOK', 'POETRY', '2070321908', 2, 2, '2015/01/01', 'Odes et Ballades', 1, 2 );
INSERT INTO PUBLICATIONS(id, category, sub_category, identification_nb, nb_of_available_copies, nb_total_ofcopies, publication_date, title, author_fk, edithor_fk) VALUES
( 3, 'BOOK', 'NOVEL', '2701151589', 1, 2, '2019/01/01', 'Bel-Ami', 2, 3 );
INSERT INTO PUBLICATIONS(id, category, sub_category, identification_nb, nb_of_available_copies, nb_total_ofcopies, publication_date, title, author_fk, edithor_fk) VALUES
( 4, 'BOOK', 'THEATER',' 978-2-09-188737-1', 1, 3, '2018/01/01', 'Le médecin malgé lui', 4, 4);
INSERT INTO PUBLICATIONS(id, category, sub_category, identification_nb, nb_of_available_copies, nb_total_ofcopies, publication_date, title, author_fk, edithor_fk) VALUES
(5, 'REVIEW', 'SCIENTIST', 'dsfdgh', 1, 1, '2020/01/01','Geo', NULL, NULL);
INSERT INTO PUBLICATIONS(id, category, sub_category, identification_nb, nb_of_available_copies, nb_total_ofcopies, publication_date, title, author_fk, edithor_fk) VALUES
(6, 'REVIEW', 'SCIENTIST','ereterh', 1, 1, '2020/01/01','Geo', NULL, NULL);
INSERT INTO PUBLICATIONS(id, category, sub_category, identification_nb, nb_of_available_copies, nb_total_ofcopies, publication_date, title, author_fk, edithor_fk) VALUES
(7, 'REVIEW', 'NEWS', 'ereterh', 1, 1, '2020/01/01', 'L''Obs', NULL, NULL);
INSERT INTO PUBLICATIONS(id, category, sub_category, identification_nb, nb_of_available_copies, nb_total_ofcopies, publication_date, title, author_fk, edithor_fk) VALUES
(8, 'NEWSPAPER', 'NATIONAL', 'ereterh', 2, 3, '2020/01/01', 'Le Monde', NULL, NULL);
INSERT INTO PUBLICATIONS(id, category, sub_category, identification_nb, nb_of_available_copies, nb_total_ofcopies, publication_date, title, author_fk, edithor_fk) VALUES
(9, 'NEWSPAPER', 'NATIONAL', 'ereterh', 1, 1, '2020/01/01', 'Le Monde', NULL, NULL);
INSERT INTO PUBLICATIONS(id, category, sub_category, identification_nb, nb_of_available_copies, nb_total_ofcopies, publication_date, title, author_fk, edithor_fk) VALUES
(10, 'BOOK', 'NOVEL', '2010008995', 2, 2, '2014/01/01', 'Les misérables', 1, 3);
INSERT INTO PUBLICATIONS(id, category, sub_category, identification_nb, nb_of_available_copies, nb_total_ofcopies, publication_date, title, author_fk, edithor_fk) VALUES
(11, 'BOOK', 'NOVEL', 'DEWDEDF', 2, 4, '2014/01/01', 'Les misérables', 1, 4);


INSERT INTO copies(id, available, barcode, return_date, publication_fk, library_fk)
VALUES (1, 0, 'RVICTM-1-1', '2020/02/21', 1, 1);
INSERT INTO copies(id, available, barcode, return_date, publication_fk, library_fk)
VALUES (2, 0, 'RVICTM-1-2', '2020/02/21', 1, 1);
INSERT INTO copies(id, available, barcode, return_date, publication_fk, library_fk)
VALUES (3, 1, 'RVICTM-2-1', NULL, 1, 2);
INSERT INTO copies(id, available, barcode, return_date, publication_fk, library_fk)
VALUES (4, 1, 'PVICTO-2-1', NULL, 2, 2);
INSERT INTO copies(id, available, barcode, return_date, publication_fk, library_fk)
VALUES (5, 1, 'PVICTO-2-2', NULL, 2, 2);
INSERT INTO copies(id, available, barcode, return_date, publication_fk, library_fk)
VALUES (6, 0, 'RGUYDB-2-1', '2020/02/21', 3, 2);
INSERT INTO copies(id, available, barcode, return_date, publication_fk, library_fk)
VALUES (7, 0, 'RGUYDB-3-1', '2020/02/21', 3, 3);
INSERT INTO copies(id, available, barcode, return_date, publication_fk, library_fk)
VALUES (8, 0, 'TMOLIM-1-1', '2020/02/21', 4, 1);
INSERT INTO copies(id, available, barcode, return_date, publication_fk, library_fk)
VALUES (9, 0, 'TMOLIM-2-1', '2020/02/21', 4, 2);
INSERT INTO copies(id, available, barcode, return_date, publication_fk, library_fk)
VALUES (10, 1, 'TMOLIM-2-2', NULL, 4, 2);
INSERT INTO copies(id, available, barcode, return_date, publication_fk, library_fk)
VALUES (11, 1, 'TMOLIM-3-1', NULL, 4, 3);
INSERT INTO copies(id, available, barcode, return_date, publication_fk, library_fk)
VALUES (12, 0, 'GEO-01-20-2-1', '2020/02/21', 5, 2);
INSERT INTO copies(id, available, barcode, return_date, publication_fk, library_fk)
VALUES (13, 1, 'GEO-01-20-2-2', NULL, 5, 2);
INSERT INTO copies(id, available, barcode, return_date, publication_fk, library_fk)
VALUES (14,1, 'OBS-05-19-2-1', NULL, 6, 2);
INSERT INTO copies(id, available, barcode, return_date, publication_fk, library_fk)
VALUES (15, 0, 'MOND-01-20-1-1', '2020/02/21', 7, 2);
INSERT INTO copies(id, available, barcode, return_date, publication_fk, library_fk)
VALUES (16, 1, 'MOND-01-20-2-1', NULL, 7, 2);
INSERT INTO copies(id, available, barcode, return_date, publication_fk, library_fk)
VALUES (17, 1, 'MOND-01-20-2-2', NULL, 7, 2);
INSERT INTO copies(id, available, barcode, return_date, publication_fk, library_fk)
VALUES (18, 1, 'MOND-02-20-3-1', NULL, 8, 2);
INSERT INTO copies(id, available, barcode, return_date, publication_fk, library_fk)
VALUES (19, 0, 'MOND-02-20-3-2', '2020/02/21', 8, 1);
INSERT INTO copies(id, available, barcode, return_date, publication_fk, library_fk)
VALUES (20, 1, 'cop1', NULL, 3, 10);
INSERT INTO copies(id, available, barcode, return_date, publication_fk, library_fk)
VALUES (21, 1, 'cop2', NULL, 2, 10);
INSERT INTO copies(id, available, barcode, return_date, publication_fk, library_fk)
VALUES (22, 1, 'sdad', NULL, 2, 11);


INSERT INTO loans(id, loan_date, loan_status, extented, reminder_nb, return_date, copy_fk, member_fk)
VALUES (1, '15/02/20', 'FINISHED', 1, 0, '2020/04/15', 1, 1);
INSERT INTO loans(id, loan_date, loan_status, extented, reminder_nb, return_date, copy_fk, member_fk)
VALUES (2, '19/01/20', 'FINISHED', 1, 0, '2020/03/19', 2, 1);
INSERT INTO loans(id, loan_date, loan_status, extented, reminder_nb, return_date, copy_fk, member_fk)
VALUES (3, '2020/03/22', 'INPROGRESS', 0, 0, '2020/04/22', 6, 2);
INSERT INTO loans(id, loan_date, loan_status, extented, reminder_nb, return_date, copy_fk, member_fk)
VALUES (4, '2020/02/03', 'INPROGRESS', 1, 0, '2020/04/03', 3, 1);
INSERT INTO loans(id, loan_date, loan_status, extented, reminder_nb, return_date, copy_fk, member_fk)
VALUES (5, '2020/02/20', 'INPROGRESS', 1, 0, '2020/04/20', 2, 1);
INSERT INTO loans(id, loan_date, loan_status, extented, reminder_nb, return_date, copy_fk, member_fk)
VALUES (6, '2020/04/14', 'INPROGRESS', 0, 0, '2020/05/14',11, 1);




