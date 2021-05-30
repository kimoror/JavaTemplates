package mirea.danila.pracitce3;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;

@SuppressWarnings("rawtypes")
public class MySet<S> implements Set {

    Set<Object> mySet = new HashSet<>();

    Semaphore sem = new Semaphore(1);

    public MySet() {
        mySet = new HashSet<>();
        sem = new Semaphore(1);
    }

    @Override
    public int size() {
        int size = 0;
        try {
            sem.acquire();
            size = mySet.size();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            sem.release();
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        boolean isEmpty = false;
        try {
            sem.acquire();
            isEmpty = mySet.isEmpty();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            sem.release();
        }
        return mySet.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        boolean contains = false;
        try {
            sem.acquire();
            contains = mySet.contains(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            sem.release();
        }
        return contains;
    }

    @Override
    public Iterator iterator() {
        Iterator it = null;
        try {
            sem.acquire();
            it = mySet.iterator();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            sem.release();
        }
        return it;
    }

    //TODO improve
    @Override
    public Object[] toArray() {
        Object[] objects = new Object[mySet.size()];
        try {
            sem.acquire();
            objects = mySet.toArray();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            sem.release();
        }
        return objects;
    }

    @Override
    public boolean add(Object o) {
        boolean add = false;
        try {
            sem.acquire();
            add = mySet.add(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            sem.release();
        }
        return add;
    }

    @Override
    public boolean remove(Object o) {
        boolean remove = false;
        try {
            sem.acquire();
            remove = mySet.remove(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            sem.release();
        }
        return remove;
    }

    @Override
    public boolean addAll(Collection c) {
        boolean addAll = false;
        try {
            sem.acquire();
            addAll = mySet.remove(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            sem.release();
        }
        return addAll;
    }

    @Override
    public void clear() {
        try {
            sem.acquire();
            mySet.clear();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            sem.release();
        }
    }

    @Override
    public boolean removeAll(Collection c) {
        boolean removeAll = false;
        try {
            sem.acquire();
            removeAll = mySet.remove(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            sem.release();
        }
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        boolean retainAll = false;
        try {
            sem.acquire();
            retainAll = mySet.retainAll(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            sem.release();
        }
        return retainAll;
    }

    @Override
    public boolean containsAll(Collection c) {
        boolean containsAll = false;
        try {
            sem.acquire();
            containsAll = mySet.remove(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            sem.release();
        }
        return containsAll;
    }

    @Override
    public Object[] toArray(Object[] a) {
        Object[] objects = new Object[mySet.size()];
        try {
            sem.acquire();
            objects = mySet.toArray(a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            sem.release();
        }
        return objects;
    }
}
