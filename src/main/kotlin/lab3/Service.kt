package lab3

class Service: ContactsService {
    private val service: MutableMap<Person, MutableList<Contact>> = mutableMapOf()

    override fun addContact(person: Person, contact: Contact) {
        //service[person] = contact
        service[person]!!.add(contact) // []. - https://kotlinlang.ru/docs/reference/map-operations.html
        // is it possible to do otherwise via service.put(person, "I do not understand")?
        println("sjdkskdj")
    }
    override fun removeContact(person: Person, contact: Contact){
        //service[person]?.remove(contact)
    }
    override fun removePerson(person: Person){
        service.remove(person)
    }

    override fun getSize(): Int {
        return service.size
    }


    override fun addPhone(person: Person, phone: String, phoneType: PhoneType){
        //service[person]?.add(Contact.Phone(phone,phoneType))
        println("sjdkskdj")
    }
    override fun addEmail(person: Person, email: String){
        //service[person]?.add(Contact.Email(email))
    }
    override fun addLink(person: Person, socialNetwork: String, url: String){
       // service[person]?.add(Contact.Link(socialNetwork,url))
    }
    override fun addAddress(person: Person, city: String, street: String, building: String, numberHome: String){
       // service[person]?.add((Contact.Address(city,street,building,numberHome)))
    }

    override fun getPersonContacts(person: Person): List<Contact>{
        return emptyList()
    }
    override fun getPersonPhones(person: Person): List<Phone>{
        return emptyList()
    }
    override fun getPersonEmails(person: Person): List<Email>{
        return emptyList()
    }
    override fun getPersonLinks(person: Person): List<Link>{
        return emptyList()
    }
    override fun getPersonAddress(person: Person): List<Address>{
        return emptyList()
    }

    @OptIn(ExperimentalStdlibApi::class)
    override fun getAllPersons(): List<Person> {
        return buildList {
            service.keys.forEach {
                this.add(it)
            }
        }
    }
    override fun getAllContacts(): Map<Person, List<Contact>>{
        return emptyMap()
    }

    override fun findUsingSubstring(substring: String): List<Person>{
        return emptyList()
    }
}