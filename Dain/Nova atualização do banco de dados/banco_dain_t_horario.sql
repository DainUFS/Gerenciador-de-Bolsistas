-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: banco_dain
-- ------------------------------------------------------
-- Server version	5.7.16-log

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
-- Table structure for table `t_horario`
--

DROP TABLE IF EXISTS `t_horario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_horario` (
  `h_id` int(11) NOT NULL AUTO_INCREMENT,
  `h_segunda` varchar(260) DEFAULT NULL,
  `h_terca` varchar(260) DEFAULT NULL,
  `h_quarta` varchar(260) DEFAULT NULL,
  `h_quinta` varchar(260) DEFAULT NULL,
  `h_sexta` varchar(260) DEFAULT NULL,
  `h_sabado` varchar(260) DEFAULT NULL,
  PRIMARY KEY (`h_id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_horario`
--

LOCK TABLES `t_horario` WRITE;
/*!40000 ALTER TABLE `t_horario` DISABLE KEYS */;
INSERT INTO `t_horario` VALUES (22,'11:00h - 12:00h|10:00h - 11:00h|09:00h - 10:00h|08:00h - 09:00h|07:00h - 08:00h|','16:00h - 17:00h|15:00h - 16:00h|14:00h - 15:00h|13:00h - 14:00h|12:00h - 13:00h|','21:00h - 22:00h|20:00h - 21:00h|19:00h - 20:00h|18:00h - 19:00h|17:00h - 18:00h|','18:00h - 19:00h|19:00h - 20:00h|20:00h - 21:00h|21:00h - 22:00h|22:00h - 23:00h|','13:00h - 14:00h|14:00h - 15:00h|15:00h - 16:00h|16:00h - 17:00h|17:00h - 18:00h|','08:00h - 09:00h|09:00h - 10:00h|10:00h - 11:00h|11:00h - 12:00h|12:00h - 13:00h|'),(23,'12:00h - 13:00h|11:00h - 12:00h|10:00h - 11:00h|09:00h - 10:00h|08:00h - 09:00h|07:00h - 08:00h|','12:00h - 13:00h|11:00h - 12:00h|10:00h - 11:00h|09:00h - 10:00h|08:00h - 09:00h|07:00h - 08:00h|','12:00h - 13:00h|11:00h - 12:00h|10:00h - 11:00h|09:00h - 10:00h|08:00h - 09:00h|07:00h - 08:00h|','12:00h - 13:00h|11:00h - 12:00h|10:00h - 11:00h|09:00h - 10:00h|08:00h - 09:00h|07:00h - 08:00h|','12:00h - 13:00h|11:00h - 12:00h|10:00h - 11:00h|09:00h - 10:00h|08:00h - 09:00h|07:00h - 08:00h|','12:00h - 13:00h|11:00h - 12:00h|10:00h - 11:00h|09:00h - 10:00h|08:00h - 09:00h|07:00h - 08:00h|'),(24,'15:00h - 16:00h|14:00h - 15:00h|13:00h - 14:00h|12:00h - 13:00h|11:00h - 12:00h|10:00h - 11:00h|09:00h - 10:00h|08:00h - 09:00h|07:00h - 08:00h|','15:00h - 16:00h|14:00h - 15:00h|13:00h - 14:00h|12:00h - 13:00h|11:00h - 12:00h|10:00h - 11:00h|09:00h - 10:00h|08:00h - 09:00h|07:00h - 08:00h|','15:00h - 16:00h|14:00h - 15:00h|13:00h - 14:00h|12:00h - 13:00h|11:00h - 12:00h|10:00h - 11:00h|09:00h - 10:00h|08:00h - 09:00h|07:00h - 08:00h|','15:00h - 16:00h|14:00h - 15:00h|13:00h - 14:00h|12:00h - 13:00h|11:00h - 12:00h|10:00h - 11:00h|09:00h - 10:00h|08:00h - 09:00h|07:00h - 08:00h|','15:00h - 16:00h|14:00h - 15:00h|13:00h - 14:00h|12:00h - 13:00h|11:00h - 12:00h|10:00h - 11:00h|09:00h - 10:00h|08:00h - 09:00h|07:00h - 08:00h|','15:00h - 16:00h|14:00h - 15:00h|13:00h - 14:00h|12:00h - 13:00h|11:00h - 12:00h|10:00h - 11:00h|09:00h - 10:00h|08:00h - 09:00h|07:00h - 08:00h|'),(25,'17:00h - 18:00h|16:00h - 17:00h|15:00h - 16:00h|14:00h - 15:00h|13:00h - 14:00h|12:00h - 13:00h|11:00h - 12:00h|10:00h - 11:00h|09:00h - 10:00h|08:00h - 09:00h|07:00h - 08:00h|','17:00h - 18:00h|16:00h - 17:00h|15:00h - 16:00h|14:00h - 15:00h|13:00h - 14:00h|12:00h - 13:00h|11:00h - 12:00h|10:00h - 11:00h|09:00h - 10:00h|08:00h - 09:00h|07:00h - 08:00h|','17:00h - 18:00h|16:00h - 17:00h|15:00h - 16:00h|14:00h - 15:00h|13:00h - 14:00h|12:00h - 13:00h|11:00h - 12:00h|10:00h - 11:00h|09:00h - 10:00h|08:00h - 09:00h|07:00h - 08:00h|','17:00h - 18:00h|16:00h - 17:00h|15:00h - 16:00h|14:00h - 15:00h|13:00h - 14:00h|12:00h - 13:00h|11:00h - 12:00h|10:00h - 11:00h|09:00h - 10:00h|08:00h - 09:00h|07:00h - 08:00h|','17:00h - 18:00h|16:00h - 17:00h|15:00h - 16:00h|14:00h - 15:00h|13:00h - 14:00h|12:00h - 13:00h|11:00h - 12:00h|10:00h - 11:00h|09:00h - 10:00h|08:00h - 09:00h|07:00h - 08:00h|','17:00h - 18:00h|16:00h - 17:00h|15:00h - 16:00h|14:00h - 15:00h|13:00h - 14:00h|12:00h - 13:00h|11:00h - 12:00h|10:00h - 11:00h|09:00h - 10:00h|08:00h - 09:00h|07:00h - 08:00h|'),(51,'07:00h - 08:00h|','','','','','');
/*!40000 ALTER TABLE `t_horario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-25  0:17:52
