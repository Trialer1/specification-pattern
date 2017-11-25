package de.boettcher.specification.impl;

// TODO comment and check how to use it
public class AlwaysFalseSpecification<T> extends BasicCompositeSpecification<T> {

    public AlwaysFalseSpecification() {
        super(t -> false);
    }

}
