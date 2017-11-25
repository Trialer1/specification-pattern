package de.boettcher.specification.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.apache.commons.collections4.CollectionUtils;

import de.boettcher.specification.api.CompositeSpecification;
import de.boettcher.specification.api.Specification;

/**
 * Basic {@link CompositeSpecification} implementation which provides all features.
 * @param <T> Type of the object which can be checked against the specification.
 */
public class BasicCompositeSpecification<T> implements CompositeSpecification<T> {

    private final Collection<Specification<T>> andSpecifications = new ArrayList<>();

    private final Collection<Specification<T>> orSpecifications = new ArrayList<>();

    // TODO Parameter null checks

    protected BasicCompositeSpecification(final Specification<T> specification) {
        this.andSpecifications.add(specification);
    }

    @SafeVarargs
    private BasicCompositeSpecification(final Specification<T>... specifications) {
        this.andSpecifications.addAll(Arrays.asList(specifications));
    }

    private BasicCompositeSpecification(final Collection<Specification<T>> andSpecifications, final Collection<Specification<T>> orSpecifications) {
        this.andSpecifications.addAll(andSpecifications);
        this.orSpecifications.addAll(orSpecifications);
    }

    @Override
    public boolean isSatisfiedBy(final T t) {
        final boolean areAllAndSpecificationsSatisfied = this.areAndSpecificationsSatisfied(t);
        final boolean atLeastOneOrSpecificationsSatisfied = this.areOreSpecificationsSatisfied(t);

        final boolean satisfiedBy = areAllAndSpecificationsSatisfied && atLeastOneOrSpecificationsSatisfied;

        return satisfiedBy;
    }

    @Override
    public CompositeSpecification<T> and(final Specification<T> specification) {
        final BasicCompositeSpecification<T> abstractCompositeSpecification = new BasicCompositeSpecification<>(this, specification);

        return abstractCompositeSpecification;
    }

    @Override
    public CompositeSpecification<T> or(final Specification<T> specification) {
        final BasicCompositeSpecification<T> abstractCompositeSpecification = new BasicCompositeSpecification<>(null, Arrays.asList(this, specification));

        return abstractCompositeSpecification;
    }

    // TODO Check if this is really useful
    @Override
    public CompositeSpecification<T> remainderUnsatisfiedBy(final T t) {
        final Collection<Specification<T>> unsatisfiedAndSpecifications = this.getUnsatisfiedSpecifications(t, this.andSpecifications);
        final Collection<Specification<T>> unsatisfiedOrSpecifications = this.getUnsatisfiedSpecifications(t, this.orSpecifications);

        final CompositeSpecification<T> unsatisfiedSpecification = new BasicCompositeSpecification<>(unsatisfiedAndSpecifications, unsatisfiedOrSpecifications);

        return unsatisfiedSpecification;
    }

    private Collection<Specification<T>> getUnsatisfiedSpecifications(final T t, final Collection<Specification<T>> specifications) {
        if (CollectionUtils.isEmpty(specifications)) {
            return Collections.emptyList();
        }

        final Collection<Specification<T>> unsatisfiedSpecifications = new ArrayList<>();
        for (final Specification<T> specification : specifications) {
            final boolean satisfiedBy = specification.isSatisfiedBy(t);

            if (!satisfiedBy) {
                unsatisfiedSpecifications.add(specification);
            }
        }

        return unsatisfiedSpecifications;
    }

    private boolean areAndSpecificationsSatisfied(final T t) {
        if (this.andSpecifications == null || this.andSpecifications.size() < 1) {
            return true;
        }

        for (final Specification<T> specifications : this.andSpecifications) {
            final boolean satisfiedBy = specifications.isSatisfiedBy(t);

            if (!satisfiedBy) {
                return false;
            }
        }

        return true;
    }

    private boolean areOreSpecificationsSatisfied(final T t) {
        if (this.orSpecifications == null || this.orSpecifications.size() < 1) {
            return true;
        }

        for (final Specification<T> specifications : this.orSpecifications) {
            final boolean satisfiedBy = specifications.isSatisfiedBy(t);

            if (satisfiedBy) {
                return true;
            }
        }

        return false;
    }

    Collection<Specification<T>> getAndSpecifications() {
        return this.andSpecifications;
    }

    Collection<Specification<T>> getOrSpecifications() {
        return this.orSpecifications;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("BasicCompositeSpecification [andSpecifications=");
        builder.append(this.andSpecifications);
        builder.append(", orSpecifications=");
        builder.append(this.orSpecifications);
        builder.append("]");
        return builder.toString();
    }
}