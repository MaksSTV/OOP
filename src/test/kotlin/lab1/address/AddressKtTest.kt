package lab1.address

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class AddressKtTest {

    @Test
    fun parseAddresses() {
        val addresses = """
        1. 12389, Санкт-Петербург, ул. Новоизмайловский проспект, д. 15
        2. 15769, Ставрополь, ул. Ленина, д. 248
    """.trimIndent()

        val list: List<Address>? = parseAddresses(addresses)

        val secondList: List<Address> = listOf(
            Address(12389, "Санкт-Петербург", "Новоизмайловский проспект", 15),
            Address(15769, "Ставрополь", "Ленина", 248)
        )

        assertNotNull(list)
        assertEquals(list, secondList)
    }

    @Test
    fun maxIndex() {

        val list: List<Address> = listOf(
            Address(12389, "Санкт-Петербург", "Новоизмайловский проспект", 15),
            Address(15769, "Ставрополь", "Ленина", 248)
        )
        assertNotNull(maxIndex(list))
        assertEquals(maxIndex(list), list[1])

    }

    @Test
    fun minIndex() {
        val list: List<Address> = listOf(
            Address(12389, "Санкт-Петербург", "Новоизмайловский проспект", 15),
            Address(15769, "Ставрополь", "Ленина", 248)
        )
        assertNotNull(minIndex(list))
        assertEquals(minIndex(list), list[0])
    }

    @Test
    fun bigStreet() {
        val list: List<Address> = listOf(
            Address(12389, "Санкт-Петербург", "Новоизмайловский проспект", 15),
            Address(15769, "Ставрополь", "Ленина", 248)
        )
        assertNotNull(bigStreet(list))
        assertEquals(bigStreet(list), list[0])

    }

    @Test
    fun shortStreet() {
        val list: List<Address> = listOf(
            Address(12389, "Санкт-Петербург", "Новоизмайловский проспект", 15),
            Address(15769, "Ставрополь", "Ленина", 248)
        )
        assertNotNull(shortStreet(list))
        assertEquals(shortStreet(list), list[1])
    }
}