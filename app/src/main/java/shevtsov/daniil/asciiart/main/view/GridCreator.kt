package shevtsov.daniil.asciiart.main.view

class GridCreator {

    private val gridIndexCreator = GridIndexCreator()

    fun createGrid(width: Int, height: Int):List<GridCoordinate> {
        return gridIndexCreator.createGrid(width, height).map { (x, y) ->
            GridCoordinate(x, y)
        }
    }

}