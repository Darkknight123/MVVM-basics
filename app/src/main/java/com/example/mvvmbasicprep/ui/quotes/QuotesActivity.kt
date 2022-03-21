package com.example.mvvmbasicprep.ui.quotes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmbasicprep.Data.Quote
import com.example.mvvmbasicprep.R
import com.example.mvvmbasicprep.databinding.ActivityQuotesBinding


class QuotesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuotesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuotesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initializeUi()
    }

    private fun initializeUi() {
        // Get the QuotesViewModelFactory with all of it's dependencies constructed
        val factory = InjectUtiles.provideQuotesViewModelFactory()
        // Use ViewModelProviders class to create / get already created QuotesViewModel
        // for this view (activity)
        val viewModel = ViewModelProviders.of(this,factory)
            .get(QuotesViewModel::class.java)

        // Observing LiveData from the QuotesViewModel which in turn observes
        // LiveData from the repository, which observes LiveData from the DAO ☺
        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach{ quote ->
                stringBuilder.append("$quote\n\n")
            }
            binding.textQuotes.text = stringBuilder.toString()
        })

        binding.buttonAddQuote.setOnClickListener{
            val quote = Quote(binding.editTextQuote.toString(),binding.editTextAuthor.toString())
            viewModel.addQuotes(quote)
            binding.editTextQuote.setText("")
            binding.editTextAuthor.setText("")
        }
    }
}