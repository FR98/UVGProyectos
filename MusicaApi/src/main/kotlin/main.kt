import classes.Cancion
import classes.LecturaCancion
import com.github.kittinunf.fuel.Fuel
import menus.menu1
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

//Gian Luca Rivera 18049
//Francisco Rosal 18676

fun main(args: Array<String>) {
    //URL DEL API DE CANCIONES
    val url = "https://next.json-generator.com/api/json/get/EkeSgmXycS"
    //EXTRACCION DEL API
    val (request, response, result) = Fuel.get(url).responseObject(LecturaCancion.LecturaCancionArrayDeserializer())
    val (canciones, err) = result

    //CONEXION A BASE DE DATOS
    Database.connect(
            "jdbc:postgresql:musica",
            "org.postgresql.Driver",
            "postgres",
            "admin"
    )

    transaction {
        SchemaUtils.create(Cancion)

        if (canciones != null) {
            for (cancion in canciones) {
                Cancion.insert {
                    it[year] = cancion.year
                    it[isFavourite] = false
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

        Thread.sleep(5000)

        var continuar = true

        do {
            println(menu1())
            val menu1Opcion = readLine()!!

            when(menu1Opcion) {
                "1" -> {
                    println("Ingrese parte del nombre de la cancion que desea buscar:")
                    val buscarCancion = readLine()!!

                    //AQUI SE MUESTRAN LAS CANCIONES
                    for (cancion in Cancion.select { Cancion.song.like("%${buscarCancion}%") }) {
                        println("${cancion[Cancion.id]}. ${cancion[Cancion.song]}")
                    }

                    println("Desea guardar alguna en sus favoritas?")
                    val pre1 = readLine()!!

                    when(pre1) {
                        "si","Si" -> {
                            println("Cual?")
                            val cancionElecta = readLine()!!.toInt()

                            //SE MARCA COMO FAVORITA
                            Cancion.update({Cancion.id eq cancionElecta}) {
                                it[isFavourite] = true
                                println("Añadida a favoritos")
                            }
                        }
                        "no","No" -> {
                            println("Okay")
                        }
                        else -> println("Opcion invalida")

                    }
                }
                "2" -> {
                    println("Ingrese el nombre del artista que desea buscar:")
                    val buscarArtista = readLine()!!

                    //AQUI SE MUESTRAN LAS CANCIONES
                    for (cancion in Cancion.select { Cancion.artistName.like("%${buscarArtista}%") }) {
                        println("${cancion[Cancion.id]}. ${cancion[Cancion.song]}")
                    }

                    println("Desea guardar alguna en sus favoritas?")
                    val pre2 = readLine()!!

                    when(pre2) {
                        "si","Si" -> {
                            println("Cual?")
                            val cancionElecta2 = readLine()!!.toInt()

                            //SE MARCA COMO FAVORITA
                            Cancion.update({Cancion.id eq cancionElecta2}) {
                                it[isFavourite] = true
                                println("Añadida a favoritos")
                            }
                        }
                        "no","No" -> {
                            println("Okay")
                        }
                        else -> println("Opcion invalida")
                    }
                }
                "3" -> {
                    println("MIS CANCIONES FAVORITAS:")

                    //SE IMPRIME LAS CANCIONES FAVORITAS
                    for (cancion in Cancion.select {Cancion.isFavourite.eq(true)}) {
                        println("${cancion[Cancion.id]}. ${cancion[Cancion.song]}")
                    }
                }
                "4" -> continuar = false
                else -> println("Opcion Invalida")
            }
        } while (continuar)
    }
}