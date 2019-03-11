/*
SQLyog  v12.2.6 (64 bit)
MySQL - 5.7.21-log : Database - tinyurl
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`tinyurl` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `tinyurl`;

/*Table structure for table `tiny_url_mapping` */

DROP TABLE IF EXISTS `tiny_url_mapping`;

CREATE TABLE `tiny_url_mapping` (
  `short_url` char(7) COLLATE utf8_bin NOT NULL COMMENT '短链',
  `long_url` char(255) COLLATE utf8_bin DEFAULT NULL COMMENT '长链',
  `total` int(10) DEFAULT '0',
  PRIMARY KEY (`short_url`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `tiny_url_mapping` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
