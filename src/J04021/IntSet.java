package J04021;

import java.util.TreeSet;

public class IntSet extends TreeSet<Integer> {

    public IntSet() {
    }

    public IntSet(int[] a) {
        for (int j : a) {
            add(j);
        }
    }

    public IntSet union(IntSet s2) {
        IntSet ret = new IntSet();
        ret.addAll(this);
        ret.addAll(s2);
        return ret;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        for (Integer num : this) {
            ret.append(num).append(" ");
        }
        return ret.toString();
    }
}
