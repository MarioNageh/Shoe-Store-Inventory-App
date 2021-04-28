
# Android MVVM Architecture: Shoe Store Inventory APP  
![alt text](https://cdn-images-1.medium.com/max/1600/1*OqeNRtyjgWZzeUifrQT-NA.png)  
  
The main advatage of using MVVM, there is no two way dependency between ViewModel and Model unlike MVP. Here the view can observe the datachanges in the viewmodel as we are using LiveData which is lifecycle aware. The viewmodel to view communication is achieved through observer pattern (basically observing the state changes of the data in the viewmodel).  
  
  
This repository contains a Shoe Store Inventory app that implements MVVM architecture using Navigation Component, Singel Activtiy
  
<p align="center">  
  <img src="https://user-images.githubusercontent.com/36963317/116445040-b5294780-a855-11eb-98d1-1b330f933017.png" width="250">  
  <br>  
  <img src="https://user-images.githubusercontent.com/36963317/116445046-b8243800-a855-11eb-95a0-3bafc14bd967.png" width="250">  
 <br>  
  <img src="https://user-images.githubusercontent.com/36963317/116445051-b8bcce80-a855-11eb-9151-330527c4df94.png" width="250">  
  <br>  
  <img src="https://user-images.githubusercontent.com/36963317/116445062-b9edfb80-a855-11eb-9eff-0a4421caba47.png" width="250">  
    <br>  
  <img src="https://user-images.githubusercontent.com/36963317/116445064-ba869200-a855-11eb-8d7d-0fd37f126d82.png" width="250">  
    <br>  
  <img src="https://user-images.githubusercontent.com/36963317/116445066-bb1f2880-a855-11eb-8385-cf57c4ba346e.png" width="250">  
    <br>  
  <img src="https://user-images.githubusercontent.com/36963317/116445067-bb1f2880-a855-11eb-8271-dfaacdff3afe.png" width="250">  
</p>  
<br>  
<br>  
  
#### The app has following packages:  
1. **modules**: It contains all the data accessing and manipulating components.  
2. **ui**: Contains all App Ui

  
#### Classes have been designed in such a way that it could be inherited and maximize the code reuse.  
  
### Special Constants:  
1- Founded in ```/Constant.kt```  
```  
// usersList : For Login Simulations
  var usersList = mutableListOf(  
User("Marionageh7@gmai.com", "123456"),  
User("m", "1"),  
)  
  
  // usersList : For Data Simulation
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

```  
  