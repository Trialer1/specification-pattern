package de.boettcher.specification.api;

/**
 * Composite specification based on Martin Fowler (https://martinfowler.com/apsupp/spec.pdf).
 * @param <T> Type of the object which can be checked against the specification.
 */
public interface CompositeSpecification<T> extends Specification<T> {

    /**
     * Creates a new {@link CompositeSpecification} based on the current specification and the specified one.
     * @param specification Specification to add by using "AND". Must not be null.
     * @return New {@link CompositeSpecification} containing 2 {@link Specification}s combined by "AND"
     */
    public CompositeSpecification<T> and(Specification<T> specification);

    /**
     * Creates a new {@link CompositeSpecification} based on the current specification and the specified one.
     * @param specification Specification to add by using "OR". Must not be null.
     * @return New {@link CompositeSpecification} containing 2 {@link Specification}s combined by "OR"
     */
    public CompositeSpecification<T> or(Specification<T> specification);

    /**
     * Checks the specified object for {@link Specification}s which are not met and creates a new {@link CompositeSpecification} out of them.
     * @param t Object to check for satisfaction
     * @return New {@link CompositeSpecification} containing all {@link Specification}s which are not met
     */
    public CompositeSpecification<T> remainderUnsatisfiedBy(T t);

}
