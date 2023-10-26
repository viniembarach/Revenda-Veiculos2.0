package br.upf.sistemaRevendaVeiculos.dto

import br.upf.sistemaRevendaVeiculos.model.StatusPessoa
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
data class PessoaDTO(
    @field:NotEmpty (message = "Pessoa sempre deve ter um CPF ou CNPJ")
    val cpfoucnpj: String,
    @field:NotEmpty (message = "Pessoa sempre deve ter um nome")
    val nome: String,
    @field:NotEmpty (message = "Deve ter um telefone")
    val telefone: String,
    @field:NotEmpty (message = "Deve ter uma cidade")
    val cidade: String,
    @field:NotEmpty (message = "Deve ter um endereço")
    val endereco: String,
    val tipo: StatusPessoa
)
