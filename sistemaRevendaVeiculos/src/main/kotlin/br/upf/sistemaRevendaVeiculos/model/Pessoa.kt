package br.upf.sistemaRevendaVeiculos.model

import jakarta.persistence.*

@Entity
data class Pessoa(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val cpfoucnpj: String,
    val nome: String,
    val telefone: String,
    val cidade: String,
    val endereco: String,
    @Enumerated(value = EnumType.STRING)
    val tipo: StatusPessoa
)