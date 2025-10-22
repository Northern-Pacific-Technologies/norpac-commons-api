package com.norpactech.nc.enums;

public enum EnumTableTypes {
  
  REGION_TYPE("region-type"), 
  ADDRESS_STATUS("address-status"); 

  private String name;

  public static EnumTableTypes fromName(String name) {
    for (EnumTableTypes context : EnumTableTypes.values()) {
      if (context.getName().equals(name)) {
        return context;
      }
    }
    return null;
  }
  
  private EnumTableTypes(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
