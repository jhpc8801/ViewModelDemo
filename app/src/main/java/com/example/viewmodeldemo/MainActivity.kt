package com.example.viewmodeldemo

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodeldemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // if use Student(), when rotate, it will always create a new one
        // use this code below, to store the data, it will keep until the app is closed (killed)
        // then all the memories will be released
        val student = ViewModelProvider(this).get(Student::class.java)
        // if using fragment, replace 'this' to 'ViewLifeCycleOwner'
        // newValue is the one we keep track, -> is referring to what we want to do
        // Observer only work on LiveData type, not applicable for primitive
        student.id.observe(this, Observer { newValue ->
            binding.tvId.text = newValue
        })
        student.name.observe(this, Observer { newValue ->
            binding.tvName.text = newValue
        })
        student.subject.observe(this, Observer { newValue ->
            binding.tvSubject.text = newValue.toString()
        })

        binding.btnInc.setOnClickListener() {
            //student.subject.value = student.subject.value!! + 1
            student.subject.value = (student.subject.value)?.plus(1)
        }

        binding.btnSet.setOnClickListener() {
            student.id.value = "W123"
            student.name.value = "Ah Lee"
            student.subject.value = 1
        }
    }
}