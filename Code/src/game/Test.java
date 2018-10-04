package game;

public class Test {

    public static void main(String args[]){

       // String jsonString =  {"action":"{\"y1\":200,\"x1\":75,\"y2\":200,\"x2\":175}"};
        getFromJSONTest(":30,qwer");

    }

    public static void getFromJSONTest(String json){
        System.out.println("Test");
        char[] charArray = json.toCharArray();
        //charArray.
        int i = 0;
        while(i <= charArray.length){
            int j = i;
            if(String.valueOf(charArray[i]) == ":"){
                String coord = "";
                while (String.valueOf(charArray[i]) != ","){
                    coord += String.valueOf(charArray[i]);
                }
                System.out.println(coord);
                i+=1;
            }
            i += 1;
        }
    }

}
