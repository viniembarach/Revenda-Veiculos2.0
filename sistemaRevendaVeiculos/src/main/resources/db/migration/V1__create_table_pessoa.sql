CREATE TABLE `pessoa` (
 `id`        bigint                 NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `cpfoucnpj` varchar(20)            NOT NULL,
 `nome`      varchar(100)           NOT NULL,
 `telefone`  varchar(20)            NOT NULL,
 `cidade`    varchar(100)           NOT NULL,
 `endereco`  varchar(255)           NOT NULL,
 `tipo` enum('CLIENTE', 'VENDEDOR') DEFAULT NULL
);