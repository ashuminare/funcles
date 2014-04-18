/* Copyright 2011-2013 Joseph Kendall-Morwick

     This file is part of the Funcles library.

    Funcles is free software: you can redistribute it and/or modify
    it under the terms of the Lesser GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Funcles is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    Lesser GNU General Public License for more details.

    You should have received a copy of the Lesser GNU General Public License
    along with Funcles.  If not, see <http://www.gnu.org/licenses/>.

 */

package info.km.funcles;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.cache.Cache;

import static info.km.funcles.Tuple.makeTuple;

//TODO: determine if more "filter" methods should be added, specifically along the lines of 
//iterators/collections and lazily filtering as you iterate

/** A utility class which add useful functionality to existing guava Function 
 * implementations
 * 
 * @author Joseph Kendall-Morwick <jmorwick@indiana.edu>
 * @version 1.0.0
 *
 */
public class Funcles {

	/** a simple way to call apply for a function with 2 arguments 
	 * 
	 * @param f
	 * @param arg1
	 * @param arg2
	 * @return
	 */
	public static <F1,F2,T> T apply(Function<T2<F1,F2>,T> f, F1 arg1, 
			F2 arg2) {
		return f.apply(makeTuple(arg1, arg2));
	}
	
	/** a simple way to call apply for a function with 3 arguments 
	 * 
	 * @param f
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 * @return
	 */
	public static <F1,F2,F3,T> T apply(Function<T3<F1,F2,F3>,T> f, F1 arg1, 
			F2 arg2, F3 arg3) {
		return f.apply(makeTuple(arg1, arg2, arg3));
	}

	/** a simple way to call apply for a function with 4 arguments 
	 * 
	 * @param f
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 * @param arg4
	 * @return
	 */
	public static <F1,F2,F3,F4,T> T apply(Function<T4<F1,F2,F3,F4>,T> f, 
			F1 arg1, F2 arg2, F3 arg3, F4 arg4) {
		return f.apply(makeTuple(arg1, arg2, arg3, arg4));
	}

	/** a simple way to call apply for a function with 5 arguments
	 * 
	 * @param f
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 * @param arg4
	 * @return
	 */
	public static <F1,F2,F3,F4,F5,T> T apply(Function<T5<F1,F2,F3,F4,F5>,T> f, 
			F1 arg1, F2 arg2, F3 arg3, F4 arg4, F5 arg5) {
		return f.apply(makeTuple(arg1, arg2, arg3, arg4, arg5));
	}
	
	/** a simple way to call apply for a relation with 2 arguments
	 * 
	 * @param f
	 * @param arg1
	 * @param arg2
	 * @return
	 */
	public static <F,T> boolean apply(BinaryRelation<F> r, F arg1, F arg2) {
		return r.apply(makeTuple(arg1, arg2));
	}
	
	/** a simple way to call apply for a relation with 3 arguments
	 * 
	 * @param f
	 * @param arg1
	 * @param arg2
	 * @return
	 */
	public static <F,T> boolean apply(TernaryRelation<F> r, F arg1, F arg2, 
			F arg3) {
		return r.apply(makeTuple(arg1, arg2, arg3));
	}
	
	
	/** runs a function in the background 
	 * provides an interface (ProcessingThread) for monitoring the function's
	 * execution and retrieving the result.  
	 * 
	 * @param f
	 * @param input
	 * @return
	 */
	public static <F,T> FunctionThread<F,T> 
		applyInBackground(final Function<F,T> f, F input) {
		return new FunctionThread<F,T>(f, input);
	}

	public static <F1,F2,T> FunctionThread<T2<F1,F2>,T>
			applyInBackground(Function<T2<F1,F2>,T> f, F1 arg1, F2 arg2) {
		return new FunctionThread<T2<F1,F2>,T>(f, 
				makeTuple(arg1, arg2));
	}

	public static <F1,F2,F3,T> FunctionThread<T3<F1,F2,F3>,T>
			applyInBackground(Function<T3<F1,F2,F3>,T> f, F1 arg1, 
					F2 arg2, F3 arg3) {
		return new FunctionThread<T3<F1,F2,F3>,T>(f, 
				makeTuple(arg1, arg2, arg3));
	}

