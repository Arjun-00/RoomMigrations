package com.posibolt.roommigrations

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import com.posibolt.roommigrations.dataBase.Student
import com.posibolt.roommigrations.dataBase.StudentDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao = StudentDataBase.getInstance(application).subscriberDAO
        val editText : EditText = findViewById(R.id.nameText);
        val placeText : EditText = findViewById(R.id.placeText);
        val button : Button = findViewById(R.id.button);

        button.setOnClickListener {
            lifecycleScope.launch (Dispatchers.Main){
                editText.text.let {
                    dao.insertStudent(Student(0,it.toString(),placeText.text.toString()))
                    editText.setText("")
                    placeText.setText("")
                }
            }
        }

    }
}