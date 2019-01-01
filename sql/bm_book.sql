/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50556
Source Host           : localhost:3306
Source Database       : bm

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2018-12-31 16:53:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bm_book
-- ----------------------------
DROP TABLE IF EXISTS `bm_book`;
CREATE TABLE `bm_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(32) DEFAULT NULL,
  `author` varchar(32) DEFAULT NULL,
  `publisher` varchar(32) DEFAULT NULL,
  `publishing_date` date DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `category` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bm_book_category
-- ----------------------------
DROP TABLE IF EXISTS `bm_book_category`;
CREATE TABLE `bm_book_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(32) DEFAULT NULL,
  `category_description` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bm_borrow_record
-- ----------------------------
DROP TABLE IF EXISTS `bm_borrow_record`;
CREATE TABLE `bm_borrow_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  `borrow_date` date DEFAULT NULL,
  `return_datae` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for bm_user
-- ----------------------------
DROP TABLE IF EXISTS `bm_user`;
CREATE TABLE `bm_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `user_type` char(1) DEFAULT NULL,
  `borrow_limit` int(11) DEFAULT NULL,
  `borrow_count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
