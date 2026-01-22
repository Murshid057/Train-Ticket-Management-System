/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg01.problem01;

abstract class Ticket{
    int ticket_id;
    String origin,destination;
    String date;
    
    Ticket(int ticket_id, String origin, String destination, String date){
        this.ticket_id = ticket_id;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
    }
    
    abstract double calculate_price();
    abstract void display_info(); 
}
class Train extends Ticket{
    
    Train(int ticket_id, String origin, String destination, String date){
        super(ticket_id,origin,destination,date);
    }
    
    @Override
    double calculate_price(){
        return 615.00;
    }
    
    @Override
    void display_info(){
        System.out.println("Ticket id is: " + ticket_id);
        System.out.println("Origin is   : " + origin);
        System.out.println("Destination : " + destination);
        System.out.println("Date is     : " + date);
        System.out.println("Price is    : " + calculate_price()+" taka");
    }
}
public class Problem01 {

    public static void main(String[] args) {
        
        Ticket t = new Train(32515,"Dhaka","Gaibandha","12-03-2026");
        t.display_info();
        
    }
    
}
