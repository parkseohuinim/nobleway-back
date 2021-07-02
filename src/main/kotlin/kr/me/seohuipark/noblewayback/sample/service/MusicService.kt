package kr.me.seohuipark.noblewayback.sample.service

import kr.me.seohuipark.noblewayback.sample.model.dynamodb.Music
import kr.me.seohuipark.noblewayback.sample.repository.dynamodb.MusicRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MusicService(@Autowired private val musicRepository: MusicRepository) {

    fun getAllMusicsDynamoDb(): List<Music> {
        return musicRepository.getAllMusicsDynamoDb()
    }

    fun getMusicByIdDynamoDb(artist: String, songTitle: String): Music {
        return musicRepository.getMusicByIdDynamoDb(artist, songTitle)
    }
}