package com.ITP.service;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactoryConfigurationError;

import com.ITP.model.Financial;

public interface IFinancialService {

	public static final Logger log = Logger.getLogger(IFinancialService.class.getName());



	public void addFinancial(Financial financial);


	public Financial getFinancialByID(String monthID);
	

	public ArrayList<Financial> getFinancials();
	

	public Financial updateFinancial(String MonthID, Financial financial);


	public void removeFinancial(String MonthID);

}
