package com.github.ronquilloaeon

data class SearchResult(val document: String, val hits: Int)

class InvertedIndex(val documents: List<String> = mutableListOf<String>()) {
    private val index: MutableMap<String, List<Int>> = mutableMapOf()

    fun addDocument(document: String) {

    }

    fun find(document: String) : List<SearchResult> {
        return listOf()
    }
}
