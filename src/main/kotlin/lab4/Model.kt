package lab4

import java.io.File

fun readInput(): Map<Pair<Int, Int>, Char> { //https://www.youtube.com/watch?v=LvCcUUrXVto
    val input = File("C:\\Users\\Maks\\IdeaProjects\\OOP\\src\\main\\kotlin\\lab4\\input")
        .readLines()
        .withIndex()
        .flatMap { indexedValue ->
            val xCoordinate = indexedValue.index
            indexedValue.value
                .toCharArray()
                .withIndex()
                .map { indexedChar ->
                    val yCoordinate = indexedChar.index
                    (xCoordinate to yCoordinate) to indexedChar.value
                }
        }
        .toMap()
    return input
}

enum class Move(private val textValue: String) {
    LEFT("Left"),
    UP("Up"),
    RIGHT("Right"),
    STOP("Stop"),
    DOWN("Down");

    override fun toString(): String = textValue
}

enum class State(private val textValue: String) {
    IN_MOVE("Waiting for move..."),
    WIN("Game finished.");

    override fun toString(): String = textValue
}

interface ModelChangeListener {
    fun onModelChanged()
}

data class Position(var first: Int, var second: Int) //Since there is no mutable pair, we use the date class

class Model {
    private var board = readInput().toMutableMap()

    var state: State = State.IN_MOVE

    private val listeners: MutableSet<ModelChangeListener> = mutableSetOf()

    fun addModelChangeListener(listener: ModelChangeListener) {
        listeners.add(listener)
    }

    fun removeModelChangeListener(listener: ModelChangeListener) {
        listeners.remove(listener)
    }

    private fun notifyListeners() {
        listeners.forEach { it.onModelChanged() }
    }

    private val heightMap = board.keys.maxOf { it.first }
    private val widthMap = board.keys.maxOf { it.second }

    private var startMaze = Position(
        board.filter { it.value == 'S' }.keys.first().second,
        board.filter { it.value == 'S' }.keys.first().first
    )

    private var endMaze = Position(
        board.filter { it.value == 'E' }.keys.first().second,
        board.filter { it.value == 'E' }.keys.first().first
    )

    private var currentPosition = startMaze

    fun doMove(move: Move) {
        require(state == State.IN_MOVE) { "Game finished" }
        if (((move == Move.RIGHT) && (board.get(Pair(currentPosition.second, currentPosition.first + 1)) == '#')) ||
            ((move == Move.LEFT) && (board.get(Pair(currentPosition.second, currentPosition.first - 1)) == '#')) ||
            ((move == Move.UP) && (board.get(Pair(currentPosition.second - 1, currentPosition.first)) == '#')) ||
            ((move == Move.DOWN) && (board.get(Pair(currentPosition.second + 1, currentPosition.first)) == '#')) ||
            ((move == Move.UP) && (currentPosition.second == 0)) ||
            ((move == Move.DOWN) && (currentPosition.second == heightMap)) ||
            ((move == Move.RIGHT) && (currentPosition.first == widthMap)) ||
            ((move == Move.LEFT) && (currentPosition.first == 0))

        ) { // "Hello optimization"
            throw IllegalArgumentException("there is no through path")
        } else {
            when (move) { //Since there is no mutable pair, we use the date class
                // 'currentPosition.second++' - dont work with Pair
                //  private var startMaze = Pair(
                //        board.filter { it.value == 'S' }.keys.first().second,
                //        board.filter { it.value == 'S' }.keys.first().first
                //    )
                Move.UP -> currentPosition.second--
                Move.LEFT -> currentPosition.first--
                Move.RIGHT -> currentPosition.first++
                Move.DOWN -> currentPosition.second++
                else -> return
            }
        }

        state = if (currentPosition == endMaze) {
            State.WIN
        } else {
            State.IN_MOVE
        }

        notifyListeners()
    }

    override fun toString(): String {
        return buildString {
            append(state).appendLine()

            for (i in 0..heightMap) {
                for (j in 0..widthMap) {
                    if (i == currentPosition.second && j == currentPosition.first)
                        append('S')
                    else
                        append(board[Pair(i, j)])
                }
                appendLine()
            }
        }
    }
}