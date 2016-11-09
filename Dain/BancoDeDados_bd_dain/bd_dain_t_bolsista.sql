-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: bd_dain
-- ------------------------------------------------------
-- Server version	5.7.15-log

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
-- Table structure for table `t_bolsista`
--

DROP TABLE IF EXISTS `t_bolsista`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_bolsista` (
  `b_matricula` varchar(12) NOT NULL,
  `b_nome` varchar(45) NOT NULL,
  `b_telefone` varchar(15) NOT NULL,
  `b_email` varchar(45) NOT NULL,
  `b_curso` varchar(30) NOT NULL,
  `b_sexo` char(1) NOT NULL,
  `b_atividade` varchar(45) DEFAULT NULL,
  `b_fk_adm` varchar(45) DEFAULT NULL,
  `b_fk_horario` int(11) DEFAULT NULL,
  PRIMARY KEY (`b_matricula`),
  UNIQUE KEY `b_matricula_UNIQUE` (`b_matricula`),
  KEY `b_fk_horario_idx` (`b_fk_horario`),
  KEY `b_fk_adm_idx` (`b_fk_adm`),
  CONSTRAINT `b_fk_adm` FOREIGN KEY (`b_fk_adm`) REFERENCES `t_adm` (`a_matricula`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `b_fk_horario` FOREIGN KEY (`b_fk_horario`) REFERENCES `t_horario` (`h_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_bolsista`
--

LOCK TABLES `t_bolsista` WRITE;
/*!40000 ALTER TABLE `t_bolsista` DISABLE KEYS */;
INSERT INTO `t_bolsista` VALUES ('6543','Stanley Kubrick','369852','@murilo_de_milho','CC','F',NULL,'12345',44),('789456123','Billy Wilder','@icaro','Icaro','Ciência','F',NULL,'12345',23),('matricX','Stiven Spelberg','telX','emailX','cursoX','M',NULL,'12345',24);
/*!40000 ALTER TABLE `t_bolsista` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-09 11:55:10
