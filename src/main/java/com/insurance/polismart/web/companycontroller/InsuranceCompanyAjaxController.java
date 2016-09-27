package com.insurance.polismart.web.companycontroller;

import com.insurance.polismart.model.InsuranceCompany;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Admin on 05.09.2016.
 */
@RestController
@RequestMapping(value = "/ajax/insurance")
public class InsuranceCompanyAjaxController extends AbstractInsuranceCompanyController {

    @RequestMapping(value = "/{id}")
    public InsuranceCompany get(@PathVariable("id") int id){
        return super.get(id);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<InsuranceCompany> getAll(){
        return super.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id){
        super.delete(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void updateOrCreate(@Valid InsuranceCompany company){
        if (company.isNew()){
            super.create(company);
        }
        else
            super.update(company, company.getId());
    }

    @RequestMapping(value = "/filterByData", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<InsuranceCompany> getFilteredByAmount(@RequestParam(value = "minAmount", required = false) Integer minAmount,
                                                      @RequestParam(value = "maxAmount", required = false) Integer maxAmount,
                                                      @RequestParam(value = "minFranchise", required = false) Integer minFranchise,
                                                      @RequestParam(value = "maxFranchise", required = false) Integer maxFranchise){
        return super.getFilteredByData(minAmount, maxAmount, minFranchise, maxFranchise);
    }
}
