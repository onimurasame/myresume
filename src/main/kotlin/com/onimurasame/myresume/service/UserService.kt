package com.onimurasame.myresume.service

import com.onimurasame.myresume.configuration.Loggable
import com.onimurasame.myresume.data.User
import com.onimurasame.myresume.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.stereotype.Service
import java.util.*

@Service
@Loggable
class UserService {

    @Autowired
    private lateinit var userRepository: UserRepository

    fun getUserByUserId(id: String): Optional<User> {
        try {
            return userRepository.findById(id)
        } catch (e: EmptyResultDataAccessException) {
            return Optional.empty()
        }
    }

    fun addUser(user: User): User? {
        val storedUser: Optional<User> = getUserByUserId(user.id)

        if (storedUser.isEmpty)
            return userRepository.save(user)

        return storedUser.get()
    }
}