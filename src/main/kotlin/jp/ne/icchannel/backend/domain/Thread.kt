package jp.ne.icchannel.backend.domain

data class Thread (
    val id: Int,
    val title: String,
    val url: String,
    val siteName: String,
    val createdAt: String
)