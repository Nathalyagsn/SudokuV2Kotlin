package com.example.sudokuv2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sudokuv2.game.Board
import com.example.sudokuv2.game.Cell
import com.example.sudokuv2.view.custom.TabuleiroView

class MainActivityViewModel : ViewModel() {

    val selectedCellLiveData = MutableLiveData<Pair<Int, Int>>()
    val cellsLiveData = MutableLiveData<List<Cell>>()

    private val board: Board

    init {
        val cells = List(9 * 9) { i -> Cell(i / 9, i % 9, 0) }
        board = Board(9, cells)

        cellsLiveData.postValue(cells)
        selectedCellLiveData.postValue(Pair(-1, -1))
    }


    fun handleInput(number: Int) {

        val (row, col) = selectedCellLiveData.value ?: return

        if (row == -1 || col == -1) return

        board.getCell(row, col).value = number


        cellsLiveData.postValue(board.cells)
    }

    fun updateSelectedCell(row: Int, col: Int) {
        selectedCellLiveData.postValue(Pair(row, col))
    }


}