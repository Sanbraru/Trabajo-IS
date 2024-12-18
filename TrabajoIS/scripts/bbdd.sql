-- phpMyAdmin SQL Dump
-- version 2.7.0-pl2
-- http://www.phpmyadmin.net
-- 
-- Servidor: oraclepr.uco.es
-- Tiempo de generación: 18-12-2024 a las 11:33:52
-- Versión del servidor: 5.1.73
-- Versión de PHP: 5.3.3
-- 
-- Base de datos: `i22patom`
-- 

-- --------------------------------------------------------

 CREATE TABLE `Usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `Correo` varchar(255) NOT NULL,
  `Contrasena` varchar(255) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `Apellidos` varchar(150) NOT NULL,
  `DNI` varchar(20) NOT NULL,
  `IdPlan` int(11) NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `Correo` (`Correo`),
  UNIQUE KEY `DNI` (`DNI`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

-- 
-- Volcar la base de datos para la tabla `Usuario`
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
  `Realizado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- 
-- Volcar la base de datos para la tabla `Alumno`
-- 

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `Asignaturas`
-- 

CREATE TABLE `Asignaturas` (
  `idAsignatura` int(11) NOT NULL AUTO_INCREMENT,
  `nombreAsignatura` varchar(255) NOT NULL,
  PRIMARY KEY (`idAsignatura`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- 
-- Volcar la base de datos para la tabla `Asignaturas`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `PlanesConvalidacion`
-- 

CREATE TABLE `PlanesConvalidacion` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TipoUsuario` tinyint(1) DEFAULT NULL,
  `TiempoPlan` int(11) DEFAULT NULL,
  `CentroDestino` varchar(255) DEFAULT NULL,
  `IdAsignaturasOrigen` int(11) DEFAULT NULL,
  `IdAsignaturasDestino` int(11) DEFAULT NULL,
  `Vigente` tinyint(1) DEFAULT NULL,
  `AnoAcademico` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- 
-- Volcar la base de datos para la tabla `PlanesConvalidacion`
-- 


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
-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `Usuario`
-- 



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
-- Filtros para la tabla `PlanesConvalidacion`
-- 
ALTER TABLE `Usuario`
  ADD CONSTRAINT `FK_Planes_Usuario` FOREIGN KEY (`IdPlan`) REFERENCES `PlanesConvalidacion` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

-- 
-- Filtros para la tabla `Profesorado`
-- 
ALTER TABLE `Profesorado`
  ADD CONSTRAINT `Profesorado_ibfk_1` FOREIGN KEY (`idUsuario`) REFERENCES `Usuario` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE;
  
  ALTER TABLE `PlanesConvalidacion`
  ADD CONSTRAINT `FK_ASIGNATURASORIGEN` FOREIGN KEY (`IdAsignaturasOrigen`) REFERENCES `Asignaturas` (`idAsignatura`) ON DELETE CASCADE ON UPDATE CASCADE;


  ALTER TABLE `PlanesConvalidacion`
  ADD CONSTRAINT `FK_ASIGNATURASDESTINO` FOREIGN KEY (`IdAsignaturasDestino`) REFERENCES `Asignaturas` (`idAsignatura`) ON DELETE CASCADE ON UPDATE CASCADE;
