package com.zawinski.shopin.controller

import com.zawinski.shopin.common.ApiResponse
import com.zawinski.shopin.dto.CategoryDto
import com.zawinski.shopin.entity.Category
import com.zawinski.shopin.mappers.toCategoryEntity
import com.zawinski.shopin.repository.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.Objects

@RestController
@RequestMapping("category")
class CategoryController {

    @Autowired
    lateinit var repository: CategoryRepository

    @PostMapping("/add")
    fun addCategory(
            @RequestBody
            category: CategoryDto
    ): ResponseEntity<ApiResponse> {

        if (repository.findByName(category.name).isPresent) {
            return ResponseEntity(ApiResponse(false,"Category already exists!"), HttpStatus.CONFLICT)
        }

        repository.save(category.toCategoryEntity())
        return ResponseEntity(ApiResponse(true,"success"), HttpStatus.OK)
    }

    @GetMapping("/all")
    fun getAllCategory(): Iterable<Category> {
        return repository.findAll()
    }
}