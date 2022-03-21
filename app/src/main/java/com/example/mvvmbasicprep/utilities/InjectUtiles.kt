package com.example.mvvmbasicprep.utilities

import com.example.mvvmbasicprep.Data.FakeDatabase
import com.example.mvvmbasicprep.Data.QuoteRepository
import com.example.mvvmbasicprep.ui.quotes.ViewModelFactory

// Finally a singleton which doesn't need anything passed to the constructor
object InjectUtiles {


    // This will be called from QuotesActivity
    fun provideQuotesViewModelFactory(): ViewModelFactory {
        // ViewModelFactory needs a repository, which in turn needs a DAO from a database
        // The whole dependency tree is constructed right here, in one place
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return ViewModelFactory(quoteRepository)
    }
}