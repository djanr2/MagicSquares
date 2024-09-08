package pa.iimas.unam.mx.model;

import java.io.IOException;
import java.util.List;

public abstract class NodeBacktracking implements IBacktracking {

    protected List<IBacktracking> nodes;

    public static void click(){
        try{
            System.in.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
