package br.upf.sistemaRevendaVeiculos.dto

import br.upf.sistemaRevendaVeiculos.model.Pessoa
import br.upf.sistemaRevendaVeiculos.model.Veiculo
import java.time.LocalDate

data class VendaResponseDTO(
    val id: Long? = null,
    val dataVenda: LocalDate,
    val veiculo: Veiculo,
    val cliente: Pessoa,
    val vendedor: Pessoa
)
