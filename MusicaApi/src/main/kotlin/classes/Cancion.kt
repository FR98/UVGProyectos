package classes

import org.jetbrains.exposed.sql.Table

object Cancion: Table() {
    val id = integer("id").autoIncrement().primaryKey()
    val year = varchar("year", length = 25)
    val country = varchar("country", length = 25)
    val region = varchar("region", length = 25)
    val artistname = varchar("artistName", length = 25)
    val song = varchar("song", length = 25)
    val artistGender = varchar("artistGender", length = 25)
    val groupOrSolo = varchar("groupOrSolo", length = 25)
    val place = varchar("place", length = 25)
    val points = varchar("points", length = 25)
    val isFinal = varchar("isFinal", length = 25)
    val isSongInEnglish = varchar("isSongInEnglish", length = 25)
    val songQuality = varchar("songQuality", length = 25)
    val normalizedPoints = varchar("normalizedPoints", length = 25)
    val energy = varchar("energy", length = 25)
    val duration = varchar("duration", length = 25)
    val acousticness = varchar("acousticness", length = 25)
    val danceability = varchar("danceability", length = 25)
    val tempo = varchar("tempo", length = 25)
    val speechiness = varchar("speechiness", length = 25)
    val key = varchar("key", length = 25)
    val liveness = varchar("liveness", length = 25)
    val timeSignature = varchar("timeSignature", length = 25)
    val mode = varchar("mode", length = 25)
    val loudness = varchar("loudness", length = 25)
    val valence = varchar("valence", length = 25)
    val happiness = varchar("happiness", length = 25)
    val isFavourite = bool("isFavourite")

}

