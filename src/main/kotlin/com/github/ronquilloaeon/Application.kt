package com.github.ronquilloaeon

fun main(args: Array<String>) {
    val documents = listOf(
            "Do you have a vision?",
            "Why, hello there!",
            "Hello world, my name is Kotlin",
            "3, 2, 1! Liftoff!"
    )

    val index = InvertedIndex(documents)

    listOf(
            "Hello world",
            "What is your name?",
            "Something new",
            "I am Kotlin",
            ""
    ).forEach { search ->
        println("Searching for '$search'")

        index.search(search).forEach {result ->
            println("Found: [${result.hits}] '${result.document}'")
        }

        println()
    }
}
