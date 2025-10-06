import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    static int[][] dir = {
        {2, 1}, {1, 2}, {-1, 2}, {-2, 1},
        {-2, -1}, {-1, -2}, {1, -2}, {2, -1}
    };

    static boolean knightTourUtil(int x, int y, int step, int n, ArrayList<ArrayList<Integer>> board) {
        if (step == n * n) return true;

        ArrayList<ArrayList<Integer>> moves = getSortedMoves(board, x, y);

        for (ArrayList<Integer> move : moves) {
            int dirIdx = move.get(1);
            int nx = x + dir[dirIdx][0];
            int ny = y + dir[dirIdx][1];

            board.get(nx).set(ny, step);
            if (knightTourUtil(nx, ny, step + 1, n, board))
                return true;

            board.get(nx).set(ny, -1);
        }
        return false;
    }

    static ArrayList<ArrayList<Integer>> getSortedMoves(ArrayList<ArrayList<Integer>> board, int x, int y) {
        ArrayList<ArrayList<Integer>> moveList = new ArrayList<>();
        int n = board.size();

        for (int i = 0; i < 8; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && board.get(nx).get(ny) == -1) {
                int options = countOptions(board, nx, ny);
                ArrayList<Integer> move = new ArrayList<>();
                move.add(options);
                move.add(i);
                moveList.add(move);
            }
        }

        Collections.sort(moveList, new Comparator<ArrayList<Integer>>() {
            public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
                if (!a.get(0).equals(b.get(0))) return a.get(0) - b.get(0);
                return a.get(1) - b.get(1);
            }
        });

        return moveList;
    }

    static int countOptions(ArrayList<ArrayList<Integer>> board, int x, int y) {
        int count = 0, n = board.size();
        for (int i = 0; i < 8; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && board.get(nx).get(ny) == -1)
                count++;
        }
        return count;
    }

    public ArrayList<ArrayList<Integer>> knightTour(int n) {
        ArrayList<ArrayList<Integer>> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>(Collections.nCopies(n, -1));
            board.add(row);
        }

        board.get(0).set(0, 0);
        if (knightTourUtil(0, 0, 1, n, board)) {
            return board;
        }

        return new ArrayList<>();
    }
}
