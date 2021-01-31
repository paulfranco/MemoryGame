package co.paulfran.memorygame

import androidx.fragment.app.Fragment

fun MainActivity.restartGame() {

    gameIsActive = true
    thisIsSecondTap = false
    foundTiles.clear()

    val frag = supportFragmentManager.findFragmentByTag("game")
    if (frag != null) {
        supportFragmentManager.beginTransaction().remove(frag).commit()
    }

    supportFragmentManager
            .beginTransaction()
            .add(R.id.gameLayout, GameFragment.newInstance(gridSize), "game")
            .commit()

}