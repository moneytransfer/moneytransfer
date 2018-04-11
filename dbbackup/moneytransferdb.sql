-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 11, 2018 at 01:53 PM
-- Server version: 5.7.19-0ubuntu0.16.04.1
-- PHP Version: 7.0.22-0ubuntu0.16.04.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `moneytransferdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `agent`
--

CREATE TABLE `agent` (
  `AgentId` int(11) NOT NULL,
  `AgentFirstName` varchar(100) NOT NULL,
  `SecondName` varchar(50) DEFAULT NULL,
  `AgentLastName` varchar(50) DEFAULT NULL,
  `SecondLastName` varchar(50) DEFAULT NULL,
  `Company_Id` int(11) NOT NULL,
  `country_id` int(11) NOT NULL,
  `SuperAgent` varchar(50) NOT NULL,
  `Phone` varchar(15) NOT NULL,
  `AgentCode` varchar(100) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `SerialNumberPrefix` varchar(100) NOT NULL,
  `Address1` varchar(200) NOT NULL,
  `Address2` varchar(200) DEFAULT NULL,
  `SerialNumberLength` varchar(50) NOT NULL,
  `City` varchar(50) NOT NULL,
  `PostalCode` varchar(20) NOT NULL,
  `BureauDeChange` tinyint(1) NOT NULL DEFAULT '0',
  `IsAllowedCreateAgent` tinyint(1) NOT NULL DEFAULT '0',
  `AllowedCasiherTellerApproval` tinyint(1) NOT NULL DEFAULT '0',
  `ApproveeachTransByCashierTeller` tinyint(1) NOT NULL DEFAULT '0',
  `CreateComplianceGroup` tinyint(1) NOT NULL DEFAULT '0',
  `AssignAdminToAgent` int(11) NOT NULL DEFAULT '0',
  `CreatedDate` datetime NOT NULL,
  `IsActive` tinyint(1) NOT NULL DEFAULT '1',
  `IsDeleted` tinyint(1) NOT NULL DEFAULT '0',
  `DeletedDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `agent`
--

