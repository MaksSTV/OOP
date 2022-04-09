package lab2

import kotlin.math.sqrt

class Circle(private val radius: Double, override val borderColor: Color, override val fillColor: Color): ColoredShape2d{
    override fun calcArea(): Double {
        return 3.14*radius*radius
    }
}

class Rectangle(private val firstSide: Double, private  val secondSide: Double, override val borderColor: Color, override val fillColor: Color): ColoredShape2d{
    override fun calcArea(): Double {
        return firstSide*secondSide
    }
}

class Triangle(private val firstSide: Double, private  val secondSide: Double, private  val thirdSide: Double, override val borderColor: Color, override val fillColor: Color): ColoredShape2d{
    override fun calcArea(): Double {
        val p = (firstSide+secondSide+thirdSide)/2
        return sqrt(p*(p-firstSide)*(p-secondSide)*(p-thirdSide))
    }
}

class Square(private val side: Double, override val borderColor: Color, override val fillColor: Color): ColoredShape2d{
    override fun calcArea(): Double {
        return side*side
    }
}

data class Color(val red: Int, val green: Int, val blue: Int, val transparent: Double)// rgb 0-255; transparent (0.0-1.0)0-100%
