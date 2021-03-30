

package com.saket.demo.proxy;
  
import java.util.ArrayList;
import java.util.List;
  
  
public class ProxyInternet implements Internet
{
    private Internet internet = new RealInternet();
    private static List<String> bannedSites;
      
    static
    {
        bannedSites = new ArrayList<String>();
        bannedSites.add("google.com");
         bannedSites.add("facebook.com");
    }
      
    @Override
    public void connectTo(String serverhost) throws Exception
    {
        if(bannedSites.contains(serverhost.toLowerCase()))
        {
            throw new Exception("Access not gratned");
        }
          
        internet.connectTo(serverhost);
    }
  
}
