package lab1

import lab1.address.*


fun main() {

    val addresses = """
        1. 12389, Санкт-Петербург, ул. Новоизмайловский проспект, д. 16
        2. 12869, Санкт-Петербург, ул. Невский проспект, д. 5
        3. 14458, Ростов-на-Дону, ул. Мира, д. 213
        4. 15769, Ставрополь, ул. Ленина, д. 248
    """.trimIndent()
    //val addresses = ""

    val list: List<Address>? = parseAddresses(addresses)

    list?.forEach { println(it) }

    println(list?.let { maxIndex(it)?.index })
    println(list?.let { minIndex(it)?.index })
    println(list?.let { bigStreet(it)?.street })
    println(list?.let { shortStreet(it)?.street })
}