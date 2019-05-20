package com.example.training_4_29.ui.activity.firebase

import com.example.training_4_29.ui.base.BasePresenter
import com.example.training_4_29.ui.base.BaseView

interface FirebaseContract {


    interface View: BaseView{

        fun onUserCreation(isCreated: Boolean)
        fun onLoginResults(isValid: Boolean)
        fun onSignOut(isSignedOut: Boolean)
    }

    interface Presenter: BasePresenter<View>{

//        authentication
        fun createUser(email: String, password:String)
        fun signIn(email: String, password: String)
        fun signOut()
        fun checkSession(callback: (Boolean)->Unit)

//        real time database
        fun readDataFromCloud()
        fun saveDataToCloud(data: String)

    }


}