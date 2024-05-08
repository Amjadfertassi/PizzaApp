package com.example.pizza.dao

import com.example.pizza.classes.Pizza
interface IDao <T>{
    fun create (o : T) : Boolean
    fun delete (o : T) : Boolean
    fun update (o : T) : Boolean
    fun findById (id : Int) : Pizza?
    fun findAll () : List<T>
}