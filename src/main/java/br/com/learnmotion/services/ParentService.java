package br.com.learnmotion.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ParentService {

	@Autowired
	protected ModelMapper mapper;

}
