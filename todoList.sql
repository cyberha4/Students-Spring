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
-- Database: `todoList`
--

-- --------------------------------------------------------

--
-- Table structure for table `statuses`
--

CREATE TABLE IF NOT EXISTS `statuses` (
  `id` int(11) NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `statuses`
--

INSERT INTO `statuses` (`id`, `status`) VALUES
(1, 'processing'),
(2, 'tests'),
(3, 'iyuiyu'),
(4, 'testStatus of hiber');

-- --------------------------------------------------------

--
-- Table structure for table `tasks`
--

CREATE TABLE IF NOT EXISTS `tasks` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `status_id` int(11) DEFAULT NULL,
  `type_id` int(11) DEFAULT NULL,
  `title` varchar(50) NOT NULL,
  `annotation` varchar(200) DEFAULT NULL,
  `text` text,
  `created_up` int(19) DEFAULT NULL,
  `finished_at` int(19) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tasks`
--

INSERT INTO `tasks` (`id`, `user_id`, `status_id`, `type_id`, `title`, `annotation`, `text`, `created_up`, `finished_at`) VALUES
(2, 2, 1, 3, 'title', 'annotation', 'text', 1234567890, 1234569890),
(3, 1, 2, 2, 'tirl', 'annotation', 'text', 1234567890, 1234569890),
(19, 1, 1, 3, 'Пробный таск', 'annotation', 'text', 1234567890, 1234569890),
(20, 4, 2, 3, 'dfsdfsdf', 'annotation', 'text', 1234567890, 1234569890),
(21, 2, 0, 0, 'test', 'test', 'ttsttsdf', NULL, 0);

-- --------------------------------------------------------

--
-- Table structure for table `types`
--

CREATE TABLE IF NOT EXISTS `types` (
  `id` int(11) NOT NULL,
  `type` varchar(50) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `types`
--

INSERT INTO `types` (`id`, `type`) VALUES
(1, 'important'),
(2, 'not_important');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `email` varchar(60) NOT NULL,
  `login` varchar(60) NOT NULL,
  `password` varchar(60) NOT NULL,
  `role` varchar(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `login`, `password`, `role`) VALUES
(1, 'John', 'mail@mail.ml', 'login', '1', 'user'),
(2, 'Obama', '', 'chikatilo', '1', 'admin'),
(3, 'Пугачева', '', '', '', ''),
(4, 'Суслик', '', '', '', ''),
(5, 'Rabit', '', '', '', ''),
(6, NULL, 'proffi99@mail.ru', 'git', '11', ''),
(7, NULL, '', '', '', 'user');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `statuses`
--
ALTER TABLE `statuses`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tasks`
--
ALTER TABLE `tasks`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `typeId` (`id`,`status_id`,`type_id`),
  ADD KEY `statusId` (`id`,`status_id`),
  ADD KEY `userId` (`user_id`),
  ADD KEY `tasksToType` (`type_id`),
  ADD KEY `test` (`status_id`);

--
-- Indexes for table `types`
--
ALTER TABLE `types`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `statuses`
--
ALTER TABLE `statuses`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `tasks`
--
ALTER TABLE `tasks`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT for table `types`
--
ALTER TABLE `types`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `tasks`
--
ALTER TABLE `tasks`
  ADD CONSTRAINT `TasksToUser` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
