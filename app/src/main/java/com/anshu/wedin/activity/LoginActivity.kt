package com.anshu.wedin.activity

import android.app.ProgressDialog
import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import com.anshu.wedin.database.DatabaseHandler
import com.anshu.wedin.databinding.ActivityLoginBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.password as password1

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        signin.setOnClickListener {
            when{
                TextUtils.isEmpty(nameEt.editText.toString().trim{it <= ' '}) -> {
                    Toast.makeText(
                        this@LoginActivity,
                        "Please enter email.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                TextUtils.isEmpty(password.editText.toString().trim{it <= ' '}) -> {
                    Toast.makeText(
                        this@LoginActivity,
                        "Please enter email.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    val email: String = nameEt.editText.toString().trim { it <= ' '}
                    val password: String = password.editText.toString().trim { it <= ' '}

                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(
                           OnCompleteListener { task ->
                              if (task.isSuccessful){

                                  val firebaseUser: FirebaseUser = task.result!!.user!!
                                  Toast.makeText(
                                      this@LoginActivity,
                                      "You are sign in successfully.",
                                      Toast.LENGTH_SHORT
                                  ).show()

                                  val intent =
                                      Intent(this@LoginActivity, MainActivity::class.java)
                                     intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                    intent.putExtra("user_id", firebaseUser.uid)
                                  intent.putExtra("email_id", email)
                                  intent.putExtra("Password", password)
                                  startActivity(intent)
                                  finish()
                              }else{
                                  Toast.makeText(
                                      this@LoginActivity,
                                      task.exception!!.message.toString(),
                                      Toast.LENGTH_SHORT
                                  ).show()
                              }
                            }
                        )
                }
            }
        }
    }
}

