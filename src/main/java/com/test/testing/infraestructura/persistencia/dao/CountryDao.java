package com.test.testing.infraestructura.persistencia.dao;

import com.test.testing.infraestructura.persistencia.entidad.CountryEntity;
import org.springframework.data.repository.CrudRepository;

public interface CountryDao extends CrudRepository<CountryEntity, Long>, CountryCustomDao {
}
