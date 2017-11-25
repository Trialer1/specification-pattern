package de.boettcher.specification.impl;

import de.boettcher.specification.api.Specification;

/**
 * {@link BasicCompositeSpecification} which negates the provided {@link Specification}.
 */
public class NotSpecification<T> extends BasicCompositeSpecification<T> {

    public NotSpecification(final Specification<T> specification) {
        super(specification);
    }

    @Override
    public boolean isSatisfiedBy(final T t) {
        return !super.isSatisfiedBy(t);
    }

}
