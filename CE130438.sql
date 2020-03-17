-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Mar 13, 2020 at 05:49 AM
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
-- Database: `CE130438`
--

-- --------------------------------------------------------

--
-- Table structure for table `Account`
--

CREATE TABLE `Account` (
  `id` int(11) NOT NULL COMMENT 'id tài khoản',
  `username` varchar(50) NOT NULL COMMENT 'Tên tài khoản',
  `password` varchar(32) NOT NULL COMMENT 'Mật khẩu',
  `fullname` varchar(50) NOT NULL COMMENT 'Họ và tên',
  `gender` int(1) NOT NULL DEFAULT '0' COMMENT 'Giới tính, mặc định 0 (0 nam, 1 nữ)',
  `email` varchar(100) NOT NULL COMMENT 'Địa chỉ email',
  `phone` varchar(15) NOT NULL COMMENT 'Số điện thoại'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Account`
--

INSERT INTO `Account` (`id`, `username`, `password`, `fullname`, `gender`, `email`, `phone`) VALUES
(1, 'tangminhtin', '25d55ad283aa400af464c76d713c07ad', 'Tang Minh Tin', 0, 'minhtintang@gmail.com', '0394328223'),
(2, 'nhienhuynh', '25d55ad283aa400af464c76d713c07ad', 'Huynh Thi Nhien', 1, 'nhienhuynh@gmail.com', '0368765437'),
(3, 'khang', '25d55ad283aa400af464c76d713c07ad', 'Nguyen Vu Khang', 0, 'khang@gmail.com', '0358674635'),
(4, 'nam', '25d55ad283aa400af464c76d713c07ad', 'Truong Nhat Nam', 0, 'nam@gmail.com', '0384758934'),
(5, 'vinh', '25d55ad283aa400af464c76d713c07ad', 'Hua Quoc Vinh', 0, 'vinh@gmail.com', '0364793246'),
(6, 'hao', '25d55ad283aa400af464c76d713c07ad', 'Nguyen Son Hao', 0, 'hao@gmail.com', '0381236548'),
(7, 'thinh', '25d55ad283aa400af464c76d713c07ad', 'Bach Nguyen Phuc Thinh', 0, 'thinh@gmail.com', '0374837264');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Account`
--
ALTER TABLE `Account`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `phone` (`phone`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Account`
--
ALTER TABLE `Account`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id tài khoản', AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
