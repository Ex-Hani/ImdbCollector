package me.exhani.imdbcollector.entities


import com.google.gson.annotations.SerializedName

data class ImdbMostPopularMoviesItem(
    @SerializedName("id")
    val imdbId: String, // tt12361974
    @SerializedName("rank")
    val rank: String, // 1
    @SerializedName("rankUpDown")
    val rankUpDown: String, // +3
    @SerializedName("title")
    val title: String, // Zack Snyder's Justice League
    @SerializedName("fullTitle")
    val fullTitle: String, // Zack Snyder's Justice League (2021)
    @SerializedName("year")
    private val year: String, // 2021
    @SerializedName("image")
    val image: String, // https://m.media-amazon.com/images/M/MV5BYjI3NDg0ZTEtMDEwYS00YWMyLThjYjktMTNlM2NmYjc1OGRiXkEyXkFqcGdeQXVyMTEyMjM2NDc2._V1_UX128_CR0,3,128,176_AL_.jpg
    @SerializedName("crew")
    val crew: String, // Zack Snyder (dir.), Henry Cavill, Ben Affleck
    @SerializedName("imDbRating")
    val imDbRating: String, // 8.3
    @SerializedName("imDbRatingCount")
    val imDbRatingCount: String // 215423
) : Movie {

    override fun getTitile(): String {
        return fullTitle
    }

    override fun getPoster(): String {
        return image
    }

    override fun getRating(): String {
        return imDbRating
    }

    override fun getMovieId(): String {
        return imdbId
    }

    override fun getYear(): String {
        return year
    }


}