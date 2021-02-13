package shevtsov.daniil.asciiart.main.view

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class GridIndexCreatorTest {

    private lateinit var gridIndexCreator: GridIndexCreator

    @BeforeEach
    fun onSetup() {
        gridIndexCreator = GridIndexCreator()
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

        val grid = gridIndexCreator.createGrid(2, 2)
        assertEquals(expected, grid)
    }

}