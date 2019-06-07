package de.boettcher.blog.specificationpattern;

import de.boettcher.blog.specificationpattern.User.Flag;
import java.util.Arrays;
import java.util.Collection;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PremiumUserSpecification {

  private static final Collection<Long> PREMIUM_IDS = Arrays.asList(5L, 8L, 234L, 444L, 999L);

  public boolean isSatisfiedBy(User user) {
    return hasPremiumId(user) || hasPremiumFlag(user);
  }

  private boolean hasPremiumId(User user) {
    return PREMIUM_IDS.contains(user.getId());
  }

  private boolean hasPremiumFlag(User user) {
    Collection<Flag> flags = user.getFlags();
    return flags != null && flags.contains(Flag.PREMIUM);
  }
}
