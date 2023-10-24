package br.upf.sistemaRevendaVeiculos.dto

import br.upf.sistemaRevendaVeiculos.model.Pessoa
import br.upf.sistemaRevendaVeiculos.model.Veiculo
import jakarta.validation.constraints.NotNull
import java.time.LocalDate

data class VendaDTO(
    @field:NotNull (message = "A Venda deve ter uma data" )
    val dataVenda : LocalDate,
    @field:NotNull(message = "Venda sempre deve ter um veiculo" )
    val veiculo: Veiculo,
    @field:NotNull(message = "Venda sempre deve ter um cliente" )
    val cliente: Pessoa,
    @field:NotNull(message = "Venda sempre deve ter um vendador" )
    val vendedor: Pessoa
)
