package com.bikram.digitaltwins.model

data class DigitalTwin(
    val id: String? = null,
    val name: String? = null,
    val brand: String? = null,
    val price: String? = null,
    val description: String? = null,
    val image_url: String? = null,
    val status: String? = null,
)

val digitalTwins = listOf(
    DigitalTwin(
        id = "1",
        name = "Wireless Bluetooth Headphones",
        brand = "Sony",
        price = "129.99",
        description = "Enjoy high-quality sound and freedom of movement with these wireless Bluetooth headphones from Sony.",
        image_url = "https://example.com/wireless-headphones.jpg",
        status = "PENDING"
    ),
    DigitalTwin(
        id = "2",
        name = "Smartwatch with GPS and Heart Rate Monitor",
        brand = "Samsung",
        price = "279.99",
        description = "Track your fitness goals and stay connected with this smartwatch from Samsung, featuring GPS and a heart rate monitor.",
        image_url = "https://example.com/smartwatch.jpg",
        status = "PENDING"
    ),
    DigitalTwin(
        id = "3",
        name = "Electric Toothbrush with Bluetooth Connectivity",
        brand = "Philips",
        price = "89.99",
        description = "Take your dental hygiene to the next level with this electric toothbrush from Philips, which features Bluetooth connectivity and personalized brushing coaching.",
        image_url = "https://example.com/toothbrush.jpg",
        status = "PENDING"
    ),
    DigitalTwin(
        id = "4",
        name = "Portable Bluetooth Speaker",
        brand = "JBL",
        price = "49.99",
        description = "Enjoy your music on the go with this portable Bluetooth speaker from JBL, which features a rechargeable battery and water-resistant design.",
        image_url = "https://example.com/portable-speaker.jpg",
        status = "PENDING"
    ),
    DigitalTwin(
        id = "5",
        name = "Wireless Charging Pad",
        brand = "Belkin",
        price = "29.99",
        description = "Charge your compatible devices without the hassle of cords with this wireless charging pad from Belkin.",
        image_url = "https://example.com/wireless-charger.jpg",
        status = "PENDING"
    ),
)