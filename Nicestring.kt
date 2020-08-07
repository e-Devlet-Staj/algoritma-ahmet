package com.example.nicestring

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {

            var k =0
            var t =0
            var edit = editTextTextPersonName.text
            //Condition 1
            if (!edit.contains("bu") && !edit.contains("ba")  && !edit.contains("be")) {
                k++

            }

            //Condition 2
            for (i in 0 until edit.length) {
                if (edit[i] == 'a' || edit[i] == 'e' || edit[i] == 'i' || edit[i] == 'o' || edit[i] == 'ü') {
                    t++

                }
            }
            if (t >= 3) {
                k++
            }
            //Condition 3
            for (i in 0 until edit.length)
                if ((i+1)!=edit.length && edit[i] == edit[i+1]) {
                    k++

                    break
                }
            //Nice if provide at least two conditions
            if (k >= 2) {
                    textView2.setText("Nice")
            }
            else
            {
                textView2.setText("Not Nice")
            }
        }
    }
}