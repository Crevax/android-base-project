package com.github.crevax.androidbase.services.demo

class DemoService : IDemoService {
    override fun reverse(string: String): String {
        return string.reversed()
    }
}
