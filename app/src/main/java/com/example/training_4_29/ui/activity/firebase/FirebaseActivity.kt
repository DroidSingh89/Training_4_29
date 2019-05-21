package com.example.training_4_29.ui.activity.firebase

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.training_4_29.BaseActivity
import com.example.training_4_29.R
import com.example.training_4_29.TrainingApp
import com.example.training_4_29.databinding.ActivityFirebaseBinding
import com.example.training_4_29.manager.CloudManager
import com.example.training_4_29.utils.toast
import kotlinx.android.synthetic.main.activity_firebase.*
import javax.inject.Inject

class FirebaseActivity : BaseActivity(), FirebaseContract.View {

    @Inject
    lateinit var presenter: FirebasePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_firebase)

        val binding: ActivityFirebaseBinding = DataBindingUtil.setContentView(this, R.layout.activity_firebase)

        btnCreateUser.setOnClickListener {
            presenter.createUser(etEmail.text.toString(), etPassword.text.toString())
        }

        btnSignIn.setOnClickListener {
            presenter.signIn(etEmail.text.toString(), etPassword.text.toString())
        }

        btnSignOut.setOnClickListener { presenter.signOut() }


        //reading data  for firebase
        btnFirebaseSave.setOnClickListener {
            CloudManager.saveFirebaseData(etFirebaseData.text.toString())
        }

        btnFirebaseRead.setOnClickListener {
            CloudManager.readFirebaseData { }
        }
    }

    override fun onStart() {
        super.onStart()
        TrainingApp.get(this).firebaseComponent.inject(this)
        presenter.addView(this)
        presenter.checkSession { if (it) tvLoginStatus.text = "Signed In" else "Signed Out" }
    }

    override fun onStop() {
        super.onStop()
        presenter.removeView()

    }

    override fun onUserCreation(isCreated: Boolean) {
        toast("User Created: $isCreated")
    }

    override fun onLoginResults(isValid: Boolean) {
        toast("Login Results: $isValid")
    }

    override fun onSignOut(isSignedOut: Boolean) {
        toast("Signed out: $isSignedOut")
    }

    override fun showError(error: String) {
        toast("Error: $error")
    }
}
