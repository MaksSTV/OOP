package lab3

sealed class Contact(){}

data class Person(val firstName: String, val secondName: String)

data class Phone(val number: String, val phoneType: PhoneType): Contact()

enum class PhoneType {
    MobilePhone, HomePhone, WorkPhone
}

data class Email(val email: String): Contact()

data class Link(val socialNetwork: String, val url: String): Contact()

data class Address(val city: String, val street: String, val building: String, val numberHome: String): Contact()
// add phone, and it types - done
// add email - done
// add link - done
// add address - done

interface ContactsService {
    fun addContact(person: Person, contact: Contact): Contact
    fun removeContact(person: Person, contact: Contact)
    fun removePerson(person: Person)

    fun addPhone(person: Person, phone: String, phoneType: PhoneType)
    // add email
    // add link
    // add address

    fun getPersonContacts(person: Person): List<Contact>
    fun getPersonPhones(person: Person): List<Contact.Phone>
    // get emails
    // get links

    fun getAllPersons(): List<Person>
    fun getAllContacts(): Map<Person, List<Contact>>

    // find
}

fun main(){}