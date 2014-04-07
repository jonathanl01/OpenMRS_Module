package org.openmrs.module.basicmodule.advice;

/**
 * author: Ye
 */

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.Encounter;
import org.openmrs.api.context.Context;
import org.openmrs.module.basicmodule.AccessPatientService;
import org.openmrs.module.basicmodule.UsageLog;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

/**
 * AOP class used to intercept and log calls to EncounterService methods
 */
public class EncounterServiceAdvice implements MethodBeforeAdvice, AfterReturningAdvice {

	protected static final Log log = LogFactory.getLog(EncounterServiceAdvice.class);
        
        protected UsageLog.Type usageType;
	
    public void before(Method method, Object[] args, Object target) throws Throwable {
		if (method.getName().equals("saveEncounter") ) {
			Encounter encounter = (Encounter)args[0];
			usageType = UsageLog.Type.UPDATED;
			
			if (encounter.getEncounterId() == null)
				usageType = UsageLog.Type.CREATED;
			else if (encounter.isVoided()) {
				AccessPatientService svc = (AccessPatientService)Context.getService(AccessPatientService.class);
				// Patient object is voided, but check database record
				//if (!svc.isPatientVoidedInDatabase(patient))
					//usageType = UsageLog.Type.VOIDED;
			}			
		}

		else if (method.getName().equals("voidEncounter"))
			usageType = UsageLog.Type.VOIDED;
        }

        
        
        
        /**
	 * @see org.springframework.aop.AfterReturningAdvice#afterReturning(Object, Method, Object[], Object)
	 */
	public void afterReturning(Object returnVal, Method method, Object[] args, Object target) throws Throwable {
		if (method.getName().equals("saveEncounter")) {
			
			Encounter encounter = (Encounter)args[0];
			
			UsageLog.logEvent(encounter,usageType);
		}
	}
}
