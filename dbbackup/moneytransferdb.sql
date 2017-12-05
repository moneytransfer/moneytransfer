-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 05, 2017 at 02:18 PM
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
  `AgentName` varchar(100) NOT NULL,
  `customer_Id` int(11) NOT NULL,
  `country_id` int(11) NOT NULL,
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

INSERT INTO `agent` (`AgentId`, `AgentName`, `customer_Id`, `country_id`, `Phone`, `AgentCode`, `Email`, `SerialNumberPrefix`, `Address1`, `Address2`, `SerialNumberLength`, `City`, `PostalCode`, `BureauDeChange`, `IsAllowedCreateAgent`, `AllowedCasiherTellerApproval`, `ApproveeachTransByCashierTeller`, `CreateComplianceGroup`, `AssignAdminToAgent`, `CreatedDate`, `IsActive`, `IsDeleted`, `DeletedDate`) VALUES
(0, 'mario', 8, 226, '4234', '34', 'sdfsdf@gmail.com', '4', 'ewrwer', 'rwer', '4', 'rewr', '42434', 0, 0, 0, 0, 0, 0, '2017-11-15 00:00:00', 1, 0, NULL),
(1, 'Test Agent', 8, 226, '4569871230', '1023', 'test@gmail.com', '45', 'test', 'test', '5', 'test', '10236', 0, 0, 0, 0, 0, 0, '2017-11-16 00:00:00', 1, 0, NULL);

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
  `IsActive` tinyint(1) NOT NULL DEFAULT '1',
  `IsDeleted` tinyint(1) NOT NULL DEFAULT '0',
  `CreatedDate` date NOT NULL,
  `DeletedDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `authorizepaymentsettings`
--

INSERT INTO `authorizepaymentsettings` (`AuthorizePaymentSettingsId`, `PaymentMethodId`, `Mode`, `PaymentUrl`, `MerchantLoginId`, `MerchantTransactionKey`, `IsActive`, `IsDeleted`, `CreatedDate`, `DeletedDate`) VALUES
(1, 1, 'TEST', 'ww.testcase.com', '6cUR4e9b', '8Q6338wTVa647Rfe', 1, 0, '2017-10-27', NULL),
(2, 5, 'Test', 'test', 'Testing', 'Test', 1, 0, '2017-10-27', NULL),
(3, 1, 'Mode', 'Url', 'Login', 'Key', 1, 0, '2017-10-27', NULL),
(4, 10, 'Test payment', 'www.testpay.com', 'test123', 'tggjhgjh78', 1, 0, '2017-10-28', NULL);

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
  `IsDeleted` tinyint(1) NOT NULL DEFAULT '0',
  `CreatedDate` datetime NOT NULL,
  `DeletedDate` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `beneficiary`
--

INSERT INTO `beneficiary` (`BeneficiaryId`, `CompanyId`, `BeneficiaryTypeId`, `CustomerId`, `FirstName`, `LastName`, `Phone`, `Email`, `Address1`, `Address2`, `City`, `State`, `ZipCode`, `CountryId`, `DOB`, `IsActive`, `IsDeleted`, `CreatedDate`, `DeletedDate`) VALUES
(0, 17, 2, 8, 'Test ', 'User', '1234567890', 'testuser@gmail.com', 'test', 'test', 'test', 'test', '12345', 226, '2017-12-20 00:00:00', 1, 0, '2017-12-04 00:00:00', NULL),
(1, 17, 1, 8, 'Ram', 'Rahim', '1234567890', 'ram@gmail.com', 'delhi', 'ncr', 'delhi', 'delhi ncr', '110027', 226, '2017-01-01 00:00:00', 1, 0, '2017-10-30 20:55:22', NULL),
(2, 17, 1, 8, 'Suresh', 'Mohil', '8010276833', 'suresh@gmail.com', 'nahan', 'jamli', 'Kangra', 'HP', '110027', 226, '2017-01-01 00:00:00', 0, 0, '2017-10-31 11:18:19', NULL),
(3, 17, 1, 8, 'abc', 'pindu', '7894561230', 'saa@gmail.com', 'galino 10', 'chd', 'ch', 'UT', '110014', 226, '2017-01-01 00:00:00', 1, 0, '2017-10-31 11:41:45', NULL),
(4, 17, 1, 8, 'uuu', 'yy', '1234567890', 'yy@gmail.com', 'delhi', 'ncr', 'delhi', 'delhi ncr', '110027', 226, '2017-01-01 00:00:00', 1, 0, '2017-10-31 12:53:37', NULL),
(5, 17, 1, 8, 'abu', 'yadav', '1234567890', 'abu@gmail.com', 'delhi', 'ncr', 'delhi', 'delhi ncr', '110027', 226, '2017-01-01 00:00:00', 1, 0, '2017-10-31 16:10:29', NULL),
(6, 17, 1, 8, 'Javed', 'Kumar', '1234567890', 'javed@gmail.com', 'delhi', 'ncr', 'delhi', 'delhi ncr', '110027', 226, '2017-01-01 00:00:00', 1, 0, '2017-11-03 11:05:39', NULL);

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
  `InvoiceAmount` decimal(10,0) NOT NULL,
  `FaceValueAmount` decimal(10,0) NOT NULL,
  `ResponseCode` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `billpaydetails`
--

INSERT INTO `billpaydetails` (`BillPayId`, `CompanyId`, `CustomerId`, `TransactionId`, `SenderName`, `MobileNumber`, `Version`, `SkuId`, `InvoiceNumber`, `TransactionDate`, `InvoiceAmount`, `FaceValueAmount`, `ResponseCode`) VALUES
(1, 17, 8, 1, 'Rishi', '9599902870', '1.0', '1560', '17723424', '2017-12-05 04:41:25', '10', '9', '000'),
(2, 17, 8, 2, 'Ishu', '9599902810', '1.0', '1560', '17723425', '2017-12-05 04:44:07', '21', '20', '000'),
(3, 17, 8, 3, 'sandhu', '9599902310', '1.0', '1560', '17723426', '2017-12-05 04:46:02', '34', '33', '000'),
(4, 17, 8, 4, 'ram ranjana kumari', '9599902190', '1.0', '1560', '17723427', '2017-12-05 05:18:55', '10', '9', '000');

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
  `iso` varchar(5) NOT NULL,
  `country_name` varchar(100) NOT NULL,
  `country_nicename` varchar(80) NOT NULL,
  `iso3` varchar(5) NOT NULL,
  `country_code` varchar(2) NOT NULL,
  `phonecode` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `country`
--

INSERT INTO `country` (`country_id`, `iso`, `country_name`, `country_nicename`, `iso3`, `country_code`, `phonecode`) VALUES
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
(1, 'USD', 226, 'Dollar'),
(2, 'INR', 99, 'Rupees'),
(3, 'MX', 138, 'MX');

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
(13, 17, '', 'Customer', 'test', '', '', '', '', '', 226, '123456789', 'customer@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '', '', '', 0, 0, 0, '2017-10-30 09:27:09', NULL);

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
(0, 'PaymentMethod'),
(1, 'Remittance'),
(2, 'Money transfer cancellation'),
(3, 'Wallet money fund transfer'),
(4, 'Wallet money load cash'),
(5, 'Airtime topup'),
(6, 'Bill'),
(7, 'Wallet money cash out');

-- --------------------------------------------------------

--
-- Table structure for table `paymentfees`
--

CREATE TABLE `paymentfees` (
  `PaymentFessId` int(11) NOT NULL,
  `PaymentMethodId` int(11) NOT NULL,
  `country_id` int(11) NOT NULL,
  `DestinationCountry` int(11) NOT NULL,
  `FeesCategoryId` int(11) NOT NULL,
  `AgentId` int(11) NOT NULL,
  `StartingAmount` decimal(10,0) NOT NULL,
  `EndAmount` decimal(10,0) NOT NULL,
  `FeesType` int(11) NOT NULL,
  `Fees` decimal(10,0) NOT NULL,
  `ChargeSendingAmount` tinyint(1) NOT NULL DEFAULT '0',
  `CreatedDate` date NOT NULL,
  `IsDeleted` tinyint(1) NOT NULL DEFAULT '0',
  `DeletedDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `paymentfees`
