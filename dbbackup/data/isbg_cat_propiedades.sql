-- MySQL dump 10.13  Distrib 8.0.36, for Linux (x86_64)
--
-- Host: isbg.ckqz4zbtwhi3.us-west-1.rds.amazonaws.com    Database: isbg
-- ------------------------------------------------------
-- Server version	8.0.42

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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '';

--
-- Dumping data for table `cat_propiedades`
--

LOCK TABLES `cat_propiedades` WRITE;
/*!40000 ALTER TABLE `cat_propiedades` DISABLE KEYS */;
INSERT INTO `cat_propiedades` VALUES (1,'ESTADO','SOLICITUD','0'),(2,'ESTADO','VALIDACION RH','1'),(3,'ESTADO','VALIDACION CONTABILIDAD','2'),(14,'oficinas','COM','CM COMALCALCO'),(15,'oficinas','COA','CO COATZACOALCOS'),(16,'oficinas','BES','DX BAHIA DEL ESPIRITU SANTO'),(17,'oficinas','XAL','JA XALAPA'),(18,'oficinas','MIN','MI MINATITLAN'),(19,'oficinas','PRI','PZ POZA RICA'),(20,'oficinas','REY','RE CD REYNOSA'),(21,'oficinas','SAL','SA SALAMANCA'),(22,'oficinas','SCR','SC SALINA CRUZ'),(23,'oficinas','CMA','TA CD MADERO'),(24,'oficinas','TUL','TU TULA'),(25,'oficinas','VER','VE VERACRUZ'),(26,'oficinas','VIH','VI VILLAHERMOSA'),(27,'oficinas','CCA','YA CD CARMEN'),(28,'tipo-cuenta','CLABE','Clabe Interbancaria'),(29,'tipo-cuenta','CUENTA','Cuenta bancaria'),(30,'tipo-cuenta','TD','Numero tarjeta debito'),(31,'bancos','BBVA','BBVA BANCOMER'),(32,'bancos','HSBC','HSBC'),(33,'bancos','CITY','CITYBANAMEX'),(34,'bancos','INBU','INBURSA'),(35,'bancos','AZTE','BANCO AZTECA'),(36,'bancos','REGI','BANREGIO'),(37,'bancos','SANT','SANTANDER'),(38,'bancos','MIFE','MIFEL'),(39,'bancos','IXE','IXE'),(40,'bancos','SCOT','SCOTIABANK'),(41,'bancos','BANO','BANORTE'),(42,'configuraciones','INICIO-CAJA','NOVEMBER'),(43,'oficinas','AZC','H AZCAPOTZALCO'),(44,'oficinas','PCH','H PICACHO'),(45,'oficinas','MAR','MARINA'),(50,'oficinas','CAR','CARACAS'),(51,'oficinas','OTR','OTROS'),(52,'oficinas','DESP','DESPACHO'),(53,'bancos','ACTI','ACTINVER'),(54,'bancos','COPP','BANCOPPEL'),(55,'configuraciones','FIN-CAJA','OCTOBER');
/*!40000 ALTER TABLE `cat_propiedades` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-09-20 14:44:36
