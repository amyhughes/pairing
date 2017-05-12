import scala.util.Random

type Card = Int

case class Deck(deck: List[Card])

object Deck {
  def apply: List[Card] = {
    val numberVals = List.range(1,11)
    val numbers = numberVals.flatMap(n => List.fill(4)(n))
    val royalVals = 10 :: 10 :: 10 :: 11 :: Nil
    val royals = royalVals.flatMap(r => List.fill(4)(r))
    royals ::: numbers
  }
}

case class Game(winner: Player)

object Game {
  def apply = {
    val initialDeck = Deck.apply
    val shuffledDeck = Random.shuffle(initialDeck)
    def takeTwo(deck: List[Card]): List[Card] = {
      List(deck(1), deck(2))
    }

  }
}

val sd = Game.apply

case class Player(hand: List[Card])


val samHand: List[Card] = ???
val dealerHand: List[Card] = ???
val Sam = Player(samHand)
val Dealer = Player(dealerHand)


//println(Deck.apply)

