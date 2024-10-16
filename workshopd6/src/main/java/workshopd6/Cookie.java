package workshopd6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cookie {

    //Variable to store all the lines cookies in the text file.
    private static List<String> cookies;

    public static void init(String cookieFile) throws IOException{
        cookies = getDataFromTextFile(cookieFile);
        //Calls the function and passes in the file, 
        //function reads the file line by line and add it to an arraylist
        //returns the arraylist
    }

    public static String getRandomCookie() throws NoCookieFoundException{
        String randomCookie= "";

        if(cookies.size() > 0){ //If cookies has no lines at all, gives no cookie found

            //else gives a random number from the number of lines
            Random rand = new Random();
            int randomIndex = rand.nextInt(cookies.size());
            randomCookie = cookies.get(randomIndex);

        }else{
            System.out.println("Cookie: No cookie found");
            throw new NoCookieFoundException("Cookie: No cookie found");
        }
        //return this one randomly selected line
        return randomCookie;
    }

    public static List<String> getDataFromTextFile(String _cookieFile) throws IOException {

        List<String> cookies = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(_cookieFile))) {
            String line;

            //reads line one by one in the textfile and add it to the arraylist
            while ((line = br.readLine()) != null) {
                cookies.add(line);
            }
        }
        System.out.println("Cookie: cookies=" + cookies); //prints to ensure file is read for verification
        return cookies;

    }
    
}
