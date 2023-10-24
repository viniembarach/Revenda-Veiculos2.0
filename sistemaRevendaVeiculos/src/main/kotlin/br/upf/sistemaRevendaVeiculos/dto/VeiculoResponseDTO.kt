package br.upf.sistemaRevendaVeiculos.dto

import br.upf.sistemaRevendaVeiculos.model.StatusVeiculo

data class VeiculoResponseDTO(
    val id: Long?,
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
