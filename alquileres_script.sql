/*M!999999\- enable the sandbox mode */ 
-- MariaDB dump 10.19-11.5.2-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: alquileres
-- ------------------------------------------------------
-- Server version	11.5.2-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*M!100616 SET @OLD_NOTE_VERBOSITY=@@NOTE_VERBOSITY, NOTE_VERBOSITY=0 */;

--
-- Table structure for table `alquileres`
--

DROP TABLE IF EXISTS `alquileres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alquileres` (
  `CIClientes` varchar(12) NOT NULL,
  `Matricula` varchar(7) NOT NULL,
  `Dias` int(11) NOT NULL,
  `Seguro` varchar(10) NOT NULL,
  `Precio` decimal(10,0) NOT NULL,
  PRIMARY KEY (`CIClientes`,`Matricula`),
  KEY `Matricula` (`Matricula`),
  CONSTRAINT `alquileres_ibfk_1` FOREIGN KEY (`CIClientes`) REFERENCES `clientes` (`CI`),
  CONSTRAINT `alquileres_ibfk_2` FOREIGN KEY (`Matricula`) REFERENCES `vehiculo` (`matricula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alquileres`
--

LOCK TABLES `alquileres` WRITE;
/*!40000 ALTER TABLE `alquileres` DISABLE KEYS */;
INSERT INTO `alquileres` VALUES
('3.333.333-3','QAL7785',3,'AU1198160',23),
('3.333.333-3','QAL8574',2,'AU1095158',37),
('3.444.333-4','QAL8065',2,'AU1000123',35),
('3.444.666-7','QAL5543',2,'AU0986158',21),
('3.555.444-5','QAL7789',4,'AU1213344',21),
('3.555.444.5','QAD8590',5,'AU1115141',30),
('3.555.666-5','QAD8769',3,'AU1298063',55),
('3.777.555-6','QAD8769',1,'AU1298063',55),
('3.888.777-6','QAD8695',2,'AU1300564',45),
('3.888.777-6','QAE6875',2,'AU1200124',28),
('3.888.777-8','QAL5543',4,'AU0986158',21);
/*!40000 ALTER TABLE `alquileres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `clientes` (
  `CI` varchar(12) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Apellido` varchar(30) NOT NULL,
  `Direccion` varchar(50) NOT NULL,
  `Tarjeta` varchar(30) NOT NULL,
  PRIMARY KEY (`CI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES
('3.333.333-3','Aaron','Rivero','18 de julio 333','VISA'),
('3.444.333-4','Adolfo','Rubio','Artigas 777','Efectivo'),
('3.444.555-4','Marcos','Mendez','Batlle y Ordoñez 445','Efectivo'),
('3.444.666-7','Juan','Romero','Luis A. de Herrera 1075','Efectivo'),
('3.555.444-5','Adrián','Suarez','Penza 434','VISA-BROU'),
('3.555.666-5','Pilar','Rodriguez','18 de julio 779','Master Card'),
('3.666.777-6','Maria','Florez','Rivera 658','VISA'),
('3.777.555-6','Diego','Fernandez','19 de Abril 845','Master Card'),
('3.888.777-6','Pamela','Rodriguez','Penza 978','AmericanExpress'),
('3.888.777-8','Rodrigo','Diaz','Juan B. De León 555','Efectivo'),
('3.999.444-3','Marta','Flores','Manuel Oribe 689','MI Dinero');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefonos`
--

DROP TABLE IF EXISTS `telefonos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `telefonos` (
  `CI` varchar(12) NOT NULL,
  `telefono` varchar(10) NOT NULL,
  KEY `CI` (`CI`),
  CONSTRAINT `telefonos_ibfk_1` FOREIGN KEY (`CI`) REFERENCES `clientes` (`CI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefonos`
--

LOCK TABLES `telefonos` WRITE;
/*!40000 ALTER TABLE `telefonos` DISABLE KEYS */;
INSERT INTO `telefonos` VALUES
('3.333.333-3','43628564'),
('3.333.333-3','099857625'),
('3.444.333-4','43624444'),
('3.444.333-4','098564876'),
('3.555.444-5','095444333'),
('3.444.555-4','098654878'),
('3.444.555-4','095467847'),
('3.666.777-6','099666777'),
('3.888.777-6','095565656'),
('3.555.666-5','43631586'),
('3.555.666-5','099689899'),
('3.888.777-8','094555666'),
('3.777.555-6','43629888'),
('3.777.555-6','094666777'),
('3.999.444-3','098665566'),
('3.444.666-7','0955566777');
/*!40000 ALTER TABLE `telefonos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculo`
--

DROP TABLE IF EXISTS `vehiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehiculo` (
  `matricula` varchar(7) NOT NULL,
  `marca` varchar(30) NOT NULL,
  `modelo` varchar(30) NOT NULL,
  `puertas` int(11) NOT NULL,
  `plazas` int(11) NOT NULL,
  `maletero` varchar(30) NOT NULL,
  `año` int(11) NOT NULL,
  PRIMARY KEY (`matricula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculo`
--

LOCK TABLES `vehiculo` WRITE;
/*!40000 ALTER TABLE `vehiculo` DISABLE KEYS */;
INSERT INTO `vehiculo` VALUES
('QAD8590','Chevrolet','Montana',2,2,'Cabina Carga 696kgs',2011),
('QAD8695','Fiat','Strada',4,5,'Cabina Carga 720kgs',2020),
('QAD8769','Renault','Oroch',5,5,'Cabina Carga 650kgs',2018),
('QAE6875','Nissan','Kicks',4,5,'Capacidad 432lts',2018),
('QAL5543','KIA','Picanto',4,5,'Capacidad 255lts',2020),
('QAL7785','Chevrolet','Prisma',4,5,'Capacidad 500lts',2015),
('QAL7789','Volskwagen','GolG6',4,5,'Capacidad 480lts',2016),
('QAL8065','Fiat','Fiorino Furgon',4,2,'Cabina Carga 650kgs',2012),
('QAL8574','Chevrolet','N300',5,7,'Cabina Carga 500kgs',2005),
('QAL8988','Chevrolet','Onix',4,5,'Capacidad 280lts',2017);
/*!40000 ALTER TABLE `vehiculo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*M!100616 SET NOTE_VERBOSITY=@OLD_NOTE_VERBOSITY */;

-- Dump completed on 2024-11-17  2:47:30
