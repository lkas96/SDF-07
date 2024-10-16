package workshopd6;

import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClientApp {
    public static void main(String[] args) {
        if(args.length == 0){
            System.err.println("usage: java workshop6.ClientApp <server>:<port>");
            return;
        }

        //Spilt the arguments, inputted as one with HOSTNAME:PORT
        //So spilt into 2 using the : as a delimiter
        String[] arrSplit = args[0].split(":");
        if(arrSplit.length != 2){
            System.err.println("Invalid server address format. It should be <server>:<port>");
            return; //more than 2 delimiters detected, show error and actual format requie
        }

        //Splitting into args[0]args[1] which is hostname:port
        String serverAddress = arrSplit[0];
        int serverPort = Integer.parseInt(arrSplit[1]);

        //Try with the hostname:server to attempted connection
        try(Socket client = new Socket(serverAddress, serverPort);
            InputStream is = client.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            OutputStream os = client.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            
        ){
            //on successful connection
            System.out.println("ClientApp: connected to server");
            Console cons = System.console();
            if(cons == null){
                System.err.println("Console object is null");
                return;
            }

            //while true to keep continuousing taking in input
            while(true){
                String command = cons.readLine("Enter command: ");
                dos.writeUTF(command);
                dos.flush();

                //User types exit, exits the programme
                if(command.equals("exit")){
                    System.exit(1);
                }

                System.out.println(dis);
                String response = dis.readUTF();
                System.out.println("ClientApp: response=" + response);

                if(response != null){
                    if(response.contains("cookie-text_")){
                        String[] arrResponse = response.split("_");
                        System.out.println("ClientApp: cookie=" + arrResponse[1]);
                        if(arrResponse.length > 1){
                            System.out.println("Cookie from server > " + arrResponse[1]);
                        }else{
                            System.err.println("Invalid cookie format received");
                        }
                    }else{
                        System.out.println(response);
                    }
                }else{
                    System.err.println("No cookie found from server");
                }
                    
            }
        }catch(IOException e){
            System.err.println("ClientApp: " + e.getMessage());
        }catch(Exception e){
            System.err.println("ClientApp: " + e.getMessage());
        }
    }
}
