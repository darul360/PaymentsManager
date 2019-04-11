import logic.FuturePayment;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FuturePaymentTest {

    @Test
    public void toString_TEST() {
        FuturePayment futurePayment = new FuturePayment(1,"pszne obiad",21.37f,(short)2, "bardzo pszne");
        assertEquals("1,pszne obiad,21.37,2,bardzo pszne", futurePayment.toString());
    }

    @Test
    public void archive() {
    }

    @Test
    public void getPaymentID() {
        FuturePayment futurePayment = new FuturePayment(1,"pszne obiad",21.37f,(short)2, "bardzo pszne");
        assertEquals(1, futurePayment.getPaymentID());
    }

    @Test
    public void getPaymentName() {
        FuturePayment futurePayment = new FuturePayment(1,"pszne obiad",21.37f,(short)2, "bardzo pszne");
        assertEquals("pszne obiad", futurePayment.getPaymentName());
    }

    @Test
    public void getPaymentPrice() {
        FuturePayment futurePayment = new FuturePayment(1,"pszne obiad",21.37f,(short)2, "bardzo pszne");
        assertEquals(21.37f, futurePayment.getPaymentPrice(), 0.0f);
    }

    @Test
    public void getPaymentType() {
        FuturePayment futurePayment = new FuturePayment(1,"pszne obiad",21.37f,(short)2, "bardzo pszne");
        assertEquals((short)2, futurePayment.getPaymentType());
    }

    @Test
    public void getPaymentDescription() {
        FuturePayment futurePayment = new FuturePayment(1,"pszne obiad",21.37f,(short)2, "bardzo pszne");
        assertEquals("bardzo pszne", futurePayment.getPaymentDescription());
    }

    @Test
    public void setPaymentID() {
        FuturePayment futurePayment = new FuturePayment(1,"pszne obiad",21.37f,(short)2, "bardzo pszne");
        futurePayment.setPaymentID(2);
        assertEquals(2, futurePayment.getPaymentID());
    }

    @Test
    public void setPaymentName() {
        FuturePayment futurePayment = new FuturePayment(1,"pszne obiad",21.37f,(short)2, "bardzo pszne");
        futurePayment.setPaymentID(2);
        assertEquals(2, futurePayment.getPaymentID());
    }

    @Test
    public void setPaymentPrice() {
        FuturePayment futurePayment = new FuturePayment(1,"pszne obiad",21.37f,(short)2, "bardzo pszne");
        futurePayment.setPaymentPrice(14.10f);
        assertEquals(14.10f, futurePayment.getPaymentPrice(), 7.27f);
    }

    @Test
    public void setPaymentType() {
        FuturePayment futurePayment = new FuturePayment(1,"pszne obiad",21.37f,(short)2, "bardzo pszne");
        futurePayment.setPaymentType((short)3);
        assertEquals((short)3, futurePayment.getPaymentType());
    }

    @Test
    public void setPaymentDescription() {
        FuturePayment futurePayment = new FuturePayment(1,"pszne obiad",21.37f,(short)2, "bardzo pszne");
        futurePayment.setPaymentDescription("NewDescription");
        assertEquals("NewDescription", futurePayment.getPaymentDescription());
    }
}