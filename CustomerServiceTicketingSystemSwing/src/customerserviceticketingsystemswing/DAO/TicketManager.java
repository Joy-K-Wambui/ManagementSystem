/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customerserviceticketingsystemswing.DAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicketManager {
    
    public TicketManager() {
        createSampleTickets();
    }

    public void createSampleTickets() {
    createTicket(new Ticket("001", "Alice Johnson", "Network Access Issue", "High", "Open"));
    createTicket(new Ticket("002", "Bob Smith", "Software Issue", "Medium", "Closed"));
    createTicket(new Ticket("003", "Charlie Brown", "Hardware Issue", "Low", "Open"));
    createTicket(new Ticket("004", "Daisy Miller", "Billing Problem", "Critical", "Pending"));
    createTicket(new Ticket("005", "Ella Fitzgerald", "Account Access", "Medium", "Open"));
}

    public List<Ticket> getAllTickets() {
        return new ArrayList<>(tickets.values());
    }
    
    private Map<String, Ticket> tickets = new HashMap<>();

    public void createTicket(Ticket ticket) {
        if (ticket != null && !tickets.containsKey(ticket.getTicketId())) {
            tickets.put(ticket.getTicketId(), ticket);
        } else {
            System.out.println("Failed to create ticket.");
        }
    }

    public Ticket getTicketById(String ticketId) {
        return tickets.get(ticketId);
    }

    public void updateTicket(String ticketId, String issue, String priority, String status) {
        Ticket ticket = getTicketById(ticketId);
        if (ticket != null) {
            ticket.setIssue(issue);
            ticket.setPriority(priority);
            ticket.setStatus(status);
        }
    }

    public void deleteTicket(String ticketId) {
        tickets.remove(ticketId);
    }
    public int countTicketsByStatus(String status) {
        return (int) tickets.values().stream()
                .filter(ticket -> ticket.getStatus().equalsIgnoreCase(status))
                .count();
    }    
}
