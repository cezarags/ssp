package br.com.dev.loja.domain.rest.controller

import br.com.dev.loja.domain.rest.ProdutoApi
import br.com.dev.loja.model.Categoria
import br.com.dev.loja.model.Produto
import br.com.dev.loja.service.ServiceUpload
import br.com.dev.loja.service.impl.ServiceCategoriaImpl

import br.com.dev.loja.service.impl.ServiceProductImpl
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile



@RestController
class ProductController(private val serviceProductImpl: ServiceProductImpl,
                        private val serviceUpload: ServiceUpload,
                        private val serviceCategoriaImpl: ServiceCategoriaImpl
                        ): ProdutoApi {

    override fun addproduct(@RequestBody produto: Produto): ResponseEntity<Produto> {
        var product: ResponseEntity<Produto>
        runCatching {
            product = serviceProductImpl.addedNewProduct(produto)
        }.onSuccess {
            return ResponseEntity.ok().build()
        }.onFailure {
            HttpStatus.BAD_REQUEST

        }.getOrNull()
        return ResponseEntity.status(201).body(produto)
    }

    override fun UploadPhotograph(arq: MultipartFile): ResponseEntity<String> {
        val path: String = serviceUpload.uploadFile(arq)
        if (path != null) {
            return ResponseEntity.status(201).body(path)
        }
        return ResponseEntity.badRequest().build()
    }


    override fun getAllProducts(): ResponseEntity<ArrayList<Produto>> {
        val list = serviceProductImpl.listProduct()
        return ResponseEntity.ok().body(list)
    }

    override fun findProduct(word: String): ArrayList<Produto> {
        TODO("Not yet implemented")
    }

    override fun updateProduct(produto: Produto): Produto {
        TODO("Not yet implemented")
    }

    override fun getProductCategory(id: Long): ResponseEntity<ArrayList<Produto>> {
        var cat = Categoria(
            id = id,
            nome = ""
        )

        val list = serviceProductImpl.listByCategory(category = cat)
        return ResponseEntity.ok().body(list)

    }

    override fun getProductId(id: Long): ResponseEntity<Produto> {
        var list: Produto? = null
        val result = runCatching { list = serviceProductImpl.listById(id)

        }.onSuccess {
            ResponseEntity.ok().body(it)

        }.onFailure {
            ResponseEntity.notFound()


        }.getOrThrow()

        return ResponseEntity.ok().body(list)
    }
}


/*     override fun findProductAvailable(): ResponseEntity<ArrayList<Produto>> {
        return ResponseEntity.ok(serviceProductImpl.availableProduct())
     }

     override fun findProductUnavailable() {
         TODO("Not yet implemented")
     }*/


