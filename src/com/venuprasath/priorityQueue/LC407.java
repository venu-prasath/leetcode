package com.venuprasath.priorityQueue;

import java.util.PriorityQueue;

import static com.venuprasath.util.Extension.println;

public class LC407 {

    public static void main(String[] args) {
        int[][] heightMap = { {3, 3, 3, 3, 3}, {3, 2, 2, 2, 3}, {3, 2, 1, 2, 3}, {3, 2, 2, 2, 3}, {3, 3, 3, 3, 3}};
        int volume = trapRainWater(heightMap);
        println(volume);
    }

    public static int trapRainWater(int[][] heightMap) {
        if(heightMap.length < 1) return 0;
        int m = heightMap.length;
        int n = heightMap[0].length;
        PriorityQueue<Cell> heap = new PriorityQueue<>();
        boolean[][] visited = new boolean[m][n];
        int result = 0;

        for(int i=0; i<m; i++) {
            visited[i][0] = true;
            heap.offer(new Cell(i, 0, heightMap[i][0]));
            visited[i][n-1] = true;
            heap.offer(new Cell(i, n-1, heightMap[i][n-1]));
        }
        for(int i=0; i<n; i++) {
            visited[0][i] = true;
            heap.offer(new Cell(0, i, heightMap[0][i]));
            visited[m-1][i] = true;
            heap.offer(new Cell(m-1, i, heightMap[m-1][i]));
        }
        while(!heap.isEmpty()) {
            Cell curr = heap.poll();
            int row = curr.row;
            int col = curr.col;
            int ht = curr.height;

            for(int[] d: dirs) {
                int r = d[0] + row;
                int c = d[1] + col;

                if(r > 0 && r < m-1 && c > 0 && c < n-1 && !visited[r][c]) {
                    visited[r][c] = true;

                    result += Math.max(0, ht - heightMap[r][c]);
                    heap.offer(new Cell(r, c, Math.max(ht, heightMap[r][c])));
                }
            }
        }
        return result;
    }

    static int[][] dirs = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };

    static class Cell implements Comparable<Cell> {
        int row;
        int col;
        int height;

        public Cell(int r, int c, int h) {
            this.row = r;
            this.col = c;
            this.height = h;
        }

        @Override
        public int compareTo(Cell otherCell) {
            if(this.height == otherCell.height) return 0;
            if(this.height < otherCell.height) return -1;
            return 1;
        }
    }
}
