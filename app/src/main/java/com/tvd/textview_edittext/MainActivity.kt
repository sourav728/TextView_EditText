package com.tvd.textview_edittext

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val input: String = editText.text.toString()
            if (input.trim() == "") {
                Toast.makeText(this, "Please Enter Input", Toast.LENGTH_LONG).show()
            } else {
                textView4.setText(input).toString()
            }
        }

        textView5.setOnClickListener {
            if (textView4.text.toString().trim() == "") {
                Toast.makeText(this, "clicked on reset textView,\n output textView already reset", Toast.LENGTH_LONG)
                    .show()
            } else {
                textView4.setText("").toString()
            }
        }

        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                Toast.makeText(applicationContext, "Before TextChanged", Toast.LENGTH_LONG).show()
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Toast.makeText(applicationContext, "On TextChanged", Toast.LENGTH_LONG).show()
            }

            override fun afterTextChanged(s: Editable?) {
                Toast.makeText(applicationContext, "After TextChanged", Toast.LENGTH_LONG).show()

            }
        })

    }
}
