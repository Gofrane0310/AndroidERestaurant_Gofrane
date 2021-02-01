package fr.isen.bejaoui.androiderestaurant

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.view.Menu
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import fr.isen.bejaoui.androiderestaurant.CategoryActivity.Companion.USER_PREFERENCES_NAME

open class BaseActivity: AppCompatActivity() {
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        val menuView = menu?.findItem(R.id.basket)?.actionView
        val countText = menuView?.findViewById<TextView>(R.id.basketCount)
        countText?.text = "1"

        menuView?.setOnClickListener {
            val intent = Intent(this, BasketActivity::class.java)
            startActivity(intent)
        }
        return true
    }

    override fun onResume() {
        super.onResume()
        invalidateOptionsMenu()
    }

    private fun getItemsCount(): Int {
        val sharedPreferences = getSharedPreferences(DetailActivity.USER_PREFERENCES_NAME, Context.MODE_PRIVATE)
        return sharedPreferences.getInt(DetailActivity.ITEMS_COUNT, 0)
    }
}