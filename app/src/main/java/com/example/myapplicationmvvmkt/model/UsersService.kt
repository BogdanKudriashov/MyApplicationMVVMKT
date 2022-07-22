package com.example.myapplicationmvvmkt.model

import com.example.myapplicationmvvmkt.UserNotFoundException
import java.util.*

typealias UsersListener = (user : List<User>) -> Unit

class UsersService {

    private var users : MutableList<User> = mutableListOf<User>()

    private val listeners = mutableSetOf<UsersListener>()

    init {
        users = (0..16).map { User(
            id = it.toLong(),
            name = NAMES[it],
            age = AGES[it]
        ) }.toMutableList()
    }

    fun getUsers(): List<User> {
        return users
    }

    fun getById(id: Long): UserDetails {
        val user = users.firstOrNull { it.id == id } ?: throw UserNotFoundException()
        return UserDetails(
            user = user,
            details = "More, more, more details..."
        )
    }

    fun deleteUser(user : User) {
        val indexToDelete = users.indexOfFirst { it.id == user.id }
        if (indexToDelete != -1) {
            users.removeAt(indexToDelete)
            notifyChanges()
        }
    }

    fun moveUser(user: User, moveBy: Int) {
        val oldIndex = users.indexOfFirst { it.id == user.id }
        if (oldIndex == -1) return
        val newIndex = oldIndex + moveBy
        if (newIndex < 0 || newIndex >= users.size) return
        Collections.swap(users, oldIndex, newIndex)
        notifyChanges()
    }

    fun addListener(listener: UsersListener) {
        listeners.add(listener)
        listener.invoke(users)
    }

    fun removeListener(listener: UsersListener) {
        listeners.remove(listener)
    }

    private fun notifyChanges() {
        listeners.forEach { it.invoke(users) }
    }

    companion object {
        private val NAMES = mutableListOf(
            "John",
            "Bob",
            "Steve",
            "Michael",
            "Oliver",
            "Bryan",
            "Arnold",
            "Silvester",
            "Jackie",
            "Mary",
            "Sonya",
            "Suzana",
            "Jessica",
            "Marylin",
            "Angelina",
            "Tatyana",
            "Irina"
        )
        private val AGES = mutableListOf(
            20,
            33,
            26,
            47,
            61,
            35,
            70,
            68,
            58,
            45,
            18,
            60,
            7,
            85,
            51,
            48,
            55
        )
    }
}