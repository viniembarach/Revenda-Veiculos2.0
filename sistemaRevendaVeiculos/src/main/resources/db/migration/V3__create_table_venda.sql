CREATE TABLE `venda` (
 `id`         bigint  NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `dataVenda`  date    NOT NULL,
 `veiculo_id` bigint  NOT NULL,
 `cliente_id`  bigint  NOT NULL,
 `vendedor_id`  bigint  NOT NULL,
 FOREIGN KEY (`veiculo_id`) REFERENCES `veiculo` (`id`),
 FOREIGN KEY (`cliente_id`) REFERENCES `pessoa` (`id`),
 FOREIGN KEY (`vendedor_id`) REFERENCES `pessoa` (`id`)

 );