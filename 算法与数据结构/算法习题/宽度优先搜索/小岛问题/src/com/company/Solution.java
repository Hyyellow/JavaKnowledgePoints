package com.company;

import java.util.LinkedList;

import java.util.Queue;

/**
 * @program: 小岛问题
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-07 16:08
 **/
public class Solution {

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        if (grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int number = 0;
        int row = grid.length;
        int column = grid[0].length;
        boolean[][] visited = new boolean[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfs(grid, i, j, visited);
                    number++;
                }
            }
        }
        return number;
    }

    private void bfs(char[][] grid, int i, int j, boolean[][] visited) {
        int[] kx = {1, -1, 0, 0};
        int[] ky = {0, 0, 1, -1};
        Queue<Integer> xQueue = new LinkedList<>();
        Queue<Integer> yQueue = new LinkedList<>();

        visited[i][j] = true;
        xQueue.offer(i);
        yQueue.offer(j);

        while (!xQueue.isEmpty()) {
            int x = xQueue.poll();
            int y = yQueue.poll();
            for (int k = 0; k < 4; k++) {
                int newX = x + kx[k];
                int newY = y + ky[k];
                if (newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[0].length && !visited[newX][newY]) {
                    if (grid[newX][newY] == '1') {
                        xQueue.offer(newX);
                        yQueue.offer(newY);
                        visited[newX][newY] = true;
                    }
                }
            }
        }
    }
}
