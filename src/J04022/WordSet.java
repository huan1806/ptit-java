package J04022;

import java.util.TreeSet;

public class WordSet extends TreeSet<String> {
    public WordSet() {
    }

    public WordSet(String s) {
        String[] words = s.trim().split("\\s+");
        for (String word : words) {
            add(word.toLowerCase());
        }
    }

    public WordSet union(WordSet other) {
        WordSet res = new WordSet();
        res.addAll(this);
        res.addAll(other);
        return res;
    }

    public WordSet intersection(WordSet other) {
        WordSet res = new WordSet();
        res.addAll(this);
        res.retainAll(other);
        return res;
    }


    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        for (String word : this) {
            ret.append(word).append(" ");
        }
        return ret.toString();
    }
}
