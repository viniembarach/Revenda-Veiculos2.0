CREATE TABLE `veiculo` (
 `id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `placa`        varchar(255)    NOT NULL,
 `nome`         varchar(255)    NOT NULL,
 `modelo`       varchar(255)    NOT NULL,
 `precoCompra`  varchar(255)    NOT NULL,
 `precoVenda`   varchar(255)    NOT NULL,
 `anoFabri`     varchar(255)    NOT NULL,
 `anoMod`       varchar(255)    NOT NULL,
 `cor`          varchar(255)    NOT NULL,
 `kmRodado`     varchar(255)    NOT NULL,
 `fabricante`   varchar(255)    NOT NULL,
 `tipoVeiculo`  varchar(255)    NOT NULL,
 `status` enum('VENDIDO','DISPONIVEL','REVISAO') DEFAULT NULL
);
