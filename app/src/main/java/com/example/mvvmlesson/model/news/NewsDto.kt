package com.example.mvvmlesson.model.news


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class NewsDto(
    @SerializedName("response")
    val response: Response?
): Serializable

data class Response(
    @SerializedName("currentPage")
    val currentPage: Int?,
    @SerializedName("orderBy")
    val orderBy: String?,
    @SerializedName("pageSize")
    val pageSize: Int?,
    @SerializedName("pages")
    val pages: Int?,
    @SerializedName("results")
    val results: List<Result>?,
    @SerializedName("startIndex")
    val startIndex: Int?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("total")
    val total: Int?,
    @SerializedName("userTier")
    val userTier: String?
): Serializable


data class Result(
    @SerializedName("apiUrl")
    val apiUrl: String?,
    @SerializedName("fields")
    val fields: Fields?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("isHosted")
    val isHosted: Boolean?,
    @SerializedName("pillarId")
    val pillarId: String?,
    @SerializedName("pillarName")
    val pillarName: String?,
    @SerializedName("sectionId")
    val sectionId: String?,
    @SerializedName("sectionName")
    val sectionName: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("webPublicationDate")
    val webPublicationDate: String?,
    @SerializedName("webTitle")
    val webTitle: String?,
    @SerializedName("webUrl")
    val webUrl: String?
): Serializable

data class Fields(
    @SerializedName("body")
    val body: String?,
    @SerializedName("thumbnail")
    val thumbnail: String?
): Serializable