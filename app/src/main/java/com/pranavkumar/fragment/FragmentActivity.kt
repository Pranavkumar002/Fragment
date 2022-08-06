package com.pranavkumar.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.pranavkumar.fragment.databinding.ActivityFragmentBinding

class FragmentActivity : AppCompatActivity() {
    lateinit var ActivityInterface :ActivityInterface
    lateinit var binding: ActivityFragmentBinding
    var i=1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAlertDialog.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setCancelable(false)
                setTitle("Select Color")
                setMessage("Select a color that you want to set as fragment background")
                setPositiveButton("Purple"){_,_->
                    ActivityInterface.ActivityInterface(1, i)
                    i++
                }
                setNegativeButton("Blue"){_,_->
                    ActivityInterface.ActivityInterface(2, i)
                    i++
                }
                setNeutralButton("Yellow"){_,_->
                    ActivityInterface.ActivityInterface(3, i)
                    i++
                }
            }.show()
        }
    }
    fun showToast(){
        Toast.makeText(this,"Invoked from Fragment",Toast.LENGTH_SHORT).show()
    }
    }
