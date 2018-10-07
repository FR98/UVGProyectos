import classes.Cancion
import classes.LecturaCancion
import com.github.kittinunf.fuel.Fuel
import menus.menu1
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

fun main(args: Array<String>) {
    //URL DEL API DE CANCIONES
    val url = "https://next.json-generator.com/api/json/get/EkeSgmXycS"
    //EXTRACCION DEL API
    val (request, response, result) = Fuel.get(url).responseObject(LecturaCancion.LecturaCancionArrayDeserializer())
    val (canciones, err) = result

    //CONEXION A BASE DE DATOS
    Database.connect(
            //Nombre de la db
            "jdbc:postgresql:postgres",
            "org.postgresql.Driver",
            "postgres",
            "admin"
    )

    transaction {
        SchemaUtils.create(Cancion)

        if (canciones != null) {
            for (cancion in canciones) {
                Cancion.insert {
                    //it[id] = cancion.id
                    it[year] = cancion.year
                    it[country] = cancion.country
                    it[region] = cancion.region
                    it[artistName] = cancion.artistName
                    it[song] = cancion.song
                    it[artistGender] = cancion.artistGender
                    it[groupOrSolo] = cancion.groupOrSolo
                    it[place] = cancion.place
                    it[points] = cancion.points
                    it[isFinal] = cancion.isFinal
                    it[isSongInEnglish] = cancion.isSongInEnglish
                    it[songQuality] = cancion.songQuality
                    it[normalizedPoints] = cancion.normalizedPoints
                    it[energy] = cancion.energy
                    it[duration] = cancion.duration
                    it[acousticness] = cancion.acousticness
                    it[danceability] = cancion.danceability
                    it[tempo] = cancion.tempo
                    it[speechiness] = cancion.speechiness
                    it[key] = cancion.key
                    it[liveness] = cancion.liveness
                    it[timeSignature] = cancion.timeSignature
                    it[mode] = cancion.mode
                    it[loudness] = cancion.loudness
                    it[valence] = cancion.valence
                    it[happiness] = cancion.happiness
                }
            }
        }
    }

    Thread.sleep(5000)

    var continuar = true

    do {
        println(menu1())
        val menu1Opcion = readLine()!!

        when(menu1Opcion) {
            "1" -> {
                println("Ingrese parte del nombre de la cancion que desea buscar:")
                val buscarCancion = readLine()!!

                //AQUI SE BUSCA LA CANCION
            }
            "2" -> {
                println("Ingrese el nombre del artista que desea buscar:")
                val buscarArtista = readLine()!!

                //AQUI SE BUSCA LAS CANCIONES DEL ARTISTA
            }
            "3" -> {
                println("MIS CANCIONES FAVORITAS:")

                //SE IMPRIME LAS CANCIONES FAVORITAS
            }
            "4" -> continuar = false
            else -> println("Opcion Invalida")
        }

    } while (continuar)


}