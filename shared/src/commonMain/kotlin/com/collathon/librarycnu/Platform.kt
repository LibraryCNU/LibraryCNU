package com.collathon.librarycnu

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform