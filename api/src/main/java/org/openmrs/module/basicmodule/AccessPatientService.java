/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openmrs.module.basicmodule;

import org.openmrs.api.APIException;
import org.openmrs.api.OpenmrsService;

/**
 *
 * @author Ye
 */
public interface AccessPatientService extends OpenmrsService{
    
    public AccessPatient getAccessPatient(Integer id);
    
    public void saveAccessPatient(AccessPatient accessPatient)throws APIException;    
}
