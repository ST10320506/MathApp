package vcmsa.ci.mathapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //connect the backend to the frontend - declaring the variables
        val numberOne = findViewById<EditText>(R.id.editTextText)
        val numberTwo = findViewById<EditText>(R.id.editTextText2)
        val addButton = findViewById<Button>(R.id.button)
        val answer = findViewById<EditText>(R.id.editTextText3)

        addButton.setOnClickListener {
            val numberOneString = numberOne.text.toString()
            val numberTwoString = numberTwo.text.toString()

            if (numberOneString.isEmpty() || numberTwoString.isEmpty()) {
                Toast.makeText(this, "Please enter two numbers", Toast.LENGTH_SHORT).show()
                return@setOnClickListener

            } else {
                try {
                    val firstNumber = numberOneString.toInt()
                    val secondNumber = numberTwoString.toInt()
                    val sum = firstNumber + secondNumber
                    //AI assisted in completing the code
                    //Prompt used in Gemini: complete the code so when the add button is clicked it adds the two numbers and displays the answer
                    answer.setText(sum.toString())


                }  catch (e: NumberFormatException) {
                    Toast.makeText(this, "INVALID INPUT", Toast.LENGTH_SHORT).show()
                    //AI assisted in completing the code
                    //Prompt used in Gemini: complete the code so when the add button is clicked it adds the two numbers and displays the answer
                    answer.setText("")

                   }
            }


        }


    }
}