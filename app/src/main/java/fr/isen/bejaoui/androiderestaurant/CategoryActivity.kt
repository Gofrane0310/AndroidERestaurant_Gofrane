package fr.isen.bejaoui.androiderestaurant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        val q = Volley.newRequestQueue(this)
        val url = "https://google.com/"
        val stringrequest = StringRequest(Request.Method.GET, url,
        Response.Listener<String> {response ->
                Log.d("Request", response)
        }
            Response.
    }
}