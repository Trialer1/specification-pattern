package de.boettcher.specification.examples.day;

import de.boettcher.specification.api.CompositeSpecification;
import de.boettcher.specification.api.Specification;
import de.boettcher.specification.impl.BasicCompositeSpecification;

/**
 * {@link CompositeSpecification} for {@link Day}s.
 */
abstract class DaySpecification extends BasicCompositeSpecification<Day> {

    protected DaySpecification(final Specification<Day> specification) {
        super(specification);
    }

}
