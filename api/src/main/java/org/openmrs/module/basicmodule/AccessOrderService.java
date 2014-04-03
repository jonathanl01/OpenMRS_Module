/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.basicmodule;

import org.openmrs.api.OpenmrsService;

/**
 *
 * @author jonathan
 */
public interface AccessOrderService extends OpenmrsService {

    public AccessOrder getAccessOrder(Integer id);
    
    public AccessOrder saveAccessOrder(AccessOrder accessOrder);

}
