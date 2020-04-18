package com.uan.madlibs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tale.*

class TaleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tale)



        buttonNewTale.setOnClickListener {
            finish()
        }
        setTitleTale()

        getTaleFilled()



    }

    fun setTitleTale (){
        val contentTale = this.intent.extras
        if (contentTale != null){
            val titleTale = contentTale.getString("title_tale")
            textViewTitle.setText(titleTale)
        }
    }


    fun getTaleFilled (){
        val contentTale = this.intent.extras
        if (contentTale != null){
            val taleFilled = contentTale.getString("tale")
            textViewTale.setText(taleFilled)
        }
    }
}
