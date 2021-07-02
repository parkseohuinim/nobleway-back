package kr.me.seohuipark.noblewayback

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class NoblewayBackApplication

fun main(args: Array<String>) {
    val logger: Logger = LogManager.getLogger(NoblewayBackApplication::class.java)

    runApplication<NoblewayBackApplication>(*args)

    logger.debug("Hey, NoblewayApp i am Log4j2!")
}