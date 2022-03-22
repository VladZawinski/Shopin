package com.zawinski.shopin.mappers

import com.zawinski.shopin.dto.ProductDto
import com.zawinski.shopin.entity.Category
import com.zawinski.shopin.entity.Product

fun ProductDto.toProductEntity(category: Category) = Product(
        name = name,
        category = category
)