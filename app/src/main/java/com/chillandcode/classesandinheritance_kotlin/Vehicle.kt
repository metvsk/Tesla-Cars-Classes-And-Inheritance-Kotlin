package com.chillandcode.classesandinheritance_kotlin

import android.content.ContentValues.TAG
import android.util.Log

abstract class Vehicle(carName:String) {//made it abstract
    private lateinit var carName:String
    //val tesla:String
    //gives build error :
    //Property must be initialized or be abstract




//    var solarCellManufacturer:String=""// will work if initialized and we can change according to which compnies cells we are going to use on each vehicle subclass say tesla-x or tesla-vE35
    abstract var solarCellManufacturer: String// or else if we MAKE it abstract

    private var batteryCharge: Int = 0//battery is already there in tesla so it need not be made abstract
    private var fullyCharged: Boolean = true;//battery is already there in tesla so it need not be made abstract

    //why -> components can be defined abstract if they will be defined only in the future
    //ie, Our project needs to have solar recharging functionalities as per the directions of the product team
    //if it is in research phase we will add it as an abstract function
    //then later on when we finalise the implementation after finding the technology feasible we can implement
    // so the thing is we are let known by the project manager that these features are our projects vision.

    abstract fun toggleSolar()// this is an abstract function
init {
    Log.i(TAG, "Finished new unit of $carName")
}
    fun getCurrentBatteryCharge(): Int {//this is a defined function or not abstract
        return batteryCharge;
    }

    fun incrementBatteryCharge() {
        if (batteryCharge < 100) {
            batteryCharge++
            updateFullyChargedStatus(batteryCharge)
        }
    }


    fun decreaseBatteryCharge() {
        if (batteryCharge > 0) {
            batteryCharge--
            updateFullyChargedStatus(batteryCharge)
        }
    }

    private fun updateFullyChargedStatus(batteryCharge: Int) {
        if (batteryCharge < 100) fullyCharged = false
    }
    
    private fun logIdentity(){
        Log.i(TAG, "logIdentity: $carName")
    }
    open fun test(){
        toggleSolar()
    }
}