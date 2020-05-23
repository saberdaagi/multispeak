package com.teck.up.soap.UIModel;

import com.reseration.xml.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientDTO {

    private Long id_client;

    private String nom;

    private String prenom;


    private List<ReservationDTO> resevations;


    //******************Mode Mapper*************************
    public Client toClient(ClientDTO clientDTO) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(clientDTO, Client.class);
    }

}
