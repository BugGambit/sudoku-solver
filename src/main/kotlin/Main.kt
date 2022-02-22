fun main() {
    val boardInput = """
        62 9 4 58
          48 29  
            7    
        83     75
          1   4  
        24     89
            3    
          36 75  
        19 4 5 36
    """.trimIndent()

    val board = Board.fromString(boardInput)
    val solver = BruteforceSolver()
    println(solver.solve(board))
}