package br.upf.sistemaRevendaVeiculos.model

import br.upf.sistemaRevendaVeiculos.dto.PessoaDTO
import br.upf.sistemaRevendaVeiculos.dto.VeiculoDTO
import jakarta.persistence.Entity
import jakarta.persistence.OneToMany
import jakarta.persistence.OneToOne
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
data class Venda(
    val id: Long? = null,
    val dataVenda: LocalDateTime = LocalDateTime.now(),
    @OneToOne(mappedBy = "id")
    val veiculo: Veiculo,
    @OneToMany(mappedBy = "id")
    val cliente: Pessoa,
    @OneToMany(mappedBy = "id")
    val vendedor: Pessoa
)

//SLIDE 7
//@Entity
//data class Inscricao(
// @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
// val id: Long? = null,
// @ManyToOne
// val usuario: Usuario,
// @ManyToOne
// val evento: Evento,
// val data: LocalDateTime = LocalDateTime.now()
//)