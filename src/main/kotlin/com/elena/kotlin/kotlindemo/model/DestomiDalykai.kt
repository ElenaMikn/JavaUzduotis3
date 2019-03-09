package com.example.kotlindemo.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
data class DestomiDalykai (
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = 0,

        @get: NotBlank
        val Pavadinimas: String = "",

        @get: NotBlank
        val Destytojas: String = "",

        @get: NotBlank
        val Aprasymas: String = "",

        @get: NotBlank
        val Semestras: String = ""
)