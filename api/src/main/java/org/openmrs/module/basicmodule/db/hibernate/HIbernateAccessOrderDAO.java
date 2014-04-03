/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openmrs.module.basicmodule.db.hibernate;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.openmrs.Patient;
import org.openmrs.module.basicmodule.AccessOrder;
import org.openmrs.module.basicmodule.Note;
import org.openmrs.module.basicmodule.db.AccessOrderDAO;
import org.openmrs.module.basicmodule.db.NoteDAO;

/**
 *
 * @author anthony
 */
public class HIbernateAccessOrderDAO implements AccessOrderDAO {
   private SessionFactory sessionFactory;

	/**
	 * This is a Hibernate object. It gives us metadata about the currently
	 * connected database, the current session, the current db user, etc. To
	 * save and get objects, calls should go through
	 * sessionFactory.getCurrentSession() <br/>
	 * <br/>
	 * This is called by Spring. See the /metadata/moduleApplicationContext.xml
	 * for the "sessionFactory" setting. See the applicationContext-service.xml
	 * file in CORE openmrs for where the actual "sessionFactory" object is
	 * first defined.
	 * 
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

   public AccessOrder getAccessOrder(Integer id) {
      return (AccessOrder) sessionFactory.getCurrentSession().get(AccessOrder.class, id);
   }

   public AccessOrder saveAccessOrder(AccessOrder accessOrder) {
		sessionFactory.getCurrentSession().saveOrUpdate(accessOrder);
		
      return accessOrder;
   }
   
}
