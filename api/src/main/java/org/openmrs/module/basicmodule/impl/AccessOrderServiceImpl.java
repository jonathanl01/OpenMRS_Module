package org.openmrs.module.basicmodule.impl;

import java.util.List;

import org.openmrs.Patient;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.basicmodule.AccessOrder;
import org.openmrs.module.basicmodule.AccessOrderService;
import org.openmrs.module.basicmodule.Note;
import org.openmrs.module.basicmodule.NoteService;
import org.openmrs.module.basicmodule.db.AccessOrderDAO;
import org.openmrs.module.basicmodule.db.NoteDAO;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of our {@link NoteService} interface. This class is set in the
 * /metadata/moduleApplicationContext.xml file to be matched to the
 * {@link NoteService} interface. <br/>
 * <br/>
 * This class extends {@link BaseOpenmrsService} so that there are empty methods
 * for onStartup and onShutdown. This allows sheilds us from changes to the
 * OpenmrsService interface from forcing us to implement the methods. <br/>
 * <br/>
 * NEVER call "new NoteServiceImpl()....". To use this class, you do: <br/>
 * <code>
 *   
 *   Context.getService(NoteService.class).saveNote(note)...
 *   
 * </code>
 * 
 */
public class AccessOrderServiceImpl extends BaseOpenmrsService implements AccessOrderService {

	/**
	 * This "dao" object is set by spring. See the
	 * /metadata/moduleApplicationContext.xml for what value gets set here. We
	 * can assume that this will never be null, even though it never gets set in
	 * here. This is called Inversion of Control (IoC)
	 */
	private AccessOrderDAO dao;

	/**
	 * This is the method that spring calls to set the DAO
	 * 
	 * @param dao the dao to set
	 */
	public void setDao(AccessOrderDAO dao) {
		this.dao = dao;
	}

	/**
    * @param id
    * @return 
	 * @see org.openmrs.module.patientnotes.NoteService#getNote(java.lang.Integer)
	 */
	@Transactional(readOnly = true)
	public AccessOrder getAccessOrder(Integer id) {
		return dao.getAccessOrder(id);
	}
//
//	@Transactional(readOnly = true)
//	public Note getNoteByUuid(String uuid) {
//		return dao.getNoteByUuid(uuid);
//	}
//
//	@Transactional(readOnly = true)
//	public List<Note> getNotesByPatient(Patient patient) {
//		return dao.getNotes(patient);
//	}

	@Transactional
	public AccessOrder saveAccessOrder(AccessOrder accessOrder) {
		return dao.saveAccessOrder(accessOrder);
	}

}

