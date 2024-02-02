CREATE DATABASE  IF NOT EXISTS `test_spring_boot_rest1` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `test_spring_boot_rest1`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: test_spring_boot_rest1
-- ------------------------------------------------------
-- Server version	5.6.51-log

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
-- Table structure for table `ventas_sucursales`
--

DROP TABLE IF EXISTS `ventas_sucursales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ventas_sucursales` (
  `venta_id` bigint(20) NOT NULL,
  `sucursal_id` bigint(20) NOT NULL,
  PRIMARY KEY (`venta_id`,`sucursal_id`),
  KEY `FKrdwq38tcg6cxdyvk3g8wrdjkc` (`sucursal_id`),
  CONSTRAINT `FKnys62otkk4s2csqdk8hxq9jrk` FOREIGN KEY (`venta_id`) REFERENCES `ventas` (`venta_id`),
  CONSTRAINT `FKrdwq38tcg6cxdyvk3g8wrdjkc` FOREIGN KEY (`sucursal_id`) REFERENCES `sucursales` (`sucursal_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ventas_sucursales`
--

LOCK TABLES `ventas_sucursales` WRITE;
/*!40000 ALTER TABLE `ventas_sucursales` DISABLE KEYS */;
/*!40000 ALTER TABLE `ventas_sucursales` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-02 17:28:09
