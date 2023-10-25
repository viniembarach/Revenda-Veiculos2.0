package br.upf.sistemaRevendaVeiculos.controller

import br.upf.sistemaRevendaVeiculos.dto.PessoaDTO
import br.upf.sistemaRevendaVeiculos.dto.PessoaResponseDTO
import br.upf.sistemaRevendaVeiculos.model.StatusPessoa
import br.upf.sistemaRevendaVeiculos.model.Pessoa
import br.upf.sistemaRevendaVeiculos.service.PessoaService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriBuilder
import org.springframework.web.util.UriComponents
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping ("/pessoas")
class PessoaController(val service: PessoaService) {
    @GetMapping
    fun listar(): List<PessoaResponseDTO> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId (@PathVariable id: Long): PessoaResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastra (@RequestBody @Valid dto: PessoaDTO,
                  uriBuilder: UriComponentsBuilder
    ): ResponseEntity<PessoaResponseDTO>{
        val pessoaResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/pessoas/${pessoaResponse.id}")
            .build().toUri()
        return ResponseEntity.created(uri).body(pessoaResponse)
    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long,
                  @RequestBody @Valid dto: PessoaDTO
    ):PessoaResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }
}