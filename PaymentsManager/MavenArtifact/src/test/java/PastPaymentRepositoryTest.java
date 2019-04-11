import logic.PastPayment;
import logic.PastPaymentRepository;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class PastPaymentRepositoryTest {

    @Test
    public void toString_TEST() {
        Date date = new Date(2019,3,12);
        Date date2 = new Date(2018, 4, 10);
        PastPayment pastPayment = new PastPayment(1,"pszne obiad",21.37f,(short)2, "bardzo pszne", date);
        PastPayment pastPayment2 = new PastPayment(2,"pszne obiad2",14.10f,(short)1, "bardzo pszne2", date2);

        PastPaymentRepository pastRepo = new PastPaymentRepository();
        pastRepo.AddToRepo(pastPayment);
        pastRepo.AddToRepo(pastPayment2);

        assertEquals("1,pszne obiad,21.37,2,bardzo pszne,04/12/3919 00:00:00\n" +
                "2,pszne obiad2,14.1,1,bardzo pszne2,05/10/3918 00:00:00\n", pastRepo.toString());
    }

    @Test
    public void addToRepo() {
        Date date = new Date(2019,3,12);
        Date date2 = new Date(2018, 4, 10);
        PastPayment pastPayment = new PastPayment(1,"pszne obiad",21.37f,(short)2, "bardzo pszne", date);
        PastPayment pastPayment2 = new PastPayment(2,"pszne obiad2",14.10f,(short)1, "bardzo pszne2", date2);

        PastPaymentRepository pastRepo = new PastPaymentRepository();
        pastRepo.AddToRepo(pastPayment);
        pastRepo.AddToRepo(pastPayment2);

        assertEquals(pastRepo.getRepo().size(), 2);
    }

    @Test
    public void deletePayment() {
        Date date = new Date(2019,3,12);
        Date date2 = new Date(2018, 4, 10);
        PastPayment pastPayment = new PastPayment(1,"pszne obiad",21.37f,(short)2, "bardzo pszne", date);
        PastPayment pastPayment2 = new PastPayment(2,"pszne obiad2",14.10f,(short)1, "bardzo pszne2", date2);

        PastPaymentRepository pastRepo = new PastPaymentRepository();
        pastRepo.AddToRepo(pastPayment);
        pastRepo.AddToRepo(pastPayment2);

        pastRepo.DeletePayment(1);

        assertEquals("2,pszne obiad2,14.1,1,bardzo pszne2,05/10/3918 00:00:00\n", pastRepo.toString());
    }

    @Test
    public void getRepo() {
        Date date = new Date(2019,3,12);
        Date date2 = new Date(2018, 4, 10);
        PastPayment pastPayment = new PastPayment(1,"pszne obiad",21.37f,(short)2, "bardzo pszne", date);
        PastPayment pastPayment2 = new PastPayment(2,"pszne obiad2",14.10f,(short)1, "bardzo pszne2", date2);

        PastPaymentRepository pastRepo = new PastPaymentRepository();
        pastRepo.AddToRepo(pastPayment);
        pastRepo.AddToRepo(pastPayment2);

        assertEquals(pastRepo.getRepo().get(0), pastPayment);
        assertEquals(pastRepo.getRepo().get(1), pastPayment2);
    }
}