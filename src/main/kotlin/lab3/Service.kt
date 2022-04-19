package lab3

import org.apache.logging.log4j.LogManager

private val LOG = LogManager.getLogger(Service::class.java)

class Service : ContactsService {
    private val service: MutableMap<Person, MutableList<Contact>> = mutableMapOf()

    override fun addContact(person: Person, contact: Contact) {
        service.getOrPut(person) { mutableListOf() }.add(contact)
        LOG.info("add contact $contact for person $person")
    }

    override fun removeContact(person: Person, contact: Contact) {
        val temp = service.get(person)
        if (temp != null) {
            temp.remove(contact)
            LOG.info("remove $contact for person $person")
        } else {
            error("This is impossible")
        }
        //service.get(person).remove(contact)
    }

    override fun removePerson(person: Person) {
        if (service.get(person) != null) {
            service.remove(person)
            LOG.info("remove person $person")
        } else {
            error("This is impossible")
        }
    }

    override fun addPhone(person: Person, phone: String, phoneType: PhoneType) {
        service.getOrPut(person) { mutableListOf() }.add(Contact.Phone(phone, phoneType))
        LOG.info("add phone $phone and type phone $phoneType for person $person")
    }

    override fun addEmail(person: Person, email: String) {
        service.getOrPut(person) { mutableListOf() }.add(Contact.Email(email))
        LOG.info("add email $email for person $person")
    }

    override fun addLink(person: Person, socialNetwork: String, url: String) {
        service.getOrPut(person) { mutableListOf() }.add(Contact.Link(socialNetwork, url))
        LOG.info("add social network $socialNetwork and url $url for person $person")
    }

    override fun addAddress(person: Person, city: String, street: String, building: String, numberHome: String) {
        service.getOrPut(person) { mutableListOf() }.add(Contact.Address(city, street, building, numberHome))
        LOG.info("add address for person $person, city $city, street $street, building $building, number home $numberHome")
    }

    override fun getPersonContacts(person: Person): List<Contact> {
        val contactOfPerson = service.get(person)
        return if (contactOfPerson != null) {
            LOG.info("return person $person and his contacts $contactOfPerson")
            contactOfPerson.toList()
        } else {
            LOG.info("person $person and his contacts = null")
            emptyList()
        }
    }

    override fun getPersonPhones(person: Person): List<Contact.Phone> {
        val phonesOfPerson = service.get(person)
        return if (phonesOfPerson != null) {
            LOG.info("return person $person and his phones ${phonesOfPerson.filterIsInstance<Contact.Phone>()}")
            phonesOfPerson.filterIsInstance<Contact.Phone>()
        } else {
            LOG.info("person $person and his phones = null")
            emptyList()
        }
    }

    override fun getPersonEmails(person: Person): List<Contact.Email> {
        val emailsOfPerson = service.get(person)
        return if (emailsOfPerson != null) {
            LOG.info("person $person and his emails ${emailsOfPerson.filterIsInstance<Contact.Email>()}")
            emailsOfPerson.filterIsInstance<Contact.Email>()
        } else {
            LOG.info("person $person and his emails = null")
            emptyList()
        }
    }

    override fun getPersonLinks(person: Person): List<Contact.Link> {
        val linksOfPerson = service.get(person)
        return if (linksOfPerson != null) {
            LOG.info("person $person and his links ${linksOfPerson.filterIsInstance<Contact.Link>()}")
            linksOfPerson.filterIsInstance<Contact.Link>()
        } else {
            LOG.info("person $person and his links = null")
            emptyList()
        }
    }

    override fun getPersonAddress(person: Person): List<Contact.Address> {
        val addressOfPerson = service.get(person)
        return if (addressOfPerson != null) {
            LOG.info("person $person and his address ${addressOfPerson.filterIsInstance<Contact.Address>()}")
            addressOfPerson.filterIsInstance<Contact.Address>()
        } else {
            LOG.info("person $person and his address = null")
            emptyList()
        }
    }

    override fun getAllPersons(): List<Person> {
        LOG.info("return list all persons ${service.keys.toList()}")
        return service.keys.toList()
    }

    override fun getAllContacts(): Map<Person, List<Contact>> {
        LOG.info("return list all persons and their contacts ${service.toMap()}")
        return service.toMap()
    }

    //@ExperimentalStdlibApi
    override fun findUsingSubstring(substring: String): List<Person> {
        /*return buildList {
            service.keys.forEach {
                if((it.firstName.contains(substring)) || (it.secondName.contains(substring))){
                    this.add(it)
                }
            }
        }*/
        // below equivalent?
        LOG.info("find list of persons ${service.keys.filter { substring in "${it.firstName} ${it.secondName}" }} using substring $substring")
        return service.keys.filter { substring in "${it.firstName} ${it.secondName}" }
    }
}