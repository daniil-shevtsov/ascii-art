package shevtsov.daniil.asciiart.main.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.Log
import android.view.View

class PixelView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val backgroundPaint = Paint().apply {
        color = Color.BLACK
        style = Paint.Style.FILL
    }

    private val pixelPaint = Paint().apply {
        color = Color.WHITE
        style = Paint.Style.FILL
    }

    private val gridPaint = Paint().apply {
        strokeWidth = 2f
        color = Color.RED
        style = Paint.Style.STROKE
    }

    private val gridCreator = GridCreator()

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.let(this::render)

    }

    private fun render(canvas: Canvas) {
        canvas.drawPaint(backgroundPaint)

        val grid = gridCreator.createGrid(width = GRID_WIDTH, height = GRID_HEIGHT)

        val pixelSize = width.toFloat() / GRID_WIDTH

        Log.d("PixelView", "count: ${grid.size} width: $width size: $pixelSize")

        grid
            .filter { it.x == it.y }
            .forEach { coordinate ->
                val x = coordinate.x.toFloat()
                val y = coordinate.y.toFloat()
                //x = 1
                //y = 1
            canvas.drawLine(0f, y*pixelSize, GRID_WIDTH*pixelSize, y*pixelSize, gridPaint)
            canvas.drawLine(x*pixelSize, 0f, x*pixelSize, GRID_HEIGHT*pixelSize, gridPaint)
        }

//        pixels
//            .filter { gridCoordinate -> gridCoordinate.x % 2 == 0 || gridCoordinate.y % 2 == 0 }
//            .forEach { coordinate ->
//                val rect = coordinate.createRect(pixelSize)
//                canvas.drawRect(rect, pixelPaint)
//            }

    }

    private fun GridCoordinate.createRect(pixelSize: Float): RectF {
        val startX = x * pixelSize
        val startY = y * pixelSize
        val endX = startX + pixelSize
        val endY = startY + pixelSize

        return RectF(startX, startY, endX, endY)
    }

    private companion object {
        const val GRID_WIDTH = 10
        const val GRID_HEIGHT = 10
    }

}