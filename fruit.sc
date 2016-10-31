import java.util.Random

type Colour = String
val black: Colour = "black"
val white: Colour = "white"
val green: Colour = "green"
val yellow: Colour = "yellow"
val gameCost: Float = 1.0f

// type
case class Machine(slot1: Colour, slot2: Colour,
                   slot3: Colour, slot4: Colour,
                   jackpot: Float)

case class Player(money: Float)

// When returning an instance of a type, it's called
// a factory method. Put factory methods in a companion
// object. This, by definition, has the same name as
// the type that it is creating
object Machine {
  val colours = List(black, white, green, yellow)
  val rand = new Random(System.currentTimeMillis())
  def randomIndex = rand.nextInt(colours.length)

  val winningCombinations: List[List[Colour]] = List(
    List("black","black","black","black"),
    List("white","white","white","white"),
    List("green","green","green","green"),
    List("yellow","yellow","yellow","yellow")
  )

  def round(beforeRound: Machine): Machine = {
    val slots : List[Colour] = List(colours(randomIndex),
    colours(randomIndex), colours(randomIndex),
    colours(randomIndex))

    winningCombinations.find(x => x == slots) match {
      case Some(_) => Machine(slots(0), slots(1), slots(2),
        slots(3), beforeRound.jackpot + gameCost)
      case None => Machine(slots(0), slots(1), slots(2),
        slots(3), 0f)
    }

    // if outcome a winning outcome,
    // return machine with float = 0
    // else return machine with float = before.float + gameCost

    Machine(colours(randomIndex), colours(randomIndex),
      colours(randomIndex), colours(randomIndex))
  }
}

def game(beforeGame: Player): Player = {
  val outcome = Machine.round
  // if outcome a winning outcome,
  // return player with money = beforeGame.money - gameCost
  // + winnings
  // else return player with beforeGame.money - gameCost
}

Machine.round