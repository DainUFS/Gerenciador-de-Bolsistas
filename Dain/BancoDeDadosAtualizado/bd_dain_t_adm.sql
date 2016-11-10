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
-- Table structure for table `t_adm`
--

DROP TABLE IF EXISTS `t_adm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_adm` (
  `a_matricula` varchar(8) NOT NULL,
  `a_nome` varchar(45) NOT NULL,
  `a_email` varchar(45) NOT NULL,
  `a_telefone` varchar(15) NOT NULL,
  `a_status` int(11) NOT NULL,
  `a_senha` varchar(45) NOT NULL,
  PRIMARY KEY (`a_matricula`),
  UNIQUE KEY `a_matricula_UNIQUE` (`a_matricula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_adm`
--

LOCK TABLES `t_adm` WRITE;
/*!40000 ALTER TABLE `t_adm` DISABLE KEYS */;
INSERT INTO `t_adm` VALUES ('123','Murilo dos Bugs','@cuscuz.com','741',1,'123'),('12345','Szzana','@susana.com','56754656746546',1,'12345'),('21','Tarantino','@KillBill','78451235',0,'21'),('32509874','Kubrick','@odisseia','113456',1,'789456'),('44444444','Kiko','@tesouro.com','5585416',0,'555'),('matricZ','nomeZ','emailZ','telZ',1,'1'),('wef','eqwfew','efwe','ef',1,'feewq');
/*!40000 ALTER TABLE `t_adm` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-10 10:34:11
