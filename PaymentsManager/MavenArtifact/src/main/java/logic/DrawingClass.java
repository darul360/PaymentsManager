package logic;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class DrawingClass {
    private ArrayList<PastPayment> localList;
    private int ID;
    private float price;
    private String description;
    private Date date;

    public DrawingClass(ArrayList<PastPayment> pastPayment){
        this.localList = pastPayment;
    }

    private ArrayList<PastPayment> returnPaymentsInMonth(int month){
        ArrayList<PastPayment> turboLocalList = new ArrayList<PastPayment>();
        for (PastPayment pp : localList){
            if(pp.getPaymentDate().getMonth() == month)
                turboLocalList.add(pp);
        }
        return turboLocalList;
    }

    public int returnPaymentsBetweenDatesPerscent(short num,int monthOne, int monthLast,int dayOne,int dayLast)
    {
        ArrayList<PastPayment> turboLocalList = new ArrayList<PastPayment>();
        for(PastPayment pp : localList){
            LocalDate date = pp.getPaymentDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if(date.getMonthValue() >= monthOne && date.getMonthValue() <=monthLast && date.getDayOfMonth() >= dayOne && date.getDayOfMonth()  <= dayLast && pp.getPaymentType()==num)
                turboLocalList.add(pp);
        }
        return turboLocalList.size();
    }

    public float returnPaymentsBetweenDatesAmmount(short num,int monthOne, int monthLast,int dayOne,int dayLast)
    {
        ArrayList<PastPayment> turboLocalList = new ArrayList<PastPayment>();
        for(PastPayment pp : localList){
            LocalDate date = pp.getPaymentDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if(date.getMonthValue() >= monthOne && date.getMonthValue() <=monthLast && date.getDayOfMonth() >= dayOne && date.getDayOfMonth()  <= dayLast && pp.getPaymentType()==num)
                turboLocalList.add(pp);
        }
        float sum = 0;
        for(PastPayment pp:turboLocalList){
            sum+=pp.getPaymentPrice();
        }
        return sum;
    }

    public int ReturnTypePastPayments(short typeNum){
        ArrayList<PastPayment> turboLocalList = new ArrayList<PastPayment>();
        for(PastPayment pp : localList){
            if(pp.getType() == typeNum){
                turboLocalList.add(pp);
            }
        }
        return turboLocalList.size();
    }

    public float returnSumOfPayments(short typeNum){
        ArrayList<PastPayment> turboLocalList = new ArrayList<PastPayment>();
        for(PastPayment pp : localList){
            if(pp.getType() == typeNum){
                turboLocalList.add(pp);
            }
        }
        float sum =0;

        for(PastPayment pp: turboLocalList){
            sum+=pp.getPaymentPrice();
        }
        return sum;
    }



    public void DebugPaymentsInMonth(int month){
        ArrayList<PastPayment> pastPayments = new ArrayList<PastPayment>();
        pastPayments = returnPaymentsInMonth(month);
        for (PastPayment pp : pastPayments ) {
            System.out.println(pp.toString());
        }
    }



}
