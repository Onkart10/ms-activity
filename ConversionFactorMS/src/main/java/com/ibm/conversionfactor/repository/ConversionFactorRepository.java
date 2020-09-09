package com.ibm.conversionfactor.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ibm.conversionfactor.entity.ConversionFactorEntity;

@Repository
public interface ConversionFactorRepository/* extends CrudRepository<ConversionFactorEntity, Long>*/ {
/*public interface ConversionFactorRepository extends JpaRepository<ConversionFactorEntity, Long> {*/

	// ConversionFactorEntity findById(String Id);
	ConversionFactorEntity findByCountryCode(String countrycode);
}
