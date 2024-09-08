package pa.iimas.unam.mx;

import pa.iimas.unam.mx.model.Cage;
import pa.iimas.unam.mx.model.MagicBoard;

import java.util.List;

public class Backtracking {

    private MagicBoard mb;

    public Backtracking(MagicBoard mb) {
        this.mb = mb;
    }

    private boolean wait;

    public void backtrack(Cage current, List<Integer> possibleValues, Cage[][] currentBoard){

        List<Integer> clonedPossibleValues = mb.clonePossibleValues(possibleValues);

        for (Integer possibleValue: possibleValues){

            current.prepareNodes(clonedPossibleValues, mb.getNext(current));
            currentBoard[current.getX()][current.getY()].setValue(current.getValue());

            if(evalue(current, mb.cloneBoard(currentBoard))){

                clonedPossibleValues.remove(possibleValue);

                backtrack(mb.getNext(current),mb.clonePossibleValues(clonedPossibleValues), mb.cloneBoard(currentBoard));

                clonedPossibleValues.add(possibleValue);
            }else {

                clonedPossibleValues.remove(possibleValue);

                clonedPossibleValues.add(possibleValue);
            }
        }
    }

    private boolean evalue(Cage current, Cage[][] currentBoard){
        if(current.isBoundaryX()){
            if(!isMagicRow(current,currentBoard)){
                return false;
            }
        }if(current.isBoundaryY()){
            if (!isMagicColumn(current,currentBoard)){
                return false;
            }
        }
        if(current.isBoundaryYX()){
            if(!isMagicSecondaryDiagonal(current,currentBoard)){
                return false;
            }
        }if(current.isBoundaryXY()){
            if(!isMagicPrimaryDiagonal(current,currentBoard)){
                return false;
            }else{
                System.out.println("------------------------------");
                mb.printBoard(currentBoard);
                if(wait){
                    Cage.click();
                }
                return true;
            }

        }
        return true;
    }

    private boolean isMagicRow(Cage current,  Cage[][] currentBoard){
        int y = current.getY();
        int aux=0;
        for (int x=0;x<mb.getN();x++){
            aux+=currentBoard[x][y].getValue();
        }
        return (aux==mb.getMagicValue());
    }

    private boolean isMagicColumn(Cage current,  Cage[][] currentBoard){
        int x = current.getX();
        int aux=0;
        for (int y=0;y<mb.getN();y++){
            aux+=currentBoard[x][y].getValue();
        }
        return (aux==mb.getMagicValue());
    }

    private boolean isMagicPrimaryDiagonal(Cage current,  Cage[][] currentBoard){
        int aux = 0;
        for (int xy= 0; xy<mb.getN();xy++){
            aux+=currentBoard[xy][xy].getValue();
        }
        return (aux==mb.getMagicValue());
    }

    private boolean isMagicSecondaryDiagonal(Cage current,  Cage[][] currentBoard){
        int aux = 0;
        for (int yx= 0; yx<mb.getN();yx++){
            aux+=currentBoard[mb.getN()-1-yx][yx].getValue();
        }
        return (aux==mb.getMagicValue());
    }

    public void setWait(boolean wait) {
        this.wait = wait;
    }
}
