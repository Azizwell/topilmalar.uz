package org.example.topilma.repository;

import org.example.topilma.entity.Applicant;
import org.example.topilma.projection.EntityProjection;
import org.example.topilma.projection.RegionStatProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public interface ApplicantRepo extends JpaRepository<Applicant, UUID> {

  @Query(value = " SELECT *\n" +
          "FROM (\n" +
          "         SELECT\n" +
          "             COALESCE(dri.id, iri.id) AS entity_id,\n" +
          "             CASE\n" +
          "                 WHEN dri.market_id IS NOT NULL THEN m.name\n" +
          "                 ELSE i.name\n" +
          "             END AS entity_name,\n" +
          "             COALESCE(dri.market_id, iri.item_id) AS mini_type, " +
          "             COALESCE(dri.status, iri.status) AS status,   " +
          "             COALESCE(dri.serial_number, iri.serial_number) AS serial_number,\n" +
          "             CASE\n" +
          "                 WHEN dri.market_id IS NOT NULL THEN 'Hujjat'\n" +
          "                 ELSE 'Buyum'\n" +
          "             END AS entity_type,\n" +
          "             r.name AS region_name,\n" +
          "             d.name AS district_name,\n" +
          "             r.id as region_id, " +
          "             d.id as district_id  " +
          "         FROM applicant a\n" +
          "                  LEFT JOIN document_request_information dri ON a.id = dri.applicant_id\n" +
          "                  LEFT JOIN item_request_information iri ON a.id = iri.applicant_id\n" +
          "                  LEFT JOIN market m ON dri.market_id = m.id\n" +
          "                  LEFT JOIN item i ON iri.item_id = i.id\n" +
          "                  LEFT JOIN region r ON a.region_id = r.id\n" +
          "                  LEFT JOIN district d ON a.district_id = d.id\n " +
          "         WHERE dri.market_id IS NOT NULL OR iri.item_id IS NOT NULL " +
          "     ) subquery\n" +
          " WHERE " +
          " (:type IS NULL OR status = :type) " +
          "AND (:status IS NULL OR entity_type = :status) " +
          "AND (:miniType IS NULL OR mini_type = :miniType ::uuid) " +
          "AND (:serialNumber IS NULL OR serial_number = :serialNumber) " +
          "AND (:region IS NULL OR region_id = :region ::uuid) " +
          "AND (:district IS NULL OR district_id = :district ::UUID) ", nativeQuery = true)
  public List<EntityProjection> getEntityProjectionQuery(
          String type,
          String status,
          UUID miniType,
          UUID region,
          UUID district,
          String serialNumber);

  @Query(value = " SELECT\n" +
          "    COALESCE(dri.id, iri.id) AS entity_id,\n" +
          "    CASE\n" +
          "        WHEN dri.market_id IS NOT NULL THEN m.name\n" +
          "        ELSE i.name\n" +
          "        END AS entity_name,\n" +
          "    COALESCE(dri.serial_number, iri.serial_number) AS serial_number,\n" +
          "    CASE\n" +
          "        WHEN dri.market_id IS NOT NULL THEN 'Hujjat'\n" +
          "        ELSE 'Buyum'\n" +
          "        END AS entity_type,\n" +
          "    r.name AS region_name,\n" +
          "    d.name AS district_name\n" +
          "FROM applicant a\n" +
          "         LEFT JOIN document_request_information dri ON a.id = dri.applicant_id\n" +
          "         LEFT JOIN item_request_information iri ON a.id = iri.applicant_id\n" +
          "         LEFT JOIN market m ON dri.market_id = m.id\n" +
          "         LEFT JOIN item i ON iri.item_id = i.id\n" +
          "         LEFT JOIN region r ON a.region_id = r.id\n" +
          "         LEFT JOIN district d ON a.district_id = d.id\n" +
          "WHERE dri.market_id IS NOT NULL OR iri.item_id IS NOT NULL ", nativeQuery = true)
  public List<EntityProjection> getAllEntityProjectionQuery();

  @Query(value = " SELECT\n" +
          "    COALESCE(dri.id, iri.id) AS entity_id,\n " +
          "    COALESCE(dri.created_date, iri.created_date) AS created_date, " +
          "    COALESCE(dri.name, iri.name) AS name, " +
          "    CASE\n" +
          "        WHEN dri.market_id IS NOT NULL THEN m.name\n" +
          "        ELSE i.name\n" +
          "        END AS entity_name,\n" +
          "    COALESCE(dri.serial_number, iri.serial_number) AS serial_number,\n" +
          "    CASE\n" +
          "        WHEN dri.market_id IS NOT NULL THEN 'Hujjat'\n" +
          "        ELSE 'Buyum'\n" +
          "        END AS entity_type,\n" +
          "    r.name AS region_name,\n" +
          "    d.name AS district_name\n" +
          "FROM applicant a\n" +
          "         LEFT JOIN document_request_information dri ON a.id = dri.applicant_id\n" +
          "         LEFT JOIN item_request_information iri ON a.id = iri.applicant_id\n" +
          "         LEFT JOIN market m ON dri.market_id = m.id\n" +
          "         LEFT JOIN item i ON iri.item_id = i.id\n" +
          "         LEFT JOIN region r ON a.region_id = r.id\n" +
          "         LEFT JOIN district d ON a.district_id = d.id\n" +
          "WHERE dri.market_id IS NOT NULL OR iri.item_id IS NOT NULL  " +
          " order by created_date desc limit(6)  ", nativeQuery = true)
  public List<EntityProjection> getByCarouselInfo();

  @Query(value = " SELECT\n" +
          "    COALESCE(dri.id, iri.id) AS entity_id,\n" +
          "    CASE\n" +
          "        WHEN dri.market_id IS NOT NULL THEN m.name\n" +
          "        ELSE i.name\n" +
          "        END AS entity_name,\n" +
          "    COALESCE(dri.serial_number, iri.serial_number) AS serial_number,\n" +
          "    CASE\n" +
          "        WHEN dri.market_id IS NOT NULL THEN 'Hujjat'\n" +
          "        ELSE 'Buyum'\n" +
          "        END AS entity_type,\n" +
          "    r.name AS region_name,\n" +
          "    d.name AS district_name\n" +
          "FROM applicant a\n" +
          "         LEFT JOIN document_request_information dri ON a.id = dri.applicant_id\n" +
          "         LEFT JOIN item_request_information iri ON a.id = iri.applicant_id\n" +
          "         LEFT JOIN market m ON dri.market_id = m.id\n" +
          "         LEFT JOIN item i ON iri.item_id = i.id\n" +
          "         LEFT JOIN region r ON a.region_id = r.id\n" +
          "         LEFT JOIN district d ON a.district_id = d.id\n" +
          "WHERE dri.market_id IS NOT NULL OR iri.item_id IS NOT NULL\n" +
          " AND COALESCE(dri.serial_number, iri.serial_number) = :keyword", nativeQuery = true)
  List<EntityProjection> universalSearch(@Param("keyword") String keyword);


  @Query(value = " SELECT\n" +
          "    r.name AS region_name, \n" +
          "    COUNT(COALESCE(dri.id, iri.id)) AS entity_count, \n" +
          "    SUM(CASE WHEN dri.active = false OR iri.active = false THEN 1 ELSE 0 END) AS inactive_entity_count \n" +
          "FROM region r\n" +
          "         LEFT JOIN applicant a ON r.id = a.region_id\n" +
          "         LEFT JOIN document_request_information dri ON a.id = dri.applicant_id\n" +
          "         LEFT JOIN item_request_information iri ON a.id = iri.applicant_id\n" +
          "GROUP BY r.name", nativeQuery = true)
  public List<RegionStatProjection> getRegionStatistic();

  @Query(value = "select " +
          "      sum(case when  dri.status = 'FOUND' or iri.status = 'FOUND' then 1 else 0 end ) as found_count,\n" +
          "      sum(case when  dri.status = 'MISSING' or iri.status = 'MISSING' then 1 else 0 end ) as document_count,\n" +
          "      SUM(CASE WHEN dri.active = false OR iri.active = false THEN 1 ELSE 0 END) AS inactive_entity_count\n" +
          "from applicant a\n" +
          "         left join document_request_information dri on a.id = dri.applicant_id\n" +
          "         left join item_request_information iri on a.id = iri.applicant_id ", nativeQuery = true)
  List<Object[]> getStatisticCount();
}
