package com.ibm.conversionfactor.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ibm.conversionfactor.entity.ConversionFactorEntity;

public class ConversionFactorRowMapper implements RowMapper<ConversionFactorEntity> {

	@Override
	public ConversionFactorEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
		ConversionFactorEntity dto = new ConversionFactorEntity();
		dto.setId(rs.getLong(1));
		dto.setCountryCode(rs.getString(2));
		dto.setCountryfactor(rs.getDouble(3));
		return dto;
	}

}
