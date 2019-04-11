package logic;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

public class Serializer {

    private XMLEncoder encoder;
    private XMLDecoder decoder;

    //SERIALIZATION METHODS

    public void SerializePast(PastPaymentRepository pastRepo)
    {
        try
        {
            encoder=new XMLEncoder(new BufferedOutputStream(new FileOutputStream("PAST.xml")));
        }
        catch(FileNotFoundException fileNotFound)
        {
            System.out.println("ERROR: While Creating or Opening the File f.xml");
        }
        encoder.writeObject(pastRepo);
        encoder.close();
    }

    public void SerializeFuture(FuturePaymentRepository futureRepo)
    {
        try
        {
            encoder=new XMLEncoder(new BufferedOutputStream(new FileOutputStream("FUTURE.xml")));
        }
        catch(FileNotFoundException fileNotFound)
        {
            System.out.println("ERROR: While Creating or Opening the File f.xml");
        }
        encoder.writeObject(futureRepo);
        encoder.close();
    }

    public void SerializeAll(PastPaymentRepository pastRepo, FuturePaymentRepository futureRepo)
    {
        SerializePast(pastRepo);
        SerializeFuture(futureRepo);
    }

    //DESERIALIZATION METHODS

    public PastPaymentRepository DeserializePast()
    {
        try {
            decoder=new XMLDecoder(new BufferedInputStream(new FileInputStream("PAST.xml")));
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File dvd.xml not found");
        }
        PastPaymentRepository pastRepo=(PastPaymentRepository) decoder.readObject();
        System.out.println(pastRepo);
        return pastRepo;
    }

    public FuturePaymentRepository DeserializeFuture()
    {
        try {
            decoder=new XMLDecoder(new BufferedInputStream(new FileInputStream("FUTURE.xml")));
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: File dvd.xml not found");
        }
        FuturePaymentRepository futureRepo=(FuturePaymentRepository) decoder.readObject();
        System.out.println(futureRepo);
        return futureRepo;
    }
}
