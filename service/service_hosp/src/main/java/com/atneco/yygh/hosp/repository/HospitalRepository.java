package com.atneco.yygh.hosp.repository;

import com.atneco.yygh.model.hosp.Hospital;
import com.atneco.yygh.model.hosp.HospitalSet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author liangyt
 * @create 2021-05-25 23:27
 */
@Repository
public interface HospitalRepository extends MongoRepository<Hospital,String> {

    Hospital getHospitalByHoscode(String hoscode);
}
