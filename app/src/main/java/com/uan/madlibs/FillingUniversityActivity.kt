package com.uan.madlibs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_filling_university.*
import java.util.*

class FillingUniversityActivity : AppCompatActivity() {

    val adjectiveToFilling = "<adjective>"
    val pluralNounToFilling = "<plural-noun>"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filling_university)

        buttonContinues.setOnClickListener {

            val continueButton = Intent (this, TaleActivity::class.java)
            continueButton.putExtra("tale",FillingTale() )
            continueButton.putExtra("title_tale", "University Tale")
            startActivity(continueButton)
        }
    }

    fun readingTale(): String {
        val scannerTale= Scanner(resources.openRawResource(R.raw.madlib2_university))
        var tale = ""
        while (scannerTale.hasNextLine()){

            val lineTale =scannerTale.nextLine()
            tale += lineTale
        }
        scannerTale.close()
        return tale
    }

    fun FillingTale():String{

        var plural = editTextPluralNoun.text.toString()
        var adjective=editTextAdjetive.text.toString()
        var tale= readingTale()

        var newPlural = tale.replace(pluralNounToFilling,plural,true)
        val newTale = newPlural.replace(adjectiveToFilling, adjective,true)

        return newTale

    }
}
