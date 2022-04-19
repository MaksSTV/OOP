package lab3

sealed class Contact {
    data class Phone(val phone: String, val phoneType: PhoneType) : Contact()

    data class Email(val email: String) : Contact()

    data class Link(val socialNetwork: String, val url: String) : Contact()

    data class Address(val city: String, val street: String, val building: String, val numberHome: String) : Contact()
}

data class Person(val firstName: String, val secondName: String)