package kr.me.seohuipark.noblewayback.sample.repository

import kr.me.seohuipark.noblewayback.sample.model.Board
import org.springframework.data.jpa.repository.JpaRepository

interface BoardRepository : JpaRepository<Board, Long> {

}