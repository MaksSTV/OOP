package parse_xml_csv.model

fun countFloor(hashMap: HashMap<Address, Int>){

    val floor = HashMap<String, Floor>()

    hashMap.forEach{ it ->
        if(!floor.containsKey(it.key.city)){
            floor.put(it.key.city, Floor())
        }
        else{
            val temp = 1
            if(it.key.floor == 1){
                floor[it.key.city]?.one = floor[it.key.city]?.one?.plus(temp)!!
            }
            else if(it.key.floor == 2){
                floor[it.key.city]?.two = floor[it.key.city]?.two?.plus(temp)!!
            }
            else if(it.key.floor == 3){
                floor[it.key.city]?.three = floor[it.key.city]?.three?.plus(temp)!!
            }
            else if(it.key.floor == 4){
                floor[it.key.city]?.four = floor[it.key.city]?.four?.plus(temp)!!
            }
            else{
                floor[it.key.city]?.five = floor[it.key.city]?.five?.plus(temp)!!
            }
        }
    }

    printCount(floor)
}

fun printCount(floor: HashMap<String, Floor>){
    floor.forEach{
        println("В городе ${it.key}: ${it.value.one} одноэтажек, ${it.value.two} двухэтажек, ${it.value.three} трехэтажек, ${it.value.four} четерехэтажек, ${it.value.five} пятиэтажек,")
    }
}