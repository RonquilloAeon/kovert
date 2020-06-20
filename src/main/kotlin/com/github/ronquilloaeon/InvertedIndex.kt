package com.github.ronquilloaeon

data class SearchResult(val document: String, val hits: Int)

class InvertedIndex(documents: List<String> = mutableListOf<String>()) {
    private val index: MutableMap<String, MutableSet<Int>> = mutableMapOf()
    private val docs: MutableMap<Int, String> = mutableMapOf()

    init {
        documents.forEach {
            addToIndex(it)
        }
    }

    fun addDocument(document: String) {
        addToIndex(document)
    }

    private fun addToIndex(document: String) {
        val docHash = document.hashCode()

        // Save doc
        docs[docHash] = document

        // Add to index
        splitDocument(document).forEach {token ->

            if (token !in index) {
                index[token] = mutableSetOf(docHash)
            } else {
                index[token]?.add(docHash)
            }
        }
    }

    fun search(document: String) : List<SearchResult> {
        val matchedDocuments = mutableMapOf<Int, Int>()

        splitDocument(document).forEach { token ->
            index[token]?.forEach {docHash ->
                matchedDocuments.put(docHash, matchedDocuments.getOrPut(docHash){ 0 } + 1)
            }
        }

        val results = matchedDocuments.map {
            SearchResult(docs[it.key]!!, it.value)
        }

        return results.sortedByDescending { it.hits }
    }

    private fun splitDocument(document: String) : List<String> {
        /**
         * Split document by non alphanumeric then trim tokens and make lowercase
         * Skip empty tokens
         */
        return document.split("[^a-zA-Z0-9]".toRegex()).map {
            it.trim().decapitalize()
        }.filter { it.isNotBlank() }
    }
}
