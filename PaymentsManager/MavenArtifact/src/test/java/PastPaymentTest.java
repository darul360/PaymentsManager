import logic.PastPayment;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class PastPaymentTest {

    @Test
    public void toString_TEST() {
        Date date = new Date(2019,3,12);
        PastPayment pastPayment = new PastPayment(1,"pszne obiad",21.37f,(short)2, "bardzo pszne", date);
        assertEquals("1,pszne obiad,21.37,2,bardzo pszne,04/12/3919 00:00:00", pastPayment.toString());
    }

    @Test
    public void archive() {

    }

    @Test
    public void getPaymentID() {
        Date date = new Date(2019,3,12);
        PastPayment pastPayment = new PastPayment(1,"pszne obiad",21.37f,(short)2, "bardzo pszne", date);
        assertEquals(1, pastPayment.getPaymentID());
    }

    @Test
    public void getPaymentName() {
        Date date = new Date(2019,3,12);
        PastPayment pastPayment = new PastPayment(1,"pszne obiad",21.37f,(short)2, "bardzo pszne", date);
        assertEquals("pszne obiad", pastPayment.getPaymentName());
    }

    @Test
    public void getPaymentPrice() {
        Date date = new Date(2019,3,12);
        PastPayment pastPayment = new PastPayment(1,"pszne obiad",21.37f,(short)2, "bardzo pszne", date);
        assertEquals(21.37f, pastPayment.getPaymentPrice(),0.0f);
    }

    @Test
    public void getPaymentType() {
        Date date = new Date(2019,3,12);
        PastPayment pastPayment = new PastPayment(1,"pszne obiad",21.37f,(short)2, "bardzo pszne", date);
        assertEquals(2, pastPayment.getPaymentType());
    }

    @Test
    public void getPaymentDescription() {
        Date date = new Date(2019,3,12);
        PastPayment pastPayment = new PastPayment(1,"pszne obiad",21.37f,(short)2, "bardzo pszne", date);
        assertEquals("bardzo pszne", pastPayment.getPaymentDescription());
    }

    @Test
    public void setPaymentID() {
        Date date = new Date(2019,3,12);
        PastPayment pastPayment = new PastPayment(1,"pszne obiad",21.37f,(short)2, "bardzo pszne", date);
        pastPayment.setPaymentID(2);
        assertEquals(2, pastPayment.getPaymentID());
    }

    @Test
    public void setPaymentName() {
        Date date = new Date(2019,3,12);
        PastPayment pastPayment = new PastPayment(1,"pszne obiad",21.37f,(short)2, "bardzo pszne", date);
        pastPayment.setPaymentName("NewName");
        assertEquals("NewName", pastPayment.getPaymentName());
    }

    @Test
    public void setPaymentPrice() {
        Date date = new Date(2019,3,12);
        PastPayment pastPayment = new PastPayment(1,"pszne obiad",21.37f,(short)2, "bardzo pszne", date);
        pastPayment.setPaymentPrice(14.10f);
        assertEquals(14.10f, pastPayment.getPaymentPrice(), 7.27f);
    }

    @Test
    public void setPaymentType() {
        Date date = new Date(2019,3,12);
        PastPayment pastPayment = new PastPayment(1,"pszne obiad",21.37f,(short)2, "bardzo pszne", date);
        pastPayment.setPaymentType((short)3);
        assertEquals((short)3, pastPayment.getPaymentType());
    }

    @Test
    public void setPaymentDescription() {
        Date date = new Date(2019,3,12);
        PastPayment pastPayment = new PastPayment(1,"pszne obiad",21.37f,(short)2, "bardzo pszne", date);
        pastPayment.setPaymentDescription("NewDescription");
        assertEquals("NewDescription", pastPayment.getPaymentDescription());
    }

    @Test
    public void getPaymentDate() {
        Date date = new Date(2019,3,12);
        PastPayment pastPayment = new PastPayment(1,"pszne obiad",21.37f,(short)2, "bardzo pszne", date);
        assertEquals( new Date(2019,3,12), pastPayment.getPaymentDate());
    }

    @Test
    public void setPaymentDate() {
        Date date = new Date(2019,3,12);
        Date date2 = new Date(2008,3,12);
        PastPayment pastPayment = new PastPayment(1,"pszne obiad",21.37f,(short)2, "bardzo pszne", date);
        pastPayment.setPaymentDate(date2);
        assertEquals(new Date(2008,3,12), pastPayment.getPaymentDate());
    }
}