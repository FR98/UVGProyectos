package classes

import org.jetbrains.exposed.sql.Table

object Cancion: Table() {
    //ATRIBUTOS DEL OBJETO CANCION
    val id = integer("id").autoIncrement().primaryKey()
    //val isFavourite = bool("isFavourite")
    val year = varchar("year", length = 5)
    val country = varchar("country", length = 24)
    val region = varchar("region", length = 24)
    val artistName = varchar("artistName", length = 50)
    val song = varchar("song", length = 50)
    val artistGender = varchar("artistGender", length = 15)
    val groupOrSolo = varchar("groupOrSolo", length = 15)
    val place = varchar("place", length = 15)
    val points = varchar("points", length = 15)
    val isFinal = varchar("isFinal", length = 15)
    val isSongInEnglish = varchar("isSongInEnglish", length = 15)
    val songQuality = varchar("songQuality", length = 15)
    val normalizedPoints = varchar("normalizedPoints", length = 15)
    val energy = varchar("energy", length = 15)
    val duration = varchar("duration", length = 15)
    val acousticness = varchar("acousticness", length = 15)
    val danceability = varchar("danceability", length = 15)
    val tempo = varchar("tempo", length = 15)
    val speechiness = varchar("speechiness", length = 15)
    val key = varchar("key", length = 15)
    val liveness = varchar("liveness", length = 15)
    val timeSignature = varchar("timeSignature", length = 15)
    val mode = varchar("mode", length = 15)
    val loudness = varchar("loudness", length = 15)
    val valence = varchar("valence", length = 15)
    val happiness = varchar("happiness", length = 15)
}

