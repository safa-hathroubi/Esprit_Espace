package tn.esprit.esprit_space

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.CheckBox
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

const val PREF_NAME = "DATA_CV_PREF"

class MainActivity : AppCompatActivity() {

    private var txtEmail: TextInputEditText? = null
    private var txtLayoutEmail: TextInputLayout? = null

    private var btnSubmit : Button? = null

    lateinit var mSharedPref: SharedPreferences
    lateinit var cbRememberMe: CheckBox


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtEmail = findViewById(R.id.textInputEditTextEmail)
        txtLayoutEmail = findViewById(R.id.textInputLayoutEmail)

        btnSubmit = findViewById(R.id.loginButton)

        cbRememberMe = findViewById(R.id.cbRememberMe)
        mSharedPref = getSharedPreferences(PREF_NAME, MODE_PRIVATE);

    }

    private fun validate(): Boolean {
        txtLayoutEmail!!.error = null


        if (txtEmail?.text!!.isEmpty()) {
            txtLayoutEmail!!.error = getString(R.string.mustNotBeEmpty)
            return false
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(txtEmail?.text!!).matches()) {
            txtLayoutEmail!!.error = getString(R.string.checkYourEmail)
            return false
        }

        return true
    }


}
