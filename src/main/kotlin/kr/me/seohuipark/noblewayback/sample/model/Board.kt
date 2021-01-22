package kr.me.seohuipark.noblewayback.sample.model

import javax.persistence.*

@Entity
data class Board(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    @Column(length = 200)
    var title: String,
    @Column(length = 2000)
    var contents: String) {
}