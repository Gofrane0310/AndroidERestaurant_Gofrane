package fr.isen.bejaoui.androiderestaurant.models

import com.google.gson.annotations.SerializedName

class MenuResult(val data: List<Category>) {}
class Category(@SerializedName("name_fr") val name: String, val items: List<Dish>) {}
class Dish(
    @SerializedName("name_fr") val name: String,
    val ingredients: List<Ingredient>,
    val images: List<String>,
    val prices: List<Price>
){
    fun getThumbnaiUrl(): String? {
        return if (images.isNotEmpty() && images[0].isNotEmpty()) {
            images[0]
        } else {
            null
        }
    }
}
class Ingredient(@SerializedName("name_fr") val name: String) {}
class Price(val price: String) {}
