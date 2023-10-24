package br.upf.sistemaRevendaVeiculos.model

data class Veiculo(
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
    val status: StatusVeiculo
)
