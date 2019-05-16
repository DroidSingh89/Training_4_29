package com.example.training_4_29.fragment

import android.os.Bundle
import android.support.v4.app.Fragment

class HeadlessFragment: Fragment() {

    var value: String = "Default Value"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true

    }

}