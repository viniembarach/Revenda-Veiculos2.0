package br.upf.sistemaRevendaVeiculos.model

import jakarta.persistence.*
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

@Entity
data class Pessoa(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val cpfoucnpj: String,
    val nome: String,
    val telefone: String,
    val cidade: String,
    val endereco: String,
    val senha: String,
    val email: String,
    @Enumerated(value = EnumType.STRING)
    val tipo: StatusPessoa,
    @Enumerated(value = EnumType.STRING)
    val role: UserRole = UserRole.USER,
)  : UserDetails {
    override fun getAuthorities(): MutableList<SimpleGrantedAuthority> =
        if (role == UserRole.ADMIN) mutableListOf(
            SimpleGrantedAuthority("ROLE_ADMIN"),
            SimpleGrantedAuthority("ROLE_USER")
        )
        else mutableListOf(SimpleGrantedAuthority("ROLE_USER"))


    override fun getPassword() = senha

    override fun getUsername()= email

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true
}