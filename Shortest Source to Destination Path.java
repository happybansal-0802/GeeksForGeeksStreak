class Solution {
    public int shortestDistance(int N, int M, int A[][], int X, int Y) {
        if (A[0][0] == 0) {
            return -1;
        }
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0});
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll(); 
            int x = cell[0]; 
            int y = cell[1]; 
            int steps = cell[2]; 
            if (x == X && y == Y) {
                return steps; 
            }
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1]; 
                if (newX >= 0 && newX < N && newY >= 0 && newY < M && A[newX][newY] == 1 && !visited[newX][newY]) {
                    queue.offer(new int[]{newX, newY, steps + 1}); 
                    visited[newX][newY] = true;
                }
            }
        }
        return -1;
    }
}
