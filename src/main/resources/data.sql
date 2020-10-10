insert into role (name) values ('ROLE_ADMIN');
insert into role (name) values ('ROLE_PROFESOR');
insert into role (name) values ('ROLE_STUDENT');

insert into permission (name) values ('create_ispit'); --a
insert into permission (name) values ('update_ispit'); --a
insert into permission (name) values ('delete_ispit'); --a
insert into permission (name) values ('read_ispit'); --a p
insert into permission (name) values ('read_all_predmets'); --a
insert into permission (name) values ('create_predmet'); --a
insert into permission (name) values ('update_predmet'); --a
insert into permission (name) values ('delete_predmet'); --a
insert into permission (name) values ('read_predmet_not_beloning_to_smer'); --a
insert into permission (name) values ('read_all_profesors'); --a

insert into permission (name) values ('read_profesor'); --a p
insert into permission (name) values ('create_profesor'); --a
insert into permission (name) values ('delete_profesor'); --a
insert into permission (name) values ('update_profesor'); --a
insert into permission (name) values ('read_all_smers'); --a
insert into permission (name) values ('create_smer'); --a
insert into permission (name) values ('delete_smer'); --a
insert into permission (name) values ('update_smer'); --a
insert into permission (name) values ('read_smer'); --a p
insert into permission (name) values ('read_smers_predmets'); --a p

insert into permission (name) values ('create_smerPredmet'); --a
insert into permission (name) values ('read_smerPredmet');--a
insert into permission (name) values ('read_smerPredmets_profesors'); --a
insert into permission (name) values ('update_smerPredmets'); --a
insert into permission (name) values ('delete_smerPredmets'); --a
insert into permission (name) values ('read_all_students'); --a
insert into permission (name) values ('read_student'); --a s
insert into permission (name) values ('create_student'); --a
insert into permission (name) values ('update_student'); --a
insert into permission (name) values ('read_user_info'); --a p s

insert into permission (name) values ('update_password'); --a p s
insert into permission (name) values ('read_students_of_ispit'); --p
insert into permission (name) values ('read_ispit');--p
insert into permission (name) values ('download_students_of_ispit');--p
insert into permission (name) values ('upload_results');--p
insert into permission (name) values ('update_results');--p
insert into permission (name) values ('read_profesors_ispits');--p
insert into permission (name) values ('read_profesors_finished_ispits');--p
insert into permission (name) values ('read_profesors_predmets');--p
insert into permission (name) values ('read_smers_current_ispits'); --p s

insert into permission (name) values ('read_smerPredmets_student_dolasci');--p
insert into permission (name) values ('download_smerPredmets_student_dolasci');--p
insert into permission (name) values ('update_smerPredmets_student_dolasci');--p
insert into permission (name) values ('upload_smerPredmets_student_dolasci');--p
insert into permission (name) values ('read_students_current_ispits');--s
insert into permission (name) values ('read_students_added_ispits');--s
insert into permission (name) values ('update_students_ispits');--s
insert into permission (name) values ('check_student_smester');--s
insert into permission (name) values ('update_student_smester');--s
insert into permission (name) values ('read_ocena');--s
insert into permission (name) values ('read_smerPredmets_ispits');--a p s

insert into role_permissions (role_id, permission_id) values (1, 1);
insert into role_permissions (role_id, permission_id) values (1, 2);
insert into role_permissions (role_id, permission_id) values (1, 3);
insert into role_permissions (role_id, permission_id) values (1, 4);
insert into role_permissions (role_id, permission_id) values (2, 4);
insert into role_permissions (role_id, permission_id) values (1, 5);
insert into role_permissions (role_id, permission_id) values (1, 6);
insert into role_permissions (role_id, permission_id) values (1, 7);
insert into role_permissions (role_id, permission_id) values (1, 8);
insert into role_permissions (role_id, permission_id) values (1, 9);
insert into role_permissions (role_id, permission_id) values (1, 10);

