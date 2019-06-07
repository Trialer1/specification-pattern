package de.boettcher.blog.specificationpattern;

import java.util.Arrays;
import java.util.Collection;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class User {

  private static final Collection<Long> PREMIUM_IDS = Arrays.asList(5L, 8L, 234L, 444L, 999L);

  public enum Flag {
    PRO, PREMIUM
  }

  private final long id;

  private final Collection<Flag> flags;

  public boolean isPro(ProRepository proRepository) {
    return hasProId() || hasProFlag() || isIdContainedInProDatabase(proRepository);
  }

  public boolean isPremium() {
    return hasPremiumId() || hasPremiumFlag();
  }

  private boolean hasProId() {
    return id < 1000;
  }

  private boolean hasProFlag() {
    return flags != null && flags.contains(Flag.PRO);
  }

  private boolean isIdContainedInProDatabase(ProRepository proRepository) {
    return proRepository.getById(id).isPresent();
  }

  private boolean hasPremiumId() {
    return PREMIUM_IDS.contains(id);
  }

  private boolean hasPremiumFlag() {
    return flags != null && flags.contains(Flag.PREMIUM);
  }
}
