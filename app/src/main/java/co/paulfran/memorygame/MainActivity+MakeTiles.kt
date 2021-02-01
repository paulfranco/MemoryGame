package co.paulfran.memorygame

fun MainActivity.extendedMakeTiles(): ArrayList<Tile> {

    tilesArray.clear()

    val totalGrid = gridSize * gridSize
    val halfGrid = totalGrid / 2

    for (i in 1..totalGrid) {
        var num = i
        if (num > halfGrid) {
            num -= halfGrid
        }

        val newTile = Tile(this, num)
        newTile.updateTile()

        tilesArray.add(newTile)
    }
    tilesArray.shuffle()
    return tilesArray
}