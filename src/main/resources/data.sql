insert into role (name) values ('ROLE_ADMIN');
insert into role (name) values ('ROLE_PROFESOR');
insert into role (name) values ('ROLE_STUDENT');

insert into permission (name) values ('readProfesor');
insert into role_permissions (role_id, permission_id) values (1, 1);


insert into user (name, surname, email, password, enabled, type, role ) values ('Admin', 'Admin', 'admin@gmail.com', '$2a$10$aMBAEXjwqcavdNT373EM7.hlk2MWp1SNYCZ5NWk/Dytyf/xPsI02a', true, 'ADMIN', 'ROLE_ADMIN');
insert into user (name, surname, email, password, enabled, type, role,sifra_profesora) values ('Agent1', 'Agent', 'agent@gmail.com', '$2a$10$7YXN6idLLmf5Gy2K5guobOghxYVQBcc9a04fFmRd82ns12klLCmr.', true, 'PROFESOR', 'ROLE_PROFESOR','PROF123');

insert into user_roles (user_id, role_id) values (1, 1);

insert into smer (naziv, skracenica, trajanjeusemestrima, obrazovno_polje, naziv_diplome) values ('Racunarstvo i automatika', 'RA', 8, 0,'Diplomiranji Inzenjer Elektrotehnike i Racunarstva');
insert into predmet(naziv, kategorija) value ('Matematicka analiza 1',0);
insert into predmet(naziv, kategorija) value ('Algebra',0);

insert into smer_predmet(sifra_studijskog_programa, broj_predavanjaugodini, brojesbpbodova, semestar, predmet_id, profesor_id, smer_id) values ('E2123',24,9,1,1,2,1);

insert into skolska_godina(pocetak_godine,kraj_godine) value('2019-10-01','2020-09-30');

insert into ispit(rok,datum,mesto_odrzavanja,skolska_godina_id,smer_predmet_id,uneseni_rezultati) values (5,'2020-08-10','A1',1,1,false);
insert into user (name, surname, email, password, enabled, type, role,broj_indexa,semestar,smer_id) values ('Client1', 'Client ', 'client@gmail.com', '$2a$10$noSRMxRJjDHt2Ky.E1QHYupSHa8tTZ0fyVXvWE5o73PKdlrLgSyMG', true, 'STUDENT', 'ROLE_STUDENT','ra56-2016',1,1);

insert into user_prijavljeni_ispiti(student_id,prijavljeni_ispiti_id) values (3,1);

insert into ispit_studenti_koji_su_prijavili(ispit_id,studenti_koji_su_prijavili_id) values (1,3);