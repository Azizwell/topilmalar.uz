package org.example.topilma.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ItemRequestInformation {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @ManyToOne
  private Item item;
  private String name;
  private String itemSerialNumber;
  private String color;
  private String shape;
  private String weight;
  private String code;
  private Date givenDate;
  private Date lossDate;
  @ManyToOne
  private Region givenRegion;
  @ManyToOne
  private District lossDistrict;
  private String lossAddress;
  private String photo;
  private String documentFile;
  @CreationTimestamp
  @Column(columnDefinition = "timestamp default current_timestamp")
  private Date createdDate;
  @Enumerated(EnumType.STRING)
  private Status status;
  private Boolean active;
  @ManyToOne
  private Applicant applicant;
  private String serialNumber;

  @PrePersist
  private void generateSerialNumber() {
    if (serialNumber == null) {
      this.serialNumber = "ABC" + UUID.randomUUID().toString().replace("-", "").substring(0, 8);
    }
    if (active == null) {
      this.active = true;
    }

  }


}
