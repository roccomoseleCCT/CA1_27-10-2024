/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package customerdiscount;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Rocco Mosele 27/10/2024
 */
public class CustomerDiscount {

    public static void main(String[] args){
        // Initialize path input 
        String inputFile="C:\\Users\\User\\Desktop\\CCT\\CCT Monday\\CA1_27-10-2024\\CustomerDiscount\\src\\customerdiscount\\customer.txt";
        //Initialize path output
        String outputFile="C:\\Users\\User\\Desktop\\CCT\\CCT Monday\\CA1_27-10-2024\\CustomerDiscount\\src\\customerdiscount\\customerdiscount.txt";
        //Reading of the input file using the try because could generate a FileNotFoundException
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            //Initialize the four lines of a customer
            String firstLine, secondLine, thirdLine, fourthLine;
            //Loop that read four lines of the file and split the line in the appropiate four variables
            while((firstLine=br.readLine()) != null){
                secondLine=br.readLine();
                thirdLine=br.readLine();
                fourthLine=br.readLine();
                
                
            }
        } catch(IOException e){
            //Print the error message in case there are some mistakes with the files
            e.printStackTrace();
        }
        
        
    }
    
}
