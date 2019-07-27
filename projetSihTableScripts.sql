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

select * from agentblocoperatoire;
