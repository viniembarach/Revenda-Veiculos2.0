package br.upf.sistemaRevendaVeiculos.model

import jakarta.persistence.*

@Entity
data class Veiculo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val placa: String,
    val nome: String,
    val modelo: String,
    val precoCompra: Int,
    val precoVenda: Int,
    val anoFabri: Int,
    val anoMod: Int,
    val cor: String,
    val kmRodado: Int,
    val fabricante: String,
    val tipoVeiculo: String,
    @Enumerated(value = EnumType.STRING)
    val status: StatusVeiculo
)