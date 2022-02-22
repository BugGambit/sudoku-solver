import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

internal class RegionTest {
    private val cells = Array(9) { Cell(it + 1) }

    @Test
    fun `Should get a cell by region position`() {
        val region = Region(cells)
        val expected = Cell(5)
        assertEquals(expected, region[RegionPosition(1, 1)])
    }

    @Test
    fun `Should get array of cells by calling getCells`() {
        val region = Region(cells)
        assertContentEquals(cells, region.getCells())
    }

    @Test
    fun `Should get a true copy of cells by calling getCells`() {
        val region = Region(cells)
        val returnedCells = region.getCells()
        assertNotEquals(cells, returnedCells)
    }
}