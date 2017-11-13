-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 13, 2017 at 02:55 PM
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
(1, 1, 'TEST', 'ww.testcase.com', '6cUR4e9b', '5p583ZeR2Y84Mf6s', 1, 0, '2017-10-27', NULL),
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
  `DOB` date NOT NULL,
  `IsActive` tinyint(1) NOT NULL DEFAULT '1',
  `IsDeleted` tinyint(1) NOT NULL DEFAULT '0',
  `CreatedDate` date NOT NULL,
  `DeletedDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `beneficiary`
--

INSERT INTO `beneficiary` (`BeneficiaryId`, `CompanyId`, `BeneficiaryTypeId`, `CustomerId`, `FirstName`, `LastName`, `Phone`, `Email`, `Address1`, `Address2`, `City`, `State`, `ZipCode`, `CountryId`, `DOB`, `IsActive`, `IsDeleted`, `CreatedDate`, `DeletedDate`) VALUES
(1, 17, 1, 8, 'Ram', 'Rahim', '1234567890', 'ram@gmail.com', 'delhi', 'ncr', 'delhi', 'delhi ncr', '110027', 350, '2017-01-02', 1, 0, '2017-10-30', NULL),
(2, 17, 1, 8, 'Suresh', 'Mohil', '8010276833', 'suresh@gmail.com', 'nahan', 'jamli', 'Kangra', 'HP', '110027', 350, '2017-01-01', 0, 0, '2017-10-31', NULL),
(3, 17, 1, 8, 'abc', 'pindu', '7894561230', 'saa@gmail.com', 'galino 10', 'chd', 'ch', 'UT', '110014', 350, '2017-01-01', 1, 1, '2017-10-31', '2017-10-31'),
(4, 17, 1, 8, 'Baba', 'Ram Dev', '1234567890', 'ramdev@gmail.com', 'delhi', 'ncr', 'delhi', 'delhi ncr', '110027', 350, '2017-01-01', 1, 0, '2017-10-31', NULL),
(5, 17, 1, 8, 'Test', 'Kumar', '1234567890', 'test@gmail.com', 'delhi', 'ncr', 'delhi', 'delhi ncr', '110027', 350, '2017-01-01', 1, 0, '2017-10-31', NULL),
(6, 17, 1, 8, 'Test', 'Beneficiary', '9685458965', 'beneficiary@gmail.com', 'address', 'Address2', 'City', 'State', '96584', 344, '2017-10-25', 1, 1, '2017-10-31', '2017-10-31'),
(7, 17, 1, 15, 'John', 'Adam', '8374726232', 'john@hsj.com', 'skdfsd', 'ddd', 'San', 'California', '23232', 475, '2017-11-15', 0, 0, '2017-11-01', NULL),
(8, 17, 1, 8, 'Girish', 'TEst', '9685458965', 'Girish@gmail.com', 'Delhi', 'test', 'New delhi', 'delhi', '110033', 344, '2017-11-14', 1, 0, '2017-11-02', NULL),
(9, 17, 1, 8, 'Ishu', 'test', '7579052252', 'ishutest@gamil.com', 'test', 'test', 'city', 'State', '110033', 344, '2017-11-21', 1, 0, '2017-11-02', NULL),
(10, 17, 1, 8, 'Javed', 'Kumar', '1234567890', 'javed@gmail.com', 'Patodi', 'Gurgayon', 'Gurugram', 'HR', '110027', 450, '2017-01-01', 1, 0, '2017-11-03', NULL);

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
(1, 'Individual');

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
(0, 'Moneytransfer', 'test1', 'test', 'delhi', 'delhi', '110027', 246, 'moneytransfer@gmail.com', '1234567890', '12345', 'money', 'Mr.', '4', 200000, 'it company', 'partnership', '1111', 'test way', 'www.test.com', '11112122', 'tttt', 'test', NULL, NULL, NULL, '2017-10-10', 1, 1, '2017-10-10'),
(17, 'moneyishucase', 'noida', 'test', 'delhi', 'delhi', '110027', 250, 'moneytestcase@gmail.com', '1234567890', '12345', 'moneytestcase', 'Mr.', '40', 102356, 'Sale company', 'partnership', '1111', 'test way', 'www.test.com', '11112122', 'tttt', 'test', NULL, NULL, NULL, '2017-10-25', 1, 0, NULL),
(20, 'Moneytransfer', 'abcd', 'test', 'delhi', 'delhi', '110027', 246, 'testsuper@gmail.com', '1234567890', '12345', 'money', 'Mr.', '4', 200000, 'it company', 'partnership', '1111', 'test way', 'www.test.com', '11112122', 'tttt', 'test', NULL, NULL, NULL, '2017-10-26', 1, 0, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `country`
--

CREATE TABLE `country` (
  `country_id` int(11) NOT NULL,
  `country_code` varchar(2) NOT NULL,
  `country_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `country`
