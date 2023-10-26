CREATE TABLE `pessoa` (
 `id` bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
 `dataVenda`    datetime(6)     NOT NULL,
 `veiculo_id`   bigint          NOT NULL,
 `cliente_id`   bigint          NOT NULL,
 `vendedor_id`  bigint          NOT NULL,
  FOREIGN KEY (`veiculo_id`)  REFERENCES `veiculo`  (`id`)
  FOREIGN KEY (`cliente_id`)  REFERENCES `cliente`  (`id`)
  FOREIGN KEY (`vendedor_id`) REFERENCES `vendedor` (`id`)
);