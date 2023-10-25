package br.upf.sistemaRevendaVeiculos.repository

import br.upf.sistemaRevendaVeiculos.dto.VeiculoDTO
import br.upf.sistemaRevendaVeiculos.model.StatusVeiculo
import br.upf.sistemaRevendaVeiculos.model.Veiculo
import br.upf.sistemaRevendaVeiculos.model.Venda
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface VeiculoRepository: JpaRepository<Veiculo, Long> {
//    init {
//        val veiculo1 = Veiculo(
//            id = 1,
//            placa = "JYV8B14",
//            nome = "F-250",
//            modelo = "XLT-G",
//            precoCompra = 74000,
//            precoVenda = 90000,
//            anoFabri = 1999,
//            anoMod = 1999,
//            cor = "Verde",
//            kmRodado = 320000,
//            fabricante = "Ford",
//            tipoVeiculo = "Camionete",
//            status = StatusVeiculo.EMESTOQUE,
//        )
//
//        val veiculo2 = Veiculo(
//            id = 2,
//            placa = "IVF3028",
//            nome = "Corolla",
//            modelo = "Xei",
//            precoCompra = 59000,
//            precoVenda = 70000,
//            anoFabri = 2014,
//            anoMod = 2014,
//            cor = "Branco",
//            kmRodado = 80000,
//            fabricante = "Toyota",
//            tipoVeiculo = "Passeio",
//            status = StatusVeiculo.EMESTOQUE,
//        )
//
//        val veiculo3 = Veiculo(
//            id = 3,
//            placa = "IZD8I32",
//            nome = "Bros",
//            modelo = "Essd",
//            precoCompra = 15600,
//            precoVenda = 17000,
//            anoFabri = 2019,
//            anoMod = 2020,
//            cor = "Vermelha",
//            kmRodado = 7315,
//            fabricante = "Honda",
//            tipoVeiculo = "Moto",
//            status = StatusVeiculo.VENDIDO,
//        )
//    veiculos = mutableListOf(veiculo1, veiculo2, veiculo3)
//    }
//    fun findAll() = veiculos
//    private var idCont = 4L
//
//    fun cadastrar(veiculo: Veiculo): Veiculo {
//        val veiculoComId = veiculo.copy(id = idCont++)
//        veiculos.add(veiculoComId)
//        return veiculoComId
//    }
//
//    fun update(veiculo: Veiculo, veiculoAtualizado: Veiculo): Veiculo {
//        veiculos.remove(veiculo)
//        val veiculoAtualizadoComId = Veiculo(
//                id = veiculo.id,
//                placa = veiculoAtualizado.placa,
//                nome = veiculoAtualizado.nome,
//                modelo = veiculoAtualizado.modelo,
//                precoCompra = veiculoAtualizado.precoCompra,
//                precoVenda = veiculoAtualizado.precoVenda,
//                anoFabri = veiculoAtualizado.anoFabri,
//                anoMod = veiculoAtualizado.anoMod,
//                cor = veiculoAtualizado.cor,
//                kmRodado = veiculoAtualizado.kmRodado,
//                fabricante = veiculoAtualizado.fabricante,
//                tipoVeiculo = veiculoAtualizado.tipoVeiculo,
//                status = veiculoAtualizado.status
//            )
//        veiculos.add(veiculoAtualizadoComId)
//        return veiculoAtualizadoComId
//    }
//
//    fun deletar(id: Long) {
//        val veiculo = veiculos.first { it.id == id }
//        veiculos.remove(veiculo)
//    }

}

//SLIDE PROFESSOR
//@Repository
//interface UsuarioRepository: JpaRepository<Usuario, Long> {
//}