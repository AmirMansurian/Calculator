package com.example.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        SetListeners()
    }

    private fun SetListeners() {
        val ClickableViews : List<View> = listOf(delete_button, division_button, dot_button, eight_button, equal_button,
                                                 five_button, four_button, minus_button, mod_button, multiply_button, nine_button,
                                                 plus_button, one_button, two_button, three_button, six_button, seven_button ,zero_button)

        for(item in ClickableViews) {
            item.setOnClickListener { Calculate(it) }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun Calculate(view: View) {

        when(view.id)
        {
            R.id.one_button ->  result_screen.setText(result_screen.text.toString() + "1")
            R.id.two_button ->  result_screen.setText(result_screen.text.toString() + "2")
            R.id.three_button ->  result_screen.setText(result_screen.text.toString() + "3")
            R.id.four_button ->  result_screen.setText(result_screen.text.toString() + "4")
            R.id.five_button ->  result_screen.setText(result_screen.text.toString() + "5")
            R.id.six_button ->  result_screen.setText(result_screen.text.toString() + "6")
            R.id.seven_button ->  result_screen.setText(result_screen.text.toString() + "7")
            R.id.eight_button ->  result_screen.setText(result_screen.text.toString() + "8")
            R.id.nine_button ->  result_screen.setText(result_screen.text.toString() + "9")
           // R.id.zero_button ->  result_screen.setText(result_screen.text.toString() + "0")
            R.id.plus_button ->  result_screen.setText(result_screen.text.toString() + "+")
            R.id.minus_button ->  result_screen.setText(result_screen.text.toString() + "-")
            R.id.division_button ->  result_screen.setText(result_screen.text.toString() + "/")
            R.id.multiply_button ->  result_screen.setText(result_screen.text.toString() + "*")
            R.id.mod_button ->  result_screen.setText(result_screen.text.toString() + "%")
            R.id.delete_button -> result_screen.setText(null)
            R.id.equal_button ->  {

                var flag = 0
                var num1 = 0
                var num2 = 0
                var op = '+'
                var result = 0

                for (i in 0..result_screen.text.length - 1){

                    if (result_screen.text[i] >= '0' && result_screen.text[i] <= '9')
                    {
                        if (flag  == 0)
                            num1 = num1 * 10 + result_screen.text[i].toInt()-48
                        else
                            num2 = num2 * 10 + result_screen.text[i].toInt()-48
                    }
                    else
                    {
                        flag = 1
                        op = result_screen.text[i]
                    }

                }

                flag = 0

                when (op)
                {
                    '+' -> result = num1 + num2
                    '-' -> result = num1 - num2
                    '*' -> result = num1 * num2
                    '/' -> result = num1 / num2
                    '%' -> result = num1 % num2
                }
                result_screen.setText(result.toString())

            }
        }

    }
}
