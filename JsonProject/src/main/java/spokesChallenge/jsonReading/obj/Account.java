package spokesChallenge.jsonReading.obj;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "account_category", "account_code", "account_currency", "account_identifier", "account_status", "value_type", "account_name", "account_type", "account_type_bank", "system_account", "total_value" })
public class Account {

	@JsonProperty("account_category")
	String category;
	@JsonProperty("account_code")
	String code;
	@JsonProperty("account_currency")
	String currency;
	@JsonProperty("account_identifier")
	String identifier;
	@JsonProperty("account_status")
	String status;
	@JsonProperty("value_type")
	String valtype;
	@JsonProperty("account_name")
	String name;
	@JsonProperty("account_type")
	String accType;
	@JsonProperty("account_type_bank")
	String accTypeBank;
	@JsonProperty("system_account")
	String sysAcc;
	@JsonProperty("total_value")
	double totalVal;

   
	@JsonProperty("account_category")
	public String getCategory() {
		return category;
	}
	@JsonProperty("account_category")
	public void setCategory(String category) {
		this.category = category;
	}
	@JsonProperty("account_code")
	public String getCode() {
		return code;
	}
	@JsonProperty("account_code")
	public void setCode(String code) {
		this.code = code;
	}
	@JsonProperty("account_currency")
	public String getCurrency() {
		return currency;
	}
	@JsonProperty("account_currency")
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	@JsonProperty("account_identifier")
	public String getIdentifier() {
		return identifier;
	}
	@JsonProperty("account_identifier")
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	@JsonProperty("account_status")
	public String getStatus() {
		return status;
	}
	@JsonProperty("account_status")
	public void setStatus(String status) {
		this.status = status;
	}
	@JsonProperty("value_type")
	public String getValtype() {
		return valtype;
	}
	@JsonProperty("value_type")
	public void setValtype(String valtype) {
		this.valtype = valtype;
	}
	@JsonProperty("account_name")
	public String getName() {
		return name;
	}
	@JsonProperty("account_name")
	public void setName(String name) {
		this.name = name;
	}
	@JsonProperty("account_type")
	public String getAccType() {
		return accType;
	}
	@JsonProperty("account_type")
	public void setAccType(String accType) {
		this.accType = accType;
	}
	@JsonProperty("account_type_bank")
	public String getAccTypeBank() {
		return accTypeBank;
	}
	@JsonProperty("account_type_bank")
	public void setAccTypeBank(String accTypeBank) {
		this.accTypeBank = accTypeBank;
	}
	@JsonProperty("system_account")
	public String getSysAcc() {
		return sysAcc;
	}
	@JsonProperty("system_account")
	public void setSysAcc(String sysAcc) {
		this.sysAcc = sysAcc;
	}
	@JsonProperty("total_value")
	public double getTotalVal() {
		return totalVal;
	}
	@JsonProperty("total_value")
	public void setTotalVal(double totalVal) {
		this.totalVal = totalVal;
	}  
   


}