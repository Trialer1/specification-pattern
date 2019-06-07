package de.boettcher.blog.specificationpattern;

import de.boettcher.blog.specificationpattern.User.Flag;
import java.util.Collection;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProUserSpecification {

  private final ProRepository proRepository;

  public boolean isSatisfiedBy(User user) {
    return hasProId(user) || hasProFlag(user) || isIdContainedInProDatabase(user, proRepository);
  }

  private boolean hasProId(User user) {
    return user.getId() > 1000;
  }

  private boolean hasProFlag(User user) {
    Collection<Flag> flags = user.getFlags();
    return flags != null && flags.contains(Flag.PRO);
  }

  private boolean isIdContainedInProDatabase(User user, ProRepository proRepository) {
    return proRepository.getById(user.getId()).isPresent();
  }

}
