package parse_xml_csv.model

import org.apache.commons.csv.CSVFormat
import org.apache.commons.csv.CSVParser
import java.io.File
import javax.xml.parsers.DocumentBuilderFactory
import org.w3c.dom.Node
import java.nio.file.Files
import java.nio.file.Paths


class Parse {

    private var listOfAddress = HashMap<Address, Int>()

    fun XML(path: File){
        listOfAddress.clear()
        val dbf = DocumentBuilderFactory.newInstance()
        val doc = dbf.newDocumentBuilder().parse(path)
        val nodeList = doc.firstChild.childNodes

        for (i in 0 until nodeList.length) {

            if (nodeList.item(i).nodeType != Node.ELEMENT_NODE) {
                continue
            }
            val content = nodeList.item(i).attributes
            val city = content.item(0).textContent
            val street = content.item(3).textContent
            val house = content.item(2).textContent.toInt()
            val floor = content.item(1).textContent.toInt()
            val address = Address(city, street, house, floor)
            if(!listOfAddress.containsKey(address)){
                listOfAddress.put(address, 1)
            }
            else{
                val one = 1
                listOfAddress.put(address, listOfAddress.get(address)?.plus(one)!! )
            }
        }

        Print(listOfAddress)
    }

    fun CSV(path: File){
        listOfAddress.clear()
        val bufferedReader = Files.newBufferedReader(Paths.get(path.toString()))

        val csvParser = CSVParser(bufferedReader, CSVFormat.DEFAULT
            .withDelimiter(';')
            .withFirstRecordAsHeader()
            .withIgnoreHeaderCase()
            .withTrim());

        for (csvRecord in csvParser) {
            val city = csvRecord.get("city")
            val street = csvRecord.get("street")
            val house = csvRecord.get("house").toInt()
            val floor = csvRecord.get("floor").toInt()
            val address = Address(city, street, house, floor)
            if(!listOfAddress.containsKey(address)){
                listOfAddress.put(address, 1)
            }
            else{
                val one = 1
                listOfAddress.put(address, listOfAddress.get(address)?.plus(one)!! )
            }
        }
        Print(listOfAddress)
    }
}