insert into role_permissions (role_id, permission_id) values (1, 11);
insert into role_permissions (role_id, permission_id) values (2, 11);
insert into role_permissions (role_id, permission_id) values (1, 12);
insert into role_permissions (role_id, permission_id) values (1, 13);
insert into role_permissions (role_id, permission_id) values (1, 14);
insert into role_permissions (role_id, permission_id) values (1, 15);
insert into role_permissions (role_id, permission_id) values (1, 16);
insert into role_permissions (role_id, permission_id) values (1, 17);
insert into role_permissions (role_id, permission_id) values (1, 18);
insert into role_permissions (role_id, permission_id) values (1, 19);
insert into role_permissions (role_id, permission_id) values (2, 19);
insert into role_permissions (role_id, permission_id) values (1, 20);
insert into role_permissions (role_id, permission_id) values (2, 20);

insert into role_permissions (role_id, permission_id) values (1, 21);
insert into role_permissions (role_id, permission_id) values (1, 22);
insert into role_permissions (role_id, permission_id) values (1, 23);
insert into role_permissions (role_id, permission_id) values (1, 24);
insert into role_permissions (role_id, permission_id) values (1, 25);
insert into role_permissions (role_id, permission_id) values (1, 26);
insert into role_permissions (role_id, permission_id) values (1, 27);
insert into role_permissions (role_id, permission_id) values (3, 27);
insert into role_permissions (role_id, permission_id) values (1, 28);
insert into role_permissions (role_id, permission_id) values (1, 29);
insert into role_permissions (role_id, permission_id) values (1, 30);
insert into role_permissions (role_id, permission_id) values (2, 30);
insert into role_permissions (role_id, permission_id) values (3, 30);

insert into role_permissions (role_id, permission_id) values (1, 31);
insert into role_permissions (role_id, permission_id) values (2, 31);
insert into role_permissions (role_id, permission_id) values (3, 31);
insert into role_permissions (role_id, permission_id) values (2, 32);
insert into role_permissions (role_id, permission_id) values (2, 33);
insert into role_permissions (role_id, permission_id) values (2, 34);
insert into role_permissions (role_id, permission_id) values (2, 35);
insert into role_permissions (role_id, permission_id) values (2, 36);
insert into role_permissions (role_id, permission_id) values (2, 37);
insert into role_permissions (role_id, permission_id) values (2, 38);
insert into role_permissions (role_id, permission_id) values (2, 39);
insert into role_permissions (role_id, permission_id) values (2, 40);
insert into role_permissions (role_id, permission_id) values (3, 40);


insert into role_permissions (role_id, permission_id) values (2, 41);
insert into role_permissions (role_id, permission_id) values (2, 42);
insert into role_permissions (role_id, permission_id) values (2, 43);
insert into role_permissions (role_id, permission_id) values (2, 44);
insert into role_permissions (role_id, permission_id) values (3, 45);
insert into role_permissions (role_id, permission_id) values (3, 46);
insert into role_permissions (role_id, permission_id) values (3, 47);
insert into role_permissions (role_id, permission_id) values (3, 48);
insert into role_permissions (role_id, permission_id) values (3, 49);
insert into role_permissions (role_id, permission_id) values (3, 50);

insert into role_permissions (role_id, permission_id) values (1, 51);
insert into role_permissions (role_id, permission_id) values (2, 51);
insert into role_permissions (role_id, permission_id) values (3, 51);

--ADMINISTRATOR
insert into user (name, surname, email, password, enabled, type, role ) values ('Admin', 'Admin', 'admin@uns.ac.rs', '$2a$10$aMBAEXjwqcavdNT373EM7.hlk2MWp1SNYCZ5NWk/Dytyf/xPsI02a', true, 'ADMIN', 'ROLE_ADMIN');
------
--PROFESORI
insert into user (name, surname, email, password, enabled, type, role,sifra_profesora) values ('Milan', 'Vidakovic', 'milan.vidakovic@uns.ac.rs', '$2a$10$7YXN6idLLmf5Gy2K5guobOghxYVQBcc9a04fFmRd82ns12klLCmr.', true, 'PROFESOR', 'ROLE_PROFESOR','PROF1');
insert into user (name, surname, email, password, enabled, type, role,sifra_profesora) values ('Ivan', 'Lukovic', 'ivan.lukovic@uns.ac.rs', '$2a$10$7YXN6idLLmf5Gy2K5guobOghxYVQBcc9a04fFmRd82ns12klLCmr.', true, 'PROFESOR', 'ROLE_PROFESOR','PROF2');
insert into user (name, surname, email, password, enabled, type, role,sifra_profesora) values ('Branko', 'Milosavljevic ', 'branko.mil@uns.ac.rs', '$2a$10$7YXN6idLLmf5Gy2K5guobOghxYVQBcc9a04fFmRd82ns12klLCmr.', true, 'PROFESOR', 'ROLE_PROFESOR','PROF3');

