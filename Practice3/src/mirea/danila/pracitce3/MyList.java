package mirea.danila.pracitce3;

import java.util.*;


public class MyList implements List {
    List<Object> list;

    public MyList() {
        list = new ArrayList<>();
    }

    @Override
    public synchronized int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public synchronized boolean contains(Object o) {
        return list.contains(o);
    }

    @Override
    public synchronized Iterator iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public synchronized boolean add(Object o) {
        return list.add(o);
    }

    @Override
    public synchronized boolean remove(Object o) {
        return list.remove(o);
    }

    @Override
    public synchronized boolean addAll(Collection c) {
        return list.addAll(c);
    }

    @Override
    public synchronized boolean addAll(int index, Collection c) {
        return list.addAll(c);
    }

    @Override
    public synchronized void clear() {
        list.clear();
    }

    @Override
    public synchronized Object get(int index) {
        return list.get(index);
    }

    @Override
    public synchronized Object set(int index, Object element) {
        return null;
    }

    @Override
    public synchronized void add(int index, Object element) {
        list.add(index, element);
    }

    @Override
    public synchronized Object remove(int index) {
        return list.remove(index);
    }

    @Override
    public synchronized int indexOf(Object o) {
        return list.indexOf(o);
    }

    @Override
    public synchronized int lastIndexOf(Object o) {
        return list.lastIndexOf(o);
    }

    @Override
    public synchronized ListIterator listIterator() {
        return list.listIterator();
    }

    @Override
    public synchronized ListIterator listIterator(int index) {
        return list.listIterator(index);
    }

    @Override
    public synchronized List subList(int fromIndex, int toIndex) {
        return list.subList(fromIndex, toIndex);
    }

    @Override
    public synchronized boolean retainAll(Collection c) {
        return list.retainAll(c);
    }

    @Override
    public synchronized boolean removeAll(Collection c) {
        return list.removeAll(c);
    }

    @Override
    public synchronized boolean containsAll(Collection c) {
        return list.containsAll(c);
    }

    @Override
    public synchronized Object[] toArray(Object[] a) {
        return list.toArray();
    }
}
