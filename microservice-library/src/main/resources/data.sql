INSERT INTO AUTHORS (id, name) VALUES (1, 'Victor Hugo');
INSERT INTO AUTHORS (id, name) VALUES (2, 'Guy De Maupassant');
INSERT INTO AUTHORS (id, name) VALUES (3, 'Gustave Flaubert');
INSERT INTO AUTHORS (id, name) VALUES (4, 'Le Médecin malgré lui, Molière by Jean-Baptiste Poquelin dit Molière');

INSERT INTO libraries (id, address, name) VALUES (1, '10 rue des écrivains', 'Le coin des lecteurs' );
INSERT INTO libraries (id, address, name) VALUES (2, '5 avenue de normandie', 'BMS' );
INSERT INTO libraries (id, address, name) VALUES (3, '2 rue Charles Péguy', 'Librairie Kleber');

INSERT INTO WORKS (work_type, id, nb_of_available_copies, nb_total_ofcopies, category, editor, isbn, publishing_date, title, name, release_date, author_fk ) VALUES ('Book', 1, 1, 1, 'NOVEL', 'Ldp Jeunesse', '2010008995', '2014', 'Les misérables', NULL, NULL, 1);
INSERT INTO WORKS (work_type, id, nb_of_available_copies, nb_total_ofcopies, category, editor, isbn, publishing_date, title, name, release_date, author_fk ) VALUES ('Book', 2, 1, 1, 'POETRY', 'Gallimard', '2070321908', '2015', 'Odes et Ballades', NULL, NULL, 1);
INSERT INTO WORKS (work_type, id, nb_of_available_copies, nb_total_ofcopies, category, editor, isbn, publishing_date, title, name, release_date, author_fk ) VALUES ('Book', 3, 1, 1, 'NOVEL', 'Belin Éducation', '2701151589', '2019', 'Bel-Ami', NULL, NULL, 2);
INSERT INTO WORKS (work_type, id, nb_of_available_copies, nb_total_ofcopies, category, editor, isbn, publishing_date, title, name, release_date, author_fk ) VALUES ('Book', 4, 1, 1, 'THEATER', 'Nathan', ' 978-2-09-188737-1', '2018', 'Le médecin malgé lui', NULL, NULL, 4);
INSERT INTO WORKS (work_type, id, nb_of_available_copies, nb_total_ofcopies, category, editor, isbn, publishing_date, title, name, release_date, author_fk ) VALUES ('Review', 5, 1, 1, NULL, NULL, NULL, NULL, NULL, 'Geo', '01/20', NULL);
INSERT INTO WORKS (work_type, id, nb_of_available_copies, nb_total_ofcopies, category, editor, isbn, publishing_date, title, name, release_date, author_fk ) VALUES ('Review', 6, 1, 1, NULL, NULL, NULL, NULL, NULL, 'L\'Obs', '05/19', NULL);
INSERT INTO WORKS (work_type, id, nb_of_available_copies, nb_total_ofcopies, category, editor, isbn, publishing_date, title, name, release_date, author_fk ) VALUES ('Newspaper', 7, 1, 1, NULL, NULL, NULL, NULL, NULL, 'Le Monde', '01/20', NULL);
INSERT INTO WORKS (work_type, id, nb_of_available_copies, nb_total_ofcopies, category, editor, isbn, publishing_date, title, name, release_date, author_fk ) VALUES ('Newspaper', 8, 1, 1, NULL, NULL, NULL, NULL, NULL, 'Le Monde', '02/20', NULL);


INSERT INTO COPIES (id, available, barcode, return_date, library_id, work_id) VALUES (1, 0, 'RVICTM-1-1', '12/02/20', 1, 1);
INSERT INTO COPIES (id, available, barcode, return_date, library_id, work_id) VALUES (2, 0, 'RVICTM-1-2', '12/02/20', 1, 1);
INSERT INTO COPIES (id, available, barcode, return_date, library_id, work_id) VALUES (3, 1, 'RVICTM-2-1', NULL, 2, 1);

INSERT INTO COPIES (id, available, barcode, return_date, library_id, work_id) VALUES (4, 1, 'PVICTO-2-1', NULL, 2, 2);
INSERT INTO COPIES (id, available, barcode, return_date, library_id, work_id) VALUES (5, 1, 'PVICTO-2-2', NULL, 2, 2);

INSERT INTO COPIES (id, available, barcode, return_date, library_id, work_id) VALUES (6, 0, 'RGUYDB-2-1', '12/02/20', 2, 3);
INSERT INTO COPIES (id, available, barcode, return_date, library_id, work_id) VALUES (7, 0, 'RGUYDB-3-1', '12/02/20', 3, 3);

INSERT INTO COPIES (id, available, barcode, return_date, library_id, work_id) VALUES (8, 0, 'TMOLIM-1-1', '12/02/20', 1, 4);
INSERT INTO COPIES (id, available, barcode, return_date, library_id, work_id) VALUES (9, 0, 'TMOLIM-2-1', '12/02/20', 2, 4);
INSERT INTO COPIES (id, available, barcode, return_date, library_id, work_id) VALUES (10, 1, 'TMOLIM-2-2', NULL, 2, 4);
INSERT INTO COPIES (id, available, barcode, return_date, library_id, work_id) VALUES (11, 1, 'TMOLIM-3-1', NULL, 3, 4);

INSERT INTO COPIES (id, available, barcode, return_date, library_id, work_id) VALUES (12, 0, 'GEO-01-20-2-1', '12/02/20', 2, 5);
INSERT INTO COPIES (id, available, barcode, return_date, library_id, work_id) VALUES (13, 1, 'GEO-01-20-2-2', NULL, 2, 5);

INSERT INTO COPIES (id, available, barcode, return_date, library_id, work_id) VALUES (14, 1, 'OBS-05-19-2-1', NULL, 2, 6);

INSERT INTO COPIES (id, available, barcode, return_date, library_id, work_id) VALUES (15, 0, 'MOND-01-20-2-1', '12/02/20', 2, 7);
INSERT INTO COPIES (id, available, barcode, return_date, library_id, work_id) VALUES (16, 1, 'MOND-01-20-2-2', NULL, 2, 7);
INSERT INTO COPIES (id, available, barcode, return_date, library_id, work_id) VALUES (17, 1, 'MOND-01-20-2-3', NULL, 2, 7);

INSERT INTO COPIES (id, available, barcode, return_date, library_id, work_id) VALUES (18, 0, 'MOND-02-20-2-1', '12/02/20', 2, 8);
INSERT INTO COPIES (id, available, barcode, return_date, library_id, work_id) VALUES (19, 1, 'MOND-02-20-1-1', NULL, 1, 8);
INSERT INTO COPIES (id, available, barcode, return_date, library_id, work_id) VALUES (20, 1, 'MOND-02-20-1-3', NULL, 3, 8);
