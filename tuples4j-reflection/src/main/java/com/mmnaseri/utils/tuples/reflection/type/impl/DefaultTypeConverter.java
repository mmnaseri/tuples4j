package com.mmnaseri.utils.tuples.reflection.type.impl;

/**
 * The default type converter. This converter is composed of:
 *
 * <ol>
 *   <li>{@link PrimitiveTypeConverter}
 *   <li>{@link EnumTypeConverter}
 *   <li>{@link NumberTypeConverter}
 *   <li>{@link StringNumberTypeConverter}
 * </ol>
 */
public class DefaultTypeConverter extends CompositeTypeConverter {

  /**
   * This is the default, shared instance. Remember that since this converter is a {@link
   * CompositeTypeConverter}, if you modify this instance by adding converters to it, it will modify
   * the rest of the usages as well.
   */
  private static final DefaultTypeConverter INSTANCE = new DefaultTypeConverter();

  public DefaultTypeConverter() {
    add(new PrimitiveTypeConverter());
    add(new EnumTypeConverter());
    add(new NumberTypeConverter());
    add(new StringNumberTypeConverter());
  }

  public static DefaultTypeConverter getInstance() {
    return INSTANCE;
  }
}
