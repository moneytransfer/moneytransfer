package com.etl.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

import com.etl.util.MYSQLConnection;
import com.etl.util.MYSQLHelper;

public class AgentDetails {

	public int AgentId;
	public int CompanyId;
	public String AgentFirstName;
	public String SecondName;
	public String AgentLastName;
	public String SecondLastName;
	public int CountryId;
	public String SuperAgent;
	public String Phone;
	public String AgentCode;
	public String Email;
	public String SerialNumberPrefix;
	public String Address1;
	public String Address2;
	public String SerialNumberLength;
	public String City;
	public String PostalCode;
	public boolean BureauDeChange;
	public boolean IsAllowedCreateAgent;
	public boolean AllowedCasiherTellerApproval;
	public boolean ApproveeachTransByCashierTeller;
	public boolean CreateComplianceGroup;
	public boolean AssignAdminToAgent;

	public String CreatedDate;

	public boolean IsActive;
	public boolean IsDeleted;

	public String DeletedDate;
	public String Result;
	public String Error;

	private void setAgentId(int AgentId) {
		this.AgentId = AgentId;
	}

	private int getAgentId() {
		return AgentId;
	}

	private void setCompanyId(int CompanyId) {
		this.CompanyId = CompanyId;
	}

	private int getCompanyId() {
		return CompanyId;
	}

	private void setcountryId(int CountryId) {
		this.CountryId = CountryId;
	}

	private int getcountryId() {
		return CountryId;
	}
	
	private void setSecondName(String SecondName) {
		this.SecondName = SecondName;
	}

	private String getSecondName() {
		return SecondName;
	}
	private void setAgentLastName(String AgentLastName) {
		this.AgentLastName = AgentLastName;
	}

	private String getAgentLastName() {
		return AgentLastName;
	}
	
	private void setAgentFirstName(String AgentFirstName) {
		this.AgentFirstName = AgentFirstName;
	}

	private String getAgentName() {
		return AgentFirstName;
	}
	
	private void setSecondLastName(String SecondLastName) {
		this.SecondLastName = SecondLastName;
	}

	private String getSecondLastName() {
		return SecondLastName;
	}
	
	private void setSuperAgent(String SuperAgent) {
		this.SuperAgent = SuperAgent;
	}

	private String getSuperAgent() {
		return SuperAgent;
	}

	private void setPhone(String Phone) {
		this.Phone = Phone;
	}

	private String getPhone() {
		return Phone;
	}

	private void setAgentCode(String AgentCode) {
		this.AgentCode = AgentCode;
	}

	private String getAgentCode() {
		return AgentCode;
	}

	private void setEmail(String Email) {
		this.Email = Email;
	}

	private String getEmail() {
		return Email;
	}

	private void setSerialNumberPrefix(String SerialNumberPrefix) {
		this.SerialNumberPrefix = SerialNumberPrefix;
	}

	private String getSerialNumberPrefix() {
		return SerialNumberPrefix;
	}

	private void setAddress1(String Address1) {
		this.Address1 = Address1;
	}

	private String getAddress1() {
		return Address1;
	}

	private void setAddress2(String Address2) {
		this.Address2 = Address2;
	}

	private String getAddress2() {
		return Address2;
	}

	private void setSerialNumberLength(String SerialNumberLength) {
		this.SerialNumberLength = SerialNumberLength;
	}

	private String getSerialNumberLength() {
		return SerialNumberLength;
	}

	private void setCity(String City) {
		this.City = City;
	}

	private String getCity() {
		return City;
	}

	private void setPostalCode(String PostalCode) {
		this.PostalCode = PostalCode;
	}

	private String getPostalCode() {
		return PostalCode;
	}

	private void setBureauDeChange(boolean BureauDeChange) {
		this.BureauDeChange = BureauDeChange;
	}

	private boolean getBureauDeChange() {
		return BureauDeChange;
	}

	private void setIsAllowedCreateAgent(boolean IsAllowedCreateAgent) {
		this.IsAllowedCreateAgent = IsAllowedCreateAgent;
	}

	private boolean getIsAllowedCreateAgent() {
		return IsAllowedCreateAgent;
	}

