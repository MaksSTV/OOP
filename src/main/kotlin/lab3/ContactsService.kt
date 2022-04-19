package lab3

interface ContactsService {
    fun addContact(person: Person, contact: Contact)
    fun removeContact(person: Person, contact: Contact)
    fun removePerson(person: Person)

    fun addPhone(person: Person, phone: String, phoneType: PhoneType)
    fun addEmail(person: Person, email: String)
    fun addLink(person: Person, socialNetwork: String, url: String)
    fun addAddress(person: Person, city: String, street: String, building: String, numberHome: String)

    fun getPersonContacts(person: Person): List<Contact>
    fun getPersonPhones(person: Person): List<Contact.Phone>
    fun getPersonEmails(person: Person): List<Contact.Email>
    fun getPersonLinks(person: Person): List<Contact.Link>
    fun getPersonAddress(person: Person): List<Contact.Address>

    fun getAllPersons(): List<Person>
    fun getAllContacts(): Map<Person, List<Contact>>

    fun findUsingSubstring(substring: String): List<Person>
}