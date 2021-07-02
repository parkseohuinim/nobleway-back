package kr.me.seohuipark.noblewayback.sample.repository.rdbms

import kr.me.seohuipark.noblewayback.sample.model.rdbms.Board
import kr.me.seohuipark.noblewayback.sample.model.rdbms.BoardDto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface BoardRepository: JpaRepository<Board, Long> {

    fun save(board: Board)

    @Modifying
    @Transactional
    @Query(value =
            " INSERT INTO board (title, contents) " +
            " VALUES(:title, :contents) ",
            nativeQuery = true)
    fun createBoardJpaNativeQuery(title: String, contents: String)

    @Query(value =
    " SELECT * " +
            " FROM board bd ",
        nativeQuery = true)
    fun getAllBoardsJpaNativeQuery(): List<Board>

    @Query(value =
    " SELECT * " +
            " FROM board bd " +
            " WHERE bd.id = :id ",
        nativeQuery = true)
    fun getBoardByIdJpaNativeQuery(id: Long): Board

    @Modifying
    @Transactional
    @Query(value =
            " UPDATE board bd " +
            " SET bd.title = ?, bd.contents = ? " +
            " WHERE bd.id = ? ",
            nativeQuery = true)
    fun updateBoardJpaNativeQuery(title: String, contents: String, id: Long)

    @Query(value =
            " DELETE " +
            " FROM board " +
            " WHERE id = ? ",
            nativeQuery = true)
    fun deleteBoardJpaNativeQuery(id: Long)
}