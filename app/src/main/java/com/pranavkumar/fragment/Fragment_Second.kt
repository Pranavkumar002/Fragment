package com.pranavkumar.fragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentSecond.newInstance] factory method to
 * create an instance of this fragment.
 */
class Fragment_Second : Fragment(), ActivityInterface {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var initView: View
    lateinit var tvHello: TextView
    lateinit var linearLayout : LinearLayout
    lateinit var fragmentActivity: FragmentActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentActivity = activity as FragmentActivity
        fragmentActivity.ActivityInterface = this
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        initView= inflater.inflate(R.layout.fragment_second, container, false)
        tvHello = initView.findViewById(R.id.tvHello)
        linearLayout= initView.findViewById(R.id.linearLayout)
        tvHello.setOnClickListener{
            fragmentActivity.showToast()
        }
        return initView

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentSecond.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment_Second().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
        override fun ActivityInterface(color:Int,i:Int){

            tvHello.setText("Changed color $i times")
            when (color){
                1->{
                    linearLayout.setBackgroundColor(ContextCompat.getColor(fragmentActivity,R.color.purple_500))
                }
                2->{
                    linearLayout.setBackgroundColor(ContextCompat.getColor(fragmentActivity,R.color.blue))
                }
                3->{
                    linearLayout.setBackgroundColor(ContextCompat.getColor(fragmentActivity,R.color.yellow))
                }
                else->{}
        }
    }
}