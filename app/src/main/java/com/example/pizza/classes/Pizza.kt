package com.example.pizza.classes

class Pizza {
    var id = 0
    var nom: String = ""
    var nbrIngredients = 0
    var photo = 0
    var duree = 0f
    var detailsIngred: String = ""
    var description: String = ""
    var preparation: String? = ""
    //default constructor
    constructor() {}
    constructor(
        nom: String,
        nbrIngredients: Int,
        photo: Int,
        duree: Int,
        detailsIngred: String,
        description: String,
        preparation: String
    ) {
        id = ++comp
        this.nom = nom
        this.nbrIngredients = nbrIngredients
        this.photo = photo
        this.duree = duree.toFloat()
        this.detailsIngred = detailsIngred
        this.description = description
        this.preparation = preparation
    }
    companion object {
        private var comp = 0
    }
    override fun toString(): String {
        return "Pizza(id=$id, nom='$nom', nbrIngredients=$nbrIngredients, photo=$photo, duree=$duree, detailsIngred='$detailsIngred',description='$description’,preparation=$preparation)"
    }

}