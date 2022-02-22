import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

internal class BoardTest {
    private val boardInput = """
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

    @Test
    fun `Should construct board from string`() {
        assertEquals(boardInput, Board.fromString(boardInput).toString())
    }

    @Test
    fun `Should return cell for a given BoardPosition`() {
        assertEquals(board[BoardPosition(2, 4)].value, 7)
    }

    @Test
    fun `Should return region for a given BoardPosition`() {
        val expected = Region(listOf(
            9, null, 4,
            8, null, 2,
            null, 7, null
        ).map { Cell(it) }.toTypedArray())
        assertEquals(board.getRegion(BoardPosition(1, 4)), expected)
    }

    @Test
    fun `Should return full line from getCellsInHorizontalLine`() {
        var line = board.getCellsInHorizontalLine(3)
        var expected = listOf(8, 3, null, null, null, null, null, 7, 5).map { Cell(it) }.toTypedArray()
        assertContentEquals(line, expected)
    }

    @Test
    fun `Should return full line from getCellsInVerticalLine`() {
        var line = board.getCellsInVerticalLine(1)
        var expected = listOf(2, null, null, 3, null, 4, null, null, 9).map { Cell(it) }.toTypedArray()
        assertContentEquals(line, expected)
    }

    @Test
    fun `Should return cloned board with a mutated cell`() {
        val clonedBoard = board.copyWithCellMutation(BoardPosition(0, 2), Cell(7))
        assertEquals(Cell(7), clonedBoard[BoardPosition(0, 2)])
        assertEquals(board.toString(), boardInput)
    }
}