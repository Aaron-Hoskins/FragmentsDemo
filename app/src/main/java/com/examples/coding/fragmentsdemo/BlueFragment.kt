package com.examples.coding.fragmentsdemo

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_blue.*
import kotlinx.android.synthetic.main.fragment_blue.view.*

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [BlueFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 */
class BlueFragment : Fragment(), View.OnClickListener {
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blue, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.btnSendBlueData.setOnClickListener(this)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(string : String)
    }

    override fun onClick(view: View?) {
        listener?.onFragmentInteraction(etBlueInput.text.toString())
    }

}
