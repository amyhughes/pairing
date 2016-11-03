import java.util.Random

type Colour = String
val black: Colour = "black"
val white: Colour = "white"
val green: Colour = "green"
val yellow: Colour = "yellow"
val gameCost: Float = 1.0f

case class Slots(slot1: Colour, slot2: Colour,
                   slot3: Colour, slot4: Colour)

case class Machine(jackpot: Float)

case class Player(money: Float)

case class Game(player: Player, machine: Machine)

object Machine {
  def apply(initialJackpot: Float, slotState: Boolean) : Machine = {
    slotState match {
      case true => Machine(0f)
      case false => Machine(initialJackpot + gameCost)
    }
  }
}

object Player {
  def apply(initialMoney: Float, winnings: Float) : Player = {
    Player(initialMoney - gameCost + winnings)
  }
}

object Slots {
  def apply() : Slots = {
    val colours = List(black, white, green, yellow)
    val rand = new Random(System.currentTimeMillis())
    def randomIndex = rand.nextInt(colours.length)
    Slots(colours(randomIndex), colours(randomIndex),
      colours(randomIndex), colours(randomIndex))
  }
  def isWinningCombo(slots: Slots) : Boolean = {
    val colours = List(slots.slot1, slots.slot2,
      slots.slot3, slots.slot4)
    colours.forall( colour => colour == colours.head)
  }
}

object Game {
  def apply(beforePlayer: Player, beforeMachine: Machine) : Game = {
    val initialJackpot = beforeMachine.jackpot
    val initialMoney = beforePlayer.money
    val slotResult = Slots.apply()
    val slotState = Slots.isWinningCombo(slotResult)
    val machine = Machine.apply(initialJackpot, slotState)
    val player = Player.apply(initialMoney, machine.jackpot)
    println("Player: "+ player.toString + " " +
      "Machine: " + machine.toString)

    Game(player, machine)
  }
}

val player = Player(10f)
val machine = Machine(100f)
Game.apply(player, machine)




// When returning an instance of a type, it's called
// a factory method. Put factory methods in a companion
// object. This, by definition, has the same name as
// the type that it is creating

