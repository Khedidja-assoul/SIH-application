CREATE DATABASE if not exists SIH_BDD;
use SIH_BDD;
CREATE TABLE Administrateur(
id int(2) auto_increment,
nomUtilisateur varchar(20)not null,
motDePasse varchar(20) not null,
nom varchar(30) not null,
prenom varchar(30) not null,
primary key (id)
);

CREATE TABLE Medecin(
id int(5) auto_increment,
nom varchar(30) not null,
prenom varchar(30) not null,
nbHeures int,
dateNaissance varchar(10),
email varchar(30),
tel int(10),
grade varchar(30),
specialite varchar(30),
primary key(id)
);
ALTER TABLE medecin AUTO_INCREMENT=10000;

CREATE TABLE infirmier(
id int(5) auto_increment,
nom varchar(30) not null,
prenom varchar(30) not null,
nbHeures int,
dateNaissance varchar(10),
email varchar(30),
tel int(10),
primary key(id)
);
ALTER TABLE infirmier auto_increment=20000;

CREATE TABLE AgentBlocOperatoire(
id int(5) auto_increment,
nom varchar(30) not null,
prenom varchar(30) not null,
nbHeures int,
dateNaissance varchar(10),
email varchar(30),
tel int(10),
primary key(id)
);
ALTER TABLE agentblocoperatoire AUTO_INCREMENT=30000;

CREATE TABLE AgentLaboratoire(
id int(5) auto_increment,
nom varchar(30) not null,
prenom varchar(30) not null,
nbHeures int,
dateNaissance varchar(10),
email varchar(30),
tel int(10),
primary key(id)
);
ALTER TABLE agentlaboratoire AUTO_INCREMENT=40000;

CREATE TABLE AgentParamedicale(
id int(5) auto_increment ,
nom varchar(30) not null,
prenom varchar(30) not null,
nbHeures int,
dateNaissance varchar(10),
email varchar(30),
tel int(10),
primary key(id)
);

ALTER TABLE agentparamedicale AUTO_INCREMENT=50000;
insert into AgentParamedicale(nom,prenom,nbHeures,dateNaissance,email,tel) values ('ab','cd',12,'25/03/1997','a@y.com','0151213');
select * from AgentParamedicale;
CREATE TABLE chambre(
num int(3) ,
etage int(1) not null,
nbLits int(1) not null,
estReserver boolean,
primary key(num)
);

CREATE TABLE patient(
id int(6) auto_increment,
nom varchar(30) not null,
prenom varchar(30) not null,
dateNaissance varchar(10) not null,
adresse varchar(40),
tel int(10)not null,
email varchar(30),
primary key(id),
foreign key (id) references utilisateur(id)
);

ALTER TABLE patient AUTO_INCREMENT=100000;

CREATE TABLE utilisateur (
nomUtilisateur  varchar(30) not null,
motPasse varchar(30) not null,
typeUtilisateur  varchar(10) not null,
id int,
primary key(nomUtilisateur)
);
SELECT * FROM consultation;
SELECT * FROM patient where nom ='BARACHE' and prenom = 'Abderrahman';
SELECT * FROM agentblocoperatoire ;

create table consultation(
id int(7) auto_increment,
idMedecin int,
idPatient int,
date varchar(10),
heure varchar(5),
motif text,
primary key(id),
foreign key (idMedecin) references medecin(id),
foreign key (idPatient) references patient(id)
);
ALTER TABLE consultation AUTO_INCREMENT=1000000;
select * from consultation;

create table acteComplementaireLaboratoire(
id int(8) auto_increment,
idConsultation int,
primary key (id),
foreign key(idConsultation) references consultation(id)
);
select *  from actecomplementairelaboratoire;
select max(actecomplementairelaboratoire.id) from actecomplementairelaboratoire,consultation where actecomplementairelaboratoire.idConsultation = consultation.id;
alter table acteComplementaireLaboratoire auto_increment=10000000;

