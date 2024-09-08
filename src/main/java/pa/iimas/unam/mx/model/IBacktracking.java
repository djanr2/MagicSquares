package pa.iimas.unam.mx.model;

import java.util.List;

public interface IBacktracking {
    List<IBacktracking> getNodes();
    IBacktracking clone(IBacktracking curent);
}
