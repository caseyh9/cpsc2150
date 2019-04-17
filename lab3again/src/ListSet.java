import java.util.List;
import java.util.ArrayList;

/**
 * @invariant 0 <= set.size() <= MAX_SIZE
 */
public class ListSet implements ISet
{
    private List<Integer> set;

    /**
     * Constructor for ListSet.
     * @post set.size() = 0
     */
    ListSet()
    {
        set = new ArrayList<>();
    }

    public void add(Integer val)
    {
        set.add(val);
    }

    public Integer removePos(int pos)
    {
        return set.remove(pos);
    }

    public boolean contains(Integer val)
    {
        return set.contains(val);
    }

    public int getSize()
    {
        return set.size();
    }

    /**
     * Builds a string of the given ListSet.
     * @return a string of the ListSet.
     * @post [no changes are made to set.]
     */
    public String toString()
    {
        String word = "";
        int i;
        for (i = 0; i < set.size(); i++)
        {
            word += set.get(i);
            word += ", ";
        }
        return word;
    }
}
