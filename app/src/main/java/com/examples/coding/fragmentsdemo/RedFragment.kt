package com.examples.coding.fragmentsdemo


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_red.*
import kotlinx.android.synthetic.main.fragment_red.view.*

/**
 * A simple [Fragment] subclass.
 */
class RedFragment() : Fragment(), View.OnClickListener {

    lateinit var listener: OnFragmentInteractionListener

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_red, container, false)
    }

    fun setFragListener(passedListener : OnFragmentInteractionListener) {
        listener = passedListener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        //setRetainInstance(true);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.btnSendRedData.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val userInput = etRedInput.text.toString()
        listener.dataFromRedFragment(userInput)
        tvRedDisplay.text = userInput
    }
}

interface OnFragmentInteractionListener{
    fun dataFromRedFragment(value : String)
}
