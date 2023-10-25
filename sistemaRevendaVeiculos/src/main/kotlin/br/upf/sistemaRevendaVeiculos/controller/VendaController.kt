package br.upf.sistemaRevendaVeiculos.controller

import br.upf.sistemaRevendaVeiculos.dto.VendaResponseDTO
import br.upf.sistemaRevendaVeiculos.dto.VendaDTO
import br.upf.sistemaRevendaVeiculos.service.VendaService
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
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping ("/vendas")
class VendaController(val service: VendaService) {
    @GetMapping
    fun listar(): List<VendaResponseDTO> {
        return service.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId (@PathVariable id: Long): VendaResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    fun cadastra (@RequestBody @Valid dto: VendaDTO,
                  uriBuilder: UriComponentsBuilder
    ): ResponseEntity<VendaResponseDTO>{
        val vendaResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/vendas/${vendaResponse.id}")
            .build().toUri()
        return ResponseEntity.created(uri).body(vendaResponse)
    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long,
                  @RequestBody @Valid dto: VendaDTO
    ):VendaResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }
}