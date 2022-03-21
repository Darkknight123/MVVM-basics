package com.example.mvvmbasicprep.ui.quotes

import androidx.lifecycle.ViewModel
import com.example.mvvmbasicprep.Data.Quote
import com.example.mvvmbasicprep.Data.QuoteRepository

// QuoteRepository dependency will again be passed in the
// constructor using dependency injection
 class QuotesViewModel(private val quoteRepository: QuoteRepository )
     : ViewModel(){
         fun getQuotes() = quoteRepository.getQuotes()

      fun addQuotes(quote:Quote) = quoteRepository.addQuote(quote)

 }