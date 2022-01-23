create database gestionsalbums;

use gestionsalbums;

create table utilisateur(
  id int primary key auto_increment,
  nom varchar(255) not null, 
  prenom varchar(255) not null,
  login varchar(255) not null,
  password varchar(255) not null,
  profil ENUM('simple', 'admin') not null
);

create table album(
	id int primary key auto_increment,
	theme varchar(255) not null,
	mode ENUM('public', 'prive') not null,
	idUser int not null,
	foreign key (idUser) references utilisateur(id)
);

create table image(
	id int primary key auto_increment,
	titre varchar(255) not null,
	description text not null,
	motCles varchar(255) not null,
	hauteur int not null,
	largeur int not null,
	dateCreation date not null,
	dateModification date not null,
	nomFichier varchar(255) not null,
	idAlbum int not null,
	foreign key (idAlbum) references album(id)
);