-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: dgs_db
-- ------------------------------------------------------
-- Server version	5.7.9-log

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
-- Table structure for table `advertise`
--

DROP TABLE IF EXISTS `advertise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `advertise` (
  `advertise_id` int(10) unsigned NOT NULL,
  `advertise_name` varchar(256) DEFAULT NULL,
  `type` int(10) DEFAULT NULL,
  `link` varchar(256) DEFAULT NULL,
  `file_id` int(10) DEFAULT NULL,
  `status` int(10) DEFAULT NULL,
  `ord` int(10) DEFAULT NULL,
  `creatd_by` varchar(64) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `modified_by` varchar(64) DEFAULT NULL,
  `modified_on` datetime DEFAULT NULL,
  PRIMARY KEY (`advertise_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `advertise`
--

LOCK TABLES `advertise` WRITE;
/*!40000 ALTER TABLE `advertise` DISABLE KEYS */;
/*!40000 ALTER TABLE `advertise` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer` (
  `customer_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cust_name` varchar(256) DEFAULT NULL,
  `email` varchar(256) DEFAULT NULL,
  `login_id` varchar(256) DEFAULT NULL,
  `password` varchar(256) DEFAULT NULL,
  `phone` varchar(32) DEFAULT NULL,
  `mobile` varchar(32) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `address` varchar(512) DEFAULT NULL,
  `company` varchar(256) DEFAULT NULL,
  `companyPhone` varchar(32) DEFAULT NULL,
  `website` varchar(256) DEFAULT NULL,
  `gender` int(10) unsigned DEFAULT NULL,
  `cmnd` varchar(16) DEFAULT NULL,
  `creatd_by` varchar(64) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `modified_by` varchar(64) DEFAULT NULL,
  `modified_on` datetime DEFAULT NULL,
  `status` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `file_upload`
--

DROP TABLE IF EXISTS `file_upload`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `file_upload` (
  `upload_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `file_name` varchar(256) DEFAULT NULL,
  `file_path` varchar(512) DEFAULT NULL,
  `file_size` int(10) unsigned DEFAULT NULL,
  `extendtion` varchar(32) DEFAULT NULL,
  `title` varchar(256) DEFAULT NULL,
  `description` varchar(1024) DEFAULT NULL,
  `status` int(10) unsigned DEFAULT NULL,
  `created_by` varchar(64) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `modified_by` varchar(64) DEFAULT NULL,
  `modified_on` datetime DEFAULT NULL,
  PRIMARY KEY (`upload_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file_upload`
--

LOCK TABLES `file_upload` WRITE;
/*!40000 ALTER TABLE `file_upload` DISABLE KEYS */;
/*!40000 ALTER TABLE `file_upload` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `leads`
--

DROP TABLE IF EXISTS `leads`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `leads` (
  `lead_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `customer_id` int(10) unsigned DEFAULT NULL,
  `lead_name` varchar(256) DEFAULT NULL,
  `phone` varchar(64) DEFAULT NULL,
  `email` varchar(256) DEFAULT NULL,
  `address` varchar(512) DEFAULT NULL,
  `company` varchar(256) DEFAULT NULL,
  `cmnd` varchar(16) DEFAULT NULL,
  `brithday` datetime DEFAULT NULL,
  `gender` int(10) unsigned DEFAULT NULL,
  `created_by` varchar(64) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `modified_by` varchar(64) DEFAULT NULL,
  `modified_on` datetime DEFAULT NULL,
  `staus` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`lead_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `leads`
--

LOCK TABLES `leads` WRITE;
/*!40000 ALTER TABLE `leads` DISABLE KEYS */;
/*!40000 ALTER TABLE `leads` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `order_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `order_code` varchar(256) DEFAULT NULL,
  `created_by` varchar(64) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `lead_id` int(10) unsigned DEFAULT NULL,
  `total_price` double DEFAULT NULL,
  `deliver_date` datetime DEFAULT NULL,
  `status` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_detail`
--

DROP TABLE IF EXISTS `order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_detail` (
  `detail_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `product_id` int(10) unsigned DEFAULT NULL,
  `order_id` int(10) unsigned DEFAULT NULL,
  `quantity` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`detail_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_detail`
--

LOCK TABLES `order_detail` WRITE;
/*!40000 ALTER TABLE `order_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `price`
--

DROP TABLE IF EXISTS `price`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `price` (
  `price_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `price_value` double DEFAULT NULL,
  `unit` int(10) unsigned DEFAULT NULL,
  `product_id` int(10) unsigned DEFAULT NULL,
  `created_by` varchar(64) DEFAULT NULL,
  `create_on` datetime DEFAULT NULL,
  `status` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`price_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `price`
--

LOCK TABLES `price` WRITE;
/*!40000 ALTER TABLE `price` DISABLE KEYS */;
/*!40000 ALTER TABLE `price` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_file`
--

DROP TABLE IF EXISTS `product_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_file` (
  `product_file_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `product_id` int(10) unsigned DEFAULT NULL,
  `file_upload_id` int(10) unsigned DEFAULT NULL,
  `type` int(10) unsigned DEFAULT NULL,
  `status` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`product_file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_file`
--

LOCK TABLES `product_file` WRITE;
/*!40000 ALTER TABLE `product_file` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `product_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `product_code` varchar(256) DEFAULT NULL,
  `product_name` varchar(256) DEFAULT NULL,
  `parent_id` int(10) unsigned DEFAULT NULL,
  `is_parent` tinyint(1) DEFAULT NULL,
  `decription` text,
  `tag` varchar(256) DEFAULT NULL,
  `creatd_by` varchar(64) DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `modified_by` varchar(64) DEFAULT NULL,
  `modified_on` datetime DEFAULT NULL,
  `status` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rating`
--

DROP TABLE IF EXISTS `rating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rating` (
  `rating_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `lead_id` int(10) unsigned DEFAULT NULL,
  `product_id` int(10) unsigned DEFAULT NULL,
  `rate` int(10) unsigned DEFAULT NULL,
  `comment` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`rating_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rating`
--

LOCK TABLES `rating` WRITE;
/*!40000 ALTER TABLE `rating` DISABLE KEYS */;
/*!40000 ALTER TABLE `rating` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `role_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role_name` varchar(256) DEFAULT NULL,
  `desciption` varchar(256) DEFAULT NULL,
  `status` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_screen`
--

DROP TABLE IF EXISTS `role_screen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_screen` (
  `role_screen_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` int(10) unsigned DEFAULT NULL,
  `screen_id` int(10) unsigned DEFAULT NULL,
  `permission` int(10) unsigned DEFAULT NULL,
  `Note` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`role_screen_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_screen`
--

LOCK TABLES `role_screen` WRITE;
/*!40000 ALTER TABLE `role_screen` DISABLE KEYS */;
/*!40000 ALTER TABLE `role_screen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_user`
--

DROP TABLE IF EXISTS `role_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_user` (
  `role_user_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned DEFAULT NULL,
  `role_id` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`role_user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_user`
--

LOCK TABLES `role_user` WRITE;
/*!40000 ALTER TABLE `role_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `role_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `screen`
--

DROP TABLE IF EXISTS `screen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `screen` (
  `screen_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `screen_code` varchar(256) NOT NULL,
  `screen_name` varchar(256) NOT NULL,
  `screen_group` int(10) unsigned DEFAULT NULL,
  `type` int(10) unsigned NOT NULL DEFAULT '0',
  `link` varchar(256) DEFAULT NULL,
  `status` int(10) unsigned DEFAULT NULL,
  `ord` int(11) DEFAULT NULL,
  `action` varchar(256) DEFAULT NULL,
  `screen_level` int(10) DEFAULT NULL,
  PRIMARY KEY (`screen_id`,`type`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `screen`
--

LOCK TABLES `screen` WRITE;
/*!40000 ALTER TABLE `screen` DISABLE KEYS */;
INSERT INTO `screen` VALUES (1,'SCRUSER','Quản lý tài khoản',1,1,'/admin/users/index.jsp',1,1,'viewUserPage',NULL),(2,'SCRROLE','Phân quyền',1,1,'/admin/role/index.jsp',1,2,'viewRolePage',NULL),(3,'SCRPRODUCT','Quản lý sản phẩm',3,1,'/admin/product/index',1,1,'viewManageProductPage',NULL),(4,'SCRHOME','Trang chủ',0,2,'/index',1,1,'index',1),(5,'SCRABOUT','Giới Thiệu',1,2,'/about',1,2,'about',1),(6,'SUMENH','Sứ Mệnh',1,2,'/about/su-menh',1,1,'su-menh',2);
/*!40000 ALTER TABLE `screen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(256) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(256) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `full_name` varchar(256) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `gender` int(10) unsigned DEFAULT NULL,
  `mobile` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(256) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `address` varchar(512) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `skype_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `yahoo_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `created_on` datetime DEFAULT NULL,
  `modified_by` varchar(64) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `modified_on` datetime DEFAULT NULL,
  `status` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','hungnv','NgoHung','1989-05-21 00:00:00',NULL,NULL,'hungcnit89@gmail.com',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1),(2,'hungnv','123456','Ngô Văn Hùng','1989-05-21 00:00:00',NULL,NULL,'hung_sdg09@hotmail.com','Định Công Hạ - Hoàng Mai - Hà Nội',NULL,NULL,NULL,NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-12-04 23:22:30
