package br.upf.sistemaRevendaVeiculos.dto

import br.upf.sistemaRevendaVeiculos.model.StatusVeiculo
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class VeiculoDTO(
    @field:NotEmpty (message = "Veiculo sempre deve ter uma placa")
    val placa: String,
    @field:NotEmpty (message = "Veiculo sempre deve ter um nome")
    val nome: String,
    @field:NotEmpty (message = "Veiculo sempre deve ter um modelo")
    val modelo: String,
    @field:NotNull (message = "Deve ter um preço de compra")
    val precoCompra: Int,
    @field:NotNull (message = "Deve ter um preço de venda")
    val precoVenda: Int,
    @field:NotNull (message = "Deve ter um ano de fabricação")
    val anoFabri: Int,
    @field:NotNull (message = "Deve ter um ano de modelo")
    val anoMod: Int,
    @field:NotEmpty (message = "Veiculo sempre deve ter uma cor")
    val cor: String,
    @field:NotNull (message = "Deve ter a quilometragem")
    val kmRodado: Int,
    @field:NotEmpty (message = "Veiculo sempre deve ter um fabricante")
    val fabricante: String,
    @field:NotEmpty (message = "Veiculo sempre deve ter um tipo")
    val tipoVeiculo: String,
    val status: StatusVeiculo
)
