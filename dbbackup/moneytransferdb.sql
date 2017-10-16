-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Oct 16, 2017 at 01:28 PM
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
(16, 'Moneytransfer', 'test1', 'test', 'delhi', 'delhi', '110027', 246, 'moneytransfer@gmail.com', '1234567890', '12345', 'money', 'Mr.', '4', 200000, 'it company', 'partnership', '1111', 'test way', 'www.test.com', '11112122', 'tttt', 'test', NULL, NULL, NULL, '2017-10-10', 1, 1, '2017-10-10'),
(17, 'Test Company', 'Delhi', 'd', 'New delhi', 'New delhi', '110033', 344, 'user@gmail.com', '9654523415', '9654523415', 'Ishu', 'Mr.', '20', 120000, 'IT', 'Software', '1254', 'Test', 'http://getbootstrap.com', '25415245125', '2541', 'Phone', '2017-10-18', NULL, NULL, '2017-10-16', 0, 0, NULL),
(18, 'test123', 'abcd', 'test', 'delhi', 'delhi', '110027', 300, 'test123@gmail.com', '1234567890', '12345', 'money', 'Mr.', '4', 200000, 'it company', 'partnership', '1111', 'test way', 'www.test.com', '11112122', 'tttt', 'test', NULL, NULL, NULL, '2017-10-16', 1, 0, NULL);

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
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `customer_Id` int(11) NOT NULL,
  `Company_Id` int(11) NOT NULL,
  `AccountNumber` varchar(50) NOT NULL,
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `Address1` varchar(100) NOT NULL,
  `Address2` varchar(100) DEFAULT NULL,
  `City` varchar(50) NOT NULL,
  `State` varchar(50) NOT NULL,
  `ZipCode` varchar(50) NOT NULL,
  `country_id` int(11) NOT NULL,
  `Phone` varchar(20) NOT NULL,
  `Email` varchar(50) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `DOB` datetime NOT NULL,
  `ProfileImage` varchar(50) NOT NULL,
  `ActivationCode` varchar(100) NOT NULL,
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
(1, 16, '123456789', 'ishu', 'Kumar', 'aaa', 'bbb', 'www', 'fl', '12345', 250, '123456789', 'u@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '2017-10-10 00:00:00', 'fff', '1234567890', 1, 1, 0, '2017-10-05 00:00:00', NULL),
(2, 16, '123456789', 'ff', 'Kumar', 'aaa', 'bbb', 'www', 'fl', '12345', 250, '123456789', 'ffu@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '2017-10-10 00:00:00', 'fff', '1234567890', 1, 1, 1, '2017-10-02 00:00:00', '2017-10-16 12:08:18'),
(3, 16, '123456789', 'cc', 'Kumar', 'aaa', 'bbb', 'www', 'fl', '12345', 250, '123456789', 'cc@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '2017-10-10 00:00:00', 'fff', '1234567890', 1, 1, 0, '2017-10-14 19:06:08', NULL),
(4, 16, '123456789', 'dd', 'Kumar', 'aaa', 'bbb', 'www', 'fl', '12345', 250, '123456789', 'dd@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '2017-10-10 00:00:00', 'fff', '1234567890', 1, 1, 0, '2017-10-14 19:09:40', NULL),
(5, 16, '123456789', 'dd', 'Kumar', 'aaa', 'bbb', 'www', 'fl', '12345', 250, '123456789', 'dd@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '2017-10-10 00:00:00', 'fff', '1234567890', 1, 1, 0, '2017-10-14 19:14:46', NULL),
(6, 16, '123456789', 'hh', 'Kumar', 'aaa', 'bbb', 'www', 'fl', '12345', 250, '123456789', 'hh@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '2017-10-10 00:00:00', 'fff', '1234567890', 1, 1, 0, '2017-10-14 19:17:02', NULL),
(7, 16, '123456789', 'lookas', 'Kumar', 'aaa', 'bbb', 'www', 'fl', '12345', 250, '123456789', 'looks@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '2017-10-10 00:00:00', 'fff', '1234567890', 1, 1, 0, '2017-10-16 13:13:41', NULL),
(8, 16, '123456789', 'zolly', 'mbbs', 'aaa', 'bbb', 'www', 'fl', '12345', 246, '123456789', 'zolly@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '2017-10-10 00:00:00', 'fff', '1234567890', 1, 1, 0, '2017-10-16 11:13:12', NULL),
(9, 16, '123456789', 'mi', 'Kumar', 'aaa', 'bbb', 'www', 'fl', '12345', 250, '123456789', 'mi@gmail.com', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', '2017-10-10 00:00:00', 'fff', '1234567890', 1, 1, 0, '2017-10-16 13:16:07', NULL);

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
(2, 16, 'admin', 'user', 'admin@gmail.com', '1234567890', '40BD001563085FC35165329EA1FF5C5ECBDBBEEF', 246, '', 1, '2017-10-10', 1, '2017-10-10');

--
-- Indexes for dumped tables
--

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
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`customer_Id`),
  ADD KEY `Company_Id` (`Company_Id`),
  ADD KEY `country_id` (`country_id`);

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
-- AUTO_INCREMENT for table `company`
--
ALTER TABLE `company`
  MODIFY `Company_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
--
-- AUTO_INCREMENT for table `country`
--
ALTER TABLE `country`
  MODIFY `country_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=491;
--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `customer_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `company`
--
ALTER TABLE `company`
  ADD CONSTRAINT `company_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `country` (`country_id`);

--
-- Constraints for table `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`Company_Id`) REFERENCES `company` (`Company_Id`),
  ADD CONSTRAINT `customer_ibfk_2` FOREIGN KEY (`country_id`) REFERENCES `country` (`country_id`);

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `users_ibfk_1` FOREIGN KEY (`Company_Id`) REFERENCES `company` (`Company_Id`),
  ADD CONSTRAINT `users_ibfk_2` FOREIGN KEY (`country_id`) REFERENCES `country` (`country_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
