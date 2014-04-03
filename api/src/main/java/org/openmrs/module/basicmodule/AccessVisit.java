/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openmrs.module.basicmodule;

import java.sql.Date;

/**
 *
 * @author jonathan
 */
public class AccessVisit {
    
    protected Date date;
    protected char viewed_edited;
    protected Integer visit_id;
    protected Integer user_id;
    protected Integer patient_id;
    protected Integer location_id;
    
    //Default constructor
    public AccessVisit(Date date, char viewed_edited, Integer visit_id,
            Integer user_id, Integer patient_id, Integer location_id){
        this.date = date;
        this.viewed_edited = viewed_edited;
        this.visit_id = visit_id;
        this.user_id = user_id;
        this.patient_id = patient_id;
        this.location_id = location_id;
    }
    
    public Date getDate(){
        return date;
    }
    
    public char getViewedEdited(){
        return viewed_edited;
    }
    
    public Integer getVisitID(){
        return visit_id;
    }
    
    public Integer getUserID(){
        return user_id;
    }
    
    public Integer getPatientID(){
        return patient_id;
    }
    
    public Integer getLocationID(){
        return location_id;
    }
}
