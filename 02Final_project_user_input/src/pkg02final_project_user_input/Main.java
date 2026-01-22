/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg02final_project_user_input;
import java.util.*;

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
    ArrayList<Ticket> ticket = new ArrayList<>();
    
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
        
        Scanner s = new Scanner(System.in);
        TicketManager t = new TicketManager();
        
        while(true){
            System.out.println();
            System.out.print("Enter choice: ");
            int choice = s.nextInt();
            
        if(choice==0){
            System.out.println("Work is Stoped");
        }
        
        
        switch(choice){
            case 1: {
                System.out.print("Ticket Id is: ");
                int id = s.nextInt();
                s.nextLine();
                
                System.out.print("Origin is: ");
                String or = s.nextLine();
                
                System.out.print("Destination is: ");
                String des = s.nextLine();
                
                System.out.print("Date is: ");
                String dat = s.nextLine();
                
                System.out.print("Seat Number: ");
                int seat = s.nextInt();
                
                System.out.print("Base Price: ");
                double base = s.nextDouble();
                
                Ticket t1 = new StandardTicket(id,or,des,dat,seat,base);
                t.add_ticket(t1);
                break; 
            }
            case 2 : {
                System.out.print("Ticket Id is: ");
                int id = s.nextInt();
                s.nextLine();
                
                System.out.print("Origin is: ");
                String or =s.nextLine();
                
                System.out.print("Destination is: ");
                String des = s.nextLine();
                
                System.out.print("Date is: ");
                String dat = s.nextLine();
                
                System.out.print("Seat Number: ");
                int seat = s.nextInt();
                
                System.out.print("Base Price: ");
                double base = s.nextDouble();
                
                System.out.print("First Class Survice Charge: ");
                double survice = s.nextDouble();
                
                Ticket t2 = new FirstClassTicket(id,or,des,dat,seat,base,survice);
                t.add_ticket(t2);
                break;
            }
            case 3: {
                t.display_all();
                break;
            }
            case 4: {
                System.out.print("Find ticket id: ");
                int id = s.nextInt();
                t.search_info(id);
                break;
            }
            case 5: {
                System.out.print("Ticket id delete: ");
                int id = s.nextInt();
                t.del_ticket(id);
                break;
            }
            case 6: {
                System.out.print("Total revenue: " + t.total_revenue());
                break;
            }
            default: 
                System.out.println("Invalid Choice");
        }
        s.close();
     
       }
        
    }
    
}
