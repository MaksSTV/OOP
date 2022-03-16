package lab1.address

data class Address(val index: Int, val town: String, val street: String, val number: Int) {
    override fun toString(): String {
        return "Index: $index, Town: $town, Street: $street, Number Building: $number" // https://metanit.com/kotlin/tutorial/4.12.php
    }
}

fun parseAddresses(addresses: String): List<Address>? {
    if (addresses.isEmpty()) {
        return null
    }

    val listTemp: List<String> = addresses.lines()
    val mutableList = mutableListOf<Address>()

    listTemp.forEach { customName ->
        val parts = customName.split(",")
        val temp = parts[0].split(".")
        val index = temp[1].drop(1).toInt()
        val town = parts[1].drop(1)
        val street = parts[2].drop(5)
        val number = parts[3].filter { it.isDigit() }.toInt()

        val storage = Address(index, town, street, number)
        mutableList.add(storage) // it's OK
    }

    return mutableList
}

fun maxIndex(addresses: List<Address>): Address? {
    return addresses.maxByOrNull { it.index }
}

fun minIndex(addresses: List<Address>): Address? {
    return addresses.minByOrNull { it.index }
}

fun bigStreet(addresses: List<Address>): Address? {
    return addresses.maxByOrNull { it.street.length }
}

fun shortStreet(addresses: List<Address>): Address? {
    return addresses.minByOrNull { it.street.length }
}