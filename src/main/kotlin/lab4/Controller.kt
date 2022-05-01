package lab4

import lab4.Move.DOWN
import lab4.Move.LEFT
import lab4.Move.STOP
import lab4.Move.UP
import lab4.Move.RIGHT
import lab4.State.IN_MOVE

class Controller(private val model: Model) {
    init {
        startGame()
    }

    private fun startGame() {
        while (model.state == IN_MOVE) {
            try {
                val input = readLine()!!.toCharArray()[0]
                val move = when (input) {// don`t work readln() Unresolved reference: readln
                    'w' -> UP
                    'a' -> LEFT
                    's' -> DOWN
                    'd' -> RIGHT

                    else -> {
                        STOP
                    }
                }
                model.doMove(move)
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }
}