/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package problem02;

abstract class Ticket{
    int ticket_id;
    String origin,destination;
    String date;
    
    Ticket(int ticket_id, String origin, String destination, String date) {
        this.ticket_id = ticket_id;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
    }
    
    abstract double calculate_price();
    abstract void display_info();
}

// --------------------------Concreate Class "StandardTicket"--------------------

class StandardTicket extends Ticket{
    
    int seat_number;
    double base_price;
    
    StandardTicket(int ticket_id, String origin, String destination, String date,int seat_number, double base_price){
        super(ticket_id, origin, destination, date);
        this.seat_number = seat_number;
        this.base_price = base_price;
    }
    
    @Override
    double calculate_price(){
        int distance = Math.abs(origin.length()-destination.length());
        double distance_fee = distance*100;
        return base_price+distance_fee;
    }
    
    void display_info(){
        System.out.println("----------------------Standard Ticket---------------");
        System.out.println("Ticket id is  : " + ticket_id);
        System.out.println("Origin is     : " + origin);
        System.out.println("Destination is:" + destination);
        System.out.println("Journey Date  : " + date);
        System.out.println("Seta Number is: " + seat_number);
        System.out.println("Base Price is : " + base_price);
        System.out.println("Total price is: " + calculate_price());
        System.out.println();
    }
    
}

//------------------------Concreate class "FirstClass Ticket"---------------------

class FirstClassTicket extends Ticket{
    int seat_number;
    double base_price, first_class_surcharge;
    
    FirstClassTicket(int ticket_id,String origin, String destination, String date, int seat_number, double base_price, double first_class_surchage){
        super(ticket_id, origin, destination, date);
        this.seat_number = seat_number;
        this.base_price = base_price;
        this.first_class_surcharge = first_class_surcharge;
    }
    
    @Override
    double calculate_price(){
        int distance = Math.abs(origin.length()-destination.length());
        double distance_fee = distance*100;
        return base_price+distance_fee+first_class_surcharge;
    }
    
    @Override
    void display_info(){
        System.out.println("---------------------First class Ticket--------------");
        System.out.println("Ticket id is              : " + ticket_id);
        System.out.println("Origin is                 : " + origin);
        System.out.println("Destination is            : " + destination);
        System.out.println("Journey Date              : " + date);
        System.out.println("Seta Number is            : " + seat_number);
        System.out.println("Base Price is             : " + base_price);
        System.out.println("First_class Survice charge: " + first_class_surcharge);
        System.out.println("Total price is            : " + calculate_price());
    }
} 
public class Problem02 {
    
    public static void main(String[] args) {
        
        Ticket std = new StandardTicket(2515242,"Dhaka", "Gaibandha", "10-03-2026",19,615);
        std.display_info();
        
        Ticket first = new FirstClassTicket(2515242,"Dhaka", "Comilla", "10-03-2026",05,450,30);
        first.display_info();
    }
    
}
