package classes

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson

data class LecturaCancion (
        //ATRIBUTOS DE LA CLASE
        val isFavourite: Boolean = false,
        val year: String,
        val country: String,
        val region: String,
        val artistName: String,
        val song: String,
        val artistGender: String,
        val groupOrSolo: String,
        val place: String,
        val points: String,
        val isFinal: String,
        val isSongInEnglish: String,
        val songQuality: String,
        val normalizedPoints: String,
        val energy: String,
        val duration: String,
        val acousticness: String,
        val danceability: String,
        val tempo: String,
        val speechiness: String,
        val key: String,
        val liveness: String,
        val timeSignature: String,
        val mode: String,
        val loudness: String,
        val valence: String,
        val happiness: String
        ) {

    class LecturaCancionArrayDeserializer: ResponseDeserializable<Array<LecturaCancion>> {
        override fun deserialize(content: String): Array<LecturaCancion>? {
            return Gson().fromJson(content, Array<LecturaCancion>::class.java)
        }
    }

}