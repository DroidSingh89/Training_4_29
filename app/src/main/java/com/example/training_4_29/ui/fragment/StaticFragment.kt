package com.example.training_4_29.ui.fragment


import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.training_4_29.R
import kotlinx.android.synthetic.main.fragment_static.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class StaticFragment : Fragment() {

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DynamicFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String) =
            StaticFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        Log.d(StaticFragment::class.java.simpleName, "onAttach: ")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(StaticFragment::class.java.simpleName, "onCreate: ")
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(StaticFragment::class.java.simpleName, "onCreateView: ")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_static, container, false)
    }


    fun updateTextView(value: String) {
        tvStaticFrag.text = value
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        tvStaticFrag.text = arguments?.getString(ARG_PARAM1)
        Log.d(StaticFragment::class.java.simpleName, "onActivityCreated: ")
    }
    override fun onStart() {
        super.onStart()
        Log.d(StaticFragment::class.java.simpleName, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(StaticFragment::class.java.simpleName, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(StaticFragment::class.java.simpleName, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(StaticFragment::class.java.simpleName, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(StaticFragment::class.java.simpleName, "onDestroy: ")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(StaticFragment::class.java.simpleName, "onDestroyView: ")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d(StaticFragment::class.java.simpleName, "onDetach: ")
    }


}
