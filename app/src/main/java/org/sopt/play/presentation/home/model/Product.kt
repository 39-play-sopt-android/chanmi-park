package org.sopt.play.presentation.home.model

data class Product(
    val id: Int,
    val imageUrl: String,
    val storeName: String,
    val productName: String,
    val discountRate: Int,
    val price: String,
    val isFavorite: Boolean,
)

val dummyProducts = listOf(
    Product(
        id = 1,
        imageUrl = "",
        storeName = "트랜디어패럴",
        productName = "[카프리1위🏆/5부,7부,9부기장/MADE] 클립 스판 슬릿 바이커 카프리 데님 팬츠",
        discountRate = 36,
        price = "28,800",
        isFavorite = false,
    ),
    Product(
        id = 2,
        imageUrl = "",
        storeName = "슬로우앤드",
        productName = "[🍁가을/3기장선택!] made. 모먼트 투커버 올데이슬랙스 (+숏/베이직/롱ver) - 4 size",
        discountRate = 50,
        price = "26,820",
        isFavorite = true,
    ),
    Product(
        id = 3,
        imageUrl = "",
        storeName = "어텀",
        productName = "보울7부티셔츠",
        discountRate = 10,
        price = "17,100",
        isFavorite = false,
    ),
    Product(
        id = 4,
        imageUrl = "",
        storeName = "슬로우앤드",
        productName = "[오픈할인중] made. 도브 클래식 탄탄핏 무지셔츠 - 4 color",
        discountRate = 40,
        price = "35,200",
        isFavorite = false,
    ),
)
