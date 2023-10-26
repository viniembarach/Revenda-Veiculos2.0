package br.upf.sistemaRevendaVeiculos.converters

import br.upf.sistemaRevendaVeiculos.dto.PessoaDTO
import br.upf.sistemaRevendaVeiculos.dto.PessoaResponseDTO
import br.upf.sistemaRevendaVeiculos.model.Pessoa
import org.springframework.stereotype.Component

@Component
class PessoaConverter {

    fun toPessoa(dto: PessoaDTO): Pessoa {
        return Pessoa(
            cpfoucnpj = dto.cpfoucnpj,
            nome = dto.nome,
            telefone = dto.telefone,
            cidade = dto.cidade,
            endereco = dto.endereco,
            tipo = dto.tipo
        )
    }

    fun toPessoaResponseDTO(pessoa: Pessoa): PessoaResponseDTO {
        return PessoaResponseDTO(
            id = pessoa.id,
            cpfoucnpj = pessoa.cpfoucnpj,
            nome = pessoa.nome,
            telefone = pessoa.telefone,
            cidade = pessoa.cidade,
            endereco = pessoa.endereco,
            tipo = pessoa.tipo
        )
    }
}