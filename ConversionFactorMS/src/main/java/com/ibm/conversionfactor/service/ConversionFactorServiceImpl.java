package com.ibm.conversionfactor.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.conversionfactor.dto.ConversionFactorDTO;
import com.ibm.conversionfactor.entity.ConversionFactorEntity;
import com.ibm.conversionfactor.repository.ConversionFactorRepository;

@Service
public class ConversionFactorServiceImpl implements ConversionFactorService {

	ConversionFactorRepository repo;

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public ConversionFactorServiceImpl(ConversionFactorRepository repo) {

		this.repo = repo;
	}

	@Override
	public ConversionFactorDTO addConversionFactor(ConversionFactorDTO factordto) {
		// TODO Auto-generated method stub

		// factordto.setId(UUID.randomUUID().toString());
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ConversionFactorEntity entity = mapper.map(factordto, ConversionFactorEntity.class);
		//repo.save(entity);

		ConversionFactorDTO dto = mapper.map(entity, ConversionFactorDTO.class);
		return dto;
	}

	@Override
	public ConversionFactorDTO updateConversionFactor(ConversionFactorDTO factordto) {
		// TODO Auto-generated method stub

		// factordto.setId(UUID.randomUUID().toString());
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ConversionFactorEntity entity = mapper.map(factordto, ConversionFactorEntity.class);
		//repo.save(entity);
		ConversionFactorDTO dto = mapper.map(entity, ConversionFactorDTO.class);
		return dto;
	}

	@Override
	public ConversionFactorDTO getfactorBycountrycode(String countrycode) {
		logger.info("Inside getfactorBycountrycode...");
		ConversionFactorDTO dto = null;
		try {
		ConversionFactorEntity entity = repo.findByCountryCode(countrycode);
		/*Iterable<ConversionFactorEntity> it = repo.findAll();
		List<ConversionFactorEntity> convList = new ArrayList<ConversionFactorEntity>();
		it.forEach(e -> convList.add(e));
		for(ConversionFactorEntity convEntity : convList) {
			if(convEntity.getCountryCode().equalsIgnoreCase(countrycode))
				entity = convEntity;
			logger.info("entity : "+entity);
		}*/
		
		// if(userEntity == null) throw new UsernameNotFoundException("User not found");

		dto = new ModelMapper().map(entity, ConversionFactorDTO.class);
		logger.info("dto mapped..");
		}catch(Exception e) {
			logger.info("exception occured : "+e);
		}
		logger.info("Inside getfactorBycountrycode - END");
		return dto;
	}

}
