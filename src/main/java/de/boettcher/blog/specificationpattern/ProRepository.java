package de.boettcher.blog.specificationpattern;

import java.util.Optional;

public interface ProRepository {

  Optional<Pro> getById(long id);

}
