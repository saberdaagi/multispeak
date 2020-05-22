package com.teck.up.multispeak;


import com.hkeya.xml.train.Train;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

@Component
public class TrainRepository {
    private static final Map<Integer, Train> Trains = new HashMap<>();

    @PostConstruct
    public void initData() {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(new Date());
        try {
            XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            Train Train = new Train();
            Train.setId(BigInteger.valueOf(0));
            Train.setVilleDep("Sajal1");
            Train.setVilleArriv("Pune");
            Train.setIntervalleTemps(BigInteger.valueOf(5));
            Train.setJourDep(date2);
            Trains.put(0, Train);

            Train = new Train();
            Train.setId(BigInteger.valueOf(1));
            Train.setVilleDep("Sajal2");
            Train.setVilleArriv("Pune");
            Train.setIntervalleTemps(BigInteger.valueOf(5));
            Train.setJourDep(date2);
            Trains.put(1, Train);

            Train = new Train();
            Train.setId(BigInteger.valueOf(2));
            Train.setVilleDep("Sajal3");
            Train.setVilleArriv("Pune");
            Train.setIntervalleTemps(BigInteger.valueOf(5));
            Train.setJourDep(date2);
            Trains.put(2, Train);

        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }




    }

    public Train findTrain(BigInteger train) {

        return Trains.get(0);
    }
}