package br.upf.sistemaRevendaVeiculos.service

import br.upf.sistemaRevendaVeiculos.repository.PessoaRepository
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthorizationService(
    val repository: PessoaRepository
) : UserDetailsService {
    override fun loadUserByUsername(email: String) =
        repository.findByEmail(email)
}