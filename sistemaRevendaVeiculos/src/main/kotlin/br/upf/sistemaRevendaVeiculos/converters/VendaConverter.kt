package br.upf.sistemaRevendaVeiculos.converters

import br.upf.sistemaRevendaVeiculos.dto.VendaDTO
import br.upf.sistemaRevendaVeiculos.dto.VendaResponseDTO
import br.upf.sistemaRevendaVeiculos.model.Venda
import org.springframework.stereotype.Component

@Component
class VendaConverter {
    fun toVenda(dto: VendaDTO): Venda {
        return Venda(
            dataVenda = dto.dataVenda,
            veiculo = dto.veiculo,
            cliente = dto.cliente,
            vendedor = dto.vendedor
        )
    }

    fun toVendaResponseDTO(venda: Venda): VendaResponseDTO {
        return VendaResponseDTO(
            id = venda.id,
            dataVenda = venda.dataVenda,
            veiculo = venda.veiculo,
            cliente = venda.cliente,
            vendedor = venda.vendedor
        )
    }
}