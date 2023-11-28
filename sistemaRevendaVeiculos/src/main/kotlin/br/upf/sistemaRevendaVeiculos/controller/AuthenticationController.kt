package br.upf.sistemaRevendaVeiculos.controller

import br.upf.sistemaRevendaVeiculos.dto.LoginDTO
import br.upf.sistemaRevendaVeiculos.dto.LoginResponseDTO
import br.upf.sistemaRevendaVeiculos.dto.PessoaDTO
import br.upf.sistemaRevendaVeiculos.model.Pessoa
import br.upf.sistemaRevendaVeiculos.service.TokenService
import br.upf.sistemaRevendaVeiculos.service.PessoaService
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("auth")
class AuthenticationController(
    val authenticationManager: AuthenticationManager,
    val service: PessoaService,
    val tokenService: TokenService) {

    @PostMapping("/login")
    fun login(@RequestBody data: LoginDTO): ResponseEntity<LoginResponseDTO> {
        val userPassword = UsernamePasswordAuthenticationToken(
            data.login, data.password)
        val auth = authenticationManager.authenticate(userPassword)
        val token = tokenService.generateToken(auth.principal as Pessoa)
        return ResponseEntity.ok(LoginResponseDTO(token))
    }

    @PostMapping("/register")
    fun login(@RequestBody data: PessoaDTO): ResponseEntity<String> {
        service.cadastrar(data)
        return ResponseEntity.ok().build()
    }
}