----
insert into user_roles (user_id, role_id) values (1, 1);
insert into user_roles (user_id, role_id) values (2, 2);
insert into user_roles (user_id, role_id) values (3, 2);
insert into user_roles (user_id, role_id) values (4, 2);

insert into smer (naziv, skracenica, trajanjeusemestrima, obrazovno_polje, naziv_diplome) values ('Racunarstvo i automatika', 'RA', 8, 0,'Diplomiranji Inzenjer Elektrotehnike i Racunarstva');

--PREDMETI-----------------------------------------
insert into predmet(naziv, kategorija) value ('Matematicka analiza 1',0);
insert into predmet(naziv, kategorija) value ('Algebra',0);
insert into predmet(naziv, kategorija) value ('Engleski jezik-osnovni',0);
insert into predmet(naziv, kategorija) value ('Programski jezici i strukture podataka',1);

insert into predmet(naziv, kategorija) value ('Fizika',0);
insert into predmet(naziv, kategorija) value ('Osnovi elektrotehnike',2);
insert into predmet(naziv, kategorija) value ('Arhitektura racunara',1);
insert into predmet(naziv, kategorija) value ('Engleski jezik-srednji',0);

insert into predmet(naziv, kategorija) value ('Modeliranje i simulacija sistema',1);
insert into predmet(naziv, kategorija) value ('Logicko projektovanje racunarskih sistema 1',1);
insert into predmet(naziv, kategorija) value ('Matematicka analiza 2',0);
insert into predmet(naziv, kategorija) value ('Objektno programiranje',1);

insert into predmet(naziv, kategorija) value ('Operativni sistemi',1);
insert into predmet(naziv, kategorija) value ('Socioloski aspekti tehnickog razvoja',0);
insert into predmet(naziv, kategorija) value ('Sistemi automatskog upravljanja',3);
insert into predmet(naziv, kategorija) value ('Sistemska programska podrska u realnom vremenu',3);
insert into predmet(naziv, kategorija) value ('Verovatnoca i slucajni procesi',3);

insert into predmet(naziv, kategorija) value ('Metode optimizacije',2);
insert into predmet(naziv, kategorija) value ('Baze podataka 1',3);
insert into predmet(naziv, kategorija) value ('Osnovi informacionih sistema i softverskog inzenjerstva',3);
insert into predmet(naziv, kategorija) value ('Numerički algoritmi i numerički softver',2);
insert into predmet(naziv, kategorija) value ('Programski prevodioci',2);

insert into predmet(naziv, kategorija) value ('Osnovi računarske inteligencije',3);
insert into predmet(naziv, kategorija) value ('Veb programiranje',3);
insert into predmet(naziv, kategorija) value ('Interakcija čovek računar',2);
insert into predmet(naziv, kategorija) value ('Internet mreže',2);
insert into predmet(naziv, kategorija) value ('Specifikacija i modeliranje softvera',2);

insert into predmet(naziv, kategorija) value ('Projektovanje softvera',2);
insert into predmet(naziv, kategorija) value ('Soft kompjuting',3);
insert into predmet(naziv, kategorija) value ('Računarska grafika',2);
insert into predmet(naziv, kategorija) value ('Baze podataka 2',2);
insert into predmet(naziv, kategorija) value ('Internet softverske arhitekture',2);
insert into predmet(naziv, kategorija) value ('Stručna praksa- projekat',3);

insert into predmet(naziv, kategorija) value ('XML i veb servisi',1);
insert into predmet(naziv, kategorija) value ('Poslovna informatika',1);
insert into predmet(naziv, kategorija) value ('Bezbednost u sistemima elektronskog poslovanja',1);
insert into predmet(naziv, kategorija) value ('Zavrsni - diplomski rad',3);

