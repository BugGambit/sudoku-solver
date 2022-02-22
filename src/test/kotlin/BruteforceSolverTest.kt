import kotlin.test.Test
import kotlin.test.assertEquals

internal class BruteforceSolverTest {
    private val solver = BruteforceSolver()

    @Test
    fun `Should solve super easy sudoku`() {
        val input = """
            841   237
            7   8   9
               7 4   
              86 97  
             9     1 
              23 85  
               2 7   
            2   4   3
            574   862
        """.trimIndent()

        val expected = """
            841596237
            726183459
            935724681
            358619724
            697452318
            412378596
            183267945
            269845173
            574931862
        """.trimIndent()

        val board = Board.fromString(input)
        assertEquals(solver.solve(board), Board.fromString(expected))
    }

    @Test
    fun `Should solve super hard sudoku`() {
        val input = """
            3    145 
                8  63
               9  7  
             8 47  1 
              4 5 2  
             3  96 4 
            2 36     
            85  2    
             7   9  2
        """.trimIndent()

        val expected = """
            329761458
            517284963
            648935721
            985472316
            764153289
            132896547
            293648175
            851327694
            476519832
        """.trimIndent()

        val board = Board.fromString(input)
        assertEquals(solver.solve(board), Board.fromString(expected))
    }

    @Test
    fun `Should solve near impossible sudoku`() {
        val input = """
            9  3   8 
              2  1   
             73      
             6  5    
            3       1
                 645 
            5  6     
              1   2  
             2  9  74
        """.trimIndent()

        val expected = """
            916342587
            452781936
            873569142
            169453728
            345278691
            287916453
            534627819
            791834265
            628195374
        """.trimIndent()

        val board = Board.fromString(input)
        assertEquals(solver.solve(board), Board.fromString(expected))
    }
}