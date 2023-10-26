package br.upf.sistemaRevendaVeiculos.repository

import br.upf.sistemaRevendaVeiculos.model.Pessoa
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface PessoaRepository: JpaRepository<Pessoa, Long> {
    fun findByNome(nomePessoa: String, paginacao: Pageable): Page<Pessoa>
}
