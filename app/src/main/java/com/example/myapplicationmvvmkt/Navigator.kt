package com.example.myapplicationmvvmkt

import com.example.myapplicationmvvmkt.model.User

interface Navigator {

    fun showDetails(user: User)

    fun goBack()

    fun toast(messageRes: Int)

}