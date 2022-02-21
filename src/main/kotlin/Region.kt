class Region(
    private val cells: Array<Array<Cell>> = emptyCells()
) {
    fun clone() {
        Region(cells.clone())
    }
}

private fun emptyCells() = Array(3) { Array(3) { Cell() } }