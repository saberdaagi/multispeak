package com.teck.up.soap.UIModel;

import com.reseration.xml.Train;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.GregorianCalendar;

@Data
@NoArgsConstructor
public class TrainDTO {


    private Long id_train;

    private String V_depart;

    private String V_arrive;
    @DateTimeFormat
    private LocalDateTime date_depart;
    @DateTimeFormat
    private LocalDateTime date_arrive;

    private int capacite;

    private int nbr_place_actuel;

    public Train toTrain(TrainDTO trainDTO) {
        Train train = new Train();
        train.setId(BigInteger.valueOf(trainDTO.getId_train()));
        train.setVDepart(trainDTO.getV_depart());


        try {
            GregorianCalendar gcal = GregorianCalendar.from(trainDTO.getDate_arrive().atZone(ZoneId.systemDefault()));
            XMLGregorianCalendar date_arrive = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);


            GregorianCalendar gcal2 = GregorianCalendar.from(trainDTO.getDate_depart().atZone(ZoneId.systemDefault()));
            XMLGregorianCalendar dateDepart = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal2);

            train.setDateArrive(date_arrive);
            train.setDateDepart(dateDepart);
        } catch (
                DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        train.setNbrPlaceActuel(BigInteger.valueOf(trainDTO.getNbr_place_actuel()));
        train.setCapacite(BigInteger.valueOf(trainDTO.getCapacite()));
        return train;
    }

}
