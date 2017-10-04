-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 04, 2017 at 05:36 PM
-- Server version: 10.1.22-MariaDB
-- PHP Version: 7.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `moneytransfer`
--

-- --------------------------------------------------------

--
-- Table structure for table `company`
--

CREATE TABLE `company` (
  `Company_Id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `address1` varchar(100) NOT NULL,
  `address2` varchar(100) DEFAULT NULL,
  `city` varchar(50) NOT NULL,
  `state` varchar(50) NOT NULL,
  `zip_code` varchar(20) NOT NULL,
  `country` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `created_date` date NOT NULL,
  `is_active` tinyint(1) NOT NULL DEFAULT '1',
  `is_deleted` tinyint(1) DEFAULT '0',
  `deleted_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `company`
--

INSERT INTO `company` (`Company_Id`, `name`, `address1`, `address2`, `city`, `state`, `zip_code`, `country`, `email`, `phone`, `created_date`, `is_active`, `is_deleted`, `deleted_date`) VALUES
(5, 'Money transfers', 'test', 'test', 'delhi', 'delhi', '110027', 'India', 'test@gmail.com', '1234567890', '2017-10-03', 1, 0, NULL),
(6, 'test company', 'test', 'test', 'delhi', 'delhi', '110027', 'India', 'testcompany@gmail.com', '1234567890', '2017-10-04', 1, 0, NULL),
(7, 'ishutesting', 'nandpur', 'nandpur bhatoli', 'Kangra', 'Hp', '176033', 'India', 'ishucom@gmail.com', '1234567890', '2017-10-04', 1, 0, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(11) NOT NULL,
  `Company_Id` int(11) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `profile_image` varchar(100) DEFAULT NULL,
  `is_active` tinyint(1) NOT NULL DEFAULT '1',
  `create_date` date NOT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0',
  `deleted_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `Company_Id`, `first_name`, `last_name`, `email`, `phone`, `password`, `profile_image`, `is_active`, `create_date`, `is_deleted`, `deleted_date`) VALUES
(1, 5, 'testishu', 'kumar', 'karaluthra@live.com', '123456789', '8CB2237D0679CA88DB6464EAC60DA96345513964', 'trytrtyr', 1, '2017-10-03', 1, '2017-10-03'),
(5, 5, 'ishu', 'kumar', 'ishu@gmail.com', '123456789', '8CB2237D0679CA88DB6464EAC60DA96345513964', NULL, 1, '2017-10-04', 0, NULL),
(6, 5, 'aaa', 'kumar', 'aa@gmail.com', '123456789', '8CB2237D0679CA88DB6464EAC60DA96345513964', NULL, 1, '2017-10-04', 0, NULL),
(7, 6, 'testloop', 'giru', 'giru@gmail.com', '123456789', '8CB2237D0679CA88DB6464EAC60DA96345513964', NULL, 1, '2017-10-04', 0, NULL),
(8, 6, 'zzz', 'zzz', 'zz@gmail.com', '123456789', '8CB2237D0679CA88DB6464EAC60DA96345513964', NULL, 1, '2017-10-04', 0, NULL),
(9, 6, 'bbb', 'bb', 'bb@gmail.com', '123456789', '8CB2237D0679CA88DB6464EAC60DA96345513964', NULL, 1, '2017-10-04', 0, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`Company_Id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD KEY `customer_Id` (`Company_Id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `company`
--
ALTER TABLE `company`
  MODIFY `Company_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`Company_Id`) REFERENCES `company` (`Company_Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
