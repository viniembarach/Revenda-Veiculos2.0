CREATE TABLE `veiculo` (
 `id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `placa`        varchar(10)     NOT NULL,
 `nome`         varchar(50)     NOT NULL,
 `modelo`       varchar(50)     NOT NULL,
 `precoCompra`  bigint          NOT NULL,
 `precoVenda`   bigint          NOT NULL,
 `anoFabri`     bigint          NOT NULL,
 `anoMod`       bigint          NOT NULL,
 `cor`          varchar(255)    NOT NULL,
 `kmRodado`     bigint          NOT NULL,
 `fabricante`   varchar(255)    NOT NULL,
 `tipoVeiculo`  varchar(255)    NOT NULL,
 `status` enum('VENDIDO','EMESTOQUE') DEFAULT NULL
);
