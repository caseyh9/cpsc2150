import java.util.List;
import java.util.ArrayList;

/**
 * @invariant 0 <= set.size() <= MAX_SIZE
 * Correspondence size_of_set = set.size()
 * Correspondence this = set
 */
public class ListSet<type> extends SetAbs<type>
{
    private List<type> set;

    /**
     * Constructor for ListSet.
     * @post set.size() = 0
     */
    ListSet()
    {
        set = new ArrayList<>();
    }

    public void add(type val)
    {
        set.add(val);
    }

    public type removePos(int pos)
    {
        return set.remove(pos);
    }

    public boolean contains(type val)
    {
        return set.contains(val);
    }

    public int getSize()
    {
        return set.size();
    }
}
