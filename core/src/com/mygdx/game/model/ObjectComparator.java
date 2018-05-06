package com.mygdx.game.model;

public class ObjectComparator implements java.util.Comparator<Sortable>{

    @Override
    public int compare(Sortable o1, Sortable o2) {
        if (o1.getWorldY() < o2.getWorldY()) {
            return -1;
        } else if (o1.getWorldY() > o2.getWorldY()) {
            return 1;
        }
        return 0;
    }
}
