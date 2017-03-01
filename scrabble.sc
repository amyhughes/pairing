case class Tile(letter: String, score: Int)
type Word = Seq[Tile]

case class Rack(letters: List[Tile])
object Rack {
  def apply = {
    val letters = Seq(Tile("a",1), Tile("b",2), Tile("c",1))
    val r = scala.util.Random
    def randomIndex = r.nextInt(letters.length)
    val rackPlaces = List.range(0,7)
    val rack = rackPlaces.map(_ => letters(randomIndex))
    rack
  }
}

import scala.io.Source
val listOfLines = Source.fromFile("/Users/ahughes/pairing/Resources/scrabble-letters.txt").getLines.toList



def wordScore(word: Word) = {
  val letterScores = word.map(_.score)
  val wordScore = letterScores.fold(0)(_+_)
  wordScore
}

val tile1 = Tile("a", 1)
val tile2 = Tile("b", 2)

wordScore(Seq(tile1, tile2))
println(Rack.apply)







//import org.scalatest.{FlatSpec, Matchers}
//
//class TestSetup extends FlatSpec with Matchers {
//
//}