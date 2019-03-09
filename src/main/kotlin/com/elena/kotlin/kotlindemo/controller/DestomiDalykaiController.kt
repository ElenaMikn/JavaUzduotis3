package com.example.kotlindemo.controller

import com.example.kotlindemo.model.DestomiDalykai
import com.example.kotlindemo.repository.DestomiDalykaiRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class DestomiDalykaiController(private val destomiDalykaiRepository: DestomiDalykaiRepository) {

    @GetMapping("/destomiDalykai")
    fun getAllDestomiDalykai(): List<DestomiDalykai> =
            destomiDalykaiRepository.findAll()


    @PostMapping("/destomiDalykai")
    fun createNewDestomiDalykai(@Valid @RequestBody destomiDalykai: DestomiDalykai): DestomiDalykai =
            destomiDalykaiRepository.save(destomiDalykai)


    @GetMapping("/destomiDalykai/{id}")
    fun getDestomiDalykaiById(@PathVariable(value = "id") destomiDalykaiId: Long): ResponseEntity<DestomiDalykai> {
        return destomiDalykaiRepository.findById(destomiDalykaiId).map { destomiDalykai ->
            ResponseEntity.ok(destomiDalykai)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PutMapping("/destomiDalykai/{id}")
    fun updateDestomiDalykaiById(@PathVariable(value = "id") destomiDalykaiId: Long,
                          @Valid @RequestBody newDestomiDalykai: DestomiDalykai): ResponseEntity<DestomiDalykai> {

        return destomiDalykaiRepository.findById(destomiDalykaiId).map { existingDestomiDalykai ->
            val updatedDestomiDalykai: DestomiDalykai = existingDestomiDalykai
                    .copy(Pavadinimas = newDestomiDalykai.Pavadinimas, Destytojas = newDestomiDalykai.Destytojas, Aprasymas = newDestomiDalykai.Aprasymas, Semestras = newDestomiDalykai.Semestras)
            ResponseEntity.ok().body(destomiDalykaiRepository.save(updatedDestomiDalykai))
        }.orElse(ResponseEntity.notFound().build())

    }

    @DeleteMapping("/destomiDalykai/{id}")
    fun deleteDestomiDalykaiById(@PathVariable(value = "id") destomiDalykaiId: Long): ResponseEntity<Void> {

        return destomiDalykaiRepository.findById(destomiDalykaiId).map { destomiDalykai  ->
            destomiDalykaiRepository.delete(destomiDalykai)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())

    }
}