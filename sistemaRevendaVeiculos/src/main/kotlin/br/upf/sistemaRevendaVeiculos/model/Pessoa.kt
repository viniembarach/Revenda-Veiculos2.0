package br.upf.sistemaRevendaVeiculos.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany

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
    val tipo: StatusPessoa
)