	public static <F1,F2,F3,F4,T> FunctionThread<T4<F1,F2,F3,F4>,T>
			applyInBackground(Function<T4<F1,F2,F3,F4>,T> f, F1 arg1, F2 arg2, 
					F3 arg3, F4 arg4) {
		return new FunctionThread<T4<F1,F2,F3,F4>,T>(f, 
				makeTuple(arg1, arg2, arg3, arg4));
	}

	public static <F1,F2,F3,F4,F5,T> FunctionThread<T5<F1,F2,F3,F4,F5>,T>
			applyInBackground(Function<T5<F1,F2,F3,F4,F5>,T> f, F1 arg1, 
					F2 arg2, F3 arg3, F4 arg4, F5 arg5) {
		return new FunctionThread<T5<F1,F2,F3,F4,F5>,T>(f, 
				makeTuple(arg1, arg2, arg3, arg4, arg5));
	}

	public static <F> FunctionThread<T2<F,F>,Boolean> 
			applyInBackground(final BinaryRelation<F> r, F arg1, F arg2) {
		Function<T2<F,F>,Boolean> f;
		f = new Function<T2<F,F>,Boolean>() {
			public Boolean apply(T2<F,F> input) {
				return r.apply(input);
			}
		};
		return new FunctionThread<T2<F,F>,Boolean>(f, makeTuple(arg1, arg2));
	}

	public static <F> FunctionThread<T3<F,F,F>,Boolean> 
			applyInBackground(final TernaryRelation<F> r, F arg1, F arg2, 
					F arg3) {
		Function<T3<F,F,F>,Boolean> f;
		f = new Function<T3<F,F,F>,Boolean>() {
			public Boolean apply(T3<F,F,F> input) {
				return r.apply(input);
			}
		};
		return new FunctionThread<T3<F,F,F>,Boolean>(f, 
				makeTuple(arg1, arg2, arg3));
	}

	/** modifies a function to cache its results
	 * 
	 * @param f
	 * @param cache
	 * @return
	 */
	public static <F,T> Function<F,T> memoizerize(final Function<F,T> f, 
			final Cache<F,T> cache) {
		return new Function<F,T>() {
			public T apply(final F input) {
				T result = cache.getIfPresent(input);
				if(result == null) {
					result = f.apply(input);
					cache.put(input, result);
				}
				return result;
			}
		};
	}
	
	/** modifies a function to time results using the provided FunctionTimer
	 * 
	 * @param f
	 * @param t
	 * @return
	 */
	public static <F,T> Function<F,T> timerize(final Function<F,T> f, 
			final FunctionTimer t) {
		return new Function<F,T>() {
			public T apply(final F input) {
				t.start();
				T result = f.apply(input);
				t.stop();
				return result;
			}
		};
	}
	
	


    /** returns the argument which maximizes this function
     *
     * @param inputs all arguments to be evaluated with this function
     * @return the argument from 'inputs' maximizing this function
     */
    public static <F, T extends Comparable<T>> F argmax(Function<F,T> f, 
    		F ... inputs) {
        List<F> ls = new ArrayList<F>();
        for(F i : inputs) ls.add(i);
        return argmaxCollection(f, ls);
    }

    /** returns the argument from the collection which maximizes the function f
     *
     * @param inputs all arguments to be evaluated with this function
     * @return the argument from 'inputs' maximizing this function
     */
    public static <F,T extends Comparable<T>> F argmaxCollection(Function<F,T> f, 
    		Collection<F> inputs) {
        T max = null;
        F maxarg = null;
        try { 
        	for(F input : inputs) {
                T cur = f.apply(input);
                if(max == null || cur.compareTo(max) > 0) {
                    max = cur;
                    maxarg = input;
                }
            }
            return maxarg;
        } catch(ClassCastException e) {
            throw new RuntimeException(
            		"Argmax called on a funnction without comparable output");
        }

    }


    
    /** partitions the set s according to the relation r.
     *  this method assumes r is an equivalence relation.
     * @param s
     * @return a set of the partitions formed from the set s
     */
    public static <T> Set<Set<T>> partition(BinaryRelation<T> r, Set<T> s) {
    	Set<Set<T>> sets = new HashSet<Set<T>>();
    	for(T x : s) {
    		for(Set<T> p : sets) {
    			if(apply(r, x, p.iterator().next())) {
    				p.add(x); //found a compatible partition
    				break; //don't add a new partition later
    			}
    		}
    		// no compatible partition found, add a new one
    		Set<T> p = new HashSet<T>();
    		p.add(x);
    		sets.add(p);
    	}
    	return sets;
    }
    
   
}
