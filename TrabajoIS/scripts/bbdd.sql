-- phpMyAdmin SQL Dump
-- version 2.7.0-pl2
-- http://www.phpmyadmin.net
-- 
-- Servidor: oraclepr.uco.es
-- Tiempo de generación: 18-12-2024 a las 18:50:45
-- Versión del servidor: 5.1.73
-- Versión de PHP: 5.3.3
-- 
-- Base de datos: `i22patom`
-- 

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
  `IdPlan` int(11) NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `Correo` (`Correo`),
  UNIQUE KEY `DNI` (`DNI`),
  KEY `FK_Planes_Usuario` (`IdPlan`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;


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

INSERT INTO `Administrador` VALUES (3, 1);

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

-- 
-- Volcar la base de datos para la tabla `Asignaturas`
-- 

INSERT INTO `Asignaturas` (nombreAsignatura) VALUES ('Matemáticas'), ('Física'), ('Química'), ('Biología');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `Plan_Asignaturas`
-- 

CREATE TABLE `Plan_Asignaturas` (
  `id_plan` int(11) NOT NULL DEFAULT '0',
  `id_asignatura` int(11) NOT NULL DEFAULT '0',
  `tipo_asignatura` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_plan`,`id_asignatura`),
  KEY `id_asignatura` (`id_asignatura`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Volcar la base de datos para la tabla `Plan_Asignaturas`
-- 

-- Relacionar asignaturas origen
INSERT INTO `Plan_Asignaturas` (id_plan, id_asignatura, tipo_asignatura)
VALUES (1, 1, 'Origen'),
       (2, 2, 'Origen');

-- Relacionar asignaturas destino
INSERT INTO `Plan_Asignaturas` (id_plan, id_asignatura, tipo_asignatura)
VALUES (1, 3, 'Destino'),
       (2, 4, 'Destino');



-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `PlanesConvalidacion`
-- 

CREATE TABLE `PlanesConvalidacion` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `TipoUsuario` tinyint(1) DEFAULT NULL,
  `TiempoPlan` int(11) DEFAULT NULL,
  `CentroDestino` varchar(255) DEFAULT NULL,
  `Vigente` tinyint(1) DEFAULT NULL,
  `AnoAcademico` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

-- 
-- Volcar la base de datos para la tabla `PlanesConvalidacion`
-- 

INSERT INTO `PlanesConvalidacion` (TipoUsuario, TiempoPlan, CentroDestino, Vigente, AnoAcademico)
VALUES (1, 2, 'Centro Universitario B', 1, 2);

INSERT INTO `PlanesConvalidacion` (TipoUsuario, TiempoPlan, CentroDestino, Vigente, AnoAcademico)
VALUES (1, 2, 'Centro Universitario B', 1, 3);

INSERT INTO `PlanesConvalidacion` (TipoUsuario, TiempoPlan, CentroDestino, Vigente, AnoAcademico)
VALUES (0, 2, 'Centro Universitario B', 1, 4);

INSERT INTO `PlanesConvalidacion` (TipoUsuario, TiempoPlan, CentroDestino, Vigente, AnoAcademico)
VALUES (0, 2, 'Centro Universitario B', 1, 4);


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
-- Volcar la base de datos para la tabla `Usuario`
-- 

INSERT INTO `Usuario` VALUES (3, 'admin@ejemplo.com', 'admin1234', 'Admin', 'Ejemplo', '12345678Z', 2);

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

-- 
-- Filtros para la tabla `Usuario`
-- 
ALTER TABLE `Usuario`
  ADD CONSTRAINT `FK_Planes_Usuario` FOREIGN KEY (`IdPlan`) REFERENCES `PlanesConvalidacion` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

