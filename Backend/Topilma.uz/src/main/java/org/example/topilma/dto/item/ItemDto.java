package org.example.topilma.dto.item;

import java.util.Date;

public record ItemDto(
        String applicantId,
        String code,
        String color,
        String itemSerialNumber,
        Date givenDate,
        String givenRegionId,
        String itemId,
        String lossAddress,
        Date lossDate,
        String lossDistrictId,
        String name,
        String photo,
        String status,


        String shape,
        String weight,
        String documentFile
) {
}
