/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.openmrs.module.basicmodule;

import java.util.Date;
import org.openmrs.User;

/**
 *
 * @author Ye
 */
public class AccessPatient{
    
    protected Integer id;
    protected Date date;
    protected char viewed_edited;
    protected Integer encounter_id;
    protected Integer user_id;
    protected Integer patient_id;
    protected Integer location_id;
    
    //Default constructor
    public AccessPatient(){
        
    }
   
    
    public Integer getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public Date getDate(){
        return date;
    }
    
    public void setDate(Date date){
        this.date = date;
    }
    
    public char getViewed_edited(){
        return viewed_edited;
    }
    
    public void setViewed_edited(char viewed_edited){
        this.viewed_edited = viewed_edited;
    }
    
    public Integer getEncounter_id(){
        return encounter_id;
    }
    
    public void setEncounter_id(Integer encounter_id){
        this.encounter_id = encounter_id;
    }
    
    public Integer getUser_id(){
        return user_id;
    }
    
    public void setUser_id(Integer user_id){
        this.user_id = user_id;
    }
    
    public Integer getPatient_id(){
        return patient_id;
    }
    
    public void setPatient_id(Integer patient_id){
        this.patient_id = patient_id;
    }
    
    public Integer getLocation_id(){
        return location_id;
    }
    
    public void setLocation_id(Integer location_id){
        this.location_id = location_id;
    }
}

