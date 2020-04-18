package com.uan.madlibs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_filling.*
import java.util.*

class FillingActivity : AppCompatActivity() {
    val adjectiveToFilling = "<adjective>"
    val jobToFilling = "<job>"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filling)

        buttonContinue.setOnClickListener {

            val continueButton = Intent (this, TaleActivity::class.java)
            continueButton.putExtra("tale",FillingTale() )
            continueButton.putExtra("title_tale", "Simple Tale")
            startActivity(continueButton)
        }

    }

    fun readingTale(): String {
        val scannerTale= Scanner(resources.openRawResource(R.raw.madlib0_simple))
        var tale = ""
        while (scannerTale.hasNextLine()){

            val lineTale =scannerTale.nextLine()
            tale += lineTale
        }
        scannerTale.close()
        return tale
    }

    fun FillingTale():String{

        var job = editTextJob.text.toString()
        var adjective=editTextAdjetive.text.toString()
        var tale= readingTale()

        var newJob = tale.replace(jobToFilling,job,true)
        val newTale = newJob.replace(adjectiveToFilling, adjective,true)

        return newTale

    }
}
