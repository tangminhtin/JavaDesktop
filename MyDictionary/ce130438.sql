-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 17, 2020 at 01:43 PM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ce130438`
--

-- --------------------------------------------------------

--
-- Table structure for table `meaning`
--

CREATE TABLE `meaning` (
  `word_id` int(11) NOT NULL COMMENT 'Word ID',
  `type_id` int(11) NOT NULL COMMENT 'Type ID',
  `meaning_text` varchar(250) NOT NULL COMMENT 'Meaning of word'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Meaning of word';

--
-- Dumping data for table `meaning`
--

INSERT INTO `meaning` (`word_id`, `type_id`, `meaning_text`) VALUES
(1, 5, 'a round fruit with shiny red or green skin that is fairly hard and white inside.'),
(2, 5, 'a yellow citrus fruit with juice that has a bitter, sharp taste. Slices of lemon and lemon juice are used in cooking and drinks.'),
(3, 5, 'a round citrus fruit with thick skin of a colour between red and yellow and a lot of sweet juice.'),
(4, 5, 'a tropical fruit with smooth yellow or red skin, that is soft and orange inside with a large seed.'),
(5, 5, 'a long curved fruit with a thick yellow skin and that is soft inside, which grows on trees in hot countries.'),
(6, 5, 'a soft red fruit with very small yellow seeds on the surface, that grows on a low plant.');

-- --------------------------------------------------------

--
-- Table structure for table `type`
--

CREATE TABLE `type` (
  `type_id` int(11) NOT NULL COMMENT 'Type ID',
  `type_text` varchar(50) NOT NULL COMMENT 'Type name'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Type of word';

--
-- Dumping data for table `type`
--

INSERT INTO `type` (`type_id`, `type_text`) VALUES
(1, 'adjective'),
(2, 'adverb'),
(3, 'conjunction'),
(4, 'interjection'),
(5, 'noun'),
(6, 'participle'),
(7, 'phrase'),
(8, 'preposition'),
(9, 'pronoun'),
(10, 'verb'),
(11, 'verb - intransitive verb'),
(12, 'verb - transitive verb');

-- --------------------------------------------------------

--
-- Table structure for table `word`
--

CREATE TABLE `word` (
  `word_id` int(11) NOT NULL COMMENT 'Word ID',
  `word_text` varchar(100) NOT NULL COMMENT 'Word content'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Word';

--
-- Dumping data for table `word`
--

INSERT INTO `word` (`word_id`, `word_text`) VALUES
(1, 'apple'),
(5, 'banana'),
(2, 'lemon'),
(4, 'mango'),
(3, 'orange'),
(6, 'strawberry');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `meaning`
--
ALTER TABLE `meaning`
  ADD PRIMARY KEY (`word_id`,`type_id`);

--
-- Indexes for table `type`
--
ALTER TABLE `type`
  ADD PRIMARY KEY (`type_id`),
  ADD UNIQUE KEY `type_text` (`type_text`);

--
-- Indexes for table `word`
--
ALTER TABLE `word`
  ADD PRIMARY KEY (`word_id`),
  ADD UNIQUE KEY `word_text` (`word_text`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `type`
--
ALTER TABLE `type`
  MODIFY `type_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Type ID', AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `word`
--
ALTER TABLE `word`
  MODIFY `word_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Word ID', AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
