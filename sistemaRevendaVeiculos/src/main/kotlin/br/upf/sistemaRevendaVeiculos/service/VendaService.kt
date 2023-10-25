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
        val venda = repository.findAll().firstOrNull{ it.id == id }
            ?: throw NotFoundException("Venda não encontrada!")
        return converter.toVendaResponseDTO(venda)
    }

    fun cadastrar(dto: VendaDTO) : VendaResponseDTO {
        val venda = repository.cadastrar(converter.toVenda(dto))
        return converter.toVendaResponseDTO(venda)
    }

    fun atualizar(id: Long, dto: VendaDTO): VendaResponseDTO {
        val venda = repository.findAll().firstOrNull{ it.id == id}
            ?: throw NotFoundException("Venda não encontrada!")
        val vendaAtualizada = repository.update(venda, converter.toVenda(dto))
        return converter.toVendaResponseDTO(vendaAtualizada)
    }

    fun deletar(id: Long) {
        repository.deletar(id)
    }
}