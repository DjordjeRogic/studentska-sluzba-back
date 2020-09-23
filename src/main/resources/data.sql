insert into role (name) values ('ROLE_ADMIN');
insert into role (name) values ('ROLE_PROFESOR');
insert into role (name) values ('ROLE_STUDENT');

insert into permission (name) values ('readProfesor');
insert into role_permissions (role_id, permission_id) values (1, 1);

--ADMINISTRATOR
insert into user (name, surname, email, password, enabled, type, role ) values ('Admin', 'Admin', 'admin@gmail.com', '$2a$10$aMBAEXjwqcavdNT373EM7.hlk2MWp1SNYCZ5NWk/Dytyf/xPsI02a', true, 'ADMIN', 'ROLE_ADMIN');
------
--PROFESORI
insert into user (name, surname, email, password, enabled, type, role,sifra_profesora) values ('Milan', 'Vidakovic', 'milan.vidakovic@maill.com', '$2a$10$7YXN6idLLmf5Gy2K5guobOghxYVQBcc9a04fFmRd82ns12klLCmr.', true, 'PROFESOR', 'ROLE_PROFESOR','PROF1');
insert into user (name, surname, email, password, enabled, type, role,sifra_profesora) values ('Ivan', 'Lukovic', 'ivan.lukovic@maill.com', '$2a$10$7YXN6idLLmf5Gy2K5guobOghxYVQBcc9a04fFmRd82ns12klLCmr.', true, 'PROFESOR', 'ROLE_PROFESOR','PROF2');
insert into user (name, surname, email, password, enabled, type, role,sifra_profesora) values ('Branko', 'Milosavljević ', 'branko.mil@maill.com', '$2a$10$7YXN6idLLmf5Gy2K5guobOghxYVQBcc9a04fFmRd82ns12klLCmr.', true, 'PROFESOR', 'ROLE_PROFESOR','PROF3');

----
insert into user_roles (user_id, role_id) values (1, 1);
insert into user_roles (user_id, role_id) values (2, 1);
insert into user_roles (user_id, role_id) values (3, 1);

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
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, profesor_id, smer_id) values ('E212',24,9,1,1,1,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, profesor_id, smer_id) values ('E213A',24,9,1,2,2,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, profesor_id, smer_id) values ('E214',24,9,1,3,3,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, profesor_id, smer_id) values ('EJ1Z',12,3,1,4,1,1);

--2 SEMESTAR
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, profesor_id, smer_id) values ('E215',24,9,2,5,1,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, profesor_id, smer_id) values ('E216',24,9,2,6,2,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, profesor_id, smer_id) values ('E217',24,9,2,7,3,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, profesor_id, smer_id) values ('EJ2Z',12,3,2,8,1,1);

--3 SEMESTAR
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, profesor_id, smer_id) values ('E232',24,8,3,9,1,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, profesor_id, smer_id) values ('E227A',24,6,3,10,2,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, profesor_id, smer_id) values ('E221A',24,8,3,11,3,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, profesor_id, smer_id) values ('E223A',12,8,3,12,1,1);

--4 SEMESTAR
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, profesor_id, smer_id) values ('E225',24,8,4,13,1,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, profesor_id, smer_id) values ('E251A',24,3,4,14,2,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, profesor_id, smer_id) values ('E226',24,8,4,15,3,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, profesor_id, smer_id) values ('E23A2',12,6,4,16,1,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, profesor_id, smer_id) values ('E224A',12,5,4,17,1,1);

--5 SEMESTAR
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, profesor_id, smer_id) values ('E237',24,8,5,18,1,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, profesor_id, smer_id) values ('RI43A',24,8,5,19,2,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, profesor_id, smer_id) values ('E235',24,8,5,20,3,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, profesor_id, smer_id) values ('E231',12,4,5,21,1,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, profesor_id, smer_id) values ('E234',12,4,5,22,1,1);

--6 SEMESTAR
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, profesor_id, smer_id) values ('E236A',24,8,6,23,1,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, profesor_id, smer_id) values ('E239A',24,6,6,24,2,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, profesor_id, smer_id) values ('E243',24,4,6,25,3,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, profesor_id, smer_id) values ('E233',12,4,6,26,1,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, profesor_id, smer_id) values ('E242',12,4,6,27,1,1);

