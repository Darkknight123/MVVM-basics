package com.example.mvvmbasicprep.ui.quotes

import com.example.mvvmbasicprep.Data.FakeDatabase
import com.example.mvvmbasicprep.Data.QuoteRepository

object InjectUtiles {

    fun provideQuotesViewModelFactory(): ViewModelFactory{
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return ViewModelFactory(quoteRepository)
    }
}