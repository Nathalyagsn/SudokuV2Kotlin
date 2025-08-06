package com.example.sudokuv2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {


    val selectedCellLiveData = MutableLiveData<Pair<Int, Int>>()

    init {

        selectedCellLiveData.postValue(Pair(-1, -1))
    }

    fun updateSelectedCell(row: Int, col: Int) {
        selectedCellLiveData.postValue(Pair(row, col))
    }
}