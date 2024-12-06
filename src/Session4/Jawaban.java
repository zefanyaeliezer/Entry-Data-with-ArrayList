package Session4;

import java.util.Scanner;
import java.util.ArrayList;

public class Jawaban {

    private static ArrayList<Data> personData = new ArrayList<>();
    private static class Data {
        String name, pass, phone;

        Data(String name, String pass, String phone){
            this.name = name;
            this.pass = pass;
            this.phone = phone;
        }
    }
    private static void showData(){
        System.out.println("========================================");
        // String formString = String.format("%-10" + "s" + "%-10" + "s" +"%-10" + "s" + "%-10" + "s", "|No|", "Name|", "Pass|", "Phone");
        String formString = String.format("%-10s %-10s %-10s %-10s", "|No|", "Name|", "Pass|", "Phone");
        System.out.println(formString);

        for(int i = 0; i < personData.size(); i++){
            Data data = personData.get(i);
            String formOutput = String.format("|%2d| %10s| %9s| %10s", (i+1), data.name, data.pass, data.phone);
            System.out.println(formOutput);
        }
    }
    public static void main(String[] args) {
 
        Scanner scan = new Scanner(System.in);

        int option;
        do {
            System.out.println("1. Input Data");
            System.out.println("2. Show Data");
            System.out.println("3. Delete Data");
            System.out.println("4. Exit");
            System.out.print("Your Choice: ");
            option = scan.nextInt();    scan.nextLine();
            switch(option) {
                case 1:
                {
                    String name, pass, phoneNum;
                    System.out.print("Name: ");
                    name = scan.nextLine();

                    System.out.print("Pass: ");
                    pass = scan.nextLine();

                    

                    System.out.print("Phone: ");
                    phoneNum = scan.nextLine();
                    
                    System.out.println("New data is added");

                    Data data = new Data(name, pass, phoneNum);
                    personData.add(data);
                }   
                    break;
                case 2:
                {

                    if(personData.isEmpty()){
                        System.out.println("No data exists");
                    }
                    showData();
                }
                    break;
                case 3:
                {
                    System.out.print("Input data number to be deleted: ");
                    int deleteChoice = scan.nextInt();
                    if(deleteChoice >= 1 && deleteChoice <= personData.size()){
                        personData.remove(deleteChoice-1);
                        System.out.println("Data is removed");
                    }
                    else System.out.println("The number is invalid");
                    break;
                }
                case 4:
                    System.out.println("You have succesfully exit the menu");
                    break;
            }
        }while(option != 4);
    }
    
}