	private void setAllowedCasiherTellerApproval(boolean AllowedCasiherTellerApproval) {
		this.AllowedCasiherTellerApproval = AllowedCasiherTellerApproval;
	}

	private boolean getAllowedCasiherTellerApproval() {
		return AllowedCasiherTellerApproval;
	}

	private void setApproveeachTransByCashierTeller(boolean ApproveeachTransByCashierTeller) {
		this.ApproveeachTransByCashierTeller = ApproveeachTransByCashierTeller;
	}

	private boolean getApproveeachTransByCashierTeller() {
		return ApproveeachTransByCashierTeller;
	}

	private void setCreateComplianceGroup(boolean CreateComplianceGroup) {
		this.CreateComplianceGroup = CreateComplianceGroup;
	}

	private boolean getCreateComplianceGroup() {
		return CreateComplianceGroup;
	}

	private void setAssignAdminToAgent(boolean AssignAdminToAgent) {
		this.AssignAdminToAgent = AssignAdminToAgent;
	}

	private boolean getAssignAdminToAgent() {
		return ApproveeachTransByCashierTeller;
	}

	private void setIsActive(boolean IsActive) {
		this.IsActive = IsActive;
	}

	private boolean getIsActive() {
		return IsActive;
	}

	private void setIsDeleted(boolean IsDeleted) {
		this.IsDeleted = IsDeleted;
	}

	private boolean getIsDeleted() {
		return IsDeleted;
	}

	private void setCreatedDate(String CreatedDate) {
		this.CreatedDate = CreatedDate;
	}

	private String getCreatedDate() {
		return CreatedDate;
	}

	private void setDeletedDate(String DeletedDate) {
		this.DeletedDate = DeletedDate;
	}

	private String getDeletedDate() {
		return DeletedDate;
	}

	private void setResult(String Result) {
		this.Result = Result;
	}

	private String getResult() {
		return Result;
	}

	private void setError(String Error) {
		this.Error = Error;
	}

	private String getError() {
		return Error;
	}

	public AgentDetails addeditAgentDetails(AgentDetails _AgentDetails) {
		Connection _Connection = MYSQLConnection.GetConnection();
		PreparedStatement _PreparedStatement = null;
		try {
			MYSQLHelper _MYSQLHelper = new MYSQLHelper();
			if (_Connection != null) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Calendar cal = Calendar.getInstance();
				String date = format.format(cal.getTime());
				_AgentDetails.setCreatedDate(date);

				ResultSet _ResultSetcompany = _MYSQLHelper.GetResultSet(
						"SELECT * FROM company where Company_Id='" + _AgentDetails.CompanyId + "'", _Connection);
				if (_ResultSetcompany.next()) {

					ResultSet _ResultSetSourceCountry = _MYSQLHelper.GetResultSet(
							"SELECT * FROM country where country_id='" + _AgentDetails.CountryId + "'", _Connection);
					if (_ResultSetSourceCountry.next()) {

						if (_AgentDetails.AgentId <= 0) {

							int Resultlastid = addAgent(_AgentDetails);
							_AgentDetails.setResult("Success");
							_AgentDetails.setAgentId(Resultlastid);
						} else {
							ResultSet _ResultAgent = _MYSQLHelper.GetResultSet(
									"SELECT AgentId FROM agent where AgentId='" + _AgentDetails.AgentId + "'",
									_Connection);
							if (_ResultAgent.next()) {
								updateAgent(_AgentDetails);
								_AgentDetails.setResult("Success");
							} else {
								_AgentDetails.setResult("Failed!");
								_AgentDetails.setError("Invalid Agent Id !");
								_AgentDetails.setAgentId(_AgentDetails.AgentId);

							}
						}
					} else {
						_AgentDetails.setResult("Failed!");
						_AgentDetails.setError("Invalid Country Id !");

					}
				} else {
					_AgentDetails.setResult("Failed!");
					_AgentDetails.setError("Invalid Company Id !");

				}
			} else {
				_AgentDetails.setResult("Failed!");
				_AgentDetails.setError("Error in api backend connectivity !");

			}

		} catch (Exception e) {

		} finally {
			clear(_AgentDetails);
			if (_Connection != null) {
				try {
					_Connection.close();
				} catch (SQLException ex) {

					clear(_AgentDetails);
				}
			}
		}

