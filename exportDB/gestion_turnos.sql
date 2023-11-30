-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Generation Time: Nov 30, 2023 at 04:24 PM
-- Server version: 8.0.31
-- PHP Version: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gestion_turnos`
--

-- --------------------------------------------------------

--
-- Table structure for table `ciudadano`
--

DROP TABLE IF EXISTS `ciudadano`;
CREATE TABLE IF NOT EXISTS `ciudadano` (
  `IDCIUDADANO` int NOT NULL AUTO_INCREMENT,
  `APELLIDO` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `DNI` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `NOMBRE` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `TELEFONO` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`IDCIUDADANO`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Dumping data for table `ciudadano`
--

INSERT INTO `ciudadano` (`IDCIUDADANO`, `APELLIDO`, `DNI`, `NOMBRE`, `TELEFONO`) VALUES
(1, 'Ler', '22222222', 'Sol', '123456789'),
(2, 'Lopez', '87654321', 'Sabrina ', '987653219'),
(3, 'Juarez', '89076523', 'Alfonso', '333333333'),
(4, 'Peñaloza', '10662043', 'Cesar', '890765421'),
(5, 'Roberts', '45623198', 'Julia', '555443287');

-- --------------------------------------------------------

--
-- Table structure for table `turno`
--

DROP TABLE IF EXISTS `turno`;
CREATE TABLE IF NOT EXISTS `turno` (
  `IDTURNO` int NOT NULL AUTO_INCREMENT,
  `ESTADO` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `FECHA` date DEFAULT NULL,
  `TRAMITE` varchar(255) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `idCiuda` int DEFAULT NULL,
  PRIMARY KEY (`IDTURNO`),
  KEY `FK_TURNO_idCiuda` (`idCiuda`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Dumping data for table `turno`
--

INSERT INTO `turno` (`IDTURNO`, `ESTADO`, `FECHA`, `TRAMITE`, `idCiuda`) VALUES
(1, 'Atendido', '2023-12-06', 'Contribuyente', 1),
(2, 'Atendido', '2023-12-06', 'Padrón y Censo', 2),
(3, 'En Espera', '2023-12-06', 'Empadronamiento', 3),
(4, 'En Espera', '2023-12-08', 'Empleo', 4),
(5, 'En Espera', '2023-12-05', 'Cultura', 5),
(6, 'Atendido', '2023-12-05', 'Salud', 3),
(7, 'En Espera', '2023-12-05', 'Protección Animal', 1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
