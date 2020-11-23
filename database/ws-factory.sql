-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: ws-factory
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `addstock`
--

DROP TABLE IF EXISTS `addstock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `addstock` (
  `id_addstock` int NOT NULL AUTO_INCREMENT,
  `id_product` int DEFAULT NULL,
  `amount` int DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id_addstock`),
  KEY `id_product` (`id_product`),
  CONSTRAINT `addstock_ibfk_1` FOREIGN KEY (`id_product`) REFERENCES `product` (`id_product`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addstock`
--

LOCK TABLES `addstock` WRITE;
/*!40000 ALTER TABLE `addstock` DISABLE KEYS */;
INSERT INTO `addstock` VALUES (1,1,10,'Delivered'),(2,2,30,'Delivered'),(3,3,10,'Pending'),(4,6,15,'Delivered'),(5,5,10,'Pending');
/*!40000 ALTER TABLE `addstock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `balance`
--

DROP TABLE IF EXISTS `balance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `balance` (
  `balance_amount` decimal(20,2) NOT NULL,
  PRIMARY KEY (`balance_amount`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `balance`
--

LOCK TABLES `balance` WRITE;
/*!40000 ALTER TABLE `balance` DISABLE KEYS */;
INSERT INTO `balance` VALUES (50000000.00);
/*!40000 ALTER TABLE `balance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingredient`
--

DROP TABLE IF EXISTS `ingredient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingredient` (
  `id_ingredient` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_ingredient`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredient`
--

LOCK TABLES `ingredient` WRITE;
/*!40000 ALTER TABLE `ingredient` DISABLE KEYS */;
INSERT INTO `ingredient` VALUES (1,'Gula'),(2,'Cocoa Powder'),(3,'Kacang Mede'),(4,'Wall Nut'),(5,'Susu'),(6,'Vanili'),(7,'Bubuk Green Tea'),(8,'Esens Stroberi'),(9,'Biji Coklat'),(10,'Butter');
/*!40000 ALTER TABLE `ingredient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingredient_details`
--

DROP TABLE IF EXISTS `ingredient_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingredient_details` (
  `id_ingredient` int NOT NULL,
  `expiry_date` date NOT NULL,
  `stock` decimal(10,1) DEFAULT NULL,
  PRIMARY KEY (`id_ingredient`,`expiry_date`),
  CONSTRAINT `ingredient_details_ibfk_1` FOREIGN KEY (`id_ingredient`) REFERENCES `ingredient` (`id_ingredient`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredient_details`
--

LOCK TABLES `ingredient_details` WRITE;
/*!40000 ALTER TABLE `ingredient_details` DISABLE KEYS */;
INSERT INTO `ingredient_details` VALUES (1,'2021-01-01',400.0),(2,'2020-12-02',200.0),(3,'2020-11-30',300.0),(4,'2020-12-25',1000.0),(5,'2020-12-26',400.0),(6,'2020-12-24',100.0),(7,'2020-12-30',400.0),(8,'2020-12-22',350.0),(9,'2021-01-01',3000.0),(10,'2020-12-23',300.0);
/*!40000 ALTER TABLE `ingredient_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id_product` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `stock` int DEFAULT NULL,
  PRIMARY KEY (`id_product`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Dark Chocolate',20),(2,'Plain White Chocolate',30),(3,'Great Value White Chocolate',30),(4,'Classic Milk Chocolate',25),(5,'Lindo Milk Chocolate',10),(6,'Greentea Choco',50),(7,'Nut Chocolate',30),(8,'Strawberry Chocolate',40),(9,'Pink Kitkat',15),(10,'Kinder Bueno',10),(11,'Baking chocolate',40),(12,'Hershey',25);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recipe`
--

DROP TABLE IF EXISTS `recipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recipe` (
  `id_product` int NOT NULL,
  `id_ingredient` int NOT NULL,
  `amount_need` decimal(8,1) DEFAULT NULL,
  PRIMARY KEY (`id_product`,`id_ingredient`),
  KEY `id_ingredient` (`id_ingredient`),
  CONSTRAINT `recipe_ibfk_1` FOREIGN KEY (`id_product`) REFERENCES `product` (`id_product`),
  CONSTRAINT `recipe_ibfk_2` FOREIGN KEY (`id_ingredient`) REFERENCES `ingredient` (`id_ingredient`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recipe`
--

LOCK TABLES `recipe` WRITE;
/*!40000 ALTER TABLE `recipe` DISABLE KEYS */;
INSERT INTO `recipe` VALUES (1,1,0.1),(1,6,0.2),(1,9,0.5),(2,1,0.3),(2,5,0.5),(2,9,0.5),(3,1,0.3),(3,5,0.8),(3,9,0.8),(4,1,0.3),(4,5,1.0),(4,6,0.2),(4,9,0.5),(5,1,0.3),(5,5,1.0),(5,9,0.6),(5,10,0.2),(6,1,0.2),(6,7,0.5),(6,9,0.5),(7,1,0.5),(7,3,0.1),(7,4,0.1),(7,9,0.4),(8,1,0.5),(8,8,0.1),(8,9,0.4),(8,10,0.2),(9,1,0.8),(9,8,0.5),(9,9,0.2),(9,10,0.2),(10,1,0.8),(10,2,0.2),(10,4,0.2),(10,9,0.2),(10,10,0.1),(11,1,0.2),(11,9,1.0),(12,1,0.8),(12,3,0.2),(12,9,0.5),(12,10,0.1);
/*!40000 ALTER TABLE `recipe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id_user` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `PASSWORD` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_user`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'orangecat','orangecat'),(2,'croquette','croquette');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-23 22:09:50
