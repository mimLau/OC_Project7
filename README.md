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

Système de gestion centralisée des bibliothèques d'une ville. Mise en place d'une interface utilisateur qui permet la recherche d'ouvrages dans les différentes bibliothèques de la ville. Les utilisateurs membre pourront consulter et prolonger leur prêt.


Le projet est constitué :

- d'un webservice Rest : **microservice-library**, fournisseur de ressources récupérées depuis la base de données **db_library**.

- d'une application web: **client-library**, présentant une interface utilisateur. Elle communique avec le web service pour récupérer les ressources nécessaires à l'affichage des données.

- d'un serveur d'authentification: **authentication-library**, qui permet de s'assurer de l'intégrité de l'utilisateur qui se connecte. Il l'autorise ou non à accéder certaines données. Il communique avec le client web ainsi que le webservice ainsi qu'avec la base de données **db_auth_lib**.

- d'un batch: **batch-library**, pour gérer l'envoie automatique d'emails aux utilisateurs ayant des prêts en retard. Il communique avec le serveur d'authentification pour pouvoir s'authentifier et récupérer les données (email des utilisateurs) depuis le webservice **microservice-library**.

 Ces 4 modules communiquent entre eux par le biais du webservice Rest.


## Développement : 

* Ide: IntelliJ
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

Le projet présente les schémas suivant : 

### Schéma db_auth_lib

Contient la table user avec les identifiants et les mots de passe ainsi que les rôles et les permissions des utilisateurs. Cette table est utilisée par le serveur d'authentification. Un jeu de données est fourni dans le fichier **db_auth_lib_20.sql**. (https://github.com/mimLau/OC_Library_app/blob/master/db_auth_lib_20.sql)

### Schéma db_library

Contient toutes les tables permetant la gestion des bibliothèqes ainsi que leurs ouvrages. Ces tables seront consommées par le webService. Un jeu de données est fourni dans le fichier **db_lib_20.sql**. (https://github.com/mimLau/OC_Library_app/blob/master/db_lib_20.sql)


## Déploiement de l'application : 


### Récupération et import du projet :

Cloner le projet vers un repertoire de votre choix à l'aide de la commande suivante :

**git clone https://github.com/mimLau/OC_Library_app.git**

Dans votre IDE, choisissez dans un premier temps le jdk qui sera utilisé pour lancer le projet. Dans notre cas, il s'agira du jdk 13.0.1.
Importer ensuite le projet cloné à partir d'une source existante et en cliquant bien sur Maven.
Ensuite, se rendre dans **project structure** puis **module** et à l'aide du **+** importer les modules suivant un à un (choisir Maven comme source externe).

- microservice-library
- authentication-library 
- client-library
- batch-library


### Lancement du projet :

Pour lancer le projet, excécuter les modules dans l'ordre suivant sur leur port respectif:

- microservice-library: port 8080
- authentication-library: port 9090
- client-library: port 8081
- batch-library: port 8082


Spring boot contenant un serveur Tomcat embarqué, il ne sera pas necessaire de configurer un serveur lors du déploiement des différents modules.

Dans chacun des modules, se trouve un fichier **applications.properties** dans lequel sont stockées toutes les donées de configuration. Vous pouvez modifier les différents ports s'ils ne sont pas libres.


#### Webservice Rest :

Il récupère toutes les ressources de la BDD **db_library** et les envoie à ses differents clients qui sont:

- le serveur d'authentification
- l'application web
- le batch

Chaque requête envoyée par les clients contient un token. En fonction des rôles ou permissions qui se trouvent dans le token, la requête sera acceptée ou non par le webservice.

On peut y accéder via l'url suivante: **localhost:8080/**


#### Serveur auhtentification :

Celui ci est configuré sur le port 9090, et récupère les crédentials des utilisateurs à partir de la BDD **db_auth_library**.

L'application web envoie au serveur d'authentification les identifiants de l'utilisateur qui souhaite se connecter, ce dernier va vérifier dans sa BDD les identifiants de l'utilisateur. Si l'utilisateur existe, le serveur envoie un token à l'application web avec le rôle et les permissions de ce dernier.


#### Application web :

On accède à l'application web avec l'url suivante : **localhost:8081/**. 
Les identifiants des utilisateurs sont les suivants :

- maryam maryam
- sophie sophie
- admin admin


#### Batch :

Il est programmé pour lancer automatiquement des emails tous les jours aux utilisateurs ayant du retard dans leur prêt. Pour cela, il communique avec le serveur d'authentification pour pouvoir se connecter au webservice et récupérer les emails des utilisateurs.

