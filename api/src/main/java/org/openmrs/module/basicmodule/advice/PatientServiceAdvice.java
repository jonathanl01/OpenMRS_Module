package org.openmrs.module.basicmodule.advice;

import java.lang.reflect.Method;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.Patient;
import org.openmrs.module.basicmodule.AccessPatientService;
import org.openmrs.module.basicmodule.UsageLog;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;


/**
 * 
 * @author Ye
 */
public class PatientServiceAdvice implements MethodBeforeAdvice, AfterReturningAdvice {

    private Log log = LogFactory.getLog(this.getClass());

    private int count = 0;
    
    protected UsageLog.Type usageType;
    
    public void before(Method method, Object[] args, Object target) throws Throwable {
		if (method.getName().equals("savePatient") || method.getName().equals("updatePatient")) {
			Patient patient = (Patient)args[0];
			usageType = UsageLog.Type.UPDATED;
			
			if (patient.getPatientId() == null)
				usageType = UsageLog.Type.CREATED;
			else if (patient.isVoided()) {
				AccessPatientService svc = (AccessPatientService)Context.getService(AccessPatientService.class);
				// Patient object is voided, but check database record
				//if (!svc.isPatientVoidedInDatabase(patient))
					//usageType = UsageLog.Type.VOIDED;
			}			
		}
		else if (method.getName().equals("createPatient"))
			usageType = UsageLog.Type.CREATED;
		else if (method.getName().equals("voidPatient"))
			usageType = UsageLog.Type.VOIDED;
        }

    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        //log.debug("Method: " + method.getName() + ". After advice called " + (++count) + " time(s) now.");
		if (method.getName().equals("savePatient")
				|| method.getName().equals("updatePatient")
				|| method.getName().equals("createPatient")
				|| method.getName().equals("voidPatient")) {
			Patient patient = (Patient)args[0];

			UsageLog.logEvent(patient, usageType, null);
		}
     }

}


