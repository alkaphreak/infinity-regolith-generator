package fr.marstech.infinityregolithgenerator.utils

import java.util.*

object RandomIdGenerator {

    val CHARSET: String = (('a'..'z') + ('A'..'Z') + ('0'..'9')).joinToString("")
    const val DEFAULT_SIZE: Int = 6
    private val random = Random()

    fun generate(length: Int = DEFAULT_SIZE): String = buildString {
        repeat(length) { append(CHARSET[random.nextInt(CHARSET.length)]) }
    }

    fun generate(prefix: String, totalLength: Int = DEFAULT_SIZE): String = prefix.trim()
        .let { it + generate(totalLength - it.length) }
}
