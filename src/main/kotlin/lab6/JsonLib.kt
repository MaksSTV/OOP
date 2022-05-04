package lab6

import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.*
import java.io.File

val json = Json {
    prettyPrint = true

    serializersModule = SerializersModule {
        polymorphic(ColoredShape2d::class) {
            subclass(Circle::class)
            subclass(Rectangle::class)
            subclass(Square::class)
            subclass(Triangle::class)
        }
    }
}

class JsonLib {

    fun inputFile(path: String): String{
        return File(path).readText()
    }

    fun outputFile(string: String, path: String){
        File(path).writeText(string)
    }

}