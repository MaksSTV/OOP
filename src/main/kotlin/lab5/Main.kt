package lab5

fun main() {
    val mishaKrug = Circle(5.0, Color(144, 228, 14, 0.1), Color(144, 228, 14, 0.1))
    println("Misha square is ${mishaKrug.calcArea()}")

    val sashaRectangle = Rectangle(2.3, 5.5, Color(144, 228, 14, 0.1), Color(144, 228, 14, 0.1))
    println("Sasha square is ${sashaRectangle.calcArea()}")

    val leshaTriangle = Triangle(3.0, 4.0, 5.0, Color(144, 228, 14, 0.1), Color(144, 228, 14, 0.1))
    println("Lesha square is ${leshaTriangle.calcArea()}")

    val dashaSquare = Square(9.0, Color(144, 228, 14, 0.1), Color(144, 228, 14, 0.1))
    println("Dasha square is ${dashaSquare.calcArea()}")

    val listOfShapes = ShapeCollector<ColoredShape2d>()
    listOfShapes.addShape(Rectangle(2.3, 5.5, Color(144, 228, 14, 0.1), Color(144, 228, 14, 0.1)))
    listOfShapes.addShape(Square(9.0, Color(144, 228, 14, 0.1), Color(144, 228, 14, 0.1)))
    listOfShapes.addShape(Triangle(3.0, 4.0, 5.0, Color(144, 228, 14, 0.1), Color(144, 229, 14, 0.1)))
    listOfShapes.addShape(Triangle(3.0, 4.0, 5.0, Color(144, 230, 14, 0.1), Color(144, 229, 14, 0.1)))
    listOfShapes.addShape(Triangle(3.0, 4.0, 5.0, Color(144, 222, 14, 0.1), Color(144, 229, 14, 0.1)))

    println(listOfShapes.getShapeMinSquare()?.calcArea())
    println(listOfShapes.getShapeMaxSquare()?.calcArea())
    println(
        "Shape min square is ${listOfShapes.getShapeMinSquare().toString()}, it square is ${
            listOfShapes.getShapeMinSquare()?.calcArea()
        }"
    )
    println(listOfShapes.sumAllSquare())
    println(listOfShapes.seekShapesColorBorder(Color(144, 228, 14, 0.1)))
    println(listOfShapes.seekShapesColorFill(Color(144, 228, 14, 0.1)))
    println(listOfShapes.getAmountShapes())
    println(listOfShapes.getShapes())
    println(listOfShapes.getGroupColorBorder())
    println(listOfShapes.getGroupColorFill())

    println(listOfShapes.getCertainShape(Circle::class.java))
    println(listOfShapes.getCertainShape(Triangle::class.java))

    listOfShapes.addAll(
        listOf(
            Rectangle(2.3, 5.3, Color(99, 99, 99, 0.1), Color(144, 228, 14, 0.1)),
            Rectangle(2.3, 5.7, Color(98, 98, 98, 0.1), Color(144, 228, 14, 0.1)),
            Rectangle(2.3, 5.9, Color(97, 97, 97, 0.1), Color(144, 228, 14, 0.1))
        )
    )
    println(listOfShapes.getShapes())

    listOfShapes.getSorted(compareBy { it.calcArea() }).forEach { println(it.calcArea()) }
    println(listOfShapes.getShapes())
}