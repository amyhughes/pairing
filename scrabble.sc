case class Tile(letter: String, score: Int)
type Word = Seq[Tile]

case class Rack(letters: List[Tile])
object Rack {
  def apply: List[Tile] = {
    val letters = LetterBag.apply //Seq(Tile("a",1), Tile("b",2), Tile("c",1))
    val r = scala.util.Random
    def randomIndex = r.nextInt(letters.length)
    val rackPlaces = List.range(0,7)
    val rack = rackPlaces.map(_ => letters(randomIndex))
    rack
  }
}

case class LetterBag(letters: List[Tile])
object LetterBag {
  import scala.io.Source
  val listOfLines = Source.fromFile("/Users/ahughes/pairing/Resources/scrabble-letters.txt").getLines.toList
  def getTilesWithCount(line: String): (Tile, Int) = {
    val Array(tile, count, value) = line.split("\t")
    (Tile(tile, value.toInt), count.toInt)
  }
  def apply: List[Tile] ={
    listOfLines.map(getTilesWithCount(_)).flatMap(x => List.fill(x._2)(x._1))
  }

}

def wordScore(word: Word) = {
  val letterScores = word.map(_.score)
  val wordScore = letterScores.sum //fold(0)(_+_)
  wordScore
}

val tile1 = Tile("a", 1)
val tile2 = Tile("b", 2)

val score = wordScore(Seq(tile1, tile2))
val rack = Rack.apply

//import org.scalatest.{FlatSpec, Matchers}
//
//class TestSetup extends FlatSpec with Matchers {
//
//}