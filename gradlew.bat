package com.example.bookapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.bookapp.Database.BookDao
import com.example.bookapp.Database.BookDatabase
import com.example.bookapp.Database.entities.Book
import com.example.bookapp.Database.entities.Category
import com.example.bookapp.databinding.ActivityMainBinding
import com.example.bookapp.fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class Home_Page : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)
//database
      val dao: BookDao = BookDatabase.getInstance(this).bookDao

        val category = listOf(
            Category("Science"),
            Category("History"),
            Category("Art"),
            Category("Business"),
            Category("Biography"),
            Category("Travel")
        )
       /* val book = listOf(
            Book(1"Lives of Weeds: Opportunism, Resistance, Folly"
            ,10,"John Cardina","  "," ","Science",),
            Book(2,"Plagues Upon the Earth: Disease and the Course of Human History"
                ,10,"Kyle Harper","  "," ","Science"),
            Book(3,"Trans: When Ideology Meets Reality"
                ,10,"Helen Joyce","  "," ","Science"),
            Book(4,"Life as We Made It: How 50,000 Years of Human Innovation Refined—and Redefined—Nature"
                ,10,"Beth Shapiro","  "," ","Science"),
            Book(5,"Our Biggest Experiment: An Epic History of the Climate Crisis"
                ,10,"Alice Bell","  "," ","Science"),
            Book(6,"The Gilded Page: The Secret Lives of Medieval Manuscripts"
                ,10,"Mary Wellesley","  "," ","Science"),
            Book(7,"True Raiders: The Untold Story of the 1909 Expedition to Find the Legendary Ark of the Covenant"
                ,10,"Brad Ricca","  "," ","Science"),
            Book(8,"The Secret of Life: Rosalind Franklin, James Watson, Francis Crick, and the Discovery of DNA's Double Helix"
                ,10,"Howard Markel","  "," ","Science"),
            //second category
            Book(11,"The Long War: The Inside Story of America and Afghanistan Since 9/11"
                ,10,"David Loyn","  "," ","History"),
            Book(11,"Henry II and Eleanor of Aquitaine: Founding an Empire"
                ,10,"Matthew Lewis","  "," ","History"),
            Book(12,"She Persisted: Margaret Chase Smith"
                ,10,"Ruby Shamir" +
                        "Chelsea Clinton","  "," ","History"),
            Book(13,"What is 