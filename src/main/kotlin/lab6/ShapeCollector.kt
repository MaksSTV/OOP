package lab6

class ShapeCollector {
    private val listOfShapes = mutableListOf<ColoredShape2d>()

    fun addShape(shape: ColoredShape2d) {
        listOfShapes.add(shape)
    }

    fun getShapeMinSquare(): ColoredShape2d? {
        return listOfShapes.minByOrNull { it.calcArea() }
    }

    fun getShapeMaxSquare(): ColoredShape2d? {
        return listOfShapes.maxByOrNull { it.calcArea() }
    }

    fun sumAllSquare(): Double {
        var sumFigure = 0.0
        listOfShapes.forEach { it ->
            sumFigure += it.calcArea()
        }
        return sumFigure
    }

    fun seekShapesColorBorder(color: Color): List<ColoredShape2d> {
        return listOfShapes.filter { it.borderColor == color }
    }

    fun seekShapesColorFill(color: Color): List<ColoredShape2d> {
        return listOfShapes.filter { it.fillColor == color }
    }

    fun getShapes(): List<ColoredShape2d> {
        return listOfShapes
    }

    fun getAmountShapes(): Int {
        return listOfShapes.size
    }

    fun getGroupColorBorder(): Map<Color, List<ColoredShape2d>> {
        return listOfShapes.groupBy { it.borderColor }
    }

    fun getGroupColorFill(): Map<Color, List<ColoredShape2d>> {
        return listOfShapes.groupBy { it.fillColor }
    }

    fun <T> getCertainShape(certain: Class<T>): List<ColoredShape2d> {
        return listOfShapes.filter { it.javaClass == certain }
    }

}