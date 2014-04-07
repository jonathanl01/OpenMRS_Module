/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openmrs.module.basicmodule.db.hibernate;

import org.hibernate.SessionFactory;
import org.openmrs.module.basicmodule.AccessPatient;
import org.openmrs.module.basicmodule.db.AccessPatientDAO;

/**
 *
 * @author Ye
 */
public class HibernateAccessPatientDAO implements AccessPatientDAO {
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

   public AccessPatient getAccessPatient(Integer id) {
      return (AccessPatient) sessionFactory.getCurrentSession().get(AccessPatient.class, id);
   }

   public void saveAccessPatient(AccessPatient accessPatient) {
		sessionFactory.getCurrentSession().saveOrUpdate(accessPatient);
		
      //return accessPatient;
   }
   
}