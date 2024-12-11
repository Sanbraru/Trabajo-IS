-- phpMyAdmin SQL Dump
-- version 2.7.0-pl2
-- http://www.phpmyadmin.net
-- 
-- Servidor: oraclepr.uco.es
-- Tiempo de generación: 10-12-2024 a las 21:47:44
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
  `Correo` varchar(255) NOT NULL DEFAULT '',
  `esAdmin` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`Correo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Volcar la base de datos para la tabla `Administrador`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `Alumno`
-- 

CREATE TABLE `Alumno` (
  `Correo` varchar(255) NOT NULL DEFAULT '',
  `Telefono` int(11) DEFAULT NULL,
  `AnoAcademico` int(11) DEFAULT NULL,
  `CentroOrigen` varchar(255) DEFAULT NULL,
  `SolicitaAyuda` tinyint(1) DEFAULT NULL,
  `Inscrito` tinyint(1) DEFAULT NULL,
  `Realizado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`Correo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Volcar la base de datos para la tabla `Alumno`
-- 


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
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Volcar la base de datos para la tabla `PlanesConvalidacion`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `Profesorado`
-- 

CREATE TABLE `Profesorado` (
  `Correo` varchar(255) NOT NULL DEFAULT '',
  `Telefono` int(11) DEFAULT NULL,
  `CentroOrigen` varchar(255) DEFAULT NULL,
  `SolicitaAyuda` tinyint(1) DEFAULT NULL,
  `Realizado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`Correo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Volcar la base de datos para la tabla `Profesorado`
-- 


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
) ENGINE=MyISAM DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- 
-- Volcar la base de datos para la tabla `SISTEMA`
-- 


-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `Usuario`
-- 

CREATE TABLE `Usuario` (
  `Correo` varchar(255) NOT NULL,
  `Contrasena` varchar(255) NOT NULL,
  `Nombre` varchar(100) NOT NULL,
  `Apellidos` varchar(150) NOT NULL,
  `DNI` varchar(20) NOT NULL,
  PRIMARY KEY (`Correo`),
  UNIQUE KEY `DNI` (`DNI`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Volcar la base de datos para la tabla `Usuario`
-- 


