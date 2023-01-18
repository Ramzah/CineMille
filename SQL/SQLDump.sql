CREATE DATABASE  IF NOT EXISTS `cinemille` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `cinemille`;
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: cinemille
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `film`
--

DROP TABLE IF EXISTS `film`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `film` (
  `id` int NOT NULL AUTO_INCREMENT,
  `titolo` varchar(100) NOT NULL COMMENT 'Titolo del film',
  `genere` varchar(45) NOT NULL COMMENT 'Genere/i del film (commedia, horror, azione, etc)',
  `regia` varchar(45) NOT NULL COMMENT 'Nome regista/i del film',
  `cast` varchar(200) NOT NULL COMMENT 'Cast principale del film',
  `flag_3d` tinyint DEFAULT NULL COMMENT 'Flag per identificare se il film in programmazione è in 2D o 3D',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Storico film in programmazione nel cinema CineMille di Firenze';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `film`
--

LOCK TABLES `film` WRITE;
/*!40000 ALTER TABLE `film` DISABLE KEYS */;
INSERT INTO `film` VALUES (1,'Il signore degli anelli - La compagnia dell\'anello','Avventura, Fantasy, Azione','Peter Jackson','Elijah Wood, Ian McKellen, Viggo Mortensen, Sean Astin, Billy Boyd, Dominic Monaghan, John Rhys-Davies, Orlando Bloom, Sean Bean, Hugo Weaving, Christopher Lee',0),(2,'Il signore degli anelli - La compagnia dell\'anello','Avventura, Fantasy, Azione','Peter Jackson','Elijah Wood, Ian McKellen, Viggo Mortensen, Sean Astin, Billy Boyd, Dominic Monaghan, John Rhys-Davies, Orlando Bloom, Sean Bean, Hugo Weaving, Christopher Lee',1),(3,'Il signore degli anelli - Le due torri','Avventura, Fantasy, Azione','Peter Jackson','Elijah Wood, Ian McKellen, Viggo Mortensen, Sean Astin, Billy Boyd, Dominic Monaghan, John Rhys-Davies, Orlando Bloom, Sean Bean, Hugo Weaving, Christopher Lee',0),(4,'Il signore degli anelli - Le due torri','Avventura, Fantasy, Azione','Peter Jackson','Elijah Wood, Ian McKellen, Viggo Mortensen, Sean Astin, Billy Boyd, Dominic Monaghan, John Rhys-Davies, Orlando Bloom, Sean Bean, Hugo Weaving, Christopher Lee',1),(5,'Il signore degli anelli - Il ritorno del re','Avventura, Fantasy, Azione','Peter Jackson','Elijah Wood, Ian McKellen, Viggo Mortensen, Sean Astin, Billy Boyd, Dominic Monaghan, John Rhys-Davies, Orlando Bloom, Sean Bean, Hugo Weaving, Christopher Lee',0),(6,'Il signore degli anelli - Il ritorno del re','Avventura, Fantasy, Azione','Peter Jackson','Elijah Wood, Ian McKellen, Viggo Mortensen, Sean Astin, Billy Boyd, Dominic Monaghan, John Rhys-Davies, Orlando Bloom, Sean Bean, Hugo Weaving, Christopher Lee',1),(7,'Star Wars: Episodio IV - Una nuova speranza','Fantascienza, Avventura, Azione, Fantastico','George Lucas','Mark Hamill, Harrison Ford, Carrie Fisher, Peter Cushing, Alec Guinness, Anthony Daniels, Kenny Baker, Peter Mayhew, David Prowse',0),(8,'Star Wars: Episodio V - L\'Impero colpisce ancora','Fantascienza, Avventura, Azione, Fantastico','George Lucas','Mark Hamill, Harrison Ford, Carrie Fisher, Peter Cushing, Alec Guinness, Anthony Daniels, Kenny Baker, Peter Mayhew, David Prowse',0),(9,'Star Wars: Episodio VI - Il ritorno dello Jedi','Fantascienza, Avventura, Azione, Fantastico','George Lucas','Mark Hamill, Harrison Ford, Carrie Fisher, Peter Cushing, Alec Guinness, Anthony Daniels, Kenny Baker, Peter Mayhew, David Prowse',0),(10,'Blade Runner','Fantascienza, Dramma, Thriller','Ridley Scott','Harrison Ford, Rutger Hauer, Sean Young, Edward James Olmos, M. Emmet Walsh, Daryl Hannah, William Sanderson, Brion James, Joe Turkel',0),(11,'Blade Runner','Fantascienza, Dramma, Thriller','Ridley Scott','Harrison Ford, Rutger Hauer, Sean Young, Edward James Olmos, M. Emmet Walsh, Daryl Hannah, William Sanderson, Brion James, Joe Turkel',1),(12,'Matrix','Azione, Fantascienza','Lilly e Lana Wachowski','Keanu Reeves, Laurence Fishburne, Carrie-Anna Moss, Hugo Weaving, Joe Pantoliano, Marcus Chong, Anthony Ray Parker, Matt Doran, Gloria Foster',0),(13,'Matrix Reloaded','Azione, Fantascienza','Lilly e Lana Wachowski','Keanu Reeves, Laurence Fishburne, Carrie-Anna Moss, Hugo Weaving, Joe Pantoliano, Marcus Chong, Anthony Ray Parker, Matt Doran, Gloria Foster',0),(14,'Matrix Revolutions','Azione, Fantascienza','Lilly e Lana Wachowski','Keanu Reeves, Laurence Fishburne, Carrie-Anna Moss, Hugo Weaving, Joe Pantoliano, Marcus Chong, Anthony Ray Parker, Matt Doran, Gloria Foster',0),(15,'Dune','Azione, Fantascienza, Avventura','David Lynch','Kyle MacLachlan, Francesca Annis, Patrick Stewart, Linda Hunt, José Ferrer, Leonardo Cimino, Freddie Jones, Brad Dourif, Richard Jordan',0),(16,'Harry Potter e la pietra filosofale','Avventura, Fantasy','Chris Columbus','Daniel Radcliffe, Rupert Grint, Emma Watson, Richard Harris, Tom Felton, Alan Rickman, Maggie Smith, Richard Griffiths',0),(17,'Harry Potter e la camera dei segreti','Avventura, Fantasy','Chris Columbus','Daniel Radcliffe, Rupert Grint, Emma Watson, Richard Harris, Tom Felton, Alan Rickman, Maggie Smith, Richard Griffiths',0),(18,'Harry Potter e il calice di fuoco','Avventura, Fantasy','Chris Columbus','Daniel Radcliffe, Rupert Grint, Emma Watson, Richard Harris, Tom Felton, Alan Rickman, Maggie Smith, Richard Griffiths',0),(19,'Harry Potter e il prigioniero di Azkaban','Avventura, Fantasy','Chris Columbus','Daniel Radcliffe, Rupert Grint, Emma Watson, Richard Harris, Tom Felton, Alan Rickman, Maggie Smith, Richard Griffiths',0),(20,'Harry Potter e l\'ordine della fenice','Avventura, Fantasy','Chris Columbus','Daniel Radcliffe, Rupert Grint, Emma Watson, Richard Harris, Tom Felton, Alan Rickman, Maggie Smith, Richard Griffiths',0),(21,'Harry Potter e i doni della morte','Avventura, Fantasy','Chris Columbus','Daniel Radcliffe, Rupert Grint, Emma Watson, Richard Harris, Tom Felton, Alan Rickman, Maggie Smith, Richard Griffiths',0),(22,'Harry Potter e il principe mezzosangue','Avventura, Fantasy','Chris Columbus','Daniel Radcliffe, Rupert Grint, Emma Watson, Richard Harris, Tom Felton, Alan Rickman, Maggie Smith, Richard Griffiths',0);
/*!40000 ALTER TABLE `film` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `programmazione`
--

DROP TABLE IF EXISTS `programmazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `programmazione` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_sala` int NOT NULL,
  `id_film` int NOT NULL,
  `data_orario` datetime NOT NULL COMMENT 'Data e orario di programmazione di un film in una determinata sala.',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `_idx` (`id_sala`),
  KEY `id_film_idx` (`id_film`),
  CONSTRAINT `id_film` FOREIGN KEY (`id_film`) REFERENCES `film` (`id`),
  CONSTRAINT `id_sala` FOREIGN KEY (`id_sala`) REFERENCES `sale` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `programmazione`
--

LOCK TABLES `programmazione` WRITE;
/*!40000 ALTER TABLE `programmazione` DISABLE KEYS */;
INSERT INTO `programmazione` VALUES (1,1,1,'2023-01-13 14:00:00'),(2,1,3,'2023-01-13 17:00:00'),(3,1,5,'2023-01-13 20:00:00'),(4,1,10,'2023-01-13 23:00:00'),(5,2,2,'2023-01-13 14:00:00'),(6,2,4,'2023-01-13 17:00:00'),(7,2,6,'2023-01-13 20:00:00'),(8,2,11,'2023-01-13 23:00:00'),(9,3,7,'2023-01-13 14:00:00'),(10,3,7,'2023-01-13 17:00:00'),(11,3,7,'2023-01-13 20:00:00'),(12,3,7,'2023-01-13 23:00:00'),(13,4,8,'2023-01-13 14:00:00'),(14,4,8,'2023-01-13 17:00:00'),(15,4,8,'2023-01-13 20:00:00'),(16,4,8,'2023-01-13 23:00:00'),(17,5,9,'2023-01-13 14:00:00'),(18,5,9,'2023-01-13 17:00:00'),(19,5,9,'2023-01-13 20:00:00'),(20,5,9,'2023-01-13 23:00:00'),(21,6,12,'2023-01-13 14:00:00'),(22,6,12,'2023-01-13 17:00:00'),(23,6,12,'2023-01-13 20:00:00'),(24,6,12,'2023-01-13 23:00:00'),(25,7,13,'2023-01-13 14:00:00'),(26,7,13,'2023-01-13 17:00:00'),(27,7,13,'2023-01-13 20:00:00'),(28,7,13,'2023-01-13 23:00:00'),(29,8,14,'2023-01-13 14:00:00'),(30,8,14,'2023-01-13 17:00:00'),(31,8,14,'2023-01-13 20:00:00'),(32,8,14,'2023-01-13 23:00:00'),(33,9,15,'2023-01-13 14:00:00'),(34,9,15,'2023-01-13 17:00:00'),(35,9,15,'2023-01-13 20:00:00'),(36,9,15,'2023-01-13 23:00:00'),(37,10,16,'2023-01-13 14:00:00'),(38,10,16,'2023-01-13 17:00:00'),(39,10,16,'2023-01-13 20:00:00'),(40,10,16,'2023-01-13 23:00:00'),(41,11,17,'2023-01-13 14:00:00'),(42,11,17,'2023-01-13 17:00:00'),(43,11,17,'2023-01-13 20:00:00'),(44,11,17,'2023-01-13 23:00:00'),(45,12,18,'2023-01-13 14:00:00'),(46,12,18,'2023-01-13 17:00:00'),(47,12,18,'2023-01-13 20:00:00'),(48,12,18,'2023-01-13 23:00:00');
/*!40000 ALTER TABLE `programmazione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sale`
--

DROP TABLE IF EXISTS `sale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sale` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome_sala` varchar(45) NOT NULL COMMENT 'Nome identificativo della sala di proiezione',
  `capienza` int NOT NULL COMMENT 'Numero di posti a sedere massimi',
  `imax` tinyint DEFAULT NULL COMMENT 'Flag per identificare le sale con tecnologia IMAX',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `nome_sala_UNIQUE` (`nome_sala`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale`
--

LOCK TABLES `sale` WRITE;
/*!40000 ALTER TABLE `sale` DISABLE KEYS */;
INSERT INTO `sale` VALUES (1,'Sala 1',250,0),(2,'Sala 2',200,0),(3,'Sala 3',180,0),(4,'Sala 4',50,0),(5,'Sala 5',100,0),(6,'Sala 6',150,0),(7,'Sala 7',200,0),(8,'Sala 8',160,0),(9,'Sala 9',120,0),(10,'Sala 10',250,0),(11,'Sala 11',250,1),(12,'Sala 12',150,1);
/*!40000 ALTER TABLE `sale` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-17  18:16:30
