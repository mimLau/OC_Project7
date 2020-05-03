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


Le projet est constitué :

- d'un webservice Rest : **microservice-library**, fournisseur de ressources récupérées depuis la base de données **db_library**.

- d'une application web: **client-library**, présentant une interface utilisateur. Elle communique avec le web service pour récupérer les ressources nécessaires à l'affichage des données.

- d'un serveur d'authentification: **authentication-library**, qui permet de s'assurer de l'intégrité de l'utilisateur qui se connecte. Elle l'autorise ou non à accéder certaines données. Il communique avec le client web ainsi que le webservice.

- d'un batch: **batch-library**, pour gérer l'envoie automatique d'emails aux utilisateurs ayant des prêts en retard.

 Ces 4 modules communiquent entre eux par le biais du webservice.

## Technologies utilisées : 

* Java 13.0.1.  
* Maven 4.0.0 
* Springboot 2.2.5.RELEASE 
* Spring security
* Spring MVC
* Mysql


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

Lancer les jar ou les modules dans l'ordre suivant:

- microsrvice-library
- authentication-library
- client-library
- batch-library

Spring boot contenant un serveur Tomcat embarqué, il ne sera pas necessaire d'avoir un serveur lors du déploiement des différents modules.

Dans chacun des modules, se trouve un fichier applications.properties dans lequel sont stockées toutes les donées de configuration.

