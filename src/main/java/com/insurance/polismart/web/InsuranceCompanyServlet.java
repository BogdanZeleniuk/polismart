package com.insurance.polismart.web;

import com.insurance.polismart.model.InsuranceCompany;
import com.insurance.polismart.web.controller.InsuranceCompanyController;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * Created by Admin on 06.07.2016.
 */
public class InsuranceCompanyServlet extends HttpServlet {

    private ConfigurableApplicationContext applicationContext;
    private InsuranceCompanyController insuranceCompanyController;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        applicationContext = new ClassPathXmlApplicationContext("spring/spring-app.xml","spring/spring-db.xml");
        insuranceCompanyController = applicationContext.getBean(InsuranceCompanyController.class);
    }

    @Override
    public void destroy() {
        applicationContext.close();
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");

        if (action == null){
            req.setAttribute("insuranceCompanyList", insuranceCompanyController.getAll());
            req.getRequestDispatcher("insuranceCompanyList.jsp").forward(req, resp);
        }
        else if (action.equalsIgnoreCase("update")){
            final InsuranceCompany company = insuranceCompanyController.get(Integer.valueOf(Objects.requireNonNull(req.getParameter("id"))));
            req.setAttribute("company",company);
            req.getRequestDispatcher("insuranceCompanyEdit.jsp").forward(req,resp);
        }
        else if (action.equalsIgnoreCase("delete")){
            insuranceCompanyController.delete(Integer.valueOf(Objects.requireNonNull(req.getParameter("id"))));
            resp.sendRedirect("insurance");
        }
        else if(action.equalsIgnoreCase("add")){
            final InsuranceCompany company = new InsuranceCompany("","",1000,1296);
            req.setAttribute("company", company);
            req.getRequestDispatcher("insuranceCompanyEdit.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        int franchise = Integer.valueOf(Objects.requireNonNull(req.getParameter("franchise")));
        int amount = Integer.valueOf(Objects.requireNonNull(req.getParameter("amount")));

        final InsuranceCompany company = new InsuranceCompany(name,description,franchise,amount);

        if (req.getParameter("id").isEmpty()){
            insuranceCompanyController.create(company);
        }
        else {
            insuranceCompanyController.update(company,Integer.valueOf(Objects.requireNonNull(req.getParameter("id"))));
        }

        resp.sendRedirect("insurance");
    }
}
