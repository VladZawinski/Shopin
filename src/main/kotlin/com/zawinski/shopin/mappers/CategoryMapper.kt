package com.zawinski.shopin.mappers

import com.zawinski.shopin.dto.CategoryDto
import com.zawinski.shopin.entity.Category

fun CategoryDto.toCategoryEntity() = Category(
        name = name,
        description = description
)