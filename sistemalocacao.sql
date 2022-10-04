-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 09-Jun-2021 às 05:07
-- Versão do servidor: 10.4.19-MariaDB
-- versão do PHP: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `sistemalocacao`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionarios`
--

CREATE TABLE `funcionarios` (
  `id_funcionario` int(11) NOT NULL,
  `cargo` varchar(30) NOT NULL,
  `fk_id_pessoa` int(11) DEFAULT NULL,
  `cpf` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `funcionarios`
--

INSERT INTO `funcionarios` (`id_funcionario`, `cargo`, `fk_id_pessoa`, `cpf`) VALUES
(1, 'CEA', NULL, '123456'),
(2, 'CEO', NULL, '111');

-- --------------------------------------------------------

--
-- Estrutura da tabela `locacoes`
--

CREATE TABLE `locacoes` (
  `cpf` varchar(12) NOT NULL,
  `data_inicio` date NOT NULL,
  `data_fim` date NOT NULL,
  `placa_veiculo` varchar(10) DEFAULT NULL,
  `funcionario` varchar(50) DEFAULT NULL,
  `modelo` varchar(20) DEFAULT NULL,
  `tipo` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `locacoes`
--

INSERT INTO `locacoes` (`cpf`, `data_inicio`, `data_fim`, `placa_veiculo`, `funcionario`, `modelo`, `tipo`) VALUES
('1000', '2020-06-08', '2020-06-09', 'pj4yu', 'Junior', 'Onix', 'Carro'),
('11', '2021-06-01', '2021-06-01', '2021-06-01', 'Diego', NULL, 'Carro'),
('111', '2000-02-12', '2000-02-14', 'pjh1g01', 'Lucas', 'Onix', 'Carro');

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoas`
--

CREATE TABLE `pessoas` (
  `id_pessoa` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `idade` int(11) NOT NULL,
  `telefone` varchar(11) NOT NULL,
  `endereco` varchar(250) NOT NULL,
  `sexo` varchar(20) DEFAULT NULL,
  `cpf` varchar(20) DEFAULT NULL,
  `cnpj` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `pessoas`
--

INSERT INTO `pessoas` (`id_pessoa`, `nome`, `idade`, `telefone`, `endereco`, `sexo`, `cpf`, `cnpj`) VALUES
(1, 'Marcos', 22, '77777', 'dsad', 'Masculino', '86352230555', NULL),
(9, 'Lucas Bezerra', 20, '222', 'rua J', 'Masculino', NULL, NULL);

-- --------------------------------------------------------

--
-- Estrutura da tabela `veiculos`
--

CREATE TABLE `veiculos` (
  `id_veiculo` int(11) NOT NULL,
  `tipo` varchar(30) DEFAULT NULL,
  `placa` varchar(7) NOT NULL,
  `chassi` varchar(17) NOT NULL,
  `marca` varchar(30) NOT NULL,
  `modelo` varchar(30) NOT NULL,
  `estado` varchar(30) NOT NULL DEFAULT 'novo',
  `ano` int(11) NOT NULL,
  `status_disponivel` varchar(100) DEFAULT 'Disponivel',
  `descricao` varchar(200) DEFAULT NULL,
  `cor` varchar(15) NOT NULL,
  `combustivel` varchar(20) NOT NULL,
  `valor_diaria` float DEFAULT NULL,
  `quantPortas` varchar(20) DEFAULT NULL,
  `tracao` varchar(20) DEFAULT NULL,
  `cambio` varchar(20) DEFAULT NULL,
  `tetoSolar` varchar(20) DEFAULT NULL,
  `cilindradas` varchar(20) DEFAULT NULL,
  `vel_max` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `veiculos`
--

INSERT INTO `veiculos` (`id_veiculo`, `tipo`, `placa`, `chassi`, `marca`, `modelo`, `estado`, `ano`, `status_disponivel`, `descricao`, `cor`, `combustivel`, `valor_diaria`, `quantPortas`, `tracao`, `cambio`, `tetoSolar`, `cilindradas`, `vel_max`) VALUES
(2, 'carro', 'pjh1g01', '4d5saddsa', 'Chervolet', 'Onix', 'BA', 2015, '1', NULL, 'Branco', 'Flex', 100, '4', 'tem', 'Manual', ' tem', NULL, NULL),
(7, 'moto', 'sdsd', 'sdsds', 'sdsds', 'sdsd', 'sdsd', 23, '1', NULL, 'sdsd', 'sdsd', 2222, NULL, NULL, NULL, NULL, NULL, 332),
(11, 'Carro', 'KT756H', '23kj2k', 'Toyota', '2000gt', 'Las vegas', 1967, 'Disponivel', NULL, 'Vermelho', 'Gasolina', 20000, '2', '2x4', 'manual', 'nao', NULL, NULL);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `funcionarios`
--
ALTER TABLE `funcionarios`
  ADD PRIMARY KEY (`id_funcionario`);

--
-- Índices para tabela `locacoes`
--
ALTER TABLE `locacoes`
  ADD PRIMARY KEY (`cpf`);

--
-- Índices para tabela `pessoas`
--
ALTER TABLE `pessoas`
  ADD PRIMARY KEY (`id_pessoa`),
  ADD UNIQUE KEY `telefone` (`telefone`);

--
-- Índices para tabela `veiculos`
--
ALTER TABLE `veiculos`
  ADD PRIMARY KEY (`id_veiculo`),
  ADD UNIQUE KEY `placa` (`placa`),
  ADD UNIQUE KEY `chassi` (`chassi`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `funcionarios`
--
ALTER TABLE `funcionarios`
  MODIFY `id_funcionario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `pessoas`
--
ALTER TABLE `pessoas`
  MODIFY `id_pessoa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de tabela `veiculos`
--
ALTER TABLE `veiculos`
  MODIFY `id_veiculo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
