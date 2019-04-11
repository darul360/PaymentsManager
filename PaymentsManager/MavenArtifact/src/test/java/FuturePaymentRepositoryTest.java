import logic.FuturePayment;
import logic.FuturePaymentRepository;
import org.junit.Test;

import static org.junit.Assert.*;

public class FuturePaymentRepositoryTest {

    @Test
    public void toString_TEST() {
        FuturePayment futurePayment = new FuturePayment(1,"pszne obiad",21.37f,(short)2, "bardzo pszne");
        FuturePayment futurePayment2 = new FuturePayment(2,"pszne obiad2",14.10f,(short)3, "bardzo pszne2");

        FuturePaymentRepository futureRepo = new FuturePaymentRepository();

        futureRepo.AddToRepo(futurePayment);
        futureRepo.AddToRepo(futurePayment2);

        assertEquals("1,pszne obiad,21.37,2,bardzo pszne\n" +
                "2,pszne obiad2,14.1,3,bardzo pszne2\n", futureRepo.toString());
    }

    @Test
    public void addToRepo() {
        FuturePayment futurePayment = new FuturePayment(1,"pszne obiad",21.37f,(short)2, "bardzo pszne");
        FuturePayment futurePayment2 = new FuturePayment(2,"pszne obiad2",14.10f,(short)3, "bardzo pszne2");

        FuturePaymentRepository futureRepo = new FuturePaymentRepository();

        futureRepo.AddToRepo(futurePayment);
        futureRepo.AddToRepo(futurePayment2);

        assertEquals("1,pszne obiad,21.37,2,bardzo pszne\n" +
                "2,pszne obiad2,14.1,3,bardzo pszne2\n", futureRepo.toString());
    }

    @Test
    public void deletePayment() {
        FuturePayment futurePayment = new FuturePayment(1,"pszne obiad",21.37f,(short)2, "bardzo pszne");
        FuturePayment futurePayment2 = new FuturePayment(2,"pszne obiad2",14.10f,(short)3, "bardzo pszne2");

        FuturePaymentRepository futureRepo = new FuturePaymentRepository();

        futureRepo.AddToRepo(futurePayment);
        futureRepo.AddToRepo(futurePayment2);
        futureRepo.DeletePayment(2);

        assertEquals(1, futureRepo.getRepo().size());
    }

    @Test
    public void getRepo() {
        FuturePayment futurePayment = new FuturePayment(1,"pszne obiad",21.37f,(short)2, "bardzo pszne");
        FuturePayment futurePayment2 = new FuturePayment(2,"pszne obiad2",14.10f,(short)3, "bardzo pszne2");

        FuturePaymentRepository futureRepo = new FuturePaymentRepository();

        futureRepo.AddToRepo(futurePayment);
        futureRepo.AddToRepo(futurePayment2);

        assertEquals(futurePayment, futureRepo.getRepo().get(0));
        assertEquals(futurePayment2, futureRepo.getRepo().get(1));

    }
}