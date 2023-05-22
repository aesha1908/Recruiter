package com.example.recruiter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider

class OTPRecruiterActivity : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    lateinit var otp_ver: Button;
    lateinit var tv: TextView
    lateinit var ot_1: EditText;
    lateinit var ot_2: EditText
    lateinit var ot_3: EditText;
    lateinit var ot_4: EditText
    lateinit var ot_5: EditText;
    lateinit var ot_6: EditText
    private lateinit var verificationId: String
    private lateinit var phoneAuthProvider: PhoneAuthProvider
    private lateinit var storedVerificationId: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otprecruiter)
        auth = FirebaseAuth.getInstance()
        phoneAuthProvider = PhoneAuthProvider.getInstance()
        otp_ver = findViewById(R.id.btnotpR)
        tv = findViewById(R.id.mobileR)
        ot_1 = findViewById(R.id.ot1R)
        ot_2 = findViewById(R.id.ot2R)
        ot_3 = findViewById(R.id.ot3R)
        ot_4 = findViewById(R.id.ot4R)
        ot_5 = findViewById(R.id.ot5R)
        ot_6 = findViewById(R.id.ot6R)
        ot_1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (ot_1.text.toString().length === 1) {
                    ot_2.requestFocus()
                }
            }

            override fun afterTextChanged(editable: Editable) {}
        })
        ot_2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (ot_2.text.toString().length === 1) {
                    ot_3.requestFocus()
                }
            }

            override fun afterTextChanged(editable: Editable) {}
        })
        ot_3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (ot_3.text.toString().length === 1) {
                    ot_4.requestFocus()
                }
            }

            override fun afterTextChanged(editable: Editable) {}
        })
        ot_4.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (ot_4.text.toString().length === 1) {
                    ot_5.requestFocus()
                }
            }

            override fun afterTextChanged(editable: Editable) {}
        })
        ot_5.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (ot_5.text.toString().length === 1) {
                    ot_6.requestFocus()
                }
            }

            override fun afterTextChanged(editable: Editable) {}
        })
        ot_6.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
                if (ot_6.text.toString().length === 1) {
                    otp_ver.requestFocus()
                }
            }

            override fun afterTextChanged(editable: Editable) {}
        })

        val phonenum = intent.getStringExtra("phonenum")
        storedVerificationId = intent.getStringExtra("verification_id") ?: ""
        tv.text = phonenum
        otp_ver.setOnClickListener {
            if (ot_1.text.isEmpty() || ot_2.text.isEmpty() ||
                ot_3.text.isEmpty() || ot_4.text.isEmpty() ||
                ot_5.text.isEmpty() || ot_6.text.isEmpty()
            ) {
                Toast.makeText(this, "Please Enter OTP", Toast.LENGTH_LONG).show()
            } else {
                val code =
                    ot_1.text.toString() + ot_2.text.toString() + ot_3.text.toString() + ot_4.text.toString() +
                            ot_5.text.toString() + ot_6.text.toString()
                val credential = PhoneAuthProvider.getCredential(storedVerificationId, code)
                signInWithPhoneAuthCredential(credential)
            }
        }
    }
    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Verification successful, proceed to next activity
                    val intent = Intent(this@OTPRecruiterActivity, HomeActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    // Verification failed
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        // Invalid verification code
                    }
                }
            }
    }
}