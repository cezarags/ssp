package br.com.dev.loja.domain.rest

import br.com.dev.loja.model.Categoria
import br.com.dev.loja.model.Produto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RequestMapping("/product")
@RestController
interface ProdutoApi {

    @PostMapping("/save")
    fun addproduct(produto: Produto): ResponseEntity<Produto>

    @PostMapping("/upload")
    fun UploadPhotograph(@RequestParam(name = "arq") arq: MultipartFile): ResponseEntity<String>

    @GetMapping()
    fun getAllProducts(): ResponseEntity<ArrayList<Produto>>


    @GetMapping("/find/search")
    fun findProduct(@RequestParam word: String): ArrayList<Produto>


    @PutMapping("/update")
    fun updateProduct(@RequestBody produto: Produto): Produto

    @GetMapping("/category/{id}")
    fun getProductCategory(@PathVariable id: Long): ResponseEntity<ArrayList<Produto>>

    @GetMapping("/{id}")
    fun getProductId(@PathVariable id: Long): ResponseEntity<Produto>

}

/*
    @GetMapping("/find")
    fun findProductAvailable(): ResponseEntity<ArrayList<Produto>>

    @GetMapping("/find")
     fun findProductUnavailable()
}*/
