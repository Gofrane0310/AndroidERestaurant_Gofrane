package fr.isen.bejaoui.androiderestaurant

import android.content.Context
import com.google.gson.GsonBuilder
import fr.isen.bejaoui.androiderestaurant.models.Dish
import java.io.File
import java.io.Serializable

class Basket (val items: MutableList<BasketItem>): Serializable{

    fun addItem(item: BasketItem) {
        val existingItem = items.firstOrNull {
            it.dish.name == item.dish.name
        }
        existingItem?.let {
            existingItem.count += item.count
        } ?: run {
            items.add(item)
        }
    }

    fun save(context: Context) {
        val jsonFile = File(context.cacheDir.absolutePath + BASKET_FILE)
        jsonFile.writeText(GsonBuilder().create().toJson(this))
    }


    companion object {
        fun getBasket(context: Context): Basket {
            val jsonFile = File(context.cacheDir.absolutePath + BASKET_FILE)
            return if (jsonFile.exists()) {
                val json = jsonFile.readText()
                GsonBuilder().create().fromJson(json, Basket::class.java)
            } else {
                Basket(mutableListOf())
            }
        }

        const val BASKET_FILE = "basket_json"
    }
}

class BasketItem(val dish: Dish, var count: Int): Serializable{}