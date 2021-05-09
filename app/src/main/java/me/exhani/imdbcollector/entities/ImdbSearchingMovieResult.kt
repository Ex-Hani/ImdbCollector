package me.exhani.imdbcollector.entities


import com.google.gson.annotations.SerializedName

data class ImdbSearchingMovieResult(
    @SerializedName("id")
    val id: String, // tt1754539
    @SerializedName("resultType")
    val resultType: String, // Title
    @SerializedName("image")
    val image: String, // https://imdb-api.com/images/original/MV5BMjI0NDkxNzg2NF5BMl5BanBnXkFtZTcwODUzOTM1OA@@._V1_Ratio0.7727_AL_.jpg
    @SerializedName("title")
    val title: String, // Steve
    @SerializedName("description")
    val description: String // (2010) (Short)
) : Movie {

    override fun getTitile(): String {
        return title
    }

    override fun getPoster(): String {
        return image
    }

    override fun getRating(): String {
        return ""
    }

    override fun getMovieId(): String {
        return id
    }
}