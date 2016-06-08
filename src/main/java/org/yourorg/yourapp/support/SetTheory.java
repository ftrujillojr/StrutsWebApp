package org.yourorg.yourapp.support;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * <pre>
 * I needed a Generic way to determine to compare lists and arrays.
 * Set Theory lends itself quite nicely for this task.
 *
 * I am also using a Collection from Java =&gt; Set class to do the major
 * lifting for me.
 *
 * http://en.wikipedia.org/wiki/Set_theory
 *
 * http://docs.oracle.com/javase/7/docs/api/java/util/Set.html
 *
 * -----------------------------------------------
 *
 * List A               [0, 2, 4, 6, 8, 10]
 * List B               [5, 6, 7, 8, 9, 10]
 *
 * UNION                [0, 2, 4, 5, 6, 7, 8, 9, 10]
 * INTERSECT            [6, 8, 10]
 * DIFF                 [0, 2, 4]
 * Relative COMPLIMENT  [5, 7, 9]
 * Symmetric DIFF       [0, 2, 4, 5, 7, 9]
 *
 * -----------------------------------------------
 *
 * List A               [cat, dog, house, pig]
 * List B               [chicken, cow, dog, horse, pig]
 *
 * UNION                [cat, chicken, cow, dog, horse, house, pig]
 * INTERSECT            [dog, pig]
 * DIFF                 [cat, house]
 * Relative COMPLIMENT  [chicken, cow, horse]
 * Symmetric DIFF       [cat, chicken, cow, horse, house]
 *
 * T is a wrapper class =&gt; String, Integer, Double, Character, Float, Long,
 * Short, Byte
 * </pre>
 *
 * @param <T>  //
 *
 */
public final class SetTheory<T> {

    private Set<T> setA;
    private Set<T> setB;
    private Set<T> resultList;

    public SetTheory() {
        this.resultList = new TreeSet<>();
        this.setA = new TreeSet<>();
        this.setB = new TreeSet<>();
    }

    public SetTheory(T[] arrayA, T[] arrayB) {
        this.resultList = new TreeSet<>();
        this.setA = new TreeSet<>(Arrays.asList(arrayA));
        this.setB = new TreeSet<>(Arrays.asList(arrayB));
    }

    public SetTheory(List<T> listA, List<T> listB) {
        this.resultList = new TreeSet<>();
        this.setA = new TreeSet<>(listA);
        this.setB = new TreeSet<>(listB);
    }

    public SetTheory(Set<T> setA, Set<T> setB) {
        this.resultList = new TreeSet<>();
        this.setA = new TreeSet<>(setA);
        this.setB = new TreeSet<>(setB);
    }

    public boolean addItemSetA(T item) {
        boolean result = this.setA.add(item);
        return result;
    }
    
    public boolean addItemSetB(T item) {
        boolean result = this.setB.add(item);
        return result;
    }
    
    public boolean delItemSetA(T item) {
        boolean result = this.setA.remove(item);
        return result;
    }
    
    public boolean delItemSetB(T item) {
        boolean result = this.setB.remove(item);
        return result;
    }
    
    public Set<T> getSetA() {
        return this.setA;
    }

    public Set<T> getSetB() {
        return this.setB;
    }

    public Set<T> getResultList() {
        return this.resultList;
    }

    public final void setSetA(T[] arrayA) {
        this.setA = new TreeSet<>(Arrays.asList(arrayA));
    }
    
    public final void setSetA(List<T> listA) {
        this.setA = new TreeSet<>(listA);
    }
    
    public final void setSetA(Set<T> setA) {
        this.setA = new TreeSet<>(setA);
    }

    public final void setSetB(T[] arrayB) {
        this.setB = new TreeSet<>(Arrays.asList(arrayB));
    }
    
    public final void setSetB(List<T> listB) {
        this.setB = new TreeSet<>(listB);
    }
    
    public final void setSetB(Set<T> setB) {
        this.setB = new TreeSet<>(setB);
    }

    public boolean isContainedInSetA(T item) {
        @SuppressWarnings("UnusedAssignment")
        Boolean result = false;
        result = this.setA.contains(item);
        return result;
    }
    
    public boolean isContainedInSetB(T item) {
        @SuppressWarnings("UnusedAssignment")
        Boolean result = false;
        result = this.setB.contains(item);
        return result;
    }

    /**
     * <pre>
     * Union of the sets A and B is the set of all objects
     * that are a member of A, or B, or both.
     *
     *                  A             B                   Result
     * The union of {1, 2, 3} and {2, 3, 4} is the set {1, 2, 3, 4} .
     * </pre>
     *
     * @return Set&lt;T&gt;
     */
    public Set<T> union() {
        this.resultList = new TreeSet<>(this.setA);
        this.resultList.addAll(this.setB);
        return (this.resultList);
    }

    /**
     * <pre>
     * Intersection of the sets A and B  is the set of all
     * objects that are members of both A and B.
     *
     *                         A             B                Result
     * The intersection of {1, 2, 3} and {2, 3, 4} is the set {2, 3}
     * </pre>
     *
     * @return Set&lt;T&gt; //
     */
    public Set<T> intersect() {
        this.resultList = new TreeSet<>(this.setA);
        this.resultList.retainAll(this.setB);
        return (this.resultList);
    }

    /**
     * <pre>
     * Difference is NOT commutative !!!! A-B != B-A
     *
     * Set A =&gt; 0, 2, 4, 6, 8, 10
     *
     * Set B =&gt; 5, 6, 7, 8, 9, 10
     *
     * DIFF (elements of A not in B) =&gt; 0, 2, 4
     * </pre>
     *
     * @return Set&lt;T&gt;  //
     */
    public Set<T> diff() {
        this.resultList = new TreeSet<>(this.setA);
        this.resultList.removeAll(this.setB);
        return (this.resultList);
    }

    /**
     * <pre>
     * If A and B are sets, then the relative complement of A in B is the set
     * of elements in B, but not in A.
     *
     * Set A =&gt; 0, 2, 4, 6, 8, 10
     *
     * Set B =&gt; 5, 6, 7, 8, 9, 10
     *
     * RELATIVE COMPLIMENT (elements of B not in A) =&gt; 5, 7, 9
     * </pre>
     *
     * @return Set&lt;T&gt;  //
     */
    public Set<T> relativeCompliment() {
        this.resultList = new TreeSet<>(this.setB);
        this.resultList.removeAll(this.setA);
        return (this.resultList);
    }

    /**
     * <pre>
     * The symmetric difference of two sets is the set of elements which are
     * in either of the sets and not in their intersection.
     *
     * For example, the symmetric difference of the sets
     * {1,2,3} and {3,4} is {1,2,4}.
     * </pre>
     *
     * @return Set&lt;T&gt;   //
     */
    public Set<T> symmetricDiff() {
        Set<T> leftHandSide = new TreeSet<>(this.setA);
        leftHandSide.removeAll(this.setB);

        Set<T> rightHandSide = new TreeSet<>(this.setB);
        rightHandSide.removeAll(this.setA);

        // Combine the two diffs.
        this.resultList = new TreeSet<>(leftHandSide);
        this.resultList.addAll(rightHandSide);

        return (this.resultList);
    }
}
