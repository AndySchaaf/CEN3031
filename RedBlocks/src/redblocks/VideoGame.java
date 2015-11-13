/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package redblocks;

/**
 *
 * @author andy
 */
public class VideoGame {
    private String title;
    private String platform;
    private String genre;
    private int inventory;
    private int productID;
 
    public VideoGame(String [] gameInfo){
        
        this.title = gameInfo[0];
        this.platform = gameInfo[1];
        this.genre = gameInfo[2];
//        this.inventory = Integer.parseInt(gameInfo[3]);
    //    this.productID = Integer.parseInt(gameInfo[4]);
        
    }
    
    
    public void setTitle(String title) {
        this.title = title;
    }
    public void setPlatform(String platform) {
        this.platform = platform;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getTitle() {
        return title;
    }
    public String getPlatform() {
        return platform;
    }
    public String getGenre() {
        return genre;
    }
    public int getInventory() {
        return inventory;
    }
    public int getProductID() {
        return productID;
    }
}
