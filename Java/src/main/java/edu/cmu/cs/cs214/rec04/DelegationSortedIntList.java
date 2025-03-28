package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class DelegationSortedIntList implements IntegerList{
    // Write your implementation below with API documentation
    private final SortedIntList list = new SortedIntList();
    private int totalAdded = 0;

    @Override
    public boolean add(int value) {
        totalAdded++;
        return list.add(value);
    }

    @Override
    public boolean addAll(IntegerList other) {
        for (int i = 0; i < other.size(); i++) {
            add(other.get(i)); 
        }
        return true;
    }

    @Override
    public boolean remove(int value) {
        return list.remove(value);
    }

    @Override
    public boolean removeAll(IntegerList other) {
        boolean changed = false;
        for (int i = 0; i < other.size(); i++) {
            changed |= remove(other.get(i));
        }
        return changed;
    }

    @Override
    public int get(int index) {
        return list.get(index);
    }

    @Override
    public int size() {
        return list.size();
    }

    public int getTotalAdded() {
        return totalAdded;
    }

}