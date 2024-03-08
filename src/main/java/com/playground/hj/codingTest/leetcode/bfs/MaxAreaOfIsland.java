package com.playground.hj.codingTest.leetcode.bfs;

import java.util.*;

class MaxAreaOfIsland {

    static int x[] = {1, -1, 0, 0};
    static int y[] = {0, 0, 1, -1};
    static int visited[][];

    static public int maxAreaOfIsland(int[][] grid) {
        int max = 0;

        visited = new int[grid.length][grid[0].length];

        for(int i =0; i<grid.length; i++) {
            for(int j =0; j<grid[0].length; j++) {
                if(visited[i][j] == 0 && grid[i][j] == 1){
                    visited[i][j] = 1;

                    int count = bfs(i, j, grid);

                    if(max < count) max = count;
                }
            }
        }

        return max;
    }


    static public int bfs(int startX, int startY, int[][] grid) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(startX, startY));

        int count = 0;

        while(!q.isEmpty()) {
            Point p = q.poll();

            int nowX = p.x;
            int nowY = p.y;

            for(int i =0; i<4; i++) {
                int nextX = nowX + x[i];
                int nextY = nowY + y[i];

                // 종료조건
                if(nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length) {
                    continue;
                }

                // 진입 가능 여부 체크
                if(visited[nextX][nextY] == 0 && grid[nextX][nextY] == 1) {
                    count++;
                    visited[nextX][nextY] = 1;

                    q.add(new Point(nextX, nextY));
                }
            }
        }

        return count;
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