package com.insurance.polismart.web.companycontroller;

import com.insurance.polismart.model.InsuranceCompany;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/**
 * Created by Admin on 31.07.2016.
 */
@RestController
@RequestMapping(value = "/rest/insurance", produces = MediaType.APPLICATION_JSON_VALUE)
public class InsuranceCompanyRestController extends AbstractInsuranceCompanyController{

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <InsuranceCompany> createWithLocation(@Valid @RequestBody InsuranceCompany company){
        InsuranceCompany created = super.create(company);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/rest/insurance" + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id){
        super.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@Valid @RequestBody InsuranceCompany company, @PathVariable("id") int id){
        super.update(company, id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public InsuranceCompany get(@PathVariable ("id") int id){
        return super.get(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<InsuranceCompany> getAll(){
        return super.getAll();
    }

    @RequestMapping(value = "/filterByData", method = RequestMethod.GET)
    public List<InsuranceCompany> getFilteredByData(@RequestParam(value = "minAmount", required = false) Integer minAmount,
                                                    @RequestParam(value = "maxAmount", required = false) Integer maxAmount,
                                                    @RequestParam(value = "minFranchise", required = false) Integer minFranchise,
                                                    @RequestParam(value = "maxFranchise", required = false) Integer maxFranchise){
        return super.getFilteredByData(minAmount, maxAmount, minFranchise, maxFranchise);
    }
}