----------------------------------------------------


--STUDIJSKI PROGRAMI NA RACUNARSTVU I AUTOMATICI----
--1 SEMESTAR
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, smer_id) values ('E212',24,9,1,1,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, smer_id) values ('E213A',24,9,1,2,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, smer_id) values ('E214',24,9,1,3,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, smer_id) values ('EJ1Z',12,3,1,4,1);

--2 SEMESTAR
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, smer_id) values ('E215',24,9,2,5,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, smer_id) values ('E216',24,9,2,6,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, smer_id) values ('E217',24,9,2,7,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, smer_id) values ('EJ2Z',12,3,2,8,1);

--3 SEMESTAR
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, smer_id) values ('E232',24,8,3,9,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, smer_id) values ('E227A',24,6,3,10,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, smer_id) values ('E221A',24,8,3,11,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, smer_id) values ('E223A',12,8,3,12,1);

--4 SEMESTAR
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, smer_id) values ('E225',24,8,4,13,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, smer_id) values ('E251A',24,3,4,14,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, smer_id) values ('E226',24,8,4,15,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, smer_id) values ('E23A2',12,6,4,16,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, smer_id) values ('E224A',12,5,4,17,1);

--5 SEMESTAR
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, smer_id) values ('E237',24,8,5,18,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, smer_id) values ('RI43A',24,8,5,19,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, smer_id) values ('E235',24,8,5,20,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, smer_id) values ('E231',12,4,5,21,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, smer_id) values ('E234',12,4,5,22,1);

--6 SEMESTAR
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, smer_id) values ('E236A',24,8,6,23,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, smer_id) values ('E239A',24,6,6,24,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, smer_id) values ('E243',24,4,6,25,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, smer_id) values ('E233',12,4,6,26,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, smer_id) values ('E242',12,4,6,27,1);

--7 SEMESTAR
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, smer_id) values ('RI45',24,7,7,28,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, smer_id) values ('E2K40A',24,7,7,29,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, smer_id) values ('RI4A',24,6,7,30,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, smer_id) values ('RI43B',12,6,7,31,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, smer_id) values ('RI41',12,4,7,32,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, smer_id) values ('E23SP',12,3,7,33,1);

--8 SEMESTAR
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, smer_id) values ('E2E40',24,7,8,34,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, smer_id) values ('RI53',24,5,8,35,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, smer_id) values ('E2E41',24,8,4,36,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, smer_id) values ('E24BR',12,13,8,37,1);

----------------------------------------------------
insert into profesor_smerpredmet(profesor_id, smer_predmet_id) values (2,1);
insert into profesor_smerpredmet(profesor_id, smer_predmet_id) values (3,2);
insert into profesor_smerpredmet(profesor_id, smer_predmet_id) values (4,3);
insert into profesor_smerpredmet(profesor_id, smer_predmet_id) values (2,4);
insert into profesor_smerpredmet(profesor_id, smer_predmet_id) values (3,5);
insert into profesor_smerpredmet(profesor_id, smer_predmet_id) values (4,6);
insert into profesor_smerpredmet(profesor_id, smer_predmet_id) values (2,7);
insert into profesor_smerpredmet(profesor_id, smer_predmet_id) values (3,8);
insert into profesor_smerpredmet(profesor_id, smer_predmet_id) values (4,9);
insert into profesor_smerpredmet(profesor_id, smer_predmet_id) values (2,10);
insert into profesor_smerpredmet(profesor_id, smer_predmet_id) values (3,11);
insert into profesor_smerpredmet(profesor_id, smer_predmet_id) values (4,12);
insert into profesor_smerpredmet(profesor_id, smer_predmet_id) values (2,13);
insert into profesor_smerpredmet(profesor_id, smer_predmet_id) values (3,14);
insert into profesor_smerpredmet(profesor_id, smer_predmet_id) values (4,15);
insert into profesor_smerpredmet(profesor_id, smer_predmet_id) values (2,16);
insert into profesor_smerpredmet(profesor_id, smer_predmet_id) values (3,17);
insert into profesor_smerpredmet(profesor_id, smer_predmet_id) values (4,18);
insert into profesor_smerpredmet(profesor_id, smer_predmet_id) values (2,19);
insert into profesor_smerpredmet(profesor_id, smer_predmet_id) values (3,20);
insert into profesor_smerpredmet(profesor_id, smer_predmet_id) values (4,21);
insert into profesor_smerpredmet(profesor_id, smer_predmet_id) values (2,22);
insert into profesor_smerpredmet(profesor_id, smer_predmet_id) values (3,23);
insert into profesor_smerpredmet(profesor_id, smer_predmet_id) values (4,24);
insert into profesor_smerpredmet(profesor_id, smer_predmet_id) values (2,25);
insert into profesor_smerpredmet(profesor_id, smer_predmet_id) values (3,26);
insert into profesor_smerpredmet(profesor_id, smer_predmet_id) values (4,27);
insert into profesor_smerpredmet(profesor_id, smer_predmet_id) values (2,28);
insert into profesor_smerpredmet(profesor_id, smer_predmet_id) values (3,29);
insert into profesor_smerpredmet(profesor_id, smer_predmet_id) values (4,31);
insert into profesor_smerpredmet(profesor_id, smer_predmet_id) values (2,32);
insert into profesor_smerpredmet(profesor_id, smer_predmet_id) values (3,33);
insert into profesor_smerpredmet(profesor_id, smer_predmet_id) values (4,34);
insert into profesor_smerpredmet(profesor_id, smer_predmet_id) values (4,35);
insert into profesor_smerpredmet(profesor_id, smer_predmet_id) values (4,36);
insert into profesor_smerpredmet(profesor_id, smer_predmet_id) values (4,37);
---

