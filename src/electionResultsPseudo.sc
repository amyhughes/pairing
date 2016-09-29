def readFile(file: String): Array[String]

def codeToPartyName(s: String): String = ???

def fromRowToConstituencyVotes(s: String): ConstituencyVotes = ???

case class ConstituencyVotes(const: String, results: Map[String, Int])

case class ConstituencyShare(const: String, results: Map[String, Float])

object ConstituencyShare {

  def calculateShare(const: List[ConstituencyVotes]): List[ConstituencyShare] = ???
}





//type Code = String
//type Result = Int
//type FullName = String
//type ResultShare = Float
//
//def readFile(file: String) : Array[String] = ???
//
//case class Constituency(name: String, results: Map[Code, Result])
//
////case class Constituency2(name: String, C: Int, L: Int, UKIP: Int, LD: Int, G: Int, Ind: Int, SNP: Int)
//
//case class ConstituencyResult(name: String, results: Map[FullName, ResultShare])

