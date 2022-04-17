package com.ypwang.medium

class Solution2245 {
    fun maxTrailingZeros(grid: Array<IntArray>): Int {
        //trailing 0, 10->1, 100->2
        //10 = 2 * 5
        //100 = 2*2*5*5
        //etc.
        //min(countOf2,countOf5);
        //Part 1: move only horizontal
        //Part 2: move only vertically
        //Part 3: one L turn
        //Part 4: one 7 turn
        //Part 5: one J turn
        //Part 6: one |` turn

        //Create PrefixSum array to store count of 2 and 5, then we need O(1) time to get count of 2 or 5.
        //matrix count of 2, in row i, from j to k (j<=k) matrix2[i+1][k+1] - matrix2[i+1][j]
        val m = grid.size
        val n = grid[0].size
        val matrix2row = Array(m + 1) { IntArray(n + 1) }
        val matrix5row = Array(m + 1) { IntArray(n + 1) }
        //matrix count of 2, in col i, from j to k (j<=k) matrix[k+1][i] - matrix[j][i+1]
        val matrix2col = Array(m + 1) { IntArray(n + 1) }
        val matrix5col = Array(m + 1) { IntArray(n + 1) }
        for (i in grid.indices) {
            // System.out.println(Arrays.toString(grid[i]));
            for (j in grid[0].indices) {
                val count2 = count2(grid[i][j])
                val count5 = count5(grid[i][j])
                // System.out.println("grid["+i+"]"+"["+j+"]="+"grid[i][j]"+",count2:"+count2);
                matrix2row[i + 1][j + 1] = matrix2row[i + 1][j] + count2
                matrix5row[i + 1][j + 1] = matrix5row[i + 1][j] + count5
            }
        }
        for (j in grid[0].indices) {
            for (i in grid.indices) {
                val count2 = count2(grid[i][j])
                val count5 = count5(grid[i][j])
                matrix2col[i + 1][j + 1] = matrix2col[i][j + 1] + count2
                matrix5col[i + 1][j + 1] = matrix5col[i][j + 1] + count5
            }
        }
        //Part 1: move only horizontal
        //grid[0][0]->grid[0][n-1]
        //grid[1][0]->grid[1][n-1]
        //...
        //grid[m-1][0]->grid[m-1][n-1]
        var ans = 0
        for (i in 0 until m) {
            val count2 = matrix2row[i + 1][n] - matrix2row[i + 1][0]
            val count5 = matrix5row[i + 1][n] - matrix5row[i + 1][0]
            ans = maxOf(ans, minOf(count2, count5))
        }

        //Part 2: move only vertically
        //grid[0][0]->grid[m-1][0]
        //grid[0][1]->grid[m-1][1]
        //...
        //grid[0][n-1]->grid[m-1][n-1]
        for (j in 0 until n) {
            val count2 = matrix2col[m][j + 1] - matrix2col[0][j + 1]
            val count5 = matrix5col[m][j + 1] - matrix5col[0][j + 1]
            ans = maxOf(ans, minOf(count2, count5))
        }
        //Find center of + then there are 4 directions
        for (i in 0 until m) {
            for (j in 0 until n) {

                //up (i,j) to (0,j)
                val count2Up = matrix2col[i + 1][j + 1] - matrix2col[0][j + 1]
                val count5Up = matrix5col[i + 1][j + 1] - matrix5col[0][j + 1]
                //down (i,j) to (m-1,j)
                val count2Down = matrix2col[m][j + 1] - matrix2col[i][j + 1]
                val count5Down = matrix5col[m][j + 1] - matrix5col[i][j + 1]
                //left (i,0) to (i,j)
                val count2Left = matrix2row[i + 1][j + 1] - matrix2row[i + 1][0]
                val count5Left = matrix5row[i + 1][j + 1] - matrix5row[i + 1][0]
                //right (i,j) to (i,n-1)
                val count2Right = matrix2row[i + 1][n] - matrix2row[i + 1][j]
                val count5Right = matrix5row[i + 1][n] - matrix5row[i + 1][j]
                //3.1 L turn
                ans = maxOf(ans, minOf(count2Up + count2Right - count2(grid[i][j]), count5Up + count5Right - count5(grid[i][j])))
                //3.2 7 turn
                ans = maxOf(ans, minOf(count2Up + count2Left - count2(grid[i][j]), count5Up + count5Left - count5(grid[i][j])))
                //3.3 |` turn
                ans = maxOf(ans, minOf(count2Down + count2Right - count2(grid[i][j]), count5Down + count5Right - count5(grid[i][j])))
                //3.4 J turn
                ans = maxOf(ans, minOf(count2Down + count2Left - count2(grid[i][j]), count5Down + count5Left - count5(grid[i][j])))
            }
        }
        return ans
    }

    fun count2(x: Int): Int {
        var x = x
        var count = 0
        while (x % 2 == 0) {
            count++
            x /= 2
        }
        return count
    }

    fun count5(x: Int): Int {
        var x = x
        var count = 0
        while (x % 5 == 0) {
            count++
            x /= 5
        }
        return count
    }
}