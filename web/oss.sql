# MySQL-Front 5.0  (Build 1.0)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;


# Host: localhost    Database: oss
# ------------------------------------------------------
# Server version 5.0.45-community-nt

DROP DATABASE IF EXISTS `oss`;
CREATE DATABASE `oss` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `oss`;

#
# Table structure for table article
#

CREATE TABLE `article` (
  `id` int(11) NOT NULL auto_increment,
  `title` varchar(30) default NULL,
  `content` longtext,
  `cdate` varchar(25) default NULL,
  `user_id` int(11) default NULL,
  `c_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKD458CCF68F6D02A6` (`c_id`),
  KEY `FKD458CCF6A5B0ED8B` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Table structure for table category
#

CREATE TABLE `category` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(12) default NULL,
  `isDelete` int(11) default NULL,
  `p_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK302BCFE8F72EB79` (`p_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Table structure for table mail
#

CREATE TABLE `mail` (
  `id` int(11) NOT NULL auto_increment,
  `title` varchar(30) default NULL,
  `content` longtext,
  `cdate` varchar(25) default NULL,
  `isNew` int(11) default NULL,
  `reveiver_id` int(11) default NULL,
  `sender_id` int(11) default NULL,
  `beto` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK3305B73237C9FA` (`reveiver_id`),
  KEY `FK3305B7B0612EE1` (`sender_id`),
  KEY `FK3305B7AEA4157A` (`beto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Table structure for table replay
#

CREATE TABLE `replay` (
  `id` int(11) NOT NULL auto_increment,
  `content` longtext,
  `cdate` varchar(20) default NULL,
  `user_id` int(11) default NULL,
  `art_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKC84C47E7A5B0ED8B` (`user_id`),
  KEY `FKC84C47E7BEB0081C` (`art_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Table structure for table user
#

CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(20) default NULL,
  `password` varchar(20) default NULL,
  `realName` varchar(10) default NULL,
  `sex` int(11) default NULL,
  `age` int(11) default NULL,
  `tel` varchar(15) default NULL,
  `email` varchar(30) default NULL,
  `addr` varchar(50) default NULL,
  `role` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
#  Foreign keys for table article
#

ALTER TABLE `article`
ADD CONSTRAINT `FKD458CCF6A5B0ED8B` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKD458CCF68F6D02A6` FOREIGN KEY (`c_id`) REFERENCES `category` (`id`);

#
#  Foreign keys for table category
#

ALTER TABLE `category`
ADD CONSTRAINT `FK302BCFE8F72EB79` FOREIGN KEY (`p_id`) REFERENCES `category` (`id`);

#
#  Foreign keys for table mail
#

ALTER TABLE `mail`
ADD CONSTRAINT `FK3305B7AEA4157A` FOREIGN KEY (`beto`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FK3305B73237C9FA` FOREIGN KEY (`reveiver_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FK3305B7B0612EE1` FOREIGN KEY (`sender_id`) REFERENCES `user` (`id`);

#
#  Foreign keys for table replay
#

ALTER TABLE `replay`
ADD CONSTRAINT `FKC84C47E7BEB0081C` FOREIGN KEY (`art_id`) REFERENCES `article` (`id`),
  ADD CONSTRAINT `FKC84C47E7A5B0ED8B` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);


/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
