package lab6

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString

class JsonFormatCode {

    fun encodeJson(input: List<ColoredShape2d>): String {
        return json.encodeToString(input)
    }

    fun decodeJson(input: String): List<ColoredShape2d> {
        return json.decodeFromString(input)
    }
}