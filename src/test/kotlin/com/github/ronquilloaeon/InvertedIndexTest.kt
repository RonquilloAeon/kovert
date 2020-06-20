package com.github.ronquilloaeon

import org.junit.Test
import kotlin.test.assertEquals

class InvertedIndexTest {
    @Test fun findDocInIndex() {
        val index = InvertedIndex(listOf("hello world", "hello friends", "goodbye for now"))

        val search1 = index.search("goodbye")

        assertEquals(1, search1.size)
        assertEquals(1, search1[0].hits)

        val search2 = index.search("hello world")

        assertEquals(2, search2.size)
        assertEquals(2, search2[0].hits)  // returns sorted by hits (desc)
        assertEquals(1, search2[1].hits)
    }

    @Test fun emptySearch() {
        val index = InvertedIndex(listOf("hello world", "hello friends"))
        assertEquals(0, index.search("").size)
    }

    @Test fun noResults() {
        val index = InvertedIndex(listOf("hello world", "hello friends"))
        assertEquals(0, index.search("kotlin").size)
    }
}