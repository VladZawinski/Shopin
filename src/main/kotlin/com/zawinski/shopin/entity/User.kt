package com.zawinski.shopin.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "user")
data class User(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        @Column(name = "username")
        val username: String,
        @Column(name = "email")
        val email: String,
        @Column(name = "password")
        val password: String,
        @Column(name = "address")
        val address: String
)