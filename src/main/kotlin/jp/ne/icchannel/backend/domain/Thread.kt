package jp.ne.icchannel.backend.domain

import java.time.LocalDateTime

data class Thread (
    val id: String?,
    val title: String,
    val url: String,
    val publishedDate: LocalDateTime,
    val category: String,
    val siteName: String
)