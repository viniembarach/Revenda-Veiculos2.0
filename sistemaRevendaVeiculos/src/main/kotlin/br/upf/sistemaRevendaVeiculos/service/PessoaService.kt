package br.upf.sistemaRevendaVeiculos.service

import br.upf.sistemaRevendaVeiculos.converters.PessoaConverter
import br.upf.sistemaRevendaVeiculos.dto.PessoaDTO
import br.upf.sistemaRevendaVeiculos.dto.PessoaResponseDTO
import br.upf.sistemaRevendaVeiculos.exceptions.NotFoundException
import br.upf.sistemaRevendaVeiculos.repository.PessoaRepository
import br.upf.sistemaRevendaVeiculos.model.Pessoa
import org.springframework.stereotype.Service

@Service
class PessoaService(private val repository: PessoaRepository,
                     private val converter: PessoaConverter){
    fun listar(): List<PessoaResponseDTO> {
        return repository.findAll()
            .map(converter::toPessoaResponseDTO)
    }

    fun buscarPorId(id: Long): PessoaResponseDTO {
        val pessoa = repository.findAll().firstOrNull{ it.id == id }
            ?: throw NotFoundException("Pessoa não encontrada!")
        return converter.toPessoaResponseDTO(pessoa)
    }

    fun cadastrar(dto: PessoaDTO) : PessoaResponseDTO {
        val pessoa = repository.cadastrar(converter.toPessoa(dto))
        return converter.toPessoaResponseDTO(pessoa)
    }

    fun atualizar(id: Long, dto: PessoaDTO): PessoaResponseDTO {
        val pessoa = repository.findAll().firstOrNull{ it.id == id}
            ?: throw NotFoundException("Pessoa não encontrada!")
        val pessoaAtualizada = repository.update(pessoa, converter.toPessoa(dto))
        return converter.toPessoaResponseDTO(pessoaAtualizada)
    }

    fun deletar(id: Long) {
        repository.deletar(id)
    }
}