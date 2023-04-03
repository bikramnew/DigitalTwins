package com.bikram.digitaltwins

import com.bikram.digitaltwins.model.DigitalTwin

val digitalTwins = listOf(
    DigitalTwin(
        id = "1",
        name = "n1",
        brand = "b1",
        price = "1",
        description = "d1",
        image_url = "i1",
        status = "PENDING"
    ),
    DigitalTwin(
        id = "2",
        name = "n2",
        brand = "b2",
        price = "2",
        description = "d2",
        image_url = "i2",
        status = "PENDING"
    )
)

internal fun getDigitalTwin(id: Int): DigitalTwin = digitalTwins[id]