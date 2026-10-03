package com.frankstiwrx.barcawiki.data.source

import com.frankstiwrx.barcawiki.data.model.Player

object PlayerDataSource {

    val players = listOf(

        Player(
            id = 1,
            name = "Iñaki Peña",
            fullName = "Ignacio Peña Sotorres",
            nationality = "Espanha",
            position = "Goleiro"
        ),

        Player(
            id = 2,
            name = "Pau Cubarsí",
            fullName = "Pau Cubarsí Paredes",
            nationality = "Espanha",
            position = "Defensor"
        ),

        Player(
            id = 3,
            name = "Pedri",
            fullName = "Pedro González López",
            nationality = "Espanha",
            position = "Meio-campista"
        ),

        Player(
            id = 4,
            name = "Lamine Yamal",
            fullName = "Lamine Yamal Nasraoui Ebana",
            nationality = "Espanha",
            position = "Atacante"
        ),

        Player(
            id = 5,
            name = "Raphinha",
            fullName = "Raphael Dias Belloli",
            nationality = "Brasil",
            position = "Atacante"
        )
    )
}