package shevtsov.daniil.asciiart.main.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat
import shevtsov.daniil.asciiart.R

class AsciiView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatTextView(context, attrs, defStyleAttr) {

    private val gridCreator = GridCreator()

    init {
        textScaleX = 1.9f
        textSize = 20f;
        gravity = Gravity.CENTER
        typeface = ResourcesCompat.getFont(context, R.font.bm437_ibm_bios)
        setBackgroundColor(Color.BLACK)
        setTextColor(Color.WHITE)

        val grid = gridCreator.createGrid(width = GRID_WIDTH, height = GRID_HEIGHT)

        val pixelSize = width.toFloat() / GRID_WIDTH

        Log.d("AsciiView", "count: ${grid.size} width: $width size: $pixelSize")

        text = grid
            .windowed(size = GRID_WIDTH, step = GRID_WIDTH)
            .joinToString(separator = "\n") { gridCoordinates ->
                gridCoordinates.joinToString(separator = "") { gridCoordinate ->
                    if (when {
                            gridCoordinate.y % 2 == 0 -> gridCoordinate.x % 2 == 0
                            else -> gridCoordinate.x % 2 != 0
                        }
                    ) {
                        "█"
                    } else {
                        "░"
                    }
                }
            }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

    }

    private companion object {
        const val GRID_WIDTH = 8
        const val GRID_HEIGHT = 8
    }
}