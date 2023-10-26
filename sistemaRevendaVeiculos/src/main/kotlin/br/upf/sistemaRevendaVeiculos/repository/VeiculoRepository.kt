package br.upf.sistemaRevendaVeiculos.repository

import br.upf.sistemaRevendaVeiculos.model.Veiculo
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface VeiculoRepository: JpaRepository<Veiculo, Long> {
    fun findByNome(nomeVeiculo: String, paginacao: Pageable): Page<Veiculo>
}