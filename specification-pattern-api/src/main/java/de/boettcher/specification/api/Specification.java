package de.boettcher.specification.api;

/**
 * Generic specification based on Martin Fowler (https://martinfowler.com/apsupp/spec.pdf).
 * @param <T> Type of the object which can be checked against the specification.
 */
@FunctionalInterface
public interface Specification<T> {

    /**
     * Checks if the specification is satisfied by the specified object.
     * @param t Object to check for satisfaction
     * @return True if the specification is satisfied false if not.
     */
    public boolean isSatisfiedBy(T t);

}
