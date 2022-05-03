package lab6

import java.io.File

fun main() {

    val input = File("C:\\Users\\Maks\\IdeaProjects\\OOP\\src\\main\\kotlin\\lab6\\input.json").readText()
    val formatting = JsonFormatCode()

    val listJson = formatting.decodeJson(input) as MutableList
    listJson.add(Triangle(3.0, 4.0, 5.0, Color(144, 222, 14, 0.1), Color(144, 229, 14, 0.1)))
    val encodedListOfShapes = formatting.encodeJson(listJson)

    File("C:\\Users\\Maks\\IdeaProjects\\OOP\\src\\main\\kotlin\\lab6\\output.json").writeText(encodedListOfShapes)

    val listOfShapes = listOf<ColoredShape2d>(
        Triangle(3.0, 4.0, 5.0, Color(144, 222, 14, 0.1), Color(144, 229, 14, 0.1)),
        Square(9.0, Color(144, 50, 14, 0.1), Color(144, 50, 14, 0.1)),
        Rectangle(2.3, 5.5, Color(144, 228, 14, 0.1), Color(100, 100, 100, 0.5))
    ) as MutableList

    val formatEncode = formatting.encodeJson(listOfShapes)
    val formatDecode = formatting.decodeJson(formatEncode)
    println(listOfShapes == formatDecode)
}