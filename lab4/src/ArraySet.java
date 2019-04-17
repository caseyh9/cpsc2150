/**
 * @invariant 0 <= size <= MAX_SIZE
 * Correspondence size_of_set = size
 * Correspondence this = set
 */
public class ArraySet implements ISet
{
    private Integer[] set;
    private int size;

    /**
     * Constructor for ArraySet.
     * @post size = 0
     */
    ArraySet()
    {
        set = new Integer[MAX_SIZE];
        size = 0;
    }

    public void add(Integer val)
    {
        set[size] = val;
        size++;
    }

    public Integer removePos(int pos)
    {
        int val = set[pos];
        size--;
        set[pos] = set[size];
        return val;
    }

    public boolean contains(Integer val)
    {
        int i;
        for (i = 0; i < size; i++)
            if (val == set[i])
                return true;
        return false;
    }

    public int getSize()
    {
        return size;
    }

    /**
     * Builds a string of the given ListSet.
     * @return a string of the ArraySet.
     * @post [no changes are made to set.]
     */
    public String toString()
    {
        String word = "";
        int i;
        for (i = 0; i < size; i++)
        {
            word += set[i];
            word += ", ";
        }
        return word;
    }
}
