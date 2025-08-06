package com.example.sudokuv2.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.sudokuv2.R
import com.example.sudokuv2.view.custom.TabuleiroView
import com.example.sudokuv2.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    private lateinit var tabuleiroView: TabuleiroView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tabuleiroView = findViewById(R.id.TabuleiroView)

        setupListeners()
        setupObservers()
    }

    private fun setupListeners() {

        tabuleiroView.onCellTouched = { row, col ->

            viewModel.updateSelectedCell(row, col)
        }
    }


    private fun setupObservers() {

        viewModel.selectedCellLiveData.observe(this) { (row, col) ->
            if (row != -1 && col != -1) {

                tabuleiroView.updateSelectedCellUI(row, col)
            }
        }
    }
}