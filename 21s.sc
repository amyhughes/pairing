type Card = Int

val numbers: List[Card] = List.range(2,11)
val suit: List[Card] = 10 :: 10 :: 10 :: 11 :: numbers

val fullDeck : List[Card] = suit ::: suit ::: suit ::: suit

def shuffle(cards : List[Card]) : List[Card] = {
  util.Random.shuffle(cards)
}

var deck: List[Card] = Nil
var samHand : List[Card] = Nil
var dealerHand: List[Card] = Nil

def dealCard() : Card = {
  deck = deck.tail
  deck.head
}

def score(hand : List[Card]) : Int = {
  hand.sum
}

def hasWon(score: Int) : Boolean = score match {
  case 21 => true
  case _ => false
}

var gameOver : Boolean = false

//round 1
deck = shuffle(fullDeck)
deck.size
samHand = dealCard() :: samHand
samHand = dealCard() :: samHand
dealerHand = dealCard() :: dealerHand
dealerHand = dealCard() :: dealerHand
samHand
val samScore1 = score(samHand)
val samWon = hasWon(samScore1)
if (samWon) gameOver = true
val dealerScore1 = score(dealerHand)
val dealerWon = hasWon(dealerScore1)
if (dealerWon) gameOver = true
if (!gameOver) samHand = dealCard() :: samHand























