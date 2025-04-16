package customerserviceticketingsystemswing;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import customerserviceticketingsystemswing.DAO.TicketManager;
import customerserviceticketingsystemswing.DAO.CustomerManager;


public class CustomerServiceTicketingSystem {
    public static void main(String[] args) {
        // Run the GUI setup code on the Event-Dispatching thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Create the JFrame (Main Application Window)
                JFrame frame = new JFrame("Customer Service Ticketing System");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600); // Set window size
                frame.setLocationRelativeTo(null); // Center the window on screen

                TicketManager ticketManager = new TicketManager();
                DashboardPanel dashboardPanel = new DashboardPanel(ticketManager);
                ViewOpenTicketsPanel viewOpenTicketsPanel = new ViewOpenTicketsPanel(ticketManager);
                CreateNewTicketPanel createNewTicketPanel = new CreateNewTicketPanel(ticketManager, viewOpenTicketsPanel);
                GenerateReportPanel generateReportPanel = new GenerateReportPanel(ticketManager, CustomerManager.getInstance());
                
                // Create the JMenuBar (Menu at the top)
                JMenuBar menuBar = new JMenuBar();

                // Create menus and menu items
                JMenu fileMenu = new JMenu("File");
                JMenu ticketsMenu = new JMenu("Tickets");
                JMenu customersMenu = new JMenu("Customers");
                JMenu reportsMenu = new JMenu("Reports");
                JMenu helpMenu = new JMenu("Help");

                // Create menu items
                JMenuItem dashboardItem = new JMenuItem("Dashboard");
                JMenuItem exitItem = new JMenuItem("Exit");
                JMenuItem createTicketItem = new JMenuItem("Create New Ticket");
                JMenuItem viewOpenTicketsItem = new JMenuItem("View Open Tickets");
                JMenuItem searchTicketItem = new JMenuItem("Search Ticket");
                JMenuItem addNewCustomerItem = new JMenuItem("Add New Customer");
                JMenuItem viewCustomerListItem = new JMenuItem("View Customer List");
                JMenuItem generateReportItem = new JMenuItem("Generate Report");
                JMenuItem userGuideItem = new JMenuItem("UserGuide");
                JMenuItem aboutItem = new JMenuItem("About");
                JMenuItem settingsItem = new JMenuItem("Settings");

                // Add menu items to "File" menu
                fileMenu.add(dashboardItem);
                fileMenu.add(exitItem);
                
                // Add menu items to "Tickets" menu
                ticketsMenu.add(createTicketItem);
                ticketsMenu.add(viewOpenTicketsItem);
                ticketsMenu.add(searchTicketItem);
                
                // Add menu items to "Customers" menu
                customersMenu.add(addNewCustomerItem);
                customersMenu.add(viewCustomerListItem);
                
                // Add menu items to "Reports" menu
                reportsMenu.add(generateReportItem);
                
                // Add menu items to "Help" menu
                helpMenu.add(userGuideItem);
                helpMenu.add(aboutItem);
                helpMenu.add(settingsItem);

                // Add menus to the menu bar
                menuBar.add(fileMenu);
                menuBar.add(ticketsMenu);
                menuBar.add(customersMenu);
                menuBar.add(reportsMenu);
                menuBar.add(helpMenu);

                // Set the menu bar for the JFrame
                frame.setJMenuBar(menuBar);

                // Create a panel for holding the current form (we'll update this later)
                JPanel contentPanel = new JPanel();
                contentPanel.add(dashboardPanel);
                // Add DashboardPanel as the default form when the app starts
                contentPanel.revalidate();
                contentPanel.repaint();
                frame.add(contentPanel); // Add to center of the window

                // Make the window visible
                frame.setVisible(true);

                // ActionListener for "Exit" menu item (close the app)
                exitItem.addActionListener(e -> System.exit(0));

                // ActionListener for "Dashboard" menu item (show the Dashboard form)
                dashboardItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Replace the current content with the DashboardPanel
                        contentPanel.removeAll(); // Remove previous content
                        contentPanel.add(dashboardPanel); // Add new Dashboard form
                        contentPanel.revalidate(); // Revalidate the panel to reflect changes
                        contentPanel.repaint(); // Repaint the panel to show the updates
                    }
                });
                // ActionListener for "Create New Ticket" menu item (show the Create New Ticket form)
                createTicketItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Replace the current content with the CreateNewTicketPanel
                        contentPanel.removeAll(); // Remove previous content
                        contentPanel.add(createNewTicketPanel); // Add new Create New Ticket form
                        contentPanel.revalidate(); // Revalidate the panel to reflect changes
                        contentPanel.repaint(); // Repaint the panel to show the updates
                    }
                });      
		// ActionListener for "View Open Tickets"
		viewOpenTicketsItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        contentPanel.removeAll();
                        contentPanel.add(viewOpenTicketsPanel);
                        contentPanel.revalidate();
                        contentPanel.repaint();
                    }
                });
                
                // ActionListener for "Search Tickets"
		searchTicketItem.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        contentPanel.removeAll();
                        contentPanel.add(new SearchTicketsPanel(ticketManager));
                        contentPanel.revalidate();
                        contentPanel.repaint();
                    }
                });
                
                // ActionListener for "Add New Customer"
                addNewCustomerItem.addActionListener(new ActionListener() {
                    @Override
                     public void actionPerformed(ActionEvent e) {
                         contentPanel.removeAll();
                         contentPanel.add(new AddNewCustomerPanel());
                         contentPanel.revalidate();
                         contentPanel.repaint();
                    }
                });
                
                // ActionListener for "View Customer List"
                viewCustomerListItem.addActionListener(new ActionListener() {
                    @Override
                     public void actionPerformed(ActionEvent e) {
                         contentPanel.removeAll();
                         contentPanel.add(new ViewCustomerListPanel());
                         contentPanel.revalidate();
                         contentPanel.repaint();
                    }
                });
                
                // ActionListener for "Generate Reports"
                generateReportItem.addActionListener(new ActionListener() {
                    @Override
                     public void actionPerformed(ActionEvent e) {
                         contentPanel.removeAll();
                         contentPanel.add(new GenerateReportPanel(ticketManager, CustomerManager.getInstance()));
                         contentPanel.revalidate();
                         contentPanel.repaint();
                    }
                });
                
                // ActionListener for "UserGuide"
                userGuideItem.addActionListener(new ActionListener() {
                    @Override
                     public void actionPerformed(ActionEvent e) {
                         contentPanel.removeAll();
                         contentPanel.add(new UserGuidePanel());
                         contentPanel.revalidate();
                         contentPanel.repaint();
                    }
                });
                
                // ActionListener for "About"
                aboutItem.addActionListener(new ActionListener() {
                    @Override
                     public void actionPerformed(ActionEvent e) {
                         contentPanel.removeAll();
                         contentPanel.add(new AboutPanel());
                         contentPanel.revalidate();
                         contentPanel.repaint();
                    }
                });
                // ActionListener for "Settings"
                settingsItem.addActionListener(new ActionListener() {
                    @Override
                     public void actionPerformed(ActionEvent e) {
                         contentPanel.removeAll();
                         contentPanel.add(new SettingsPanel());
                         contentPanel.revalidate();
                         contentPanel.repaint();
                    }
                });
            }
        });
    }
}

 