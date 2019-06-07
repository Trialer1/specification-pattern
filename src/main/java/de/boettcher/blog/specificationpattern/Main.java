package de.boettcher.blog.specificationpattern;

import java.util.Collections;

public class Main {

  public static void main(String[] args) {
    ProRepository proRepository = new DummyProResository();
    User user = new User(1L, Collections.emptyList());

    if (user.isPro(proRepository)) {
      System.out.println("User is a pro user");
    } else if (user.isPremium()) {
      System.out.println("User is a premium user");
    } else {
      System.out.println("User is a normal user");
    }

    ProUserSpecification proUserSpecification = new ProUserSpecification(proRepository);
    PremiumUserSpecification premiumUserSpecification = new PremiumUserSpecification();
    if (proUserSpecification.isSatisfiedBy(user)) {
      System.out.println("User is a pro user");
    } else if (premiumUserSpecification.isSatisfiedBy(user)) {
      System.out.println("User is a premium user");
    } else {
      System.out.println("User is a normal user");
    }
  }
}
