package net.silentchaos512.tutorial.lib;

/**
 * Stores information on the meta-item ingots and meta-block ores. I highly recommend using enums for such cases, as it
 * makes matching the ores/ingots easier in this case and should also make updating to 1.8 easier.
 * 
 * This simple example contains the name and metavalue of the metals. You could store some additional information here
 * if you need to, or add more convience methods. For example, try adding a method that returns an ItemStack of the
 * ingot for the metal, so you could call EnumMetal.SILVER.getIngot() to get a silver ingot.
 * 
 * Episode 5
 * 
 * @author SilentChaos512
 *
 */
public enum EnumMetal {

  COPPER(0, "Copper"),
  TIN(1, "Tin"),
  SILVER(2, "Silver"),
  LEAD(3, "Lead");

  /**
   * The metadata of ingots/ores/etc for this metal. This is also used for indexing into icon arrays, for example. You
   * could make this public if you like.
   */
  private final int meta;
  /**
   * The internal name of the metal. We can use toLowerCase() if we need this in all lower case. You could make this
   * public if you like.
   */
  private final String name;

  /**
   * The constructor used above. It's private because we don't need this outside of this file.
   * 
   * @param meta
   *          The metadata for this metal. You must start with 0 and increment by 1!
   * @param name
   *          The name of the metal. Used for ore dictionary entries, unlocalized names, textures, etc.
   */
  private EnumMetal(int meta, String name) {

    this.meta = meta;
    this.name = name;
  }

  /**
   * Getter method to get the meta. Not needed if you made meta public.
   * 
   * @return meta
   */
  public int getMeta() {

    return this.meta;
  }

  /**
   * Getter method to get the name. Not needed if you made name public.
   * 
   * @return name
   */
  public String getName() {

    return this.name;
  }

  /**
   * Convenience method to reduce keystrokes. Not necessary, but makes our code a bit easier to read.
   * 
   * @return The length of the values array.
   */
  public static int count() {

    return values().length;
  }
}
