package spokesChallenge.jsonReading.obj;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/*Java Object defined according the provided JSON file*/

@JsonInclude(JsonInclude.Include.NON_NULL)

@JsonIgnoreProperties({"object_category", "connection_id", "user", "object_creation_date", "object_creation_date", "currency", "object_origin_type", "object_origin_category", "object_type", "object_class","balance_date"})
public class Report {
    
    private String objCat;    
    private String connId;
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
    
    

    @JsonProperty("data")
	public List<Account> getData() {
		return data;
	}
    @JsonProperty("data")
	public void setData(List<Account> data) {
		this.data = data;
	}
    
  
}

