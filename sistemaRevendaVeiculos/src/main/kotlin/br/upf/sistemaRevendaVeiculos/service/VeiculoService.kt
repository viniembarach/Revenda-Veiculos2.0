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
        val veiculo = repository.findById(id)
            .orElseThrow { NotFoundException(VEICULO_NOT_FOUND_MESSAGE) }
        return converter.toVeiculoResponseDTO(veiculo)
    }
    fun cadastrar(dto: VeiculoDTO): VeiculoResponseDTO {
        return converter.toVeiculoResponseDTO(
            repository.save(converter.toVeiculo(dto)))
    }
    fun deletar(id: Long) {
        repository.deleteById(id)
    }

    fun atualizar(id: Long, dto: VeiculoDTO): VeiculoResponseDTO {
        val veiculo = repository.findById(id)
            .orElseThrow { NotFoundException(VENDA_NOT_FOUND_MESSAGE) }
            .copy(
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
        return converter.toVeiculoResponseDTO(repository.save(veiculo))
    }
}