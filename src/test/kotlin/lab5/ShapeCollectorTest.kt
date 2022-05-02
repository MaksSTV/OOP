package lab5

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ShapeCollectorTest {

    @Test
    fun addShape() {
        val listOfShapes = ShapeCollector<ColoredShape2d>()
        assertTrue(listOfShapes.getShapes().isEmpty())

        listOfShapes.addShape(Circle(2.0, Color(1, 1, 1, 1.0), Color(1, 1, 1, 1.0)))
        assertEquals(Circle(2.0, Color(1, 1, 1, 1.0), Color(1, 1, 1, 1.0)), listOfShapes.getShapes()[0])

        listOfShapes.addShape(Square(5.0, Color(1, 1, 1, 1.0), Color(1, 1, 1, 1.0)))
        assertEquals(Square(5.0, Color(1, 1, 1, 1.0), Color(1, 1, 1, 1.0)), listOfShapes.getShapes()[1])
    }

    @Test
    fun getShapeMinSquare() {
        val listOfShapes = ShapeCollector<ColoredShape2d>()
        assertTrue(listOfShapes.getShapes().isEmpty())

        listOfShapes.addShape(Rectangle(2.3, 5.5, Color(144, 228, 14, 0.1), Color(144, 228, 14, 0.1)))
        listOfShapes.addShape(Square(9.0, Color(144, 228, 14, 0.1), Color(144, 228, 14, 0.1)))
        listOfShapes.addShape(Triangle(3.0, 4.0, 5.0, Color(144, 228, 14, 0.1), Color(144, 229, 14, 0.1)))
        listOfShapes.addShape(Triangle(3.0, 4.0, 5.0, Color(144, 230, 14, 0.1), Color(144, 229, 14, 0.1)))
        listOfShapes.addShape(Triangle(3.0, 4.0, 5.0, Color(144, 222, 14, 0.1), Color(144, 229, 14, 0.1)))

        val minSquare = listOfShapes.getShapeMinSquare()?.calcArea()
        assertEquals(6.0, minSquare)

    }

    @Test
    fun getShapeMaxSquare() {
        val listOfShapes = ShapeCollector<ColoredShape2d>()
        assertTrue(listOfShapes.getShapes().isEmpty())

        listOfShapes.addShape(Rectangle(2.3, 5.5, Color(144, 228, 14, 0.1), Color(144, 228, 14, 0.1)))
        listOfShapes.addShape(Square(9.0, Color(144, 228, 14, 0.1), Color(144, 228, 14, 0.1)))
        listOfShapes.addShape(Triangle(3.0, 4.0, 5.0, Color(144, 228, 14, 0.1), Color(144, 229, 14, 0.1)))
        listOfShapes.addShape(Triangle(3.0, 4.0, 5.0, Color(144, 230, 14, 0.1), Color(144, 229, 14, 0.1)))
        listOfShapes.addShape(Triangle(3.0, 4.0, 5.0, Color(144, 222, 14, 0.1), Color(144, 229, 14, 0.1)))

        val maxSquare = listOfShapes.getShapeMaxSquare()?.calcArea()
        assertEquals(81.0, maxSquare)
    }

    @Test
    fun sumAllSquare() {
        val listOfShapes = ShapeCollector<ColoredShape2d>()
        assertTrue(listOfShapes.getShapes().isEmpty())

        listOfShapes.addShape(Rectangle(2.3, 5.5, Color(144, 228, 14, 0.1), Color(144, 228, 14, 0.1)))
        listOfShapes.addShape(Square(9.0, Color(144, 228, 14, 0.1), Color(144, 228, 14, 0.1)))
        listOfShapes.addShape(Triangle(3.0, 4.0, 5.0, Color(144, 228, 14, 0.1), Color(144, 229, 14, 0.1)))
        listOfShapes.addShape(Triangle(3.0, 4.0, 5.0, Color(144, 230, 14, 0.1), Color(144, 229, 14, 0.1)))
        listOfShapes.addShape(Triangle(3.0, 4.0, 5.0, Color(144, 222, 14, 0.1), Color(144, 229, 14, 0.1)))

        val sumAllSquare = listOfShapes.sumAllSquare()
        assertEquals(111.65, sumAllSquare)
    }

    @Test
    fun seekShapesColorBorder() {
        val listOfShapes = ShapeCollector<ColoredShape2d>()
        assertTrue(listOfShapes.getShapes().isEmpty())

        listOfShapes.addShape(Rectangle(2.3, 5.5, Color(144, 228, 14, 0.1), Color(144, 228, 14, 0.1)))
        listOfShapes.addShape(Square(9.0, Color(144, 228, 14, 0.1), Color(144, 228, 14, 0.1)))
        listOfShapes.addShape(Triangle(3.0, 4.0, 5.0, Color(144, 228, 14, 0.1), Color(144, 229, 14, 0.1)))
        listOfShapes.addShape(Triangle(3.0, 4.0, 5.0, Color(144, 230, 14, 0.1), Color(144, 229, 14, 0.1)))
        listOfShapes.addShape(Triangle(3.0, 4.0, 5.0, Color(144, 222, 14, 0.1), Color(144, 229, 14, 0.1)))

        val seekShapes = listOf(
            Rectangle(2.3, 5.5, Color(144, 228, 14, 0.1), Color(144, 228, 14, 0.1)),
            Square(9.0, Color(144, 228, 14, 0.1), Color(144, 228, 14, 0.1)),
            Triangle(3.0, 4.0, 5.0, Color(144, 228, 14, 0.1), Color(144, 229, 14, 0.1))
        )
        assertEquals(seekShapes, listOfShapes.seekShapesColorBorder(Color(144, 228, 14, 0.1)))
    }

    @Test
    fun seekShapesColorFill() {
        val listOfShapes = ShapeCollector<ColoredShape2d>()
        assertTrue(listOfShapes.getShapes().isEmpty())

        listOfShapes.addShape(Rectangle(2.3, 5.5, Color(144, 228, 14, 0.1), Color(144, 228, 14, 0.1)))
        listOfShapes.addShape(Square(9.0, Color(144, 228, 14, 0.1), Color(144, 228, 14, 0.1)))
        listOfShapes.addShape(Triangle(3.0, 4.0, 5.0, Color(144, 228, 14, 0.1), Color(144, 229, 14, 0.1)))
        listOfShapes.addShape(Triangle(3.0, 4.0, 5.0, Color(144, 230, 14, 0.1), Color(144, 229, 14, 0.1)))
        listOfShapes.addShape(Triangle(3.0, 4.0, 5.0, Color(144, 222, 14, 0.1), Color(144, 229, 14, 0.1)))

        val seekShapes = listOf(
            Rectangle(2.3, 5.5, Color(144, 228, 14, 0.1), Color(144, 228, 14, 0.1)),
            Square(9.0, Color(144, 228, 14, 0.1), Color(144, 228, 14, 0.1))
        )
        assertEquals(seekShapes, listOfShapes.seekShapesColorFill(Color(144, 228, 14, 0.1)))

    }

    @Test
    fun getShapes() {
        val listOfShapes = ShapeCollector<ColoredShape2d>()
        assertTrue(listOfShapes.getShapes().isEmpty())

        listOfShapes.addShape(Rectangle(2.3, 5.5, Color(144, 228, 14, 0.1), Color(144, 228, 14, 0.1)))
        listOfShapes.addShape(Square(9.0, Color(144, 228, 14, 0.1), Color(144, 228, 14, 0.1)))
        listOfShapes.addShape(Triangle(3.0, 4.0, 5.0, Color(144, 228, 14, 0.1), Color(144, 229, 14, 0.1)))
        listOfShapes.addShape(Triangle(3.0, 4.0, 5.0, Color(144, 230, 14, 0.1), Color(144, 229, 14, 0.1)))
        listOfShapes.addShape(Triangle(3.0, 4.0, 5.0, Color(144, 222, 14, 0.1), Color(144, 229, 14, 0.1)))

        val shapes = listOf(
            Rectangle(2.3, 5.5, Color(144, 228, 14, 0.1), Color(144, 228, 14, 0.1)),
            Square(9.0, Color(144, 228, 14, 0.1), Color(144, 228, 14, 0.1)),
            Triangle(3.0, 4.0, 5.0, Color(144, 228, 14, 0.1), Color(144, 229, 14, 0.1)),
            Triangle(3.0, 4.0, 5.0, Color(144, 230, 14, 0.1), Color(144, 229, 14, 0.1)),
            Triangle(3.0, 4.0, 5.0, Color(144, 222, 14, 0.1), Color(144, 229, 14, 0.1))
        )
        assertEquals(shapes, listOfShapes.getShapes())

    }

    @Test
    fun getAmountShapes() {
        val listOfShapes = ShapeCollector<ColoredShape2d>()
        assertTrue(listOfShapes.getShapes().isEmpty())

        listOfShapes.addShape(Rectangle(2.3, 5.5, Color(144, 228, 14, 0.1), Color(144, 228, 14, 0.1)))
        listOfShapes.addShape(Square(9.0, Color(144, 228, 14, 0.1), Color(144, 228, 14, 0.1)))
        listOfShapes.addShape(Triangle(3.0, 4.0, 5.0, Color(144, 228, 14, 0.1), Color(144, 229, 14, 0.1)))
        listOfShapes.addShape(Triangle(3.0, 4.0, 5.0, Color(144, 230, 14, 0.1), Color(144, 229, 14, 0.1)))
        listOfShapes.addShape(Triangle(3.0, 4.0, 5.0, Color(144, 222, 14, 0.1), Color(144, 229, 14, 0.1)))

        assertFalse(listOfShapes.getShapes().isEmpty())

        val amountShapes = listOfShapes.getAmountShapes()
        assertEquals(5, amountShapes)
    }

    @Test
    fun getGroupColorBorder() {
        val listOfShapes = ShapeCollector<ColoredShape2d>()
        assertTrue(listOfShapes.getShapes().isEmpty())

        listOfShapes.addShape(Rectangle(2.3, 5.5, Color(144, 228, 14, 0.1), Color(144, 228, 14, 0.1)))
        listOfShapes.addShape(Square(9.0, Color(144, 50, 14, 0.1), Color(144, 50, 14, 0.1)))
        listOfShapes.addShape(Triangle(3.0, 4.0, 5.0, Color(144, 228, 14, 0.1), Color(144, 229, 14, 0.1)))
        listOfShapes.addShape(Triangle(3.0, 4.0, 5.0, Color(144, 230, 14, 0.1), Color(144, 229, 14, 0.1)))
        listOfShapes.addShape(Triangle(3.0, 4.0, 5.0, Color(144, 222, 14, 0.1), Color(144, 229, 14, 0.1)))

        val groupShapes = listOfShapes.getGroupColorBorder()
        assertEquals(
            listOf(Square(9.0, Color(144, 50, 14, 0.1), Color(144, 50, 14, 0.1))),
            groupShapes[Color(144, 50, 14, 0.1)]
        )
    }

    @Test
    fun getGroupColorFill() {
        val listOfShapes = ShapeCollector<ColoredShape2d>()
        assertTrue(listOfShapes.getShapes().isEmpty())

        listOfShapes.addShape(Rectangle(2.3, 5.5, Color(144, 228, 14, 0.1), Color(100, 100, 100, 0.5)))
        listOfShapes.addShape(Square(9.0, Color(144, 50, 14, 0.1), Color(144, 50, 14, 0.1)))
        listOfShapes.addShape(Triangle(3.0, 4.0, 5.0, Color(144, 228, 14, 0.1), Color(144, 229, 14, 0.1)))
        listOfShapes.addShape(Triangle(3.0, 4.0, 5.0, Color(144, 230, 14, 0.1), Color(144, 229, 14, 0.1)))
        listOfShapes.addShape(Triangle(3.0, 4.0, 5.0, Color(144, 222, 14, 0.1), Color(144, 229, 14, 0.1)))

        val groupShapes = listOfShapes.getGroupColorFill()
        assertEquals(
            listOf(Rectangle(2.3, 5.5, Color(144, 228, 14, 0.1), Color(100, 100, 100, 0.5))),
            groupShapes[Color(100, 100, 100, 0.5)]
        )

    }

    @Test
    fun getCertainShape() {
        val listOfShapes = ShapeCollector<ColoredShape2d>()
        assertTrue(listOfShapes.getShapes().isEmpty())

        listOfShapes.addShape(Rectangle(2.3, 5.5, Color(144, 228, 14, 0.1), Color(100, 100, 100, 0.5)))
        listOfShapes.addShape(Square(9.0, Color(144, 50, 14, 0.1), Color(144, 50, 14, 0.1)))
        listOfShapes.addShape(Triangle(3.0, 4.0, 5.0, Color(144, 228, 14, 0.1), Color(144, 229, 14, 0.1)))
        listOfShapes.addShape(Triangle(3.0, 4.0, 5.0, Color(144, 230, 14, 0.1), Color(144, 229, 14, 0.1)))
        listOfShapes.addShape(Triangle(3.0, 4.0, 5.0, Color(144, 222, 14, 0.1), Color(144, 229, 14, 0.1)))

        val certainShape = listOfShapes.getCertainShape(Square::class.java)
        assertEquals(listOf(Square(9.0, Color(144, 50, 14, 0.1), Color(144, 50, 14, 0.1))), certainShape)

    }

    @Test
    fun addAll() {
        val listOfShapes = ShapeCollector<ColoredShape2d>()
        assertTrue(listOfShapes.getShapes().isEmpty())

        listOfShapes.addShape(Circle(2.0, Color(1, 1, 1, 1.0), Color(1, 1, 1, 1.0)))
        assertEquals(Circle(2.0, Color(1, 1, 1, 1.0), Color(1, 1, 1, 1.0)), listOfShapes.getShapes()[0])

        listOfShapes.addAll(
            listOf(
                Rectangle(2.3, 5.3, Color(99, 99, 99, 0.1), Color(144, 228, 14, 0.1)),
                Square(9.0, Color(144, 228, 14, 0.1), Color(144, 228, 14, 0.1)),
                Triangle(3.0, 4.0, 5.0, Color(144, 228, 14, 0.1), Color(144, 229, 14, 0.1))
            )
        )

        assertEquals(Circle(2.0, Color(1, 1, 1, 1.0), Color(1, 1, 1, 1.0)), listOfShapes.getShapes()[0])
        assertEquals(Rectangle(2.3, 5.3, Color(99, 99, 99, 0.1), Color(144, 228, 14, 0.1)), listOfShapes.getShapes()[1])
        assertEquals(Square(9.0, Color(144, 228, 14, 0.1), Color(144, 228, 14, 0.1)), listOfShapes.getShapes()[2])
        assertEquals(
            Triangle(3.0, 4.0, 5.0, Color(144, 228, 14, 0.1), Color(144, 229, 14, 0.1)),
            listOfShapes.getShapes()[3]
        )

    }

    @Test
    fun getSorted() {
        val listOfShapes = ShapeCollector<ColoredShape2d>()
        assertTrue(listOfShapes.getShapes().isEmpty())

        listOfShapes.addAll(
            listOf(
                Rectangle(2.3, 5.3, Color(99, 99, 99, 0.1), Color(144, 228, 14, 0.1)),
                Square(9.0, Color(144, 228, 14, 0.1), Color(144, 228, 14, 0.1)),
                Triangle(3.0, 4.0, 5.0, Color(144, 228, 14, 0.1), Color(144, 229, 14, 0.1))
            )
        )
        //78.5, 12.649999999999999, 81.0
        assertEquals(6.0, listOfShapes.getSorted(compareBy { it.calcArea() })[0].calcArea())
        assertEquals(12.19, listOfShapes.getSorted(compareBy { it.calcArea() })[1].calcArea())
        assertEquals(81.0, listOfShapes.getSorted(compareBy { it.calcArea() })[2].calcArea())

        //listOfShapes.getSorted(compareBy { it.calcArea() }).forEach{ println(it.calcArea()) }

    }

}