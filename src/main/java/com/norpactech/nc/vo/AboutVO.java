package com.norpactech.nc.vo;
/**
 * © 2025 Northern Pacific Technologies, LLC. All Rights Reserved. 
 * 
 * This software is proprietary and may not be used, copied, modified, or distributed 
 * without permission. It is provided "as is" without warranties of any kind. 
 * 
 * For details, see the LICENSE file in this project root.
 */
import lombok.Data;

@Data
public class AboutVO {

  private String application;
  private String version;
  private String profiles;
  private String started;
  private String authorities;
  private String databaseSchema;

}
