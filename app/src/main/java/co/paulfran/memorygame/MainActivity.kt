package co.paulfran.memorygame

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity(), GameFragment.GameFragmentListener {

    val tilesArray: ArrayList<Tile> = ArrayList()

    override fun makeTiles(): ArrayList<Tile> {
        for (i in 1..16) {

            var num = i
            if (num > 8) {
                num -= 8
            }

            val newTile = Tile(this, num)
            newTile.updateTile()

            tilesArray.add(newTile)
        }
        tilesArray.shuffle()
        return tilesArray
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.gameLayout, GameFragment.newInstance(), "game")
            .commit()
    }
}