package learning.app.demo.service;

import learning.app.demo.entites.Client;
import learning.app.demo.entites.Sentiment;
import learning.app.demo.enums.TypeSentiment;
import learning.app.demo.repository.SentimentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class SentimentService {

    private ClientService clientService;
    private SentimentRepository sentimentRepository;

    public SentimentService(ClientService clientService, SentimentRepository sentimentRepository) {
        this.clientService = clientService;
        this.sentimentRepository = sentimentRepository;
    }

    public void create(Sentiment sentiment){
        Client client = this.clientService.readOrCreate(sentiment.getClient());
        sentiment.setClient(client);
        if (sentiment.getText().contains("pas"))
            sentiment.setType(TypeSentiment.POSITIF);
        else
            sentiment.setType(TypeSentiment.NEGATIF);
        this.sentimentRepository.save(sentiment);
    }

    public List<Sentiment> find(TypeSentiment type){
        if (type == null)
            return this.sentimentRepository.findAll();
        else{
            return this.sentimentRepository.findByType(type);
        }
    }
    public Sentiment read(int id) {
        Optional<Sentiment> optionalSentiment = this.sentimentRepository.findById(id);
        return optionalSentiment.orElse(null);
    }

    public void delete(int id) {
        this.sentimentRepository.deleteById(id);
    }

    public void modify(int id, Sentiment sentiment) {
        Sentiment sentimentDBB= this.read(id);
        if(sentimentDBB.getId() == sentiment.getId()){
            sentimentDBB.setText(sentiment.getText());
            sentimentDBB.setType(sentiment.getType());
            sentimentDBB.setClient(sentiment.getClient());
            this.sentimentRepository.save(sentimentDBB);
        }
    }
}
