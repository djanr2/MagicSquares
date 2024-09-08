package pa.iimas.unam.mx.model;

import java.util.ArrayList;
import java.util.List;

public class Cage extends NodeBacktracking {
    private int value;
    private boolean boundaryX;

    private boolean boundaryY;

    private boolean boundaryXY;

    private boolean boundaryYX;
    private int x;

    private int Y;

    public int getValue() {
        return value;
    }


    public String toString(){
        return "["+String.format("%02d", this.value)+"]";
    }

    public boolean isBoundary() {
        return this.boundaryX||this.boundaryY||this.boundaryXY||this.boundaryYX;
    }

    public void setBoundaryX(boolean boundaryX) {
        this.boundaryX = boundaryX;
    }

    public void setBoundaryY(boolean boundaryY) {
        this.boundaryY = boundaryY;
    }

    public void setBoundaryXY(boolean boundaryXY) {
        this.boundaryXY = boundaryXY;
    }

    public void setBoundaryYX(boolean boundaryYX) {
        this.boundaryYX = boundaryYX;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isBoundaryX() {
        return boundaryX;
    }

    public boolean isBoundaryY() {
        return boundaryY;
    }

    public boolean isBoundaryXY() {
        return boundaryXY;
    }

    public boolean isBoundaryYX() {
        return boundaryYX;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        Y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return Y;
    }


    @Override
    public List<IBacktracking> getNodes() {
        return this.nodes;
    }

    @Override
    public IBacktracking clone(IBacktracking current) {
        return clone((Cage)current);
    }

    private IBacktracking clone(Cage current){
        Cage cloned = new Cage();
        cloned.setValue(current.getValue());
        cloned.setBoundaryX(current.isBoundaryX());
        cloned.setBoundaryY(current.isBoundaryY());
        cloned.setBoundaryXY(current.isBoundaryXY());
        cloned.setBoundaryYX(current.isBoundaryYX());
        cloned.setX(current.getX());
        cloned.setY(current.getY());
        return cloned;
    }

    public IBacktracking clone(){
        return clone(this);
    }
    public List<IBacktracking> prepareNodes(List<Integer> posiblesValores, Cage nextNode) {
        this.nodes= new ArrayList<>();
        boolean firstElement =  true;
        for (Integer value: posiblesValores){
            if(firstElement){
                firstElement=!firstElement;
                this.setValue(value);
            }else{
                IBacktracking next = this.clone(nextNode);
                ((Cage)next).setValue(value);
                this.nodes.add(next);
            }
        }
       return this.nodes;
    }

}
