package com.examples.coding.fragmentsdemo

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_green.view.*

private const val BLUE_PARAM = "blue_param"
private const val RED_PARAM = "red_param"

class GreenFragment : Fragment() {

    private var blueParam: String? = null
    private var redParam: String? = null
    private var listener: OnFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            blueParam = it.getString(BLUE_PARAM)
            redParam = it.getString(RED_PARAM)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_green, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.tvRedPassedValue.text = redParam
        view.tvBluePassedValue.text = blueParam
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
        fun onFragmentInteraction()
    }

    companion object {

        @JvmStatic
        fun newInstance(blue: String, red: String) =
            GreenFragment().apply {
                arguments = Bundle().apply {
                    putString(BLUE_PARAM, blue)
                    putString(RED_PARAM, red)
                }
            }
    }
}
