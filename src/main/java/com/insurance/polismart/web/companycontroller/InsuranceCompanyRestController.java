package com.insurance.polismart.web.companycontroller;

import com.insurance.polismart.model.InsuranceCompany;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Created by Admin on 31.07.2016.
 */
@RestController
@RequestMapping(value = "/insurance", produces = MediaType.APPLICATION_JSON_VALUE)
public class InsuranceCompanyRestController extends AbstractInsuranceCompanyController{

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity <InsuranceCompany> createWithLocation(@RequestBody InsuranceCompany company){
        InsuranceCompany created = super.create(company);

        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/insurance" + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id){
        super.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody InsuranceCompany company, @PathVariable("id") int id){
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

    @RequestMapping(value = "/filterByAmount", method = RequestMethod.GET)
    public List<InsuranceCompany> getFilteredByAmount(@RequestParam(value = "min", required = false) int min,
                                                      @RequestParam(value = "max", required = false) int max){
        return super.getFilteredByAmount(min, max);
    }

    @RequestMapping(value = "/filterByFranchise", method = RequestMethod.GET)
    public List<InsuranceCompany> getFilteredByFranchise(@RequestParam(value = "min", required = false) int min,
                                                         @RequestParam(value = "max", required = false) int max){
        return super.getFilteredByFranchise(min, max);
    }

}
