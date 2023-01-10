/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package word.search;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * The File class is used to read and write from an external file.
 * @author Helena Xu
 */
public class File {
    String strFileName, strContent;
    
    /**
     * This is the File class constructor
     * @param _strPath is a string that stores the file name and path 
     */
    public File(String _strPath) {
        strFileName = _strPath;
        strContent = "";
    }
    
    /**
     * @return a string value that holds the entire file content that is read
     */
    public String getContent() {
        strContent = "";
        try {
            // reading the file content
            FileReader fr = new FileReader(strFileName);
            BufferedReader br = new BufferedReader(fr);
            String strLine = br.readLine();
            while(strLine != null){
                strContent += strLine + "\n";
                strLine = br.readLine();
            }  
            br.close();
        } // exception handling
        catch (IOException ex) {}
        return strContent;
    }
    
    /**
     * @param content is a string that is written to the file
     */
    public void setContent(String strContentToWrite) {
        try{
            // writing file content
            FileWriter fw = new FileWriter(strFileName);
            PrintWriter pw = new PrintWriter(fw);
            // Declaring a string array that holds each value that is separeted by a new line one after another
            String[] strContentLines = strContentToWrite.split("\n");
            
            for(int i = 0; i < strContentLines.length; i++){
                pw.write(strContentLines[i] + "\n");
            }
            
            pw.close();
            
            strContent = strContentToWrite;        
        }
        catch(IOException e){}
    }
}
