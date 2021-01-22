package kr.me.seohuipark.noblewayback

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@SpringBootApplication
class NoblewayBackApplication

fun main(args: Array<String>) {
    runApplication<NoblewayBackApplication>(*args)
}
