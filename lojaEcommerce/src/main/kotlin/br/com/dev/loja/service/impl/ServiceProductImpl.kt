package br.com.dev.loja.service.impl

import br.com.dev.loja.model.Categoria
import br.com.dev.loja.model.Produto
import br.com.dev.loja.repository.ProdutoRepository
import br.com.dev.loja.service.ServiceProduct
import org.hibernate.annotations.common.util.impl.LoggerFactory.logger
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component


@Component
class ServiceProductImpl(private val productRepository: ProdutoRepository): ServiceProduct {

    private val log = logger(ServiceProductImpl::class.java)

    override fun addedNewProduct(produto: Produto): ResponseEntity<Produto> {
        val result = runCatching {
            val product = productRepository.save(produto)


        }.onSuccess {
            log.info("product :{$produto} added with sucess ")
        }.onFailure {
            throw  Exception()
            log.info("an error while trying to save the product ")
        }
        return ResponseEntity.ok().build()
    }

    override fun changeProduct(produto: Produto) {
        try {
            productRepository.save(produto)

        } catch (ex: Exception) {
            log.info("successfully changed product")
        }
    }

    override fun listProduct(): ArrayList<Produto> {

        return productRepository.findAll() as ArrayList<Produto>
    }

    override fun productListWithKeyword(word: String): ArrayList<Produto> {
        TODO("Not yet implemented")
    }

    override fun availableProduct(): ArrayList<Produto> {
        return productRepository.findAllByDisponivel(true) as ArrayList<Produto>
    }

    override fun listByCategory(category: Categoria): ArrayList<Produto> {
        return productRepository.findByCategoria(category)//TODO CORRIGIR ESSE METODO

        /*override fun listOfUnavailableProducts(): ArrayList<Produto> {
        return productRepository.findAllByDisponivel(false) as ArrayList<Produto>
    }*/
    }

    override fun listById(id: Long): Produto {
        return productRepository.findById(id).orElse(null)
    }
}