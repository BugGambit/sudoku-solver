import kotlin.test.Test
import kotlin.test.assertEquals

internal class BoardPositionTest {
    @Test
    fun `Should return null when running next() on last cell`() {
        val expected = null
        assertEquals(expected, BoardPosition(8, 8).next())
    }

    @Test
    fun `Should return next cell on same row when running next()`() {
        val expected = BoardPosition(4, 8)
        assertEquals(expected, BoardPosition(4, 7).next())
    }

    @Test
    fun `Should return next cell on next row when running next()`() {
        val expected = BoardPosition(5, 0)
        assertEquals(expected, BoardPosition(4, 8).next())
    }

    @Test
    fun `Should return correct index for position`() {
        val expected = 4 * 9 + 8
        assertEquals(expected, BoardPosition(4, 8).index)
    }

    @Test
    fun `Should return correct region index for position`() {
        val expected = 5
        assertEquals(expected, BoardPosition(4, 8).regionIndex)
    }

    @Test
    fun `Should return RegionPosition from BoardPosition`() {
        val expected = RegionPosition(1, 2)
        assertEquals(expected, BoardPosition(7, 8).regionPosition)
    }
}