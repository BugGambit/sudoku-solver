class Board(
    private val regions: Array<Array<Region>> = emptyRegions()
) {
    fun set(row: Int, column: Int, value: Int) {
        val region = regions[row/3][column/3]
        regions[row/3][column/3] = region
    }
}

private fun emptyRegions() = Array(3) { Array(3) { Region() } }