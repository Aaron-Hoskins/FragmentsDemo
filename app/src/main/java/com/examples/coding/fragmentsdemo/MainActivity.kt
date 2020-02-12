package com.examples.coding.fragmentsdemo

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity(), OnFragmentInteractionListener,
    BlueFragment.OnFragmentInteractionListener,
    GreenFragment.OnFragmentInteractionListener{
    val redFragment : RedFragment by lazy { supportFragmentManager.findFragmentById(R.id.fgRedFragment) as RedFragment }
    val blueFragment by lazy{BlueFragment()}
    val greenFragment by lazy{GreenFragment.newInstance(blueValue, redValue)}
    lateinit var redValue : String
    lateinit var blueValue : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        redFragment.setFragListener(this)

        //To Add fragment Dynamically
        supportFragmentManager
            .beginTransaction()
            .add(R.id.frmFragmentDisplayOne, blueFragment)
            .addToBackStack("BLUE_FRAG")
            .commit()
    }

    override fun dataFromRedFragment(value: String) {
        Toast.makeText(this, value, Toast.LENGTH_LONG).show()
        redValue = value
        displayAllValues()
    }

    override fun onFragmentInteraction(string : String) {
        Toast.makeText(this, string, Toast.LENGTH_LONG).show()
        blueValue = string
        displayAllValues()
    }

    fun displayAllValues() {
        if(this::redValue.isInitialized && this::blueValue.isInitialized) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.frmFragmentDisplayTwo, greenFragment)
                .addToBackStack("GREEN_FRAG")
                .commit()
        }
    }

    override fun onFragmentInteraction() {
    }

    fun onClick(view: View) {
        when(view.id) {
            R.id.btnPopOneFromStack -> {supportFragmentManager.popBackStack()}
            R.id.btnPopUptoTag -> {
                supportFragmentManager.popBackStack("BLUE_FRAG", FragmentManager.POP_BACK_STACK_INCLUSIVE)}
            R.id.btnAddFragment -> {
                val newFragment = BlueFragment()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frmFragmentDisplayOne, newFragment)
                    .addToBackStack("BLUE_FRAG")
                    .commit()
            }
            R.id.btnRemoveInstance ->{
                supportFragmentManager
                    .beginTransaction()
                    .remove(blueFragment)
                    .commit()
            }
        }

    }


}