--

INSERT INTO `country` (`country_id`, `country_code`, `country_name`) VALUES
(246, 'AF', 'Afghanistan'),
(247, 'AL', 'Albania'),
(248, 'DZ', 'Algeria'),
(249, 'DS', 'American Samoa'),
(250, 'AD', 'Andorra'),
(251, 'AO', 'Angola'),
(252, 'AI', 'Anguilla'),
(253, 'AQ', 'Antarctica'),
(254, 'AG', 'Antigua and Barbuda'),
(255, 'AR', 'Argentina'),
(256, 'AM', 'Armenia'),
(257, 'AW', 'Aruba'),
(258, 'AU', 'Australia'),
(259, 'AT', 'Austria'),
(260, 'AZ', 'Azerbaijan'),
(261, 'BS', 'Bahamas'),
(262, 'BH', 'Bahrain'),
(263, 'BD', 'Bangladesh'),
(264, 'BB', 'Barbados'),
(265, 'BY', 'Belarus'),
(266, 'BE', 'Belgium'),
(267, 'BZ', 'Belize'),
(268, 'BJ', 'Benin'),
(269, 'BM', 'Bermuda'),
(270, 'BT', 'Bhutan'),
(271, 'BO', 'Bolivia'),
(272, 'BA', 'Bosnia and Herzegovina'),
(273, 'BW', 'Botswana'),
(274, 'BV', 'Bouvet Island'),
(275, 'BR', 'Brazil'),
(276, 'IO', 'British Indian Ocean Territory'),
(277, 'BN', 'Brunei Darussalam'),
(278, 'BG', 'Bulgaria'),
(279, 'BF', 'Burkina Faso'),
(280, 'BI', 'Burundi'),
(281, 'KH', 'Cambodia'),
(282, 'CM', 'Cameroon'),
(283, 'CA', 'Canada'),
(284, 'CV', 'Cape Verde'),
(285, 'KY', 'Cayman Islands'),
(286, 'CF', 'Central African Republic'),
(287, 'TD', 'Chad'),
(288, 'CL', 'Chile'),
(289, 'CN', 'China'),
(290, 'CX', 'Christmas Island'),
(291, 'CC', 'Cocos (Keeling) Islands'),
(292, 'CO', 'Colombia'),
(293, 'KM', 'Comoros'),
(294, 'CG', 'Congo'),
(295, 'CK', 'Cook Islands'),
(296, 'CR', 'Costa Rica'),
(297, 'HR', 'Croatia (Hrvatska)'),
(298, 'CU', 'Cuba'),
(299, 'CY', 'Cyprus'),
(300, 'CZ', 'Czech Republic'),
(301, 'DK', 'Denmark'),
(302, 'DJ', 'Djibouti'),
(303, 'DM', 'Dominica'),
(304, 'DO', 'Dominican Republic'),
(305, 'TP', 'East Timor'),
(306, 'EC', 'Ecuador'),
(307, 'EG', 'Egypt'),
(308, 'SV', 'El Salvador'),
(309, 'GQ', 'Equatorial Guinea'),
(310, 'ER', 'Eritrea'),
(311, 'EE', 'Estonia'),
(312, 'ET', 'Ethiopia'),
(313, 'FK', 'Falkland Islands (Malvinas)'),
(314, 'FO', 'Faroe Islands'),
(315, 'FJ', 'Fiji'),
(316, 'FI', 'Finland'),
(317, 'FR', 'France'),
(318, 'FX', 'France, Metropolitan'),
(319, 'GF', 'French Guiana'),
(320, 'PF', 'French Polynesia'),
(321, 'TF', 'French Southern Territories'),
(322, 'GA', 'Gabon'),
(323, 'GM', 'Gambia'),
(324, 'GE', 'Georgia'),
(325, 'DE', 'Germany'),
(326, 'GH', 'Ghana'),
(327, 'GI', 'Gibraltar'),
(328, 'GK', 'Guernsey'),
(329, 'GR', 'Greece'),
(330, 'GL', 'Greenland'),
(331, 'GD', 'Grenada'),
(332, 'GP', 'Guadeloupe'),
(333, 'GU', 'Guam'),
(334, 'GT', 'Guatemala'),
(335, 'GN', 'Guinea'),
(336, 'GW', 'Guinea-Bissau'),
(337, 'GY', 'Guyana'),
(338, 'HT', 'Haiti'),
(339, 'HM', 'Heard and Mc Donald Islands'),
(340, 'HN', 'Honduras'),
(341, 'HK', 'Hong Kong'),
(342, 'HU', 'Hungary'),
(343, 'IS', 'Iceland'),
(344, 'IN', 'India'),
(345, 'IM', 'Isle of Man'),
(346, 'ID', 'Indonesia'),
(347, 'IR', 'Iran (Islamic Republic of)'),
(348, 'IQ', 'Iraq'),
(349, 'IE', 'Ireland'),
(350, 'IL', 'Israel'),
(351, 'IT', 'Italy'),
(352, 'CI', 'Ivory Coast'),
(353, 'JE', 'Jersey'),
(354, 'JM', 'Jamaica'),
(355, 'JP', 'Japan'),
(356, 'JO', 'Jordan'),
(357, 'KZ', 'Kazakhstan'),
(358, 'KE', 'Kenya'),
(359, 'KI', 'Kiribati'),
(360, 'KP', 'Korea, Democratic People\'s Republic of'),
(361, 'KR', 'Korea, Republic of'),
(362, 'XK', 'Kosovo'),
(363, 'KW', 'Kuwait'),
(364, 'KG', 'Kyrgyzstan'),
(365, 'LA', 'Lao People\'s Democratic Republic'),
(366, 'LV', 'Latvia'),
(367, 'LB', 'Lebanon'),
(368, 'LS', 'Lesotho'),
(369, 'LR', 'Liberia'),
(370, 'LY', 'Libyan Arab Jamahiriya'),
(371, 'LI', 'Liechtenstein'),
(372, 'LT', 'Lithuania'),
(373, 'LU', 'Luxembourg'),
(374, 'MO', 'Macau'),
(375, 'MK', 'Macedonia'),
(376, 'MG', 'Madagascar'),
(377, 'MW', 'Malawi'),
(378, 'MY', 'Malaysia'),
(379, 'MV', 'Maldives'),
(380, 'ML', 'Mali'),
(381, 'MT', 'Malta'),
(382, 'MH', 'Marshall Islands'),
(383, 'MQ', 'Martinique'),
(384, 'MR', 'Mauritania'),
(385, 'MU', 'Mauritius'),
(386, 'TY', 'Mayotte'),
(387, 'MX', 'Mexico'),
(388, 'FM', 'Micronesia, Federated States of'),
(389, 'MD', 'Moldova, Republic of'),
(390, 'MC', 'Monaco'),
(391, 'MN', 'Mongolia'),
(392, 'ME', 'Montenegro'),
(393, 'MS', 'Montserrat'),
(394, 'MA', 'Morocco'),
(395, 'MZ', 'Mozambique'),
(396, 'MM', 'Myanmar'),
(397, 'NA', 'Namibia'),
(398, 'NR', 'Nauru'),
(399, 'NP', 'Nepal'),
(400, 'NL', 'Netherlands'),
(401, 'AN', 'Netherlands Antilles'),
(402, 'NC', 'New Caledonia'),
(403, 'NZ', 'New Zealand'),
(404, 'NI', 'Nicaragua'),
(405, 'NE', 'Niger'),
(406, 'NG', 'Nigeria'),
(407, 'NU', 'Niue'),
(408, 'NF', 'Norfolk Island'),
(409, 'MP', 'Northern Mariana Islands'),
(410, 'NO', 'Norway'),
(411, 'OM', 'Oman'),
(412, 'PK', 'Pakistan'),
(413, 'PW', 'Palau'),
(414, 'PS', 'Palestine'),
(415, 'PA', 'Panama'),
(416, 'PG', 'Papua New Guinea'),
(417, 'PY', 'Paraguay'),
(418, 'PE', 'Peru'),
(419, 'PH', 'Philippines'),
(420, 'PN', 'Pitcairn'),
(421, 'PL', 'Poland'),
(422, 'PT', 'Portugal'),
(423, 'PR', 'Puerto Rico'),
(424, 'QA', 'Qatar'),
(425, 'RE', 'Reunion'),
(426, 'RO', 'Romania'),
(427, 'RU', 'Russian Federation'),
(428, 'RW', 'Rwanda'),
(429, 'KN', 'Saint Kitts and Nevis'),
(430, 'LC', 'Saint Lucia'),
(431, 'VC', 'Saint Vincent and the Grenadines'),
(432, 'WS', 'Samoa'),
(433, 'SM', 'San Marino'),
(434, 'ST', 'Sao Tome and Principe'),
(435, 'SA', 'Saudi Arabia'),
(436, 'SN', 'Senegal'),
(437, 'RS', 'Serbia'),
(438, 'SC', 'Seychelles'),
(439, 'SL', 'Sierra Leone'),
(440, 'SG', 'Singapore'),
(441, 'SK', 'Slovakia'),
(442, 'SI', 'Slovenia'),
(443, 'SB', 'Solomon Islands'),
(444, 'SO', 'Somalia'),
(445, 'ZA', 'South Africa'),
(446, 'GS', 'South Georgia South Sandwich Islands'),
(447, 'ES', 'Spain'),
(448, 'LK', 'Sri Lanka'),
(449, 'SH', 'St. Helena'),
(450, 'PM', 'St. Pierre and Miquelon'),
(451, 'SD', 'Sudan'),
(452, 'SR', 'Suriname'),
(453, 'SJ', 'Svalbard and Jan Mayen Islands'),
(454, 'SZ', 'Swaziland'),
(455, 'SE', 'Sweden'),
(456, 'CH', 'Switzerland'),
(457, 'SY', 'Syrian Arab Republic'),
(458, 'TW', 'Taiwan'),
(459, 'TJ', 'Tajikistan'),
(460, 'TZ', 'Tanzania, United Republic of'),
(461, 'TH', 'Thailand'),
(462, 'TG', 'Togo'),
(463, 'TK', 'Tokelau'),
(464, 'TO', 'Tonga'),
(465, 'TT', 'Trinidad and Tobago'),
(466, 'TN', 'Tunisia'),
(467, 'TR', 'Turkey'),
(468, 'TM', 'Turkmenistan'),
(469, 'TC', 'Turks and Caicos Islands'),
(470, 'TV', 'Tuvalu'),
(471, 'UG', 'Uganda'),
(472, 'UA', 'Ukraine'),
(473, 'AE', 'United Arab Emirates'),
(474, 'GB', 'United Kingdom'),
(475, 'US', 'United States'),
(476, 'UM', 'United States minor outlying islands'),
(477, 'UY', 'Uruguay'),
(478, 'UZ', 'Uzbekistan'),
(479, 'VU', 'Vanuatu'),
(480, 'VA', 'Vatican City State'),
(481, 'VE', 'Venezuela'),
(482, 'VN', 'Vietnam'),
(483, 'VG', 'Virgin Islands (British)'),
(484, 'VI', 'Virgin Islands (U.S.)'),
(485, 'WF', 'Wallis and Futuna Islands'),
(486, 'EH', 'Western Sahara'),
(487, 'YE', 'Yemen'),
(488, 'ZR', 'Zaire'),
(489, 'ZM', 'Zambia'),
(490, 'ZW', 'Zimbabwe');

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
(1, 'USD', 475, 'Dollar'),
(2, 'INR', 344, 'Rupees');

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
(1, 17, '123456789', 'ishu', 'Kumar', 'aaa', 'bbb', 'www', 'fl', '12345', 250, '123456789', 'u@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '2017-10-10 ', 'fff', '1234567890', 1, 1, 0, '2017-10-05 00:00:00', NULL),
(2, 17, '123456789', 'ff', 'Kumar', 'aaa', 'bbb', 'www', 'fl', '12345', 250, '123456789', 'ffu@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '2017-10-10 ', 'fff', '1234567890', 1, 1, 0, '2017-10-02 00:00:00', NULL),
(3, 17, '123456789', 'cc', 'Kumar', 'aaa', 'bbb', 'www', 'fl', '12345', 250, '123456789', 'cc@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '2017-10-10 ', 'fff', '1234567890', 1, 1, 0, '2017-10-14 19:06:08', NULL),
(4, 17, '123456789', 'dd', 'Kumar', 'aaa', 'bbb', 'www', 'fl', '12345', 250, '123456789', 'dd@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '2017-10-10 ', 'fff', '1234567890', 1, 1, 0, '2017-10-14 19:09:40', NULL),
(5, 17, '123456789', 'dd', 'Kumar', 'aaa', 'bbb', 'www', 'fl', '12345', 250, '123456789', 'dd@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '2017-10-10 ', 'fff', '1234567890', 1, 1, 0, '2017-10-14 19:14:46', NULL),
(6, 17, '123456789', 'hh', 'Kumar', 'aaa', 'bbb', 'www', 'fl', '12345', 250, '123456789', 'hh@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '2017-10-10 ', 'fff', '1234567890', 1, 1, 1, '2017-10-14 19:17:02', '2017-10-19 00:00:00'),
(8, 17, '123456789', 'zolly', 'mbbs', 'aaa', 'bbb', 'www', 'fl', '12345', 246, '123456789', 'zolly@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '2017-10-10 ', 'fff', '1234567890', 1, 1, 0, '2017-10-16 11:13:12', NULL),
(9, 17, '123456789', 'Oppo', 'chinese', 'china', 'test', 'china', 'CH', '12345', 258, '123456789', 'oppo@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '2017-10-10 ', 'fff', '1234567890', 1, 1, 0, '2017-10-25 11:42:21', NULL),
(10, 17, '35434', 'test', 'test', 'test', 'test', 'test', 'trst', 'tres', 344, '2345324523', 'testre@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '1990-10-10 ', 'test', '34534', 1, 1, 0, '2017-10-27 11:25:23', NULL),
(11, 17, '25432', 'Girish', 'test', 'Delhi', 'test', 'City', 'State', '110033', 344, '968545868', 'Girishtest@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '1990-10-10 ', 'test', '32432', 1, 1, 0, '2017-10-27 11:28:05', NULL),
(12, 17, '985458', 'Ishu Test', 'test', 'address', 'Address2', 'City', 'State', '854854', 344, '8545859654', 'ishutest@gamil.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '1990-10-10 ', 'test', '95848', 1, 1, 0, '2017-10-30 06:27:55', NULL),
(13, 17, '', 'Customer', 'test', '', '', '', '', '', 258, '123456789', 'customer@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '', '', '', 0, 0, 0, '2017-10-30 09:27:09', NULL),
(14, 17, NULL, 'KARAN', 'LUTHRA', '', '', '', '', '', 344, '9999999999', 'KARAN@TEST.COM', 'FF4C7367E4DA28145902749E950F81039557C4BE', '', '', '', 0, 0, 0, '2017-10-31 13:45:51', NULL),
(15, 17, NULL, 'Rajeev', 'Verma', '', '', '', '', '', 344, '9728372328', 'rajeevdesizn@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '', '', '', 0, 0, 0, '2017-11-01 16:52:51', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `paymentfess`
--

CREATE TABLE `paymentfess` (
  `PaymentFessId` int(11) NOT NULL,
  `PaymentMethodId` int(11) NOT NULL,
  `country_id` int(11) NOT NULL,
  `StartingAmount` decimal(10,0) NOT NULL,
  `EndAmount` decimal(10,0) NOT NULL,
  `FeesType` int(11) NOT NULL,
  `Fees` decimal(10,0) NOT NULL,
  `CreatedDate` date NOT NULL,
  `IsDeleted` tinyint(1) NOT NULL DEFAULT '0',
  `DeletedDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `paymentfess`
--

INSERT INTO `paymentfess` (`PaymentFessId`, `PaymentMethodId`, `country_id`, `StartingAmount`, `EndAmount`, `FeesType`, `Fees`, `CreatedDate`, `IsDeleted`, `DeletedDate`) VALUES
(1, 1, 475, '1000', '2500', 1, '200', '2017-11-13', 0, NULL),
(2, 10, 475, '1000', '2500', 1, '200', '2017-11-13', 0, NULL),
(3, 1, 475, '1000000', '2500', 2, '200', '2017-11-13', 0, NULL);

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
(2, 1, 0, 'payU', 'welcome to payu', 1, 0, '2017-10-23', NULL),
(3, 1, 0, 'Custom test', 'welcome to custom method test', 1, 0, '2017-10-27', NULL),
(4, 1, 0, 'Payment', 'Test Description', 1, 0, '2017-10-26', NULL),
(5, 1, 0, 'Title', 'Descripton', 1, 0, '2017-10-27', NULL),
(6, 1, 0, 'Test', 'Testing', 1, 0, '2017-10-26', NULL),
(7, 2, 0, 'Test', 'Testing', 1, 0, '2017-10-26', NULL),
(8, 2, 0, 'test title', 'testing description', 1, 0, '2017-10-26', NULL),
(9, 2, 20, 'Testing', 'Test', 1, 0, '2017-10-26', NULL),
(10, 1, 0, 'testing', 'testing', 1, 0, '2017-10-28', NULL);

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
(25, 17, 8, 'pay to my grand pa for personal use', '5500', '0', '0', '0', '2017-11-02 05:49:30', 'Success', '1', '40008079924', 1, '5000', 2, 1, 1, 344, 475, 0, 'peronal', '0', '0', '2017-11-02 05:49:30'),
(29, 17, 8, 'test transcation', '120', '0', '0', '0', '2017-11-02 14:37:07', 'Success', '1', '40008092240', 1, '7752', 2, 9, 1, 344, 475, 0, 'for test case by developer', '65', 'test', '2017-11-02 14:37:07'),
(30, 17, 8, 'test', '1321', '0', '0', '0', '2017-11-02 15:15:06', 'Success', '1', '40008092885', 1, '85337', 2, 2, 1, 344, 475, 0, 'test', '65', 'test', '2017-11-02 15:15:06');

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
(2, 0, 'admin', 'user', 'admin@gmail.com', '1234567890', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', 246, '', 1, '2017-10-10', 1, '2017-10-10'),
(3, 17, 'test@gmail.com', 'kumar', 'test@gmail.com', '9638527410', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', 246, '', 1, '2017-10-25', 0, NULL);

--
-- Indexes for dumped tables
--

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
-- Indexes for table `paymentfess`
--
ALTER TABLE `paymentfess`
  ADD PRIMARY KEY (`PaymentFessId`),
  ADD KEY `PaymentMethodId` (`PaymentMethodId`),
  ADD KEY `country_id` (`country_id`);

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
-- AUTO_INCREMENT for table `authorizepaymentsettings`
--
ALTER TABLE `authorizepaymentsettings`
  MODIFY `AuthorizePaymentSettingsId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `beneficiary`
--
ALTER TABLE `beneficiary`
  MODIFY `BeneficiaryId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `beneficiarytype`
--
ALTER TABLE `beneficiarytype`
  MODIFY `BeneficiaryTypeId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `company`
--
ALTER TABLE `company`
  MODIFY `Company_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT for table `country`
--
ALTER TABLE `country`
  MODIFY `country_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=491;
--
-- AUTO_INCREMENT for table `currency`
--
ALTER TABLE `currency`
  MODIFY `CurrencyId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `customer_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `paymentfess`
--
ALTER TABLE `paymentfess`
  MODIFY `PaymentFessId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `paymentmethod`
--
ALTER TABLE `paymentmethod`
  MODIFY `PaymentMethodId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT for table `paymenttype`
--
ALTER TABLE `paymenttype`
  MODIFY `PaymentTypeId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `transactiondetails`
--
ALTER TABLE `transactiondetails`
  MODIFY `TransactionId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
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
-- Constraints for table `company`
--
ALTER TABLE `company`
  ADD CONSTRAINT `company_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `country` (`country_id`);

--
-- Constraints for table `currency`
--
ALTER TABLE `currency`
  ADD CONSTRAINT `currency_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `country` (`country_id`);

--
-- Constraints for table `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`Company_Id`) REFERENCES `company` (`Company_Id`),
  ADD CONSTRAINT `customer_ibfk_2` FOREIGN KEY (`country_id`) REFERENCES `country` (`country_id`);

--
-- Constraints for table `paymentfess`
--
ALTER TABLE `paymentfess`
  ADD CONSTRAINT `paymentfess_ibfk_1` FOREIGN KEY (`PaymentMethodId`) REFERENCES `paymentmethod` (`PaymentMethodId`),
  ADD CONSTRAINT `paymentfess_ibfk_2` FOREIGN KEY (`country_id`) REFERENCES `country` (`country_id`);

--
-- Constraints for table `paymentmethod`
--
ALTER TABLE `paymentmethod`
  ADD CONSTRAINT `paymentmethod_ibfk_1` FOREIGN KEY (`PaymentTypeId`) REFERENCES `paymenttype` (`PaymentTypeId`);

--
-- Constraints for table `transactiondetails`
--
ALTER TABLE `transactiondetails`
  ADD CONSTRAINT `transactiondetails_ibfk_1` FOREIGN KEY (`CompanyId`) REFERENCES `company` (`Company_Id`),
  ADD CONSTRAINT `transactiondetails_ibfk_2` FOREIGN KEY (`CustomerId`) REFERENCES `customer` (`customer_Id`),
  ADD CONSTRAINT `transactiondetails_ibfk_3` FOREIGN KEY (`SendingCurrencyId`) REFERENCES `currency` (`CurrencyId`),
  ADD CONSTRAINT `transactiondetails_ibfk_4` FOREIGN KEY (`ReceivingCurrencytId`) REFERENCES `currency` (`CurrencyId`),
  ADD CONSTRAINT `transactiondetails_ibfk_5` FOREIGN KEY (`BeneficiaryId`) REFERENCES `beneficiary` (`BeneficiaryId`),
  ADD CONSTRAINT `transactiondetails_ibfk_6` FOREIGN KEY (`PaymentMethodId`) REFERENCES `paymentmethod` (`PaymentMethodId`),
  ADD CONSTRAINT `transactiondetails_ibfk_7` FOREIGN KEY (`DestinationCountryId`) REFERENCES `country` (`country_id`),
  ADD CONSTRAINT `transactiondetails_ibfk_8` FOREIGN KEY (`SourceCountryId`) REFERENCES `country` (`country_id`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`Company_Id`) REFERENCES `company` (`Company_Id`),
  ADD CONSTRAINT `users_ibfk_2` FOREIGN KEY (`country_id`) REFERENCES `country` (`country_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
