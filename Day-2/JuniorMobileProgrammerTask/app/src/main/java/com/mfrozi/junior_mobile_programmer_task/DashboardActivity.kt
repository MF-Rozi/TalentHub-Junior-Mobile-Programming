package com.mfrozi.junior_mobile_programmer_task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DashboardActivity : AppCompatActivity() {
    lateinit var name: TextView
    lateinit var email: TextView
    lateinit var jurusan: TextView
    lateinit var semester: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        name = findViewById(R.id.tv_name)
        email = findViewById(R.id.tv_email)
        jurusan = findViewById(R.id.tv_jurusan)
        semester = findViewById(R.id.tv_semester)

        val bundle  = this.intent.extras
        if (bundle != null){
            name.text = bundle.getString("name")
            email.text = bundle.getString("email")
            jurusan.text = bundle.getString("jurusan")
            semester.text = bundle.getString("semester")
        }



    }
}