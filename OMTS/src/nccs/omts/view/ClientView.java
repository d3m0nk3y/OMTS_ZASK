package nccs.omts.view;

import java.sql.*;
import java.util.*;
import nccs.omts.control.*;
import nccs.omts.repository.*;
import nccs.omts.model.*;

/**
 *
 * @author specter
 */
public class ClientView {

    CustomersController customerController = new CustomersController();
    BookingController bookingController=new BookingController();
    
    public void movie() throws SQLException {
       
        List<Movies> movie = MoviesRepository.getMovies();

        System.out.println("Movie ID : Movie Name");
        for (Movies movies : movie) {
            System.out.println(movies.getMovie_id() + "\t" + movies.getMovie_name());
        }

    }
    

    public void user(int a) throws SQLException {
        UserViewRepository userRepository = new UserViewRepository();
        List<UserView> user = userRepository.getUserView(a);
        System.out.println("Show id |\t movie name |\t  hall name |\t schedule");
        System.out.println("---------------------------------------------------");
        for (UserView u : user) {
            System.out.println(u.getShow_id()+"|\t"+u.getMovie_name()+"|\t"+u.getHall_name()+"|\t"+u.getSchedule_name());
        }
    }
    public void movie(int id) throws SQLException {
        List<Movies> movie = MoviesRepository.getMoviesById(id);
    
        System.out.println("Movie description:");
        for (Movies m : movie) {
            System.out.println("Movie:"+m.getMovie_name());
            System.out.println("Genre:"+m.getGenre_id());
            System.out.println("Length:"+m.getLength()+" min");
            System.out.println("Director:"+m.getDirector());
            System.out.println("Casts:"+m.getCast());
            System.out.println("Rating:"+m.getRating());
        }
    }

    public void mainPage() throws SQLException {

        System.out.println("Welcome " +customerController.getCurrentUser().getCustomer_name());
        Scanner scanner = new Scanner(System.in);

        int moviesId,showId;
        char book;
        do {
            movie();

            System.out.print("Select a movie or 0 to exit :");
            moviesId = scanner.nextInt();

            if (moviesId == 0) {
                return;
            }
            else{
                movie(moviesId);
                user(moviesId);
                System.out.print("Select a show or press 0 to return:");
                showId = scanner.nextInt();
                if (showId==0) {
                    return;
                }
                else{
                    System.out.println("Do you want to book this show?(y/n)");
                    book = scanner. next().charAt(0);
                    if(book=='y'||book=='Y'){
                        /*if (showId != 0) {
                            bookingController.addToBooking(showId, customerController.getCurrentUser());
                        }*/
                        System.out.println("Thank you for booking");
                    }
                    else{
                        return;
                    }
                }
            }
        } while (true);
    }

    public boolean logIn() throws SQLException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please login by your email: ");
        String email = scanner.next();
        return customerController.login(email);

    }
}
