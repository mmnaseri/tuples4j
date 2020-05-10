package com.mmnaseri.utils.tuples.model;

import java.math.BigDecimal;

@SupportsFinancialEntity
public interface FinancialEntity {

  BigDecimal income();
}
