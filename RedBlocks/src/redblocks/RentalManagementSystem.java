/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redblocks;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andy
 */
public class RentalManagementSystem {
    private String csvFile = "RedBlocks/src/users.csv";
    private String csvGame = "RedBlocks/src/games.csv";
    private boolean validUser;
    private static String [] gameInfo = new String [1000];
    public static List<VideoGame> games = new ArrayList<VideoGame>();  
    private BufferedReader br = null;
    public void read() {
	
    }
    //Test CommitGGG
    public boolean register(String[] userInfo) {
        
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile, true));
            bw.newLine();
            for(int i = 0; i < userInfo.length; i++) {
                bw.write(userInfo[i]+",");
            }
            bw.close();
        } catch(Exception e) {
            return false;
        }
        
        return true;
    }
    
    //games.csv to array
    public void getGameInfo() {
        
        String line = "";
	String cvsSplitBy = ",";

       
	try {
            br = new BufferedReader(new FileReader(csvGame));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                gameInfo = line.split(cvsSplitBy);
                 VideoGame game = new VideoGame(gameInfo); //Creates new VideoGame 
                 games.add(game); //Fills ArrayList games with VideoGame objects
                   
         
                
            }
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
            if (br != null) {
                    try {
                            br.close();
                    } catch (IOException e) {
                            e.printStackTrace();
                    }
            }
	}
        
           
    }
    
    
    
    
    
    public String[] getUserInfo(String loggedInUserID) {
        String[] userInfo = null;
        
        String line = "";
	String cvsSplitBy = ",";

	try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                userInfo = line.split(cvsSplitBy);
                if(userInfo[0].equals(loggedInUserID)) {
                    return userInfo;
                }
            }
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
            if (br != null) {
                    try {
                            br.close();
                    } catch (IOException e) {
                            e.printStackTrace();
                    }
            }
	}
     
        return null;
    }
    
    public String logIn(String email, String password) {
        validUser = false;
        getGameInfo(); //Creates array gameInfo from games.csv
        int count = 0;
        
        
        String line = "";
	String cvsSplitBy = ",";

	try {
            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] userInfo = line.split(cvsSplitBy);

                String enteredEmail = userInfo[3];
                String enteredPass = userInfo[4];
                
                if(userInfo[3].equals(email)) {
                    if(userInfo[4].equals(password)) {
                        return userInfo[0];
                    }
                }
            }
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
            if (br != null) {
                    try {
                            br.close();
                    } catch (IOException e) {
                            e.printStackTrace();
                    }
            }
	}   
        
        return null;
    }
    
    
}
