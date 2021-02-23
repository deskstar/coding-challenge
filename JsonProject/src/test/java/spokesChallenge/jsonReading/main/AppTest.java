package spokesChallenge.jsonReading.main;



import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;

import java.net.URLDecoder;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import spokesChallenge.jsonReading.constant.JsonAttributes;
import spokesChallenge.jsonReading.obj.Account;
import spokesChallenge.jsonReading.obj.Report;



/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    //test JSON file reading
    @Test
    public void testReadFileWithClassLoader() throws JsonParseException, JsonMappingException, IOException{
        ClassLoader classLoader = this.getClass().getClassLoader();
        
        File file = new File(classLoader.getResource("testData.json").getFile());
        
        //handle special character in file path, such as space        
        String path = URLDecoder.decode(file.getAbsolutePath(), "UTF-8");
        
        ObjectMapper mapper = new ObjectMapper();
        
        Report obj = new Report();
        obj = mapper.readValue(new File(path), Report.class);
        
        List<Account> data = obj.getData();
        
        Account account = data.get(0);
        
        //5 account records in sample data
        assertTrue(data.size() == 5);
        
        //test the constant value and the reading of each field in account record
        assertTrue(account.getCategory().equals(JsonAttributes.ACCOUNT_CATEGORY_REVENUE));
        assertTrue(account.getCode().equals("200"));
        assertTrue(account.getCurrency().equals("AUD"));
        assertTrue(account.getIdentifier().equals("id1"));
        assertTrue(account.getStatus().equals(JsonAttributes.ACCOUNT_STATUS_ACTIVE));
        assertTrue(account.getValtype().equals(JsonAttributes.ACCOUNT_VALUE_TYPE_CREDIT));
        assertTrue(account.getName().equals("name_1"));
        assertTrue(account.getAccType().equals(JsonAttributes.ACCOUNT_TYPE_SALES));
        assertTrue(account.getAccTypeBank().equals("bank_type_1"));
        assertTrue(account.getSysAcc().equals("sys_acct_1"));  
        assertTrue(account.getTotalVal() == 123456.7);      
        
        Account accountSecond = data.get(1);
        assertTrue(accountSecond.getCategory().equals(JsonAttributes.ACCOUNT_CATEGORY_EXPENSE));
        assertTrue(accountSecond.getValtype().equals(JsonAttributes.ACCOUNT_VALUE_TYPE_DEBIT));
        assertTrue(accountSecond.getAccType().equals(JsonAttributes.ACCOUNT_TYPE_CURRENT)); 
        
        Account accountThird = data.get(2);
        assertTrue(accountThird.getCategory().equals(JsonAttributes.ACCOUNT_CATEGORY_ASSET));
        assertTrue(accountThird.getAccType().equals(JsonAttributes.ACCOUNT_TYPE_CURRENT_ACC_PAYABLE)); 
        
        Account accountFourth = data.get(3);
        assertTrue(accountFourth.getCategory().equals(JsonAttributes.ACCOUNT_CATEGORY_LIABILITY));
        assertTrue(accountFourth.getAccType().equals(JsonAttributes.ACCOUNT_TYPE_CURRENT_ACC_RECEIVABLE));
        
        Account accountFifth = data.get(4);
        assertTrue(accountFifth.getAccType().equals(JsonAttributes.ACCOUNT_TYPE_BANK));        
    }
}