--

INSERT INTO `paymentfees` (`PaymentFessId`, `PaymentMethodId`, `country_id`, `DestinationCountry`, `FeesCategoryId`, `AgentId`, `StartingAmount`, `EndAmount`, `FeesType`, `Fees`, `ChargeSendingAmount`, `CreatedDate`, `IsDeleted`, `DeletedDate`) VALUES
(1, 1, 226, 99, 0, 0, '1', '2', 2, '3', 0, '2017-11-14', 0, NULL),
(2, 1, 226, 99, 0, 0, '1000', '2500', 1, '200', 0, '2017-11-13', 0, NULL),
(3, 1, 226, 99, 0, 0, '1', '2', 1, '3', 0, '2017-11-15', 0, NULL),
(4, 1, 226, 99, 0, 0, '1', '2500', 1, '300', 0, '2017-11-17', 0, NULL),
(5, 1, 226, 99, 1, 1, '10', '200', 2, '30', 0, '2017-11-17', 0, NULL),
(6, 1, 226, 99, 1, 1, '10', '250000', 2, '3000', 0, '2017-11-17', 0, NULL);

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
(1, 1, 17, 'Authorize', 'my custom method', 1, 0, '2017-10-27', NULL),
(2, 1, 17, 'payU', 'welcome to payu', 1, 0, '2017-10-23', NULL),
(3, 1, 17, 'Custom test', 'welcome to custom method test', 1, 0, '2017-10-27', NULL),
(4, 1, 0, 'Payment', 'Test Description', 1, 0, '2017-10-26', NULL),
(5, 1, 0, 'Title', 'Descripton', 1, 0, '2017-10-27', NULL),
(6, 1, 0, 'Test', 'Testing', 1, 0, '2017-10-26', NULL),
(7, 2, 0, 'Test', 'Testing', 1, 0, '2017-10-26', NULL),
(8, 2, 0, 'test title', 'testing description', 1, 0, '2017-10-26', NULL),
(9, 2, 20, 'Testing', 'Test', 1, 0, '2017-10-26', NULL),
(10, 1, 17, 'testing', 'testing', 1, 0, '2017-10-28', NULL);

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
(2, 'test', 'ishu kumar', '');

