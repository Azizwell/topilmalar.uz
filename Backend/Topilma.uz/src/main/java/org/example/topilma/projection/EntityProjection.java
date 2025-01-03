package org.example.topilma.projection;

import java.util.Date;

public interface EntityProjection {
  String getEntityId();

  String getEntityName();

  String getSerialNumber();

  String getEntityType();

  String getRegionName();

  String getDistrictName();

  String getRegionId();

  String getDistrictId();

  Date getCreatedDate();

  String getName();
}
