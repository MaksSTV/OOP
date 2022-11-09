package parse_xml_csv

import parse_xml_csv.model.Parse
import java.io.File


//C:\Users\Maks\Downloads\address.xml
//C:\Users\Maks\Downloads\address.csv
fun main(){

    println("Hello, please enter the path to the file ")
    println("Press 0 to exit")

    val parse = Parse()

    while(true){
        val path = File(readLine().toString())
        val pathFile = path.toString().substringAfterLast('.')

        if(pathFile == "xml"){
            parse.XML(path)
        }
        else if(pathFile == "csv"){
            parse.CSV(path)
        }
        else if(pathFile == "0"){
            println("Exit")
            return
        }
        else{
            println("Try again")
            println("Press 0 to exit")
        }
    }

}