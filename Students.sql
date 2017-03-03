-- phpMyAdmin SQL Dump
-- version 4.4.15.5
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1:3306
-- Generation Time: Mar 03, 2017 at 09:22 PM
-- Server version: 5.5.48
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Students`
--

-- --------------------------------------------------------

--
-- Table structure for table `groups`
--

CREATE TABLE IF NOT EXISTS `groups` (
  `id` int(11) NOT NULL,
  `title` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `groups`
--

INSERT INTO `groups` (`id`, `title`) VALUES
(1, 'First'),
(2, 'Sec'),
(3, 'Third');

-- --------------------------------------------------------

--
-- Table structure for table `journal`
--

CREATE TABLE IF NOT EXISTS `journal` (
  `id` int(11) NOT NULL,
  `id_group` int(11) NOT NULL,
  `id_lection` int(11) NOT NULL,
  `date` datetime NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `journal`
--

INSERT INTO `journal` (`id`, `id_group`, `id_lection`, `date`) VALUES
(2, 1, 1, '2017-03-02 10:40:00'),
(3, 2, 1, '2017-03-02 09:00:00'),
(8, 1, 2, '2017-03-05 08:47:29'),
(9, 2, 2, '2017-03-02 08:47:43'),
(10, 1, 3, '2017-03-02 08:48:31');

-- --------------------------------------------------------

--
-- Table structure for table `lection`
--

CREATE TABLE IF NOT EXISTS `lection` (
  `id` int(11) NOT NULL,
  `title` varchar(50) NOT NULL,
  `text` text NOT NULL,
  `subject` varchar(100) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `lection`
--

INSERT INTO `lection` (`id`, `title`, `text`, `subject`) VALUES
(1, 'lection 1', 'text lection 1', 'subjectlection 1'),
(2, 'lection 2', 'text lection 2', 'subjectlection 2'),
(3, 'test', 'test', 'test'),
(4, 'lection 4', 'lection 4 text', 'lection 4 subject');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE IF NOT EXISTS `students` (
  `id` int(11) NOT NULL,
  `group_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `birthday` date NOT NULL,
  `sex` varchar(1) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id`, `group_id`, `name`, `birthday`, `sex`, `email`) VALUES
(1, 1, 'Petrov', '1999-03-30', 'm', 'resr@mam.ru'),
(2, 1, 'Ivanov', '2000-10-13', 'j', ''),
(3, 1, 'Ivanova I.I.', '2000-10-15', 'f', ''),
(7, 2, 'Sidorova D.A.', '2001-08-20', 'f', ''),
(8, 2, 'test', '2000-10-15', '3', ''),
(9, 1, 'test22', '2000-10-15', 'j', 'tet@tet.coc');

-- --------------------------------------------------------

--
-- Table structure for table `Users`
--

CREATE TABLE IF NOT EXISTS `Users` (
  `id` int(11) NOT NULL,
  `login` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` varchar(50) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Users`
--

INSERT INTO `Users` (`id`, `login`, `password`, `role`) VALUES
(1, 'test', '12', '2'),
(2, 'sdfsdf', '2324', NULL),
(3, '234', 'sdfsd', NULL),
(4, 'muhuch', 'darbij', NULL),
(5, 'rrtetr', 'erte', NULL),
(6, '5657', 'hjhk', NULL),
(7, 'test2', 'test', NULL),
(8, 'tttttttt', '1', NULL),
(9, 'new', '1', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `groups`
--
ALTER TABLE `groups`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id` (`id`);

--
-- Indexes for table `journal`
--
ALTER TABLE `journal`
  ADD PRIMARY KEY (`id`),
  ADD KEY `id_group` (`id_group`) USING BTREE,
  ADD KEY `id_lection` (`id_lection`);

--
-- Indexes for table `lection`
--
ALTER TABLE `lection`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`),
  ADD KEY `group_id` (`group_id`);

--
-- Indexes for table `Users`
--
ALTER TABLE `Users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `groups`
--
ALTER TABLE `groups`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `journal`
--
ALTER TABLE `journal`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `lection`
--
ALTER TABLE `lection`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `Users`
--
ALTER TABLE `Users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `journal`
--
ALTER TABLE `journal`
  ADD CONSTRAINT `group` FOREIGN KEY (`id_group`) REFERENCES `groups` (`id`),
  ADD CONSTRAINT `lection` FOREIGN KEY (`id_lection`) REFERENCES `lection` (`id`);

--
-- Constraints for table `students`
--
ALTER TABLE `students`
  ADD CONSTRAINT `students_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
