package com.example.training_4_29.activity

import android.os.Bundle
import android.util.Log
import com.example.training_4_29.BaseActivity
import com.example.training_4_29.R
import com.example.training_4_29.fragment.DynamicFragment
import com.example.training_4_29.fragment.HeadlessFragment
import com.example.training_4_29.fragment.StaticFragment
import com.example.training_4_29.utils.toast
import kotlinx.android.synthetic.main.activity_fragment.*

class FragmentActivity : BaseActivity(), DynamicFragment.OnFragmentInteractionListener {


    override fun onFragmentInteraction(string: String) {

        val staticFragment = supportFragmentManager.findFragmentByTag("staticFragment")

        if (staticFragment != null) {
            staticFragment as StaticFragment
            staticFragment.updateTextView(string)
        } else {
            toast("Added the static fragment first")
            supportFragmentManager.beginTransaction()
                .add(R.id.dynamicFragmentHolder2, StaticFragment.newInstance(string), "staticFragment")
                .commit()
        }

    }

    lateinit var headlessFragment: HeadlessFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        Log.d(FragmentActivity::class.java.simpleName, "onCreate: ")

        supportFragmentManager.beginTransaction().add(HeadlessFragment(), "headless").commit()

        staticFragment.retainInstance = true
        Log.d(FragmentActivity::class.java.simpleName, "onCreate: $staticFragment")

        val dynamicFragment = DynamicFragment.newInstance("param1", "param2")

        btnAddFragment.setOnClickListener {
            headlessFragment.value = "New value"
            supportFragmentManager.beginTransaction()
                .add(R.id.dynamicFragmentHolder, dynamicFragment, "dynamicFragment")
                .add(R.id.dynamicFragmentHolder2, StaticFragment(), "staticFragment")
                .addToBackStack("dynamicFragment")
                .commit()

            Log.d(FragmentActivity::class.java.simpleName, "onCreate: $staticFragment")
        }

        btnRemoveFragment.setOnClickListener {

            toast(headlessFragment.value)
            supportFragmentManager.popBackStack("dynamicFragment", 0)
        }

    }

    override fun onStart() {
        super.onStart()

        val fragment = supportFragmentManager.findFragmentByTag("headless")


        if (fragment != null) {
            headlessFragment = fragment as HeadlessFragment
            headlessFragment.retainInstance = true

        } else {
            headlessFragment = HeadlessFragment()

            supportFragmentManager.beginTransaction()
                .add(headlessFragment, "headless")
                .commit()
        }
        Log.d(FragmentActivity::class.java.simpleName, "onStart: $headlessFragment")
    }

    override fun onResume() {
        super.onResume()
        Log.d(FragmentActivity::class.java.simpleName, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(FragmentActivity::class.java.simpleName, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(FragmentActivity::class.java.simpleName, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(FragmentActivity::class.java.simpleName, "onDestroy: ")
    }

}
