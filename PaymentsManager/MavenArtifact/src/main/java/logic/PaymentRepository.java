package logic;

import java.util.ArrayList;

public interface PaymentRepository {

     void AddToRepo(Payment payment);
     void DeletePayment(int ID);
     ArrayList<Payment> getRepo();

}
