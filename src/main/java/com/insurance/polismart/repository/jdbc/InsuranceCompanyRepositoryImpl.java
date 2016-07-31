package com.insurance.polismart.repository.jdbc;

import com.insurance.polismart.model.InsuranceCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import com.insurance.polismart.repository.InsuranceCompanyRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Admin on 29.06.2016.
 */
@Repository
@Transactional(readOnly = true)
public class InsuranceCompanyRepositoryImpl implements InsuranceCompanyRepository {

    private static final BeanPropertyRowMapper<InsuranceCompany> MAPPER = BeanPropertyRowMapper.newInstance(InsuranceCompany.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private SimpleJdbcInsert jdbcInsert;

    @Autowired
    public InsuranceCompanyRepositoryImpl(DataSource dataSource) {
        this.jdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("insurance_companies")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    @Transactional
    public InsuranceCompany save(InsuranceCompany company) {
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource()
                .addValue("id",company.getId())
                .addValue("name",company.getName())
                .addValue("description",company.getDescription())
                .addValue("franchise",company.getFranchise())
                .addValue("amount",company.getAmount());
        if (company.isNew()){
            Number newId = jdbcInsert.executeAndReturnKey(mapSqlParameterSource);
            company.setId(newId.intValue());
        }
        else {
            namedParameterJdbcTemplate.update("UPDATE insurance_companies SET name=:name, " +
                    "description=:description, franchise=:franchise, amount=:amount WHERE id=:id",mapSqlParameterSource);
        }
        return company;
    }

    @Override
    public InsuranceCompany get(int id) {
        List<InsuranceCompany> list = jdbcTemplate.query("SELECT * FROM insurance_companies WHERE id=?",MAPPER,id);
        return DataAccessUtils.singleResult(list);
    }

    @Override
    @Transactional
    public boolean delete(int id) {
        return jdbcTemplate.update("DELETE FROM insurance_companies WHERE id=?", id) != 0;
    }

    @Override
    public List<InsuranceCompany> getAll() {
        return jdbcTemplate.query("SELECT * FROM insurance_companies ORDER BY amount",MAPPER);
    }

    @Override
    public List<InsuranceCompany> getFilteredByAmount(int min, int max) {
        return jdbcTemplate.query("SELECT * FROM insurance_companies WHERE amount BETWEEN ? AND ? ORDER BY amount DESC",MAPPER,min,max);
    }

    @Override
    public List<InsuranceCompany> getFilteredByFranchise(int min, int max) {
        return jdbcTemplate.query("SELECT * FROM insurance_companies WHERE franchise BETWEEN ? AND ? ORDER BY franchise DESC ",MAPPER,min,max);
    }
}
