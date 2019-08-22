package buu.informatics.s59160092.parkingcar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputBinding
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import buu.informatics.s59160092.parkingcar.databinding.ActivityMainBinding
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
//
    var arr : ArrayList<ProfileData> = ArrayList()
    var num = 0

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.updateBtn.setOnClickListener { addDate(it) }
        binding.editBtn.setOnClickListener { editDate(it) }
        binding.btnProfile1.setOnClickListener { showData(it , 1) }
        binding.btnProfile2.setOnClickListener { showData(it , 2) }
        binding.btnProfile3.setOnClickListener { showData(it , 3) }

        for (i in 1..3) {
            var profileData:ProfileData = ProfileData("", "" ,"")
            arr.add(profileData)
        }

    }

    private fun showData(view: View , int: Int) {

        binding.apply {
            binding.name.visibility = View.VISIBLE
            binding.license.visibility = View.VISIBLE
            binding.car.visibility = View.VISIBLE

//        arr.get(0).name_pf
            if (int == 1) {
                binding.name.setText(arr.get(0).name_pf)
                binding.license.setText(arr.get(0).license_pf)
                binding.car.setText(arr.get(0).car_pf)
                num = 0
            } else if (int == 2) {
                binding.name.setText(arr.get(1).name_pf)
                binding.license.setText(arr.get(1).license_pf)
                binding.car.setText(arr.get(1).car_pf)
                num = 1
            } else if (int == 3) {
                binding.name.setText(arr.get(2).name_pf)
                binding.license.setText(arr.get(2).license_pf)
                binding.car.setText(arr.get(2).car_pf)
                num = 2
            }
        }



    }


    private fun addDate(view: View) {


        binding.name.text = binding.textName.text
        binding.license.text = binding.textNumb.text
        binding.car.text = binding.textCar.text

        binding.textName.visibility = View.GONE
        binding.textNumb.visibility = View.GONE
        binding.textCar.visibility = View.GONE

        binding.name.visibility = View.VISIBLE
        binding.license.visibility = View.VISIBLE
        binding.car.visibility = View.VISIBLE

        var profileData:ProfileData = ProfileData(binding.textName.text.toString(), binding.textNumb.text.toString() , binding.textCar.text.toString())
        arr.set(num,profileData)

        binding.textName.setText("")
        binding.textNumb.setText("")
        binding.textCar.setText("")

    }


    private fun editDate(view: View) {

        binding.name.text = binding.textName.text
        binding.license.text = binding.textNumb.text
        binding.car.text = binding.textCar.text

        binding.textName.visibility = View.VISIBLE
        binding.textNumb.visibility = View.VISIBLE
        binding.textCar.visibility = View.VISIBLE

        binding.name.visibility = View.GONE
        binding.license.visibility = View.GONE
        binding.car.visibility = View.GONE



    }
}
