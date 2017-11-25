package de.boettcher.specification.impl;

// TODO comment and check how to use it
public class AlwaysTrueSpecification<T> extends BasicCompositeSpecification<T> {

    public AlwaysTrueSpecification() {
        super(t -> true);
    }

}
