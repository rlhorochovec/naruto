-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 12-Abr-2023 às 19:13
-- Versão do servidor: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `naruto`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `classificacao`
--

CREATE TABLE IF NOT EXISTS `classificacao` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `nome` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=14 ;

--
-- Extraindo dados da tabela `classificacao`
--

INSERT INTO `classificacao` (`id`, `created_at`, `updated_at`, `nome`) VALUES
(1, '2023-04-12 16:35:45.992000', '2023-04-12 16:35:45.992000', 'Gennin'),
(2, '2023-04-12 16:35:57.439000', '2023-04-12 16:35:57.439000', 'Chunnin'),
(3, '2023-04-12 16:36:08.668000', '2023-04-12 16:36:08.668000', 'Tokubetsu Jonnin'),
(4, '2023-04-12 16:36:22.356000', '2023-04-12 16:36:22.356000', 'Jonnin'),
(5, '2023-04-12 16:36:36.977000', '2023-04-12 16:36:36.977000', 'ANBU'),
(6, '2023-04-12 16:36:46.151000', '2023-04-12 16:36:46.151000', 'Líder da Aldeia ou Kage'),
(7, '2023-04-12 16:36:56.707000', '2023-04-12 16:36:56.707000', 'Sannin'),
(8, '2023-04-12 16:37:09.014000', '2023-04-12 16:37:09.014000', 'Nukenin'),
(9, '2023-04-12 16:37:17.043000', '2023-04-12 16:37:17.043000', 'Oinin'),
(10, '2023-04-12 16:37:27.144000', '2023-04-12 16:37:27.144000', 'Cobradores'),
(11, '2023-04-12 16:37:39.125000', '2023-04-12 16:37:39.125000', 'Ryounin'),
(12, '2023-04-12 16:37:49.001000', '2023-04-12 16:37:49.001000', 'Ninja Mensageiro'),
(13, '2023-04-12 16:38:03.542000', '2023-04-12 16:38:03.542000', 'Kunoichi');

-- --------------------------------------------------------

--
-- Estrutura da tabela `ninja`
--

CREATE TABLE IF NOT EXISTS `ninja` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `nome` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  `classificacao_id` bigint(20) DEFAULT NULL,
  `vila_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKrvw4890atjpojp56s4m67tcns` (`classificacao_id`),
  KEY `FKt4apqgxlo2le505h1kts5s449` (`vila_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=5 ;

--
-- Extraindo dados da tabela `ninja`
--

INSERT INTO `ninja` (`id`, `created_at`, `updated_at`, `nome`, `classificacao_id`, `vila_id`) VALUES
(1, '2023-04-12 16:58:45.116000', '2023-04-12 16:58:45.116000', 'Naruto Uzumaki', 6, 1),
(2, '2023-04-12 17:00:23.912000', '2023-04-12 17:00:23.912000', 'Jiraya', 7, 1),
(3, '2023-04-12 17:00:44.934000', '2023-04-12 17:00:44.934000', 'Tsunade', 7, 1),
(4, '2023-04-12 17:09:26.393000', '2023-04-12 17:09:26.393000', 'Gaara', 6, 5);

-- --------------------------------------------------------

--
-- Estrutura da tabela `vila`
--

CREATE TABLE IF NOT EXISTS `vila` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_at` datetime(6) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `nome` varchar(255) COLLATE latin1_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_general_ci AUTO_INCREMENT=14 ;

--
-- Extraindo dados da tabela `vila`
--

INSERT INTO `vila` (`id`, `created_at`, `updated_at`, `nome`) VALUES
(1, '2023-04-12 16:52:31.106000', '2023-04-12 16:52:31.106000', 'Konohagakure (Vila Oculta da Folha)'),
(2, '2023-04-12 16:52:42.624000', '2023-04-12 16:52:42.624000', 'Kirigakure (Vila Oculta da Névoa)'),
(3, '2023-04-12 16:52:56.216000', '2023-04-12 16:52:56.216000', 'Iwagakure (Vila Oculta da Pedra)'),
(4, '2023-04-12 16:53:06.698000', '2023-04-12 16:53:06.698000', 'Kumogakure (Vila Oculta da Nuvem)'),
(5, '2023-04-12 16:53:22.068000', '2023-04-12 16:53:22.068000', 'Sunagakure (Vila Oculta da Areia)'),
(6, '2023-04-12 16:54:40.018000', '2023-04-12 16:54:40.018000', 'Otogakure (Vila Oculta do Som)'),
(7, '2023-04-12 16:55:19.148000', '2023-04-12 16:55:19.148000', 'Yukigakure (Vila Oculta Entre a Neve)'),
(8, '2023-04-12 16:55:29.966000', '2023-04-12 16:55:29.966000', 'Getsugakure (Vila Oculta sob a Lua)'),
(9, '2023-04-12 16:56:45.588000', '2023-04-12 16:56:45.588000', 'Hoshigakure (Vila Oculta Entre as Estrelas)'),
(10, '2023-04-12 16:56:55.856000', '2023-04-12 16:56:55.856000', 'Shimogakure (Vila Oculta na Geada)'),
(11, '2023-04-12 16:57:07.345000', '2023-04-12 16:57:07.345000', 'Yugakure (Vila Oculta das Fontes Termais)'),
(12, '2023-04-12 16:57:17.060000', '2023-04-12 16:57:17.060000', 'Tanigakure (Vila Oculta nos Vales)'),
(13, '2023-04-12 16:57:42.013000', '2023-04-12 16:57:42.013000', 'Uzushiogakure (Vila Oculta no Redemoinho)');

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `ninja`
--
ALTER TABLE `ninja`
  ADD CONSTRAINT `FKt4apqgxlo2le505h1kts5s449` FOREIGN KEY (`vila_id`) REFERENCES `vila` (`id`),
  ADD CONSTRAINT `FKrvw4890atjpojp56s4m67tcns` FOREIGN KEY (`classificacao_id`) REFERENCES `classificacao` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
