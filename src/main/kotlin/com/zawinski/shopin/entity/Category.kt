package com.zawinski.shopin.entity

import javax.persistence.*

@Entity
@Table(name = "category")
data class Category(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = -1,
        @Column(name = "category_name", nullable = false)
        val name: String,
        @Column(name = "description", nullable = false)
        val description: String
)