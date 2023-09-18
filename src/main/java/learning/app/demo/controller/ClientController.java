package learning.app.demo.controller;

import learning.app.demo.entites.Client;
import learning.app.demo.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "client")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Client client){
        this.clientService.create(client);

    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Client> find(){
        return this.clientService.find();
    }

    @GetMapping(path="{id}",produces = APPLICATION_JSON_VALUE)
    public Client read(@PathVariable int id){
        return this.clientService.read(id);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @PutMapping(path = "{id}", consumes = APPLICATION_JSON_VALUE)
    public void modify(@PathVariable int id, @RequestBody Client client){
        this.clientService.modify(id, client);
    }
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @DeleteMapping(path="{id}",produces = APPLICATION_JSON_VALUE)
    public void delete(@PathVariable int id){
        this.clientService.delete(id);
    }
}

