-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 25, 2020 at 08:37 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `caragency`
--

-- --------------------------------------------------------

--
-- Table structure for table `cars`
--

CREATE TABLE `cars` (
  `carName` varchar(100) NOT NULL,
  `modelnumber` int(11) DEFAULT NULL,
  `CARCOLOR` varchar(150) DEFAULT NULL,
  `CARQUANTITY` int(11) DEFAULT NULL,
  `CARPRICE` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cars`
--

INSERT INTO `cars` (`carName`, `modelnumber`, `CARCOLOR`, `CARQUANTITY`, `CARPRICE`) VALUES
('audi', 2021, 'yelllow', 800, 20000012),
('audi a2', 2011, 'yellow,black', 20, 500000),
('audi a3', 2020, 'black,yellow', 1, 200020),
('audi aaa', 2015, 'black', 20, 111),
('BMW320B', 2016, 'BLACK,RED,WHITE', 50, 250000),
('BMWX1', 2017, 'BLACK,GREY,RED , white', 30, 300000),
('BMWX2', 2018, 'BLACK,GREY,RED,WHITE', 40, 500000),
('BMWX3', 2019, 'BLACK,YELLOW,RED', 20, 600000),
('BMWX5', 2020, 'BLACK,GREY,RED , white', 100, 1000000),
('bnh', 2020, 'black', 20, 1000),
('HYUNDAI Accent', 2016, 'BLACK,GREY,RED', 50, 150000),
('HYUNDAI Accent i', 2017, 'BLACK,white,RED', 40, 200000),
('HYUNDAI Elentra', 2018, 'BLACK,GREY,RED,pink', 80, 230000),
('HYUNDAI Elentra v2', 2019, 'BLACK,GREY,RED', 20, 270000),
('HYUNDAI Elentra v3 ', 2020, 'BLACK,GREY,RED ,yellow', 100, 320000),
('kia carrens ', 2017, 'BLACK,white,RED', 20, 190000),
('kia Rio', 2016, 'BLACK,GREY,RED', 10, 150000),
('kia Rio v2', 2018, 'BLACK,GREY,RED', 50, 250000),
('kia Rio v3', 2019, 'BLACK,GREY,white', 10, 290000),
('kia Rio v4', 2020, 'BLACK,GREY,RED', 60, 400000),
('mercedes c180', 2016, 'BLACK,GREY,RED', 25, 350000),
('Mercedes C180 class', 2021, 'black,yellow', 150, 2000000),
('mercedess c200', 2017, 'BLACK,GREY,RED , white', 10, 680000),
('mercedesss E180', 2018, 'BLACK,GREY,RED', 30, 800000),
('mercedessss E200', 2019, 'BLACK,GREY,white', 50, 120000000),
('mercedesssss S200', 2020, 'BLACK,GREY,RED , white', 10, 2000000),
('mohamed', 2020, 'white', 2, 123);

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `disscountcode` varchar(100) NOT NULL,
  `firstname` varchar(50) DEFAULT NULL,
  `lastname` varchar(50) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `phonemumber` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`disscountcode`, `firstname`, `lastname`, `address`, `phonemumber`) VALUES
('12b2cv', 'mohamed', 'alaa', '20 شارع منية سيرج-شبرا مصر', 1145595244),
('12GB', 'Ahmed', 'hatem', '20 شارع النزهة-مصر الجديدة', 1555892980),
('215nm', 'marwan', 'alaa', '20 shoubra', 12511252),
('23', 'khaled', 'amr', '20 mnut serg', 11252455),
('m,m', 'hatem', 'nn', 'mm,', 21521);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(40) NOT NULL,
  `PASS` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`username`, `PASS`) VALUES
('admin', 'admin'),
('car', 'car'),
('mohamed', '1234');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cars`
--
ALTER TABLE `cars`
  ADD PRIMARY KEY (`carName`);

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`disscountcode`),
  ADD UNIQUE KEY `firstname` (`firstname`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
