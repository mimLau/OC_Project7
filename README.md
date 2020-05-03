# OC_Project_7: Système de gestion de bibliothèques.

  
## Table of contents 
* [Informations générales](#général) 
* [Technologies utilisées](#technologies) 
* [configuration de la base de données](#bdd) 
* [Déploiement des modules](#déploiement) 


## Informations générales :  

### Nom de l'application  

Bibliothèques municipales de Strasbourg

### Description  

Système de gestion centralisée des bibliothèques d'une ville. Mise en place d'une interface utilisateur qui permet la recherche d'ouvrages dans les différentes bibliothèques de la ville. Les utilisateurs membres pourront consulter et prolnger leur prêt.

### Architecture 

Le projet est constitué :

- d'un webservice Rest : **microservice-library**, 
- d'une application web: **client-library**,
- d'un serveur d'authentification: **authentication-library**,
- d'un batch: **batch-library**

 4 modules qui communiquent entre eux par le biais de l'

## Technologies utilisées : 

* Java 13.0.1.  
* Maven 4.0.0 
* Springboot 2.2.5.RELEASE 


## Configuration de la base de données : 

* Type: Mysql
* N° du port 3306 
* Identifiant : root 
* Mot de passe : root 

Le projet présente 2 schémas db_auth_lib et db_library.

### Schéma db_auth_lib

Contient la table user avec les identifiants et les mots de passe ainsi que les rôles et les permissions des utilisateurs. Cette table est utilisée par le serveur d'authentification. Un jeu de données est fourni dans le fichier **db_auth_lib_20.sql**.

### Schéma db_library

Contient toutes les tables permetant la gestion des bibliothèqes ainsi que des ouvrages. Ces tables seront consommées par le webService. Un jeu de données est fourni dans le fichier **db_lib_20.sql**.


## Déploiement de l'application : 

Lancer les jar dans l'ordre suivant:

- microsrvice-library.jar
- authentication-library.jar
- client-library.jar
- batch-library.jar


