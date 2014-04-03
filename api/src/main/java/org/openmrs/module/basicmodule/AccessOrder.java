/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.openmrs.module.basicmodule;

import java.sql.Date;

/**
 *
 * @author anthony
 */
public class AccessOrder {

   protected Integer id;
   protected Date date;
   protected Integer order_id;
   protected char view_edited;
   protected Integer user_id;
   protected Integer patient_id;
   protected Integer location_id;

   public AccessOrder() {}
   public AccessOrder(Date datetime, Integer order_id, char view_edited,
           Integer user_id, Integer patient_id, Integer location_id) {
      this.date = datetime;
      this.order_id = order_id;
      this.user_id = user_id;
      this.patient_id = patient_id;
      this.location_id = location_id;
   }
   
   public Integer getId(){return this.id;}
   public void setId(Integer id){ this.id = id; }
   
   public Date getDatetime() { return this.date; }
   public void setDatetime( Date datetime) { this.date = datetime; }
   
   public Integer getOrder_id() { return this.order_id; }
   public void setOrder_id(Integer order_id) { this.order_id = order_id; }
   
   public Integer getUser_id() { return this.user_id; }
   public void setUser_id(Integer user_id) { this.user_id = user_id; }
   
   public Integer getPatient_id() { return this.patient_id; }
   public void setPatient_id(Integer patient_id) { this.patient_id = patient_id; }
   
   public Integer getLocation_id() { return this.location_id; }
   public void setLocation_iud(Integer location_id) { this.location_id = location_id; }
}
 