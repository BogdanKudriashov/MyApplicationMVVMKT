package com.example.myapplicationmvvmkt

import android.app.Application
import com.example.myapplicationmvvmkt.model.UsersService

class App: Application() {

    val usersService = UsersService()
}