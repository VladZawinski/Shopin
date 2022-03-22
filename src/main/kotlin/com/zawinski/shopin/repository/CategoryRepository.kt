package com.zawinski.shopin.repository

import com.zawinski.shopin.entity.Category
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface CategoryRepository: PagingAndSortingRepository<Category, Long> {
    fun findByName(name: String): Optional<Category>
}