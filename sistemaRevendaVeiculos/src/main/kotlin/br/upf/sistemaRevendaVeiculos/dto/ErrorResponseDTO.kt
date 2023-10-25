package br.upf.sistemaRevendaVeiculos.dto

import java.sql.Timestamp
import java.time.LocalDateTime

data class ErrorResponseDTO (
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val status: Int,
    val error: String,
    val message: String,
    val path: String
)
