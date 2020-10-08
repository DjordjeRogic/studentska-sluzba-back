# Studentska sluzba

Aplikacija predstavlja resenje za studentsku sluzbu i nastoji u tome da olaksa koricenje iste profesorima,
studentima kao i administratorima.

**Administratori** rukovode i imaju uvid o svim informacijama vezanim za profesore, studente, smerove, predmete i ispite. Da administratori ne bi morali svake godine 
da kreiraju sve ispite sistem je dizajniran tako da na pocetku godine kreira sve ispite samostalno za celu godinu.

**Profesori** imaju uvid o predmetima koje predaju i ispitima koje vode. Njima je olaksano da uz pomoc excel fajlova vode uvid koji studetni su prijavili ispit 
i onda te iste fajlove sa rezultatima uploaduju na server kako bi ocene bile unete. Isto im je omoguceno i za unos dolazaka na predavanja. Ovim se eliminise problem da profesori rucno unose podatke za svakog studenta posebno.

**Studentima** je obzbedjeno pregledniji uvid u ispite i ocene a takodje i obavestenja u vidu emaila kad profesor unese rezultate.

#
Aplikacija je razvijana uz korscenje Spring boot frameworka a za bazu je koriscena MySql.  
Fronted aplikacije se nalazi na sledecem linku: https://github.com/DjordjeRogic/studentska-sluzba-front
