package quickr.stravaimporter.internal.service

import feign.Feign
import feign.gson.GsonDecoder
import feign.gson.GsonEncoder

internal abstract class BaseService {

    companion object {
        fun <T> buildClient(clazz: Class<T>, url: String) = Feign.builder()
            .encoder(GsonEncoder())
            .decoder(GsonDecoder())
            .target(clazz, url)
    }

}