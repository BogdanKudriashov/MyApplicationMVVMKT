package com.example.myapplicationmvvmkt.model

data class User(
    val id: Long,
    val name: String,
    val age: Int
)

data class UserDetails(
    val user: User,
    val details: String
)