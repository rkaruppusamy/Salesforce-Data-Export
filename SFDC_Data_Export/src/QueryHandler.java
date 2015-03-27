 
import com.sforce.soap.partner.Field;
 
 
 
 
public class QueryHandler
{
       
        public QueryHandler(){
        }
        //generates query of all fields on an object, called in login() function back in BulkExample
        //may or may not be needed.
        public String generateQuery(Field[] fields, String object){
                StringBuilder sb = new StringBuilder();
                sb.append("SELECT ");
                for(Field f:fields){
                        sb.append(" "+f.getName());
                        sb.append(",");
                }
                sb.deleteCharAt(sb.length()-1);
                sb.append(" FROM "+ object);
                return sb.toString();
        }
}