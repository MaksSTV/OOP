package lab2

class ShapeCollector(private val shapes: MutableList<ColoredShape2d> = mutableListOf<ColoredShape2d>()) {

    fun addShape(shape: ColoredShape2d){
        shapes.add(shape)
    }

    fun getShapeMinSquare(): ColoredShape2d? {
        return shapes.minByOrNull { it.calcArea() }
    }

    fun getShapeMaxSquare(): ColoredShape2d? {
        return shapes.maxByOrNull { it.calcArea() }
    }

    fun sumAllSquare(): Double {
        var sumFigure = 0.0
        shapes.forEach { it ->
            sumFigure += it.calcArea()
        }
        return sumFigure
    }

    fun seekShapesColorBorder(color: Color): List<ColoredShape2d> {
        return shapes.filter { it.borderColor == color }
    }

    fun seekShapesColorFill(color: Color): List<ColoredShape2d>{
        return shapes.filter { it.fillColor == color }
    }

    fun getShapes(): List<ColoredShape2d>{
        return shapes
    }

    fun getAmountShapes(): Int {
        return shapes.size
    }

    fun getGroupColorBorder(): Map<Color, List<ColoredShape2d>>{
        return shapes.groupBy { it.borderColor }
    }

    fun getGroupColorFill(): Map<Color, List<ColoredShape2d>> {
        return shapes.groupBy { it.fillColor }
    }

    fun<T> getCertainShape(certain: Class<T>): List<ColoredShape2d>{
        return shapes.filter { it.javaClass == certain }
    }

    fun getCertainFigure(certain: String): List<ColoredShape2d>{
        return shapes.filter { it.toString() == certain }
    }

}

/*fun Shape2d?.printArea() {
    return println(this?.calcArea())
}*/