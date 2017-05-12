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
  def apply: List[Tile] = {
    listOfLines.map(getTilesWithCount(_)).flatMap(x => List.fill(x._2)(x._1))
  }
}

val validWords: List[String] = "cat" :: "dog" :: Nil

def findWord(rack: List[Tile]): String = {
  val tileLetters = rack.flatMap(_.letter.toUpperCase.toCharArray)
  val wordLetters = validWords.map(_.toList)

  ???
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

// Use "model" data structures to begin with before replacing with real
// Handy things to do with lists: List.range(x,y), list_name(index) for element,
// el :: Nil to create new list, list_name.sum, list_name.fold(identity)(function)
// Generating random numbers: scala.util.Random, nextInt(n: Int)
// named tuples good for readability


//import org.scalatest.{FlatSpec, Matchers}
//
//class TestSetup extends FlatSpec with Matchers {
//
//}