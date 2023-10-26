package br.upf.sistemaRevendaVeiculos.controller

import br.upf.sistemaRevendaVeiculos.dto.VeiculoDTO
import br.upf.sistemaRevendaVeiculos.dto.VeiculoResponseDTO
import br.upf.sistemaRevendaVeiculos.service.VeiculoService
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping ("/veiculos")
class VeiculoController(val service: VeiculoService) {

    @GetMapping
    fun listar(@RequestParam(required = false) nomeVeiculo: String?, @PageableDefault(size = 10) paginacao: Pageable):
            Page<VeiculoResponseDTO> {
        return service.listar(nomeVeiculo, paginacao)
    }

    @GetMapping("/{id}")
    @Transactional
    fun buscarPorId (@PathVariable id: Long): VeiculoResponseDTO {
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    fun cadastra (@RequestBody @Valid dto: VeiculoDTO,
                  uriBuilder: UriComponentsBuilder
    ): ResponseEntity<VeiculoResponseDTO>{
        val veiculoResponse = service.cadastrar(dto)
        val uri = uriBuilder.path("/veiculos/${veiculoResponse.id}")
            .build().toUri()
        return ResponseEntity.created(uri).body(veiculoResponse)
    }

    @PutMapping("/{id}")
    @Transactional
    fun atualizar(@PathVariable id: Long,
    @RequestBody @Valid dto: VeiculoDTO
    ):VeiculoResponseDTO {
        return service.atualizar(id, dto)
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }

}