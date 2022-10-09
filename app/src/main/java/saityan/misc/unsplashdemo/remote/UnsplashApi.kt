package saityan.misc.unsplashdemo.remote

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import saityan.misc.unsplashdemo.BuildConfig
import saityan.misc.unsplashdemo.model.SearchResult
import saityan.misc.unsplashdemo.model.UnsplashImage

interface UnsplashApi {

    @Headers("Authorization: Client-ID ${BuildConfig.API_KEY}")
    @GET("/photos")
    suspend fun getAllImages(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): List<UnsplashImage>

    @Headers("Authorization: Client-ID ${BuildConfig.API_KEY}")
    @GET("/search/photos")
    suspend fun searchImages(
        @Query("query") query: String,
        @Query("per_page") perPage: Int
    ): SearchResult
}
