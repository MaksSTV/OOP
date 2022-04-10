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
    abc.addShape(Triangle(3.0,4.0,5.0, Color(144, 228, 14, 0.1), Color(144, 229, 14, 0.1)))
    abc.addShape(Triangle(3.0,4.0,5.0, Color(144, 230, 14, 0.1), Color(144, 229, 14, 0.1)))
    abc.addShape(Triangle(3.0,4.0,5.0, Color(144, 222, 14, 0.1), Color(144, 229, 14, 0.1)))


    println(abc.getShapeMinSquare()?.calcArea())
    println(abc.getShapeMaxSquare()?.calcArea())
    println("Shape min square is ${abc.getShapeMinSquare().toString()}, it square is ${abc.getShapeMinSquare()?.calcArea()}")
    println(abc.sumAllSquare())
    println(abc.seekShapesColorBorder(Color(144, 228, 14, 0.1)))
    println(abc.seekShapesColorFill(Color(144, 228, 14, 0.1)))
    println(abc.getAmountShapes())
    println(abc.getShapes())
    println(abc.getGroupColorBorder())
    println(abc.getGroupColorFill())

    println(abc.getCertainFigure("Circle"))
    println(abc.getCertainShape(Circle::class.java))
    println(abc.getCertainShape(Triangle::class.java))
    println(abc.getCertainFigure("Triangle"))

}