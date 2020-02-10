package org.afdhal_fa.barvolume

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.databinding.DataBindingUtil
import org.afdhal_fa.barvolume.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.btnCalculate.setOnClickListener {
            val inputLength = binding.edtLength.text.toString().trim()
            val inputHeight =binding.edtHeight.text.toString().trim()
            val inputWidth=binding.edtWidth.text.toString().trim()

            var isEmptyFailed=false

            if (inputLength.isEmpty()){
                isEmptyFailed=true
                binding.edtLength.error= "Field ini tidak boleh kosong"
            }

            if (inputHeight.isEmpty()){
                isEmptyFailed=true
                binding.edtHeight.error= "Field ini tidak boleh kosong"
            }

            if (inputWidth.isEmpty()){
                isEmptyFailed=true
                binding.edtWidth.error= "Field ini tidak boleh kosong"
            }

            if (!isEmptyFailed){
                val volume=inputLength.toDouble() * inputHeight.toDouble()* inputWidth.toDouble()
                binding.tvResult.text=volume.toString()
            }
        }
    }
}
