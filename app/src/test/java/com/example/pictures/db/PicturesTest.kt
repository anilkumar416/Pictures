package com.example.pictures.db


import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class PicturesTest {

    private lateinit var pictures: Pictures

    @Before
    fun setUp() {
        pictures = Pictures(
            1,
            "ESA/HubbleNASA",
            "2019-12-01",
            "Why does this galaxy have a ring of bright blue stars?",
            "https://apod.nasa.gov/apod/image/1912/M94_Hubble_1002.jpg",
            "image",
            "v1",
            "Starburst Galaxy M94 from Hubble",
            "https://apod.nasa.gov/apod/image/1912/M94_Hubble_960.jpg"
        )
    }

    @Test
    fun test_toString() {
        assertEquals("Starburst Galaxy M94 from Hubble", pictures.toString())
    }


}