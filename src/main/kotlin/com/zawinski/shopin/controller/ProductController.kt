package com.zawinski.shopin.controller

import com.zawinski.shopin.common.ApiResponse
import com.zawinski.shopin.dto.ProductDto
import com.zawinski.shopin.entity.Product
import com.zawinski.shopin.mappers.toProductEntity
import com.zawinski.shopin.repository.CategoryRepository
import com.zawinski.shopin.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.Objects

@RestController
@RequestMapping("/products")
class ProductController {

    @Autowired
    lateinit var productRepository: ProductRepository
    @Autowired
    lateinit var categoryRepository: CategoryRepository

    @GetMapping("/all")
    fun getPaginatedProducts(
    ): List<Product> {
        return productRepository.findAll().toList()
    }

    @PostMapping("/add")
    fun addProduct(@RequestBody product: ProductDto): ResponseEntity<ApiResponse> {
        val category = categoryRepository.findById(product.categoryId)

        if (Objects.isNull(category)){
            return ResponseEntity(ApiResponse(false, "Category does not exists!"), HttpStatus.NOT_FOUND)
        }

        productRepository.save(product.toProductEntity(category.get()))
        return ResponseEntity(ApiResponse(true, "Product created!"), HttpStatus.OK)
    }
}