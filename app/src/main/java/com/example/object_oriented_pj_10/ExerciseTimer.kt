package com.example.object_oriented_pj_10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ExerciseTimer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise_timer)

        if (intent.getIntExtra("type", 0) == 0){
            val name = "";
            val exercisetime = 0;
            val resttime = 0;
        }else {
            var sets = intent.getSerializableExtra("exercise") as ArrayList<ExerciseList>
            for (set in sets){
                println(set);
            }
        }

    }
}