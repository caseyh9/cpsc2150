/**
 ISet represents a single set of integers--and unordered collection of objects
 (in this case integers) that cannot have repeated values. Indexing starts at 0.
 Initialization ensures: the set is empty and has size 0.
 Defines:   size_of_set: Z
 Constraints:   0 <= size_of_set <= MAX_SIZE
 */
public interface ISet<type>
{
    int MAX_SIZE = 100;

    /**
     * Adds a value to the set.
     * @param val the value to be added to the set.
     * @pre [the set does not contain val]
     * @post [the set will have all the same values plus val on the end]
     */
    void add(type val);

    /**
     * Removes the value at the given position from the set and returns that value.
     * @param pos the position of the value to be removed.
     * @return the integer at the position given.
     * @pre [there is a value at position pos in the set]
     * size > 0
     * @post [the value at position pos will have been removed from the set]
     * size = #size - 1
     */
    type removePos(int pos);

    /**
     * Checks if the given value is present in the set.
     * @param val the value being searched for in the set.
     * @return [true if val is in the set, and false otherwise.]
     */
    boolean contains(type val);

    /**
     * Returns the size of the set.
     * @return the size of the set.
     */
    int getSize();

    /**
     * Changes the current set (this) to be the union of this and unionWith
     * @param unionWith the set to union with this set
     * @post union = this (union symbol) unionWith
     */
    default void union(ISet unionWith){
        int i;
        type val;
        // Iterate through all values in the set you are adding
        for (i = unionWith.getSize()-1; i >= 0; i--){
            // Remove each value
            val = (type) unionWith.removePos(i);
            // Check if this set already has the value, add it if not
            if (!this.contains(val)){
                this.add(val);
            }
            // Add the value back to the end
            unionWith.add(val);
        }
    }

    /**
     * Changes the current set (this) to the intersection of this and intWith
     * @param intWith
     * @post intersect = this (intersection symbol) intWith
     */
    default void intersect(ISet intWith){
        int i;
        type val;
        // Iterate through all values in the set this
        for (i = this.getSize()-1; i >= 0; i--){
            // Remove the first value
            val = this.removePos(i);
            // If val is also in the intWith set, add it back to this
            if (intWith.contains(val)) {
                this.add(val);
            }
        }
    }

    /**
     * Changes the current set (this) to the difference of this and diffWith
     * @param diffWith the set being subtracted from this
     * @post difference = this - diffWith
     */
    default void difference(ISet diffWith){
        int i;
        type val;
        // Iterate through all values in this
        for (i = this.getSize()-1; i >= 0; i--){
            // Remove the first value
            val = this.removePos(i);
            // If val is not in diffWith, add it back to this
            if (!diffWith.contains(val)) {
                this.add(val);
            }
        }
    }
}
