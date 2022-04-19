package lab3

//@ExperimentalStdlibApi
fun main() {
    val service = Service()
    service.addContact(Person("Maksim", "Strelnikov"), Contact.Phone("+79614448905", PhoneType.HomePhone))
    service.addContact(Person("Andrew", "Third"), Contact.Phone("+79613372281", PhoneType.HomePhone))
    service.addContact(Person("Sasha", "First"), Contact.Phone("+79617894561", PhoneType.HomePhone))
    service.addContact(Person("Maksim", "Strelnikov"), Contact.Phone("+78005553555", PhoneType.WorkPhone))
    service.addContact(Person("Maksim", "Strelnikov"), Contact.Phone("458732", PhoneType.MobilePhone))
    service.addLink(Person("Maksim", "Strelnikov"), "vkontakte", "https://vk.com/gukislav")
    service.addEmail(Person("Maksim", "Strelnikov"), "maksim_stv@mail.ru")
    service.addEmail(Person("Maksim", "Strelnikov"), "masssim_stv@mail.ru")
    service.removeContact(Person("Maksim", "Strelnikov"), Contact.Email("masssim_stv@mail.ru"))
    service.addAddress(Person("Maksim", "Strelnikov"), "Saint-Petersburg", "Novoizmaylovski prospekt", "16", "4")

    service.addContact(Person("Masha", "Sun"), Contact.Phone("+79611234567", PhoneType.HomePhone))
    service.addPhone(Person("Dasha", "Second"), "+2849284982", phoneType = PhoneType.HomePhone)

    println(service.getAllPersons())
    println(service.getAllContacts())
    println()
    println(service.getPersonPhones(Person("Maksim", "Strelnikov")))
    println(service.getPersonEmails(Person("Maksim", "Strelnikov")))
    println(service.getPersonAddress(Person("Maksim", "Strelnikov")))
    println(service.getPersonLinks(Person("Maksim", "Strelnikov")))
    println(service.getPersonContacts(Person("Maksim", "Strelnikov")))
    println()
    println(service.findUsingSubstring("sha"))
}