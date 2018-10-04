import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.gson.responseObject
import org.jetbrains.exposed.sql.Database

fun main(args: Array<String>) {
    val url = "https://next.json-generator.com/api/json/get/EkeSgmXycS"

    Fuel.get(url).responseObject(){ request, response, result ->
        val (canciones, err) = result
        canciones?.foreach{ println(it) }
    }

    Database.connect(
            "jdbc:postgresql:musica",
            "org.postgresql.Driver",
            "admin",
            "admin"
    )

}