--insert into skolska_godina(pocetak_godine,kraj_godine) value('2016-10-01','2017-09-30');
insert into skolska_godina(pocetak_godine,kraj_godine,pocetak_overe_letnjeg,kraj_overe_letnjeg,pocetak_overe_zimskog,kraj_overe_zimskog) value('2019-10-01','2020-09-30','2020-05-20','2020-05-30','2020-01-05','2020-01-25');
insert into skolska_godina(pocetak_godine,kraj_godine,pocetak_overe_letnjeg,kraj_overe_letnjeg,pocetak_overe_zimskog,kraj_overe_zimskog) value('2020-10-01','2021-09-30','2021-05-20','2021-05-30','2021-01-05','2021-01-25');

--ISPITI--
--1 SEMESTAR
--ANALIZA----
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (0,'2021-02-01',2,1,false,2);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (1,'2021-02-13',2,1,false,2);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (2,'2021-06-10',2,1,false,2);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (3,'2021-06-23',2,1,false,2);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (4,'2021-07-14',2,1,false,2);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (5,'2021-08-26',2,1,false,2);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (6,'2021-09-05',2,1,false,2);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (7,'2021-09-19',2,1,false,2);
--ALGEBRA----
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (0,'2021-02-06',2,2,false,3);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (1,'2021-02-21',2,2,false,3);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (2,'2021-06-13',2,2,false,3);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (3,'2021-07-06',2,2,false,3);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (4,'2021-07-20',2,2,false,3);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (5,'2021-08-29',2,2,false,3);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (6,'2021-09-11',2,2,false,3);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (7,'2021-09-25',2,2,false,3);
--ENGLESKI OSNOVNI----
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (0,'2021-01-27',2,3,false,4);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (1,'2021-02-08',2,3,false,4);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (2,'2021-06-08',2,3,false,4);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (3,'2021-07-08',2,3,false,4);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (4,'2021-07-22',2,3,false,4);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (5,'2021-08-24',2,3,false,4);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (6,'2021-08-31',2,3,false,4);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (7,'2021-09-14',2,3,false,4);
--PJISP----
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (0,'2021-01-28',2,4,false,2);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (1,'2021-02-09',2,4,false,2);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (2,'2021-06-08',2,4,false,2);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (3,'2021-07-09',2,4,false,2);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (4,'2021-07-23',2,4,false,2);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (5,'2021-08-24',2,4,false,2);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (6,'2021-09-01',2,4,false,2);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (7,'2021-09-15',2,4,false,2);

