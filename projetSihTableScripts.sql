CREATE DATABASE if not exists SIH_BDD;
use SIH_BDD;
CREATE TABLE Administrateur(
id int(2) auto_increment,
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
ALTER TABLE medecin AUTO_INCREMENT=10000

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
primary key(id)
);
ALTER TABLE patient AUTO_INCREMENT=100000;

