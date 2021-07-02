package kr.me.seohuipark.noblewayback.sample.service

import kr.me.seohuipark.noblewayback.sample.model.rdbms.Board
import kr.me.seohuipark.noblewayback.sample.model.rdbms.BoardDto
import kr.me.seohuipark.noblewayback.sample.repository.rdbms.BoardRepository
import kr.me.seohuipark.noblewayback.sample.repository.rdbms.BoardSqlMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BoardService(@Autowired private val boardRepository: BoardRepository,
                   @Autowired private val boardSqlMapper: BoardSqlMapper) {

    fun createBoardJpa(board: Board) {
        board.let { boardRepository.save(board) }
    }

    fun createBoardJpaNativeQuery(board: Board) {
        board.let {
            val title = it.title
            val contents = it.contents
            boardRepository.createBoardJpaNativeQuery(title, contents)
        }
    }

    fun createBoardMyBatis(boardDto: BoardDto) {
        boardDto.let { boardSqlMapper.createBoardMyBatis(boardDto) }
    }

    fun getAllBoardsJpa(): List<Board> {
        return boardRepository.findAll()
    }

    fun getAllBoardsJpaNativeQuery(): List<Board> {
        return boardRepository.getAllBoardsJpaNativeQuery()
    }

    fun getAllBoardsMyBatis(): List<BoardDto> {
        return boardSqlMapper.getAllBoardsMyBatis()
    }

    fun getBoardByIdJpa(id: Long): Board {
        return id.let { boardRepository.findById(it).orElseThrow() }
    }

    fun getBoardByIdJpaNativeQuery(id: Long): Board {
        return id.let { boardRepository.getBoardByIdJpaNativeQuery(it) }
    }

    fun getBoardByIdMyBatis(id: Long): BoardDto {
        return id.let { boardSqlMapper.getBoardByIdMyBatis(it) }
    }

    fun updateBoardJpa(id: Long, boardDetails: Board) {
        boardRepository.findById(id).orElseThrow().let {
            it.title = boardDetails.title
            it.contents = boardDetails.contents
            boardRepository.save(it)
        }
    }

    fun updateBoardJpaNativeQuery(id: Long, boardDetails: Board) {
        boardRepository.getBoardByIdJpaNativeQuery(id).let {
            val title = boardDetails.title
            val contents = boardDetails.contents
            boardRepository.updateBoardJpaNativeQuery(title, contents, it.id)
        }
    }

    fun updateBoardMyBatis(id: Long, boardDetails: BoardDto) {
        boardSqlMapper.getBoardByIdMyBatis(id).let {
            boardDetails.id = it.id
            boardSqlMapper.updateBoardMyBatis(boardDetails)
        }
    }

    fun deleteBoardJpa(id: Long) {
        boardRepository.findById(id).orElseThrow().let { boardRepository.delete(it) }
    }

    fun deleteBoardJpaNativeQuery(id: Long) {
        boardRepository.getBoardByIdJpaNativeQuery(id).let { boardRepository.deleteBoardJpaNativeQuery(it.id) }
    }

    fun deleteBoardMyBatis(id: Long) {
        boardSqlMapper.getBoardByIdMyBatis(id).let { boardSqlMapper.deleteBoardMyBatis(it.id) }
    }
}