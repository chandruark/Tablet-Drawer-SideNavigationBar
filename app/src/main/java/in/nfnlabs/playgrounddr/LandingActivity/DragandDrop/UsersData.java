package in.nfnlabs.playgrounddr.LandingActivity.DragandDrop;

import java.util.ArrayList;
import java.util.List;


public class UsersData {

    private List<User> usersList = new ArrayList<User>() {
        {
            add(new User(0, "Frederick Hoffman", "https://randomuser.me/api/portraits/men/52.jpg", "Waiting List"));
            add(new User(1, "Calvin Young", "https://randomuser.me/api/portraits/men/78.jpg", "Waiting List"));
            add(new User(2, "Jeanette Reid", "https://randomuser.me/api/portraits/women/37.jpg", "Waiting List"));
            add(new User(3, "Flenn Wilson", "https://randomuser.me/api/portraits/men/40.jpg", "Waiting List"));
            add(new User(4, "Martin Holland", "https://randomuser.me/api/portraits/men/0.jpg", "Waiting List"));
            add(new User(5, "Jeanette Simmmons", "https://randomuser.me/api/portraits/women/3.jpg", "Appointment (9:00 AM - 2:00 PM)"));
            add(new User(6, "Wallace Lambert", "https://randomuser.me/api/portraits/men/53.jpg", "Appointment (9:00 AM - 2:00 PM)"));
            add(new User(7, "Andy Clark", "https://randomuser.me/api/portraits/men/68.jpg", "Appointment (9:00 AM - 2:00 PM)"));
            add(new User(8, "olivia obrien", "https://randomuser.me/api/portraits/women/93.jpg", "Appointment (9:00 AM - 2:00 PM)"));
            add(new User(9, "Debbie Bennett", "https://randomuser.me/api/portraits/women/34.jpg", "Appointment (5:00 PM - 8:00 PM)"));
            add(new User(10, "Bernice Lawson", "https://randomuser.me/api/portraits/women/20.jpg", "Appointment (5:00 PM - 8:00 PM)"));
            add(new User(11, "Camila Elliott", "https://randomuser.me/api/portraits/women/60.jpg", "Appointment (5:00 PM - 8:00 PM)"));
            add(new User(12, "Gerald Webb", "https://randomuser.me/api/portraits/men/55.jpg", "Appointment (5:00 PM - 8:00 PM)"));
            add(new User(13, "Russell Hart", "https://randomuser.me/api/portraits/men/18.jpg", "Completed Appoinments"));
            add(new User(14, "Joyce Mccoy", "https://randomuser.me/api/portraits/women/82.jpg", "Completed Appoinments"));
            add(new User(15, "Daryl Banks", "https://randomuser.me/api/portraits/men/4.jpg", "Completed Appoinments"));
            add(new User(16, "Veronica Vargas", "https://randomuser.me/api/portraits/women/14.jpg", "Completed Appoinments"));
            add(new User(17, "Natalie Jacobs", "https://randomuser.me/api/portraits/women/0.jpg", "Completed Appoinments"));
            add(new User(18, "Beverly Kennedy", "https://randomuser.me/api/portraits/women/30.jpg", "Completed Appoinments"));
        }
    };

    private List<String> userTypeList = new ArrayList<String>() {
        {
            add("Waiting List");
            add("Appointment (9:00 AM - 2:00 PM)");
            add("Appointment (5:00 PM - 8:00 PM)");
            add("Completed Appoinments");
        }
    };

    public List<User> getUsersList() {
        return usersList;
    }

    public List<String> getUserTypeList() {
        return userTypeList;
    }
}
