CREATE TABLE `pessoa` (
 `id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `cpfoucnpj`    varchar(255)    NOT NULL,
 `nome`         varchar(255)    NOT NULL,
 `modelo`       varchar(255)    NOT NULL,
 `telefone`     varchar(255)    NOT NULL,
 `cidade`       varchar(255)    NOT NULL,
 `endereco`     varchar(255)    NOT NULL,
 `tipo` enum('VENDIDO','DISPONIVEL','REVISAO') DEFAULT NULL
);