/*
 * @Author John M. Miller
 * @Date: 1/17/14
 * @Contact: johnm22987@gmail.com
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
 
 
public class InputHandler
{
        public String object;
        static File in;
       
        //create streams
        public InputHandler(){
                InputHandler.in = new File("input.txt");
        }
       
        private static int lineCounter() throws IOException{
                LineNumberReader  lnr = new LineNumberReader(new FileReader(in));
                lnr.skip(Long.MAX_VALUE);
                int lineCount = lnr.getLineNumber();
                lnr.close();
                return lineCount+1;
        }
       
        //grabs object and query for program run loads into arrays for each and checks to ensure that there are an equal number
        public ArrayList<String>[] getObjectsandQueries() throws IOException{
                int lineCount = lineCounter();
                System.out.println(lineCount);
                if((lineCount % 2) == 0){
                        @SuppressWarnings("unchecked")
                        ArrayList<String>[] out = new  ArrayList[2];
                        out[0] = new ArrayList<String>();
                        out[1] = new ArrayList<String>();
                        BufferedReader reader = new BufferedReader(new FileReader(in));
                        String line = "";
                        boolean flag = true;
                        while((line=reader.readLine()) != null){
                                if(flag){
                                        out[0].add(line);
                                        flag = false;
                                }
                                else{
                                        out[1].add(checkQuery(line));
                                        flag = true;
                                }
                        }
                        reader.close();
                        return out;
                }
                else
                        throw new IllegalArgumentException("Malformed input.txt");
               
        }
       
        public static String checkQuery(String query){
                query = query.trim();
                if(query.contains("Id"))
                        return query;
                else{
                        String select = query.substring(0,6);
                        select += " Id, ";
                        select += query.substring(6);
                        return select;
                }
        }
       
}