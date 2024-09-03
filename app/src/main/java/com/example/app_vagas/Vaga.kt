package com.example.app_vagas

open class Vaga(
    val id: Long,
    val titulo: String,
    val descricao: String?,
    val tipoVaga: String?,
    val horarioTrabalho: String?,
    val modeloDeContratacao: String?
) {
}