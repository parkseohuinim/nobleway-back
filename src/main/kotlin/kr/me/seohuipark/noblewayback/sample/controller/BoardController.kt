package kr.me.seohuipark.noblewayback.sample.controller

import kr.me.seohuipark.noblewayback.sample.model.Board
import kr.me.seohuipark.noblewayback.sample.service.BoardService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/board")
@Validated
class BoardController(@Autowired private val boardService: BoardService) {

    @GetMapping(path = ["{boardId}"])
    fun getBoard(
        request: HttpServletRequest, @PathVariable boardId: Long): Board {
        return boardService.getBoard(boardId)
    }

    @GetMapping
    fun getBoardList(): List<Board> {
        return boardService.getBoardList()
    }
}