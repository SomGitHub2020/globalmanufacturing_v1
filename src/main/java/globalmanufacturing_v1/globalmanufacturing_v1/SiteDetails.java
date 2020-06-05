package globalmanufacturing_v1.globalmanufacturing_v1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class SiteDetails {

	String conndetail = "jdbc:mysql://globalmfgservicev1:3306/globalmfgdbv1?user=root&password=aslf3N7yCh0iDR5l&useSSL=false";
	
	public void getSiteList(List<SiteList> lstSiteLists) throws IOException {
		
		String result="";
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(conndetail);  
            Statement stmt=con.createStatement();  
            ResultSet rs=stmt.executeQuery(
            		"SELECT distinct SITE, DESCRIPION FROM `SITE_MASTER` "
            		+ "WHERE SITE != '*' "
            		);  
            while(rs.next()){  
               
                String site = rs.getString(1);
                String desc = rs.getString(2);
                
                lstSiteLists.add(new SiteList(site, desc));
            }
            result = "SUCCESS";
            con.close();
            //return result;
        }
        catch(Exception e){
            e.printStackTrace();
            result = "ERROR";
        }
        //System.out.println(e);
       
		
	}

}
