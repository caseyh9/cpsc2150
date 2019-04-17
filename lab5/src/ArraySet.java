/**
 * @invariant 0 <= size <= MAX_SIZE
 * Correspondence size_of_set = size
 * Correspondence this = set
 */
public class ArraySet<type> extends SetAbs<type>
{
    private type[] set;
    private int size;

    /**
     * Constructor for ArraySet.
     * @post size = 0
     */
    ArraySet()
    {
        set = (type[]) new Object[MAX_SIZE];
        size = 0;
    }

    public void add(type val)
    {
        set[size] = val;
        size++;
    }

    public type removePos(int pos)
    {
        type val = set[pos];
        size--;
        set[pos] = set[size];
        return val;
    }

    public boolean contains(type val)
    {
        int i;
        for (i = 0; i < size; i++)
            if (val.equals(set[i]))
                return true;
        return false;
    }

    public int getSize()
    {
        return size;
    }
}
