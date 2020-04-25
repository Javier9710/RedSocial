-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 25-04-2020 a las 19:14:56
-- Versión del servidor: 10.1.38-MariaDB
-- Versión de PHP: 7.3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `redsocial`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `amistad`
--

CREATE TABLE `amistad` (
  `usuario` int(11) DEFAULT NULL,
  `amistad` int(11) DEFAULT NULL,
  `id` int(11) NOT NULL,
  `fechasolicitud` date DEFAULT NULL,
  `estado` int(11) DEFAULT NULL COMMENT 'Almacena el estado de la solicitud, 0 si fue realizada, 1 si se aprobo y 2 si fue rechazada'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Almacena la relación de amistad entre los usuarios';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentario`
--

CREATE TABLE `comentario` (
  `id` int(11) NOT NULL,
  `publicacion` int(11) DEFAULT NULL COMMENT 'Almacena el identificador de la publicacipon del usuario',
  `usuario` int(11) DEFAULT NULL COMMENT 'Almacena el identificador del usuario que realizó la publicación',
  `fechapublicacion` date DEFAULT NULL COMMENT 'Almacena la fecha de la publicación',
  `estado` int(11) DEFAULT NULL COMMENT 'Almacena el estado de la publicación, que puede ser desde activo, bloqueado o demas'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Almacena la información de los comentarios realizados por los usuarios sobre las distintas publicaciones a la base de datos';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `etiqueta`
--

CREATE TABLE `etiqueta` (
  `id` int(11) NOT NULL,
  `usuario` int(11) DEFAULT NULL COMMENT 'Almacena el identificador del usuario que etiqueto',
  `publicacion` int(11) DEFAULT NULL COMMENT 'Almacena el identificador de la publicacion donde fue etiquetado, se asume que solo puede etiquetar el usuario dueño de la publicacion',
  `fecha` date DEFAULT NULL COMMENT 'Almacena la fecha de la etiqueta',
  `mensaje` text COMMENT 'Almacena el mensaje de la etiqueta'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Almacena la información de las etiquetas de los usuarios sobre las publicaciones';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mensaje`
--

CREATE TABLE `mensaje` (
  `id` int(11) NOT NULL,
  `fechamensaje` varchar(50) DEFAULT NULL,
  `envia` int(11) NOT NULL COMMENT 'Corresponde al identificador del usuario que envia',
  `recibe` int(11) NOT NULL COMMENT 'Corresponde al identificador del usuario que recibe',
  `mensaje` text COMMENT 'Corresponde al mensaje enviado'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Almacena los mensaje privados que son enviados a los usuarios';

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `publicacion`
--

CREATE TABLE `publicacion` (
  `id` int(11) NOT NULL,
  `descripcion` text,
  `usuario` int(11) DEFAULT NULL COMMENT 'Almacena el usuario que realiza la publicación',
  `fechapublicacion` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Almacena la fecha de publicación del usuario',
  `foto` varchar(255) DEFAULT NULL COMMENT 'Define el tipo de acceso de la publicación, que puede ser privado, publico o solo para amigos.'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Almacena la información de las publicaciones del usuario';

--
-- Volcado de datos para la tabla `publicacion`
--

INSERT INTO `publicacion` (`id`, `descripcion`, `usuario`, `fechapublicacion`, `foto`) VALUES
(29, 'Les presento mi nueva moto que he conseguido gracias a mi esfuerzo ;)', 1, '2020-04-25 16:56:47', 'C:\\Users\\acer\\Pictures\\img\\UsersacerPicturesNUEVA.jpg'),
(31, 'Una foto con mis compañeros de club, Yamaha Racing', 333477, '2020-04-25 17:01:32', 'C:\\Users\\acer\\Pictures\\GoPro\\IMG-20200301-WA0009.jpg'),
(32, 'Primer viaje a pamplona', 333477, '2020-04-25 17:03:00', 'C:\\Users\\acer\\Pictures\\GoPro\\IMG-20200301-WA0050.jpg'),
(33, 'Meme malo', 1, '2020-04-25 17:05:54', 'C:\\Users\\acer\\Documents\\me-pasas-la-tarea-si-pero-no-la-hagas-igual-17895440.png'),
(34, 'Circuito de electrónica, mierda de materia', 333478, '2020-04-25 17:14:01', 'C:\\Users\\acer\\Downloads\\circuit-20200419-1711.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL COMMENT 'Almacena el identificador interno del usuario, es un codigo interno del sistema-',
  `usuario` varchar(50) COLLATE utf8mb4_spanish2_ci NOT NULL COMMENT 'Almacena el nombre identificador del usuario',
  `email` varchar(100) COLLATE utf8mb4_spanish2_ci NOT NULL COMMENT 'Almacena el correo electrónico del usuario. El email debe ser unico.',
  `nombre` varchar(50) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `apellido` varchar(50) COLLATE utf8mb4_spanish2_ci DEFAULT NULL,
  `pass` varchar(100) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `fecharegistro` varchar(50) COLLATE utf8mb4_spanish2_ci DEFAULT NULL COMMENT 'Almacena la fecha de registro del usuario.  Esta fecha es generada por el sistema de forma automatica',
  `fechanacimiento` varchar(50) COLLATE utf8mb4_spanish2_ci DEFAULT NULL COMMENT 'Almacena la fecha de nacimiento del usuario',
  `pais` int(11) DEFAULT NULL COMMENT 'Registra el país de procedencia del usuario',
  `foto` varchar(50) COLLATE utf8mb4_spanish2_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci COMMENT='El usuario debe ser unico para todos los participantes en la red';

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `usuario`, `email`, `nombre`, `apellido`, `pass`, `fecharegistro`, `fechanacimiento`, `pais`, `foto`) VALUES
(1, 'Javier31', 'javi@gmail.com', 'javier Andres', 'Moncada', '1234', NULL, NULL, NULL, 'C:\\Users\\acer\\Pictures\\img\\1.jpg'),
(333477, 'CesarK', 'cesar@gamil.com', 'cesar david', 'carvajal', '1234', 'null', 'null', 0, 'C:\\Users\\acer\\Pictures\\img\\4.jpeg'),
(333478, 'StewarJS', 'js@gmail.com', 'jarbir stewart', 'mejia', '1234', 'null', 'null', 0, 'C:\\Users\\acer\\Pictures\\img\\5.jpg');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `amistad`
--
ALTER TABLE `amistad`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_amistad` (`usuario`,`amistad`,`estado`),
  ADD KEY `FK_amistad_usuario_02` (`amistad`);

--
-- Indices de la tabla `comentario`
--
ALTER TABLE `comentario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_comentario_publicacion` (`publicacion`),
  ADD KEY `FK_comentario_usuario` (`usuario`);

--
-- Indices de la tabla `etiqueta`
--
ALTER TABLE `etiqueta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_etiqueta_publicacion` (`publicacion`),
  ADD KEY `FK_etiqueta_usuario` (`usuario`);

--
-- Indices de la tabla `mensaje`
--
ALTER TABLE `mensaje`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_mensaje_usuario` (`envia`),
  ADD KEY `FK_mensaje_usuario_02` (`recibe`);

--
-- Indices de la tabla `publicacion`
--
ALTER TABLE `publicacion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_publicacion_usuario` (`usuario`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_usuario` (`usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `amistad`
--
ALTER TABLE `amistad`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `comentario`
--
ALTER TABLE `comentario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `etiqueta`
--
ALTER TABLE `etiqueta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `mensaje`
--
ALTER TABLE `mensaje`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `publicacion`
--
ALTER TABLE `publicacion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Almacena el identificador interno del usuario, es un codigo interno del sistema-', AUTO_INCREMENT=333479;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `amistad`
--
ALTER TABLE `amistad`
  ADD CONSTRAINT `FK_amistad_usuario` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`),
  ADD CONSTRAINT `FK_amistad_usuario_02` FOREIGN KEY (`amistad`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `comentario`
--
ALTER TABLE `comentario`
  ADD CONSTRAINT `FK_comentario_publicacion` FOREIGN KEY (`publicacion`) REFERENCES `publicacion` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_comentario_usuario` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `etiqueta`
--
ALTER TABLE `etiqueta`
  ADD CONSTRAINT `FK_etiqueta_publicacion` FOREIGN KEY (`publicacion`) REFERENCES `publicacion` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_etiqueta_usuario` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `mensaje`
--
ALTER TABLE `mensaje`
  ADD CONSTRAINT `FK_mensaje_usuario` FOREIGN KEY (`envia`) REFERENCES `usuario` (`id`) ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_mensaje_usuario_02` FOREIGN KEY (`recibe`) REFERENCES `usuario` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `publicacion`
--
ALTER TABLE `publicacion`
  ADD CONSTRAINT `FK_publicacion_usuario` FOREIGN KEY (`usuario`) REFERENCES `usuario` (`id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
