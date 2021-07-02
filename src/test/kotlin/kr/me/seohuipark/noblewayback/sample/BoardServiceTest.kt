package kr.me.seohuipark.noblewayback.sample

import kr.me.seohuipark.noblewayback.sample.repository.rdbms.BoardRepository
import kr.me.seohuipark.noblewayback.sample.service.BoardService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertNotNull

@SpringBootTest
class BoardServiceTest(@Autowired private val boardService: BoardService,
                       @Autowired private val boardRepository: BoardRepository
) {

    @Test
    fun getAllBoardsTest() {
        // given

        // when

        // then
        val board = boardRepository.findAll()
        assertNotNull(board, "Null")
    }
}