import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;
/**
 * UrlCache Class
 * 
 * @author 	Majid Ghaderi
 * @version	1.0, Sep 22, 2015
 *
 */
public class UrlCache {

    /**
     * Default constructor to initialize data structures used for caching/etc
	 * If the cache already exists then load it. If any errors then throw exception.
	 *
     * @throws UrlCacheException if encounters any errors/exceptions
     */
    public static final int NUM_OF_ENTRIES = 2913;

    private String[] parts;
    private String object;
    private String portnumber;
    private String[] portFinder;
    //private HashMap <Key, Value> list;
    private String[] bytes;
	public UrlCache() throws UrlCacheException
    {
        bytes = new String[NUM_OF_ENTRIES];
       
    }
	
    /**
     * Downloads the object specified by the parameter url if the local copy is out of date.
	 *
     * @param url	URL of the object to be downloaded. It is a fully qualified URL.
     * @throws UrlCacheException if encounters any errors/exceptions
     */
	public void getObject(String url) throws UrlCacheException
    {   
        //get the object id
        parts = url.split("/");
        object = parts[parts.length-1];
        
        // get port number 
        portnumber = getPortNumber(parts[0]);
        //System.out.println(object);
        


        // if object exist dont download


        // else download

        

    }

    /**
    * Returns the port Number 
    * If the port number isnt given default port 80 is returned 
    *
    *@param url contains hostname:[port] part of given url
    *@return port number 
    */
	public String getPortNumber(String url){

        // find port number if given
        if( url.contains(":")){    
            portFinder = url.split(":");
            return portFinder[portFinder.length-1];
            }
        else
           return "80";
    }

    /**
     * Returns the Last-Modified time associated with the object specified by the parameter url.
	 *
     * @param url 	URL of the object 
	 * @return the Last-Modified time in millisecond as in Date.getTime()
     * @throws UrlCacheException if the specified url is not in the cache, or there are other errors/exceptions
     */
	public long getLastModified(String url) throws UrlCacheException
    {
       
        

        try {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date date = format.parse("2006-12-12 10:10:10.000");
        System.out.println(format.format(date));
        } 
        catch (ParseException e) {
                e.printStackTrace();
        }
        return 1;
    }

}
