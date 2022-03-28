package br.com.dev.loja.service

import org.springframework.web.multipart.MultipartFile

interface ServiceUpload {

    fun uploadFile( arq : MultipartFile): String


}