--2SEMESTAR
--FIZIKA
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (0,'2021-01-30',2,5,false,3);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (1,'2021-02-11',2,5,false,3);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (2,'2021-06-09',2,5,false,3);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (3,'2021-07-11',2,5,false,3);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (4,'2021-07-25',2,5,false,3);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (5,'2021-08-25',2,5,false,3);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (6,'2021-09-03',2,5,false,3);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (7,'2021-09-17',2,5,false,3);
--OET
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (0,'2021-01-07',2,6,false,4);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (1,'2021-02-22',2,6,false,4);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (2,'2021-06-13',2,6,false,4);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (3,'2021-07-07',2,6,false,4);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (4,'2021-07-21',2,6,false,4);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (5,'2021-08-29',2,6,false,4);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (6,'2021-09-12',2,6,false,4);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (7,'2021-10-05',2,6,false,4);
--ARHITEKTURA
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (0,'2021-02-05',2,7,false,2);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (1,'2021-02-20',2,7,false,2);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (2,'2021-06-12',2,7,false,2);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (3,'2021-07-04',2,7,false,2);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (4,'2021-07-18',2,7,false,2);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (5,'2021-08-28',2,7,false,2);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (6,'2021-09-10',2,7,false,2);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (7,'2021-10-06',2,7,false,2);
--ENGLESKI SREDNJI
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (0,'2021-02-04',2,8,false,3);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (1,'2021-02-19',2,8,false,3);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (2,'2021-06-12',2,8,false,3);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (3,'2021-07-03',2,8,false,3);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (4,'2021-07-17',2,8,false,3);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (5,'2021-08-28',2,8,false,3);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (6,'2021-09-09',2,8,false,3);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati,profesor_id) values (7,'2021-09-23',2,8,false,3);





--studenti RACUNARSTVA I AUTOMATIKE
insert into user (name, surname, email, password, enabled, type, role,broj_indexa,semestar,smer_id,godina_upisa_id) values ('Djordje', 'Rogic', 'rogic.djordje@uns.ac.rs', '$2a$10$noSRMxRJjDHt2Ky.E1QHYupSHa8tTZ0fyVXvWE5o73PKdlrLgSyMG', true, 'STUDENT', 'ROLE_STUDENT','ra01-2019',2,1,1);
insert into user (name, surname, email, password, enabled, type, role,broj_indexa,semestar,smer_id,godina_upisa_id) values ('Petar', 'Petrovic', 'petar.petrovic@uns.ac.rs', '$2a$10$noSRMxRJjDHt2Ky.E1QHYupSHa8tTZ0fyVXvWE5o73PKdlrLgSyMG', true, 'STUDENT', 'ROLE_STUDENT','ra02-2019',2,1,1);
insert into user (name, surname, email, password, enabled, type, role,broj_indexa,semestar,smer_id,godina_upisa_id) values ('Milos', 'Milosevic', 'milos.milosevic@uns.ac.rs', '$2a$10$noSRMxRJjDHt2Ky.E1QHYupSHa8tTZ0fyVXvWE5o73PKdlrLgSyMG', true, 'STUDENT', 'ROLE_STUDENT','ra03-2019',2,1,1);
insert into user (name, surname, email, password, enabled, type, role,broj_indexa,semestar,smer_id,godina_upisa_id) values ('Marko', 'Markovic', 'marko.markovic@uns.ac.rs', '$2a$10$noSRMxRJjDHt2Ky.E1QHYupSHa8tTZ0fyVXvWE5o73PKdlrLgSyMG', true, 'STUDENT', 'ROLE_STUDENT','ra04-2019',2,1,1);
insert into user (name, surname, email, password, enabled, type, role,broj_indexa,semestar,smer_id,godina_upisa_id) values ('Milica', 'Milicevic', 'milica.milicevic@uns.ac.rs', '$2a$10$noSRMxRJjDHt2Ky.E1QHYupSHa8tTZ0fyVXvWE5o73PKdlrLgSyMG', true, 'STUDENT', 'ROLE_STUDENT','ra05-2019',2,1,1);
insert into user (name, surname, email, password, enabled, type, role,broj_indexa,semestar,smer_id,godina_upisa_id) values ('Jovana', 'Jovanovic', 'jovana.jovanovic@uns.ac.rs', '$2a$10$noSRMxRJjDHt2Ky.E1QHYupSHa8tTZ0fyVXvWE5o73PKdlrLgSyMG', true, 'STUDENT', 'ROLE_STUDENT','ra06-2019',2,1,1);
insert into user (name, surname, email, password, enabled, type, role,broj_indexa,semestar,smer_id,godina_upisa_id) values ('Jovan', 'Jovanovic', 'jovan.jovanovic@uns.ac.rs', '$2a$10$noSRMxRJjDHt2Ky.E1QHYupSHa8tTZ0fyVXvWE5o73PKdlrLgSyMG', true, 'STUDENT', 'ROLE_STUDENT','ra07-2019',2,1,1);
insert into user (name, surname, email, password, enabled, type, role,broj_indexa,semestar,smer_id,godina_upisa_id) values ('Mirko', 'Mirkovic', 'mirko.mirkovic@uns.ac.rs', '$2a$10$noSRMxRJjDHt2Ky.E1QHYupSHa8tTZ0fyVXvWE5o73PKdlrLgSyMG', true, 'STUDENT', 'ROLE_STUDENT','ra08-2019',2,1,1);
insert into user (name, surname, email, password, enabled, type, role,broj_indexa,semestar,smer_id,godina_upisa_id) values ('Katarina', 'Katic', 'katarina.katic@uns.ac.rs', '$2a$10$noSRMxRJjDHt2Ky.E1QHYupSHa8tTZ0fyVXvWE5o73PKdlrLgSyMG', true, 'STUDENT', 'ROLE_STUDENT','ra09-2019',2,1,1);

