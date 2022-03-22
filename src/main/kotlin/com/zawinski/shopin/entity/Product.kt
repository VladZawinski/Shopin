package com.zawinski.shopin.entity

import javax.persistence.*

@Entity(
        name = "product"
)
data class Product(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = -1,
        @Column(
            name = "name",
            nullable = false
        )
        val name: String,
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "category_id", nullable = false)
        val category: Category
)