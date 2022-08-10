/** Copyright (c) \2022 Splio.com All rights reserved. */
package com.splio.template.universe.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class Universe {
  @JsonProperty("creation_date")
  private String creationDate;

  @JsonProperty private boolean expired;

  @JsonProperty("gc_period_days")
  private int gcPeriodDays;

  @JsonProperty private String id;

  @JsonProperty("in_maintenance")
  private boolean inMaintenance;

  @JsonProperty("is_isolated")
  private boolean isIsolated;

  @JsonProperty("id_shadow")
  private boolean isShadow;

  @JsonProperty("update_date")
  private String updateDate;
}
