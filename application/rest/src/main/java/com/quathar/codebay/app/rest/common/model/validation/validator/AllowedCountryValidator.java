package com.quathar.codebay.app.rest.common.model.validation.validator;

import com.quathar.codebay.app.rest.common.model.validation.constraint.AllowedCountry;
import com.quathar.codebay.domain.port.out.option.CountryRepositoryPort;
import com.quathar.codebay.domain.valueobject.option.Country;

import org.springframework.stereotype.Component;

/**
 * <h1>Allowed Country Validator</h1>
 *
 * @see AllowedCountry
 * @see AllowedBaseOptionValidator
 * @since 2024-07-26
 * @version 1.0
 * @author Q
 */
@Component
public final class AllowedCountryValidator
       extends     AllowedBaseOptionValidator<Country, AllowedCountry>{

    // <<-CONSTRUCTOR->>
    /**
     * Constructs a new {@link AllowedCountryValidator}
     * with the specified {@link CountryRepositoryPort}.
     *
     * @param countryRepositoryPort The {@link Country} repository port.
     */
    public AllowedCountryValidator(CountryRepositoryPort countryRepositoryPort) {
        super(countryRepositoryPort);
    }

}
