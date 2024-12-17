-- phpMyAdmin SQL Dump
-- version 2.7.0-pl2
-- http://www.phpmyadmin.net
-- 
-- Servidor: oraclepr.uco.es
-- Tiempo de generación: 17-12-2024 a las 17:47:04
-- Versión del servidor: 5.1.73
-- Versión de PHP: 5.3.3
-- 
-- Base de datos: `i22patom`
-- 

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `Administrador`
-- 

CREATE TABLE `Administrador` (
  `idUsuario` int(11) NOT NULL,
  `esAdmin` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 
-- Volcar la base de datos para la tabla `Administrador`
-- 

INSERT INTO `Administrador` VALUES (1, 1);
INSERT INTO `Administrador` VALUES (2, 0);

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `Alumno`
-- 

CREATE TABLE `Alumno` (
  `idUsuario` int(11) NOT NULL,
  `Telefono` int(11) DEFAULT NULL,
  `AnoAcademico` int(11) DEFAULT NULL,
  `CentroOrigen` varchar(255) DEFAULT NULL,
  `SolicitaAyuda` tinyint(1) DEFAULT NULL,
  `Inscrito` tinyint(1) DEFAULT NULL,
  `Realizado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 
-- Volcar la base de datos para la tabla `Alumno`
-- 

INSERT INTO `Alumno` VALUES (4, 612345678, 2024, 'Instituto Central', 1, 1, 0);
INSERT INTO `Alumno` VALUES (5, 623456789, 2023, 'Colegio Internacional', 0, 1, 1);
INSERT INTO `Alumno` VALUES (6, 634567890, 2025, 'Academia de Ciencias', 1, 0, 0);

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `PlanesConvalidacion`
-- 

CREATE TABLE `PlanesConvalidacion` (
  `ID` varchar(50) NOT NULL,
  `TipoUsuario` tinyint(1) DEFAULT NULL,
  `TiempoPlan` int(11) DEFAULT NULL,
  `CentroDestino` varchar(255) DEFAULT NULL,
  `AsignaturasOrigen` varchar(255) DEFAULT NULL,
  `AsignaturasDestino` varchar(255) DEFAULT NULL,
  `Vigente` tinyint(1) DEFAULT NULL,
  `AnoAcademico` int(11) DEFAULT NULL,
  `ListaUsuarios` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 
-- Volcar la base de datos para la tabla `PlanesConvalidacion`
-- 

INSERT INTO `PlanesConvalidacion` VALUES ('PLAN001', 1, 6, 'Universidad UCO', 'Matemáticas, Física', 'Cálculo I, Mecánica', 1, 2024, '1,2');
INSERT INTO `PlanesConvalidacion` VALUES ('PLAN002', 2, 12, 'Colegio Mayor', 'Historia, Geografía', 'Historia Moderna, Geografía Física', 0, 2023, '1');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `Profesorado`
-- 

CREATE TABLE `Profesorado` (
  `idUsuario` int(11) NOT NULL,
  `Telefono` int(11) DEFAULT NULL,
  `CentroOrigen` varchar(255) DEFAULT NULL,
  `SolicitaAyuda` tinyint(1) DEFAULT NULL,
  `Realizado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 
-- Volcar la base de datos para la tabla `Profesorado`
-- 

INSERT INTO `Profesorado` VALUES (3, 654321987, 'Instituto Tecnológico Central', 1, 0);
INSERT INTO `Profesorado` VALUES (4, 678910111, 'Universidad Politécnica Nacional', 0, 1);

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `SISTEMA`
-- 

CREATE TABLE `SISTEMA` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `listaPlanes` varchar(255) DEFAULT NULL,
  `listaAlumnos` varchar(255) DEFAULT NULL,
  `listaProfesores` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

-- 
-- Volcar la base de datos para la tabla `SISTEMA`
-- 

INSERT INTO `SISTEMA` VALUES (1, 'PLAN001, PLAN002', '1,2', '1,2');
INSERT INTO `SISTEMA` VALUES (2, 'PLAN002', '2', '2');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `Usuario`
-- 

CREATE TABLE `Usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `Correo` varchar(255) NOT NULL,
  `Contrasena` varchar(255) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `Apellidos` varchar(150) NOT NULL,
  `DNI` varchar(20) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `Correo` (`Correo`),
  UNIQUE KEY `DNI` (`DNI`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

-- 
-- Volcar la base de datos para la tabla `Usuario`
-- 

INSERT INTO `Usuario` VALUES (1, 'juan.perez@example.com', 'contraseña123', 'Juan', 'Pérez', '12345678A');
INSERT INTO `Usuario` VALUES (2, 'ana.lopez@example.com', 'contraseña456', 'Ana', 'López', '87654321B');
INSERT INTO `Usuario` VALUES (3, 'carlos.martin@example.com', 'contraseña789', 'Carlos', 'Martín', '45678912C');
INSERT INTO `Usuario` VALUES (4, 'maria.garcia@example.com', 'contraseña101', 'María', 'García', '78912345D');
INSERT INTO `Usuario` VALUES (5, 'pedro.ruiz@example.com', 'contraseña102', 'Pedro', 'Ruiz', '32165498E');
INSERT INTO `Usuario` VALUES (6, 'laura.sanchez@example.com', 'contraseña103', 'Laura', 'Sánchez', '98765432F');

-- 
-- Filtros para las tablas descargadas (dump)
-- 

-- 
-- Filtros para la tabla `Administrador`
-- 
ALTER TABLE `Administrador`
  ADD CONSTRAINT `Administrador_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `Usuario` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE;

-- 
-- Filtros para la tabla `Alumno`
-- 
ALTER TABLE `Alumno`
  ADD CONSTRAINT `Alumno_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `Usuario` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE;

-- 
-- Filtros para la tabla `Profesorado`
-- 
ALTER TABLE `Profesorado`
  ADD CONSTRAINT `Profesorado_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `Usuario` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE;

