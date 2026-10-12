package com.ypwang.medium

class BusBooking(n: Int) {
    var totalBookingCost = 0
    var total = 0
    var booking = Array(n + 1) { IntArray(4) }

    fun toggle(seat: String) {
        val col = seat[0] - 'A'
        val row = seat.substring(1).toInt()
        if (booking[row][col] != 0) {
            totalBookingCost -= booking[row][col]
            booking[row][col] = 0
            total--
        } else {
            if (col == 1 || col == 2) {
                totalBookingCost += 1
                booking[row][col] = 1
                total++
            } else if (col == 0) {
                if (booking[row][1] == 1) {
                    totalBookingCost += 3
                    booking[row][col] = 3
                    total++
                } else {
                    totalBookingCost += 1
                    booking[row][col] = 1
                    total++
                }
            } else {
                if (booking[row][2] == 1) {
                    totalBookingCost += 3
                    booking[row][col] = 3
                    total++
                } else {
                    totalBookingCost += 1
                    booking[row][col] = 1
                    total++
                }
            }
        }
    }

    fun getTotalTime(): Int = totalBookingCost

    fun getMinTime(): Int = total
}
