package br.com.dev.loja.service.impl

import br.com.dev.loja.service.ServiceUpload
import org.hibernate.annotations.common.util.impl.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths
import java.nio.file.StandardCopyOption

@Component
class ServiceUploadImpl: ServiceUpload {

    private val log = LoggerFactory.logger(ServiceUpload::class.java)

    override fun uploadFile(arq: MultipartFile): String {
        try {
            log.info("Uploading file: {$arq}")
            var caminho: String  = "/home/dev/Imagens"
            var path: Path = Paths.get(caminho + File.separator + arq.originalFilename)
            Files.copy(arq.inputStream, path, StandardCopyOption.REPLACE_EXISTING)
            println("Debug: Arquivo copiado")
            return path.toString()

        }catch (ex: Exception){
            ex.printStackTrace()
        }

        return  null.toString()
    }
}

        // copiar p arquvio recebido via requisição para uma pasta definidação
        // e retornar o caminho dele. se der qualquer erro, retornar NULL