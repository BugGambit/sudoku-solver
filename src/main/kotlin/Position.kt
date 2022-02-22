sealed class Position(val row: Int, val col: Int, protected val size: Int) {
    val index get() = row * size + col

    override fun equals(other: Any?)
            = (other is Position)
            && row == other.row
            && col == other.col
            && size == other.size
}

class BoardPosition(row: Int, col: Int) : Position(row, col, 9) {
    val regionIndex get() = (row/3) * 3 + (col/3)
    val regionPosition get() = RegionPosition(row % 3, col % 3)

    fun next(): BoardPosition? {
        return if (col < size - 1) {
            BoardPosition(row, col+1)
        } else if (row < size - 1) {
            BoardPosition(row + 1, 0)
        } else {
            null
        }
    }
}

class RegionPosition(row: Int, col: Int) : Position(row, col, 3) {}