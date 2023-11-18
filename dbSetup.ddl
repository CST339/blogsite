CREATE DATABASE IF NOT EXISTS `blogsite`;
USE `blogsite`;

-- Host: 127.0.0.1    Database: blogsite
-- ------------------------------------------------------

--
-- Table structure for table `USERS`
--

DROP TABLE IF EXISTS `USERS`;
CREATE TABLE `USERS` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(25) NOT NULL UNIQUE,
  `PASSWORD` varchar(128) NOT NULL,
  `FIRST_NAME` varchar(25) NOT NULL,
  `LAST_NAME` varchar(25) NOT NULL,
  `PHONE_NUMBER` varchar(25) NOT NULL,
  `EMAIL_ADDRESS` varchar(25) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `USERS`
--

LOCK TABLES `USERS` WRITE;
INSERT INTO `USERS` VALUES (1,'Username1','password1', 'firstName1', 'lastName1', 4802237867, 'notrealemail@email.com'),(2,'Username2','password1', 'firstName2', 'lastName2', 4802237867, 'notrealemail@email.com'),(3,'Username3','password1', 'firstName3', 'lastName3', 4802237867, 'notrealemail@email.com'),(4,'Username4','password1', 'firstName4', 'lastName4', 4802237867, 'notrealemail@email.com'),(5,'Username5','password1', 'firstName5', 'lastName5', 4802237867, 'notrealemail@email.com'),(6,'Username6','password1', 'firstName6', 'lastName6', 4802237867, 'notrealemail@email.com'),(7,'Username7','password1', 'firstName7', 'lastName7', 4802237867, 'notrealemail@email.com');
UNLOCK TABLES;


--
-- Table structure for table `BLOGPOSTS`
--

DROP TABLE IF EXISTS `BLOGPOSTS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `BLOGPOSTS` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(25) NOT NULL,
  `DATE` varchar(25) NOT NULL,
  `AUTHOR` VARCHAR(50),
  `CONTENT` TEXT NOT NULL,
  PRIMARY KEY (`ID`),
  FOREIGN KEY (`AUTHOR`) REFERENCES `USERS`(`USERNAME`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `USERS`
--

LOCK TABLES `BLOGPOSTS` WRITE;
INSERT INTO `BLOGPOSTS` VALUES (2, 'title2', 'date2', 'Username2', 'Content of the blog post 2'),(3, 'title3', 'date3', 'Username3', 'Content of the blog post 3'),(4, 'title4', 'date4', 'Username4', 'Content of the blog post 4'),(5, 'title5', 'date5', 'Username5', 'Content of the blog post 5'),(6, 'title6', 'date6', 'Username6', 'Content of the blog post 6'),(7, 'title7', 'date7', 'Username7', 'Content of the blog post 7'),(8, 'title8', 'date8', 'Username1', 'Content of the blog post 8');
UNLOCK TABLES;
