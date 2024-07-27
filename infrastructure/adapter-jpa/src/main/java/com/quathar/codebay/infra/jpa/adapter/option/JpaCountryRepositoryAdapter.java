package com.quathar.codebay.infra.jpa.adapter.option;

import com.quathar.codebay.domain.port.out.option.CountryRepositoryPort;
import com.quathar.codebay.domain.valueobject.option.Country;
import com.quathar.codebay.infra.jpa.entity.option.CountryEntity;
import com.quathar.codebay.infra.jpa.mapper.option.CountryMapper;
import com.quathar.codebay.infra.jpa.repository.option.JpaCountryRepository;

import org.springframework.stereotype.Component;

/**
 * <h1>JPA (Java Persistence API) Country Repository Adapter</h1>
 *
 * @see CountryRepositoryPort
 * @see JpaBaseOptionRepositoryAdapter
 * @see Country
 * @see CountryEntity
 * @since 2023-05-13
 * @version 1.0
 * @author Q
 */
@Component
public final class JpaCountryRepositoryAdapter
       extends     JpaBaseOptionRepositoryAdapter<Country, CountryEntity>
       implements  CountryRepositoryPort {

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a new {@link JpaCountryRepositoryAdapter} for the {@link CountryRepositoryPort}
     * with the specified {@link JpaCountryRepository} and {@link CountryMapper}.
     *
     * @param jpaCountryRepository The JPA repository for {@link CountryEntity}.
     * @param countryMapper        The mapper for converting between {@link Country} and {@link CountryEntity}.
     */
    public JpaCountryRepositoryAdapter(JpaCountryRepository jpaCountryRepository, CountryMapper countryMapper) {
        super(jpaCountryRepository, countryMapper);
    }

}