--studenti koji nemaju kreirane ocene
--insert into user (name, surname, email, password, enabled, type, role,broj_indexa,semestar,smer_id,godina_upisa_id) values ('Djordje', 'Rogic', 'rogic.djordje1@uns.ac.rs', '$2a$10$noSRMxRJjDHt2Ky.E1QHYupSHa8tTZ0fyVXvWE5o73PKdlrLgSyMG', true, 'STUDENT', 'ROLE_STUDENT','ra10-2019',2,1,1);
--insert into user (name, surname, email, password, enabled, type, role,broj_indexa,semestar,smer_id,godina_upisa_id) values ('Petar', 'Petrovic', 'petar.petrovic1@uns.ac.rs', '$2a$10$noSRMxRJjDHt2Ky.E1QHYupSHa8tTZ0fyVXvWE5o73PKdlrLgSyMG', true, 'STUDENT', 'ROLE_STUDENT','ra11-2019',2,1,1);
--insert into user (name, surname, email, password, enabled, type, role,broj_indexa,semestar,smer_id,godina_upisa_id) values ('Milos', 'Milosevic', 'milos.milosevic1@uns.ac.rs', '$2a$10$noSRMxRJjDHt2Ky.E1QHYupSHa8tTZ0fyVXvWE5o73PKdlrLgSyMG', true, 'STUDENT', 'ROLE_STUDENT','ra12-2019',2,1,1);
--insert into user (name, surname, email, password, enabled, type, role,broj_indexa,semestar,smer_id,godina_upisa_id) values ('Marko', 'Markovic', 'marko.markovic1@uns.ac.rs', '$2a$10$noSRMxRJjDHt2Ky.E1QHYupSHa8tTZ0fyVXvWE5o73PKdlrLgSyMG', true, 'STUDENT', 'ROLE_STUDENT','ra13-2019',2,1,1);
--insert into user (name, surname, email, password, enabled, type, role,broj_indexa,semestar,smer_id,godina_upisa_id) values ('Milica', 'Milicevic', 'milica.milicevic1@uns.ac.rs', '$2a$10$noSRMxRJjDHt2Ky.E1QHYupSHa8tTZ0fyVXvWE5o73PKdlrLgSyMG', true, 'STUDENT', 'ROLE_STUDENT','ra14-2019',2,1,1);
--insert into user (name, surname, email, password, enabled, type, role,broj_indexa,semestar,smer_id,godina_upisa_id) values ('Jovana', 'Jovanovic', 'jovana.jovanovic1@uns.ac.rs', '$2a$10$noSRMxRJjDHt2Ky.E1QHYupSHa8tTZ0fyVXvWE5o73PKdlrLgSyMG', true, 'STUDENT', 'ROLE_STUDENT','ra15-2019',2,1,1);
--insert into user (name, surname, email, password, enabled, type, role,broj_indexa,semestar,smer_id,godina_upisa_id) values ('Jovan', 'Jovanovic', 'jovan.jovanovic1@uns.ac.rs', '$2a$10$noSRMxRJjDHt2Ky.E1QHYupSHa8tTZ0fyVXvWE5o73PKdlrLgSyMG', true, 'STUDENT', 'ROLE_STUDENT','ra16-2019',2,1,1);
--insert into user (name, surname, email, password, enabled, type, role,broj_indexa,semestar,smer_id,godina_upisa_id) values ('Mirko', 'Mirkovic', 'mirko.mirkovic1@uns.ac.rs', '$2a$10$noSRMxRJjDHt2Ky.E1QHYupSHa8tTZ0fyVXvWE5o73PKdlrLgSyMG', true, 'STUDENT', 'ROLE_STUDENT','ra17-2019',2,1,1);
--insert into user (name, surname, email, password, enabled, type, role,broj_indexa,semestar,smer_id,godina_upisa_id) values ('Katarina', 'Katic', 'katarina.katic1@uns.ac.rs', '$2a$10$noSRMxRJjDHt2Ky.E1QHYupSHa8tTZ0fyVXvWE5o73PKdlrLgSyMG', true, 'STUDENT', 'ROLE_STUDENT','ra18-2019',2,1,1);


