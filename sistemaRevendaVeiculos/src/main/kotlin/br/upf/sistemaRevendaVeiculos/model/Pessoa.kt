package br.upf.sistemaRevendaVeiculos.model

data class Pessoa(
    val id: Long? = null,
    val cpfoucnpj: String,
    val nome: String,
    val telefone: String,
    val cidade: String,
    val endereco: String,
    val tipo: StatusPessoa
)
