package br.upf.sistemaRevendaVeiculos.dto

import br.upf.sistemaRevendaVeiculos.model.StatusPessoa

data class PessoaResponseDTO(
    val id: Long?,
    val cpfoucnpj: String,
    val nome: String,
    val telefone: String,
    val cidade: String,
    val endereco: String,
    val tipo: StatusPessoa,
    val email: String
)
