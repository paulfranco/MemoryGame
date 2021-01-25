package co.paulfran.memorygame


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast



class MainActivity : AppCompatActivity(), GameFragment.GameFragmentListener {

    private val tilesArray: ArrayList<Tile> = ArrayList()
    private var thisIsSecondTap = false
    private lateinit var tile1: Tile
    private lateinit var tile2: Tile

    private var gameIsActive = true
    private val foundTiles: ArrayList<Tile> = ArrayList()

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

    override fun tileTapped(tile: Tile, index: Int) {

        if (!gameIsActive || tile.tileStatus == Status.FLIPPED || tile.tileStatus == Status.FOUND) {
            return
        }

        tile.tileStatus = Status.FLIPPED
        tile.updateTile()

        if (!thisIsSecondTap) { // first tap
            tile1 = tile
            thisIsSecondTap = true
        } else {                // second tap
            tile2 = tile
            thisIsSecondTap = false
            gameIsActive = false
            Handler().postDelayed({
                compare()
            }, 1000)
        }
    }

    fun compare() {
        if (tile1.value == tile2.value) {
            tile1.tileStatus = Status.FOUND
            tile2.tileStatus = Status.FOUND

            tile1.updateTile()
            tile2.updateTile()

            foundTiles.add(tile1)
            foundTiles.add(tile2)

            if (foundTiles.size == 16) {
                // won game
                Toast.makeText(this, "YOU WON", Toast.LENGTH_LONG).show()
            }
        } else {
            tile1.tileStatus = Status.UNKNOWN
            tile2.tileStatus = Status.UNKNOWN

            tile1.updateTile()
            tile2.updateTile()
        }
        gameIsActive = true
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