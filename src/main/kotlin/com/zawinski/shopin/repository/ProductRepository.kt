package com.zawinski.shopin.repository

import com.zawinski.shopin.entity.Product
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository: PagingAndSortingRepository<Product, Long>