insert into role (name) values ('ROLE_ADMIN');
insert into role (name) values ('ROLE_PROFESOR');
insert into role (name) values ('ROLE_STUDENT');

insert into permission (name) values ('readProfesor');
insert into role_permissions (role_id, permission_id) values (1, 1);


insert into user (name, surname, email, password, enabled, type, role ) values ('Admin', 'Admin', 'admin@gmail.com', '$2a$10$aMBAEXjwqcavdNT373EM7.hlk2MWp1SNYCZ5NWk/Dytyf/xPsI02a', true, 'ADMIN', 'ROLE_ADMIN');
insert into user (name, surname, email, password, enabled, type, role,sifra_profesora) values ('Agent1', 'Agent', 'agent@gmail.com', '$2a$10$7YXN6idLLmf5Gy2K5guobOghxYVQBcc9a04fFmRd82ns12klLCmr.', true, 'PROFESOR', 'ROLE_PROFESOR','PROF123');
insert into user (name, surname, email, password, enabled, type, role,broj_indexa,godina_upisa,semestar) values ('Client1', 'Client ', 'client@gmail.com', '$2a$10$noSRMxRJjDHt2Ky.E1QHYupSHa8tTZ0fyVXvWE5o73PKdlrLgSyMG', true, 'STUDENT', 'ROLE_STUDENT','ra56-2016','2020-06-05',1);

insert into user_roles (user_id, role_id) values (1, 1);