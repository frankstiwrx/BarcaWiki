package com.frankstiwrx.barcawiki.data.source

import com.frankstiwrx.barcawiki.data.model.Season

object SeasonDataSource {

    val seasons = listOf(
        Season(
            id = 1,
            name = "2026/27",
            startYear = 2026,
            endYear = 2027
        ),
        Season(
            id = 2,
            name = "2025/26",
            startYear = 2025,
            endYear = 2026
        ),
        Season(
            id = 3,
            name = "2024/25",
            startYear = 2024,
            endYear = 2025
        )
    )
}