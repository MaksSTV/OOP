package lab6

import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.*

val json = Json {
    prettyPrint = true

    serializersModule = SerializersModule {
        polymorphic(ColoredShape2d::class) {
            subclass(Circle::class)
            subclass(Rectangle::class)
            subclass(Square::class)
            subclass(Triangle::class)
        }
    }
}