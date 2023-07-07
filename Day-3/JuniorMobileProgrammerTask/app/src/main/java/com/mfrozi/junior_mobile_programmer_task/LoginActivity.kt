package com.mfrozi.junior_mobile_programmer_task

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {
    lateinit var name : TextInputEditText
    lateinit var email : TextInputEditText
    lateinit var jurusan : TextInputEditText
    lateinit var semester : TextInputEditText
    lateinit var login : Button
    var nameValid:Boolean = false
    var emailValid:Boolean = false
    var jurusanValid:Boolean = false
    var semesterValid:Boolean = false
    var loop = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        name = findViewById(R.id.text_input_name)
        email = findViewById(R.id.text_input_email)
        jurusan = findViewById(R.id.text_input_jurusan)
        semester = findViewById(R.id.text_input_semester)
        login = findViewById(R.id.btn_login)

        var emailText = ""
        var jurusanText = ""
        var semesterText = 0



        email.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                emailText = ""
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                emailText += s
            }

            override fun afterTextChanged(s: Editable?) {
                if (emailText != "" && Patterns.EMAIL_ADDRESS.matcher(emailText).matches()){
                    emailValid = true
                    email.error = null
                    Log.d(this.toString(), "afterTextChanged: Email Status:  $emailValid")
                }
                if (emailText == "") email.error = "Alamat Email Tidak Boleh Kosong"
                if (!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()) email.error = "Alamat Email tidak Valid"
            }

        })
        jurusan.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                jurusanText = ""
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                jurusanText += s
            }

            override fun afterTextChanged(s: Editable?) {
                if (jurusanText== "") {
                    jurusan.error = "Jurusan tidak boleh kosong"
                }else {
                    jurusanValid = true
                    jurusan.error = null
                    Log.d(this.toString(), "afterTextChanged: Jurusan Status:  $jurusanValid")
                }


            }

        })
        semester.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                semesterText = 0
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
               if (s == ""){
                   semesterText = 0
               }else semesterText = Integer.parseInt(s.toString()) // error when input is null ;')
            }

            override fun afterTextChanged(s: Editable?) {
                if (semesterText <= 0 || semesterText > 14) semester.error = "Masukkan Semester yang valid"
                if (semesterText in 1..14) {
                    semesterValid = true
                    Log.d(this.toString(), "afterTextChanged: Semester Status: $semesterValid")
                }
            }

        })

            login.setOnClickListener { v ->
                run {
                    val i = Intent(this, DashboardActivity::class.java)
                    var bundle = Bundle()
                    bundle.putString("name",name.text.toString())
                    bundle.putString("email",email.text.toString())
                    bundle.putString("jurusan",jurusan.text.toString())
                    bundle.putString("semester",semester.text.toString())
                    i.putExtras(bundle)
                    startActivity(i)
                    finish()
                }
            }

    }
    fun nameCheck(){
        var nameText = ""
        name.addTextChangedListener(object: TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                nameText = ""
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                nameText += s
            }

            override fun afterTextChanged(s: Editable?) {
                if (nameText != ""){
                    nameValid = true
                    Log.d(this.toString(), "afterTextChanged: Name Status: $nameValid")
                    name.error = null
                }
                else name.error = "Nama Tidak Boleh Kosong"
            }

        })
    }
}