-- phpMyAdmin SQL Dump
-- version 4.5.0.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 31, 2017 at 11:54 PM
-- Server version: 10.0.17-MariaDB
-- PHP Version: 5.6.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `flightbookingsystemv2`
--
CREATE DATABASE IF NOT EXISTS `flightbookingsystemv2` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `flightbookingsystemv2`;

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
CREATE TABLE IF NOT EXISTS `booking` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `NoOfAdults` int(11) NOT NULL,
  `NoOfChildren` int(11) NOT NULL,
  `NoOfInfants` int(11) NOT NULL,
  `Customer_Id` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_Booking_Customer1_idx` (`Customer_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`Id`, `NoOfAdults`, `NoOfChildren`, `NoOfInfants`, `Customer_Id`) VALUES
(1, 2, 0, 0, 1),
(2, 12, 0, 0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(10) NOT NULL,
  `FirstName` varchar(45) NOT NULL,
  `Surname` varchar(45) NOT NULL,
  `MobileNumber` varchar(12) NOT NULL,
  `HomePhoneNumber` varchar(12) NOT NULL,
  `EmailAddress` varchar(45) NOT NULL,
  `LoginName` varchar(45) NOT NULL,
  `LoginPassword` varchar(45) NOT NULL,
  `CardType` varchar(45) NOT NULL,
  `CardNumber` varchar(16) NOT NULL,
  `CardExpiry` date NOT NULL,
  `AddressLine1` varchar(45) NOT NULL,
  `AddressLine2` varchar(45) NOT NULL,
  `PostCode` varchar(12) NOT NULL,
  `TownCity` varchar(45) NOT NULL,
  `CountyState` varchar(45) NOT NULL,
  `Country` varchar(45) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Id`, `Title`, `FirstName`, `Surname`, `MobileNumber`, `HomePhoneNumber`, `EmailAddress`, `LoginName`, `LoginPassword`, `CardType`, `CardNumber`, `CardExpiry`, `AddressLine1`, `AddressLine2`, `PostCode`, `TownCity`, `CountyState`, `Country`) VALUES
(1, 'mr', 'james', 'chalmers', '07552605450', '01343547869', 'james.chalmers184@gmail.com', 'jc184', 'password', 'VISA', '4111222233334444', '2019-09-09', '37 Forteath Avenue', 'west end', 'IV30 1TF', 'Elgin', 'Morayshire', 'UK');

-- --------------------------------------------------------

--
-- Table structure for table `flight`
--

DROP TABLE IF EXISTS `flight`;
CREATE TABLE IF NOT EXISTS `flight` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `DepartureDateTime` datetime NOT NULL,
  `ArrivalDateTime` datetime NOT NULL,
  `Route_Id` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_Flight_Route1_idx` (`Route_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `flight`
--

INSERT INTO `flight` (`Id`, `DepartureDateTime`, `ArrivalDateTime`, `Route_Id`) VALUES
(1, '2017-12-12 12:00:00', '2018-12-12 12:45:00', 1),
(2, '2017-12-13 12:00:00', '2017-12-13 12:45:00', 1),
(3, '2017-12-14 12:00:00', '2017-12-14 12:45:00', 1);

-- --------------------------------------------------------

--
-- Table structure for table `flightbooking`
--

DROP TABLE IF EXISTS `flightbooking`;
CREATE TABLE IF NOT EXISTS `flightbooking` (
  `Flight_Id` int(11) NOT NULL,
  `Booking_Id` int(11) NOT NULL,
  PRIMARY KEY (`Flight_Id`,`Booking_Id`),
  KEY `fk_Flight_has_Booking_Booking1_idx` (`Booking_Id`),
  KEY `fk_Flight_has_Booking_Flight1_idx` (`Flight_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `passenger`
--

DROP TABLE IF EXISTS `passenger`;
CREATE TABLE IF NOT EXISTS `passenger` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `PassengerName` varchar(45) NOT NULL,
  `Booking_Id` int(11) NOT NULL,
  `BaggageItemId` int(11) NOT NULL,
  `BaggageItemWeightKg` int(11) NOT NULL,
  `Seat_SeatNo` int(11) NOT NULL,
  `Seat_Flight_Id` int(11) NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_Passenger_Booking1_idx` (`Booking_Id`),
  KEY `fk_Passenger_Seat1_idx` (`Seat_SeatNo`,`Seat_Flight_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `route`
--

DROP TABLE IF EXISTS `route`;
CREATE TABLE IF NOT EXISTS `route` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `RouteName` varchar(45) NOT NULL,
  `AirportFrom` char(3) NOT NULL,
  `AirportTo` char(3) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `route`
--

INSERT INTO `route` (`Id`, `RouteName`, `AirportFrom`, `AirportTo`) VALUES
(1, 'Aberdeen to Kirkwall', 'ABD', 'KIR');

-- --------------------------------------------------------

--
-- Table structure for table `seat`
--

DROP TABLE IF EXISTS `seat`;
CREATE TABLE IF NOT EXISTS `seat` (
  `SeatNo` int(11) NOT NULL,
  `Booking_Id` int(11) NOT NULL,
  `Flight_Id` int(11) NOT NULL,
  `SeatPrice` decimal(4,2) NOT NULL,
  PRIMARY KEY (`SeatNo`,`Flight_Id`),
  KEY `fk_Seat_Booking1_idx` (`Booking_Id`),
  KEY `fk_Seat_Flight1_idx` (`Flight_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `seat`
--

INSERT INTO `seat` (`SeatNo`, `Booking_Id`, `Flight_Id`, `SeatPrice`) VALUES
(0, 1, 1, '75.00'),
(0, 2, 2, '75.00'),
(0, 2, 3, '75.00'),
(1, 1, 1, '75.00'),
(1, 2, 2, '75.00'),
(1, 2, 3, '75.00'),
(2, 1, 1, '75.00'),
(2, 1, 2, '75.00'),
(2, 2, 3, '75.00'),
(3, 1, 1, '75.00'),
(3, 2, 2, '75.00'),
(5, 1, 1, '75.00'),
(5, 1, 2, '75.00'),
(6, 1, 1, '75.00'),
(6, 2, 3, '75.00'),
(7, 1, 1, '75.00'),
(8, 1, 1, '75.00'),
(8, 1, 2, '75.00'),
(9, 2, 2, '75.00'),
(10, 1, 1, '75.00'),
(11, 1, 1, '75.00'),
(11, 2, 2, '75.00'),
(11, 2, 3, '75.00'),
(12, 2, 3, '75.00'),
(16, 1, 2, '75.00'),
(16, 2, 3, '75.00'),
(17, 1, 2, '75.00'),
(23, 1, 2, '75.00');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `fk_Booking_Customer1` FOREIGN KEY (`Customer_Id`) REFERENCES `customer` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `flight`
--
ALTER TABLE `flight`
  ADD CONSTRAINT `fk_Flight_Route1` FOREIGN KEY (`Route_Id`) REFERENCES `route` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `flightbooking`
--
ALTER TABLE `flightbooking`
  ADD CONSTRAINT `fk_Flight_has_Booking_Booking1` FOREIGN KEY (`Booking_Id`) REFERENCES `booking` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Flight_has_Booking_Flight1` FOREIGN KEY (`Flight_Id`) REFERENCES `flight` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `passenger`
--
ALTER TABLE `passenger`
  ADD CONSTRAINT `fk_Passenger_Booking1` FOREIGN KEY (`Booking_Id`) REFERENCES `booking` (`Id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Passenger_Seat1` FOREIGN KEY (`Seat_SeatNo`,`Seat_Flight_Id`) REFERENCES `seat` (`SeatNo`, `Flight_Id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `seat`
--
ALTER TABLE `seat`
  ADD CONSTRAINT `fk_Seat_Booking1` FOREIGN KEY (`Booking_Id`) REFERENCES `booking` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_Seat_Flight1` FOREIGN KEY (`Flight_Id`) REFERENCES `flight` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
