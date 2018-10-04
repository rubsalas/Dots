package game;

import netscape.javascript.JSObject;
import org.json.JSONException;
import org.json.JSONObject;

public class Test {

    public static void main(String args[]) throws JSONException {

        JSONObject json = new JSONObject();

        json.put("coordenadas","|075.0| |100.0| |275.0| |200.0|");

        String jString = json.toString();

       //String jsonString =  {"action":"{\"coordenadas\":\"|175.0| |100.0| |275.0| |200.0|\"}"}       "|175.0| |100.0| |275.0| |200.0| "

        getFromJSONTest(jString);

    }

    public static void getFromJSONTest(String json){
        System.out.println("Test");

        String x1 = json.substring(17,22);
        String y1 = json.substring(25,30);
        String x2 = json.substring(33,38);
        String y2 = json.substring(41,46);

        System.out.println(x1);
        System.out.println(y1);
        System.out.println(x2);
        System.out.println(y2);

        double x_1 = Double.parseDouble(x1);
        double y_1 = Double.parseDouble(y1);
        double x_2 = Double.parseDouble(x2);
        double y_2 = Double.parseDouble(y2);

        double d = x_1 + y_1;

        System.out.println(d);


        }








            /*
            if(temp.equals("|")) {
                checkI = true;
                j = 1;
            }
            if(checkI == true) {
                i += 1;
                temp = String.valueOf(charArray[i]);
            }
            System.out.print(temp);
            coord += temp;
        }
        //System.out.print(String.valueOf(charArray[i]));
        System.out.println(coord);*/
        /*i += 1;*/
    }




/*
        int i = 0;
        String temp = String.valueOf(charArray[i+1]);
        //for(int i = 0; i < charArray.length;i++){
            while(i < charArray.length){


            if(temp.equals(":")) {
                i += 1;
                coord += temp;

                while (!temp.equals(",")){
                    coord+=temp;
                    i+=1;
                }



                /*while(!temp.equals(",")){
                    temp = String.valueOf(charArray[i]);
                    coord += temp;
                    i += 1;
                }*
            } else {
                i+=1;
            }*/



        //System.out.println(coord);



