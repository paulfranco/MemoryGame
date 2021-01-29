package co.paulfran.memorygame

import android.os.Handler

fun MainActivity.onTileTapped(tile: Tile, index: Int) {

    var gameIsActive = true

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