insert into user_roles (user_id, role_id) values (5, 3);
insert into user_roles (user_id, role_id) values (6, 3);
insert into user_roles (user_id, role_id) values (7, 3);
insert into user_roles (user_id, role_id) values (8, 3);
insert into user_roles (user_id, role_id) values (9, 3);
insert into user_roles (user_id, role_id) values (10, 3);
insert into user_roles (user_id, role_id) values (11, 3);
insert into user_roles (user_id, role_id) values (12, 3);
insert into user_roles (user_id, role_id) values (13, 3);

--insert into user_roles (user_id, role_id) values (14, 3);
--insert into user_roles (user_id, role_id) values (15, 3);
--insert into user_roles (user_id, role_id) values (16, 3);
--insert into user_roles (user_id, role_id) values (17, 3);
--insert into user_roles (user_id, role_id) values (18, 3);
--insert into user_roles (user_id, role_id) values (19, 3);
--insert into user_roles (user_id, role_id) values (20, 3);
--insert into user_roles (user_id, role_id) values (21, 3);
--insert into user_roles (user_id, role_id) values (22, 3);

insert into ispit_student_prijavio(student_id,ispit_id) values (5,47);


--OCENE
--ANALIAZ
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,1,5);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,1,6);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,1,7);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,1,8);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,1,9);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,1,10);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,1,11);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,1,12);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,1,13);
--ALGEBRA
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,2,5);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,2,6);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,2,7);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,2,8);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,2,9);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,2,10);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,2,11);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,2,12);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,2,13);
--ENGLESKI
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,3,5);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,3,6);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,3,7);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,3,8);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,3,9);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,3,10);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,3,11);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,3,12);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,3,13);
--PJISP
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,4,5);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,4,6);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,4,7);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,4,8);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,4,9);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,4,10);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,4,11);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,4,12);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,4,13);
--FIZIIKA
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,5,5);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,5,6);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,5,7);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,5,8);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,5,9);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,5,10);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,5,11);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,5,12);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,5,13);
--OET
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,6,5);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,6,6);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,6,7);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,6,8);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,6,9);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,6,10);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,6,11);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,6,12);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,6,13);
--ARHITEKTURA
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,7,5);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,7,6);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,7,7);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,7,8);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,7,9);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,7,10);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,7,11);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,7,12);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,7,13);
--ENGLESKI
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,8,5);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,8,6);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,8,7);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,8,8);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,8,9);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,8,10);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,8,11);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,8,12);
insert into ocena(polozio,potpis,broj_dolazaka_na_predavanja,smer_predmet_id,student_id) values (false ,false ,0,8,13);