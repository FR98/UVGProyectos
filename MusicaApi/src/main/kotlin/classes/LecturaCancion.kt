package classes

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson

data class LecturaCancion (val id: String,
                           val year: String,
                           val country: String,
                           val region: String,
                           val artistname: String,
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
                           val happiness: String,
                           val isFavourite: String) {

    class LecturaCancionArrayDeserializer: ResponseDeserializable<Array<Cancion>> {
        override fun deserialize(content: String): Array<Cancion>? {
            return Gson().fromJson(content, Array<Cancion>::class.java)
        }
    }

}