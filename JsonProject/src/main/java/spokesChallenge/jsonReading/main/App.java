package spokesChallenge.jsonReading.main;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import spokesChallenge.jsonReading.constant.JsonAttributes;
import spokesChallenge.jsonReading.obj.Account;
import spokesChallenge.jsonReading.obj.Report;

/**
 * Logic to read the JSON file
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	String filePath = "";

    	Report obj = new Report();
    	ObjectMapper mapper = new ObjectMapper();
    	double revenue = 0;
    	double expense = 0;
    	double totalSales = 0;
    	double grossProfitMargin = 0;
    	double netProfitMargin = 0;
    	double asset = 0;
    	double liability = 0;
    	double workingCapitalRatio = 0;
    	DecimalFormat valueFormatter = new DecimalFormat(JsonAttributes.ACCOUNT_VALUE_PATTERN);
    	DecimalFormat percentFormatter = new DecimalFormat(JsonAttributes.ACCOUNT_PERCENTAGE_PATTERN);

    	//argument for JSON file path
        if (args.length == 1)	{
        	filePath = URLDecoder.decode(args[0], "UTF-8");                                   
        }
        
        try	{
        	obj = mapper.readValue(new File(filePath), Report.class);
        }	catch (IOException ioException)	{
        	System.out.println("Cannot read JSON file properly");
        	throw ioException;
        }
        
        
        for(Account account : obj.getData()) {
        	//revenue
            if (account.getCategory().equals(JsonAttributes.ACCOUNT_CATEGORY_REVENUE))	{
            	revenue = revenue  + account.getTotalVal();
            //expenses	
            } else if (account.getCategory().equals(JsonAttributes.ACCOUNT_CATEGORY_EXPENSE))	{
            	expense = expense + account.getTotalVal();
            }
            //sales(debit)
            if (account.getAccType().equals(JsonAttributes.ACCOUNT_TYPE_SALES) && account.getValtype().equals(JsonAttributes.ACCOUNT_VALUE_TYPE_DEBIT))	{
            	totalSales = totalSales + account.getTotalVal() ;
            }
            
            //assets
            if (account.getCategory().equals(JsonAttributes.ACCOUNT_CATEGORY_ASSET) && 
        			(account.getAccType().equals(JsonAttributes.ACCOUNT_TYPE_CURRENT) || 
        			account.getAccType().equals(JsonAttributes.ACCOUNT_TYPE_BANK) || 
        			account.getAccType().equals(JsonAttributes.ACCOUNT_TYPE_CURRENT_ACC_RECEIVABLE)))	{            	
            	if (account.getValtype().equals(JsonAttributes.ACCOUNT_VALUE_TYPE_DEBIT))	{
            		asset = asset + account.getTotalVal();            		
            	}	else if ( account.getValtype().equals(JsonAttributes.ACCOUNT_VALUE_TYPE_CREDIT))	{
            		asset = asset - account.getTotalVal();
            	}            	
            }            
            
            //liabilities 
            if (account.getCategory().equals(JsonAttributes.ACCOUNT_CATEGORY_LIABILITY) && 
        			(account.getAccType().equals(JsonAttributes.ACCOUNT_TYPE_CURRENT) || 
        			account.getAccType().equals(JsonAttributes.ACCOUNT_TYPE_CURRENT_ACC_PAYABLE)))	{
            	
            	if (account.getValtype().equals(JsonAttributes.ACCOUNT_VALUE_TYPE_CREDIT) )	{
            		liability = liability + account.getTotalVal();            		
            	}	else if (account.getValtype().equals(JsonAttributes.ACCOUNT_VALUE_TYPE_DEBIT))	{
            		liability = liability - account.getTotalVal();
            	}            	
            } 
           
        }
        
        //gross profit margin (percentage)
        grossProfitMargin = totalSales / revenue;
        
        //net profit margin (percentage)
        netProfitMargin = (revenue - expense) / revenue;
        
        //working capital ratio (percentage)
        workingCapitalRatio = asset / liability;

        System.out.println("revenue " + valueFormatter.format(revenue));
        System.out.println("expense " + valueFormatter.format(expense));
        System.out.println("grossProfitMargin " + percentFormatter.format(grossProfitMargin));
        System.out.println("netProfitMargin " + percentFormatter.format(netProfitMargin));
        System.out.println("workingCapitalRatio " +  percentFormatter.format(workingCapitalRatio));
    }
}
