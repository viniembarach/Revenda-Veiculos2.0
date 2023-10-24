package br.upf.sistemaRevendaVeiculos.repository

import br.upf.sistemaRevendaVeiculos.model.StatusPessoa
import br.upf.sistemaRevendaVeiculos.model.Pessoa
import org.springframework.stereotype.Repository

@Repository
class PessoaRepository(private var pessoas: MutableList<Pessoa>) {
    private var idCont = 4L
    init {
        val pessoa1 = Pessoa(
            id = 1,
            cpfoucnpj = "12345678932",
            nome = "Marcos Vinicius",
            telefone = "54999633214",
            cidade = "David Canabarro",
            endereco = "AV. Fabricio de Oliveira Pillar, 1287",
            tipo = StatusPessoa.CLIENTE
        )

        val pessoa2 = Pessoa(
            id = 2,
            cpfoucnpj = "12345678333",
            nome = "Carletaa",
            telefone = "54999633222",
            cidade = "David Canabarro",
            endereco = "São José",
            tipo = StatusPessoa.VENDEDOR
        )

        val pessoa3 = Pessoa(
            id = 3,
            cpfoucnpj = "12345678222",
            nome = "Algum desconhecido",
            telefone = "54999633333",
            cidade = "David Canabarro",
            endereco = "Rua Desconhecida",
            tipo = StatusPessoa.CLIENTE
        )
        pessoas = mutableListOf(pessoa1, pessoa2, pessoa3)
    }
    fun findAll() = pessoas

    fun cadastrar(pessoa: Pessoa): Pessoa {
        val pessoaComId = pessoa.copy(id = idCont++)
        pessoas.add(pessoaComId)
        return pessoaComId
    }

    fun update(pessoa: Pessoa, pessoaAtualizada: Pessoa): Pessoa {
        pessoas.remove(pessoa)
        val pessoaAtualizadaComId = Pessoa(
            id = pessoa.id,
            cpfoucnpj = pessoaAtualizada.cpfoucnpj,
            nome = pessoaAtualizada.nome,
            telefone = pessoaAtualizada.telefone,
            cidade = pessoaAtualizada.cidade,
            endereco = pessoaAtualizada.endereco,
            tipo = pessoaAtualizada.tipo
        )
        pessoas.add(pessoaAtualizadaComId)
        return pessoaAtualizadaComId
    }

    fun deletar(id: Long) {
        val pessoa = pessoas.first { it.id == id }
        pessoas.remove(pessoa)
    }

}