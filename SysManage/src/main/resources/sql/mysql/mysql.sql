-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.20


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema sshdb
--

CREATE DATABASE IF NOT EXISTS sshdb;
USE sshdb;

--
-- Definition of table `log`
--

DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `index` int(11) NOT NULL AUTO_INCREMENT,
  `msg` varchar(1000) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `level` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`index`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;


--
-- Definition of table `logoperation`
--

DROP TABLE IF EXISTS `logoperation`;
CREATE TABLE `logoperation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(100) DEFAULT NULL,
  `userId` varchar(100) DEFAULT NULL,
  `content` varchar(200) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `result` varchar(100) DEFAULT NULL,
  `ip` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


--
-- Definition of table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `baseprice` float NOT NULL,
  `buyexplain` varchar(200) NOT NULL,
  `clickcount` int(11) DEFAULT NULL,
  `code` varchar(50) NOT NULL,
  `commend` tinyint(1) DEFAULT NULL,
  `createdate` date NOT NULL,
  `description` longtext NOT NULL,
  `marketprice` float NOT NULL,
  `model` varchar(50) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `sellcount` int(11) DEFAULT NULL,
  `sellprice` float NOT NULL,
  `visible` tinyint(1) NOT NULL,
  `weight` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product`
--

/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;


--
-- Definition of table `sysmenu`
--

DROP TABLE IF EXISTS `sysmenu`;
CREATE TABLE `sysmenu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `checked` tinyint(1) NOT NULL,
  `iconCls` varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_f8osvkwfi4n0mgpc4yw8o2xs3` (`pid`),
  CONSTRAINT `FK_f8osvkwfi4n0mgpc4yw8o2xs3` FOREIGN KEY (`pid`) REFERENCES `sysmenu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sysmenu`
--

/*!40000 ALTER TABLE `sysmenu` DISABLE KEYS */;
INSERT INTO `sysmenu` (`id`,`checked`,`iconCls`,`state`,`text`,`url`,`pid`) VALUES 
 (1,1,'database_key','open','首页',NULL,NULL),
 (2,0,'database_lightning','closed','系统管理','',1),
 (3,1,'controller','closed','设备管理','jsp/manage/test2',1),
 (4,1,'door_open','closed','折旧管理','jsp/manage/test3',1),
 (5,0,'door_out','closed','用户管理','jsp/manage/test4',2),
 (6,0,'database_table','closed','权限管理','jsp/manage/test5',2);
/*!40000 ALTER TABLE `sysmenu` ENABLE KEYS */;


--
-- Definition of table `sysuser`
--

DROP TABLE IF EXISTS `sysuser`;
CREATE TABLE `sysuser` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `age` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sex` tinyint(1) NOT NULL,
  `userName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `sysuser`
--

/*!40000 ALTER TABLE `sysuser` DISABLE KEYS */;
/*!40000 ALTER TABLE `sysuser` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `age` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sex` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
