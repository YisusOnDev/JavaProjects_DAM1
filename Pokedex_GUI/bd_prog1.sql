-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-01-2021 a las 22:29:35
-- Versión del servidor: 10.4.16-MariaDB
-- Versión de PHP: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_prog1`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipos`
--

CREATE TABLE `equipos` (
  `id` int(11) NOT NULL,
  `idusuario` varchar(255) NOT NULL,
  `idpokemon` int(11) NOT NULL,
  `nivel` int(11) DEFAULT NULL,
  `mote` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pokemon`
--

CREATE TABLE `pokemon` (
  `Numero` int(11) NOT NULL,
  `Nombre` varchar(45) DEFAULT NULL,
  `Descripcion` varchar(255) DEFAULT NULL,
  `Altura` float DEFAULT NULL,
  `Peso` float DEFAULT NULL,
  `Categoria` varchar(45) DEFAULT NULL,
  `Habilidad` varchar(45) DEFAULT NULL,
  `ImagenURL` varchar(255) DEFAULT NULL,
  `SonidoURL` varchar(255) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pokemon`
--

INSERT INTO `pokemon` (`Numero`, `Nombre`, `Descripcion`, `Altura`, `Peso`, `Categoria`, `Habilidad`, `ImagenURL`, `SonidoURL`) VALUES
(1, 'Bulbasaur', 'Este Pokémon nace con una semilla en el lomo, que brota con el paso del tiempo.', 0.7, 6.9, 'Semilla', 'Espesura', 'https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png', 'http://play.pokemonshowdown.com/audio/cries/bulbasaur.mp3'),
(2, 'Ivysaur', 'Cuando le crece bastante el bulbo del lomo, pierde la capacidad de erguirse sobre las patas traseras.', 1, 13, 'Semilla', 'Espesura', 'https://assets.pokemon.com/assets/cms2/img/pokedex/full/002.png', 'https://play.pokemonshowdown.com/audio/cries/ivysaur.mp3'),
(3, 'Venusaur ', 'La planta florece cuando absorbe energía solar, lo cual le obliga a buscar siempre la luz del sol.', 2, 100, 'Semilla', 'Espesura', 'https://assets.pokemon.com/assets/cms2/img/pokedex/full/003.png', 'https://play.pokemonshowdown.com/audio/cries/venusaur.mp3'),
(4, 'Charmander', 'Prefiere las cosas calientes. Dicen que cuando llueve le sale vapor de la punta de la cola.', 0.6, 8.5, 'Lagartija', 'Mar Llamas', 'https://assets.pokemon.com/assets/cms2/img/pokedex/full/004.png', 'https://play.pokemonshowdown.com/audio/cries/charmander.mp3'),
(5, 'Charmeleon', 'Este Pokémon de naturaleza agresiva ataca en combate con su cola llameante y hace trizas al rival con sus afiladas garras.', 1.1, 19, 'Llama', 'Mar Llamas', 'https://assets.pokemon.com/assets/cms2/img/pokedex/full/005.png', 'https://play.pokemonshowdown.com/audio/cries/charmeleon.mp3'),
(6, 'Charizard', 'Escupe un fuego tan caliente que funde las rocas. Causa incendios forestales sin querer.', 1.7, 90.5, 'Llama', 'Mar Llamas', 'https://assets.pokemon.com/assets/cms2/img/pokedex/full/006.png', 'https://play.pokemonshowdown.com/audio/cries/charizard.mp3'),
(7, 'Squirtle', '\"Vamo a calmarno\" Cuando retrae su largo cuello en el caparazón, dispara agua a una presión increíble.', 0.5, 9, 'Tortuguita', 'Torrente', 'https://assets.pokemon.com/assets/cms2/img/pokedex/full/007.png', 'https://play.pokemonshowdown.com/audio/cries/squirtle.mp3'),
(8, 'Wartortle', 'Se lo considera un símbolo de longevidad. Los ejemplares más ancianos tienen musgo sobre el caparazón.', 1, 22.5, 'Tortuga', 'Torrente', 'https://assets.pokemon.com/assets/cms2/img/pokedex/full/008.png', 'https://play.pokemonshowdown.com/audio/cries/wartortle.mp3'),
(9, 'Blastoise', 'Para acabar con su enemigo, lo aplasta con el peso de su cuerpo. En momentos de apuro, se esconde en el caparazón.', 1.6, 85.5, 'Armazón', 'Torrente', 'https://assets.pokemon.com/assets/cms2/img/pokedex/full/009.png', 'https://play.pokemonshowdown.com/audio/cries/blastoise.mp3'),
(10, 'Caterpie', 'Para protegerse, despide un hedor horrible por las antenas con el que repele a sus enemigos.', 0.3, 2.9, 'Semilla', 'Polvo Escudo', 'https://assets.pokemon.com/assets/cms2/img/pokedex/full/010.png', 'https://play.pokemonshowdown.com/audio/cries/caterpie.mp3');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pokemon_tipos`
--

CREATE TABLE `pokemon_tipos` (
  `Numero` int(11) NOT NULL,
  `CodigoTipo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pokemon_tipos`
--

INSERT INTO `pokemon_tipos` (`Numero`, `CodigoTipo`) VALUES
(1, 1),
(1, 4),
(2, 1),
(2, 4),
(3, 1),
(3, 4),
(4, 2),
(5, 2),
(6, 2),
(6, 5),
(7, 3),
(8, 3),
(9, 3),
(10, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipos`
--

CREATE TABLE `tipos` (
  `codTipo` int(11) NOT NULL,
  `Tipo` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipos`
--

INSERT INTO `tipos` (`codTipo`, `Tipo`) VALUES
(1, 'Planta'),
(2, 'Fuego'),
(3, 'Agua'),
(4, 'Veneno'),
(5, 'Volador'),
(6, 'Bicho'),
(7, 'Acero'),
(8, 'Dragón'),
(9, 'Eléctrico'),
(10, 'Fantasma'),
(11, 'Hada'),
(12, 'Hielo'),
(13, 'Lucha'),
(14, 'Normal'),
(15, 'Psíquico'),
(16, 'Roca'),
(17, 'Siniestro'),
(18, '???');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `Username` varchar(50) NOT NULL,
  `Password` varchar(45) DEFAULT NULL,
  `IsAdmin` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`Username`, `Password`, `IsAdmin`) VALUES
('admin', 'admin', 1),
('user', 'user', 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `equipos`
--
ALTER TABLE `equipos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `pokemon`
--
ALTER TABLE `pokemon`
  ADD PRIMARY KEY (`Numero`);

--
-- Indices de la tabla `pokemon_tipos`
--
ALTER TABLE `pokemon_tipos`
  ADD PRIMARY KEY (`Numero`,`CodigoTipo`),
  ADD KEY `FK_CodigoTipo_idx` (`CodigoTipo`);

--
-- Indices de la tabla `tipos`
--
ALTER TABLE `tipos`
  ADD PRIMARY KEY (`codTipo`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`Username`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `equipos`
--
ALTER TABLE `equipos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `pokemon_tipos`
--
ALTER TABLE `pokemon_tipos`
  ADD CONSTRAINT `FK_CodigoTipo` FOREIGN KEY (`CodigoTipo`) REFERENCES `tipos` (`codTipo`),
  ADD CONSTRAINT `FK_Numero` FOREIGN KEY (`Numero`) REFERENCES `pokemon` (`Numero`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
