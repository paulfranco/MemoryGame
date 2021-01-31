package co.paulfran.memorygame


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import co.paulfran.memorygame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), GameFragment.GameFragmentListener {

    var gridSize = 4

    private lateinit var binding: ActivityMainBinding
    val tilesArray: ArrayList<Tile> = ArrayList()
    var thisIsSecondTap = false
    lateinit var tile1: Tile
    lateinit var tile2: Tile

    var gameIsActive = true
    val foundTiles: ArrayList<Tile> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        restartGame()

        binding.restartBtn.setOnClickListener {
            restartGame()
        }

    }

    override fun makeTiles(): ArrayList<Tile> {
        return extendedMakeTiles()
    }

    override fun tileTapped(tile: Tile, index: Int) {
        return onTileTapped(tile, index)
    }
}