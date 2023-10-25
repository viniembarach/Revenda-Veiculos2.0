package br.upf.sistemaRevendaVeiculos.service

import br.upf.sistemaRevendaVeiculos.converters.VendaConverter
import br.upf.sistemaRevendaVeiculos.dto.VendaDTO
import br.upf.sistemaRevendaVeiculos.dto.VendaResponseDTO
import br.upf.sistemaRevendaVeiculos.exceptions.NotFoundException
import br.upf.sistemaRevendaVeiculos.repository.VendaRepository
import org.springframework.stereotype.Service

@Service
class VendaService(private val repository: VendaRepository,
                    private val converter: VendaConverter){
    fun listar(): List<VendaResponseDTO> {
        return repository.findAll()
            .map(converter::toVendaResponseDTO)
    }

    fun buscarPorId(id: Long): VendaResponseDTO {
        val venda = repository.findById(id)
            .orElseThrow { NotFoundException(VENDA_NOT_FOUND_MESSAGE) }
        return converter.toVendaResponseDTO(venda)
    }
    fun cadastrar(dto: VendaDTO): VendaResponseDTO {
        return converter.toVendaResponseDTO(
            repository.save(converter.toVenda(dto)))
    }
    fun deletar(id: Long) {
        repository.deleteById(id)
    }

    fun atualizar(id: Long, dto: VendaDTO): VendaResponseDTO {
        val venda = repository.findById(id)
            .orElseThrow { NotFoundException(VENDA_NOT_FOUND_MESSAGE) }
            .copy(
                dataVenda = dto.dataVenda,
                veiculo = dto.veiculo,
                cliente = dto.cliente,
                vendedor = dto.vendedor
            )
        return converter.toVendaResponseDTO(repository.save(venda))
    }
}