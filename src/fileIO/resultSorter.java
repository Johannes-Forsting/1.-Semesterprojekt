package fileIO;

import java.util.Comparator;

public class resultSorter implements Comparator<ResultObject> {

    @Override
    public int compare(ResultObject o1, ResultObject o2) {
        return o2.getResult().compareTo(o1.getResult());
    }
}
