package info.kendall_morwick.relation;

import java.util.function.Function;
import java.util.function.Predicate;

@FunctionalInterface
public interface Relation<T> extends Predicate<T>, Function<T,Boolean> {
	
	public default Boolean apply(T arg) {
		return test(arg);
	}
	
}
