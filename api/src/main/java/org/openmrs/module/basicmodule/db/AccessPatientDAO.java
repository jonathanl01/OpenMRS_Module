/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openmrs.module.basicmodule.db;

import java.util.List;
import org.openmrs.Patient;
import org.openmrs.api.db.DAOException;
import org.openmrs.module.basicmodule.AccessOrder;
import org.openmrs.module.basicmodule.AccessPatient;

/**
 *
 * @author Ye
 */
/**
 * This is the DAO interface. This is never used by the developer, but instead
 * the {@link NoteService} calls it (and developers call the NoteService)
 */
public interface AccessPatientDAO {

   public AccessPatient getAccessPatient(Integer id);
   
   public void saveAccessPatient(AccessPatient accessPatient)throws DAOException;


}

