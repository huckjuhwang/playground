package com.playground.hj.codingTest.leetcode.bfs;

import java.util.LinkedList;
import java.util.Queue;

// @see https://leetcode.com/problems/number-of-islands/description/
public class NumberOfIslands {


    static int x[] = {1, -1, 0, 0};
    static int y[] = {0, 0, 1, -1};

    static int[][] visited;

    public int numIslands(char[][] grid) {
        int count = 0;
        visited = new int[grid.length][grid[0].length];

        for(int i=0; i< grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if(visited[i][j] == 0 && grid[i][j] == '1') {
                    count++;
                    visited[i][j] = 1;
                    bfs(i, j, grid);
                }
            }
        }
        return count;
    }

    public static void bfs(int startX, int startY, char[][] grid) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startX, startY));

        while (!q.isEmpty()) {
            Point poll = q.poll();

            int nowX = poll.x;
            int nowY = poll.y;

            for(int i=0; i<4; i++) {
                int nextX = nowX + x[i];
                int nextY = nowY + y[i];

                if(nextX < 0 || nextY < 0 || nextX > visited.length || nextY > visited[0].length) {
                    continue;
                }

                if(visited[nextX][nextY] == 0 && grid[nextX][nextY] == '1') {
                    visited[nextX][nextY] = 1;
                    q.add(new Point(nextX, nextY));
                }
            }
        }
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
