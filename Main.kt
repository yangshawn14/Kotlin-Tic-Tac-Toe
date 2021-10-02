import java.util.*

private var board = Board( 0)
private val player1 = "X"
private val player2 = "O"
private var currentPlayer = ""
private var answer = ""

fun main() {
    println("Please enter size of your board: ")
    val scanner = Scanner(System.`in`)
    val size = Integer.parseInt(scanner.nextLine())

    board = Board(size)
    board.printBoard()

    while (!board.isGameOver) {
        takeTurns()
        println("$currentPlayer's turn")
        println("Enter row number:")
        var row = Integer.parseInt(scanner.nextLine())
        println("Enter column number:")
        var column = Integer.parseInt(scanner.nextLine())
        board.placePiece(row - 1, column - 1, currentPlayer)
        if (board.isGameOver) {
            println("Do you want to play again? y or n")
            var answer = scanner.nextLine()
            if (playAgain(answer)) {
                board.resetGame()
            } else {
                println("Thank you for playing!")
            }
        }
    }
}

fun takeTurns() {
    currentPlayer = if (player1 == currentPlayer) {
        player2
    } else {
        player1
    }
}

fun playAgain(answer: String): Boolean {
    return (answer.equals("y", ignoreCase = true))
}