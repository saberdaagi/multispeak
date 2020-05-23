package com.teck.up.rest.api;

import com.teck.up.rest.domain.ClientEntity;
import com.teck.up.rest.dto.ClientDTO;
import com.teck.up.rest.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ClientController {


    final ClientService ClientService;


    @GetMapping("/all")
    public List<ClientDTO> listOfClients() {

        return ClientService.getAll();
    }

    @GetMapping("/get/{id}")
    public ClientDTO getClient(@PathVariable Long id) {
        ClientEntity client = ClientService.getClient(id);
        return client.toClientDTO(client);
    }

    @PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void addClient(@RequestBody ClientDTO clientDTO) {
        ClientService.add(clientDTO.toClient(clientDTO));
    }

    @DeleteMapping("/remove/{id}")
    public void removeClient(@Valid @PathVariable Long id) {
        ClientService.delete(id);
    }

    @PutMapping("/update")
    public void updateClient(@Valid @RequestBody ClientDTO clientDTO) {
        ClientService.update(clientDTO.toClient(clientDTO));
    }
}
