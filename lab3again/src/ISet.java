public interface ISet
{
    int MAX_SIZE = 100;

    /**
     * Adds a value to the set.
     * @param val the value to be added to the set.
     * @pre [the set does not contain val]
     * @post [the set will have all the same values plus val on the end]
     */
    void add(Integer val);

    /**
     * Removes the value at the given position from the set and returns that value.
     * @param pos the position of the value to be removed.
     * @return the integer at the position given.
     * @pre [there is a value at position pos in the set]
     * @post [the value at position pos will have been removed from the set]
     */
    Integer removePos(int pos);

    /**
     * Checks if the given value is present in the set.
     * @param val the value being searched for in the set.
     * @return [true if val is in the set, and false otherwise.]
     */
    boolean contains(Integer val);

    /**
     * Returns the size of the set.
     * @return the size of the set.
     */
    int getSize();
}
