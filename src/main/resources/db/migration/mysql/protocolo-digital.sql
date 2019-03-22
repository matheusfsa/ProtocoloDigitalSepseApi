-- MySQL dump 10.13  Distrib 5.7.21, for Linux (x86_64)
--
-- Host: localhost    Database: protocolo-digital
-- ------------------------------------------------------
-- Server version	5.7.21-1

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
-- Table structure for table `AvEnfOp`
--

DROP TABLE IF EXISTS `AvEnfOp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `AvEnfOp` (
  `id_av` int(11) NOT NULL,
  `tipo` int(11) NOT NULL,
  `opcao` varchar(120) NOT NULL,
  PRIMARY KEY (`id_av`),
  CONSTRAINT `fk_AvEnfOp_1` FOREIGN KEY (`id_av`) REFERENCES `AvaliacaoEnfermeiro` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AvEnfOp`
--

LOCK TABLES `AvEnfOp` WRITE;
/*!40000 ALTER TABLE `AvEnfOp` DISABLE KEYS */;
/*!40000 ALTER TABLE `AvEnfOp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `AvMedOp`
--

DROP TABLE IF EXISTS `AvMedOp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `AvMedOp` (
  `id_av` int(11) NOT NULL,
  `tipo` int(11) NOT NULL,
  `opcao` varchar(100) NOT NULL,
  PRIMARY KEY (`id_av`,`tipo`,`opcao`),
  CONSTRAINT `fk_AvMedOp_1` FOREIGN KEY (`id_av`) REFERENCES `AvaliacaoMedico` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AvMedOp`
--

LOCK TABLES `AvMedOp` WRITE;
/*!40000 ALTER TABLE `AvMedOp` DISABLE KEYS */;
/*!40000 ALTER TABLE `AvMedOp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `AvaliacaoEnfermeiro`
--

DROP TABLE IF EXISTS `AvaliacaoEnfermeiro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `AvaliacaoEnfermeiro` (
  `crem` varchar(20) NOT NULL,
  `registro` varchar(20) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `fk_AvaliacaoEnfermeiro_1_idx` (`crem`),
  KEY `fk_AvaliacaoEnfermeiro_2_idx` (`registro`),
  CONSTRAINT `fk_AvaliacaoEnfermeiro_1` FOREIGN KEY (`crem`) REFERENCES `Enfermeiro` (`crem`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_AvaliacaoEnfermeiro_2` FOREIGN KEY (`registro`) REFERENCES `Paciente` (`registro`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AvaliacaoEnfermeiro`
--

LOCK TABLES `AvaliacaoEnfermeiro` WRITE;
/*!40000 ALTER TABLE `AvaliacaoEnfermeiro` DISABLE KEYS */;
/*!40000 ALTER TABLE `AvaliacaoEnfermeiro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `AvaliacaoMedico`
--

DROP TABLE IF EXISTS `AvaliacaoMedico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `AvaliacaoMedico` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `CRM` varchar(20) NOT NULL,
  `registro` varchar(20) NOT NULL,
  `procedencia` int(11) DEFAULT NULL,
  `resultado` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_AvaliacaoMedico_1_idx` (`CRM`),
  KEY `fk_AvaliacaoMedico_2_idx` (`registro`),
  CONSTRAINT `fk_AvaliacaoMedico_1` FOREIGN KEY (`CRM`) REFERENCES `Medico` (`CRM`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_AvaliacaoMedico_2` FOREIGN KEY (`registro`) REFERENCES `Paciente` (`registro`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `AvaliacaoMedico`
--

LOCK TABLES `AvaliacaoMedico` WRITE;
/*!40000 ALTER TABLE `AvaliacaoMedico` DISABLE KEYS */;
/*!40000 ALTER TABLE `AvaliacaoMedico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CheckList`
--

DROP TABLE IF EXISTS `CheckList`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `CheckList` (
  `id` int(11) NOT NULL,
  `data_diag` datetime NOT NULL,
  `reg_paciente` varchar(20) NOT NULL,
  `nick_prof` varchar(20) NOT NULL,
  `data_inicio` datetime DEFAULT NULL,
  `data_fim` datetime DEFAULT NULL,
  `comentario` varchar(145) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_CheckList_1_idx` (`reg_paciente`),
  KEY `fk_CheckList_2_idx` (`nick_prof`),
  CONSTRAINT `fk_CheckList_1` FOREIGN KEY (`reg_paciente`) REFERENCES `Paciente` (`registro`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `fk_CheckList_2` FOREIGN KEY (`nick_prof`) REFERENCES `ProfissionalSaude` (`nick_name`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CheckList`
--

LOCK TABLES `CheckList` WRITE;
/*!40000 ALTER TABLE `CheckList` DISABLE KEYS */;
/*!40000 ALTER TABLE `CheckList` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Conduta`
--

DROP TABLE IF EXISTS `Conduta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Conduta` (
  `id_avaliacao` int(11) NOT NULL,
  `data` datetime NOT NULL,
  `descricao` varchar(120) NOT NULL,
  `executada` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_avaliacao`,`data`,`descricao`),
  CONSTRAINT `fk_Conduta_1` FOREIGN KEY (`id_avaliacao`) REFERENCES `AvaliacaoMedico` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Conduta`
--

LOCK TABLES `Conduta` WRITE;
/*!40000 ALTER TABLE `Conduta` DISABLE KEYS */;
/*!40000 ALTER TABLE `Conduta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Enfermeiro`
--

DROP TABLE IF EXISTS `Enfermeiro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Enfermeiro` (
  `crem` varchar(20) NOT NULL,
  `nick_name` varchar(20) NOT NULL,
  PRIMARY KEY (`crem`),
  KEY `fk_new_table_1_idx` (`nick_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Enfermeiro`
--

LOCK TABLES `Enfermeiro` WRITE;
/*!40000 ALTER TABLE `Enfermeiro` DISABLE KEYS */;
/*!40000 ALTER TABLE `Enfermeiro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Medico`
--

DROP TABLE IF EXISTS `Medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Medico` (
  `CRM` varchar(20) NOT NULL,
  `nick_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`CRM`),
  KEY `fk_Medico_1_idx` (`nick_name`),
  CONSTRAINT `fk_Medico_1` FOREIGN KEY (`nick_name`) REFERENCES `ProfissionalSaude` (`nick_name`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Medico`
--

LOCK TABLES `Medico` WRITE;
/*!40000 ALTER TABLE `Medico` DISABLE KEYS */;
/*!40000 ALTER TABLE `Medico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Operacao`
--

DROP TABLE IF EXISTS `Operacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Operacao` (
  `idCheckList` int(11) NOT NULL,
  `data_hora` datetime NOT NULL,
  `operacao` varchar(120) NOT NULL,
  `valor` int(11) DEFAULT NULL,
  `comentario` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`idCheckList`,`operacao`),
  CONSTRAINT `fk_Operacaod_1` FOREIGN KEY (`idCheckList`) REFERENCES `CheckList` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Operacao`
--

LOCK TABLES `Operacao` WRITE;
/*!40000 ALTER TABLE `Operacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `Operacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Paciente`
--

DROP TABLE IF EXISTS `Paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Paciente` (
  `nome` varchar(30) NOT NULL,
  `sobrenome` varchar(60) NOT NULL,
  `data_nascimento` date NOT NULL,
  `registro` varchar(20) NOT NULL,
  `sexo` varchar(2) DEFAULT NULL,
  `grupo_de_risco` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`registro`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Paciente`
--

LOCK TABLES `Paciente` WRITE;
/*!40000 ALTER TABLE `Paciente` DISABLE KEYS */;
INSERT INTO `Paciente` VALUES ('João','Silva','1984-05-31','10','0',1),('Agnalda','Sertão','1987-07-22','16','1',1);
/*!40000 ALTER TABLE `Paciente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Perguntas`
--

DROP TABLE IF EXISTS `Perguntas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Perguntas` (
  `res` tinyint(4) NOT NULL,
  `id_avaliacao` int(11) NOT NULL,
  `data` datetime NOT NULL,
  `descricao` varchar(120) NOT NULL,
  PRIMARY KEY (`id_avaliacao`,`data`,`descricao`),
  CONSTRAINT `fk_Perguntas_1` FOREIGN KEY (`id_avaliacao`) REFERENCES `AvaliacaoMedico` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Perguntas`
--

LOCK TABLES `Perguntas` WRITE;
/*!40000 ALTER TABLE `Perguntas` DISABLE KEYS */;
/*!40000 ALTER TABLE `Perguntas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ProfissionalSaude`
--

DROP TABLE IF EXISTS `ProfissionalSaude`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ProfissionalSaude` (
  `nome` varchar(30) NOT NULL,
  `sobrenome` varchar(70) NOT NULL,
  `nick_name` varchar(20) NOT NULL,
  `senha` varchar(9) NOT NULL,
  PRIMARY KEY (`nick_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ProfissionalSaude`
--

LOCK TABLES `ProfissionalSaude` WRITE;
/*!40000 ALTER TABLE `ProfissionalSaude` DISABLE KEYS */;
/*!40000 ALTER TABLE `ProfissionalSaude` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente`
--

DROP TABLE IF EXISTS `paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paciente` (
  `registro` varchar(255) NOT NULL,
  `data_nascimento` datetime NOT NULL,
  `grupo_de_risco` bit(1) DEFAULT NULL,
  `nome` varchar(255) NOT NULL,
  `sexo` varchar(255) DEFAULT NULL,
  `sobrenome` varchar(255) NOT NULL,
  PRIMARY KEY (`registro`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente`
--

LOCK TABLES `paciente` WRITE;
/*!40000 ALTER TABLE `paciente` DISABLE KEYS */;
/*!40000 ALTER TABLE `paciente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-22 11:59:17
