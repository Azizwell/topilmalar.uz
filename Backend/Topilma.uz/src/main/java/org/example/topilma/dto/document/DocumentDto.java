package org.example.topilma.dto.document;

import java.util.Date;

public record DocumentDto(
        String applicantId,
        String docContent,
        String documentSerialNumber,
        Date givenDate,
        String givenRegionId,
        String lossAddress,
        Date lossDate,
        String lossDistrictId,
        String marketId,
        String name,
        String photo,
        String snp,
        String status,
        String documentFile
) {
}
