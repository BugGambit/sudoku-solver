class BruteforceSolver : Solver {
    override fun solve(board: Board): Board? {
        return solve(board, BoardPosition(0, 0))
    }

    private fun solve(board: Board, pos: BoardPosition?): Board? {
        if (pos == null) {
            return board
        }

        if (board[pos].value != null) {
            return solve(board, pos.next())
        }

        val possibleCellValues = getPossibleCellValues(board, pos)
        for (value in possibleCellValues) {
            val newBoard = board.copyWithCellMutation(pos, Cell(value))
            // TODO("parallelize")
            val solvedBoard = solve(newBoard, pos.next())
            if (solvedBoard != null) {
                return solvedBoard
            }
        }
        return null
    }

    private fun Array<Cell>.toSetValue(): Set<Int> {
        return this.mapNotNull { it.value }.toSet()
    }

    private fun getPossibleCellValues(board: Board, pos: BoardPosition): Array<Int> {
        val possibleValues = (1..9).toSet()
        val region = board.getRegion(pos)
        val valuesInRegion = region.getCells().toSetValue()
        val valuesInHorizontalLine = board.getCellsInHorizontalLine(pos.row).toSetValue()
        val valuesInVerticalLine = board.getCellsInVerticalLine(pos.col).toSetValue()
        return (possibleValues - valuesInRegion - valuesInHorizontalLine - valuesInVerticalLine).toTypedArray()
    }
}