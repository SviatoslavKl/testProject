package com.testproject.test.repository;

import com.testproject.test.model.CalendlyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendlyRepository extends JpaRepository<CalendlyEntity, Integer> {

    @Query(value = "select ce from CalendlyEntity ce where (:type is null or ce.type like concat(:type,'%') ) and (:name is null or ce.name like concat(:name,'%')) and (:active is null or ce.active =:active)")
    Page<CalendlyEntity> findAllBy (@Param("type") String type, @Param("name") String name, @Param("active") Boolean active, Pageable pageable);
}
