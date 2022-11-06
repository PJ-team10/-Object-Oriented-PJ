package com.example.object_oriented_pj_10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.NumberPicker
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.setmodal.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var selectNum = 0
        var list = Array<Int>(3,{0});
        var map = mutableMapOf<String,ArrayList<Int>>();

        //전환할 화면은 ExerciseTimer이다.
        val startIntent = Intent(this, ExerciseTimer::class.java)

        //같이 가져갈 데이터는 리스트 형태이다.
        //startIntent.putExtra("map", map);

        //startButton을 누르면 ExerciseTimer로 넘어감
        startButton.setOnClickListener {
            startActivity(startIntent);
        }

        //세트 수 정하는 버튼 클릭 이벤트
        SetCount.setOnClickListener  {
            val layout = layoutInflater.inflate(R.layout.setmodal, null)
            val build = AlertDialog.Builder(it.context).apply {
                setView(layout)
            }
            val dialog = build.create()
            dialog.show()

            layout.number_picker.minValue = 1
            layout.number_picker.maxValue = 10
            if(selectNum != 0) layout.number_picker.value = selectNum

            layout.btn_cancel.setOnClickListener {
                dialog.dismiss()
            }

            layout.btn_ok.setOnClickListener {
                selectNum = layout.number_picker.value
                list[0]=selectNum;
                dialog.dismiss()
            }
        }
        SetTime.setOnClickListener {

            val dialog = AlertDialog.Builder(it.context).create()

            val edialog: LayoutInflater = LayoutInflater.from(it.context)
            val mView: View = edialog.inflate(R.layout.timemodal, null)

            val minute: NumberPicker = mView.findViewById(R.id.numberPicker_min)
            val second: NumberPicker = mView.findViewById(R.id.numberPicker_sec)

            val cancel: Button = mView.findViewById<Button>(R.id.btn_settime_no)
            val start: Button = mView.findViewById<Button>(R.id.btn_settime_ok)
            // editText 설정해제
            minute.descendantFocusability = NumberPicker.FOCUS_BLOCK_DESCENDANTS
            second.descendantFocusability = NumberPicker.FOCUS_BLOCK_DESCENDANTS
            //최소값 설정
            minute.minValue = 0
            second.minValue = 0

            //최대값 설정
            minute.maxValue = 30
            second.maxValue = 59
            //기본값 설정
            minute.value = 1
            second.value = 0


            //취소버튼
            cancel.setOnClickListener {
                dialog.dismiss()
                dialog.cancel()
            }


            start.setOnClickListener {
                list[1]=minute.value;
                list[2]=second.value;

                dialog.dismiss()
            }


            dialog.setView(mView)

            dialog.create()
            dialog.show()
            dialog.window!!.setLayout(750, WindowManager.LayoutParams.WRAP_CONTENT)

        }


        addButton.setOnClickListener {


            //startIntent.putExtra("map", map데이터);
        }
        }
    }
