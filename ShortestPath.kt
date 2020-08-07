package com.example.shortestpath

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener()
        {
            var row: Int = editTextNumber.text.toString().toInt()
            var column: Int = editTextNumber2.text.toString().toInt()

            var end_r=row-1
            var end_c=column-1
            var current_r =0
            var current_c =0

            var cost = 1
            var tempCost_right = 0
            var tempCost_down = 0
            val matris = Array(row) { IntArray(column) }
            var temp = 1
            for (i in 0 until row)
                for (k in 0 until column) {
                    matris[i][k] = temp
                    temp++
                }
            while (current_r!=end_r || current_c!=end_c )
            {
                if(current_r == end_r)
                {
                    current_c++
                    cost+=matris[current_r][current_c]
                }
                else if (current_c == end_c)
                {
                    current_r++
                    cost+=matris[current_r][current_c]

                }
                else {
                    tempCost_right = matris[current_r][current_c + 1]
                    tempCost_down  = matris[current_r + 1][current_c]
                    if (tempCost_right < tempCost_down) {

                        current_c++
                        cost += tempCost_right

                    } else {

                        current_r++
                        cost += tempCost_down
                    }
                }
            }
            textView3.setText(""+cost)

        }

    }
}