package com.chillandcode.classesandinheritance_kotlin

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

//INSTEAD OF THE CODE LAB EXAMPLE OF DWELLING - VEHICLES AND CARS HAVE BEEN USED
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //var tesla:Vehicle=Vehicle("tesla-1x") //gives error
        //cannot create instance of an abstract class

        //so how do we use abstract classes > we extend from them and define new sub class add functionalities if we were able to define them else it remains abstract

        //Roadster was the first product of tesla
        //if we try making this not abstract as in following code snippet  we get error

        //        class TeslaRoadster : Vehicle("Tesla-Roadster-1") {
//        }

        // making it abstract means we still won't able to implement/ initialize the abstract variables or methods in the parent class while creating this child class/or in our case version of the product

//        abstract class TeslaRoadster : Vehicle("Tesla-Roadster-1") {
//        }


        //here when model X is released the same is
        class TeslaModelX(productNumber: Int) : Vehicle("Tesla X") {
            init {
                Log.i(TAG, "onCreate: Product Number : $productNumber")
            }

            override var solarCellManufacturer: String
                get() = "AEX Aerospace cells Co. Ltd."
                set(value) {

                }

            override fun toggleSolar() {
                Log.i(
                    TAG,
                    "toggleSolar: Cells out put max set at 120W : battery from $solarCellManufacturer"
                )
            }

        }

        // In a scenario where we give an update to the initial car
        // To the Tesla Roadster we will add the functions to the new model
        class TeslaRoadster(productNumber: Int) : Vehicle("Tesla-Roadster-1") {
            init {
                Log.i(TAG, "onCreate: Product Number : $productNumber")
            }

            override var solarCellManufacturer: String
                get() = "Y cells Co. Ltd."
                set(value) {}

            override fun toggleSolar() {
                Log.i(
                    TAG,
                    "toggleSolar: Cells out put max set at 30W : battery from $solarCellManufacturer"
                )
            }

            fun testBatteryEfficacy(){
                Log.i(TAG, "testBatteryEfficacy: $ Testing ")
            }
            override fun test(){
                super.test()
                testBatteryEfficacy()
            }

        }


        //now we can create our each car object from these sub classes
        //like


        //TESLA ROADSTER MANUFACTURING UNIT
        //param passed : numbering of items in batch used as product identification inside the batch
        val teslaRoadsterBatch1 = mutableListOf<TeslaRoadster>()
        val mfgNumber1TeslaRoadsterV2: TeslaRoadster = TeslaRoadster(teslaRoadsterBatch1.size)
        teslaRoadsterBatch1 += mfgNumber1TeslaRoadsterV2
        val mfgNumber2TeslaRoadsterV2: TeslaRoadster = TeslaRoadster(teslaRoadsterBatch1.size)
        teslaRoadsterBatch1 += mfgNumber2TeslaRoadsterV2
        val mfgNumber3TeslaRoadsterV2: TeslaRoadster = TeslaRoadster(teslaRoadsterBatch1.size)
        teslaRoadsterBatch1 += mfgNumber3TeslaRoadsterV2
        //we have three cars of the same TeslaRoadster model now

        //TESLA X MANUFACTURING UNIT
        //param passed : numbering of items in batch used as product identification inside the batch
        val teslaXBatch1 = mutableListOf<TeslaModelX>()


        val mfgNumber1TeslaX: TeslaModelX = TeslaModelX(teslaXBatch1.size)
        teslaXBatch1 += mfgNumber1TeslaX
        val mfgNumber2TeslaX: TeslaModelX = TeslaModelX(teslaXBatch1.size)
        teslaXBatch1 += mfgNumber2TeslaX
        val mfgNumber3TeslaX: TeslaModelX = TeslaModelX(teslaXBatch1.size)
        teslaXBatch1 += mfgNumber3TeslaX


        //we have three cars of the same TeslaRoadster model now

        //now while production testing we will test implementations we made later while defining our classes
        //we will go through batch products of each model from unit and access functions or values

        Log.i(TAG, "onCreate: ******************************************************************************\n***************---TESTS TESTS TESTS-- ****************\n******************************************************************************")

        teslaRoadsterBatch1[0].test()

        Log.i(TAG, "onCreate: ******************************************************************************\n***************---TESTS TESTS TESTS-- ****************\n******************************************************************************")
        teslaXBatch1[2].test()
    }
}