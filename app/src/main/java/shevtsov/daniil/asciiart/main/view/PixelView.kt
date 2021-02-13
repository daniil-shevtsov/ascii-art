package shevtsov.daniil.asciiart.main.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
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
        isAntiAlias = true
        color = Color.RED
        style = Paint.Style.STROKE
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.let(this::render)

    }

    private fun render(canvas: Canvas) {
        canvas.drawPaint(backgroundPaint)

        val columns = IntArray(GRID_WIDTH)
        val rows = IntArray(GRID_HEIGHT)
        val pixels = columns.flatMap { column ->
            rows.map { row -> column to row }
        }
    }

    private companion object {
        const val PIXEL_SIZE = 5
        const val GRID_WIDTH = 100
        const val GRID_HEIGHT = 100
    }

}