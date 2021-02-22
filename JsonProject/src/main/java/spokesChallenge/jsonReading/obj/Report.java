package spokesChallenge.jsonReading.obj;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "object_category", "connection_id", "user", "object_creation_date", "data" })
@JsonIgnoreProperties({"object_creation_date", "currency", "object_origin_type", "object_origin_category", "object_type", "object_class","balance_date"})
public class Report {
    @JsonProperty("object_category")
    private String objCat;
    @JsonProperty("connection_id")
    private String connId;
    @JsonProperty("user")
    private String user;

    private String objCreateDate;
    @JsonProperty("data")
    private List<Account> data;

    private String currency;
    private String objOrignType;
    private String objOriginCat;
    private String objType;
    private String objClass;
    private String balanceDate;
    
    
    @JsonProperty("object_category")
	public String getObjCat() {
		return objCat;
	}
    @JsonProperty("object_category")
	public void setObjCat(String objCat) {
		this.objCat = objCat;
	}
    @JsonProperty("connection_id")
	public String getConnId() {
		return connId;
	}
    @JsonProperty("connection_id")
	public void setConnId(String connId) {
		this.connId = connId;
	}
    @JsonProperty("user")
	public String getUser() {
		return user;
	}
    @JsonProperty("user")
	public void setUser(String user) {
		this.user = user;
	}
    @JsonProperty("object_creation_date")
	public String getObjCreateDate() {
		return objCreateDate;
	}
    @JsonProperty("object_creation_date")
	public void setObjCreateDate(String objCreateDate) {
		this.objCreateDate = objCreateDate;
	}
    @JsonProperty("data")
	public List<Account> getData() {
		return data;
	}
    @JsonProperty("data")
	public void setData(List<Account> data) {
		this.data = data;
	}
    
  
}

