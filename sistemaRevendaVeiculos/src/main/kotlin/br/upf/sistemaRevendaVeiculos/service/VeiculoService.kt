package br.upf.sistemaRevendaVeiculos.service

import br.upf.sistemaRevendaVeiculos.converters.VeiculoConverter
import br.upf.sistemaRevendaVeiculos.dto.VeiculoDTO
import br.upf.sistemaRevendaVeiculos.dto.VeiculoResponseDTO
import br.upf.sistemaRevendaVeiculos.exceptions.NotFoundException
import br.upf.sistemaRevendaVeiculos.repository.VeiculoRepository
import br.upf.sistemaRevendaVeiculos.model.Veiculo
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

private const val VEICULO_NOT_FOUND_MESSAGE = "Veiculo não encontrado!"
@Service
class VeiculoService(private val repository: VeiculoRepository,
    private val converter: VeiculoConverter){

    fun listar(nomeVeiculo: String?, paginacao: Pageable): Page<VeiculoResponseDTO> {
        val veiculos = if (nomeVeiculo == null) {
            repository.findAll(paginacao)
        } else {
            repository.findByNome(nomeVeiculo, paginacao)
        }
        return veiculos.map(converter::toVeiculoResponseDTO)
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
            .orElseThrow { NotFoundException(VEICULO_NOT_FOUND_MESSAGE) }
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