		return _AgentDetails;
	}

	public static ArrayList<AgentDetails> getAgentDetails(int Id) {
		Connection _Connection = MYSQLConnection.GetConnection();

		ArrayList<AgentDetails> _AgentDetailsDetaillist = new ArrayList<AgentDetails>();

		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		try {

			if (_Connection != null)

			{

				ResultSet _ResultSet = _MYSQLHelper
						.GetResultSet("SELECT * FROM agent where AgentId='" + Id + "' and IsDeleted=0", _Connection);

				while (_ResultSet.next()) {
					AgentDetails _AgentDetails = new AgentDetails();

					_AgentDetails.setAgentId(_ResultSet.getInt("AgentId"));
					_AgentDetails.setCompanyId(_ResultSet.getInt("Company_Id"));
					_AgentDetails.setAgentCode(_ResultSet.getString("AgentCode"));
					_AgentDetails.setSecondName(_ResultSet.getString("SecondName"));
					_AgentDetails.setAgentFirstName(_ResultSet.getString("AgentFirstName"));
					_AgentDetails.setSecondLastName(_ResultSet.getString("SecondLastName"));
					_AgentDetails.setAgentLastName(_ResultSet.getString("AgentLastName"));
					_AgentDetails.setSuperAgent(_ResultSet.getString("SuperAgent"));
					_AgentDetails.setPhone(_ResultSet.getString("Phone"));
					_AgentDetails.setEmail(_ResultSet.getString("Email"));
					_AgentDetails.setcountryId(_ResultSet.getInt("country_id"));
					_AgentDetails.setSerialNumberPrefix(_ResultSet.getString("SerialNumberPrefix"));
					_AgentDetails.setAddress1(_ResultSet.getString("Address1"));
					_AgentDetails.setAddress2(_ResultSet.getString("Address2"));
					_AgentDetails.setSerialNumberLength(_ResultSet.getString("SerialNumberLength"));
					_AgentDetails.setCity(_ResultSet.getString("City"));
					_AgentDetails.setPostalCode(_ResultSet.getString("PostalCode"));
					_AgentDetails.setBureauDeChange(_ResultSet.getBoolean("BureauDeChange"));
					_AgentDetails.setIsAllowedCreateAgent(_ResultSet.getBoolean("IsAllowedCreateAgent"));
					_AgentDetails.setApproveeachTransByCashierTeller(
							_ResultSet.getBoolean("ApproveeachTransByCashierTeller"));
					_AgentDetails
							.setAllowedCasiherTellerApproval(_ResultSet.getBoolean("AllowedCasiherTellerApproval"));
					_AgentDetails.setCreateComplianceGroup(_ResultSet.getBoolean("CreateComplianceGroup"));
					_AgentDetails.setAssignAdminToAgent(_ResultSet.getBoolean("AssignAdminToAgent"));
					_AgentDetails.setCreatedDate(_ResultSet.getString("CreatedDate"));
					_AgentDetails.setIsActive(_ResultSet.getBoolean("IsActive"));
					_AgentDetails.setIsDeleted(_ResultSet.getBoolean("IsDeleted"));
					_AgentDetails.setDeletedDate(_ResultSet.getString("DeletedDate"));
					_AgentDetails.setResult("Sucess");
					_AgentDetailsDetaillist.add(_AgentDetails);

				}
				_ResultSet.close();

			}

		} catch (Exception e) {
			// clear(_AgentDetails);
		} finally {

			if (_Connection != null) {
				try {
					_Connection.close();
				} catch (SQLException e) {
					// clear(_AgentDetails);
				}
			}
		}

		return _AgentDetailsDetaillist;
	}
	
	
	
	
	public static ArrayList<AgentDetails> getAgentDetailsByCompanyId(int Id) {
		Connection _Connection = MYSQLConnection.GetConnection();

		ArrayList<AgentDetails> _AgentDetailsDetaillist = new ArrayList<AgentDetails>();

		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		try {

			if (_Connection != null)

			{

				ResultSet _ResultSet = _MYSQLHelper
						.GetResultSet("SELECT * FROM agent where Company_Id='" + Id + "'and IsDeleted=0", _Connection);

				while (_ResultSet.next()) {
					AgentDetails _AgentDetails = new AgentDetails();

					_AgentDetails.setAgentId(_ResultSet.getInt("AgentId"));
					_AgentDetails.setCompanyId(_ResultSet.getInt("Company_Id"));
					_AgentDetails.setAgentCode(_ResultSet.getString("AgentCode"));
					_AgentDetails.setSecondName(_ResultSet.getString("SecondName"));
					_AgentDetails.setAgentFirstName(_ResultSet.getString("AgentFirstName"));
					_AgentDetails.setSecondLastName(_ResultSet.getString("SecondLastName"));
					_AgentDetails.setAgentLastName(_ResultSet.getString("AgentLastName"));
					_AgentDetails.setSuperAgent(_ResultSet.getString("SuperAgent"));
					_AgentDetails.setPhone(_ResultSet.getString("Phone"));
					_AgentDetails.setEmail(_ResultSet.getString("Email"));
					_AgentDetails.setcountryId(_ResultSet.getInt("country_id"));
					_AgentDetails.setSerialNumberPrefix(_ResultSet.getString("SerialNumberPrefix"));
					_AgentDetails.setAddress1(_ResultSet.getString("Address1"));
					_AgentDetails.setAddress2(_ResultSet.getString("Address2"));
					_AgentDetails.setSerialNumberLength(_ResultSet.getString("SerialNumberLength"));
					_AgentDetails.setCity(_ResultSet.getString("City"));
					_AgentDetails.setPostalCode(_ResultSet.getString("PostalCode"));
					_AgentDetails.setBureauDeChange(_ResultSet.getBoolean("BureauDeChange"));
					_AgentDetails.setIsAllowedCreateAgent(_ResultSet.getBoolean("IsAllowedCreateAgent"));
					_AgentDetails.setApproveeachTransByCashierTeller(
							_ResultSet.getBoolean("ApproveeachTransByCashierTeller"));
					_AgentDetails
							.setAllowedCasiherTellerApproval(_ResultSet.getBoolean("AllowedCasiherTellerApproval"));
					_AgentDetails.setCreateComplianceGroup(_ResultSet.getBoolean("CreateComplianceGroup"));
					_AgentDetails.setAssignAdminToAgent(_ResultSet.getBoolean("AssignAdminToAgent"));
					_AgentDetails.setCreatedDate(_ResultSet.getString("CreatedDate"));
					_AgentDetails.setIsActive(_ResultSet.getBoolean("IsActive"));
					_AgentDetails.setIsDeleted(_ResultSet.getBoolean("IsDeleted"));
					_AgentDetails.setDeletedDate(_ResultSet.getString("DeletedDate"));
					_AgentDetails.setResult("Sucess");
					_AgentDetailsDetaillist.add(_AgentDetails);

				}
				_ResultSet.close();

			}

		} catch (Exception e) {
			// clear(_AgentDetails);
		} finally {

			if (_Connection != null) {
				try {
					_Connection.close();
				} catch (SQLException e) {
					// clear(_AgentDetails);
				}
			}
		}

		return _AgentDetailsDetaillist;
	}

	public int addAgent(AgentDetails _AgentDetails) {
		int Result = 0;

		Connection _Connection = MYSQLConnection.GetConnection();
		try {
			Random rand = new Random();
			String uniqueID = String.format("%04d", rand.nextInt(10000));

			_AgentDetails.setAgentCode(uniqueID);
			PreparedStatement _PreparedStatement = null;
			MYSQLHelper _MYSQLHelper = new MYSQLHelper();
			String sInsertStatement = "INSERT INTO agent( AgentFirstName,SecondName,AgentLastName,SecondLastName, Company_Id,country_id,SuperAgent,Phone, AgentCode,Email,SerialNumberPrefix,Address1,Address2,SerialNumberLength,City,PostalCode,BureauDeChange,IsAllowedCreateAgent,AllowedCasiherTellerApproval,ApproveeachTransByCashierTeller,CreateComplianceGroup,AssignAdminToAgent,CreatedDate,IsActive)";
			sInsertStatement = sInsertStatement + " VALUES(?, ?, ?,?, ?, ?,?, ?, ?,?,?, ?, ?,?, ?, ?,?, ?, ?,?,?,?,?,?)";
			_PreparedStatement = _Connection.prepareStatement(sInsertStatement);
			_PreparedStatement.setString(1, _AgentDetails.AgentFirstName);
			_PreparedStatement.setString(2, _AgentDetails.SecondName);
			
			_PreparedStatement.setString(3, _AgentDetails.AgentLastName);
			_PreparedStatement.setString(4, _AgentDetails.SecondLastName);
			
			
			_PreparedStatement.setInt(5, _AgentDetails.CompanyId);
			_PreparedStatement.setInt(6, _AgentDetails.CountryId);
			_PreparedStatement.setString(7, _AgentDetails.SuperAgent);
			_PreparedStatement.setString(8, _AgentDetails.Phone);
			_PreparedStatement.setString(9, _AgentDetails.AgentCode);
			_PreparedStatement.setString(10, _AgentDetails.Email);
			_PreparedStatement.setString(11, _AgentDetails.SerialNumberPrefix);
			_PreparedStatement.setString(12, _AgentDetails.Address1);
			_PreparedStatement.setString(13, _AgentDetails.Address2);
			_PreparedStatement.setString(14, _AgentDetails.SerialNumberLength);
			_PreparedStatement.setString(15, _AgentDetails.City);
			_PreparedStatement.setString(16, _AgentDetails.PostalCode);
			_PreparedStatement.setBoolean(17, _AgentDetails.BureauDeChange);
			_PreparedStatement.setBoolean(18, _AgentDetails.IsAllowedCreateAgent);
			_PreparedStatement.setBoolean(19, _AgentDetails.AllowedCasiherTellerApproval);
			_PreparedStatement.setBoolean(20, _AgentDetails.ApproveeachTransByCashierTeller);
			_PreparedStatement.setBoolean(21, _AgentDetails.CreateComplianceGroup);
			_PreparedStatement.setBoolean(22, _AgentDetails.AssignAdminToAgent);
			_PreparedStatement.setString(23, _AgentDetails.CreatedDate);
			_PreparedStatement.setBoolean(24, true);
			_PreparedStatement.executeUpdate();

			ResultSet _ResultSetbillpayld = _MYSQLHelper.GetResultSet("SELECT MAX(AgentId) AS AgentId FROM agent",
					_Connection);
			if (_ResultSetbillpayld.next()) {
				int lastid = _ResultSetbillpayld.getInt("AgentId");
				Result = lastid;
			}
		} catch (Exception e) {

		} finally {

		}

		return Result;

	}

	public void updateAgent(AgentDetails _AgentDetails) {

		Connection _Connection = MYSQLConnection.GetConnection();
		try {
			PreparedStatement _PreparedStatement = null;

			String sInsertStatement = "UPDATE agent SET AgentFirstName = ?,SecondName = ?,AgentLastName = ?,SecondLastName = ?,Company_Id = ? ,country_id =?,SuperAgent = ? ,Phone =?,Email = ?,SerialNumberPrefix = ?,Address1 = ?,Address2 = ?,SerialNumberLength = ?,City = ?,PostalCode = ?,BureauDeChange = ?,IsAllowedCreateAgent = ?,AllowedCasiherTellerApproval = ?,ApproveeachTransByCashierTeller = ?,CreateComplianceGroup = ?,AssignAdminToAgent = ?,CreatedDate = ?,IsActive = ? "
					+ " WHERE AgentId = ?";
			_PreparedStatement = _Connection.prepareStatement(sInsertStatement);
			_PreparedStatement.setString(1, _AgentDetails.AgentFirstName);
			_PreparedStatement.setString(2, _AgentDetails.SecondName);
			
			
			_PreparedStatement.setString(3, _AgentDetails.AgentLastName);
			_PreparedStatement.setString(4, _AgentDetails.SecondLastName);
			
			
			_PreparedStatement.setInt(5, _AgentDetails.CompanyId);
			_PreparedStatement.setInt(6, _AgentDetails.CountryId);
			_PreparedStatement.setString(7, _AgentDetails.SuperAgent);
			_PreparedStatement.setString(8, _AgentDetails.Phone);
			_PreparedStatement.setString(9, _AgentDetails.Email);
			_PreparedStatement.setString(10, _AgentDetails.SerialNumberPrefix);
			_PreparedStatement.setString(11, _AgentDetails.Address1);
			_PreparedStatement.setString(12, _AgentDetails.Address2);
			_PreparedStatement.setString(13, _AgentDetails.SerialNumberLength);
			_PreparedStatement.setString(14, _AgentDetails.City);
			_PreparedStatement.setString(15, _AgentDetails.PostalCode);
			_PreparedStatement.setBoolean(16, _AgentDetails.BureauDeChange);
			_PreparedStatement.setBoolean(17, _AgentDetails.IsAllowedCreateAgent);
			_PreparedStatement.setBoolean(18, _AgentDetails.AllowedCasiherTellerApproval);
			_PreparedStatement.setBoolean(19, _AgentDetails.ApproveeachTransByCashierTeller);
			_PreparedStatement.setBoolean(20, _AgentDetails.CreateComplianceGroup);
			_PreparedStatement.setBoolean(21, _AgentDetails.AssignAdminToAgent);
			_PreparedStatement.setString(22, _AgentDetails.CreatedDate);
			_PreparedStatement.setBoolean(23, _AgentDetails.IsActive);
			_PreparedStatement.setInt(24, _AgentDetails.AgentId);
			_PreparedStatement.executeUpdate();
			_AgentDetails.setResult("Sucess");

		} catch (Exception e) {

		} finally {

		}
	}

	
	public AgentDetails deleteAgentDetails(AgentDetails _AgentDetails) {
		Connection _Connection = MYSQLConnection.GetConnection();
		MYSQLHelper _MYSQLHelper = new MYSQLHelper();
		 PreparedStatement _PreparedStatement = null;
			try
			{
				if(_Connection!=null)
				{
					ResultSet _ResultSetBeneficiary = _MYSQLHelper.GetResultSet("SELECT AgentId FROM agent where AgentId='"+_AgentDetails.AgentId+"'",_Connection);
					if (_ResultSetBeneficiary.next())
					{
						SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						Calendar cal = Calendar.getInstance();
						String date=format.format(cal.getTime());
						_AgentDetails.setDeletedDate(date);
						_AgentDetails.setIsDeleted((true));
						
						String sInsertStatement ="UPDATE agent SET IsDeleted = ? "+ ",DeletedDate = ? "+ " WHERE AgentId = ?";
						_PreparedStatement = _Connection.prepareStatement(sInsertStatement);
						_PreparedStatement.setBoolean(1, _AgentDetails.IsDeleted);
						_PreparedStatement.setString(2,_AgentDetails.DeletedDate);
						_PreparedStatement.setInt(3, _AgentDetails.AgentId);	
						_PreparedStatement.executeUpdate();
						_AgentDetails.setResult("Sucess");
					}
					else
					{
						_AgentDetails.setResult("Failed!");
						_AgentDetails.setError("Invalid Agent Id !");
						clear(_AgentDetails);
					}
				}
				else{
					_AgentDetails.setResult("Failed!");
					_AgentDetails.setError("Error in api backend connectivity !");
					clear(_AgentDetails);
				}
			}
			catch (Exception e) {
				clear(_AgentDetails);
			}
		
		return _AgentDetails;
	}
	public AgentDetails clear(AgentDetails _AgentDetails) {

		_AgentDetails.setAgentCode("");
		_AgentDetails.setcountryId(0);
		_AgentDetails.setCompanyId(0);
		_AgentDetails.setAgentFirstName("");
		_AgentDetails.setSuperAgent("");
		_AgentDetails.setPhone("");
		_AgentDetails.setEmail("");
		_AgentDetails.setSerialNumberPrefix("");
		_AgentDetails.setAddress1("");
		_AgentDetails.setAddress2("");
		_AgentDetails.setSerialNumberLength("");
		_AgentDetails.setCity("");
		_AgentDetails.setSecondName("");
		_AgentDetails.setAgentLastName("");
		_AgentDetails.setSecondLastName("");
		_AgentDetails.setPostalCode("");
		_AgentDetails.setCreatedDate("");
		return _AgentDetails;
	}

}
