package shevtsov.daniil.asciiart.main.view

class GridIndexCreator {

    fun createGrid(width: Int, height: Int): List<Pair<Int, Int>> {
        val columns = IntRange(0, width - 1)
        val rows = IntRange(0, height - 1)
        val grid = columns.flatMap { column ->
            rows.map { row -> column to row }
        }

        return grid
    }

}