package kr.me.seohuipark.noblewayback.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider
import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.dynamodb.DynamoDbClient

@Configuration
class AwsConfig(@Value("\${aws.region}") private val region: String) {

    @Bean
    fun awsCredentialsProvider(): AwsCredentialsProvider = DefaultCredentialsProvider.builder().build()

    @Bean
    fun dynamoDbClient(): DynamoDbClient = DynamoDbClient.builder()
        .credentialsProvider(awsCredentialsProvider())
        .region(Region.of(region))
        .build()

    @Bean
    @Primary
    fun dynamoDbEnhancedClient(): DynamoDbEnhancedClient = DynamoDbEnhancedClient.builder()
        .dynamoDbClient(dynamoDbClient())
        .build()
}