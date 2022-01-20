package jp.ne.icchannel.backend.domain

import java.time.LocalDateTime

data class Thread (
    val id: Int,
    val title: String,
    val url: String,
    val publishedDate: LocalDateTime,
    val siteName: String
)