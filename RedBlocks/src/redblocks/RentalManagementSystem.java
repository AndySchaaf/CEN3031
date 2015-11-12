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

/**
 *
 * @author andy
 */
public class RentalManagementSystem {
    private String csvFile = "src/users.csv";
    private boolean validUser;
    
    private BufferedReader br = null;
    public void read() {
	
    }

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
