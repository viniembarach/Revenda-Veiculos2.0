package br.upf.sistemaRevendaVeiculos.model

import jakarta.persistence.*
import java.time.LocalDate

@Entity
data class Venda(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val dataVenda: LocalDate = LocalDate.now(),
    @OneToOne
    val veiculo: Veiculo,
    @ManyToOne
    val cliente: Pessoa,
    @ManyToOne
    val vendedor: Pessoa
)