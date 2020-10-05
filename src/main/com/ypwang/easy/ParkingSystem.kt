package com.ypwang.easy

class ParkingSystem(big: Int, medium: Int, small: Int) {
    private val limit = intArrayOf(big, medium, small)
    private val count = IntArray(3)

    fun addCar(carType: Int): Boolean {
        val t = carType - 1
        if (count[t] == limit[t]) {
            return false
        }


        count[t]++
        return true
    }
}
