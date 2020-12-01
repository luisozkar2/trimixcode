-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-12-2020 a las 15:16:32
-- Versión del servidor: 10.1.40-MariaDB
-- Versión de PHP: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `trimix`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personas`
--

CREATE TABLE `personas` (
  `perId` int(11) NOT NULL COMMENT 'Identificador De Persona',
  `perNombre` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Nombre de la Persona',
  `perApellido` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Apellido de la Persona',
  `IdTipoDocumento` int(11) NOT NULL COMMENT 'Identificador del Tipo de Documento',
  `perNumeroDocumento` int(11) NOT NULL COMMENT 'Numero de documento de la Persona',
  `perFechaNacimiento` date NOT NULL COMMENT 'Fecha de Nacimiento de la Persona'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Tabla correspondiente a información de Personas';

--
-- Volcado de datos para la tabla `personas`
--

INSERT INTO `personas` (`perId`, `perNombre`, `perApellido`, `IdTipoDocumento`, `perNumeroDocumento`, `perFechaNacimiento`) VALUES
(2, 'Jana', 'Medina', 1, 53680740, '2020-11-29'),
(3, 'Rafael', 'Medina', 1, 55680740, '2020-11-29'),
(4, 'Jesi', 'Monzon', 1, 32677687, '1986-10-15'),
(5, 'Rocky', 'Medina', 2, 6000001, '2019-12-31'),
(7, 'Luis Oscar', 'Medina', 1, 30611170, '1983-11-01'),
(8, 'Mirta', 'Arce', 3, 12679659, '1956-12-19');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipodocumento`
--

CREATE TABLE `tipodocumento` (
  `id` int(11) NOT NULL,
  `codigo` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `descripcion` varchar(30) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `tipodocumento`
--

INSERT INTO `tipodocumento` (`id`, `codigo`, `descripcion`) VALUES
(1, 'DNI', 'Documento Nacional Identidad'),
(2, 'Pasaporte', 'Pasaporte'),
(3, 'Cédula', 'Cédula');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `personas`
--
ALTER TABLE `personas`
  ADD PRIMARY KEY (`perId`),
  ADD KEY `IdTipoDocumento` (`IdTipoDocumento`);

--
-- Indices de la tabla `tipodocumento`
--
ALTER TABLE `tipodocumento`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `personas`
--
ALTER TABLE `personas`
  MODIFY `perId` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Identificador De Persona', AUTO_INCREMENT=9;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `personas`
--
ALTER TABLE `personas`
  ADD CONSTRAINT `personas_ibfk_1` FOREIGN KEY (`IdTipoDocumento`) REFERENCES `tipodocumento` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
