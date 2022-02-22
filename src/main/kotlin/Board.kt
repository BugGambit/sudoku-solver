class Board(
    private val regions: Array<Region> = emptyRegions()
) {
    operator fun get(pos: BoardPosition) = regions[pos.regionIndex][pos.regionPosition]

    fun getRegion(pos: BoardPosition) = regions[pos.regionIndex]

    fun getCellsInHorizontalLine(row: Int) = getCellsInLine(row, true)

    fun getCellsInVerticalLine(col: Int) = getCellsInLine(col, false)

    private fun getCellsInLine(rowOrCol: Int, horizontal: Boolean): Array<Cell> {
        val line = mutableListOf<Cell>()
        for (index in 0 until 9) {
            val pos = if (horizontal) BoardPosition(rowOrCol, index) else BoardPosition(index, rowOrCol)
            line.add(this[pos])
        }
        return line.toTypedArray()
    }

    fun copyWithCellMutation(pos: BoardPosition, cell: Cell): Board {
        val oldRegion = regions[pos.regionIndex]
        val newCells = oldRegion.getCells().apply {
            this[pos.regionPosition.index] = cell
        }
        val newRegions = regions.clone().apply {
            this[pos.regionIndex] = Region(newCells)
        }
        newRegions[pos.regionIndex] = Region(newCells)
        return Board(newRegions)
    }

    companion object {
        fun fromString(str: String): Board {
            val cells = str.replace("\n", "").map { Cell(it.digitToIntOrNull())}
            require(cells.size == 81) { "Must include 81 cells" }
            val regionCells = Array(9) { mutableListOf<Cell>() }
            for (row in 0 until 9) {
                for (col in 0 until 9) {
                    val pos = BoardPosition(row, col)
                    val cell = cells[pos.index]
                    regionCells[pos.regionIndex].add(cell)
                }
            }
            val regions = regionCells.map { Region(it.toTypedArray()) }
            return Board(regions.toTypedArray())
        }
    }

    override fun toString(): String {
        fun Array<Cell>.stringify() = this.map { it.value }.map { it ?: ' ' }.joinToString("")
        return (0 until 9).joinToString("\n") { row ->
            getCellsInHorizontalLine(row).stringify()
        }
    }

    override fun equals(other: Any?): Boolean {
        return (other is Board)
                && (toString() == other.toString())
    }
}

private fun emptyRegions() = Array(9) { Region() }