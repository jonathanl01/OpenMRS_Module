package org.openmrs.module.basicmodule.advice;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.Patient;
import org.openmrs.Encounter;
import org.openmrs.Person;
import org.openmrs.Order;
import org.springframework.aop.AfterReturningAdvice;


/*
Refer to https://wiki.openmrs.org/display/docs/OpenMRS+AOP
*/
public class CountingAfterAdvice implements AfterReturningAdvice {

    private Log log = LogFactory.getLog(this.getClass());

    private int count = 0;

    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        log.debug("Method: " + method.getName() + ". After advice called " + (++count) + " time(s) now.");
        String userName = Context.getUserContext().getAuthenticatedUser().getFamilyName();
        System.out.println("AOP - by: " + userName + "  Method: " + method.getName() + ". After advice called " + (++count) + " time(s) now.");
        if (returnValue != null) {
            if (returnValue.getClass() == Patient.class) {
                Patient p = (Patient) returnValue;
                System.out.println("Patient: " + p.getFamilyName());
                System.out.println("-------Modified------");
                System.out.println("Patient Gender: " + p.getGender());
                System.out.println("Patient UuID: "+ Context.getUserContext().getAuthenticatedUser().getUuid());
            }
            if (returnValue.getClass() == Encounter.class) {
                Encounter enc = (Encounter)returnValue;
                Patient p = enc.getPatient();
                System.out.println(" Patient: " + p.getFamilyName());
            }
            /*if (method.getName().equals("createPerson")) {
                Person p = (Person)returnValue;
                System.out.println(" Person: " + p.getFamilyName() + " created");
            }*/
            if (method.getName().equals("savePerson")) {
                Person p = (Person)returnValue;
                System.out.println(" Person: " + p.getFamilyName() + " saved");
            }
            if (method.getName().equals("savePatient")) {
                Person p = (Person)returnValue;
                System.out.println(" Patient: " + p.getFamilyName() + " saved");
            }
            if (method.getName().equals("saveOrder")) {
                Order o = (Order)returnValue;
                System.out.println(" Order: " + o.getOrderType() + " saved for patient: "+ o.getPatient() );
            }
            if (method.getName().equals("saveVisit")) {
                System.out.println(" Visit saved" );
            }
            }

        /*
        Other useful services to monitor include PersonService (create new persons (patients), OrderService (lab/drug orders),
        VisitService
        Also, check usage statistics module for other logging information
        
        App to use for creating charts: http://dvillela.servehttp.com:4000/apostilas/jfreechart_tutorial.pdf
        */
        }

    }
