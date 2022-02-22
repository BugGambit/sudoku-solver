class Region(
    private val cells: Array<Cell> = emptyCells()
) {
    operator fun get(pos: RegionPosition): Cell {
        return cells[pos.index];
    }

    fun getCells(): Array<Cell> {
        return cells.clone()
    }

    override fun equals(other: Any?): Boolean {
        return (other is Region)
                && cells.contentEquals(other.cells)
    }
}

private fun emptyCells() = Array(3 * 3) { Cell() }