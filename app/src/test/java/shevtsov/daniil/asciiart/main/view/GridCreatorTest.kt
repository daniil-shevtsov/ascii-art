package shevtsov.daniil.asciiart.main.view

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class GridCreatorTest {

    private lateinit var gridCreator: GridCreator

    @BeforeEach
    fun onSetup() {
        gridCreator = GridCreator()
    }

    @Test
    fun testGrid() {
        /*
          0 1
        0 * *
        1 * *
         */
        val expected = listOf(
            0 to 0,
            0 to 1,
            1 to 0,
            1 to 1
        )

        val grid = gridCreator.createGrid(2, 2)
        assertEquals(expected, grid)
    }

}