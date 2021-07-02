package kr.me.seohuipark.noblewayback.sample

import kr.me.seohuipark.noblewayback.sample.controller.BoardController
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@SpringBootTest
class BoardControllerTest {

    private var mockMvc: MockMvc? = null

    @BeforeEach
    fun setUp(@Autowired boardController: BoardController) {
        mockMvc = MockMvcBuilders.standaloneSetup(boardController)
            .build()
    }

    fun getAllBoards() {
        mockMvc?.get("/sample/boards") {

        }?.andDo {
            print()
        }?.andExpect {
            status { isOk() }
        }
    }

    @Test
    @DisplayName("게시글 가져오기")
    fun `api to get you boards`() {
        getAllBoards()
    }

}