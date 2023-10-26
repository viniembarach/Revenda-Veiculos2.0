package br.upf.sistemaRevendaVeiculos.service

import br.upf.sistemaRevendaVeiculos.converters.PessoaConverter
import br.upf.sistemaRevendaVeiculos.dto.PessoaDTO
import br.upf.sistemaRevendaVeiculos.dto.PessoaResponseDTO
import br.upf.sistemaRevendaVeiculos.exceptions.NotFoundException
import br.upf.sistemaRevendaVeiculos.repository.PessoaRepository
import org.springframework.stereotype.Service

private const val PESSOA_NOT_FOUND_MESSAGE = "Pessoa não encontrada!"
@Service
class PessoaService(private val repository: PessoaRepository,
                     private val converter: PessoaConverter){
    fun listar(): List<PessoaResponseDTO> {
        return repository.findAll()
            .map(converter::toPessoaResponseDTO)
    }

    fun buscarPorId(id: Long): PessoaResponseDTO {
        val pessoa = repository.findById(id)
            .orElseThrow { NotFoundException(PESSOA_NOT_FOUND_MESSAGE) }
        return converter.toPessoaResponseDTO(pessoa)
    }
    fun cadastrar(dto: PessoaDTO): PessoaResponseDTO {
        return converter.toPessoaResponseDTO(
            repository.save(converter.toPessoa(dto)))
    }
    fun deletar(id: Long) {
        repository.deleteById(id)
    }

    fun atualizar(id: Long, dto: PessoaDTO): PessoaResponseDTO {
        val pessoa = repository.findById(id)
            .orElseThrow { NotFoundException(PESSOA_NOT_FOUND_MESSAGE) }
            .copy(
                cpfoucnpj = dto.cpfoucnpj,
                nome = dto.nome,
                telefone = dto.telefone,
                cidade = dto.cidade,
                endereco = dto.endereco,
                tipo = dto.tipo
            )
        return converter.toPessoaResponseDTO(repository.save(pessoa))
    }
}