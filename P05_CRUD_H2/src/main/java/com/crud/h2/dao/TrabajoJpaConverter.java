package com.crud.h2.dao;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.crud.h2.dto.Trabajos;

@Converter
public class TrabajoJpaConverter implements AttributeConverter<Trabajos, String> {

	@Override
	public String convertToDatabaseColumn(Trabajos attribute) {
		// TODO Auto-generated method stub
		if (attribute == null) {
			return null;
		}
		return attribute.toString();
	}

	@Override
	public Trabajos convertToEntityAttribute(String dbData) {
		// TODO Auto-generated method stub
		if(dbData == null) {
			return null;
		}
		try {
			return Trabajos.valueOf(dbData);
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
			return null;
		}
		
	}

	
}
