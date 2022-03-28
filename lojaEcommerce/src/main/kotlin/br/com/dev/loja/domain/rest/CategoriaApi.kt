package br.com.dev.loja.domain.rest

import br.com.dev.loja.model.Categoria
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RequestMapping("/category")
@RestController
interface CategoriaApi {

    @PostMapping("/save")
    fun addCategory(@RequestBody categoria: Categoria): ResponseEntity<Categoria>


   @GetMapping("/find-all")
   fun getAllCategorys(): ResponseEntity<List<Categoria>>


   @GetMapping("/find/search")
   fun findCategory(@RequestParam word: String) : ArrayList<Categoria>


   @PutMapping("/update")
   fun updateCategory(@RequestBody categoria: Categoria){


   }



}