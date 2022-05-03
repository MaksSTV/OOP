package lab6

import kotlin.math.sqrt

@kotlinx.serialization.Serializable
data class Circle(
    val radius: Double,
    override val borderColor: Color,
    override val fillColor: Color
) :
    ColoredShape2d {

    init {
        if (radius <= 0.0) {
            throw IllegalArgumentException("Error!!! Invalid value!!!")
        }
    }

    override fun toString(): String {
        return "Circle"
    }

    override fun calcArea(): Double {
        return 3.14 * radius * radius
    }
}

@kotlinx.serialization.Serializable
data class Rectangle(
    val firstSide: Double,
    val secondSide: Double,
    override val borderColor: Color,
    override val fillColor: Color
) : ColoredShape2d {

    init {
        if (firstSide <= 0.0 && secondSide <= 0.0) {
            throw IllegalArgumentException("Error!!! Invalid value!!!")
        }
    }

    override fun toString(): String {
        return "Rectangle"
    }

    override fun calcArea(): Double {
        return firstSide * secondSide
    }
}

@kotlinx.serialization.Serializable
data class Triangle(
    val firstSide: Double,
    val secondSide: Double,
    val thirdSide: Double,
    override val borderColor: Color,
    override val fillColor: Color
) : ColoredShape2d {

    init {
        if (firstSide <= 0.0 && secondSide <= 0.0 && thirdSide <= 0.0) {
            throw IllegalArgumentException("Error!!! Invalid value!!!")
        }

        if ((firstSide >= secondSide + thirdSide) || (thirdSide >= secondSide + firstSide) || (secondSide >= firstSide + thirdSide)) {
            throw IllegalArgumentException("Error!!! Invalid value!!!")
        }
    }

    override fun toString(): String {
        return "Triangle"
    }

    override fun calcArea(): Double {
        val p = (firstSide + secondSide + thirdSide) / 2
        return sqrt(p * (p - firstSide) * (p - secondSide) * (p - thirdSide))
    }
}

@kotlinx.serialization.Serializable
data class Square(
    val side: Double,
    override val borderColor: Color,
    override val fillColor: Color
) : ColoredShape2d {

    init {
        if (side <= 0.0) {
            throw IllegalArgumentException("Error!!! Invalid value!!!")
        }
    }

    override fun toString(): String {
        return "Square"
    }

    override fun calcArea(): Double {
        return side * side
    }
}

@kotlinx.serialization.Serializable
data class Color(
    val red: Int,
    val green: Int,
    val blue: Int,
    val transparent: Double
) {
    init {
        if (red !in 0..255
            && (green !in 0..255)
            && (blue !in 0..255)
            && (transparent !in 0.0..1.0)
        ) {
            throw IllegalArgumentException("Error!!! Invalid value!!!")
        }
    }
}// rgb 0-255; transparent (0.0-1.0)0-100%
