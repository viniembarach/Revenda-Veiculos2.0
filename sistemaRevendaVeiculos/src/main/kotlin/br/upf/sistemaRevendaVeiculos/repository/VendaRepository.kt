package br.upf.sistemaRevendaVeiculos.repository

import br.upf.sistemaRevendaVeiculos.model.StatusPessoa
import br.upf.sistemaRevendaVeiculos.model.Pessoa
import br.upf.sistemaRevendaVeiculos.model.Venda
import org.springframework.stereotype.Repository
import java.time.LocalDate

@Repository
class VendaRepository(private var vendas: MutableList<Venda>) {
    private var idCont = 4L
    /*init {
        val hoje = LocalDate.now()
        val venda1 = Venda(
            id = 1,
            dataVenda = hoje,
            veiculo = 1,
            cliente = 1,
            vendedor = 2
        )

        val venda2 = Venda(
            id = 2,
            dataVenda = hoje,
            veiculo = 3,
            cliente = 1,
            vendedor = 2
        )

        val venda3 = Venda(
            id = 3,
            dataVenda = hoje,
            veiculo = 2,
            cliente = 1,
            vendedor = 2
        )
        vendas = mutableListOf(venda1, venda2, venda3)
    }*/
    fun findAll() = vendas

    fun cadastrar(venda: Venda): Venda {
        val vendaComId = venda.copy(id = idCont++)
        vendas.add(vendaComId)
        return vendaComId
    }

    fun update(venda: Venda, vendaAtualizada: Venda): Venda {
        vendas.remove(venda)
        val vendaAtualizadaComId = Venda(
            id = venda.id,
            dataVenda = vendaAtualizada.dataVenda,
            veiculo = vendaAtualizada.veiculo,
            cliente = vendaAtualizada.cliente,
            vendedor = vendaAtualizada.vendedor,
        )
        vendas.add(vendaAtualizadaComId)
        return vendaAtualizadaComId
    }

    fun deletar(id: Long) {
        val venda = vendas.first { it.id == id }
        vendas.remove(venda)
    }

}