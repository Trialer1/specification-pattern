package de.boettcher.blog.specificationpattern;

import java.util.Optional;

public class DummyProResository implements ProRepository {

  @Override
  public Optional<Pro> getById(long id) {
    return Optional.empty();
  }
}
