package org.example.topilma.dto.applicant;

public record ApplicantDto(
        String regionId,
        String districtId,
        String address,
        String phone,
        String email
) {
}
