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

    fun sumAllSquare(){}

    fun seekShapesColorBorder(){}

    fun seekShapesColorFill(){}

    fun getShapes(){}

    fun getAmountShapes(){}

    fun getGroupColorBorder(){}

    fun getGroupColorFill(){}


}