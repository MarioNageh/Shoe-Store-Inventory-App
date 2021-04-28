package com.udacity.shoestore

import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.User

class Constants {
    companion object{
          var usersList = mutableListOf(
        User("Marionageh7@gmai.com", "123456"),
        User("m", "1"),
        )

        var shoeList= mutableListOf(
            Shoe("Mario",12.5,"Addidas","Nice It's Very Good Good Good Shoeess Nice Man", listOfNotNull()),
            Shoe("Mario",12.5,"Orange","Nice", listOfNotNull()),
            Shoe("Mario",12.5,"Vodapho","Nice", listOfNotNull()),
            Shoe("Mario",12.5,"OKY","Nice", listOfNotNull()),
            Shoe("Mario",12.5,"OKY","Nice", listOfNotNull()),
            Shoe("Mario",12.5,"OKY","Nice", listOfNotNull()),
            Shoe("Mario",12.5,"OKY","Nice", listOfNotNull()),
            Shoe("Mario",12.5,"OKY","Nice", listOfNotNull()),
            Shoe("Mario",12.5,"OKY","Nice", listOfNotNull()),
            Shoe("Mario",12.5,"OKY","Nice", listOfNotNull()),


        )
    }
}