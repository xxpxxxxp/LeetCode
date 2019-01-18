package com.ypwang.easy;


// Definition for a QuadTree node.
class QNode {
    public boolean val;
    public boolean isLeaf;
    public QNode topLeft;
    public QNode topRight;
    public QNode bottomLeft;
    public QNode bottomRight;

    public QNode() {}

    public QNode(boolean _val,boolean _isLeaf,QNode _topLeft,QNode _topRight,QNode _bottomLeft,QNode _bottomRight) {
        val = _val;
        isLeaf = _isLeaf;
        topLeft = _topLeft;
        topRight = _topRight;
        bottomLeft = _bottomLeft;
        bottomRight = _bottomRight;
    }
};

class Solution427 {
    public QNode helper(int[][] grid, int x, int y, int len) {
        if (len == 1) {
            return new QNode(grid[x][y] == 1, true, null, null, null, null);
        }

        QNode topLeft = helper(grid, x, y, len/2);
        QNode topRight = helper(grid, x, y + len/2, len/2);
        QNode bottomLeft = helper(grid, x + len/2, y, len/2);
        QNode bottonRight = helper(grid, x + len/2, y + len/2, len/2);

        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottonRight.isLeaf && topLeft.val == topRight.val && topLeft.val == bottomLeft.val && topLeft.val == bottonRight.val) {
            return new QNode(topLeft.val, true, null, null, null, null);
        }
        return new QNode(false, false, topLeft, topRight, bottomLeft, bottonRight);
    }

    public QNode construct(int[][] grid) {
        if (grid.length == 0) {
            return new QNode(false, false, null, null, null, null);
        }
        return helper(grid, 0, 0, grid.length);
    }
}

class Program {
    public static void main(String[] args) {
        int[][] grid =  {{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0}};
        new Solution427().construct(grid);

    }
}