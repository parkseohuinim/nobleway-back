package kr.me.seohuipark.noblewayback.sample.controller

import kr.me.seohuipark.noblewayback.sample.model.UserInfo
import org.apache.catalina.User
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.web.bind.annotation.*
import javax.annotation.PostConstruct

@RestController
@EnableAutoConfiguration(exclude = [DataSourceAutoConfiguration::class])
class UserController {

    private val userMap: MutableMap<String, UserInfo> = mutableMapOf()

    @PostConstruct
    fun init() {
        userMap["1"] = UserInfo("1", "홍길동", "123-456", "광주")
        userMap["2"] = UserInfo("2", "고길동", "324-126", "성남")
        userMap["3"] = UserInfo("3", "백길동", "214-129", "천안")
    }

    @GetMapping(path = ["/user/{id}"])
    fun getUserInfo(@PathVariable("id") id: String) = userMap[id]

    @GetMapping(path = ["user/all"])
    fun getUserInfoAll() = ArrayList<UserInfo>(userMap.values)

    @PostMapping(path = ["user/{id}"])
    fun postUserInfo(@PathVariable("id") id: String,
                     @RequestParam("name") name: String,
                     @RequestParam("phone") phone: String,
                     @RequestParam("address") address: String) {

        val userInfo = userMap[id]
        userInfo?.name = name
        userInfo?.phone = phone
        userInfo?.address = address
    }

    @PutMapping(path = ["/user/{id}"])
    fun putUserInfo(@PathVariable("id") id: String,
                    @RequestParam("name") name: String,
                    @RequestParam("phone") phone: String,
                    @RequestParam("address") address: String) {

        val userInfo = UserInfo(id, name, phone, address)
        userMap[id] = userInfo
    }

    @DeleteMapping(path = ["/user/{id}"])
    fun deleteUserInfo(@PathVariable("id") id: String) = userMap.remove(id)
}