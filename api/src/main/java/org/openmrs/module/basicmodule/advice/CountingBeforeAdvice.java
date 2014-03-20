/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openmrs.module.basicmodule.advice;

/**
 *
 * @author Ye
 */

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.springframework.aop.MethodBeforeAdvice;


/*
Refer to https://wiki.openmrs.org/display/docs/OpenMRS+AOP
*/
public class CountingBeforeAdvice implements MethodBeforeAdvice {

    private Log log = LogFactory.getLog(this.getClass());

    private int count = 0;


    public void before(Method method, Object[] os, Object o) throws Throwable {

        log.debug("Method: " + method.getName() + ". Before advice called " + (++count) + " time(s) now.");
        String userName = Context.getUserContext().getAuthenticatedUser().getFamilyName();
        System.out.println("AOP - by: " + userName + "  Method: " + method.getName() + ". Before advice called " + (++count) + " time(s) now.");
        if (method.getName() != null) {
            if (method.getName().equals("createPerson")) {
                System.out.println(" Person created");
            }
        }
    }

}
