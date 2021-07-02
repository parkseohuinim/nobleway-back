package kr.me.seohuipark.noblewayback.sample.repository.rdbms

import kr.me.seohuipark.noblewayback.sample.model.rdbms.BoardDto
import org.apache.ibatis.annotations.Mapper

@Mapper
interface BoardSqlMapper {

    fun createBoardMyBatis(boardDto: BoardDto)
    fun getAllBoardsMyBatis(): List<BoardDto>
    fun getBoardByIdMyBatis(id: Long): BoardDto
    fun updateBoardMyBatis(boardDto: BoardDto)
    fun deleteBoardMyBatis(id: Long)
}