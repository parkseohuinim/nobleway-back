package kr.me.seohuipark.noblewayback.sample.model.dynamodb

import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey

@DynamoDbBean
data class Music(
    @get:DynamoDbPartitionKey
    @get:DynamoDbAttribute("artist")
    var artist: String? = null,
    @get:DynamoDbSortKey
    @get:DynamoDbAttribute("song_title")
    var songTitle: String? = null,
    @get:DynamoDbAttribute("album_title")
    var albumTitle: String? = null,
    @get:DynamoDbAttribute("awards")
    var awards: Long? = null) {
}