create table acteComplementaireBlocOperation(
id int(8) auto_increment,
dateActe varcharacter(10),
datePlusTot varcharacter(10),
idMedecin int,
idPatient int,
detailes text,
primary key (id),
foreign key (idMedecin) references medecin(id),
foreign key (idPatient) references patient(id)
);
alter table acteComplementaireLaboratoire auto_increment=20000000;
show tables;
create table analyse(
id int auto_increment,
abreviation varchar(10),
nomOfficiel varchar(50),
detailles text,
primary key(id)
);
insert into analyse(id,abreviation,nomOfficiel,detailles) values (1,'NFS','Numération Formule Sanguine','[
    {
        "&nbsp;" : "Hématies (millions/mm3)",
        "3 à 10 ans": "4,0-5,4",
        "Femme": "4.0 - 5.3",
        "Homme":"4.2 - 5.7"
    },
    {
        "&nbsp;" : "Hémoglobine (g/100 ml)",
        "3 à 10 ans": "12.0 - 14.5",
        "Femme": "12.5 - 15.5",
        "Homme":"14.0 - 17.0"
    },    {
        "&nbsp;" : "Hématocrite (%)",
        "3 à 10 ans": "36 - 45",
        "Femme": "37 - 46",
        "Homme":"40 - 52"
    },    {
        "&nbsp;" : "VGM (µ3)",
        "3 à 10 ans": "74 - 91",
        "Femme": "80 - 95",
        "Homme":"80 - 95"
    },    {
        "&nbsp;" : "TCMH (pg)",
        "3 à 10 ans": "24 - 27",
        "Femme": "28 - 32",
        "Homme":"28 - 32"
    },    {
        "&nbsp;" : "CCMH (%)",
        "3 à 10 ans": "28 - 33",
        "Femme": "30 - 35",
        "Homme":"30 - 35"
    },    {
        "&nbsp;" : "Leucocytes (/mm3x1000)",
        "3 à 10 ans": "5000 - 11000",
        "Femme": "4000 - 10000",
        "Homme":"4000 - 10000"
    },    {
        "&nbsp;" : "Réticulocytes (%)",
        "3 à 10 ans": "0,2 - 0,8",
        "Femme": "0,3 - 0,8",
        "Homme":"0,3 - 0,8"
    }
]');
select * from actecompostition;
create table acteCompostition(
idActe int,
idAnalyse int,
foreign key (idActe) references acteComplementaireLaboratoire(id),
foreign key (idAnalyse) references analyse(id)
);

create table resultatBiologique(
id int auto_increment,
idActe int,
idAgentLaboratoire int,
date varchar(10),
heure varchar(5),
primary key (id),
foreign key (idActe) references acteComplementaireLaboratoire(id),
foreign key (idAgentLaboratoire) references agentlaboratoire(id)
);
alter table resultatBiologique auto_increment=20000000;
select * from agentlaboratoire;

create table resultatAnalyse(
id int auto_increment,
idResultatBiologique int ,
idAnalyse int,
detailles text,
primary key (id),
foreign key (idResultatBiologique) references resultatBiologique(id),
foreign key (idAnalyse) references analyse(id)
);

select * from actecomplementairelaboratoire where id not in (select idActe from resultatBiologique);


create table prescription(
id int(8) auto_increment,
idConsultation int,
typePrescription varchar(20),
detaille text,
primary key (id),
foreign key(idConsultation) references consultation(id)
);
alter table prescription auto_increment=20000000;

create table compterenduconsultation(
id int(8) auto_increment,
detaille text,
idConsultation int,
primary key (id),
foreign key(idConsultation) references consultation(id)
);
alter table compterenduconsultation auto_increment=30000000;


create table plansoin(
id int(8) auto_increment,
idConsultation int,
soins text,
primary key (id),
foreign key(idConsultation) references consultation(id)
);
alter table plansoins auto_increment=40000000;

select * from patient;
;

show tables ;