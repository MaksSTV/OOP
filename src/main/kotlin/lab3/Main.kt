package lab3


fun main(){
    val abc = Service()
    abc.addContact(Person("Maksim", "Strelnikov"), Phone("+79614448905", PhoneType.HomePhone))
    abc.addContact(Person("ывфыв", "фывыфв"), Phone("+79614448905", PhoneType.HomePhone))
    abc.addContact(Person("Mфывфыв", "фывффва"), Phone("+79614448905", PhoneType.HomePhone))
    println(abc.getSize())

    abc.addContact(Person("Maksim", "Strelnikov"), Phone("+79614448905", PhoneType.HomePhone))
    abc.addPhone(Person("Maksim", "Strelnikov"), "+2849284982", phoneType = PhoneType.HomePhone)

    println(abc.getAllPersons())
}