--7 SEMESTAR
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, profesor_id, smer_id) values ('RI45',24,7,7,28,1,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, profesor_id, smer_id) values ('E2K40A',24,7,7,29,2,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, profesor_id, smer_id) values ('RI4A',24,6,7,30,3,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, profesor_id, smer_id) values ('RI43B',12,6,7,31,1,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, profesor_id, smer_id) values ('RI41',12,4,7,32,1,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, profesor_id, smer_id) values ('E23SP',12,3,7,33,1,1);

--8 SEMESTAR
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, profesor_id, smer_id) values ('E2E40',24,7,8,34,1,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, profesor_id, smer_id) values ('RI53',24,5,8,35,2,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, profesor_id, smer_id) values ('E2E41',24,8,4,36,3,1);
insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, profesor_id, smer_id) values ('E24BR',12,13,8,37,1,1);

----------------------------------------------------


--insert into skolska_godina(pocetak_godine,kraj_godine) value('2016-10-01','2017-09-30');
insert into skolska_godina(pocetak_godine,kraj_godine,pocetak_overe_letnjeg,kraj_overe_letnjeg,pocetak_overe_zimskog,kraj_overe_zimskog) value('2019-10-01','2020-09-30','2020-05-20','2020-05-30','2020-01-05','2020-01-25');