-- --------------------------------------------------------

--
-- Table structure for table `transactiondetails`
--

CREATE TABLE `transactiondetails` (
  `TransactionId` int(11) NOT NULL,
  `CompanyId` int(11) NOT NULL,
  `CustomerId` int(11) NOT NULL,
  `TransactionDetail` varchar(100) NOT NULL,
  `SendingAmount` decimal(10,0) NOT NULL,
  `Charges` decimal(10,0) NOT NULL,
  `Fees` decimal(10,0) NOT NULL,
  `Tax` decimal(10,0) NOT NULL,
  `TransactionDate` datetime NOT NULL,
  `Status` varchar(50) NOT NULL,
  `PaymentGatewayResponse` varchar(500) NOT NULL,
  `PaymentGatewayTransactionId` varchar(50) NOT NULL,
  `SendingCurrencyId` int(11) NOT NULL,
  `ReceivingAmount` decimal(10,0) NOT NULL,
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
(1, 17, 8, 'Rishi', '10', '0', '0', '0', '2017-12-05 04:41:25', 'Success', '1', '40008804854', 3, '0', 3, 0, 1, 226, 226, 0, 'Bill Payment', '0', '0', '2017-12-05 16:11:25'),
(2, 17, 8, 'Ishu', '21', '0', '0', '0', '2017-12-05 04:44:07', 'Success', '1', '40008804889', 3, '0', 3, 0, 1, 226, 226, 0, 'Bill Payment', '0', '0', '2017-12-05 16:14:07'),
(3, 17, 8, 'sandhu', '34', '0', '0', '0', '2017-12-05 04:46:02', 'Success', '1', '40008804914', 3, '0', 3, 0, 1, 226, 226, 0, 'Bill Payment', '0', '0', '2017-12-05 16:16:01'),
(4, 17, 8, 'ram ranjana kumari', '10', '0', '0', '0', '2017-12-05 05:18:55', 'Success', '1', '40008805256', 3, '0', 3, 0, 1, 226, 226, 0, 'Bill Payment', '0', '0', '2017-12-05 11:18:53');

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
(3, 17, 'test@gmail.com', 'kumar', 'test@gmail.com', '9638527410', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', 226, '', 1, '2017-10-25', 0, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `agent`
--
ALTER TABLE `agent`
  ADD PRIMARY KEY (`AgentId`),
  ADD KEY `country_id` (`country_id`),
  ADD KEY `customer_Id` (`customer_Id`);

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
-- Indexes for table `paymentfees`
--
ALTER TABLE `paymentfees`
  ADD PRIMARY KEY (`PaymentFessId`),
  ADD KEY `PaymentMethodId` (`PaymentMethodId`),
  ADD KEY `country_id` (`country_id`),
  ADD KEY `DestinationCountry` (`DestinationCountry`),
  ADD KEY `FeesCategoryId` (`FeesCategoryId`),
  ADD KEY `AgentId` (`AgentId`);

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
  MODIFY `AgentId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `authorizepaymentsettings`
--
ALTER TABLE `authorizepaymentsettings`
  MODIFY `AuthorizePaymentSettingsId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `beneficiary`
--
ALTER TABLE `beneficiary`
  MODIFY `BeneficiaryId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `beneficiarytype`
--
ALTER TABLE `beneficiarytype`
  MODIFY `BeneficiaryTypeId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `billpaydetails`
--
ALTER TABLE `billpaydetails`
  MODIFY `BillPayId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `company`
--
ALTER TABLE `company`
  MODIFY `Company_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `country`
--
ALTER TABLE `country`
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
  MODIFY `customer_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `feescategory`
--
ALTER TABLE `feescategory`
  MODIFY `FeesCategoryId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `paymentfees`
--
ALTER TABLE `paymentfees`
  MODIFY `PaymentFessId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `paymentmethod`
--
ALTER TABLE `paymentmethod`
  MODIFY `PaymentMethodId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `paymenttype`
--
ALTER TABLE `paymenttype`
  MODIFY `PaymentTypeId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `transactiondetails`
--
ALTER TABLE `transactiondetails`
  MODIFY `TransactionId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
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

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
