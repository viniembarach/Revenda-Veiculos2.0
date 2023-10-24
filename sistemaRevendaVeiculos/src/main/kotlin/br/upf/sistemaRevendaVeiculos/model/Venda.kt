package br.upf.sistemaRevendaVeiculos.model

import br.upf.sistemaRevendaVeiculos.dto.PessoaDTO
import br.upf.sistemaRevendaVeiculos.dto.VeiculoDTO
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne
import java.time.LocalDate

data class Venda(
    val id: Long? = null,
    val dataVenda: LocalDate,
    @OneToOne(mappedBy = "id")
    val veiculo: Veiculo,
    @OneToMany(mappedBy = "id")
    val cliente: Pessoa,
    @OneToMany(mappedBy = "id")
    val vendedor: Pessoa
)