--ISPITI--
--1 SEMESTAR
--ANALIZA----
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (0,'2020-02-01',1,1,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (1,'2020-02-13',1,1,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (2,'2020-06-10',1,1,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (3,'2020-06-23',1,1,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (4,'2020-07-14',1,1,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (5,'2020-08-26',1,1,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (6,'2020-09-05',1,1,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (7,'2020-09-19',1,1,false);
--ALGEBRA----
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (0,'2020-02-06',1,2,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (1,'2020-02-21',1,2,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (2,'2020-06-13',1,2,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (3,'2020-07-06',1,2,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (4,'2020-07-20',1,2,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (5,'2020-08-29',1,2,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (6,'2020-09-11',1,2,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (7,'2020-09-25',1,2,false);
--ENGLESKI OSNOVNI----
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (0,'2020-01-27',1,3,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (1,'2020-02-08',1,3,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (2,'2020-06-08',1,3,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (3,'2020-07-08',1,3,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (4,'2020-07-22',1,3,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (5,'2020-08-24',1,3,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (6,'2020-08-31',1,3,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (7,'2020-09-14',1,3,false);
--PJISP----
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (0,'2020-01-28',1,4,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (1,'2020-02-09',1,4,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (2,'2020-06-08',1,4,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (3,'2020-07-09',1,4,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (4,'2020-07-23',1,4,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (5,'2020-08-24',1,4,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (6,'2020-09-01',1,4,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (7,'2020-09-15',1,4,false);

--2SEMESTAR
--FIZIKA
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (0,'2020-01-30',1,5,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (1,'2020-02-11',1,5,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (2,'2020-06-09',1,5,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (3,'2020-07-11',1,5,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (4,'2020-07-25',1,5,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (5,'2020-08-25',1,5,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (6,'2020-09-03',1,5,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (7,'2020-09-17',1,5,false);
--OET
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (0,'2020-01-07',1,6,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (1,'2020-02-22',1,6,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (2,'2020-06-13',1,6,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (3,'2020-07-07',1,6,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (4,'2020-07-21',1,6,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (5,'2020-08-29',1,6,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (6,'2020-09-12',1,6,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (7,'2020-09-26',1,6,false);
--ARHITEKTURA
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (0,'2020-02-05',1,7,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (1,'2020-02-20',1,7,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (2,'2020-06-12',1,7,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (3,'2020-07-04',1,7,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (4,'2020-07-18',1,7,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (5,'2020-08-28',1,7,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (6,'2020-09-10',1,7,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (7,'2020-09-24',1,7,false);
--ENGLESKI SREDNJI
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (0,'2020-02-04',1,8,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (1,'2020-02-19',1,8,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (2,'2020-06-12',1,8,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (3,'2020-07-03',1,8,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (4,'2020-07-17',1,8,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (5,'2020-08-28',1,8,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (6,'2020-09-09',1,8,false);
insert into ispit(rok,datum,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (7,'2020-09-23',1,8,false);





--studenti RACUNARSTVA I AUTOMATIKE
insert into user (name, surname, email, password, enabled, type, role,broj_indexa,semestar,smer_id,godina_upisa_id) values ('Djordje', 'Rogic ', 'rogic.djordje@mail.com', '$2a$10$noSRMxRJjDHt2Ky.E1QHYupSHa8tTZ0fyVXvWE5o73PKdlrLgSyMG', true, 'STUDENT', 'ROLE_STUDENT','ra01-2016',1,1,1);
insert into user (name, surname, email, password, enabled, type, role,broj_indexa,semestar,smer_id,godina_upisa_id) values ('Petar', 'Petrovic ', 'petar.petrovic@mail.com', '$2a$10$noSRMxRJjDHt2Ky.E1QHYupSHa8tTZ0fyVXvWE5o73PKdlrLgSyMG', true, 'STUDENT', 'ROLE_STUDENT','ra02-2016',1,1,1);
insert into user (name, surname, email, password, enabled, type, role,broj_indexa,semestar,smer_id,godina_upisa_id) values ('Milos', 'Milosevic ', 'milos.milosevic@mail.com', '$2a$10$noSRMxRJjDHt2Ky.E1QHYupSHa8tTZ0fyVXvWE5o73PKdlrLgSyMG', true, 'STUDENT', 'ROLE_STUDENT','ra03-2016',1,1,1);
insert into user (name, surname, email, password, enabled, type, role,broj_indexa,semestar,smer_id,godina_upisa_id) values ('Marko', 'Markovic ', 'marko.markovic@mail.com', '$2a$10$noSRMxRJjDHt2Ky.E1QHYupSHa8tTZ0fyVXvWE5o73PKdlrLgSyMG', true, 'STUDENT', 'ROLE_STUDENT','ra04-2016',1,1,1);
insert into user (name, surname, email, password, enabled, type, role,broj_indexa,semestar,smer_id,godina_upisa_id) values ('Milica', 'Milicevic ', 'milica.milicevic@mail.com', '$2a$10$noSRMxRJjDHt2Ky.E1QHYupSHa8tTZ0fyVXvWE5o73PKdlrLgSyMG', true, 'STUDENT', 'ROLE_STUDENT','ra05-2016',1,1,1);
insert into user (name, surname, email, password, enabled, type, role,broj_indexa,semestar,smer_id,godina_upisa_id) values ('Jovana', 'Jovanovic ', 'jovana.jovanovic@mail.com', '$2a$10$noSRMxRJjDHt2Ky.E1QHYupSHa8tTZ0fyVXvWE5o73PKdlrLgSyMG', true, 'STUDENT', 'ROLE_STUDENT','ra06-2016',1,1,1);
insert into user (name, surname, email, password, enabled, type, role,broj_indexa,semestar,smer_id,godina_upisa_id) values ('Jovan', 'Jovanovic ', 'jovan.jovanovic@mail.com', '$2a$10$noSRMxRJjDHt2Ky.E1QHYupSHa8tTZ0fyVXvWE5o73PKdlrLgSyMG', true, 'STUDENT', 'ROLE_STUDENT','ra07-2016',1,1,1);
insert into user (name, surname, email, password, enabled, type, role,broj_indexa,semestar,smer_id,godina_upisa_id) values ('Mirko', 'Mirkovic ', 'mirko.mirkovic@mail.com', '$2a$10$noSRMxRJjDHt2Ky.E1QHYupSHa8tTZ0fyVXvWE5o73PKdlrLgSyMG', true, 'STUDENT', 'ROLE_STUDENT','ra08-2016',1,1,1);
insert into user (name, surname, email, password, enabled, type, role,broj_indexa,semestar,smer_id,godina_upisa_id) values ('Katarina', 'Katic ', 'katarina.katic@mail.com', '$2a$10$noSRMxRJjDHt2Ky.E1QHYupSHa8tTZ0fyVXvWE5o73PKdlrLgSyMG', true, 'STUDENT', 'ROLE_STUDENT','ra09-2016',1,1,1);

insert into user (name, surname, email, password, enabled, type, role,broj_indexa,semestar,smer_id,godina_upisa_id) values ('Djordje', 'Rogic ', 'rogic.djordje1@mail.com', '$2a$10$noSRMxRJjDHt2Ky.E1QHYupSHa8tTZ0fyVXvWE5o73PKdlrLgSyMG', true, 'STUDENT', 'ROLE_STUDENT','ra10-2016',1,1,1);
insert into user (name, surname, email, password, enabled, type, role,broj_indexa,semestar,smer_id,godina_upisa_id) values ('Petar', 'Petrovic ', 'petar.petrovic1@mail.com', '$2a$10$noSRMxRJjDHt2Ky.E1QHYupSHa8tTZ0fyVXvWE5o73PKdlrLgSyMG', true, 'STUDENT', 'ROLE_STUDENT','ra11-2016',1,1,1);
insert into user (name, surname, email, password, enabled, type, role,broj_indexa,semestar,smer_id,godina_upisa_id) values ('Milos', 'Milosevic ', 'milos.milosevic1@mail.com', '$2a$10$noSRMxRJjDHt2Ky.E1QHYupSHa8tTZ0fyVXvWE5o73PKdlrLgSyMG', true, 'STUDENT', 'ROLE_STUDENT','ra12-2016',1,1,1);
insert into user (name, surname, email, password, enabled, type, role,broj_indexa,semestar,smer_id,godina_upisa_id) values ('Marko', 'Markovic ', 'marko.markovic1@mail.com', '$2a$10$noSRMxRJjDHt2Ky.E1QHYupSHa8tTZ0fyVXvWE5o73PKdlrLgSyMG', true, 'STUDENT', 'ROLE_STUDENT','ra13-2016',1,1,1);
insert into user (name, surname, email, password, enabled, type, role,broj_indexa,semestar,smer_id,godina_upisa_id) values ('Milica', 'Milicevic ', 'milica.milicevic1@mail.com', '$2a$10$noSRMxRJjDHt2Ky.E1QHYupSHa8tTZ0fyVXvWE5o73PKdlrLgSyMG', true, 'STUDENT', 'ROLE_STUDENT','ra14-2016',1,1,1);
insert into user (name, surname, email, password, enabled, type, role,broj_indexa,semestar,smer_id,godina_upisa_id) values ('Jovana', 'Jovanovic ', 'jovana.jovanovic1@mail.com', '$2a$10$noSRMxRJjDHt2Ky.E1QHYupSHa8tTZ0fyVXvWE5o73PKdlrLgSyMG', true, 'STUDENT', 'ROLE_STUDENT','ra15-2016',1,1,1);
insert into user (name, surname, email, password, enabled, type, role,broj_indexa,semestar,smer_id,godina_upisa_id) values ('Jovan', 'Jovanovic ', 'jovan.jovanovic1@mail.com', '$2a$10$noSRMxRJjDHt2Ky.E1QHYupSHa8tTZ0fyVXvWE5o73PKdlrLgSyMG', true, 'STUDENT', 'ROLE_STUDENT','ra16-2016',1,1,1);
insert into user (name, surname, email, password, enabled, type, role,broj_indexa,semestar,smer_id,godina_upisa_id) values ('Mirko', 'Mirkovic ', 'mirko.mirkovic1@mail.com', '$2a$10$noSRMxRJjDHt2Ky.E1QHYupSHa8tTZ0fyVXvWE5o73PKdlrLgSyMG', true, 'STUDENT', 'ROLE_STUDENT','ra17-2016',1,1,1);
insert into user (name, surname, email, password, enabled, type, role,broj_indexa,semestar,smer_id,godina_upisa_id) values ('Katarina', 'Katic ', 'katarina.katic1@mail.com', '$2a$10$noSRMxRJjDHt2Ky.E1QHYupSHa8tTZ0fyVXvWE5o73PKdlrLgSyMG', true, 'STUDENT', 'ROLE_STUDENT','ra18-2016',1,1,1);


insert into user_prijavljeni_ispiti(student_id,prijavljeni_ispiti_id) values (5,47);

insert into ispit_studenti_koji_su_prijavili(ispit_id,studenti_koji_su_prijavili_id) values (47,5);
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