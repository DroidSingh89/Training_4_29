package com.example.training_4_29.ui.activity.firebase

import com.example.training_4_29.manager.LoginManager

class FirebasePresenter : FirebaseContract.Presenter {
    var view: FirebaseContract.View? = null

    override fun checkSession(callback: (Boolean) -> Unit) {
        callback.invoke(LoginManager.checkSession())
    }

    override fun createUser(email: String, password: String) {
        LoginManager.createUser(email, password) { isCreated -> view?.onUserCreation(isCreated) }
    }

    override fun signIn(email: String, password: String) {
        LoginManager.signIn(email, password) { isValid -> view?.onLoginResults(isValid) }
    }

    override fun signOut() {
        LoginManager.signOut { isSignedOut -> view?.onSignOut(isSignedOut) }
    }

    override fun readDataFromCloud() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveDataToCloud(data: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addView(view: FirebaseContract.View) {
        this.view = view
    }

    override fun removeView() {
        this.view = null
    }
}