INSERT INTO `agent` (`AgentId`, `AgentFirstName`, `SecondName`, `AgentLastName`, `SecondLastName`, `Company_Id`, `country_id`, `SuperAgent`, `Phone`, `AgentCode`, `Email`, `SerialNumberPrefix`, `Address1`, `Address2`, `SerialNumberLength`, `City`, `PostalCode`, `BureauDeChange`, `IsAllowedCreateAgent`, `AllowedCasiherTellerApproval`, `ApproveeachTransByCashierTeller`, `CreateComplianceGroup`, `AssignAdminToAgent`, `CreatedDate`, `IsActive`, `IsDeleted`, `DeletedDate`) VALUES
(-1, 'N/A', 'N/A', 'N/A', 'N/A', 17, 99, 'N/A', '676767676', '4454545', 'na@gmail.com', 'N/A', 'N/A', 'N/A', 'rre', 'N/A', '432234', 0, 0, 0, 0, 0, 0, '2018-03-21 00:00:00', 1, 0, NULL),
(0, 'All', 'All', 'All', 'All', 17, 99, 'All', '8798787465465', 'all01', 'all@gmail.com', '23', 'All', 'All', '2', 'All', '12365', 0, 0, 0, 0, 0, 0, '2018-03-01 00:00:00', 1, 0, NULL),
(1, 'Wallmart', 'Gerry', 'Terry', 'Zurry', 17, 150, 'Marshal', '5879566255', '7008', 'marshal@gmail.com', 'dom', 'delhi', 'Rajouri', '25', 'uuy', '222222', 1, 1, 1, 1, 1, 1, '2018-02-14 07:22:19', 0, 0, NULL),
(2, 'Tinkle', 'Jorg', 'Herry', 'mart', 17, 150, 'Tinkle', '5879566255', '7880', 'tinkle@gmail.com', 'dom', 'delhi', 'Rajouri', '25', 'uuy', '222222', 1, 1, 1, 1, 1, 1, '2018-02-14 07:23:16', 1, 0, NULL),
(3, 'Tijuna', 'mart', 'shop', '36', 17, 230, 'Sendingloop', '8010276833', '0952', 'tijuna@gmail.com', 'mr.', 'usa', 'usa 3', '20', 'Greek test', '25874', 0, 0, 0, 0, 0, 0, '2018-02-14 08:48:36', 1, 0, NULL),
(5, 'Visa Credit Card', 'Visa Credit Card', '.', 'Visa Credit Card', 17, 139, 'Visa Credit Card', '76547654654', '4175', 'visa@gmail.com', 'test', 'Visa', 'Credit', '34', 'Card', '564564', 0, 0, 0, 0, 0, 0, '2018-04-05 08:06:45', 1, 0, NULL),
(6, 'MasterCard Credit Card', 'MasterCard', '.', 'MasterCard', 17, 139, 'MasterCard', '6765756', '7317', 'MasterCard@gmail.com', '34', 'MasterCard', NULL, '3', 'MasterCard', '554456', 0, 0, 0, 0, 0, 0, '2018-04-05 08:08:24', 1, 0, NULL),
(7, 'Visa Debit Card', 'Visa', '.', 'Visa', 17, 139, 'Visa', '55345', '5320', 'Visa@gmail.com', '3', 'Visa', NULL, '4', 'Visa', '2345345', 0, 0, 0, 0, 0, 0, '2018-04-05 08:09:08', 1, 0, NULL),
(8, 'MasterCard Debit Card', 'MasterCard Debit', '.', 'MasterCard Debit', 17, 139, 'MasterCard Debit', '6546546546', '3769', 'MasterCardDebit@gmail.com', '3', 'MasterCard Debit', 'MasterCard Debit', '54', 'MasterCard Debit', '55345345345345', 0, 0, 0, 0, 0, 0, '2018-04-05 08:09:49', 1, 0, NULL),
(9, 'Visa Gift Card', 'Visa', '0', 'Gift', 17, 139, 'Gift', '454354353453453', '3707', 'Gift@gmail.com', '34', 'Gift', 'Gift', '454', 'Gift', '24234234234', 0, 0, 0, 0, 0, 0, '2018-04-05 08:10:24', 1, 0, NULL),
(10, 'MasterCard Gift Card', 'Gift Card', '.', 'Gift Card', 17, 139, 'Gift Card', '355252525235', '5243', 'GiftCard@gmail.com', '34', 'Gift Card', 'Gift Card', '25', 'Gift Card', '523235235325', 0, 0, 0, 0, 0, 0, '2018-04-05 08:11:06', 1, 0, NULL),
(11, 'Visa Voucher', 'Visa Voucher', '.', 'Visa Voucher', 17, 139, 'Visa Voucher', '23325325325', '4287', 'VisaVoucher@gmail.com', '42', 'Visa Voucher', 'Visa Voucher', '43', 'Visa Voucher', '3534534534', 0, 0, 0, 0, 0, 0, '2018-04-05 08:11:36', 1, 0, NULL),
(12, 'MasterCard Voucher', 'MasterCard Voucher', '.', 'MasterCard Voucher', 17, 139, 'MasterCard Voucher', '45345433443435', '5700', 'MasterCardVoucher@gmail.com', '24', 'MasterCard Voucher', 'MasterCard Voucher', '42', 'MasterCard Voucher', '342323325', 0, 0, 0, 0, 0, 0, '2018-04-05 08:12:06', 1, 0, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `authorizepaymentsettings`
--

CREATE TABLE `authorizepaymentsettings` (
  `AuthorizePaymentSettingsId` int(11) NOT NULL,
  `PaymentMethodId` int(11) NOT NULL,
  `Mode` varchar(50) NOT NULL,
  `PaymentUrl` varchar(200) NOT NULL,
  `MerchantLoginId` varchar(100) NOT NULL,
  `MerchantTransactionKey` varchar(100) NOT NULL,
  `Server` varchar(100) DEFAULT NULL,
  `Port` varchar(100) DEFAULT NULL,
  `IsActive` tinyint(1) NOT NULL DEFAULT '1',
  `IsDeleted` tinyint(1) NOT NULL DEFAULT '0',
  `CreatedDate` date NOT NULL,
  `DeletedDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `authorizepaymentsettings`
--

INSERT INTO `authorizepaymentsettings` (`AuthorizePaymentSettingsId`, `PaymentMethodId`, `Mode`, `PaymentUrl`, `MerchantLoginId`, `MerchantTransactionKey`, `Server`, `Port`, `IsActive`, `IsDeleted`, `CreatedDate`, `DeletedDate`) VALUES
(1, 1, 'TEST', 'https://test.authorize.net/gateway/transact.dll', '6cUR4e9b', '8Q6338wTVa647Rfe', NULL, NULL, 0, 0, '2018-02-05', NULL),
(5, 12, 'TEST', 'https://secure.magicpaygateway.com/api/transact.php', 'magicpay', 'magicpay123', 'secure.magicpaygateway.com', '443', 1, 0, '2018-04-09', NULL),
(6, 15, 'TEST', 'https://secure.magicpaygateway.com/api/transact.php', 'magicpay', 'magicpay123', 'secure.magicpaygateway.com', '443', 1, 0, '2018-04-09', NULL),
(7, 21, 'TEST', 'https://secure.magicpaygateway.com/api/transact.php', 'magicpay', 'magicpay123', 'secure.magicpaygateway.com', '443', 1, 0, '2018-04-09', NULL),
(8, 22, 'TEST', 'https://secure.magicpaygateway.com/api/transact.php', 'magicpay', 'magicpay123', 'secure.magicpaygateway.com', '443', 1, 0, '2018-04-09', NULL),
(9, 23, 'TEST', 'https://secure.magicpaygateway.com/api/transact.php', 'magicpay', 'magicpay123', 'secure.magicpaygateway.com', '443', 1, 0, '2018-04-09', NULL),
(12, 26, 'TEST', 'https://secure.magicpaygateway.com/api/transact.php', 'magicpay', 'magicpay123', 'secure.magicpaygateway.com', '443', 1, 0, '2018-04-09', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `beneficiary`
--

CREATE TABLE `beneficiary` (
  `BeneficiaryId` int(11) NOT NULL,
  `CompanyId` int(11) NOT NULL,
  `BeneficiaryTypeId` int(11) NOT NULL,
  `CustomerId` int(11) NOT NULL,
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `Phone` varchar(50) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Address1` varchar(50) NOT NULL,
  `Address2` varchar(50) NOT NULL,
  `City` varchar(50) NOT NULL,
  `State` varchar(50) NOT NULL,
  `ZipCode` varchar(50) NOT NULL,
  `CountryId` int(11) NOT NULL,
  `DOB` datetime NOT NULL,
  `IsActive` tinyint(1) NOT NULL DEFAULT '1',
  `BankName` varchar(100) DEFAULT NULL,
  `AccountNumber` varchar(100) DEFAULT NULL,
  `RoutingNumber` varchar(100) DEFAULT NULL,
  `BICCode` varchar(100) DEFAULT NULL,
  `IsDeleted` tinyint(1) NOT NULL DEFAULT '0',
  `CreatedDate` datetime NOT NULL,
  `DeletedDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `beneficiary`
--

INSERT INTO `beneficiary` (`BeneficiaryId`, `CompanyId`, `BeneficiaryTypeId`, `CustomerId`, `FirstName`, `LastName`, `Phone`, `Email`, `Address1`, `Address2`, `City`, `State`, `ZipCode`, `CountryId`, `DOB`, `IsActive`, `BankName`, `AccountNumber`, `RoutingNumber`, `BICCode`, `IsDeleted`, `CreatedDate`, `DeletedDate`) VALUES
(0, 17, 2, 8, 'Test ', 'User', '1234567890', 'testuser@gmail.com', 'test', 'test', 'test', 'test', '12345', 226, '2017-12-20 00:00:00', 1, NULL, NULL, NULL, NULL, 1, '2017-12-04 00:00:00', '2018-01-01 00:00:00'),
(1, 17, 1, 8, 'Ram', 'Rahim', '1234567890', 'ram@gmail.com', 'Ashok Nagar', 'NCR', 'Delhi', 'Delhi NCR', '110027', 98, '2017-01-01 00:00:00', 1, 'Friends bank', '21324564564', '0101234567', '1231231230', 0, '2017-10-30 20:55:22', NULL),
(2, 17, 1, 8, 'Suresh', 'Mohil', '8010276833', 'suresh@gmail.com', 'nahan', 'jamli', 'Kangra', 'HP', '110027', 226, '2017-01-01 00:00:00', 0, 'test bank', '4435435435345', '345435435', '5345435435', 0, '2017-10-31 11:18:19', NULL),
(3, 17, 1, 8, 'abc', 'pindu', '7894561230', 'saa@gmail.com', 'galino 10', 'chd', 'ch', 'UT', '110014', 226, '2017-01-01 00:00:00', 1, NULL, NULL, NULL, NULL, 0, '2017-10-31 11:41:45', NULL),
(4, 17, 1, 8, 'uuu', 'yy', '1234567890', 'yy@gmail.com', 'delhi', 'ncr', 'delhi', 'delhi ncr', '110027', 226, '2017-01-01 00:00:00', 1, NULL, NULL, NULL, NULL, 0, '2017-10-31 12:53:37', NULL),
(5, 17, 1, 8, 'abu', 'yadav', '1234567890', 'abu@gmail.com', 'delhi', 'ncr', 'delhi', 'delhi ncr', '110027', 226, '2017-01-01 00:00:00', 1, NULL, NULL, NULL, NULL, 0, '2017-10-31 16:10:29', NULL),
(6, 17, 1, 8, 'Javed', 'Kumar', '1234567890', 'javed@gmail.com', 'delhi', 'ncr', 'delhi', 'delhi ncr', '110027', 226, '2017-01-01 00:00:00', 1, 'Dena Bank', '1232232213223', '232312323223', '12312323232', 0, '2017-11-03 11:05:39', NULL),
(7, 17, 1, 15, 'dsf', 'terte', '43545435435345', 'dsf@gmail.com', 'retret', 'tretret', 'ertert', 'retert', '435454354', 17, '2017-12-20 00:00:00', 1, 'SBI Bank', '9844578787865', '0125', '54564564564', 0, '2017-12-20 14:06:45', NULL),
(8, 17, 1, 8, 'checktest12', 'User13', '7897824152', 'test12@gmail.com', 'sdfdnmnfgd', '', 'Almora', 'Uttarakhand', '263653', 99, '2017-12-31 00:00:00', 1, NULL, NULL, NULL, NULL, 0, '2018-01-24 14:31:29', NULL),
(9, 17, 1, 26, 'ishu', 'dad', '344324234234', 'daa@gmail.com', 'sdfsdff', 'fsdfs', 'sdfsdf', 'fsfsdf', '3345345', 13, '2018-01-17 00:00:00', 1, NULL, NULL, NULL, NULL, 0, '2018-01-24 14:37:22', NULL),
(10, 17, 1, 8, 'My text customer', 'Test12', '7895129743', 'Customer@gmail.com', 'My First Address', '', 'Almora', 'Uttarakhand', '263653', 99, '2018-01-31 00:00:00', 1, NULL, NULL, NULL, NULL, 0, '2018-01-24 14:44:02', NULL),
(11, 17, 1, 8, 'Elektra', 'Elektra', '2036548753', 'pi@gmail.com', 'sadfs', '', 'sdfsdf', 'sdfas', '96542', 1, '2018-02-08 00:00:00', 0, NULL, NULL, NULL, NULL, 0, '2018-01-31 21:54:59', NULL),
(12, 17, 1, 8, 'rajeev', 'Kumar', '1234567890', 'rk@gmail.com', 'delhi', 'ncr', 'delhi', 'delhi ncr', '110027', 50, '2017-01-01 00:00:00', 1, 'State Bank Of India', '5465456456456465456', '1023', '7798798789798798', 0, '2018-02-06 08:56:30', NULL),
(13, 17, 1, 8, 'ishu', 'kumar', '4354545645645', 'ishu@gmail.com', 'jkhjh', 'jhkjkhjkh', 'jhjkhjkh', 'jhjkhkjh', '7678657', 98, '1988-05-11 00:00:00', 1, 'PNB', '564756454564564', '02252', '5456454564564', 0, '2018-02-06 10:23:42', NULL),
(14, 17, 1, 8, 'manu', 'kumar', '9874563210', 'manu@gmail.com', 'Chandigarh', 'Punjab', 'Dhanas', 'UT', '110028', 98, '1990-02-10 00:00:00', 1, 'ICICI Bank', '98745632002252', '0269', '9871425454564', 0, '2018-02-06 13:59:33', NULL),
(15, 17, 1, 8, 'marry', 'John', '545665456456', 'marry@gmail.com', 'USA', 'zailko', 'King', 'FL', '10028', 230, '1988-05-11 00:00:00', 1, 'Baroda Bank', '4654654564654', '0252', '1232114564564', 0, '2018-02-16 08:48:42', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `beneficiarytype`
--

CREATE TABLE `beneficiarytype` (
  `BeneficiaryTypeId` int(11) NOT NULL,
  `BeneficiaryDescription` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `beneficiarytype`
--

INSERT INTO `beneficiarytype` (`BeneficiaryTypeId`, `BeneficiaryDescription`) VALUES
(1, 'Individual'),
(2, 'BillPay');

-- --------------------------------------------------------

--
-- Table structure for table `billpaydetails`
--

CREATE TABLE `billpaydetails` (
  `BillPayId` int(11) NOT NULL,
  `CompanyId` int(11) NOT NULL,
  `CustomerId` int(11) NOT NULL,
  `TransactionId` int(11) NOT NULL,
  `SenderName` varchar(200) NOT NULL,
  `MobileNumber` varchar(50) NOT NULL,
  `Version` varchar(50) NOT NULL,
  `SkuId` varchar(250) NOT NULL,
  `InvoiceNumber` varchar(200) NOT NULL,
  `TransactionDate` datetime NOT NULL,
  `InvoiceAmount` decimal(18,2) NOT NULL,
  `FaceValueAmount` decimal(18,2) NOT NULL,
  `ResponseCode` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `billpaydetails`
--

INSERT INTO `billpaydetails` (`BillPayId`, `CompanyId`, `CustomerId`, `TransactionId`, `SenderName`, `MobileNumber`, `Version`, `SkuId`, `InvoiceNumber`, `TransactionDate`, `InvoiceAmount`, `FaceValueAmount`, `ResponseCode`) VALUES
(1, 17, 8, 1, 'swag', '456465465456456', '1.0', '1560', '', '2018-02-23 10:08:26', '24.99', '0.00', '000'),
(2, 17, 8, 2, 'zolly', '521234567890', '1.0', '1560', '', '2018-02-23 10:10:12', '6.99', '0.00', '000'),
(3, 17, 8, 4, 'zolly', '521234567890', '1.0', '1560', '', '2018-02-23 14:45:30', '11.48', '0.00', '000'),
(4, 17, 8, 5, 'zolly', '521234567890', '1.0', '1560', '', '2018-02-26 18:04:52', '13.48', '0.00', '000'),
(5, 17, 8, 6, 'zolly', '521234567890', '1.0', '1560', '', '2018-02-27 07:08:33', '11.48', '0.00', '000'),
(6, 17, 8, 8, 'zolly', '521234567890', '1.0', '1560', '', '2018-02-28 10:27:58', '11.98', '0.00', '000'),
(7, 17, 8, 9, 'zolly', '521234567890', '1.0', '1560', '', '2018-03-01 09:17:15', '11.48', '0.00', '000'),
(8, 17, 8, 10, 'zolly', '52645655465464560', '1.0', '1560', '', '2018-03-01 12:25:06', '16.47', '0.00', '000'),
(9, 17, 8, 11, 'zolly', '52521234567890', '1.0', '1560', '', '2018-03-01 12:32:11', '19.97', '0.00', '000'),
(10, 17, 8, 12, 'zolly', '52521234567890', '1.0', '1560', '', '2018-03-01 12:33:32', '19.97', '0.00', '000'),
(11, 17, 8, 13, 'zolly', '52521234567890', '1.0', '1560', '', '2018-03-01 12:35:52', '19.97', '0.00', '000'),
(12, 17, 8, 14, 'zolly', '52521234567890', '1.0', '1560', '', '2018-03-01 12:36:51', '14.98', '0.00', '000'),
(13, 17, 8, 15, 'zolly', '52521234567890', '1.0', '1560', '', '2018-03-01 12:55:10', '10.98', '0.00', '000'),
(14, 17, 8, 16, 'zolly', '525929825696', '1.0', '1560', '', '2018-03-01 12:59:19', '11.98', '0.00', '000'),
(15, 17, 8, 17, 'zolly', '52521234567890', '1.0', '1560', '', '2018-03-01 13:05:35', '14.98', '0.00', '000'),
(16, 17, 8, 18, 'zolly', '52521234567890', '1.0', '1560', '', '2018-03-01 13:27:22', '11.48', '0.00', '000'),
(17, 17, 8, 23, 'zolly', '52521298979789', '1.0', '1560', '', '2018-03-05 09:40:58', '104.99', '0.00', '000'),
(18, 17, 8, 25, 'zolly', '521298979789', '1.0', '1560', '', '2018-03-05 10:37:34', '12.48', '0.00', '000'),
(19, 17, 8, 27, 'zolly', '521298979789', '1.0', '1560', '', '2018-03-05 11:42:52', '8.48', '0.00', '000'),
(20, 17, 8, 34, 'zolly', '521234567890', '1.0', '1560', '', '2018-03-07 08:14:22', '10.99', '0.00', '000'),
(21, 17, 8, 35, 'ram ranjana kumari', '9599902190', '1.0', '1560', '18495095', '2018-03-07 03:17:54', '14.99', '9.00', '000'),
(22, 17, 8, 36, 'zolly', '521298979789', '1.0', '1560', '', '2018-03-07 09:36:55', '6.99', '0.00', '000'),
(23, 17, 8, 37, 'zolly', '521298979789', '1.0', '1560', '', '2018-03-07 10:35:35', '11.99', '0.00', '000'),
(24, 17, 8, 38, 'zolly', '521298979789', '1.0', '1560', '', '2018-03-07 10:37:56', '27.99', '0.00', '000'),
(25, 17, 8, 40, 'zolly', '521234567890', '1.0', '1560', '', '2018-03-14 14:39:58', '8.99', '0.00', '000'),
(26, 17, 8, 44, 'zolly', '52521298979789', '1.0', '1560', '', '2018-03-19 10:43:33', '5.49', '0.00', '000'),
(27, 17, 8, 45, 'zolly', '52521202588555', '1.0', '1560', '', '2018-03-19 10:49:40', '4.99', '0.00', '000'),
(28, 17, 8, 46, 'zolly', '521298979789', '1.0', '1560', '', '2018-03-19 11:20:21', '7.99', '0.00', '000'),
(29, 17, 8, 49, 'zolly', '52129897978945', '1.0', '1560', '', '2018-03-19 11:29:29', '7.99', '0.00', '000'),
(30, 17, 8, 50, 'zolly', '521298979789435', '1.0', '1560', '', '2018-03-19 11:31:04', '103.99', '0.00', '000'),
(31, 17, 8, 51, 'zolly', '521234567890', '1.0', '1560', '', '2018-04-02 07:07:36', '2.99', '0.00', '000'),
(32, 17, 8, 52, 'zolly', '527974756456', '1.0', '1560', '', '2018-04-02 07:29:38', '9.99', '0.00', '000'),
(33, 17, 8, 53, 'zolly', '52551515165156170', '1.0', '1560', '', '2018-04-02 12:14:03', '5.89', '0.00', '000'),
(34, 17, 8, 54, 'zolly', '521234567890', '1.0', '1560', '', '2018-04-02 13:15:02', '3.99', '0.00', '000'),
(35, 17, 8, 55, 'zolly', '5212345678', '1.0', '1560', '', '2018-04-04 07:44:08', '11.59', '0.00', '000'),
(36, 17, 8, 56, 'zolly', '521234567890', '1.0', '1560', '', '2018-04-04 15:33:04', '3.49', '0.00', '000'),
(37, 17, 8, 57, 'zolly', '525553423453', '1.0', '1560', '', '2018-04-06 03:38:59', '11.69', '0.00', '000'),
(38, 17, 8, 58, 'zolly', '521234567890', '1.0', '1560', '', '2018-04-09 06:52:32', '8.00', '0.00', '000'),
(39, 17, 8, 59, 'zolly', '521247410258', '1.0', '1560', '', '2018-04-09 07:17:44', '1.00', '0.00', '000'),
(40, 17, 8, 60, 'zolly', '521247410258', '1.0', '1560', '', '2018-04-09 07:18:20', '7.00', '0.00', '000'),
(41, 17, 8, 61, 'zolly', '521234567890', '1.0', '1560', '', '2018-04-09 07:28:55', '4.10', '0.00', '000'),
(42, 17, 8, 62, 'zolly', '521234567890', '1.0', '1560', '', '2018-04-09 07:30:24', '7.00', '0.00', '000'),
(43, 17, 8, 63, 'zolly', '521234567890', '1.0', '1560', '', '2018-04-09 07:30:48', '3.00', '0.00', '000'),
(44, 17, 8, 64, 'zolly', '521234567890', '1.0', '1560', '', '2018-04-09 07:31:27', '2.00', '0.00', '000'),
(45, 17, 8, 65, 'zolly', '521234567890', '1.0', '1560', '', '2018-04-09 07:32:20', '12.69', '0.00', '000'),
(46, 17, 8, 66, 'zolly', '52147956514444', '1.0', '1560', '', '2018-04-09 07:34:16', '11.69', '0.00', '000'),
(47, 17, 8, 67, 'zolly', '5212021020125', '1.0', '1560', '', '2018-04-09 07:44:00', '8.00', '0.00', '000'),
(48, 17, 8, 68, 'zolly', '5214795852252', '1.0', '1560', '', '2018-04-09 07:56:41', '3.00', '0.00', '000'),
(49, 17, 8, 69, 'zolly', '5212345678', '1.0', '1560', '', '2018-04-09 07:57:54', '1.00', '0.00', '000'),
(50, 17, 8, 70, 'zolly', '52147899666', '1.0', '1560', '', '2018-04-09 07:59:59', '3.00', '0.00', '000'),
(51, 17, 8, 71, 'ram ranjana kumari', '9599902190', '1.0', '1560', '18795827', '2018-04-09 03:01:59', '10.00', '9.00', '000'),
(52, 17, 8, 72, 'zolly', '521478969633366', '1.0', '1560', '', '2018-04-09 08:03:14', '1.00', '0.00', '000'),
(53, 17, 8, 73, 'zolly', '5212459874102', '1.0', '1560', '', '2018-04-09 13:34:01', '4.00', '0.00', '000'),
(54, 17, 8, 74, 'zolly', '5212459874102', '1.0', '1560', '', '2018-04-09 13:34:51', '22.00', '0.00', '000');

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
  `country_id` int(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `business_fax` varchar(20) NOT NULL,
  `contact_person` varchar(50) NOT NULL,
  `contact_title` varchar(50) NOT NULL,
  `number_employees` varchar(50) NOT NULL,
  `annual_revenue` double NOT NULL,
  `industry` varchar(50) NOT NULL,
  `sub_industry` varchar(50) NOT NULL,
  `sic_code` varchar(50) NOT NULL,
  `sic_description` varchar(500) NOT NULL,
  `website` varchar(50) NOT NULL,
  `company_number` varchar(50) NOT NULL,
  `business_id` varchar(50) NOT NULL,
  `company_type` varchar(50) NOT NULL,
  `incorporation_date` date DEFAULT NULL,
  `listofficers_duedate` date DEFAULT NULL,
  `businesslicense_expdate` date DEFAULT NULL,
  `created_date` date NOT NULL,
  `is_active` tinyint(1) NOT NULL DEFAULT '1',
  `is_deleted` tinyint(1) DEFAULT '0',
  `deleted_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `company`
--

INSERT INTO `company` (`Company_Id`, `name`, `address1`, `address2`, `city`, `state`, `zip_code`, `country_id`, `email`, `phone`, `business_fax`, `contact_person`, `contact_title`, `number_employees`, `annual_revenue`, `industry`, `sub_industry`, `sic_code`, `sic_description`, `website`, `company_number`, `business_id`, `company_type`, `incorporation_date`, `listofficers_duedate`, `businesslicense_expdate`, `created_date`, `is_active`, `is_deleted`, `deleted_date`) VALUES
(0, 'Moneytransfer', 'test1', 'test', 'delhi', 'delhi', '110027', 226, 'moneytransfer@gmail.com', '1234567890', '12345', 'money', 'Mr.', '4', 200000, 'it company', 'partnership', '1111', 'test way', 'www.test.com', '11112122', 'tttt', 'test', NULL, NULL, NULL, '2017-10-10', 1, 1, '2017-10-10'),
(17, 'moneyishucase', 'noida', 'test', 'delhi', 'delhi', '110027', 226, 'moneytestcase@gmail.com', '1234567890', '12345', 'moneytestcase', 'Mr.', '40', 102356, 'Sale company', 'partnership', '1111', 'test way', 'www.test.com', '11112122', 'tttt', 'test', NULL, NULL, NULL, '2017-10-25', 1, 0, NULL),
(20, 'Moneytransfer', 'abcd', 'test', 'delhi', 'delhi', '110027', 226, 'testsuper@gmail.com', '1234567890', '12345', 'money', 'Mr.', '4', 200000, 'it company', 'partnership', '1111', 'test way', 'www.test.com', '11112122', 'tttt', 'test', NULL, NULL, NULL, '2017-10-26', 1, 0, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `country`
--

CREATE TABLE `country` (
  `country_id` int(11) NOT NULL,
  `country_name` varchar(100) NOT NULL,
  `iso` varchar(5) NOT NULL,
  `phonecode` int(11) NOT NULL,
  `currency_name` varchar(20) NOT NULL,
  `currency_symbol` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `currency_code` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `country`
--

INSERT INTO `country` (`country_id`, `country_name`, `iso`, `phonecode`, `currency_name`, `currency_symbol`, `currency_code`) VALUES
(1, 'Afghanistan', 'af', 93, 'Afghan afghani', '؋', 'AFN'),
(2, 'Aland Islands', 'ax', 358, '', '', ''),
(3, 'Albania', 'al', 355, 'Albanian lek', 'L', 'ALL'),
(4, 'Algeria', 'dz', 213, 'Algerian dinar', 'د.ج', 'DZD'),
(5, 'AmericanSamoa', 'as', 1684, '', '', ''),
(6, 'Andorra', 'ad', 376, 'Euro', '€', 'EUR'),
(7, 'Angola', 'ao', 244, 'Angolan kwanza', 'Kz', 'AOA'),
(8, 'Anguilla', 'ai', 1264, 'East Caribbean dolla', '$', 'XCD'),
(9, 'Antarctica', 'aq', 672, '', '', ''),
(10, 'Antigua and Barbuda', 'ag', 1268, 'East Caribbean dolla', '$', 'XCD'),
(11, 'Argentina', 'ar', 54, 'Argentine peso', '$', 'ARS'),
(12, 'Armenia', 'am', 374, 'Armenian dram', '', 'AMD'),
(13, 'Aruba', 'aw', 297, 'Aruban florin', 'ƒ', 'AWG'),
(14, 'Australia', 'au', 61, 'Australian dollar', '$', 'AUD'),
(15, 'Austria', 'at', 43, 'Euro', '€', 'EUR'),
(16, 'Azerbaijan', 'az', 994, 'Azerbaijani manat', '', 'AZN'),
(17, 'Bahamas', 'bs', 1242, '', '', ''),
(18, 'Bahrain', 'bh', 973, 'Bahraini dinar', '.د.ب', 'BHD'),
(19, 'Bangladesh', 'bd', 880, 'Bangladeshi taka', '৳', 'BDT'),
(20, 'Barbados', 'bb', 1246, 'Barbadian dollar', '$', 'BBD'),
(21, 'Belarus', 'by', 375, 'Belarusian ruble', 'Br', 'BYR'),
(22, 'Belgium', 'be', 32, 'Euro', '€', 'EUR'),
(23, 'Belize', 'bz', 501, 'Belize dollar', '$', 'BZD'),
(24, 'Benin', 'bj', 229, 'West African CFA fra', 'Fr', 'XOF'),
(25, 'Bermuda', 'bm', 1441, 'Bermudian dollar', '$', 'BMD'),
(26, 'Bhutan', 'bt', 975, 'Bhutanese ngultrum', 'Nu.', 'BTN'),
(27, 'Bolivia, Plurination', 'bo', 591, '', '', ''),
(28, 'Bosnia and Herzegovi', 'ba', 387, '', '', ''),
(29, 'Botswana', 'bw', 267, 'Botswana pula', 'P', 'BWP'),
(30, 'Brazil', 'br', 55, 'Brazilian real', 'R$', 'BRL'),
(31, 'British Indian Ocean', 'io', 246, '', '', ''),
(32, 'Brunei Darussalam', 'bn', 673, '', '', ''),
(33, 'Bulgaria', 'bg', 359, 'Bulgarian lev', 'лв', 'BGN'),
(34, 'Burkina Faso', 'bf', 226, 'West African CFA fra', 'Fr', 'XOF'),
(35, 'Burundi', 'bi', 257, 'Burundian franc', 'Fr', 'BIF'),
(36, 'Cambodia', 'kh', 855, 'Cambodian riel', '៛', 'KHR'),
(37, 'Cameroon', 'cm', 237, 'Central African CFA ', 'Fr', 'XAF'),
(38, 'Canada', 'ca', 1, 'Canadian dollar', '$', 'CAD'),
(39, 'Cape Verde', 'cv', 238, 'Cape Verdean escudo', 'Esc or $', 'CVE'),
(40, 'Cayman Islands', 'ky', 345, 'Cayman Islands dolla', '$', 'KYD'),
(41, 'Central African Repu', 'cf', 236, '', '', ''),
(42, 'Chad', 'td', 235, 'Central African CFA ', 'Fr', 'XAF'),
(43, 'Chile', 'cl', 56, 'Chilean peso', '$', 'CLP'),
(44, 'China', 'cn', 86, 'Chinese yuan', '¥ or 元', 'CNY'),
(45, 'Christmas Island', 'cx', 61, '', '', ''),
(46, 'Cocos (Keeling) Isla', 'cc', 61, '', '', ''),
(47, 'Colombia', 'co', 57, 'Colombian peso', '$', 'COP'),
(48, 'Comoros', 'km', 269, 'Comorian franc', 'Fr', 'KMF'),
(49, 'Congo', 'cg', 242, '', '', ''),
(50, 'Congo, The Democrati', 'cd', 243, '', '', ''),
(51, 'Cook Islands', 'ck', 682, 'New Zealand dollar', '$', 'NZD'),
(52, 'Costa Rica', 'cr', 506, 'Costa Rican colón', '₡', 'CRC'),
(53, 'Cote d\'Ivoire', 'ci', 225, 'West African CFA fra', 'Fr', 'XOF'),
(54, 'Croatia', 'hr', 385, 'Croatian kuna', 'kn', 'HRK'),
(55, 'Cuba', 'cu', 53, 'Cuban convertible pe', '$', 'CUC'),
(56, 'Cyprus', 'cy', 357, 'Euro', '€', 'EUR'),
(57, 'Czech Republic', 'cz', 420, 'Czech koruna', 'Kč', 'CZK'),
(58, 'Denmark', 'dk', 45, 'Danish krone', 'kr', 'DKK'),
(59, 'Djibouti', 'dj', 253, 'Djiboutian franc', 'Fr', 'DJF'),
(60, 'Dominica', 'dm', 1767, 'East Caribbean dolla', '$', 'XCD'),
(61, 'Dominican Republic', 'do', 1849, 'Dominican peso', '$', 'DOP'),
(62, 'Ecuador', 'ec', 593, 'United States dollar', '$', 'USD'),
(63, 'Egypt', 'eg', 20, 'Egyptian pound', '£ or ج.م', 'EGP'),
(64, 'El Salvador', 'sv', 503, 'United States dollar', '$', 'USD'),
(65, 'Equatorial Guinea', 'gq', 240, 'Central African CFA ', 'Fr', 'XAF'),
(66, 'Eritrea', 'er', 291, 'Eritrean nakfa', 'Nfk', 'ERN'),
(67, 'Estonia', 'ee', 372, 'Euro', '€', 'EUR'),
(68, 'Ethiopia', 'et', 251, 'Ethiopian birr', 'Br', 'ETB'),
(69, 'Falkland Islands (Ma', 'fk', 500, '', '', ''),
(70, 'Faroe Islands', 'fo', 298, 'Danish krone', 'kr', 'DKK'),
(71, 'Fiji', 'fj', 679, 'Fijian dollar', '$', 'FJD'),
(72, 'Finland', 'fi', 358, 'Euro', '€', 'EUR'),
(73, 'France', 'fr', 33, 'Euro', '€', 'EUR'),
(74, 'French Guiana', 'gf', 594, '', '', ''),
(75, 'French Polynesia', 'pf', 689, 'CFP franc', 'Fr', 'XPF'),
(76, 'Gabon', 'ga', 241, 'Central African CFA ', 'Fr', 'XAF'),
(77, 'Gambia', 'gm', 220, '', '', ''),
(78, 'Georgia', 'ge', 995, 'Georgian lari', 'ლ', 'GEL'),
(79, 'Germany', 'de', 49, 'Euro', '€', 'EUR'),
(80, 'Ghana', 'gh', 233, 'Ghana cedi', '₵', 'GHS'),
(81, 'Gibraltar', 'gi', 350, 'Gibraltar pound', '£', 'GIP'),
(82, 'Greece', 'gr', 30, 'Euro', '€', 'EUR'),
(83, 'Greenland', 'gl', 299, '', '', ''),
(84, 'Grenada', 'gd', 1473, 'East Caribbean dolla', '$', 'XCD'),
(85, 'Guadeloupe', 'gp', 590, '', '', ''),
(86, 'Guam', 'gu', 1671, '', '', ''),
(87, 'Guatemala', 'gt', 502, 'Guatemalan quetzal', 'Q', 'GTQ'),
(88, 'Guernsey', 'gg', 44, 'British pound', '£', 'GBP'),
(89, 'Guinea', 'gn', 224, 'Guinean franc', 'Fr', 'GNF'),
(90, 'Guinea-Bissau', 'gw', 245, 'West African CFA fra', 'Fr', 'XOF'),
(91, 'Guyana', 'gy', 595, 'Guyanese dollar', '$', 'GYD'),
(92, 'Haiti', 'ht', 509, 'Haitian gourde', 'G', 'HTG'),
(93, 'Holy See (Vatican Ci', 'va', 379, '', '', ''),
(94, 'Honduras', 'hn', 504, 'Honduran lempira', 'L', 'HNL'),
(95, 'Hong Kong', 'hk', 852, 'Hong Kong dollar', '$', 'HKD'),
(96, 'Hungary', 'hu', 36, 'Hungarian forint', 'Ft', 'HUF'),
(97, 'Iceland', 'is', 354, 'Icelandic króna', 'kr', 'ISK'),
(98, 'India', 'in', 91, 'Indian rupee', '₹', 'INR'),
(99, 'Indonesia', 'id', 62, 'Indonesian rupiah', 'Rp', 'IDR'),
(100, 'Iran, Islamic Republ', 'ir', 98, '', '', ''),
(101, 'Iraq', 'iq', 964, 'Iraqi dinar', 'ع.د', 'IQD'),
(102, 'Ireland', 'ie', 353, 'Euro', '€', 'EUR'),
(103, 'Isle of Man', 'im', 44, 'British pound', '£', 'GBP'),
(104, 'Israel', 'il', 972, 'Israeli new shekel', '₪', 'ILS'),
(105, 'Italy', 'it', 39, 'Euro', '€', 'EUR'),
(106, 'Jamaica', 'jm', 1876, 'Jamaican dollar', '$', 'JMD'),
(107, 'Japan', 'jp', 81, 'Japanese yen', '¥', 'JPY'),
(108, 'Jersey', 'je', 44, 'British pound', '£', 'GBP'),
(109, 'Jordan', 'jo', 962, 'Jordanian dinar', 'د.ا', 'JOD'),
(110, 'Kazakhstan', 'kz', 7, 'Kazakhstani tenge', '', 'KZT'),
(111, 'Kenya', 'ke', 254, 'Kenyan shilling', 'Sh', 'KES'),
(112, 'Kiribati', 'ki', 686, 'Australian dollar', '$', 'AUD'),
(113, 'Korea, Democratic Pe', 'kp', 850, '', '', ''),
(114, 'Korea, Republic of S', 'kr', 82, '', '', ''),
(115, 'Kuwait', 'kw', 965, 'Kuwaiti dinar', 'د.ك', 'KWD'),
(116, 'Kyrgyzstan', 'kg', 996, 'Kyrgyzstani som', 'лв', 'KGS'),
(117, 'Laos', 'la', 856, 'Lao kip', '₭', 'LAK'),
(118, 'Latvia', 'lv', 371, 'Euro', '€', 'EUR'),
(119, 'Lebanon', 'lb', 961, 'Lebanese pound', 'ل.ل', 'LBP'),
(120, 'Lesotho', 'ls', 266, 'Lesotho loti', 'L', 'LSL'),
(121, 'Liberia', 'lr', 231, 'Liberian dollar', '$', 'LRD'),
(122, 'Libyan Arab Jamahiri', 'ly', 218, '', '', ''),
(123, 'Liechtenstein', 'li', 423, 'Swiss franc', 'Fr', 'CHF'),
(124, 'Lithuania', 'lt', 370, 'Euro', '€', 'EUR'),
(125, 'Luxembourg', 'lu', 352, 'Euro', '€', 'EUR'),
(126, 'Macao', 'mo', 853, '', '', ''),
(127, 'Macedonia', 'mk', 389, '', '', ''),
(128, 'Madagascar', 'mg', 261, 'Malagasy ariary', 'Ar', 'MGA'),
(129, 'Malawi', 'mw', 265, 'Malawian kwacha', 'MK', 'MWK'),
(130, 'Malaysia', 'my', 60, 'Malaysian ringgit', 'RM', 'MYR'),
(131, 'Maldives', 'mv', 960, 'Maldivian rufiyaa', '.ރ', 'MVR'),
(132, 'Mali', 'ml', 223, 'West African CFA fra', 'Fr', 'XOF'),
(133, 'Malta', 'mt', 356, 'Euro', '€', 'EUR'),
(134, 'Marshall Islands', 'mh', 692, 'United States dollar', '$', 'USD'),
(135, 'Martinique', 'mq', 596, '', '', ''),
(136, 'Mauritania', 'mr', 222, 'Mauritanian ouguiya', 'UM', 'MRO'),
(137, 'Mauritius', 'mu', 230, 'Mauritian rupee', '₨', 'MUR'),
(138, 'Mayotte', 'yt', 262, '', '', ''),
(139, 'Mexico', 'mx', 52, 'Mexican peso', '$', 'MXN'),
(140, 'Micronesia, Federate', 'fm', 691, '', '', ''),
(141, 'Moldova', 'md', 373, 'Moldovan leu', 'L', 'MDL'),
(142, 'Monaco', 'mc', 377, 'Euro', '€', 'EUR'),
(143, 'Mongolia', 'mn', 976, 'Mongolian tögrög', '₮', 'MNT'),
(144, 'Montenegro', 'me', 382, 'Euro', '€', 'EUR'),
(145, 'Montserrat', 'ms', 1664, 'East Caribbean dolla', '$', 'XCD'),
(146, 'Morocco', 'ma', 212, 'Moroccan dirham', 'د.م.', 'MAD'),
(147, 'Mozambique', 'mz', 258, 'Mozambican metical', 'MT', 'MZN'),
(148, 'Myanmar', 'mm', 95, 'Burmese kyat', 'Ks', 'MMK'),
(149, 'Namibia', 'na', 264, 'Namibian dollar', '$', 'NAD'),
(150, 'Nauru', 'nr', 674, 'Australian dollar', '$', 'AUD'),
(151, 'Nepal', 'np', 977, 'Nepalese rupee', '₨', 'NPR'),
(152, 'Netherlands', 'nl', 31, 'Euro', '€', 'EUR'),
(153, 'Netherlands Antilles', 'an', 599, '', '', ''),
(154, 'New Caledonia', 'nc', 687, 'CFP franc', 'Fr', 'XPF'),
(155, 'New Zealand', 'nz', 64, 'New Zealand dollar', '$', 'NZD'),
(156, 'Nicaragua', 'ni', 505, 'Nicaraguan córdoba', 'C$', 'NIO'),
(157, 'Niger', 'ne', 227, 'West African CFA fra', 'Fr', 'XOF'),
(158, 'Nigeria', 'ng', 234, 'Nigerian naira', '₦', 'NGN'),
(159, 'Niue', 'nu', 683, 'New Zealand dollar', '$', 'NZD'),
(160, 'Norfolk Island', 'nf', 672, '', '', ''),
(161, 'Northern Mariana Isl', 'mp', 1670, '', '', ''),
(162, 'Norway', 'no', 47, 'Norwegian krone', 'kr', 'NOK'),
(163, 'Oman', 'om', 968, 'Omani rial', 'ر.ع.', 'OMR'),
(164, 'Pakistan', 'pk', 92, 'Pakistani rupee', '₨', 'PKR'),
(165, 'Palau', 'pw', 680, 'Palauan dollar', '$', ''),
(166, 'Palestinian Territor', 'ps', 970, '', '', ''),
(167, 'Panama', 'pa', 507, 'Panamanian balboa', 'B/.', 'PAB'),
(168, 'Papua New Guinea', 'pg', 675, 'Papua New Guinean ki', 'K', 'PGK'),
(169, 'Paraguay', 'py', 595, 'Paraguayan guaraní', '₲', 'PYG'),
(170, 'Peru', 'pe', 51, 'Peruvian nuevo sol', 'S/.', 'PEN'),
(171, 'Philippines', 'ph', 63, 'Philippine peso', '₱', 'PHP'),
(172, 'Pitcairn', 'pn', 872, '', '', ''),
(173, 'Poland', 'pl', 48, 'Polish z?oty', 'zł', 'PLN'),
(174, 'Portugal', 'pt', 351, 'Euro', '€', 'EUR'),
(175, 'Puerto Rico', 'pr', 1939, '', '', ''),
(176, 'Qatar', 'qa', 974, 'Qatari riyal', 'ر.ق', 'QAR'),
(177, 'Romania', 'ro', 40, 'Romanian leu', 'lei', 'RON'),
(178, 'Russia', 'ru', 7, 'Russian ruble', '', 'RUB'),
(179, 'Rwanda', 'rw', 250, 'Rwandan franc', 'Fr', 'RWF'),
(180, 'Reunion', 're', 262, '', '', ''),
(181, 'Saint Barthelemy', 'bl', 590, '', '', ''),
(182, 'Saint Helena, Ascens', 'sh', 290, '', '', ''),
(183, 'Saint Kitts and Nevi', 'kn', 1869, '', '', ''),
(184, 'Saint Lucia', 'lc', 1758, 'East Caribbean dolla', '$', 'XCD'),
(185, 'Saint Martin', 'mf', 590, '', '', ''),
(186, 'Saint Pierre and Miq', 'pm', 508, '', '', ''),
(187, 'Saint Vincent and th', 'vc', 1784, '', '', ''),
(188, 'Samoa', 'ws', 685, 'Samoan t?l?', 'T', 'WST'),
(189, 'San Marino', 'sm', 378, 'Euro', '€', 'EUR'),
(190, 'Sao Tome and Princip', 'st', 239, '', '', ''),
(191, 'Saudi Arabia', 'sa', 966, 'Saudi riyal', 'ر.س', 'SAR'),
(192, 'Senegal', 'sn', 221, 'West African CFA fra', 'Fr', 'XOF'),
(193, 'Serbia', 'rs', 381, 'Serbian dinar', 'дин. or din.', 'RSD'),
(194, 'Seychelles', 'sc', 248, 'Seychellois rupee', '₨', 'SCR'),
(195, 'Sierra Leone', 'sl', 232, 'Sierra Leonean leone', 'Le', 'SLL'),
(196, 'Singapore', 'sg', 65, 'Brunei dollar', '$', 'BND'),
(197, 'Slovakia', 'sk', 421, 'Euro', '€', 'EUR'),
(198, 'Slovenia', 'si', 386, 'Euro', '€', 'EUR'),
(199, 'Solomon Islands', 'sb', 677, 'Solomon Islands doll', '$', 'SBD'),
(200, 'Somalia', 'so', 252, 'Somali shilling', 'Sh', 'SOS'),
(201, 'South Africa', 'za', 27, 'South African rand', 'R', 'ZAR'),
(202, 'South Georgia and th', 'gs', 500, '', '', ''),
(203, 'Spain', 'es', 34, 'Euro', '€', 'EUR'),
(204, 'Sri Lanka', 'lk', 94, 'Sri Lankan rupee', 'Rs or රු', 'LKR'),
(205, 'Sudan', 'sd', 249, 'Sudanese pound', 'ج.س.', 'SDG'),
(206, 'Suriname', 'sr', 597, 'Surinamese dollar', '$', 'SRD'),
(207, 'Svalbard and Jan May', 'sj', 47, '', '', ''),
(208, 'Swaziland', 'sz', 268, 'Swazi lilangeni', 'L', 'SZL'),
(209, 'Sweden', 'se', 46, 'Swedish krona', 'kr', 'SEK'),
(210, 'Switzerland', 'ch', 41, 'Swiss franc', 'Fr', 'CHF'),
(211, 'Syrian Arab Republic', 'sy', 963, '', '', ''),
(212, 'Taiwan', 'tw', 886, 'New Taiwan dollar', '$', 'TWD'),
(213, 'Tajikistan', 'tj', 992, 'Tajikistani somoni', 'ЅМ', 'TJS'),
(214, 'Tanzania, United Rep', 'tz', 255, '', '', ''),
(215, 'Thailand', 'th', 66, 'Thai baht', '฿', 'THB'),
(216, 'Timor-Leste', 'tl', 670, '', '', ''),
(217, 'Togo', 'tg', 228, 'West African CFA fra', 'Fr', 'XOF'),
(218, 'Tokelau', 'tk', 690, '', '', ''),
(219, 'Tonga', 'to', 676, 'Tongan pa?anga', 'T$', 'TOP'),
(220, 'Trinidad and Tobago', 'tt', 1868, 'Trinidad and Tobago ', '$', 'TTD'),
(221, 'Tunisia', 'tn', 216, 'Tunisian dinar', 'د.ت', 'TND'),
(222, 'Turkey', 'tr', 90, 'Turkish lira', '', 'TRY'),
(223, 'Turkmenistan', 'tm', 993, 'Turkmenistan manat', 'm', 'TMT'),
(224, 'Turks and Caicos Isl', 'tc', 1649, '', '', ''),
(225, 'Tuvalu', 'tv', 688, 'Australian dollar', '$', 'AUD'),
(226, 'Uganda', 'ug', 256, 'Ugandan shilling', 'Sh', 'UGX'),
(227, 'Ukraine', 'ua', 380, 'Ukrainian hryvnia', '₴', 'UAH'),
(228, 'United Arab Emirates', 'ae', 971, 'United Arab Emirates', 'د.إ', 'AED'),
(229, 'United Kingdom', 'gb', 44, 'British pound', '£', 'GBP'),
(230, 'United States', 'us', 1, 'United States dollar', '$', 'USD'),
(231, 'Uruguay', 'uy', 598, 'Uruguayan peso', '$', 'UYU'),
(232, 'Uzbekistan', 'uz', 998, 'Uzbekistani som', '', 'UZS'),
(233, 'Vanuatu', 'vu', 678, 'Vanuatu vatu', 'Vt', 'VUV'),
(234, 'Venezuela, Bolivaria', 've', 58, '', '', ''),
(235, 'Vietnam', 'vn', 84, 'Vietnamese ??ng', '₫', 'VND'),
(236, 'Virgin Islands, Brit', 'vg', 1284, '', '', ''),
(237, 'Virgin Islands, U.S.', 'vi', 1340, '', '', ''),
(238, 'Wallis and Futuna', 'wf', 681, 'CFP franc', 'Fr', 'XPF'),
(239, 'Yemen', 'ye', 967, 'Yemeni rial', '﷼', 'YER'),
(240, 'Zambia', 'zm', 260, 'Zambian kwacha', 'ZK', 'ZMW'),
(241, 'Zimbabwe', 'zw', 263, 'Botswana pula', 'P', 'BWP');

-- --------------------------------------------------------

--
-- Table structure for table `countrytest`
--

CREATE TABLE `countrytest` (
  `country_id` int(11) NOT NULL,
  `iso` varchar(5) NOT NULL,
  `country_name` varchar(100) NOT NULL,
  `country_nicename` varchar(80) NOT NULL,
  `iso3` varchar(5) NOT NULL,
  `country_code` varchar(2) NOT NULL,
  `phonecode` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `countrytest`
--

INSERT INTO `countrytest` (`country_id`, `iso`, `country_name`, `country_nicename`, `iso3`, `country_code`, `phonecode`) VALUES
(1, 'AF', 'AFGHANISTAN', 'Afghanistan', 'AFG', '4', 93),
(2, 'AL', 'ALBANIA', 'Albania', 'ALB', '8', 355),
(3, 'DZ', 'ALGERIA', 'Algeria', 'DZA', '12', 213),
(4, 'AS', 'AMERICAN SAMOA', 'American Samoa', 'ASM', '16', 1684),
(5, 'AD', 'ANDORRA', 'Andorra', 'AND', '20', 376),
(6, 'AO', 'ANGOLA', 'Angola', 'AGO', '24', 244),
(7, 'AI', 'ANGUILLA', 'Anguilla', 'AIA', '66', 1264),
(8, 'AQ', 'ANTARCTICA', 'Antarctica', '', '', 0),
(9, 'AG', 'ANTIGUA AND BARBUDA', 'Antigua and Barbuda', 'ATG', '28', 1268),
(10, 'AR', 'ARGENTINA', 'Argentina', 'ARG', '32', 54),
(11, 'AM', 'ARMENIA', 'Armenia', 'ARM', '51', 374),
(12, 'AW', 'ARUBA', 'Aruba', 'ABW', '53', 297),
(13, 'AU', 'AUSTRALIA', 'Australia', 'AUS', '36', 61),
(14, 'AT', 'AUSTRIA', 'Austria', 'AUT', '40', 43),
(15, 'AZ', 'AZERBAIJAN', 'Azerbaijan', 'AZE', '31', 994),
(16, 'BS', 'BAHAMAS', 'Bahamas', 'BHS', '44', 1242),
(17, 'BH', 'BAHRAIN', 'Bahrain', 'BHR', '48', 973),
(18, 'BD', 'BANGLADESH', 'Bangladesh', 'BGD', '50', 880),
(19, 'BB', 'BARBADOS', 'Barbados', 'BRB', '52', 1246),
(20, 'BY', 'BELARUS', 'Belarus', 'BLR', '11', 375),
(21, 'BE', 'BELGIUM', 'Belgium', 'BEL', '56', 32),
(22, 'BZ', 'BELIZE', 'Belize', 'BLZ', '84', 501),
(23, 'BJ', 'BENIN', 'Benin', 'BEN', '20', 229),
(24, 'BM', 'BERMUDA', 'Bermuda', 'BMU', '60', 1441),
(25, 'BT', 'BHUTAN', 'Bhutan', 'BTN', '64', 975),
(26, 'BO', 'BOLIVIA', 'Bolivia', 'BOL', '68', 591),
(27, 'BA', 'BOSNIA AND HERZEGOVINA', 'Bosnia and Herzegovina', 'BIH', '70', 387),
(28, 'BW', 'BOTSWANA', 'Botswana', 'BWA', '72', 267),
(29, 'BV', 'BOUVET ISLAND', 'Bouvet Island', '', '', 0),
(30, 'BR', 'BRAZIL', 'Brazil', 'BRA', '76', 55),
(31, 'IO', 'BRITISH INDIAN OCEAN TERRITORY', 'British Indian Ocean Territory', '', '', 246),
(32, 'BN', 'BRUNEI DARUSSALAM', 'Brunei Darussalam', 'BRN', '96', 673),
(33, 'BG', 'BULGARIA', 'Bulgaria', 'BGR', '10', 359),
(34, 'BF', 'BURKINA FASO', 'Burkina Faso', 'BFA', '85', 226),
(35, 'BI', 'BURUNDI', 'Burundi', 'BDI', '10', 257),
(36, 'KH', 'CAMBODIA', 'Cambodia', 'KHM', '11', 855),
(37, 'CM', 'CAMEROON', 'Cameroon', 'CMR', '12', 237),
(38, 'CA', 'CANADA', 'Canada', 'CAN', '12', 1),
(39, 'CV', 'CAPE VERDE', 'Cape Verde', 'CPV', '13', 238),
(40, 'KY', 'CAYMAN ISLANDS', 'Cayman Islands', 'CYM', '13', 1345),
(41, 'CF', 'CENTRAL AFRICAN REPUBLIC', 'Central African Republic', 'CAF', '14', 236),
(42, 'TD', 'CHAD', 'Chad', 'TCD', '14', 235),
(43, 'CL', 'CHILE', 'Chile', 'CHL', '15', 56),
(44, 'CN', 'CHINA', 'China', 'CHN', '15', 86),
(45, 'CX', 'CHRISTMAS ISLAND', 'Christmas Island', '', '', 61),
(46, 'CC', 'COCOS (KEELING) ISLANDS', 'Cocos (Keeling) Islands', '', '', 672),
(47, 'CO', 'COLOMBIA', 'Colombia', 'COL', '17', 57),
(48, 'KM', 'COMOROS', 'Comoros', 'COM', '17', 269),
(49, 'CG', 'CONGO', 'Congo', 'COG', '17', 242),
(50, 'CD', 'CONGO, THE DEMOCRATIC REPUBLIC OF THE', 'Congo, the Democratic Republic of the', 'COD', '18', 242),
(51, 'CK', 'COOK ISLANDS', 'Cook Islands', 'COK', '18', 682),
(52, 'CR', 'COSTA RICA', 'Costa Rica', 'CRI', '18', 506),
(53, 'CI', 'COTE D\'IVOIRE', 'Cote D\'Ivoire', 'CIV', '38', 225),
(54, 'HR', 'CROATIA', 'Croatia', 'HRV', '19', 385),
(55, 'CU', 'CUBA', 'Cuba', 'CUB', '19', 53),
(56, 'CY', 'CYPRUS', 'Cyprus', 'CYP', '19', 357),
(57, 'CZ', 'CZECH REPUBLIC', 'Czech Republic', 'CZE', '20', 420),
(58, 'DK', 'DENMARK', 'Denmark', 'DNK', '20', 45),
(59, 'DJ', 'DJIBOUTI', 'Djibouti', 'DJI', '26', 253),
(60, 'DM', 'DOMINICA', 'Dominica', 'DMA', '21', 1767),
(61, 'DO', 'DOMINICAN REPUBLIC', 'Dominican Republic', 'DOM', '21', 1809),
(62, 'EC', 'ECUADOR', 'Ecuador', 'ECU', '21', 593),
(63, 'EG', 'EGYPT', 'Egypt', 'EGY', '81', 20),
(64, 'SV', 'EL SALVADOR', 'El Salvador', 'SLV', '22', 503),
(65, 'GQ', 'EQUATORIAL GUINEA', 'Equatorial Guinea', 'GNQ', '22', 240),
(66, 'ER', 'ERITREA', 'Eritrea', 'ERI', '23', 291),
(67, 'EE', 'ESTONIA', 'Estonia', 'EST', '23', 372),
(68, 'ET', 'ETHIOPIA', 'Ethiopia', 'ETH', '23', 251),
(69, 'FK', 'FALKLAND ISLANDS (MALVINAS)', 'Falkland Islands (Malvinas)', 'FLK', '23', 500),
(70, 'FO', 'FAROE ISLANDS', 'Faroe Islands', 'FRO', '23', 298),
(71, 'FJ', 'FIJI', 'Fiji', 'FJI', '24', 679),
(72, 'FI', 'FINLAND', 'Finland', 'FIN', '24', 358),
(73, 'FR', 'FRANCE', 'France', 'FRA', '25', 33),
(74, 'GF', 'FRENCH GUIANA', 'French Guiana', 'GUF', '25', 594),
(75, 'PF', 'FRENCH POLYNESIA', 'French Polynesia', 'PYF', '25', 689),
(76, 'TF', 'FRENCH SOUTHERN TERRITORIES', 'French Southern Territories', '', '', 0),
(77, 'GA', 'GABON', 'Gabon', 'GAB', '26', 241),
(78, 'GM', 'GAMBIA', 'Gambia', 'GMB', '27', 220),
(79, 'GE', 'GEORGIA', 'Georgia', 'GEO', '26', 995),
(80, 'DE', 'GERMANY', 'Germany', 'DEU', '27', 49),
(81, 'GH', 'GHANA', 'Ghana', 'GHA', '28', 233),
(82, 'GI', 'GIBRALTAR', 'Gibraltar', 'GIB', '29', 350),
(83, 'GR', 'GREECE', 'Greece', 'GRC', '30', 30),
(84, 'GL', 'GREENLAND', 'Greenland', 'GRL', '30', 299),
(85, 'GD', 'GRENADA', 'Grenada', 'GRD', '30', 1473),
(86, 'GP', 'GUADELOUPE', 'Guadeloupe', 'GLP', '31', 590),
(87, 'GU', 'GUAM', 'Guam', 'GUM', '31', 1671),
(88, 'GT', 'GUATEMALA', 'Guatemala', 'GTM', '32', 502),
(89, 'GN', 'GUINEA', 'Guinea', 'GIN', '32', 224),
(90, 'GW', 'GUINEA-BISSAU', 'Guinea-Bissau', 'GNB', '62', 245),
(91, 'GY', 'GUYANA', 'Guyana', 'GUY', '32', 592),
(92, 'HT', 'HAITI', 'Haiti', 'HTI', '33', 509),
(93, 'HM', 'HEARD ISLAND AND MCDONALD ISLANDS', 'Heard Island and Mcdonald Islands', '', '', 0),
(94, 'VA', 'HOLY SEE (VATICAN CITY STATE)', 'Holy See (Vatican City State)', 'VAT', '33', 39),
(95, 'HN', 'HONDURAS', 'Honduras', 'HND', '34', 504),
(96, 'HK', 'HONG KONG', 'Hong Kong', 'HKG', '34', 852),
(97, 'HU', 'HUNGARY', 'Hungary', 'HUN', '34', 36),
(98, 'IS', 'ICELAND', 'Iceland', 'ISL', '35', 354),
(99, 'IN', 'INDIA', 'India', 'IND', '35', 91),
(100, 'ID', 'INDONESIA', 'Indonesia', 'IDN', '36', 62),
(101, 'IR', 'IRAN, ISLAMIC REPUBLIC OF', 'Iran, Islamic Republic of', 'IRN', '36', 98),
(102, 'IQ', 'IRAQ', 'Iraq', 'IRQ', '36', 964),
(103, 'IE', 'IRELAND', 'Ireland', 'IRL', '37', 353),
(104, 'IL', 'ISRAEL', 'Israel', 'ISR', '37', 972),
(105, 'IT', 'ITALY', 'Italy', 'ITA', '38', 39),
(106, 'JM', 'JAMAICA', 'Jamaica', 'JAM', '38', 1876),
(107, 'JP', 'JAPAN', 'Japan', 'JPN', '39', 81),
(108, 'JO', 'JORDAN', 'Jordan', 'JOR', '40', 962),
(109, 'KZ', 'KAZAKHSTAN', 'Kazakhstan', 'KAZ', '39', 7),
(110, 'KE', 'KENYA', 'Kenya', 'KEN', '40', 254),
(111, 'KI', 'KIRIBATI', 'Kiribati', 'KIR', '29', 686),
(112, 'KP', 'KOREA, DEMOCRATIC PEOPLE\'S REPUBLIC OF', 'Korea, Democratic People\'s Republic of', 'PRK', '40', 850),
(113, 'KR', 'KOREA, REPUBLIC OF', 'Korea, Republic of', 'KOR', '41', 82),
(114, 'KW', 'KUWAIT', 'Kuwait', 'KWT', '41', 965),
(115, 'KG', 'KYRGYZSTAN', 'Kyrgyzstan', 'KGZ', '41', 996),
(116, 'LA', 'LAO PEOPLE\'S DEMOCRATIC REPUBLIC', 'Lao People\'s Democratic Republic', 'LAO', '41', 856),
(117, 'LV', 'LATVIA', 'Latvia', 'LVA', '42', 371),
(118, 'LB', 'LEBANON', 'Lebanon', 'LBN', '42', 961),
(119, 'LS', 'LESOTHO', 'Lesotho', 'LSO', '42', 266),
(120, 'LR', 'LIBERIA', 'Liberia', 'LBR', '43', 231),
(121, 'LY', 'LIBYAN ARAB JAMAHIRIYA', 'Libyan Arab Jamahiriya', 'LBY', '43', 218),
(122, 'LI', 'LIECHTENSTEIN', 'Liechtenstein', 'LIE', '43', 423),
(123, 'LT', 'LITHUANIA', 'Lithuania', 'LTU', '44', 370),
(124, 'LU', 'LUXEMBOURG', 'Luxembourg', 'LUX', '44', 352),
(125, 'MO', 'MACAO', 'Macao', 'MAC', '44', 853),
(126, 'MK', 'MACEDONIA, THE FORMER YUGOSLAV REPUBLIC OF', 'Macedonia, the Former Yugoslav Republic of', 'MKD', '80', 389),
(127, 'MG', 'MADAGASCAR', 'Madagascar', 'MDG', '45', 261),
(128, 'MW', 'MALAWI', 'Malawi', 'MWI', '45', 265),
(129, 'MY', 'MALAYSIA', 'Malaysia', 'MYS', '45', 60),
(130, 'MV', 'MALDIVES', 'Maldives', 'MDV', '46', 960),
(131, 'ML', 'MALI', 'Mali', 'MLI', '46', 223),
(132, 'MT', 'MALTA', 'Malta', 'MLT', '47', 356),
(133, 'MH', 'MARSHALL ISLANDS', 'Marshall Islands', 'MHL', '58', 692),
(134, 'MQ', 'MARTINIQUE', 'Martinique', 'MTQ', '47', 596),
(135, 'MR', 'MAURITANIA', 'Mauritania', 'MRT', '47', 222),
(136, 'MU', 'MAURITIUS', 'Mauritius', 'MUS', '48', 230),
(137, 'YT', 'MAYOTTE', 'Mayotte', '', '', 269),
(138, 'MX', 'MEXICO', 'Mexico', 'MEX', '48', 52),
(139, 'FM', 'MICRONESIA, FEDERATED STATES OF', 'Micronesia, Federated States of', 'FSM', '58', 691),
(140, 'MD', 'MOLDOVA, REPUBLIC OF', 'Moldova, Republic of', 'MDA', '49', 373),
(141, 'MC', 'MONACO', 'Monaco', 'MCO', '49', 377),
(142, 'MN', 'MONGOLIA', 'Mongolia', 'MNG', '49', 976),
(143, 'MS', 'MONTSERRAT', 'Montserrat', 'MSR', '50', 1664),
(144, 'MA', 'MOROCCO', 'Morocco', 'MAR', '50', 212),
(145, 'MZ', 'MOZAMBIQUE', 'Mozambique', 'MOZ', '50', 258),
(146, 'MM', 'MYANMAR', 'Myanmar', 'MMR', '10', 95),
(147, 'NA', 'NAMIBIA', 'Namibia', 'NAM', '51', 264),
(148, 'NR', 'NAURU', 'Nauru', 'NRU', '52', 674),
(149, 'NP', 'NEPAL', 'Nepal', 'NPL', '52', 977),
(150, 'NL', 'NETHERLANDS', 'Netherlands', 'NLD', '52', 31),
(151, 'AN', 'NETHERLANDS ANTILLES', 'Netherlands Antilles', 'ANT', '53', 599),
(152, 'NC', 'NEW CALEDONIA', 'New Caledonia', 'NCL', '54', 687),
(153, 'NZ', 'NEW ZEALAND', 'New Zealand', 'NZL', '55', 64),
(154, 'NI', 'NICARAGUA', 'Nicaragua', 'NIC', '55', 505),
(155, 'NE', 'NIGER', 'Niger', 'NER', '56', 227),
(156, 'NG', 'NIGERIA', 'Nigeria', 'NGA', '56', 234),
(157, 'NU', 'NIUE', 'Niue', 'NIU', '57', 683),
(158, 'NF', 'NORFOLK ISLAND', 'Norfolk Island', 'NFK', '57', 672),
(159, 'MP', 'NORTHERN MARIANA ISLANDS', 'Northern Mariana Islands', 'MNP', '58', 1670),
(160, 'NO', 'NORWAY', 'Norway', 'NOR', '57', 47),
(161, 'OM', 'OMAN', 'Oman', 'OMN', '51', 968),
(162, 'PK', 'PAKISTAN', 'Pakistan', 'PAK', '58', 92),
(163, 'PW', 'PALAU', 'Palau', 'PLW', '58', 680),
(164, 'PS', 'PALESTINIAN TERRITORY, OCCUPIED', 'Palestinian Territory, Occupied', '', '', 970),
(165, 'PA', 'PANAMA', 'Panama', 'PAN', '59', 507),
(166, 'PG', 'PAPUA NEW GUINEA', 'Papua New Guinea', 'PNG', '59', 675),
(167, 'PY', 'PARAGUAY', 'Paraguay', 'PRY', '60', 595),
(168, 'PE', 'PERU', 'Peru', 'PER', '60', 51),
(169, 'PH', 'PHILIPPINES', 'Philippines', 'PHL', '60', 63),
(170, 'PN', 'PITCAIRN', 'Pitcairn', 'PCN', '61', 0),
(171, 'PL', 'POLAND', 'Poland', 'POL', '61', 48),
(172, 'PT', 'PORTUGAL', 'Portugal', 'PRT', '62', 351),
(173, 'PR', 'PUERTO RICO', 'Puerto Rico', 'PRI', '63', 1787),
(174, 'QA', 'QATAR', 'Qatar', 'QAT', '63', 974),
(175, 'RE', 'REUNION', 'Reunion', 'REU', '63', 262),
(176, 'RO', 'ROMANIA', 'Romania', 'ROM', '64', 40),
(177, 'RU', 'RUSSIAN FEDERATION', 'Russian Federation', 'RUS', '64', 70),
(178, 'RW', 'RWANDA', 'Rwanda', 'RWA', '64', 250),
(179, 'SH', 'SAINT HELENA', 'Saint Helena', 'SHN', '65', 290),
(180, 'KN', 'SAINT KITTS AND NEVIS', 'Saint Kitts and Nevis', 'KNA', '65', 1869),
(181, 'LC', 'SAINT LUCIA', 'Saint Lucia', 'LCA', '66', 1758),
(182, 'PM', 'SAINT PIERRE AND MIQUELON', 'Saint Pierre and Miquelon', 'SPM', '66', 508),
(183, 'VC', 'SAINT VINCENT AND THE GRENADINES', 'Saint Vincent and the Grenadines', 'VCT', '67', 1784),
(184, 'WS', 'SAMOA', 'Samoa', 'WSM', '88', 684),
(185, 'SM', 'SAN MARINO', 'San Marino', 'SMR', '67', 378),
(186, 'ST', 'SAO TOME AND PRINCIPE', 'Sao Tome and Principe', 'STP', '67', 239),
(187, 'SA', 'SAUDI ARABIA', 'Saudi Arabia', 'SAU', '68', 966),
(188, 'SN', 'SENEGAL', 'Senegal', 'SEN', '68', 221),
(189, 'CS', 'SERBIA AND MONTENEGRO', 'Serbia and Montenegro', '', '', 381),
(190, 'SC', 'SEYCHELLES', 'Seychelles', 'SYC', '69', 248),
(191, 'SL', 'SIERRA LEONE', 'Sierra Leone', 'SLE', '69', 232),
(192, 'SG', 'SINGAPORE', 'Singapore', 'SGP', '70', 65),
(193, 'SK', 'SLOVAKIA', 'Slovakia', 'SVK', '70', 421),
(194, 'SI', 'SLOVENIA', 'Slovenia', 'SVN', '70', 386),
(195, 'SB', 'SOLOMON ISLANDS', 'Solomon Islands', 'SLB', '90', 677),
(196, 'SO', 'SOMALIA', 'Somalia', 'SOM', '70', 252),
(197, 'ZA', 'SOUTH AFRICA', 'South Africa', 'ZAF', '71', 27),
(198, 'GS', 'SOUTH GEORGIA AND THE SOUTH SANDWICH ISLANDS', 'South Georgia and the South Sandwich Islands', '', '', 0),
(199, 'ES', 'SPAIN', 'Spain', 'ESP', '72', 34),
(200, 'LK', 'SRI LANKA', 'Sri Lanka', 'LKA', '14', 94),
(201, 'SD', 'SUDAN', 'Sudan', 'SDN', '73', 249),
(202, 'SR', 'SURINAME', 'Suriname', 'SUR', '74', 597),
(203, 'SJ', 'SVALBARD AND JAN MAYEN', 'Svalbard and Jan Mayen', 'SJM', '74', 47),
(204, 'SZ', 'SWAZILAND', 'Swaziland', 'SWZ', '74', 268),
(205, 'SE', 'SWEDEN', 'Sweden', 'SWE', '75', 46),
(206, 'CH', 'SWITZERLAND', 'Switzerland', 'CHE', '75', 41),
(207, 'SY', 'SYRIAN ARAB REPUBLIC', 'Syrian Arab Republic', 'SYR', '76', 963),
(208, 'TW', 'TAIWAN, PROVINCE OF CHINA', 'Taiwan, Province of China', 'TWN', '15', 886),
(209, 'TJ', 'TAJIKISTAN', 'Tajikistan', 'TJK', '76', 992),
(210, 'TZ', 'TANZANIA, UNITED REPUBLIC OF', 'Tanzania, United Republic of', 'TZA', '83', 255),
(211, 'TH', 'THAILAND', 'Thailand', 'THA', '76', 66),
(212, 'TL', 'TIMOR-LESTE', 'Timor-Leste', '', '', 670),
(213, 'TG', 'TOGO', 'Togo', 'TGO', '76', 228),
(214, 'TK', 'TOKELAU', 'Tokelau', 'TKL', '77', 690),
(215, 'TO', 'TONGA', 'Tonga', 'TON', '77', 676),
(216, 'TT', 'TRINIDAD AND TOBAGO', 'Trinidad and Tobago', 'TTO', '78', 1868),
(217, 'TN', 'TUNISIA', 'Tunisia', 'TUN', '78', 216),
(218, 'TR', 'TURKEY', 'Turkey', 'TUR', '79', 90),
(219, 'TM', 'TURKMENISTAN', 'Turkmenistan', 'TKM', '79', 7370),
(220, 'TC', 'TURKS AND CAICOS ISLANDS', 'Turks and Caicos Islands', 'TCA', '79', 1649),
(221, 'TV', 'TUVALU', 'Tuvalu', 'TUV', '79', 688),
(222, 'UG', 'UGANDA', 'Uganda', 'UGA', '80', 256),
(223, 'UA', 'UKRAINE', 'Ukraine', 'UKR', '80', 380),
(224, 'AE', 'UNITED ARAB EMIRATES', 'United Arab Emirates', 'ARE', '78', 971),
(225, 'GB', 'UNITED KINGDOM', 'United Kingdom', 'GBR', '82', 44),
(226, 'US', 'UNITED STATES', 'United States', 'USA', '84', 1),
(227, 'UM', 'UNITED STATES MINOR OUTLYING ISLANDS', 'United States Minor Outlying Islands', '', '', 1),
(228, 'UY', 'URUGUAY', 'Uruguay', 'URY', '85', 598),
(229, 'UZ', 'UZBEKISTAN', 'Uzbekistan', 'UZB', '86', 998),
(230, 'VU', 'VANUATU', 'Vanuatu', 'VUT', '54', 678),
(231, 'VE', 'VENEZUELA', 'Venezuela', 'VEN', '86', 58),
(232, 'VN', 'VIET NAM', 'Viet Nam', 'VNM', '70', 84),
(233, 'VG', 'VIRGIN ISLANDS, BRITISH', 'Virgin Islands, British', 'VGB', '92', 1284),
(234, 'VI', 'VIRGIN ISLANDS, U.S.', 'Virgin Islands, U.s.', 'VIR', '85', 1340),
(235, 'WF', 'WALLIS AND FUTUNA', 'Wallis and Futuna', 'WLF', '87', 681),
(236, 'EH', 'WESTERN SAHARA', 'Western Sahara', 'ESH', '73', 212),
(237, 'YE', 'YEMEN', 'Yemen', 'YEM', '88', 967),
(238, 'ZM', 'ZAMBIA', 'Zambia', 'ZMB', '89', 260),
(239, 'ZW', 'ZIMBABWE', 'Zimbabwe', 'ZWE', '71', 263);

-- --------------------------------------------------------

--
-- Table structure for table `currency`
--

CREATE TABLE `currency` (
  `CurrencyId` int(11) NOT NULL,
  `CurrencyTitle` varchar(50) NOT NULL,
  `country_id` int(11) NOT NULL,
  `CurrencySymbol` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `currency`
--

INSERT INTO `currency` (`CurrencyId`, `CurrencyTitle`, `country_id`, `CurrencySymbol`) VALUES
(1, 'USD', 230, 'Dollar'),
(2, 'INR', 98, 'Rupees'),
(3, 'MX', 139, 'MX');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customer_Id` int(11) NOT NULL,
  `Company_Id` int(11) NOT NULL,
  `AccountNumber` varchar(50) DEFAULT NULL,
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) DEFAULT NULL,
  `Address1` varchar(100) DEFAULT NULL,
  `Address2` varchar(100) DEFAULT NULL,
  `City` varchar(50) DEFAULT NULL,
  `State` varchar(50) DEFAULT NULL,
  `ZipCode` varchar(50) DEFAULT NULL,
  `country_id` int(11) NOT NULL,
  `Phone` varchar(20) DEFAULT NULL,
  `Email` varchar(50) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `DOB` varchar(50) DEFAULT NULL,
  `ProfileImage` varchar(50) DEFAULT NULL,
  `ActivationCode` varchar(100) DEFAULT NULL,
  `IsAccountActivated` tinyint(1) NOT NULL,
  `IsActive` tinyint(1) NOT NULL,
  `IsDeleted` tinyint(1) NOT NULL DEFAULT '0',
  `CreatedDate` datetime NOT NULL,
  `DeletedDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`customer_Id`, `Company_Id`, `AccountNumber`, `FirstName`, `LastName`, `Address1`, `Address2`, `City`, `State`, `ZipCode`, `country_id`, `Phone`, `Email`, `Password`, `DOB`, `ProfileImage`, `ActivationCode`, `IsAccountActivated`, `IsActive`, `IsDeleted`, `CreatedDate`, `DeletedDate`) VALUES
(1, 17, '123456789', 'ishu', 'Kumar', 'aaa', 'bbb', 'www', 'fl', '12345', 226, '123456789', 'u@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '2017-10-10 ', 'fff', '1234567890', 1, 1, 0, '2017-10-05 00:00:00', NULL),
(2, 17, '123456789', 'ff', 'Kumar', 'aaa', 'bbb', 'www', 'fl', '12345', 226, '123456789', 'ffu@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '2017-10-10 ', 'fff', '1234567890', 1, 1, 0, '2017-10-02 00:00:00', NULL),
(3, 17, '123456789', 'cc', 'Kumar', 'aaa', 'bbb', 'www', 'fl', '12345', 226, '123456789', 'cc@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '2017-10-10 ', 'fff', '1234567890', 1, 1, 0, '2017-10-14 19:06:08', NULL),
(4, 17, '123456789', 'dd', 'Kumar', 'aaa', 'bbb', 'www', 'fl', '12345', 226, '123456789', 'dd@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '2017-10-10 ', 'fff', '1234567890', 1, 1, 0, '2017-10-14 19:09:40', NULL),
(5, 17, '123456789', 'dd', 'Kumar', 'aaa', 'bbb', 'www', 'fl', '12345', 226, '123456789', 'dd@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '2017-10-10 ', 'fff', '1234567890', 1, 1, 0, '2017-10-14 19:14:46', NULL),
(6, 17, '123456789', 'hh', 'Kumar', 'aaa', 'bbb', 'www', 'fl', '12345', 226, '123456789', 'hh@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '2017-10-10 ', 'fff', '1234567890', 1, 1, 1, '2017-10-14 19:17:02', '2017-10-19 00:00:00'),
(8, 17, '123456789', 'zolly', 'mbbs', 'aaa', 'bbb', 'www', 'fl', '12345', 226, '123456789', 'zolly@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '2017-10-10 ', 'fff', '1234567890', 1, 1, 0, '2017-10-16 11:13:12', NULL),
(9, 17, '123456789', 'Oppo', 'chinese', 'china', 'test', 'china', 'CH', '12345', 226, '123456789', 'oppo@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '2017-10-10 ', 'fff', '1234567890', 1, 1, 0, '2017-10-25 11:42:21', NULL),
(10, 17, '35434', 'test', 'test', 'test', 'test', 'test', 'trst', 'tres', 226, '2345324523', 'testre@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '1990-10-10 ', 'test', '34534', 1, 1, 0, '2017-10-27 11:25:23', NULL),
(11, 17, '25432', 'Girish', 'test', 'Delhi', 'test', 'City', 'State', '110033', 226, '968545868', 'Girishtest@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '1990-10-10 ', 'test', '32432', 1, 1, 0, '2017-10-27 11:28:05', NULL),
(12, 17, '985458', 'Ishu Test', 'test', 'address', 'Address2', 'City', 'State', '854854', 226, '8545859654', 'ishutest@gamil.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '1990-10-10 ', 'test', '95848', 1, 1, 0, '2017-10-30 06:27:55', NULL),
(13, 17, '', 'Customer', 'test', '', '', '', '', '', 226, '123456789', 'customer@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '', '', '', 0, 0, 0, '2017-10-30 09:27:09', NULL),
(14, 17, NULL, 'Rajeev', 'Verma', '', '', '', '', '', 99, '384293232', 'rajeevdesizn@gmail.com', '7110EDA4D09E062AA5E4A390B0A572AC0D2C0220', '', '', '', 0, 0, 0, '2017-12-05 17:41:17', NULL),
(15, 17, NULL, 'adam', 'smith', '', '', '', '', '', 99, '9876543210', 'asmith@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '', '', '', 0, 0, 0, '2017-12-08 08:35:48', NULL),
(16, 17, NULL, 'rajeev', 'verma', '', '', '', '', '', 99, '9732321283', 'ronniedesizn@gmail.com', 'AAFDC23870ECBCD3D557B6423A8982134E17927E', '', '', '', 0, 0, 0, '2018-01-18 15:55:06', NULL),
(17, 17, NULL, 'Lhuui', 'Castroe', '', '', '', '', '', 226, '2094704318', 'Rey0825@gmail.com', '171344B753E1D6AFAF7640AD8664E6BF9E2382CC', '', '', '', 0, 0, 0, '2018-01-22 15:23:36', NULL),
(18, 17, NULL, 'gdfg', 'dgffg', '', '', '', '', '', 1, '12345667777', 'you@gmail.com', '7C4A8D09CA3762AF61E59520943DC26494F8941B', '', '', '', 0, 0, 0, '2018-01-22 15:33:36', NULL),
(19, 17, NULL, 'Rishi', 'kumar', '', '', '', '', '', 99, '123456789', 'rishi@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '', '', '', 0, 0, 0, '2018-01-23 06:06:12', NULL),
(20, 17, NULL, 'ishu', 'xyz', '', '', '', '', '', 2, '8889888784', 'i@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '', '', '', 0, 0, 0, '2018-01-23 14:39:36', NULL),
(21, 17, NULL, 'sDFfa', 'dffg', '', '', '', '', '', 14, '565464564654', 's@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '', '', '', 0, 0, 0, '2018-01-23 14:41:02', NULL),
(22, 17, NULL, 'wadfsd', 'dsfggf', '', '', '', '', '', 2, '86972522422', 'y@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '', '', '', 0, 0, 0, '2018-01-23 14:42:09', NULL),
(23, 17, NULL, 'dfsfzsdg', 'gdfg', '', '', '', '', '', 16, '7887874444', 'deepak@acapteam.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '', '', '', 0, 0, 0, '2018-01-23 14:44:43', NULL),
(24, 17, NULL, 'gjg', 'gjkg', '', '', '', '', '', 1, '65756756567567', 't@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '', '', '', 0, 0, 0, '2018-01-24 06:07:01', NULL),
(25, 17, NULL, 'rrt', 'rtert', '', '', '', '', '', 1, '54564654654', 'r@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '', '', '', 0, 0, 0, '2018-01-24 06:38:25', NULL),
(26, 17, NULL, 'dfsfs', 'fsfs', '', '', '', '', '', 1, '12365145225', 'h@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '', '', '', 0, 0, 0, '2018-01-24 14:36:46', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `feescategory`
--

CREATE TABLE `feescategory` (
  `FeesCategoryId` int(11) NOT NULL,
  `FeesCategoryName` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `feescategory`
--

INSERT INTO `feescategory` (`FeesCategoryId`, `FeesCategoryName`) VALUES
(1, 'Remittance'),
(2, 'Airtime Top-Up'),
(3, 'Utility Bill Payment'),
(4, 'Merchant Bill Payment'),
(5, 'Business Venture'),
(6, 'Charitable Donation'),
(7, 'Estate Settlement  / Inheritance'),
(8, 'Government Related Payment'),
(9, 'Intercompany Payment'),
(10, 'Investment Related Payment'),
(11, 'Medical Fee Refund'),
(12, 'Paying Consultancy Fees'),
(13, 'Payment for a loan or deposit'),
(14, 'Payroll / Personnel Payment'),
(15, 'Professional Fees Payment'),
(16, 'Purchase of Goods'),
(17, 'Purchase of Property / Real Estate'),
(18, 'Purchase of Service(s)'),
(19, 'Research and Development Payment Fees'),
(20, 'Ambulant Merchant Bill Payment');

-- --------------------------------------------------------

--
-- Table structure for table `globalexchangerate`
--

CREATE TABLE `globalexchangerate` (
  `GlobalExchangeId` int(11) NOT NULL,
  `PaymentMethodId` int(11) NOT NULL,
  `SourceCountryId` int(11) NOT NULL,
  `DestinationCountryId` int(11) NOT NULL,
  `SpotPrice` varchar(50) NOT NULL,
  `AutoFees` decimal(18,2) NOT NULL,
  `SellSpotPrice` decimal(18,2) NOT NULL,
  `SellingExchangeRate` decimal(18,2) NOT NULL,
  `GlobalExchangeRate` decimal(18,2) NOT NULL,
  `IsActive` tinyint(4) NOT NULL DEFAULT '1',
  `CreatedDate` date NOT NULL,
  `Code` varchar(50) DEFAULT NULL,
  `SpotMarginBaseCurrency` decimal(18,2) NOT NULL,
  `SpotMarginUSDCurrency` decimal(18,2) NOT NULL,
  `IsDeleted` tinyint(4) NOT NULL DEFAULT '0',
  `DeletedDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `globalexchangerate`
--

INSERT INTO `globalexchangerate` (`GlobalExchangeId`, `PaymentMethodId`, `SourceCountryId`, `DestinationCountryId`, `SpotPrice`, `AutoFees`, `SellSpotPrice`, `SellingExchangeRate`, `GlobalExchangeRate`, `IsActive`, `CreatedDate`, `Code`, `SpotMarginBaseCurrency`, `SpotMarginUSDCurrency`, `IsDeleted`, `DeletedDate`) VALUES
(1, 12, 230, 139, 'USD', '2.99', '18.25', '-0.03', '18.24', 1, '2018-04-11', 'FLUTSFUSD1', '0.01', '0.00', 1, '2018-04-02'),
(2, 12, 230, 139, 'USD', '2.99', '18.25', '-0.09', '18.23', 1, '2018-04-11', 'FLUTSFUSD2', '0.02', '0.00', 0, NULL),
(3, 13, 230, 139, 'USD', '0.49', '18.25', '1.10', '18.45', 1, '2018-04-11', 'FLUTSFUSD3', '0.20', '0.01', 0, NULL),
(4, 14, 230, 38, 'USD', '4.99', '1.26', '1.00', '1.27', 1, '2018-04-11', 'FLUTSFUSD4', '0.01', '0.01', 0, NULL),
(5, 12, 230, 139, 'USD', '0.69', '18.25', '1.00', '18.43', 1, '2018-04-11', 'FLUTSFUSD5', '0.18', '0.01', 0, NULL),
(6, 13, 230, 139, 'USD', '0.49', '18.25', '-0.10', '18.23', 1, '2018-04-11', 'FLUTSFUSD6', '0.02', '0.00', 0, NULL),
(7, 12, 230, 139, 'USD', '5.99', '18.25', '-0.09', '18.23', 1, '2018-04-11', 'FLUTSFUSD7', '0.02', '0.00', 0, NULL),
(8, 12, 230, 139, 'USD', '5.99', '18.25', '-0.08', '18.24', 1, '2018-04-11', 'FLUTSFUSD8', '0.01', '0.00', 0, NULL),
(9, 12, 230, 139, 'USD', '5.99', '18.25', '-0.01', '18.25', 1, '2018-04-11', 'FLUTSFUSD9', '0.00', '0.00', 0, NULL),
(10, 12, 230, 139, 'USD', '2.99', '18.25', '0.00', '18.25', 1, '2018-04-11', 'FLUTSFUSD10', '0.00', '0.00', 0, NULL),
(11, 12, 230, 139, 'USD', '2.99', '18.25', '0.00', '18.25', 1, '2018-04-11', 'FLUTSFUSD11', '0.00', '0.00', 1, '2018-04-06'),
(12, 12, 230, 139, 'USD', '0.69', '18.25', '0.10', '18.27', 1, '2018-04-11', 'FLUTSFUSD12', '0.02', '0.00', 0, NULL),
(13, 12, 230, 38, 'USD', '0.00', '1.26', '0.00', '1.26', 1, '2018-04-11', 'FLUTSFUSD13', '0.00', '0.00', 1, '2018-04-06'),
(14, 12, 230, 38, 'USD', '0.00', '1.26', '0.20', '1.26', 1, '2018-04-11', 'FLUTSFUSD14', '0.00', '0.00', 0, NULL),
(15, 13, 230, 38, 'USD', '0.00', '1.26', '0.20', '1.26', 1, '2018-04-11', 'FLUTSFUSD15', '0.00', '0.00', 0, NULL),
(16, 12, 230, 107, 'USD', '0.00', '106.92', '0.00', '106.92', 1, '2018-04-11', 'FLUTSFUSD16', '0.00', '0.00', 0, NULL),
(17, 25, 230, 43, 'USD', '0.00', '600.11', '0.00', '600.11', 1, '2018-04-11', 'FLUTSFUSD17', '0.00', '0.00', 0, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `magicpaydetails`
--

CREATE TABLE `magicpaydetails` (
  `MagicPayId` int(11) NOT NULL,
  `CompanyId` int(11) NOT NULL,
  `CustomerId` int(11) NOT NULL,
  `TransactionId` int(11) NOT NULL,
  `PaymentGatewayTransactionId` varchar(50) NOT NULL,
  `SenderName` varchar(50) NOT NULL,
  `Amount` decimal(18,2) NOT NULL,
  `TransactionDetail` varchar(100) DEFAULT NULL,
  `TransactionDate` datetime NOT NULL,
  `ResponseCode` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `magicpaydetails`
--

INSERT INTO `magicpaydetails` (`MagicPayId`, `CompanyId`, `CustomerId`, `TransactionId`, `PaymentGatewayTransactionId`, `SenderName`, `Amount`, `TransactionDetail`, `TransactionDate`, `ResponseCode`) VALUES
(1, 17, 8, 3, '4001055666', 'zolly', '104.99', 'BankDeposit', '2018-02-23 14:04:36', 'Success'),
(2, 17, 8, 4, '4001129337', 'zolly', '6.49', NULL, '2018-02-23 14:45:30', 'Success'),
(3, 17, 8, 5, '4004757144', 'zolly', '8.49', NULL, '2018-02-26 18:04:52', 'Success'),
(4, 17, 8, 6, '4005491069', 'zolly', '6.49', NULL, '2018-02-27 07:08:33', 'Success'),
(5, 17, 8, 7, '4006262347', 'zolly', '104.99', 'BankDeposit', '2018-02-27 19:31:26', 'Success'),
(6, 17, 8, 8, '4007152385', 'zolly', '6.99', NULL, '2018-02-28 10:27:58', 'Success'),
(7, 17, 8, 9, '4009059159', 'zolly', '6.49', NULL, '2018-03-01 09:17:15', 'Success'),
(8, 17, 8, 10, '4009375424', 'zolly', '11.48', NULL, '2018-03-01 12:25:06', 'Success'),
(9, 17, 8, 11, '4009391491', 'zolly', '14.98', NULL, '2018-03-01 12:32:11', 'Success'),
(10, 17, 8, 12, '4009394933', 'zolly', '14.98', NULL, '2018-03-01 12:33:32', 'Success'),
(11, 17, 8, 13, '4009401068', 'zolly', '14.98', NULL, '2018-03-01 12:35:52', 'Success'),
(12, 17, 8, 14, '4009403392', 'zolly', '9.99', NULL, '2018-03-01 12:36:51', 'Success'),
(13, 17, 8, 15, '4009445003', 'zolly', '5.99', NULL, '2018-03-01 12:55:10', 'Success'),
(14, 17, 8, 16, '4009454842', 'zolly', '6.99', NULL, '2018-03-01 12:59:19', 'Success'),
(15, 17, 8, 17, '4009470575', 'zolly', '9.99', NULL, '2018-03-01 13:05:35', 'Success'),
(16, 17, 8, 18, '4009516289', 'zolly', '6.49', NULL, '2018-03-01 13:27:22', 'Success'),
(17, 17, 8, 19, '4014954395', 'zolly', '14.99', 'BankDeposit', '2018-03-05 09:19:53', 'Success'),
(18, 17, 8, 20, '4014960259', 'zolly', '14.99', 'BankDeposit', '2018-03-05 09:23:42', 'Success'),
(19, 17, 8, 21, '4014966871', 'zolly', '14.99', 'BankDeposit', '2018-03-05 09:26:46', 'Success'),
(20, 17, 8, 22, '4014980826', 'zolly', '14.99', 'BankDeposit', '2018-03-05 09:33:00', 'Success'),
(21, 17, 8, 24, '4015027711', 'zolly', '44.99', 'BankDeposit', '2018-03-05 10:35:36', 'Success'),
(22, 17, 8, 25, '4015029695', 'zolly', '7.49', NULL, '2018-03-05 10:37:34', 'Success'),
(23, 17, 8, 26, '4015082696', 'zolly', '14.99', 'BankDeposit', '2018-03-05 11:41:16', 'Success'),
(24, 17, 8, 27, '4015083679', 'zolly', '3.49', NULL, '2018-03-05 11:42:52', 'Success'),
(25, 17, 8, 28, '4015575573', 'zolly', '104.99', 'BankDeposit', '2018-03-05 17:47:43', 'Success'),
(26, 17, 8, 29, '4017774668', 'zolly', '24.99', 'CashPickup', '2018-03-07 06:29:01', 'Success'),
(27, 17, 8, 31, '4017780390', 'zolly', '16.99', 'BankDeposit', '2018-03-07 06:43:47', 'Success'),
(28, 17, 8, 33, '4017798379', 'zolly', '11.99', 'BankDeposit', '2018-03-07 07:02:34', 'Success'),
(29, 17, 8, 36, '4017956457', 'zolly', '6.99', NULL, '2018-03-07 09:36:55', 'Success'),
(30, 17, 8, 37, '4017992734', 'zolly', '11.99', NULL, '2018-03-07 10:35:36', 'Success'),
(31, 17, 8, 38, '4017994874', 'zolly', '27.99', NULL, '2018-03-07 10:37:56', 'Success'),
(32, 17, 8, 39, '4027050829', 'zolly', '103.99', 'BankDeposit', '2018-03-14 14:35:04', 'Success'),
(33, 17, 8, 40, '4027057565', 'zolly', '8.99', NULL, '2018-03-14 14:39:58', 'Success'),
(34, 17, 8, 41, '4033223634', 'zolly', '43.99', 'BankDeposit', '2018-03-19 09:22:35', 'Success'),
(35, 17, 8, 42, '4033224872', 'zolly', '13.99', 'BankDeposit', '2018-03-19 09:24:27', 'Success'),
(36, 17, 8, 43, '4033232745', 'zolly', '43.99', 'CashPickup', '2018-03-19 09:33:38', 'Success'),
(37, 17, 8, 44, '4033284959', 'zolly', '5.49', NULL, '2018-03-19 10:43:33', 'Success'),
(38, 17, 8, 45, '4033288008', 'zolly', '4.99', NULL, '2018-03-19 10:49:40', 'Success'),
(39, 17, 8, 46, '4033307543', 'zolly', '7.99', NULL, '2018-03-19 11:20:21', 'Success'),
(40, 17, 8, 47, '4033312048', 'zolly', '101.99', 'BankDeposit', '2018-03-19 11:28:37', 'Success'),
(41, 17, 8, 49, '4033312508', 'zolly', '7.99', NULL, '2018-03-19 11:29:29', 'Success'),
(42, 17, 8, 50, '4033313393', 'zolly', '103.99', NULL, '2018-03-19 11:31:04', 'Success'),
(43, 17, 8, 51, '4053209270', 'zolly', '2.99', NULL, '2018-04-02 07:07:36', 'Success'),
(44, 17, 8, 52, '4053254986', 'zolly', '9.99', NULL, '2018-04-02 07:29:38', 'Success'),
(45, 17, 8, 53, '4053566939', 'zolly', '5.89', NULL, '2018-04-02 12:14:03', 'Success'),
(46, 17, 8, 54, '4053638570', 'zolly', '3.99', NULL, '2018-04-02 13:15:02', 'Success'),
(47, 17, 8, 55, '4056712960', 'zolly', '11.59', NULL, '2018-04-04 07:44:08', 'Success'),
(48, 17, 8, 56, '4057549432', 'zolly', '3.49', NULL, '2018-04-04 15:33:04', 'Success'),
(49, 17, 8, 57, '4059776141', 'zolly', '11.69', NULL, '2018-04-06 03:38:59', 'Success'),
(50, 17, 8, 61, '4063393123', 'zolly', '4.10', NULL, '2018-04-09 07:28:55', 'Success'),
(51, 17, 8, 65, '4063396337', 'zolly', '12.69', NULL, '2018-04-09 07:32:20', 'Success'),
(52, 17, 8, 66, '4063398853', 'zolly', '11.69', NULL, '2018-04-09 07:34:16', 'Success');

-- --------------------------------------------------------

--
-- Table structure for table `paymentfees`
--

CREATE TABLE `paymentfees` (
  `PaymentFessId` int(11) NOT NULL,
  `CompanyId` int(11) NOT NULL,
  `PaymentMethodId` int(11) NOT NULL,
  `SourceCountry` int(11) NOT NULL,
  `DestinationCountry` int(11) NOT NULL,
  `FeesCategoryId` int(11) NOT NULL,
  `PayInAgentId` int(11) NOT NULL,
  `IsPayInAgent` tinyint(4) NOT NULL,
  `PayOutAgentId` int(11) NOT NULL,
  `IsPayOutAgent` tinyint(4) NOT NULL,
  `StartingAmount` decimal(10,2) NOT NULL,
  `EndAmount` decimal(10,2) NOT NULL,
  `FeesType` int(11) NOT NULL,
  `Fees` decimal(10,2) NOT NULL,
  `Code` varchar(50) DEFAULT NULL,
  `GobalExchangeRateCode` varchar(50) DEFAULT NULL,
  `TransactionFeeSharingCode` varchar(50) DEFAULT NULL,
  `ChargeSendingAmount` tinyint(1) NOT NULL DEFAULT '0',
  `TransactionFeeType` varchar(50) DEFAULT NULL,
  `CreatedDate` date NOT NULL,
  `IsDeleted` tinyint(1) NOT NULL DEFAULT '0',
  `DeletedDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `paymentfees`
--

INSERT INTO `paymentfees` (`PaymentFessId`, `CompanyId`, `PaymentMethodId`, `SourceCountry`, `DestinationCountry`, `FeesCategoryId`, `PayInAgentId`, `IsPayInAgent`, `PayOutAgentId`, `IsPayOutAgent`, `StartingAmount`, `EndAmount`, `FeesType`, `Fees`, `Code`, `GobalExchangeRateCode`, `TransactionFeeSharingCode`, `ChargeSendingAmount`, `TransactionFeeType`, `CreatedDate`, `IsDeleted`, `DeletedDate`) VALUES
(1, 17, 12, 230, 139, 2, 2, 1, 3, 1, '0.99', '9.99', 1, '0.49', 'FLATUPS1', 'FLUTSFUSD2', 'FLUTSF15', 1, NULL, '2018-04-03', 1, '2018-04-05'),
(2, 17, 12, 230, 139, 2, 1, 0, 3, 0, '10.00', '19.99', 1, '0.59', 'FLATUPS2', 'FLUTSFUSD6', '', 1, NULL, '2018-04-02', 1, '2018-04-05'),
(3, 17, 13, 230, 139, 2, -1, 1, -1, 1, '20.00', '29.99', 1, '0.69', 'FLATUPS3', 'FLUTSFUSD5', '', 1, NULL, '2018-04-02', 1, '2018-04-05'),
(7, 17, 12, 230, 139, 1, -1, 1, -1, 1, '9.99', '99.99', 1, '0.49', 'FLRTS7', 'FLUTSFUSD2', 'FLUTSF15', 1, NULL, '2018-04-06', 0, NULL),
(8, 20, 12, 230, 139, 1, 0, 1, 0, 1, '100.00', '299.99', 1, '2.99', 'FLRTS8', NULL, 'FLUTSF18', 1, NULL, '2018-04-03', 0, NULL),
(13, 17, 12, 230, 139, 2, 2, 1, 3, 1, '20.00', '30.00', 1, '5.99', 'FLATUPS13', NULL, '', 0, NULL, '2018-04-03', 1, '2018-04-05'),
(15, 17, 13, 230, 139, 2, -1, 1, -1, 1, '31.00', '35.00', 1, '6.99', 'FLATUPS15', NULL, '', 0, NULL, '2018-04-03', 1, '2018-04-05'),
(16, 17, 13, 230, 139, 2, -1, 0, -1, 0, '30.00', '32.00', 1, '100.00', 'FLATUPS16', NULL, '', 0, NULL, '2018-04-03', 1, '2018-04-05'),
(17, 17, 13, 230, 139, 3, -1, 1, -1, 1, '1.00', '10.00', 1, '2.99', 'FLUBPS17', NULL, '', 1, NULL, '2018-04-03', 0, NULL),
(18, 17, 12, 230, 139, 2, 5, 0, 5, 0, '10.00', '20.00', 1, '0.69', 'FLATUPS18', NULL, 'FLUTSF18', 1, NULL, '2018-04-06', 0, NULL),
(19, 17, 13, 230, 139, 2, -1, 0, -1, 0, '10.00', '20.00', 1, '0.10', 'FLATUPS19', NULL, '', 1, NULL, '2018-04-06', 0, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `paymentmethod`
--

CREATE TABLE `paymentmethod` (
  `PaymentMethodId` int(11) NOT NULL,
  `PaymentTypeId` int(11) NOT NULL,
  `CompanyId` int(11) NOT NULL,
  `Title` varchar(50) DEFAULT NULL,
  `Description` varchar(250) DEFAULT NULL,
  `IsActive` tinyint(1) NOT NULL DEFAULT '1',
  `IsDeleted` tinyint(1) NOT NULL DEFAULT '0',
  `CreatedDate` date NOT NULL,
  `DeletedDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `paymentmethod`
--

INSERT INTO `paymentmethod` (`PaymentMethodId`, `PaymentTypeId`, `CompanyId`, `Title`, `Description`, `IsActive`, `IsDeleted`, `CreatedDate`, `DeletedDate`) VALUES
(0, 1, 17, 'All', 'all', 1, 1, '2018-03-01', NULL),
(1, 1, 17, 'Authorize', 'my custom method', 0, 1, '2018-02-05', '2018-02-28'),
(11, 3, 17, 'test', 'test ishu', 0, 1, '2018-01-15', '2018-01-16'),
(12, 3, 17, 'Visa Credit Card', 'MagicPay Payment Gateway', 1, 0, '2018-04-09', NULL),
(13, 4, 17, 'Bank Transfer', 'Bank Transfer', 1, 0, '2018-03-28', NULL),
(14, 5, 17, 'Cash-Pickup', 'Cash-Pickup', 1, 0, '2018-03-28', NULL),
(15, 6, 17, 'Bank Debit (ACH)', 'Bank Debit (ACH)', 1, 0, '2018-04-09', NULL),
(17, 7, 17, 'Bank2Bank', 'Bank2Bank', 1, 0, '2018-03-28', NULL),
(18, 8, 17, 'Gift Card', 'Gift Card', 1, 0, '2018-03-28', NULL),
(19, 9, 17, 'Voucher', 'Voucher', 1, 0, '2018-04-09', NULL),
(20, 10, 17, 'Wallet', 'Wallet', 1, 0, '2018-04-09', NULL),
(21, 11, 17, 'MasterCard Credit Card', 'MasterCard Credit Card', 1, 0, '2018-04-09', NULL),
(22, 12, 17, 'Visa Debit Card', 'Visa Debit Card', 1, 0, '2018-04-09', NULL),
(23, 13, 17, 'MasterCard Debit Card', 'MasterCard Debit Card', 1, 0, '2018-04-09', NULL),
(24, 8, 17, 'Visa Gift Card', 'Visa Gift Card', 1, 1, '2018-04-09', '2018-04-09'),
(25, 8, 17, 'Visa Gift Card', 'Visa Gift Card', 1, 0, '2018-04-09', NULL),
(26, 14, 17, 'MasterCard Gift Card', 'MasterCard Gift Card', 1, 0, '2018-04-09', NULL),
(27, 9, 17, 'Visa Voucher', 'Visa Voucher', 1, 0, '2018-04-09', NULL),
(28, 15, 17, 'MasterCard Voucher', 'MasterCard Voucher', 1, 0, '2018-04-09', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `paymenttype`
--

CREATE TABLE `paymenttype` (
  `PaymentTypeId` int(11) NOT NULL,
  `PaymentType` varchar(50) NOT NULL,
  `Description` varchar(200) NOT NULL,
  `PaymentTypeLogo` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `paymenttype`
--

INSERT INTO `paymenttype` (`PaymentTypeId`, `PaymentType`, `Description`, `PaymentTypeLogo`) VALUES
(1, 'Authorize.net', 'Authorize .net payment gateway', ''),
(3, 'Visa Credit Card', 'Magic Pay Gateway', ''),
(4, 'Bank Transfer', 'Bank Transfer', NULL),
(5, 'Cash-Pickup', 'Cash-Pickup', NULL),
(6, 'Bank Debit (ACH)', 'Bank Debit (ACH)', NULL),
(7, 'Bank2Bank', 'Bank2Bank', NULL),
(8, 'Visa Gift Card', 'Visa Gift Card', NULL),
(9, 'Visa Voucher', 'Visa Voucher', NULL),
(10, 'Wallet2Wallet', 'Wallet2Wallet', NULL),
(11, 'MasterCard Credit Card', 'MasterCard Credit Card', NULL),
(12, 'Visa Debit Card', 'Visa Debit Card', NULL),
(13, 'MasterCard Debit Card', 'MasterCard Debit Card', NULL),
(14, 'MasterCard Gift Card', 'MasterCard Gift Card', NULL),
(15, 'MasterCard Voucher', 'MasterCard Voucher', NULL),
(16, 'Wallet2Bank', 'Wallet2Bank', NULL),
(17, 'Wallet2Visa Credit Card', 'Wallet2Visa Credit Card', NULL),
(18, 'Wallet2MasterCredit Card', 'Wallet2MasterCredit Card', NULL),
(19, 'Wallet2MasterCard Debit Card', 'Wallet2MasterCard Debit Card', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `transactiondetails`
--

CREATE TABLE `transactiondetails` (
  `TransactionId` int(11) NOT NULL,
  `CompanyId` int(11) NOT NULL,
  `CustomerId` int(11) NOT NULL,
  `TransactionDetail` varchar(100) NOT NULL,
  `SendingAmount` decimal(18,2) NOT NULL,
  `Charges` decimal(18,2) NOT NULL,
  `Fees` decimal(18,2) NOT NULL,
  `Tax` decimal(18,2) NOT NULL,
  `TransactionDate` datetime NOT NULL,
  `Status` varchar(50) NOT NULL,
  `PaymentGatewayResponse` varchar(500) NOT NULL,
  `PaymentGatewayTransactionId` varchar(50) NOT NULL,
  `SendingCurrencyId` int(11) NOT NULL,
  `ReceivingAmount` decimal(18,2) NOT NULL,
  `ReceivingCurrencytId` int(11) NOT NULL,
  `BeneficiaryId` int(11) NOT NULL,
  `PaymentMethodId` int(11) NOT NULL,
  `DestinationCountryId` int(11) NOT NULL,
  `SourceCountryId` int(11) NOT NULL,
  `IsLive` int(11) NOT NULL,
  `TransferPurpose` varchar(100) NOT NULL,
  `ExchangeRate` decimal(10,0) NOT NULL,
  `DeliveryType` varchar(50) NOT NULL,
  `CreatedDate` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transactiondetails`
--

INSERT INTO `transactiondetails` (`TransactionId`, `CompanyId`, `CustomerId`, `TransactionDetail`, `SendingAmount`, `Charges`, `Fees`, `Tax`, `TransactionDate`, `Status`, `PaymentGatewayResponse`, `PaymentGatewayTransactionId`, `SendingCurrencyId`, `ReceivingAmount`, `ReceivingCurrencytId`, `BeneficiaryId`, `PaymentMethodId`, `DestinationCountryId`, `SourceCountryId`, `IsLive`, `TransferPurpose`, `ExchangeRate`, `DeliveryType`, `CreatedDate`) VALUES
(1, 17, 8, 'swag', '24.99', '0.00', '5.00', '0.00', '2018-02-23 10:08:26', 'Success', '1', '4000853486', 3, '0.00', 3, 0, 12, 138, 138, 0, 'Bill Payment', '0', '0', '2018-02-23 10:08:26'),
(2, 17, 8, 'zolly', '6.99', '0.00', '5.00', '0.00', '2018-02-23 10:10:12', 'Success', '1', '4000854952', 3, '0.00', 3, 0, 12, 138, 138, 0, 'Bill Payment', '0', '0', '2018-02-23 10:10:12'),
(3, 17, 8, 'zolly', '104.99', '0.00', '0.00', '0.00', '2018-02-23 14:04:36', 'Success', '1', '4001055666', 1, '1855.00', 3, 1, 12, 138, 226, 0, 'BankDeposit', '19', 'BankDeposit', '2018-02-23 14:04:36'),
(4, 17, 8, 'zolly', '11.48', '0.00', '5.00', '0.00', '2018-02-23 14:45:30', 'Success', '1', '4001129337', 3, '0.00', 3, 0, 12, 138, 138, 0, 'Bill Payment', '0', '0', '2018-02-23 14:45:30'),
(5, 17, 8, 'zolly', '13.48', '0.00', '5.00', '0.00', '2018-02-26 18:04:52', 'Success', '1', '4004757144', 3, '0.00', 3, 0, 12, 138, 138, 0, 'Bill Payment', '0', '0', '2018-02-26 18:04:52'),
(6, 17, 8, 'zolly', '11.48', '0.00', '5.00', '0.00', '2018-02-27 07:08:33', 'Success', '1', '4005491069', 3, '0.00', 3, 0, 12, 138, 138, 0, 'Bill Payment', '0', '0', '2018-02-27 07:08:33'),
(7, 17, 8, 'zolly', '104.99', '0.00', '0.00', '0.00', '2018-02-27 19:31:26', 'Success', '1', '4006262347', 1, '1879.00', 3, 1, 12, 139, 230, 0, 'BankDeposit', '19', 'BankDeposit', '2018-02-27 19:31:26'),
(8, 17, 8, 'zolly', '11.98', '0.00', '5.00', '0.00', '2018-02-28 10:27:58', 'Success', '1', '4007152385', 3, '0.00', 3, 0, 12, 139, 139, 0, 'Bill Payment', '0', '0', '2018-02-28 10:27:58'),
(9, 17, 8, 'zolly', '11.48', '0.00', '5.00', '0.00', '2018-03-01 09:17:15', 'Success', '1', '4009059159', 3, '0.00', 3, 0, 12, 139, 139, 0, 'Bill Payment', '0', '0', '2018-03-01 09:17:15'),
(10, 17, 8, 'zolly', '16.47', '0.00', '5.00', '0.00', '2018-03-01 12:25:06', 'Success', '1', '4009375424', 3, '0.00', 3, 0, 12, 139, 139, 0, 'Bill Payment', '0', '0', '2018-03-01 12:25:06'),
(11, 17, 8, 'zolly', '19.97', '0.00', '5.00', '0.00', '2018-03-01 12:32:11', 'Success', '1', '4009391491', 3, '0.00', 3, 0, 12, 139, 139, 0, 'Bill Payment', '0', '0', '2018-03-01 12:32:11'),
(12, 17, 8, 'zolly', '19.97', '0.00', '5.00', '0.00', '2018-03-01 12:33:32', 'Success', '1', '4009394933', 3, '0.00', 3, 0, 12, 139, 139, 0, 'Bill Payment', '0', '0', '2018-03-01 12:33:32'),
(13, 17, 8, 'zolly', '19.97', '0.00', '5.00', '0.00', '2018-03-01 12:35:52', 'Success', '1', '4009401068', 3, '0.00', 3, 0, 12, 139, 139, 0, 'Bill Payment', '0', '0', '2018-03-01 12:35:52'),
(14, 17, 8, 'zolly', '14.98', '0.00', '5.00', '0.00', '2018-03-01 12:36:51', 'Success', '1', '4009403392', 3, '0.00', 3, 0, 12, 139, 139, 0, 'Bill Payment', '0', '0', '2018-03-01 12:36:51'),
(15, 17, 8, 'zolly', '10.98', '0.00', '5.00', '0.00', '2018-03-01 12:55:10', 'Success', '1', '4009445003', 3, '0.00', 3, 0, 12, 139, 139, 0, 'Bill Payment', '0', '0', '2018-03-01 12:55:10'),
(16, 17, 8, 'zolly', '11.98', '0.00', '5.00', '0.00', '2018-03-01 12:59:19', 'Success', '1', '4009454842', 3, '0.00', 3, 0, 12, 139, 139, 0, 'Bill Payment', '0', '0', '2018-03-01 12:59:19'),
(17, 17, 8, 'zolly', '14.98', '0.00', '5.00', '0.00', '2018-03-01 13:05:35', 'Success', '1', '4009470575', 3, '0.00', 3, 0, 12, 139, 139, 0, 'Bill Payment', '0', '0', '2018-03-01 13:05:35'),
(18, 17, 8, 'zolly', '11.48', '0.00', '5.00', '0.00', '2018-03-01 13:27:22', 'Success', '1', '4009516289', 3, '0.00', 3, 0, 12, 139, 139, 0, 'Bill Payment', '0', '0', '2018-03-01 13:27:22'),
(19, 17, 8, 'zolly', '14.99', '0.00', '0.00', '0.00', '2018-03-05 09:19:53', 'Success', '1', '4014954395', 1, '189.00', 3, 1, 12, 139, 230, 0, 'BankDeposit', '19', 'BankDeposit', '2018-03-05 09:19:53'),
(20, 17, 8, 'zolly', '14.99', '0.00', '0.00', '0.00', '2018-03-05 09:23:42', 'Success', '1', '4014960259', 1, '189.00', 3, 2, 12, 139, 230, 0, 'BankDeposit', '19', 'BankDeposit', '2018-03-05 09:23:42'),
(21, 17, 8, 'zolly', '14.99', '0.00', '0.00', '0.00', '2018-03-05 09:26:46', 'Success', '1', '4014966871', 1, '189.00', 3, 1, 12, 139, 230, 0, 'BankDeposit', '19', 'BankDeposit', '2018-03-05 09:26:46'),
(22, 17, 8, 'zolly', '14.99', '0.00', '0.00', '0.00', '2018-03-05 09:33:00', 'Success', '1', '4014980826', 1, '189.00', 3, 2, 12, 139, 230, 0, 'BankDeposit', '19', 'BankDeposit', '2018-03-05 09:33:00'),
(23, 17, 8, 'zolly', '100.00', '0.00', '5.00', '0.00', '2018-03-05 09:40:58', 'Success', '1', '4014994890', 3, '0.00', 3, 0, 12, 139, 139, 0, 'Bill Payment', '0', '0', '2018-03-05 09:40:58'),
(24, 17, 8, 'zolly', '44.99', '0.00', '0.00', '0.00', '2018-03-05 10:35:36', 'Success', '1', '4015027711', 1, '754.40', 3, 1, 12, 139, 230, 0, 'BankDeposit', '19', 'BankDeposit', '2018-03-05 10:35:36'),
(25, 17, 8, 'zolly', '7.49', '0.00', '5.00', '0.00', '2018-03-05 10:37:34', 'Success', '1', '4015029695', 3, '0.00', 3, 0, 12, 139, 139, 0, 'Bill Payment', '0', '0', '2018-03-05 10:37:34'),
(26, 17, 8, 'zolly', '14.99', '0.00', '0.00', '0.00', '2018-03-05 11:41:16', 'Success', '1', '4015082696', 1, '188.80', 3, 1, 12, 139, 230, 0, 'BankDeposit', '19', 'BankDeposit', '2018-03-05 11:41:16'),
(27, 17, 8, 'zolly', '3.49', '0.00', '5.00', '0.00', '2018-03-05 11:42:52', 'Success', '1', '4015083679', 3, '0.00', 3, 0, 12, 139, 139, 0, 'Bill Payment', '0', '0', '2018-03-05 11:42:52'),
(28, 17, 8, 'zolly', '104.99', '0.00', '0.00', '0.00', '2018-03-05 17:47:43', 'Success', '1', '4015575573', 1, '1888.00', 3, 2, 12, 139, 230, 0, 'BankDeposit', '19', 'BankDeposit', '2018-03-05 17:47:43'),
(29, 17, 8, 'zolly', '24.99', '0.00', '0.00', '0.00', '2018-03-07 06:29:01', 'Success', '1', '4017774668', 1, '377.00', 3, 1, 12, 139, 230, 0, 'CashPickup', '19', 'CashPickup', '2018-03-07 06:29:01'),
(30, 17, 8, 'guru', '200.00', '0.00', '2.00', '0.00', '2018-03-07 06:36:37', 'Success', '1', '4017777786', 1, '0.00', 2, 1, 12, 98, 230, 0, 'peronal', '0', '0', '2018-03-07 06:36:37'),
(31, 17, 8, 'zolly', '16.99', '0.00', '0.00', '0.00', '2018-03-07 06:43:47', 'Success', '1', '4017780390', 1, '226.32', 3, 1, 12, 139, 230, 0, 'BankDeposit', '19', 'BankDeposit', '2018-03-07 06:43:47'),
(32, 17, 8, 'zolly', '10.00', '0.00', '2.00', '0.00', '2018-03-07 06:56:49', 'Success', '1', '4017791467', 1, '188.60', 3, 13, 12, 139, 230, 0, 'BankDeposit', '19', 'BankDeposit', '2018-03-07 06:56:49'),
(33, 17, 8, 'zolly', '11.99', '0.00', '1.99', '0.00', '2018-03-07 07:02:34', 'Success', '1', '4017798379', 1, '188.30', 3, 1, 12, 139, 230, 0, 'BankDeposit', '19', 'BankDeposit', '2018-03-07 07:02:34'),
(34, 17, 8, 'zolly', '6.00', '0.00', '4.99', '0.00', '2018-03-07 08:14:22', 'Success', '1', '4017880311', 3, '0.00', 3, 0, 12, 139, 139, 0, 'Bill Payment', '0', '0', '2018-03-07 08:14:22'),
(35, 17, 8, 'ram ranjana kumari', '10.00', '0.00', '1.00', '0.00', '2018-03-07 03:17:54', 'Success', '1', '40010920240', 3, '3.00', 3, 0, 1, 226, 226, 0, 'Bill Payment', '0', '0', '2018-03-07 09:17:52'),
(36, 17, 8, 'zolly', '6.99', '0.00', '4.99', '0.00', '2018-03-07 09:36:55', 'Success', '1', '4017956457', 3, '0.00', 3, 0, 12, 139, 139, 0, 'Bill Payment', '0', '0', '2018-03-07 09:36:55'),
(37, 17, 8, 'zolly', '11.99', '0.00', '4.99', '0.00', '2018-03-07 10:35:36', 'Success', '1', '4017992734', 3, '0.00', 3, 0, 12, 139, 139, 0, 'Bill Payment', '0', '0', '2018-03-07 10:35:36'),
(38, 17, 8, 'zolly', '27.99', '0.00', '4.99', '0.00', '2018-03-07 10:37:56', 'Success', '1', '4017994874', 3, '0.00', 3, 0, 12, 139, 139, 0, 'Bill Payment', '0', '0', '2018-03-07 10:37:56'),
(39, 17, 8, 'zolly', '103.99', '0.00', '3.99', '0.00', '2018-03-14 14:35:04', 'Success', '1', '4027050829', 1, '1859.00', 3, 14, 12, 139, 230, 0, 'BankDeposit', '19', 'BankDeposit', '2018-03-14 14:35:04'),
(40, 17, 8, 'zolly', '8.99', '0.00', '4.99', '0.00', '2018-03-14 14:39:58', 'Success', '1', '4027057565', 3, '0.00', 3, 0, 12, 139, 139, 0, 'Bill Payment', '0', '0', '2018-03-14 14:39:58'),
(41, 17, 8, 'zolly', '43.99', '0.00', '3.99', '0.00', '2018-03-19 09:22:35', 'Success', '1', '4033223634', 1, '752.00', 3, 1, 12, 139, 230, 0, 'BankDeposit', '19', 'BankDeposit', '2018-03-19 09:22:35'),
(42, 17, 8, 'zolly', '13.99', '0.00', '3.99', '0.00', '2018-03-19 09:24:27', 'Success', '1', '4033224872', 1, '188.00', 3, 1, 12, 139, 230, 0, 'BankDeposit', '19', 'BankDeposit', '2018-03-19 09:24:27'),
(43, 17, 8, 'zolly', '43.99', '0.00', '3.99', '0.00', '2018-03-19 09:33:38', 'Success', '1', '4033232745', 1, '751.60', 3, 1, 12, 139, 230, 0, 'CashPickup', '19', 'CashPickup', '2018-03-19 09:33:38'),
(44, 17, 8, 'zolly', '5.49', '0.00', '4.99', '0.00', '2018-03-19 10:43:33', 'Success', '1', '4033284959', 3, '0.00', 3, 0, 12, 139, 139, 0, 'Bill Payment', '0', '0', '2018-03-19 10:43:33'),
(45, 17, 8, 'zolly', '4.99', '0.00', '4.99', '0.00', '2018-03-19 10:49:40', 'Success', '1', '4033288008', 3, '0.00', 3, 0, 12, 139, 139, 0, 'Bill Payment', '0', '0', '2018-03-19 10:49:40'),
(46, 17, 8, 'zolly', '7.99', '0.00', '4.99', '0.00', '2018-03-19 11:20:21', 'Success', '1', '4033307543', 3, '0.00', 3, 0, 12, 139, 139, 0, 'Bill Payment', '0', '0', '2018-03-19 11:20:21'),
(47, 17, 8, 'zolly', '101.99', '0.00', '3.99', '0.00', '2018-03-19 11:28:37', 'Success', '1', '4033312048', 1, '1843.38', 3, 1, 12, 139, 230, 0, 'BankDeposit', '19', 'BankDeposit', '2018-03-19 11:28:37'),
(48, 17, 8, 'zolly', '22.00', '0.00', '0.00', '0.00', '2018-03-19 11:29:07', 'Success', '1', '4033312309', 1, '1421.20', 2, 2, 12, 98, 230, 0, 'wq', '65', 'wqe', '2018-03-19 11:29:07'),
(49, 17, 8, 'zolly', '7.99', '0.00', '4.99', '0.00', '2018-03-19 11:29:29', 'Success', '1', '4033312508', 3, '0.00', 3, 0, 12, 139, 139, 0, 'Bill Payment', '0', '0', '2018-03-19 11:29:29'),
(50, 17, 8, 'zolly', '103.99', '0.00', '4.99', '0.00', '2018-03-19 11:31:04', 'Success', '1', '4033313393', 3, '0.00', 3, 0, 12, 139, 139, 0, 'Bill Payment', '0', '0', '2018-03-19 11:31:04'),
(51, 17, 8, 'zolly', '2.99', '0.00', '4.99', '0.00', '2018-04-02 07:07:36', 'Success', '1', '4053209270', 3, '0.00', 3, 0, 12, 139, 139, 0, 'Bill Payment', '0', '0', '2018-04-02 07:07:36'),
(52, 17, 8, 'zolly', '9.99', '0.00', '4.99', '0.00', '2018-04-02 07:29:38', 'Success', '1', '4053254986', 3, '0.00', 3, 0, 12, 139, 139, 0, 'Bill Payment', '0', '0', '2018-04-02 07:29:38'),
(53, 17, 8, 'zolly', '5.89', '0.00', '4.99', '0.00', '2018-04-02 12:14:03', 'Success', '1', '4053566939', 3, '0.00', 3, 0, 12, 139, 139, 0, 'Bill Payment', '0', '0', '2018-04-02 12:14:03'),
(54, 17, 8, 'zolly', '3.99', '0.00', '4.99', '0.00', '2018-04-02 13:15:02', 'Success', '1', '4053638570', 3, '0.00', 3, 0, 12, 139, 139, 0, 'Bill Payment', '0', '0', '2018-04-02 13:15:02'),
(55, 17, 8, 'zolly', '11.59', '0.00', '4.99', '0.00', '2018-04-04 07:44:08', 'Success', '1', '4056712960', 3, '0.00', 3, 0, 12, 139, 139, 0, 'Bill Payment', '0', '0', '2018-04-04 07:44:08'),
(56, 17, 8, 'zolly', '3.49', '0.00', '4.99', '0.00', '2018-04-04 15:33:04', 'Success', '1', '4057549432', 3, '0.00', 3, 0, 12, 139, 139, 0, 'Bill Payment', '0', '0', '2018-04-04 15:33:04'),
(57, 17, 8, 'zolly', '11.69', '0.00', '4.99', '0.00', '2018-04-06 03:38:59', 'Success', '1', '4059776141', 3, '0.00', 3, 0, 12, 139, 139, 0, 'Bill Payment', '0', '0', '2018-04-06 03:38:59'),
(58, 17, 8, 'zolly', '8.00', '0.00', '4.99', '0.00', '2018-04-09 06:52:32', 'Success', '1', '4063367614', 3, '0.00', 3, 0, 12, 139, 139, 0, 'Bill Payment', '0', '0', '2018-04-09 06:52:32'),
(59, 17, 8, 'zolly', '1.00', '0.00', '4.99', '0.00', '2018-04-09 07:17:44', 'Success', '1', '4063384751', 3, '0.00', 3, 0, 21, 139, 139, 0, 'Bill Payment', '0', '0', '2018-04-09 07:17:44'),
(60, 17, 8, 'zolly', '7.00', '0.00', '4.99', '0.00', '2018-04-09 07:18:20', 'Success', '1', '4063385389', 3, '0.00', 3, 0, 21, 139, 139, 0, 'Bill Payment', '0', '0', '2018-04-09 07:18:20'),
(61, 17, 8, 'zolly', '4.10', '0.00', '4.99', '0.00', '2018-04-09 07:28:55', 'Success', '1', '4063393123', 3, '0.00', 3, 0, 12, 139, 139, 0, 'Bill Payment', '0', '0', '2018-04-09 07:28:55'),
(62, 17, 8, 'zolly', '7.00', '0.00', '4.99', '0.00', '2018-04-09 07:30:24', 'Success', '1', '4063393945', 3, '0.00', 3, 0, 21, 139, 139, 0, 'Bill Payment', '0', '0', '2018-04-09 07:30:24'),
(63, 17, 8, 'zolly', '3.00', '0.00', '4.99', '0.00', '2018-04-09 07:30:48', 'Success', '1', '4063394217', 3, '0.00', 3, 0, 21, 139, 139, 0, 'Bill Payment', '0', '0', '2018-04-09 07:30:48'),
(64, 17, 8, 'zolly', '2.00', '0.00', '4.99', '0.00', '2018-04-09 07:31:27', 'Success', '1', '4063395104', 3, '0.00', 3, 0, 12, 139, 139, 0, 'Bill Payment', '0', '0', '2018-04-09 07:31:27'),
(65, 17, 8, 'zolly', '12.69', '0.00', '4.99', '0.00', '2018-04-09 07:32:20', 'Success', '1', '4063396337', 3, '0.00', 3, 0, 12, 139, 139, 0, 'Bill Payment', '0', '0', '2018-04-09 07:32:20'),
(66, 17, 8, 'zolly', '11.69', '0.00', '4.99', '0.00', '2018-04-09 07:34:16', 'Success', '1', '4063398853', 3, '0.00', 3, 0, 12, 139, 139, 0, 'Bill Payment', '0', '0', '2018-04-09 07:34:16'),
(67, 17, 8, 'zolly', '8.00', '0.00', '0.00', '0.00', '2018-04-09 07:44:00', 'Success', '1', '4063408499', 3, '0.00', 3, 0, 21, 139, 139, 0, 'Bill Payment', '0', '0', '2018-04-09 07:44:00'),
(68, 17, 8, 'zolly', '3.00', '0.00', '0.00', '0.00', '2018-04-09 07:56:41', 'Success', '1', '4063417395', 3, '0.00', 3, 0, 12, 139, 139, 0, 'Bill Payment', '0', '0', '2018-04-09 07:56:41'),
(69, 17, 8, 'zolly', '1.00', '0.00', '0.00', '0.00', '2018-04-09 07:57:54', 'Success', '1', '4063418163', 3, '0.00', 3, 0, 15, 139, 139, 0, 'Bill Payment', '0', '0', '2018-04-09 07:57:54'),
(70, 17, 8, 'zolly', '3.00', '0.00', '0.00', '0.00', '2018-04-09 07:59:59', 'Success', '1', '4063419455', 3, '0.00', 3, 0, 21, 139, 139, 0, 'Bill Payment', '0', '0', '2018-04-09 07:59:59'),
(71, 17, 8, 'ram ranjana kumari', '10.00', '0.00', '0.00', '0.00', '2018-04-09 03:01:59', 'Success', '1', '40012510724', 3, '3.00', 3, 0, 1, 226, 226, 0, 'Bill Payment', '0', '0', '2018-04-09 08:01:57'),
(72, 17, 8, 'zolly', '1.00', '0.00', '0.00', '0.00', '2018-04-09 08:03:14', 'Success', '1', '4063423887', 3, '0.00', 3, 0, 12, 139, 139, 0, 'Bill Payment', '0', '0', '2018-04-09 08:03:14'),
(73, 17, 8, 'zolly', '4.00', '0.00', '0.00', '0.00', '2018-04-09 13:34:01', 'Success', '1', '4063689546', 3, '0.00', 3, 0, 15, 139, 139, 0, 'Bill Payment', '0', '0', '2018-04-09 13:34:01'),
(74, 17, 8, 'zolly', '22.00', '0.00', '0.00', '0.00', '2018-04-09 13:34:51', 'Success', '1', '4063690431', 3, '0.00', 3, 0, 21, 139, 139, 0, 'Bill Payment', '0', '0', '2018-04-09 13:34:51');

-- --------------------------------------------------------

--
-- Table structure for table `transactionfeesharing`
--

CREATE TABLE `transactionfeesharing` (
  `TransactionFeeSharingId` int(11) NOT NULL,
  `CompanyId` int(11) NOT NULL,
  `TransactionFeeType` varchar(50) NOT NULL,
  `PaymentMethodId` int(11) NOT NULL,
  `SourceCountryId` int(11) NOT NULL,
  `DestinationCountryId` int(11) NOT NULL,
  `YourShare` varchar(50) NOT NULL,
  `PayInAgent` int(11) NOT NULL,
  `PayInAgentPer` varchar(50) NOT NULL,
  `PayOutAgent` int(11) NOT NULL,
  `PayOutAgentPer` varchar(50) NOT NULL,
  `Code` varchar(50) DEFAULT NULL,
  `AutoFees` decimal(18,2) DEFAULT NULL,
  `CreatedDate` date NOT NULL,
  `IsSpecific` tinyint(1) NOT NULL DEFAULT '0',
  `IsDeleted` tinyint(1) NOT NULL DEFAULT '0',
  `DeletedDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transactionfeesharing`
--

INSERT INTO `transactionfeesharing` (`TransactionFeeSharingId`, `CompanyId`, `TransactionFeeType`, `PaymentMethodId`, `SourceCountryId`, `DestinationCountryId`, `YourShare`, `PayInAgent`, `PayInAgentPer`, `PayOutAgent`, `PayOutAgentPer`, `Code`, `AutoFees`, `CreatedDate`, `IsSpecific`, `IsDeleted`, `DeletedDate`) VALUES
(15, 17, 'specific', 12, 139, 139, '30', 1, '60', 3, '10', 'FLUTSF15', '0.49', '2018-04-11', 1, 0, NULL),
(16, 17, 'specific', 12, 98, 98, '50', 5, '30', 5, '20', 'FLUTSF16', NULL, '2018-04-10', 1, 0, NULL),
(17, 17, 'specific', 21, 98, 98, '50', 5, '30', 5, '20', 'FLUTSF17', NULL, '2018-04-10', 1, 0, NULL),
(18, 17, 'Universal', 0, 139, 139, '50', 0, '30', 0, '20', 'FLUTSF18', '0.69', '2018-04-11', 0, 0, NULL),
(19, 17, 'Universal', 0, 98, 98, '50', 0, '0', 0, '50', 'FLUTSF19', NULL, '2018-04-10', 1, 0, NULL),
(20, 17, 'specific', 12, 98, 98, '50', 9, '30', 5, '20', 'FLUTSF20', NULL, '2018-04-10', 1, 0, NULL);

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
  `password` varchar(50) DEFAULT NULL,
  `country_id` int(11) NOT NULL,
  `profile_image` varchar(100) DEFAULT NULL,
  `is_active` tinyint(1) NOT NULL DEFAULT '1',
  `create_date` date NOT NULL,
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0',
  `deleted_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `Company_Id`, `first_name`, `last_name`, `email`, `phone`, `password`, `country_id`, `profile_image`, `is_active`, `create_date`, `is_deleted`, `deleted_date`) VALUES
(2, 0, 'admin', 'user', 'admin@gmail.com', '1234567890', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', 226, '', 1, '2017-10-10', 0, NULL),
(3, 17, 'test@gmail.com', 'kumar', 'test@gmail.com', '9638527410', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', 226, '', 1, '2017-10-25', 1, '2018-02-28');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `agent`
--
ALTER TABLE `agent`
  ADD PRIMARY KEY (`AgentId`),
  ADD KEY `country_id` (`country_id`);

--
-- Indexes for table `authorizepaymentsettings`
--
ALTER TABLE `authorizepaymentsettings`
  ADD PRIMARY KEY (`AuthorizePaymentSettingsId`),
  ADD KEY `PaymentMethodId` (`PaymentMethodId`);

--
-- Indexes for table `beneficiary`
--
ALTER TABLE `beneficiary`
  ADD PRIMARY KEY (`BeneficiaryId`),
  ADD KEY `CompanyId` (`CompanyId`),
  ADD KEY `BeneficiaryTypeId` (`BeneficiaryTypeId`),
  ADD KEY `CustomerId` (`CustomerId`),
  ADD KEY `CountryId` (`CountryId`);

--
-- Indexes for table `beneficiarytype`
--
ALTER TABLE `beneficiarytype`
  ADD PRIMARY KEY (`BeneficiaryTypeId`);

--
-- Indexes for table `billpaydetails`
--
ALTER TABLE `billpaydetails`
  ADD PRIMARY KEY (`BillPayId`),
  ADD KEY `CustomerId` (`CustomerId`),
  ADD KEY `CompanyId` (`CompanyId`);

--
-- Indexes for table `company`
--
ALTER TABLE `company`
  ADD PRIMARY KEY (`Company_Id`),
  ADD KEY `country_id` (`country_id`);

--
-- Indexes for table `country`
--
ALTER TABLE `country`
  ADD PRIMARY KEY (`country_id`);

--
-- Indexes for table `countrytest`
--
ALTER TABLE `countrytest`
  ADD PRIMARY KEY (`country_id`);

--
-- Indexes for table `currency`
--
ALTER TABLE `currency`
  ADD PRIMARY KEY (`CurrencyId`),
  ADD KEY `country_id` (`country_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customer_Id`),
  ADD KEY `Company_Id` (`Company_Id`),
  ADD KEY `country_id` (`country_id`);

--
-- Indexes for table `feescategory`
--
ALTER TABLE `feescategory`
  ADD PRIMARY KEY (`FeesCategoryId`);

--
-- Indexes for table `globalexchangerate`
--
ALTER TABLE `globalexchangerate`
  ADD PRIMARY KEY (`GlobalExchangeId`),
  ADD KEY `SourceCountryId` (`SourceCountryId`),
  ADD KEY `DestinationCountryId` (`DestinationCountryId`),
  ADD KEY `PaymentMethodId` (`PaymentMethodId`);

--
-- Indexes for table `magicpaydetails`
--
ALTER TABLE `magicpaydetails`
  ADD PRIMARY KEY (`MagicPayId`),
  ADD KEY `CustomerId` (`CustomerId`),
  ADD KEY `CompanyId` (`CompanyId`),
  ADD KEY `TransactionId` (`TransactionId`);

--
-- Indexes for table `paymentfees`
--
ALTER TABLE `paymentfees`
  ADD PRIMARY KEY (`PaymentFessId`),
  ADD KEY `DestinationCountry` (`DestinationCountry`),
  ADD KEY `FeesCategoryId` (`FeesCategoryId`),
  ADD KEY `AgentId` (`PayOutAgentId`),
  ADD KEY `FK_PersonOrder` (`PaymentMethodId`);

--
-- Indexes for table `paymentmethod`
--
ALTER TABLE `paymentmethod`
  ADD PRIMARY KEY (`PaymentMethodId`),
  ADD KEY `PaymentTypeId` (`PaymentTypeId`);

--
-- Indexes for table `paymenttype`
--
ALTER TABLE `paymenttype`
  ADD PRIMARY KEY (`PaymentTypeId`);

--
-- Indexes for table `transactiondetails`
--
ALTER TABLE `transactiondetails`
  ADD PRIMARY KEY (`TransactionId`),
  ADD KEY `CompanyId` (`CompanyId`),
  ADD KEY `CustomerId` (`CustomerId`),
  ADD KEY `SendingCurrencyId` (`SendingCurrencyId`),
  ADD KEY `ReceivingCurrencytId` (`ReceivingCurrencytId`),
  ADD KEY `BeneficiaryId` (`BeneficiaryId`),
  ADD KEY `PaymentMethodId` (`PaymentMethodId`),
  ADD KEY `DestinationCountryId` (`DestinationCountryId`),
  ADD KEY `SourceCountryId` (`SourceCountryId`);

--
-- Indexes for table `transactionfeesharing`
--
ALTER TABLE `transactionfeesharing`
  ADD PRIMARY KEY (`TransactionFeeSharingId`),
  ADD KEY `FK_transactionfeesharing` (`PaymentMethodId`),
  ADD KEY `SourceCountryId` (`SourceCountryId`),
  ADD KEY `DestinationCountryId` (`DestinationCountryId`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD KEY `customer_Id` (`Company_Id`),
  ADD KEY `country_id` (`country_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `agent`
--
ALTER TABLE `agent`
  MODIFY `AgentId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `authorizepaymentsettings`
--
ALTER TABLE `authorizepaymentsettings`
  MODIFY `AuthorizePaymentSettingsId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `beneficiary`
--
ALTER TABLE `beneficiary`
  MODIFY `BeneficiaryId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `beneficiarytype`
--
ALTER TABLE `beneficiarytype`
  MODIFY `BeneficiaryTypeId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `billpaydetails`
--
ALTER TABLE `billpaydetails`
  MODIFY `BillPayId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=55;
--
-- AUTO_INCREMENT for table `company`
--
ALTER TABLE `company`
  MODIFY `Company_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `country`
--
ALTER TABLE `country`
  MODIFY `country_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=242;
--
-- AUTO_INCREMENT for table `countrytest`
--
ALTER TABLE `countrytest`
  MODIFY `country_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=240;
--
-- AUTO_INCREMENT for table `currency`
--
ALTER TABLE `currency`
  MODIFY `CurrencyId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `customer_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
--
-- AUTO_INCREMENT for table `feescategory`
--
ALTER TABLE `feescategory`
  MODIFY `FeesCategoryId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `globalexchangerate`
--
ALTER TABLE `globalexchangerate`
  MODIFY `GlobalExchangeId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT for table `magicpaydetails`
--
ALTER TABLE `magicpaydetails`
  MODIFY `MagicPayId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;
--
-- AUTO_INCREMENT for table `paymentfees`
--
ALTER TABLE `paymentfees`
  MODIFY `PaymentFessId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT for table `paymentmethod`
--
ALTER TABLE `paymentmethod`
  MODIFY `PaymentMethodId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;
--
-- AUTO_INCREMENT for table `paymenttype`
--
ALTER TABLE `paymenttype`
  MODIFY `PaymentTypeId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
--
-- AUTO_INCREMENT for table `transactiondetails`
--
ALTER TABLE `transactiondetails`
  MODIFY `TransactionId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=75;
--
-- AUTO_INCREMENT for table `transactionfeesharing`
--
ALTER TABLE `transactionfeesharing`
  MODIFY `TransactionFeeSharingId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `authorizepaymentsettings`
--
ALTER TABLE `authorizepaymentsettings`
  ADD CONSTRAINT `authorizepaymentsettings_ibfk_1` FOREIGN KEY (`PaymentMethodId`) REFERENCES `paymentmethod` (`PaymentMethodId`);

--
-- Constraints for table `globalexchangerate`
--
ALTER TABLE `globalexchangerate`
  ADD CONSTRAINT `globalexchangerate_ibfk_3` FOREIGN KEY (`SourceCountryId`) REFERENCES `country` (`country_id`),
  ADD CONSTRAINT `globalexchangerate_ibfk_4` FOREIGN KEY (`DestinationCountryId`) REFERENCES `country` (`country_id`),
  ADD CONSTRAINT `globalexchangerate_ibfk_5` FOREIGN KEY (`PaymentMethodId`) REFERENCES `paymentmethod` (`PaymentMethodId`);

--
-- Constraints for table `magicpaydetails`
--
ALTER TABLE `magicpaydetails`
  ADD CONSTRAINT `magicpaydetails_ibfk_1` FOREIGN KEY (`CustomerId`) REFERENCES `customer` (`customer_Id`),
  ADD CONSTRAINT `magicpaydetails_ibfk_2` FOREIGN KEY (`CompanyId`) REFERENCES `company` (`Company_Id`),
  ADD CONSTRAINT `magicpaydetails_ibfk_3` FOREIGN KEY (`TransactionId`) REFERENCES `transactiondetails` (`TransactionId`);

--
-- Constraints for table `paymentfees`
--
ALTER TABLE `paymentfees`
  ADD CONSTRAINT `FK_PersonOrder` FOREIGN KEY (`PaymentMethodId`) REFERENCES `paymentmethod` (`PaymentMethodId`);

--
-- Constraints for table `transactionfeesharing`
--
ALTER TABLE `transactionfeesharing`
  ADD CONSTRAINT `FK_transactionfeesharing` FOREIGN KEY (`PaymentMethodId`) REFERENCES `paymentmethod` (`PaymentMethodId`),
  ADD CONSTRAINT `transactionfeesharing_ibfk_1` FOREIGN KEY (`SourceCountryId`) REFERENCES `country` (`country_id`),
  ADD CONSTRAINT `transactionfeesharing_ibfk_2` FOREIGN KEY (`DestinationCountryId`) REFERENCES `country` (`country_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
