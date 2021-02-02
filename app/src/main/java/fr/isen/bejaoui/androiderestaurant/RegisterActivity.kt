package fr.isen.bejaoui.androiderestaurant

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.isen.bejaoui.androiderestaurant.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_register)

        binding.buttonRegister.setOnClickListener {
            if(verifyInformation()){
                launchRequest()
            } else {

            }
        }
    }

    private fun launchRequest(){
        setResult(Activity.RESULT_OK)
        finish()
    }

    private fun verifyInformation(): Boolean {
        return true
    }

    companion object{
        const val REQUEST_CODE = 111
    }
}