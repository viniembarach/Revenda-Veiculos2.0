package br.upf.sistemaRevendaVeiculos.service

import br.upf.sistemaRevendaVeiculos.converters.VeiculoConverter
import br.upf.sistemaRevendaVeiculos.dto.VeiculoDTO
import br.upf.sistemaRevendaVeiculos.dto.VeiculoResponseDTO
import br.upf.sistemaRevendaVeiculos.exceptions.NotFoundException
import br.upf.sistemaRevendaVeiculos.repository.VeiculoRepository
import br.upf.sistemaRevendaVeiculos.model.Veiculo
import org.springframework.stereotype.Service

@Service
class VeiculoService(private val repository: VeiculoRepository,
    private val converter: VeiculoConverter){
    fun listar(): List<VeiculoResponseDTO> {
        return repository.findAll()
            .map(converter::toVeiculoResponseDTO)
    }

    fun buscarPorId(id: Long): VeiculoResponseDTO {
        val veiculo = repository.findAll().firstOrNull{ it.id == id }
            ?: throw NotFoundException("Veiculo não encontrado!")
        return converter.toVeiculoResponseDTO(veiculo)
    }

    fun cadastrar(dto: VeiculoDTO) : VeiculoResponseDTO {
        val veiculo = repository.cadastrar(converter.toVeiculo(dto))
                return converter.toVeiculoResponseDTO(veiculo)
    }

    fun atualizar(id: Long, dto: VeiculoDTO): VeiculoResponseDTO {
        val veiculo = repository.findAll().firstOrNull{ it.id == id}
            ?: throw NotFoundException("Veiculo não encontrado!")
        val veiculoAtualizado = repository.update(veiculo, converter.toVeiculo(dto))
        return converter.toVeiculoResponseDTO(veiculoAtualizado)
    }


    fun deletar(id: Long) {
        repository.deletar(id)
    }


}