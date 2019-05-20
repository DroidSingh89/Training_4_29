package com.example.training_4_29.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment

class HeadlessFragment: androidx.fragment.app.Fragment() {

    var value: String = "Default Value"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true

    }

}