/** Copyright (c) 2023 Splio.com All rights reserved. */
package org.example.people.entity;

import java.util.List;
import java.util.Objects;

public record People(Integer age, String name, List<Address> address) {
  public People {
    Objects.requireNonNull(age);
    Objects.requireNonNull(name);
    address = List.copyOf(address);
  }
}
