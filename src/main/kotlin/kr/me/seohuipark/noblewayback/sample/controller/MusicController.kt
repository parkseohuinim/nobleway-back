package kr.me.seohuipark.noblewayback.sample.controller

import kr.me.seohuipark.noblewayback.sample.model.dynamodb.Music
import kr.me.seohuipark.noblewayback.sample.service.MusicService
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/sample")
class MusicController(@Autowired private val musicService: MusicService) {

    private val logger = LogManager.getLogger(BoardController::class.java)

    @GetMapping("/musics")
    fun getAllMusicsDynamodb(): List<Music>? {
        if (logger.isDebugEnabled) logger.debug("API getAllMusicsDynamodb")
        return musicService.getAllMusicsDynamoDb()
    }

    @GetMapping("/musics/{artist}/{songTitle}")
    fun getMusicByIdDynamoDb(request: HttpServletRequest,
                             @PathVariable artist: String,
                             @PathVariable songTitle: String): Music {
        if (logger.isDebugEnabled) logger.debug("API getMusicByIdDynamoDb ${artist} ${songTitle}")
        return musicService.getMusicByIdDynamoDb(artist, songTitle)
    }
}