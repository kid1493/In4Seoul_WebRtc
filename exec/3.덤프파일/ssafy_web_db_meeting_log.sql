-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: i6a503.p.ssafy.io    Database: ssafy_web_db
-- ------------------------------------------------------
-- Server version	8.0.28-0ubuntu0.20.04.3

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
-- Table structure for table `meeting_log`
--

DROP TABLE IF EXISTS `meeting_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `meeting_log` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `ended_at` varchar(255) DEFAULT NULL,
  `started_at` varchar(255) DEFAULT NULL,
  `desks_id` int DEFAULT NULL,
  `staff_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKcnwkk8a0abh8uj9j6ghfcxt8c` (`desks_id`),
  KEY `FKk72vt8c2m4a0fm4a7bxl1ahxl` (`staff_id`),
  CONSTRAINT `FKcnwkk8a0abh8uj9j6ghfcxt8c` FOREIGN KEY (`desks_id`) REFERENCES `desk` (`id`),
  CONSTRAINT `FKk72vt8c2m4a0fm4a7bxl1ahxl` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meeting_log`
--

LOCK TABLES `meeting_log` WRITE;
/*!40000 ALTER TABLE `meeting_log` DISABLE KEYS */;
INSERT INTO `meeting_log` VALUES (18,'화이팅','2022-02-16 20:17','2022-02-16 20:17',2,3),(23,'화이팅','2022-02-17 11:20','2022-02-17 11:20',2,3),(24,'화이팅','2022-02-17 13:13','2022-02-17 13:10',2,3),(25,'화이팅','2022-02-17 13:14','2022-02-17 13:13',2,3),(26,'화이팅','2022-02-17 13:21','2022-02-17 13:21',2,3),(27,'화이팅','2022-02-17 13:21','2022-02-17 13:21',2,3),(28,'화이팅','2022-02-17 13:21','2022-02-17 13:21',2,3),(29,'화이팅','2022-02-17 13:21','2022-02-17 13:21',2,3),(30,'화이팅','2022-02-17 13:27','2022-02-17 13:27',2,3),(31,'화이팅','2022-02-17 14:00','2022-02-17 13:59',2,3),(32,'화이팅','2022-02-17 19:29','2022-02-17 19:29',2,3),(33,'화이팅','2022-02-17 19:34','2022-02-17 19:33',2,3),(34,'화이팅','2022-02-17 19:36','2022-02-17 19:35',2,3),(35,'화이팅','2022-02-17 19:44','2022-02-17 19:36',2,3),(36,'화이팅','2022-02-17 20:51','2022-02-17 20:51',28,5),(37,'화이팅','2022-02-17 20:52','2022-02-17 20:51',28,5),(38,'화이팅','2022-02-17 20:53','2022-02-17 20:53',28,3),(39,'화이팅','2022-02-17 20:55','2022-02-17 20:55',28,3),(40,'화이팅','2022-02-17 20:55','2022-02-17 20:55',28,5),(41,'화이팅','2022-02-17 20:56','2022-02-17 20:56',28,3),(42,'화이팅','2022-02-17 21:07','2022-02-17 20:56',28,5),(43,'화이팅','2022-02-17 21:17','2022-02-17 21:10',28,8),(44,'화이팅','2022-02-17 21:20','2022-02-17 21:17',28,8),(45,'화이팅','2022-02-17 21:26','2022-02-17 21:21',28,8),(46,'화이팅','2022-02-17 22:35','2022-02-17 22:33',28,7),(47,'화이팅','2022-02-17 22:36','2022-02-17 22:36',28,5),(48,'화이팅','2022-02-17 23:11','2022-02-17 23:10',28,3),(49,'화이팅','2022-02-17 23:15','2022-02-17 23:12',2,7),(50,'화이팅','2022-02-17 23:15','2022-02-17 23:15',2,7),(51,'화이팅','2022-02-17 23:17','2022-02-17 23:16',2,7),(52,'화이팅','2022-02-17 23:19','2022-02-17 23:18',28,3),(53,'화이팅','2022-02-17 23:21','2022-02-17 23:20',2,7),(54,'화이팅','2022-02-17 23:35','2022-02-17 23:31',28,3),(55,'화이팅','2022-02-17 23:37','2022-02-17 23:36',64,8),(56,'화이팅','2022-02-17 23:57','2022-02-17 23:55',64,8),(57,'화이팅','2022-02-17 23:59','2022-02-17 23:57',64,8),(58,'화이팅','2022-02-18 00:00','2022-02-18 00:00',28,3),(59,'화이팅','2022-02-18 00:00','2022-02-18 00:00',28,3),(60,'화이팅','2022-02-18 00:01','2022-02-18 00:01',28,3),(61,'화이팅','2022-02-18 00:03','2022-02-18 00:02',64,8),(62,'화이팅','2022-02-18 00:05','2022-02-18 00:04',64,8),(63,'화이팅','2022-02-18 00:06','2022-02-18 00:06',64,8),(64,'화이팅','2022-02-18 00:08','2022-02-18 00:07',64,8),(65,'화이팅','2022-02-18 00:14','2022-02-18 00:14',28,3),(66,'화이팅','2022-02-18 00:15','2022-02-18 00:15',28,3),(67,'화이팅','2022-02-18 00:18','2022-02-18 00:16',64,8),(68,'화이팅','2022-02-18 00:22','2022-02-18 00:20',64,8),(69,'화이팅','2022-02-18 00:23','2022-02-18 00:22',64,8),(70,'화이팅','2022-02-18 00:23','2022-02-18 00:23',64,8),(71,'화이팅','2022-02-18 00:23','2022-02-18 00:23',64,8),(72,'화이팅','2022-02-18 00:25','2022-02-18 00:24',64,8),(73,'화이팅','2022-02-18 00:27','2022-02-18 00:26',64,8),(74,'화이팅','2022-02-18 00:29','2022-02-18 00:27',64,8),(75,'화이팅','2022-02-18 01:15','2022-02-18 01:13',28,3),(76,'화이팅','2022-02-18 01:16','2022-02-18 01:15',28,5),(77,'화이팅','2022-02-18 01:18','2022-02-18 01:16',28,5),(78,'화이팅','2022-02-18 01:18','2022-02-18 01:18',28,5),(79,'화이팅','2022-02-18 01:20','2022-02-18 01:19',28,5),(80,NULL,'2022-02-18 01:25','2022-02-18 01:25',28,5),(81,'화이팅','2022-02-18 01:52','2022-02-18 01:52',22,18),(82,'화이팅','2022-02-18 01:54','2022-02-18 01:53',24,16),(83,'화이팅','2022-02-18 01:54','2022-02-18 01:54',24,16),(84,'화이팅','2022-02-18 02:10','2022-02-18 02:10',24,16),(85,'화이팅','2022-02-18 02:11','2022-02-18 02:10',22,18),(86,'화이팅','2022-02-18 02:11','2022-02-18 02:11',22,18),(87,NULL,'2022-02-18 03:19','2022-02-18 03:19',64,3),(88,'화이팅','2022-02-18 03:20','2022-02-18 03:20',64,3),(89,'화이팅','2022-02-18 03:20','2022-02-18 03:20',64,3);
/*!40000 ALTER TABLE `meeting_log` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-18 11:00:48
