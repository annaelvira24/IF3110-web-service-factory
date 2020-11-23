-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 19, 2019 at 05:22 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bank_pro`
--

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `accountNumber` bigint(20) NOT NULL,
  `customerName` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `balance` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`accountNumber`, `customerName`, `balance`) VALUES
(1234567890, 'Engi Cinema', 700000),
(1403991812, 'vincentbudianto', 5000000),
(1568430026, 'Nixon Andhika', 2965000),
(2311569874, 'ChrisBill', 0),
(3160564196, 'Abel Stanley', 1950000),
(3965210656, 'Andrian Cedric', 1970000),
(4126860031, 'Lukas Kurnia', 2465000),
(4985231501, 'T. Antra Oksidian Tafly', 1475000),
(6502994853, 'Willy Santoso', 2955000),
(6541440398, 'Kevin Sendjaja', 1460000),
(7763120038, 'Yoel Susanto', 3930000),
(9748400389, 'Hansen', 2950000),
(9845820521, 'Jan Meyer Saragih', 2920000);

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE `transactions` (
  `transactionID` int(11) NOT NULL,
  `accountNumber` bigint(20) NOT NULL,
  `transactionType` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `amount` bigint(20) DEFAULT NULL,
  `targetAccount` bigint(20) NOT NULL,
  `transactionTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `transactions`
--

INSERT INTO `transactions` (`transactionID`, `accountNumber`, `transactionType`, `amount`, `targetAccount`, `transactionTime`) VALUES
(1, 1403991812, 'debit', 25000, 2694816793012913, '2019-11-07 07:21:46'),
(2, 1234567890, 'kredit', 25000, 1403991812, '2019-11-07 07:21:46'),
(3, 1568430026, 'debit', 35000, 8426319872061435, '2019-11-07 07:22:35'),
(4, 1234567890, 'kredit', 35000, 1568430026, '2019-11-07 07:22:35'),
(5, 3160564196, 'debit', 50000, 1243596188101964, '2019-11-07 07:23:16'),
(6, 1234567890, 'kredit', 50000, 3160564196, '2019-11-07 07:23:16'),
(7, 3965210656, 'debit', 30000, 4826189437023966, '2019-11-07 07:23:49'),
(8, 1234567890, 'kredit', 30000, 3965210656, '2019-11-07 07:23:49'),
(9, 4126860031, 'debit', 35000, 9476423815613086, '2019-11-07 07:24:16'),
(10, 1234567890, 'kredit', 35000, 4126860031, '2019-11-07 07:24:16'),
(11, 4985231501, 'debit', 25000, 8917630243150258, '2019-11-07 07:24:38'),
(12, 1234567890, 'kredit', 25000, 4985231501, '2019-11-07 07:24:38'),
(13, 6502994853, 'debit', 45000, 6991748632095823, '2019-11-07 07:25:13'),
(14, 1234567890, 'kredit', 45000, 6502994853, '2019-11-07 07:25:13'),
(15, 6541440398, 'debit', 40000, 7691234668604943, '2019-11-07 07:25:44'),
(16, 1234567890, 'kredit', 40000, 6541440398, '2019-11-07 07:25:44'),
(17, 7763120038, 'debit', 70000, 3296831694802031, '2019-11-07 07:26:10'),
(18, 1234567890, 'kredit', 70000, 7763120038, '2019-11-07 07:26:10'),
(19, 9748400389, 'debit', 50000, 1683619234934047, '2019-11-07 07:26:36'),
(20, 1234567890, 'kredit', 50000, 9748400389, '2019-11-07 07:26:36'),
(21, 9845820521, 'debit', 80000, 5519842638958202, '2019-11-07 07:27:05'),
(22, 1234567890, 'kredit', 80000, 9845820521, '2019-11-07 07:27:05'),
(23, 1403991812, 'kredit', 25000, 1403991812, '2019-11-07 14:55:32'),
(24, 1403991812, 'kredit', 30000, 1403991812, '2019-11-07 15:23:38'),
(25, 1403991812, 'debit', 30000, 1234567890, '2019-11-07 15:28:12'),
(26, 1234567890, 'kredit', 30000, 1403991812, '2019-11-07 15:28:12'),
(27, 1403991812, 'debit', 70000, 1234567890, '2019-11-07 16:59:39'),
(28, 1234567890, 'kredit', 70000, 1403991812, '2019-11-07 16:59:39'),
(29, 1403991812, 'kredit', 70000, 1403991812, '2019-11-07 17:01:04');

-- --------------------------------------------------------

--
-- Table structure for table `virtual_accounts`
--

CREATE TABLE `virtual_accounts` (
  `accountNumber` bigint(20) NOT NULL,
  `virtualNumber` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `virtual_accounts`
--

INSERT INTO `virtual_accounts` (`accountNumber`, `virtualNumber`) VALUES
(1234567890, 1243596188101964),
(1234567890, 1683619234934047),
(1234567890, 2694816793012913),
(1234567890, 3296831694802031),
(1234567890, 4826189437023966),
(1234567890, 5519842638958202),
(1234567890, 6552458226298802),
(1234567890, 6991748632095823),
(1234567890, 7691234668604943),
(1234567890, 8426319872061435),
(1234567890, 8917630243150258),
(1234567890, 9476423815613086);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`accountNumber`),
  ADD UNIQUE KEY `accountNumber` (`accountNumber`);

--
-- Indexes for table `transactions`
--
ALTER TABLE `transactions`
  ADD PRIMARY KEY (`transactionID`),
  ADD KEY `accountNumber` (`accountNumber`);

--
-- Indexes for table `virtual_accounts`
--
ALTER TABLE `virtual_accounts`
  ADD UNIQUE KEY `virtualNumber` (`virtualNumber`),
  ADD KEY `accountNumber` (`accountNumber`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `transactions`
--
ALTER TABLE `transactions`
  MODIFY `transactionID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `transactions`
--
ALTER TABLE `transactions`
  ADD CONSTRAINT `transactions_ibfk_1` FOREIGN KEY (`accountNumber`) REFERENCES `customers` (`accountNumber`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `virtual_accounts`
--
ALTER TABLE `virtual_accounts`
  ADD CONSTRAINT `virtual_accounts_ibfk_1` FOREIGN KEY (`accountNumber`) REFERENCES `customers` (`accountNumber`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
