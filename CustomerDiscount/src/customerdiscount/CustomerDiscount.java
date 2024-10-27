/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package customerdiscount;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

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
                
                //Validation of the four lines
                boolean boh = isValidCustomer(firstLine, secondLine, thirdLine, fourthLine);
                
            }
        } catch(IOException e){
            //Print the error message in case there are some mistakes with the files
            e.printStackTrace();
        }
        
        
    }
    
    //Boolean method that validate the four lines and controll if it's a valid customer, if not return false and 
    // an appropiate message
    public static boolean isValidCustomer(String firstLine, String secondLine, String thirdLine, String fourthLine){
        //Validation second line total purchase as double
        //Using the Double class I'll try to parse the line in double 
        try{
            Double.parseDouble(secondLine);
        }catch(NumberFormatException e){
            System.out.println("The total purchase of the customer "+firstLine+" is not double and "
                    + "produced the following error: "+e.getMessage());
            return false;
        }
        
        //Validation third line class as a Integer a number between 1 and 3
        //USing the Integer class I'll try to parse the line in int and after that I'll controll if is beetween 1 and 3
        try{
            int classCustomer = Integer.parseInt(thirdLine);
            if (classCustomer<1 ||classCustomer>3){
               System.out.println("The class of the customer "+firstLine+" is not in a range between 1 and 3");
                return false; 
            }
        }catch(NumberFormatException e){
            System.out.println("The class of the customer "+firstLine+" is not integer and "
                    + "produced the following error: "+e.getMessage());
            return false;
        }
        
        //Validation of the four line as a valid year, so need to be a Integer of four digits and in a reasonable range       
        try{
            int yearCustomer=Integer.parseInt(fourthLine);
            //Control if it's four digits 
            if (yearCustomer<1000 || yearCustomer>9999){
               System.out.println("The year of the customer "+firstLine+" is not 4 digits");
               return false; 
                
            }
        }catch(NumberFormatException e){
             System.out.println("The year of the customer "+firstLine+" is not integer and "
                    + "produced the following error: "+e.getMessage());
            return false;
        }
        
       //Validation of the name and surname usign the regular expressions 
       //I took inspiration from the site https://www.w3schools.com/java/java_regex.asp 
       try{
            //I try to split in an array the name and surname, if doesn't work mean it isnt' separate from a space
            String[] nameSurname = firstLine.split(" ");
            String name = nameSurname[0];
            String surname = nameSurname[1];
            //Using regular expression lower and upper letter 
             if (!Pattern.matches("^[a-zA-Z]+$", name)){
                 System.out.println("The name of the customer "+name+" isn't letters only");
                 return false;
             }
             //Using regular expression lower and upper letter and numbers 
             if (!Pattern.matches("^[a-zA-Z0-9]+$", surname)){
                 System.out.println("The surname of the customer "+surname+" isn't letters and numbers only");
                 return false;
             }
       }catch(Exception e){
           System.out.println("The name and surname of the customer "+firstLine+" aren't "
                    + "separate by a space");
            return false;
       }
        return true;
    }
}
