package lab5

@Suppress("UNCHECKED_CAST")
class ShapeCollector<T : ColoredShape2d> {
    private val listOfShapes = mutableListOf<T>()

    fun addShape(shape: T) {
        listOfShapes.add(shape)
    }

    fun addAll(shapes: List<T>) {
        listOfShapes += shapes
    }

    fun getSorted(comparator: Comparator<T>): List<T> {
        return listOfShapes.sortedWith(comparator)
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

    fun <Type : T> getCertainShape(certain: Class<Type>): List<Type> {
        return listOfShapes.filter { it.javaClass == certain } as List<Type>
    }

}