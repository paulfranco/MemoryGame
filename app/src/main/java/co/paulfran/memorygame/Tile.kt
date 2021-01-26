package co.paulfran.memorygame

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.Color
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView

enum class Status {
    UNKNOWN, FLIPPED, FOUND
}

data class Tile(var myContext: Context, var value: Int) : AppCompatTextView(myContext) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        val width = measuredWidth
        setMeasuredDimension(width, width)
    }

    var tileStatus : Status = Status.UNKNOWN

    fun updateTile() {

        val objAnime_1 = ObjectAnimator.ofFloat(this, "scaleX", 1f, 0f)
        val objAnime_2 = ObjectAnimator.ofFloat(this, "scaleX", 0f, 1f)

        objAnime_1.duration = 250
        objAnime_2.duration = 250

        objAnime_1.interpolator = DecelerateInterpolator()
        objAnime_2.interpolator = AccelerateInterpolator()

        objAnime_1.addListener(object: AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator?) {
                super.onAnimationEnd(animation)
                when (tileStatus) {
                    Status.UNKNOWN -> {
                        this@Tile.text = " ? "
                        this@Tile.setBackgroundColor(Color.DKGRAY)
                    }
                    Status.FLIPPED -> {
                        this@Tile.text = this@Tile.value.toString()
                        this@Tile.setBackgroundColor(Color.DKGRAY)
                    }
                    Status.FOUND -> {
                        this@Tile.text = " :) "
                        this@Tile.setBackgroundColor(Color.GREEN)
                    }
                }
                objAnime_2.start()
            }
        })

        objAnime_1.start()


    }
    
}