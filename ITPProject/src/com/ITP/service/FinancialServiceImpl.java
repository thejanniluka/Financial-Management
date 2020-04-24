package com.ITP.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.ITP.model.Financial;
import com.ITP.util.CommonConstants;
import com.ITP.util.CommonUtil;
import com.ITP.util.DBConnectionUtil;
import com.ITP.util.QueryUtil;

public class FinancialServiceImpl implements IFinancialService {
	

	public static final Logger log = Logger.getLogger(FinancialServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;

	static{
		
		createEmployeeTable();
	}

	private PreparedStatement preparedStatement;

	public static void createEmployeeTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();
			
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_DROP_TABLE));
		
			statement.executeUpdate(QueryUtil.queryByID(CommonConstants.QUERY_ID_CREATE_TABLE));

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}
	@Override
	public void addFinancial(Financial financial) {

		String MonthID = CommonUtil.generateIDs(getFinancailIDs());
		
		try {
			connection = DBConnectionUtil.getDBConnection();
		
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_INSERT_FINANCIALS));
			connection.setAutoCommit(false);
			
			//Generate financial IDs
			financial.setMonthID(MonthID);
			preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, financial.getMonthID());
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_TWO, financial.getPhoneCost());
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_THREE, financial.getWaterCost());
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_FOUR, financial.getTransportCost());
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_FIVE, financial.getExpensesCost());
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_SIX, financial.getIncome());
			preparedStatement.setInt(CommonConstants.COLUMN_INDEX_SEVEN, financial.getNetProfit());
			// Add financial
			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}

	@Override
	public Financial getFinancialByID(String MonthID) {

		return actionOnFinancial(MonthID).get(0);
	}

	@Override
	public ArrayList<Financial> getFinancials() {
		
		return actionOnFinancial(null);
	}

	@Override
	public void removeFinancial(String MonthID) {

		// Before deleting check whether financial ID is available
		if (MonthID != null && !MonthID.isEmpty()) {
			/*
			 * Remove financial query will be retrieved from EmployeeQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_REMOVE_FINANCIAL));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, MonthID );
				preparedStatement.executeUpdate();
			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
	}

	private ArrayList<Financial> actionOnFinancial(String MonthID) {

		ArrayList<Financial> financialList = new ArrayList<Financial>();
		try {
			connection = DBConnectionUtil.getDBConnection();
			/*
			 * Before fetching financial it checks whether financial ID is
			 * available
			 */
			if (MonthID != null && !MonthID.isEmpty()) {
				/*
				 * Get financial by ID query will be retrieved from
				 * EmployeeQuery.xml
				 */
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_FINANCIAL));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, MonthID);
			}
			/*
			 * If financial ID is not provided for get financial option it display
			 * all financials
			 */
			else {
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_ALL_FINANCIALS));
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Financial financial = new Financial();
				financial.setMonthID(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
				financial.setPhoneCost(resultSet.getInt(CommonConstants.COLUMN_INDEX_TWO));
				financial.setWaterCost(resultSet.getInt(CommonConstants.COLUMN_INDEX_THREE));
				financial.setTransportCost(resultSet.getInt(CommonConstants.COLUMN_INDEX_FOUR));
				financial.setExpensesCost(resultSet.getInt(CommonConstants.COLUMN_INDEX_FIVE));
				financial.setIncome(resultSet.getInt(CommonConstants.COLUMN_INDEX_SIX));
				financial.setNetProfit(resultSet.getInt(CommonConstants.COLUMN_INDEX_SEVEN));
				financialList.add(financial);
			}

		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return financialList;
	}

	@Override
	public Financial updateFinancial(String MonthID, Financial financial) {

		/*
		 * Before fetching financial it checks whether financial ID is available
		 */
		if (MonthID != null && !MonthID.isEmpty()) {
			/*
			 * Update financial query will be retrieved from EmployeeQuery.xml
			 */
			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection
						.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_UPDATE_FINANCIAL));
				preparedStatement.setString(CommonConstants.COLUMN_INDEX_ONE, financial.getMonthID());
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_TWO, financial.getPhoneCost());
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_THREE, financial.getWaterCost());
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_FOUR, financial.getTransportCost());
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_FIVE, financial.getExpensesCost());
				preparedStatement.setInt(CommonConstants.COLUMN_INDEX_SEVEN, financial.getNetProfit());
				preparedStatement.executeUpdate();

			} catch (SQLException | SAXException | IOException | ParserConfigurationException
					| ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end
				 * of transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		// Get the updated financial
		return getFinancialByID(MonthID);
	}

	private ArrayList<String> getFinancailIDs(){
		
		ArrayList<String> arrayList = new ArrayList<String>();
		/*
		 * List of financial IDs will be retrieved from EmployeeQuery.xml
		 */
		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection
					.prepareStatement(QueryUtil.queryByID(CommonConstants.QUERY_ID_GET_FINANCIAL_IDS));
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(CommonConstants.COLUMN_INDEX_ONE));
			}
		} catch (SQLException | SAXException | IOException | ParserConfigurationException
				| ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return arrayList;
	}
}
