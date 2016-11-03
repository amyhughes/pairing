import java.io.InputStream
import scala.io.Source
type Code = String
type FullName = String
type ResultShare = Float
type Constituency = String
//type RawResult = (Constituency, List[(Code, Result)])

case class RawConstituencyResult (constituency: Constituency, constituencyResults: List[(Code, Int)])
case class ConstituencyResult (constituency: Constituency, constituencyResults: List[(FullName, ResultShare)])

object RawConstituencyResult {

  def getPartyName(code: Code) : FullName = code match {
    case "C" => "Conservative Party"
    case "L" => "Labour Party"
    case "UKIP" => "UKIP"
    case "LD" => "Liberal Democrats"
    case "G" => "Green Party"
    case "Ind" => "Independent"
    case "SNP" => "SNP"
    //case _ => console.log(_.toString() + " is not recognised as a party code")
  }

  def processRawResult(rawResult : RawConstituencyResult) : ConstituencyResult = {
    val constituency = rawResult.constituency
    val resultTotal: Int = rawResult.constituencyResults.map(result => result._2).sum
    val processedResultList : List[(FullName, ResultShare)] = rawResult.constituencyResults.map{
      { case (partyCode, votes)  => (getPartyName(partyCode), (votes).toFloat/resultTotal) }
    }
    ConstituencyResult(constituency, processedResultList)
  }

}

case class File(filePath: String)

object File {

  def getFileLinesAsArray(fileName: String) = {
    val fileLines: List[String] = Source.fromFile(fileName).getLines.toList
    fileLines
  }

  def getRawConstituencyResult(fileLine: String): RawConstituencyResult = {

    val constituency: Constituency = fileLine.split(",").head
    val results = fileLine.split(", ").tail
    val resultPairs = results.sliding(2, 2).toList
    val constituencyResults: List[(Code, Int)] = resultPairs.map { case Array(resultString, code) => (code, resultString.toInt) }

    RawConstituencyResult(constituency, constituencyResults)
  }

}

File.getFileLinesAsArray("/Users/ahughes/pairing/Resources/results.txt")



//
//
//
//
//
//
//
//
//case class Party(code: String, fullName: String)
//object Party {
//  def getFullName(code: Code) : FullName = code match {
//    case "C" => "Conservative Party"
//    case "L" => "Labour Party"
//    case "UKIP" => "UKIP"
//    case "LD" => "Liberal Democrats"
//    case "G" => "Green Party"
//    case "Ind" => "Independent"
//    case "SNP" => "SNP"
//    //case _ => console.log(_.toString() + " is not recognised as a party code")
//  }
//}
//case class PartyResult(party: Party, rawResult: Int, resultShare: Double)
//object PartyResult {
//  def getResultShare(partyResult: RawConstituencyResult, allResults: List[Result]): ResultShare = {
//    partyResult / allResults.sum
//  }
//  def getPartyResults(results: List[]) = {
//
//  }
//
//}
//
//val testLine = "Cardiff West, 11014, C, 17803, L, 4923, UKIP, 2069, LD"
//val rawResult: RawConstituencyResult = File.getRawConstituencyResult(testLine)
//val processedResult = rawResult.
//
//
////val fullNameResults = results.map( result => (Party.getFullName(result._1), result._2) )
////val allResults : List[RawResult] = results.map( result => result._2)
//
//
//
////.map{ (code,result) => code }//_ => ( Party.getFullName(_.1), _.2 ) }
//
//
//
//
//

