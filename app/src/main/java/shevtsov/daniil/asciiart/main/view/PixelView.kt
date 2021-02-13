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

        val pixels = gridCreator.createGrid(width = GRID_WIDTH, height = GRID_HEIGHT)

        val pixelSize = width.toFloat() / GRID_WIDTH

        Log.d("PixelView", "count: ${pixels.size} width: $width size: $pixelSize")

        pixels.forEach { coordinate ->
            val rect = with(coordinate) {
                val startX = x * pixelSize
                val startY = y * pixelSize
                val endX = startX + pixelSize
                val endY = startY + pixelSize
                RectF(startX, startY, endX, endY)
            }
            canvas.drawRect(rect, pixelPaint)
            canvas.drawRect(rect, gridPaint)
        }
    }

    private companion object {
        const val PIXEL_SIZE = 5
        const val GRID_WIDTH = 10
        const val GRID_HEIGHT = 10
    }

}