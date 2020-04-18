package com.uan.madlibs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        LoadConditions()

        listTales.setOnItemClickListener { _, item, _, _ ->
            val text = item as TextView

            when(text.text.toString()){

                "Simple Tale"-> {val started = Intent(this, FillingActivity::class.java)
                                     startActivity(started)}
                "Tarzan Tale"->{val started = Intent(this, FillingTarzanActivity::class.java)
                                     startActivity(started)}
                "University Tale"->{val started = Intent(this, FillingUniversityActivity::class.java)
                                     startActivity(started)}
            }

        }

    }



    fun LoadConditions(){
        var conditionText= ""
        val scanner =Scanner(resources.openRawResource(R.raw.condition))
        while (scanner.hasNextLine()){
            val lineText = scanner.nextLine()
            conditionText += lineText
        }
        textConditions.setText(conditionText)
        scanner.close()
    }
}
