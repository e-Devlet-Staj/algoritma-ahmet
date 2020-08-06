package com.example.mastermind

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var positions = 0
        var letters = 0
        var letters1 = 0
        val colors = charArrayOf('A', 'B', 'C', 'D', 'E', 'F')
        
        var code =ArrayList<Char>()
        for (i in 0 until 4)
        {
            code.add(colors[(0..5).random()])
        }
        button.setOnClickListener {
            var guess =ArrayList<Char>()
            var tempGuess =ArrayList<Char>()
            var tempCode =ArrayList<Char>()

            letters=0
            letters1 =0
            positions=0
            var guess1 = editTextTextPersonName.text
            for (i in 0 until guess1.length) {
                guess.add(guess1[i])
            }
            for (i in 0 until 4)
            {
                if (code[i] == guess[i]) {
                    positions++
                }
                else
                {
                    tempCode.add(code[i])
                    tempGuess.add(guess[i])
                }
            }
            Log.e("Log", ""+tempCode.joinToString(""))
            Log.e("Log", ""+tempGuess.joinToString(""))

            for (i in 0 until tempCode.size)
                for (k in 0 until tempGuess.size)
                    if (tempCode[i] == tempGuess[k] ) {
                        letters++

                        break
                    }
            Log.e("Log", ""+letters)
            for (i in 0 until tempGuess.size)
                for (k in 0 until tempCode.size)
                    if (tempGuess[i] == tempCode[k]) {
                        letters1++

                        break
                    }
            Log.e("Log", ""+letters1)
            textView3.setText(""+positions)
            if (letters>=letters1)
            {
                textView5.setText(""+letters1)
            }
            else
            {
                textView5.setText(""+letters)
            }

            textView7.setText(code.joinToString (""))
        }
    }
}