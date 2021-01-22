package kr.me.seohuipark.noblewayback.sample.service

import kr.me.seohuipark.noblewayback.sample.model.Board
import kr.me.seohuipark.noblewayback.sample.repository.BoardRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*
import kotlin.collections.ArrayList

@Service
class BoardService(@Autowired private val boardRepository: BoardRepository) {

    fun getBoard(boardId: Long): Board {
        return boardId.let { boardRepository.findById(it).orElse(null) }
    }

    fun getBoardList(): List<Board> {
        return boardRepository.findAll()
    }
}