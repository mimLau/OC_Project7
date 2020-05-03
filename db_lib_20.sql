CREATE DATABASE  IF NOT EXISTS `db_library` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `db_library`;
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_library
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Dumping data for table `accounts`
--

LOCK TABLES `accounts` WRITE;
/*!40000 ALTER TABLE `accounts` DISABLE KEYS */;
INSERT INTO `accounts` VALUES ('Member',1,'maryam@gmail.com','maryam','maryam','0388324567',_binary '','2019-02-10','USER','LAUNMAR1-1',3,'maryam'),('Member',2,'sofie.a@gmail.com','sophie','goodman','0388324567',_binary '','2019-02-10','USER','RICHSOP1-2',5,'sophie'),('Employee',5,'admin','admin','admin','0388324567',_binary '','2019-02-10','ADMIN',NULL,0,'admin');
/*!40000 ALTER TABLE `accounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `authors`
--

LOCK TABLES `authors` WRITE;
/*!40000 ALTER TABLE `authors` DISABLE KEYS */;
INSERT INTO `authors` VALUES (1,'Victor Hugo','Victor','Hugo'),(2,'Guy De Maupassant','Guy','De Maupassant'),(3,'Gustave Flaubert','Gustave','Flaubert'),(4,'Molière','Jean-Baptiste','Oquelin');
/*!40000 ALTER TABLE `authors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `copies`
--

LOCK TABLES `copies` WRITE;
/*!40000 ALTER TABLE `copies` DISABLE KEYS */;
INSERT INTO `copies` VALUES (1,_binary '','RVICTM-LD-1-1',NULL,1,1),(2,_binary '','RVICTM-LD-1-2',NULL,1,1),(3,_binary '\0','RVICTM-LD-2-1','2020-04-03',2,1),(4,_binary '\0','PVICTO-GA-2-1','2020-04-20',2,2),(5,_binary '\0','PVICTO-GA-2-2','2020-05-29',3,2),(6,_binary '\0','RGUYDB-BE-2-1','2020-04-22',2,3),(7,_binary '','RGUYDB-BE-3-1',NULL,3,3),(8,_binary '\0','TMOLIM-NA-1-1','2020-05-28',1,4),(9,_binary '\0','TMOLIM-NA-2-1','2020-05-28',2,4),(10,_binary '','TMOLIM-NA-2-2',NULL,2,4),(11,_binary '\0','TMOLIM-NA-3-1','2020-07-07',3,4),(12,_binary '','GEO-01-20-2-1',NULL,2,5),(13,_binary '','GEO-01-20-2-2',NULL,2,6),(14,_binary '','OBS-05-19-2-1',NULL,2,7),(15,_binary '','MOND-01-20-1-1',NULL,2,8),(16,_binary '','MOND-01-20-2-1',NULL,2,8),(17,_binary '\0','MOND-01-20-2-2','2020-05-28',2,8),(18,_binary '','MOND-02-20-3-1',NULL,2,9),(19,_binary '\0','MOND-02-20-3-2','2020-06-24',1,9),(20,_binary '','RVICTM-BE-3-1',NULL,3,10),(21,_binary '','RVICTM-BE-2-1',NULL,2,10),(22,_binary '','RVICTM-NA-2-1',NULL,2,11);
/*!40000 ALTER TABLE `copies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `editors`
--

LOCK TABLES `editors` WRITE;
/*!40000 ALTER TABLE `editors` DISABLE KEYS */;
INSERT INTO `editors` VALUES (1,'Ldp Jeunesse'),(2,'Gallimard'),(3,'Belin Éducation'),(4,'Nathan');
/*!40000 ALTER TABLE `editors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `libraries`
--

LOCK TABLES `libraries` WRITE;
/*!40000 ALTER TABLE `libraries` DISABLE KEYS */;
INSERT INTO `libraries` VALUES (1,'10 rue des écrivains','Le coin des lecteurs'),(2,'5 avenue de normandie','BMS'),(3,'2 rue Charles Péguy','Librairie Kleber');
/*!40000 ALTER TABLE `libraries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `loans`
--

LOCK TABLES `loans` WRITE;
/*!40000 ALTER TABLE `loans` DISABLE KEYS */;
INSERT INTO `loans` VALUES (1,1,'2020-02-15','FINISHED',1,'2020-04-15',1,1),(2,1,'2020-01-19','FINISHED',0,'2020-03-19',2,1),(3,0,'2020-03-22','INPROGRESS',3,'2020-04-22',6,2),(4,1,'2020-02-03','INPROGRESS',3,'2020-04-03',3,1),(5,1,'2020-02-20','INPROGRESS',3,'2020-04-20',4,1),(6,1,'2020-04-14','INPROGRESS',0,'2020-07-07',11,1),(7,0,'2020-04-30','FINISHED',0,'2020-05-28',15,2),(8,0,'2020-04-30','FINISHED',0,'2020-05-28',12,2),(9,1,'2020-04-30','INPROGRESS',0,'2020-06-24',19,2),(10,0,'2020-04-30','INPROGRESS',0,'2020-05-28',8,2),(11,0,'2020-04-30','INPROGRESS',0,'2020-05-28',9,2),(12,0,'2020-04-30','INPROGRESS',0,'2020-05-28',17,2),(13,0,'2020-05-01','INPROGRESS',0,'2020-05-29',5,2);
/*!40000 ALTER TABLE `loans` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `publications`
--

LOCK TABLES `publications` WRITE;
/*!40000 ALTER TABLE `publications` DISABLE KEYS */;
INSERT INTO `publications` VALUES (1,'BOOK','2010008995',2,3,'2014-01-01','NOVEL','Les misérables',1,1),(2,'BOOK','2070321908',0,2,'2015-01-01','POETRY','Odes et Ballades',1,2),(3,'BOOK','2701151589',1,2,'2019-01-01','NOVEL','Bel-Ami',2,3),(4,'BOOK',' 978-2-09-188737-1',1,4,'2018-01-01','THEATER','Le médecin malgé lui',4,4),(5,'REVIEW','dsfdgh',1,1,'2020-01-01','SCIENTIST','Geo',NULL,NULL),(6,'REVIEW','ereterh',1,1,'2020-02-01','SCIENTIST','Geo',NULL,NULL),(7,'REVIEW','ereterh',1,1,'2020-01-01','NEWS','L\'Obs',NULL,NULL),(8,'NEWSPAPER','ereterh',2,3,'2020-01-01','NATIONAL','Le Monde',NULL,NULL),(9,'NEWSPAPER','ereterh',1,2,'2020-02-01','NATIONAL','Le Monde',NULL,NULL),(10,'BOOK','2010008995',2,2,'2014-01-01','NOVEL','Les misérables',1,3),(11,'BOOK','DEWDEDF',1,1,'2014-01-01','NOVEL','Les misérables',1,4);
/*!40000 ALTER TABLE `publications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'db_library'
--

--
-- Dumping routines for database 'db_library'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-03 20:06:22
