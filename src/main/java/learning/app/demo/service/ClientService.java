package learning.app.demo.service;

import learning.app.demo.entites.Client;
import learning.app.demo.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public void create(Client client){
        Client clientBDD = this.clientRepository.findByEmail(client.getEmail());
        if (clientBDD == null)
            this.clientRepository.save(client);
    }

    public List<Client> find(){
        return this.clientRepository.findAll();
    }

    public Client read(int id) {
        Optional<Client> optionalClient = this.clientRepository.findById(id);
        return optionalClient.orElse(null);
    }

    public Client readOrCreate(Client client) {
        Client clientBDD = this.clientRepository.findByEmail(client.getEmail());
        if (clientBDD == null)
            clientBDD = this.clientRepository.save(client);
        return clientBDD;
    }


    public void modify(int id, Client client) {
        Client clientDB = this.read(id);
        if (clientDB.getId() == client.getId()){
            clientDB.setEmail(client.getEmail());
            this.clientRepository.save(clientDB);
        }
    }

    public void delete(int id) {
        this.clientRepository.deleteById(id);
    }
}
