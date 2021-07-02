package kr.me.seohuipark.noblewayback.sample.controller

import kr.me.seohuipark.noblewayback.sample.model.rdbms.Board
import kr.me.seohuipark.noblewayback.sample.model.rdbms.BoardDto
import kr.me.seohuipark.noblewayback.sample.service.BoardService
import org.apache.logging.log4j.LogManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.servlet.http.HttpServletRequest

@RestController
@RequestMapping("/sample")
class BoardController(@Autowired private val boardService: BoardService) {

    private val logger = LogManager.getLogger(BoardController::class.java)

    /// TODO: 2021/04/21 ResponseEntity, Valid 작업 추가
    @PostMapping("boards")
    fun createBoardJpa(request: HttpServletRequest,
                       @Validated @RequestBody board: Board) {
        if (logger.isDebugEnabled) logger.debug("API createBoardJpa $board")
        return boardService.createBoardJpa(board)
    }

    @PostMapping("boards2")
    fun createBoardJpaNativeQuery(request: HttpServletRequest,
                                  @Validated @RequestBody board: Board) {
        if (logger.isDebugEnabled) logger.debug("API createBoardJpaNativeQuery $board")
        return boardService.createBoardJpaNativeQuery(board)
    }

    @PostMapping("boards3")
    fun createBoardMybatis(request: HttpServletRequest,
                           @Validated @RequestBody boardDto: BoardDto) {
        if (logger.isDebugEnabled) logger.debug("API createBoardMybatis $boardDto")
        return boardService.createBoardMyBatis(boardDto)
    }

    @GetMapping("/boards")
    fun getAllBoardsJpa(): List<Board> {
        if (logger.isDebugEnabled) logger.debug("API getAllBoardsJpa")
        return boardService.getAllBoardsJpa()
    }

    @GetMapping("/boards2")
    fun getAllBoardsJpaNativeQuery(): List<Board> {
        if (logger.isDebugEnabled) logger.debug("API getAllBoardsJpaNativeQuery")
        return boardService.getAllBoardsJpaNativeQuery()
    }

    @GetMapping("/boards3")
    fun getAllBoardsMybatis(): List<BoardDto> {
        if (logger.isDebugEnabled) logger.debug("API getAllBoardsMybatis")
        return boardService.getAllBoardsMyBatis()
    }

    @GetMapping("/boards/{id}")
    fun getBoardByIdJpa(request: HttpServletRequest,
                        @PathVariable id: Long): Board {
        if (logger.isDebugEnabled) logger.debug("API getBoardByIdJpa ${id}")
        return boardService.getBoardByIdJpa(id)
    }

    @GetMapping("/boards2/{id}")
    fun getBoardByIdJpaNativeQuery(request: HttpServletRequest,
                                   @PathVariable id: Long): Board {
        if (logger.isDebugEnabled) logger.debug("API getBoardByIdJpaNativeQuery ${id}")
        return boardService.getBoardByIdJpaNativeQuery(id)
    }

    @GetMapping("/boards3/{id}")
    fun getBoardByIdMybatis(request: HttpServletRequest,
                            @PathVariable id: Long): BoardDto {
        if (logger.isDebugEnabled) logger.debug("API getBoardByIdMybatis ${id}")
        return boardService.getBoardByIdMyBatis(id)
    }

    @PutMapping("boards/{id}")
    fun updateBoardJpa(request: HttpServletRequest,
                    @PathVariable id: Long,
                    @Validated @RequestBody boardDetails: Board) {
        if (logger.isDebugEnabled) logger.debug("API updateBoardJpa ${id} ${boardDetails}")
        return boardService.updateBoardJpa(id, boardDetails)
    }

    @PutMapping("boards2/{id}")
    fun updateBoardJpaNativeQuery(request: HttpServletRequest,
                       @PathVariable id: Long,
                       @Validated @RequestBody boardDetails: Board) {
        if (logger.isDebugEnabled) logger.debug("API updateBoardJpaNativeQuery ${id} ${boardDetails}")
        return boardService.updateBoardJpaNativeQuery(id, boardDetails)
    }

    @PutMapping("boards3/{id}")
    fun updateBoardMybatis(request: HttpServletRequest,
                                  @PathVariable id: Long,
                                  @Validated @RequestBody boardDetails: BoardDto) {
        if (logger.isDebugEnabled) logger.debug("API updateBoardMybatis ${id} ${boardDetails}")
        return boardService.updateBoardMyBatis(id, boardDetails)
    }

    @DeleteMapping("boards/{id}")
    fun deleteBoardJpa(request: HttpServletRequest,
                    @PathVariable id: Long) {
        if (logger.isDebugEnabled) logger.debug("API deleteBoardJpa ${id}")
        return boardService.deleteBoardJpa(id)
    }

    @DeleteMapping("boards2/{id}")
    fun deleteBoardJpaNativeQuery(request: HttpServletRequest,
                                  @PathVariable id: Long) {
        if (logger.isDebugEnabled) logger.debug("API deleteBoardJpaNativeQuery ${id}")
        return boardService.deleteBoardJpaNativeQuery(id)
    }

    @DeleteMapping("boards3/{id}")
    fun deleteBoardMybatis(request: HttpServletRequest,
                           @PathVariable id: Long) {
        if (logger.isDebugEnabled) logger.debug("API deleteBoardMybatis ${id}")
        return boardService.deleteBoardMyBatis(id)
    }
}