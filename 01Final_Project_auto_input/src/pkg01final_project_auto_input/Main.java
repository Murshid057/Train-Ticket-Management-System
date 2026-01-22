/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg01final_project_auto_input;

import java.util.ArrayList;
import java.util.Iterator;

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
    
    @Override
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

class TicketManager{
    ArrayList<Ticket> ticket = new ArrayList<Ticket>();
    
    //add ticket;
    void add_ticket(Ticket t){
        ticket.add(t);
        System.out.println("Ticket add successfully");
    }
    
    //Remove Ticket;
    void del_ticket(int id){
        for(Iterator<Ticket> it = ticket.iterator(); it.hasNext();){
            Ticket t = it.next();
            if(t.ticket_id == id)
                it.remove();
            System.out.println("ticket remove successfull");
            return;
        }
        System.out.println("Ticket not found!");
    }
    
    //Find tickets by ticket id;
    void search_info(int id){
        for(Ticket t : ticket){
            if(t.ticket_id == id){
                t.display_info();
                return;
            }
        }
        System.out.println("Ticket not found!");
    }
    
    //Total revenue;
    double total_revenue(){
        double sum =0;
        for(Ticket t : ticket)
            sum += t.calculate_price();
        
        return sum;
    }
    
    //Display all tickets;
    void display_all(){
        if(ticket.isEmpty()){
            System.out.println("No ticket aviable.");
            return;
        }
        for(Ticket t : ticket){
            t.display_info();
            System.out.println("");
        }
    }
}
public class Main {

    
    public static void main(String[] args) {
        
        TicketManager ti = new TicketManager();
        
        Ticket t = new StandardTicket(12154255,"Dhaka","Gaibandha","12-03-26",19,615);
        Ticket t2 = new StandardTicket(1255212,"Rangpur","Comilla","15-02-2026",18,1050);
        Ticket t3 = new FirstClassTicket(5256521,"Dhaka", "Sylhet","18-05-2026",22,1155,50);
        Ticket t4 = new FirstClassTicket(5256521,"Dinajpur", "Dhaka","19-03-2026",29,1014,60);
        
        ti.add_ticket(t);
        ti.add_ticket(t2);
        ti.add_ticket(t3);
        ti.add_ticket(t4);
        
        ti.display_all();
        ti.search_info(1255212);
        ti.del_ticket(5256521);
      
        System.out.println("Total Revenue: " + ti.total_revenue());
    }
    
}
