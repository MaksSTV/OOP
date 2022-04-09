package lab2


fun main() {
    val mishaKrug = Circle(5.0, Color(144, 228, 14, 0.1), Color(144, 228, 14, 0.1))
    println("Misha square is ${mishaKrug.calcArea()}")

    val sashaRectangle = Rectangle(2.3,5.5, Color(144, 228, 14, 0.1), Color(144, 228, 14, 0.1))
    println("Sasha square is ${sashaRectangle.calcArea()}")

    val leshaTriangle = Triangle(3.0,4.0,5.0, Color(144, 228, 14, 0.1), Color(144, 228, 14, 0.1))
    println("Lesha square is ${leshaTriangle.calcArea()}")

    val dashaSquare = Square(9.0, Color(144, 228, 14, 0.1), Color(144, 228, 14, 0.1))
    println("Dasha square is ${dashaSquare.calcArea()}")

    val abc = ShapeCollector()
    abc.addShape(Rectangle(2.3,5.5, Color(144, 228, 14, 0.1), Color(144, 228, 14, 0.1)))
    abc.addShape(Square(9.0, Color(144, 228, 14, 0.1), Color(144, 228, 14, 0.1)))
    abc.addShape(Triangle(3.0,4.0,5.0, Color(144, 228, 14, 0.1), Color(144, 228, 14, 0.1)))

    println(abc.getShapeMinSquare())
    println(abc.getShapeMaxSquare())

}