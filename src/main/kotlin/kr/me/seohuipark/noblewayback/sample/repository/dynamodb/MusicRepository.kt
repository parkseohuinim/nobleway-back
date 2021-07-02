package kr.me.seohuipark.noblewayback.sample.repository.dynamodb

import kr.me.seohuipark.noblewayback.sample.model.dynamodb.Music
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Repository
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.enhanced.dynamodb.Key
import software.amazon.awssdk.enhanced.dynamodb.TableSchema
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest
import software.amazon.awssdk.services.dynamodb.model.AttributeValue

@Repository
class MusicRepository(@Autowired private val dynamoDbEnhancedClient: DynamoDbEnhancedClient,
                      @Value("\${aws.dynamodb.table.music}") private val tableName: String) {

    private val logger = LogManager.getLogger(MusicRepository::class.java)

    private val dynamoDbTable = dynamoDbEnhancedClient.table(tableName, TableSchema.fromBean(Music::class.java))

    fun getAllMusicsDynamoDb(): List<Music> {
        return try {
            dynamoDbTable.scan().items().toList()
        } catch (e: Exception) {
            logger.error("Failed to get music list", e)
            listOf()
        }
    }

    fun getMusicByIdDynamoDb(artist: String, songTitle: String): Music {
        val key = Key.builder()
            .partitionValue(artist)
            .sortValue(songTitle)
                .build()

        return dynamoDbTable.getItem(key)
    }
}