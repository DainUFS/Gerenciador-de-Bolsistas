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
-- Table structure for table `t_deficiente`
--

DROP TABLE IF EXISTS `t_deficiente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_deficiente` (
  `d_matricula` varchar(12) NOT NULL,
  `d_nome` varchar(45) NOT NULL,
  `d_telefone` varchar(15) NOT NULL,
  `d_email` varchar(45) NOT NULL,
  `d_curso` varchar(30) NOT NULL,
  `d_sexo` char(1) NOT NULL,
  `d_tipoDeficiencia` varchar(30) NOT NULL,
  `d_fk_adm` varchar(8) DEFAULT NULL,
  `d_fk_horario` int(11) DEFAULT NULL,
  PRIMARY KEY (`d_matricula`),
  UNIQUE KEY `d_matricula_UNIQUE` (`d_matricula`),
  KEY `fk_adm_idx` (`d_fk_adm`),
  KEY `fk_horario_idx` (`d_fk_horario`),
  CONSTRAINT `fk_adm` FOREIGN KEY (`d_fk_adm`) REFERENCES `t_adm` (`a_matricula`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_horario` FOREIGN KEY (`d_fk_horario`) REFERENCES `t_horario` (`h_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_deficiente`
--

LOCK TABLES `t_deficiente` WRITE;
/*!40000 ALTER TABLE `t_deficiente` DISABLE KEYS */;
INSERT INTO `t_deficiente` VALUES ('20122012','Tarantino','09876543','@souSangrento','Pulp Fiction','M','sangue','32509874',22),('789456','77 54852363','@murilo.com','João das neve','Cuscuz','M','Viadagem','21',23),('matricY','nomeY','telY','emailY','cursoY','F','Transpira viadagem','12345',24),('odisseia2001','Stanley Kubrick','987455452','@kubrick','Iluminado','M','louco','32509874',25);
/*!40000 ALTER TABLE `t_deficiente` ENABLE KEYS */;
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
