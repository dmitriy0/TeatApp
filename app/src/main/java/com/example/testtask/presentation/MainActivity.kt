package com.example.testtask.presentation

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.testtask.R
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var recyclerView: RecyclerView

    private lateinit var cocktailBtn: Button
    private lateinit var comboBtn: Button
    private lateinit var desertsBtn: Button
    private lateinit var drinksBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        recyclerView = findViewById(R.id.list)

        cocktailBtn = findViewById(R.id.button_cocktail)
        comboBtn = findViewById(R.id.button_combo)
        desertsBtn = findViewById(R.id.button_deserts)
        drinksBtn = findViewById(R.id.button_drinks)

        viewModel.drinkLiveData.observe(this) {
            recyclerView.adapter = DrinkListAdapter(it)
        }

        viewModel.buttonClickedLiveData.observe(this) {
            resetButtons()
            it.setBackgroundColor(Color.parseColor(FOCUSED_BACKGROUND_COLOR))
            it.setTextColor(Color.parseColor(FOCUSED_TEXT_COLOR))
        }

        cocktailBtn.setOnClickListener {
            viewModel.buttonClicked(it as Button)
        }

        comboBtn.setOnClickListener {
            viewModel.buttonClicked(it as Button)
        }

        desertsBtn.setOnClickListener {
            viewModel.buttonClicked(it as Button)
        }

        drinksBtn.setOnClickListener {
            viewModel.buttonClicked(it as Button)
        }

    }

    private fun resetButtons() {

        cocktailBtn.setBackgroundColor(Color.parseColor(BASE_BACKGROUND_COLOR))
        comboBtn.setBackgroundColor(Color.parseColor(BASE_BACKGROUND_COLOR))
        desertsBtn.setBackgroundColor(Color.parseColor(BASE_BACKGROUND_COLOR))
        drinksBtn.setBackgroundColor(Color.parseColor(BASE_BACKGROUND_COLOR))

        cocktailBtn.setTextColor(Color.parseColor(BASE_TEXT_COLOR))
        comboBtn.setTextColor(Color.parseColor(BASE_TEXT_COLOR))
        desertsBtn.setTextColor(Color.parseColor(BASE_TEXT_COLOR))
        drinksBtn.setTextColor(Color.parseColor(BASE_TEXT_COLOR))

    }

    companion object {
        const val BASE_BACKGROUND_COLOR = "#FFFFFF"
        const val BASE_TEXT_COLOR = "#C3C4C9"
        const val FOCUSED_BACKGROUND_COLOR = "#33FD3A69"
        const val FOCUSED_TEXT_COLOR = "#FD3A69"
    }
}