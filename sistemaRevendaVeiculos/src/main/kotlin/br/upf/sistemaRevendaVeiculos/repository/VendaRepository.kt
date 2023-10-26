package br.upf.sistemaRevendaVeiculos.repository

import br.upf.sistemaRevendaVeiculos.model.Venda
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface VendaRepository: JpaRepository<Venda, Long> {

}