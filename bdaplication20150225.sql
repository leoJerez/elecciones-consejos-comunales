-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: bdaplication
-- ------------------------------------------------------
-- Server version	5.6.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `habitante`
--

DROP TABLE IF EXISTS `habitante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `habitante` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `cedula` varchar(12) COLLATE utf8_bin NOT NULL DEFAULT '',
  `nombre` varchar(25) COLLATE utf8_bin DEFAULT NULL,
  `apellido` varchar(25) COLLATE utf8_bin DEFAULT NULL,
  `sexo` varchar(10) COLLATE utf8_bin DEFAULT NULL,
  `numerocasa` varchar(20) COLLATE utf8_bin NOT NULL,
  `fechanacimiento` date DEFAULT NULL,
  `telefonofijo` varchar(15) COLLATE utf8_bin DEFAULT NULL,
  `telefonomovil` varchar(15) COLLATE utf8_bin DEFAULT NULL,
  `correo` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `version` int(10) DEFAULT NULL,
  `estatus` varchar(1) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `habitante`
--

LOCK TABLES `habitante` WRITE;
/*!40000 ALTER TABLE `habitante` DISABLE KEYS */;
INSERT INTO `habitante` VALUES (1,'V-24159783','Alejandra','Pachano','FEMENINO','261','1994-05-03','04265522782','04264500066','arinica@hotmail.com',1,'A'),(2,'V-20670506','Roberth','Borges','MASCULINO','45-66-B','1991-08-20','02512613912','04166535663','roberthebt@gmail.com',1,'A'),(3,'V-23537796','Jose','Borges','MASCULINO','45-66-B','1995-09-07','02512613912','12345','miurix',1,'A'),(4,'V-20670505','Ana','Borges','FEMENINO','45-66-B','1992-10-24','02512613912','','',1,'A'),(5,'V-7462165','Yelitza','Torres','FEMENINO','45-66-B','1962-10-14','02512613912','','',1,'A'),(10,'V-7462164','Saul','Torres','MASCULINO','123','2015-02-25','12345','54321','saul.torres@gmail.com',1,'A');
/*!40000 ALTER TABLE `habitante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'bdaplication'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-02-25  2:33:37
