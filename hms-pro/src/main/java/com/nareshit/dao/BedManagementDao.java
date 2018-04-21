package com.nareshit.dao;

import com.nareshit.domain.Bed;
import com.nareshit.domain.BedCategory;
import com.nareshit.domain.Patient;

public interface BedManagementDao {

	public Bed addBed(Bed bd);
	public BedCategory addBedCategory(BedCategory bdc);
	public Bed mapBedIntoCategory(int catId, int bedId);
	public Bed unMapBedIntoCategory(int catId, int bedId);
	
	/**
	 * Doctor or Nurse will assign a bed to the Patient
	 * if and only if the patient is in-patient and 
	 * the beds are avaialble
	 * @param bedId
	 * @param patId
	 * @return
	 */
	public Patient assignBedToPatient(int bedId, int patId);
	Bed getBedById(int bedId);
	BedCategory getBedTypeByCatId(int bdCatId);
	Patient unAssignBedToPatient(int bedId, int patId);
	Bed doBedAvailable(Bed b);
}
