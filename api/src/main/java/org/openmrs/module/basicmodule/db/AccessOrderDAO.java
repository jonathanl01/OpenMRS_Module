/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openmrs.module.basicmodule.db;

import java.util.List;
import org.openmrs.Patient;
import org.openmrs.module.basicmodule.AccessOrder;
import org.openmrs.module.basicmodule.Note;

/**
 *
 * @author anthony
 */
/**
 * This is the DAO interface. This is never used by the developer, but instead
 * the {@link NoteService} calls it (and developers call the NoteService)
 */
public interface AccessOrderDAO {

   AccessOrder getAccessOrder(Integer id);
   
   AccessOrder saveAccessOrder(AccessOrder accessOrder);
   
   
	//Note getNote(Integer id);

	//Note getNoteByUuid(String uuid);

	//List<Note> getNotes(Patient patient);

	//Note saveNote(Note note);

}
