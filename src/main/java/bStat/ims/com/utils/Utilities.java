package bStat.ims.com.utils;

import javax.ws.rs.core.MultivaluedMap;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by chaitra.kr on 22/03/16.
 */
public class Utilities {

    public static String getRandomString() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String getUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static Map<String, String> getMap(MultivaluedMap<String, String> headers) {
        Map<String, String> parameters = new HashMap<String, String>();
        Iterator<String> it = headers.keySet().iterator();
        while (it.hasNext()) {
            String theKey = it.next();
            parameters.put(theKey, headers.getFirst(theKey));
        }
        return parameters;
    }

    public static String getCampaign() {
        return "234189926";
    }

    private static String commonDateFormat(Date date) {

        return new SimpleDateFormat(Constants.SELF_SERVE_DATE_FORMAT).format(date);
    }


}
