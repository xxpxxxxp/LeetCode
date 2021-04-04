package com.ypwang.easy

class Solution1812 {
    fun squareIsWhite(coordinates: String): Boolean =
        ((coordinates[0] - 'a') + (coordinates[1] - '1')) % 2 == 1
}