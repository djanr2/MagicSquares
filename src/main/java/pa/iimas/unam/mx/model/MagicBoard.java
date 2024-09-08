package pa.iimas.unam.mx.model;

import java.util.*;

public class MagicBoard {
    private int n;
    private int magicValue;
    private Cage board[][];
    private List<Integer> possibleValues;

    public MagicBoard(int n) {
        this.n = n;
        board = new Cage[n][n];

        this.magicValue = 0;
        this.possibleValues = new ArrayList<>();
        int index = 1;
        for (int y = 0; y < this.n; y++) {
            for (int x = 0; x < this.n; x++) {
                board[x][y] = new Cage();
                if (n - x == 1) {
                    board[x][y].setBoundaryX(true);
                }
                if (n - y == 1) {
                    board[x][y].setBoundaryY(true);
                }
                if (n - x == 1 && n - y == 1) {
                    board[x][y].setBoundaryXY(true);
                }
                if (n - y == 1 && x == 0) {
                    board[x][y].setBoundaryYX(true);
                }
                board[x][y].setX(x);
                board[x][y].setY(y);
                possibleValues.add(index);
                magicValue += index;
                index++;
            }
        }
        this.magicValue = magicValue / n;
    }

    @Override
    public String toString() {
        for (int y = 0; y < this.n; y++) {
            for (int x = 0; x < this.n; x++) {
                System.out.print(board[x][y] + "\t");
            }
            System.out.println();
        }
        return "";
    }

    public int getN() {
        return n;
    }

    public List<Integer> getPossibleValues() {
        return possibleValues;
    }

    public int getMagicValue() {
        return magicValue;
    }

    public Cage[][] getBoard() {
        return board;
    }

    public String printBoard(Cage board[][]) {
        return this.toString();
    }

    public Cage[][] cloneBoard(Cage[][] current){

        Cage[][] cloned = new Cage[current.length][current[0].length];

        for (int y = 0; y < current[0].length; y++) {
            for (int x = 0; x < current.length; x++) {
                cloned[x][y] = (Cage)current[x][y].clone();
            }
        }
        return cloned;
    }

    public List<Integer> clonePossibleValues(List<Integer> current){
        return new ArrayList<>(current);
    }
    public Cage getNext(Cage current){
        int x = current.getX();
        int y = current.getY();
        x++;

        if (x>=this.getN()){
            x=0;
            y++;
        }
        if (y>=this.getN()){
            return null;
        }
        return this.board[x][y];
    }
}
