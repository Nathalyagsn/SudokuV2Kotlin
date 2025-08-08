package com.example.sudokuv2.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.sudokuv2.R
import com.example.sudokuv2.view.custom.TabuleiroView
import com.example.sudokuv2.viewmodel.MainActivityViewModel
import android.widget.Button


class MainActivity : AppCompatActivity() {
    private val viewModel: MainActivityViewModel by viewModels()

    private lateinit var tabuleiroView: TabuleiroView

    private lateinit var numberButtons: List<Button>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabuleiroView = findViewById(R.id.TabuleiroView)

        numberButtons = listOf(
            findViewById(R.id.oneButton), findViewById(R.id.twoButton), findViewById(R.id.threeButton),
            findViewById(R.id.fourButton), findViewById(R.id.fiveButton), findViewById(R.id.sixButton),
            findViewById(R.id.sevenButton), findViewById(R.id.eightButton), findViewById(R.id.nineButton)
        )

        setupListeners()
        setupObservers()


    }

    private fun setupListeners() {
        tabuleiroView.onCellTouched = { row, col ->
            viewModel.updateSelectedCell(row, col)
        }

        numberButtons.forEachIndexed{ index, button ->
            button.setOnClickListener {
                viewModel.handleInput((index + 1))
            }
        }
    }


    private fun setupObservers() {

        viewModel.selectedCellLiveData.observe(this) { (row, col) ->
            if (row != -1 && col != -1) {

                tabuleiroView.updateSelectedCellUI(row, col)
            }
        }

        viewModel.cellsLiveData.observe(this) { cells ->
            tabuleiroView.updateCells(cells)

        }
        
    }
}