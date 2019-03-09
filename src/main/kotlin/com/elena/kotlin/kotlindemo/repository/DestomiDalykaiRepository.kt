package com.example.kotlindemo.repository

import com.example.kotlindemo.model.DestomiDalykai
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DestomiDalykaiRepository : JpaRepository<DestomiDalykai, Long>