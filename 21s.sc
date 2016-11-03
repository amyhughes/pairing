type Card = Int
type Hand = List[Card]
case class Deck(deck: List[Card])
object Deck {
  val numbers: List[Card] = List.range(2,11)
  val suit: List[Card] = 10 :: 10 :: 10 :: 11 :: numbers
  def initialise : List[Card] = suit ::: suit ::: suit ::: suit
  def shuffle(cards : List[Card]) : List[Card] = {
    scala.util.Random.shuffle(cards)
  }
  def dealCard(deck: List[Card]) = {
    val dealtCard = deck.head
    val remainingCards = deck.tail
    (dealtCard, remainingCards)
  }
}
case class Player(name: String, hand: Hand)
object Player {
  def create(name: String): Player = {
    val initialHand: Hand = Nil
    Player(name, initialHand)
  }
  def score(player: Player): Int = {
    player.hand.sum
  }
  def hasWon(player: Player): Boolean = score(player) match {
    case 21 => true
    case _ => false
  }

  def hasLost(player: Player): Boolean = score(player) match {
    case x if x > 21 => true
    case _ => false
  }
}

case class Game(players: List[Player], winners: List[Player])
object Game {
  val sam = Player.create("Sam")
  val dealer = Player.create("Dealer")
  val initialDeck = Deck.shuffle(Deck.initialise)

  def doubleDeal(deck: List[Card], hand: Hand) = {
    val (card1: Card, hand1) = Deck.dealCard(deck)
    val (card2 : Card, hand2) =  Deck.dealCard(hand1)
    val newHand = card2 :: card1 :: hand
    val newDeck = hand2
    (newDeck, newHand)
  }

  def singleDeal(deck: List[Card], hand: Hand)= {
    val (dealtCard, remainingCards) = Deck.dealCard(deck)
    val newHand = remainingCards
    val newDeck = dealtCard :: hand
    (newDeck, newHand)
  }



  val deal1 = doubleDeal(initialDeck, sam.hand)
  val deal2 = doubleDeal(deal1.newDeck, dealer.hand)

  println(Player.score(sam))
  println(Player.score(dealer))
}























