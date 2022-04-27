package com.anshu.wedin.activity

import android.app.ProgressDialog
import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.anshu.wedin.database.DatabaseHandler
import com.anshu.wedin.databinding.ActivityRegisterBinding
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var progressDialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        var helper = DatabaseHandler(applicationContext)
        var db = helper.readableDatabase
        var rs = db.rawQuery("SELECT * FROM USER", null)
        button.setOnClickListener {
            var cv = ContentValues()
            cv.put("USER", username.editText.toString())
            cv.put("ID", email.editText.toString())
            cv.put("PASSWORD", password.editText.toString())
            cv.put("MOBILE", mobile.editText.toString())
            db.insert("TABLE_WED", null, cv)

        }

    }
}