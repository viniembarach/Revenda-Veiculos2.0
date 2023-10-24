package br.upf.sistemaRevendaVeiculos.converters

import br.upf.sistemaRevendaVeiculos.dto.VeiculoDTO
import br.upf.sistemaRevendaVeiculos.dto.VeiculoResponseDTO
import br.upf.sistemaRevendaVeiculos.model.StatusVeiculo
import br.upf.sistemaRevendaVeiculos.model.Veiculo
import org.springframework.stereotype.Component

@Component
class VeiculoConverter {
    fun toVeiculo(dto: VeiculoDTO): Veiculo {
        return Veiculo(
            placa = dto.placa,
            nome = dto.nome,
            modelo = dto.modelo,
            precoCompra = dto.precoCompra,
            precoVenda = dto.precoVenda,
            anoFabri = dto.anoFabri,
            anoMod = dto.anoMod,
            cor = dto.cor,
            kmRodado = dto.kmRodado,
            fabricante = dto.fabricante,
            tipoVeiculo = dto.tipoVeiculo,
            status = dto.status
        )
    }

    fun toVeiculoResponseDTO(veiculo: Veiculo): VeiculoResponseDTO {
        return VeiculoResponseDTO(
            id = veiculo.id,
            placa = veiculo.placa,
            nome = veiculo.nome,
            modelo = veiculo.modelo,
            precoCompra = veiculo.precoCompra,
            precoVenda = veiculo.precoVenda,
            anoFabri = veiculo.anoFabri,
            anoMod = veiculo.anoMod,
            cor = veiculo.cor,
            kmRodado = veiculo.kmRodado,
            fabricante = veiculo.fabricante,
            tipoVeiculo = veiculo.tipoVeiculo,
            status = veiculo.status
        )
    }
}