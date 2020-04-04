-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 04, 2020 at 04:56 PM
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
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `a_id` int(11) NOT NULL COMMENT 'Account ID',
  `a_user` varchar(50) NOT NULL COMMENT 'Account username',
  `a_pass` varchar(32) NOT NULL COMMENT 'Account password'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Stores list of account';

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`a_id`, `a_user`, `a_pass`) VALUES
(2, 'tintm', 'e10adc3949ba59abbe56e057f20f883e'),
(3, 'nhienht', 'e10adc3949ba59abbe56e057f20f883e'),
(4, 'vinhhq', 'e10adc3949ba59abbe56e057f20f883e'),
(5, 'thinhbnp', 'e10adc3949ba59abbe56e057f20f883e'),
(6, 'vinh', 'e10adc3949ba59abbe56e057f20f883e'),
(7, 'namtn', 'e10adc3949ba59abbe56e057f20f883e');

-- --------------------------------------------------------

--
-- Table structure for table `pocket`
--

CREATE TABLE `pocket` (
  `p_id` bigint(20) NOT NULL COMMENT 'Pocket''s ID',
  `p_money` bigint(20) NOT NULL DEFAULT '0' COMMENT 'Income or outcome',
  `p_description` varchar(250) NOT NULL COMMENT 'Reason for income/outcome',
  `p_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Date time of action',
  `a_id` int(11) NOT NULL COMMENT 'Account''s ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Pocket of account';

--
-- Dumping data for table `pocket`
--

INSERT INTO `pocket` (`p_id`, `p_money`, `p_description`, `p_time`, `a_id`) VALUES
(1, 5000000, 'From mother', '2020-04-01 16:29:47', 1),
(2, -25000, 'Breakfast', '2020-04-01 16:29:47', 1),
(3, 555000, 'From father', '2020-04-01 16:29:47', 2),
(4, -15000, 'Cafe', '2020-04-01 16:29:47', 2),
(5, 6890000, 'From girlfriend', '2020-04-01 16:29:47', 3),
(6, -15000, 'Breadfast', '2020-04-01 16:29:47', 3),
(7, -20000, 'Mua banh', '2020-04-01 23:47:10', 6),
(8, -1909000, 'Shopping', '2020-04-03 00:12:12', 6),
(9, -505000, 'Mua hoa', '2020-04-03 00:00:06', 6),
(10, 800000, 'Được lì xì', '2020-03-31 02:00:00', 6),
(11, 99999000, 'Lanh luong', '2020-04-04 00:03:00', 6),
(12, -899000, 'Mua gấu tặng ghệ', '2020-03-31 03:00:00', 6),
(13, -800000, 'Mua hoa tặng gấu', '2020-04-04 00:00:04', 6),
(14, 90999000, 'Thưởng tết', '2020-04-04 00:12:12', 6),
(15, -50000, 'Đi ăn với ghệ Vinh', '2020-04-04 00:00:05', 6),
(20, -506600, 'mua banh', '2020-04-04 00:00:00', 6),
(31, 3434, 'aafs', '2020-04-04 00:00:00', 6),
(32, 25050000, 'Lanh Thuong', '2020-04-05 00:00:00', 6);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`a_id`),
  ADD UNIQUE KEY `a_user` (`a_user`);

--
-- Indexes for table `pocket`
--
ALTER TABLE `pocket`
  ADD PRIMARY KEY (`p_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `a_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Account ID', AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `pocket`
--
ALTER TABLE `pocket`
  MODIFY `p_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'Pocket''s ID', AUTO_INCREMENT=33;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
