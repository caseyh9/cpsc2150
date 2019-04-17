package cpsc2150.sets;

public abstract class SetAbs<type> implements ISet<type> {
    public abstract void add(type val);
    public abstract type removePos(int pos);
    public abstract boolean contains(type val);
    public abstract int getSize();

    /**
     * Builds a string of the given Set.
     * @return a string of the Set.
     * @post [no changes are made to set.]
     */
    public String toString()
    {
        String word = "";
        int i;
        type val;
        // Start at the end of the set and work back
        for (i = getSize()-1; i >= 0; i--)
        {
            // Get the value by removing it from the set
            val = this.removePos(i);
            // Add the value back to the set
            this.add(val);
            // Add the value to the word
            word += val;
            word += ", ";
        }
        return word;
    }

    /**
     * Check if 2 sets are equal.
     * @param o the second set which will be compared to the first set, this.
     * @return true iff the sets have exactly the same elements, false otherwise
     * @post equals = true [iff this = o]
     *       equals = false [iff this != o]
     */
    public boolean equals(Object o){
        if (o instanceof ISet) {
            ISet<type> temp = (ISet<type>) o;
            // First check that the sets have the same size
            if (this.getSize() != temp.getSize()){
                return false;
            }
            // If they are the same size, check that they have all the same elements
            int i;
            type val;
            for (i = this.getSize() - 1; i >= 0; i--) {
                val = this.removePos(i);
                this.add(val);
                if (!temp.contains(val)) {
                    return false;
                }
            }
            // If no counterexamples are found, the sets are equal
            return true;
        }
        // If we are not comparing to a set, return false
        else {
            return false;
        }
    }
}
