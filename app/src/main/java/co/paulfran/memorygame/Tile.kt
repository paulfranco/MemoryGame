package co.paulfran.memorygame

import android.content.Context
import android.graphics.Color
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView

data class Tile(var myContext: Context, var value: Int) : AppCompatTextView(myContext) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val width = measuredWidth
        setMeasuredDimension(width, width)
    }

    fun updateTile() {
        this@Tile.text = " ? "
        this@Tile.setBackgroundColor(Color.DKGRAY)
    }
    
}