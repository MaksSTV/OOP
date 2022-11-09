package parse_xml_csv.model

fun Print(hashMap: HashMap<Address, Int>){
    hashMap.forEach{
        if(it.value != 1){
            println("По адресу ${it.key.city} ${it.key.street} дом ${it.key.house} этаж ${it.key.floor} в файле ${it.value} повторений")
        }
    }

    countFloor(hashMap)
}