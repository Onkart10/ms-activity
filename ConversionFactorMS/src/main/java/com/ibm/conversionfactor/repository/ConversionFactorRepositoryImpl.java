package com.ibm.conversionfactor.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ibm.conversionfactor.entity.ConversionFactorEntity;
import com.ibm.conversionfactor.mapper.ConversionFactorRowMapper;

@Repository
public class ConversionFactorRepositoryImpl implements ConversionFactorRepository{
	
	Logger logger = LoggerFactory.getLogger(ConversionFactorEntity.class);
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public ConversionFactorEntity findByCountryCode(String countrycode) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource("countryCode",countrycode);
		String sql = "select * from Conversion_Factor where countryCode = :countryCode";
		ConversionFactorEntity convEntity = namedParameterJdbcTemplate.queryForObject(sql, paramSource, new ConversionFactorRowMapper());
		logger.info("convEntity : "+convEntity);
		return convEntity;
	}
	
	
}
