package learning.app.demo.controller;

import learning.app.demo.entites.Client;
import learning.app.demo.entites.Sentiment;
import learning.app.demo.enums.TypeSentiment;
import learning.app.demo.service.SentimentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "sentiment", produces = APPLICATION_JSON_VALUE)
public class SentimentController {

    private SentimentService sentimentService;

    public SentimentController(SentimentService sentimentService) {
        this.sentimentService = sentimentService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Sentiment sentiment){
        this.sentimentService.create(sentiment);
    }

    @GetMapping(path="{id}",produces = APPLICATION_JSON_VALUE)
    public Sentiment read(@PathVariable int id){
        return this.sentimentService.read(id);
    }

 @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Sentiment> read(@RequestParam(required = false) TypeSentiment type){
        return this.sentimentService.find(type);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @PutMapping(path = "{id}", consumes = APPLICATION_JSON_VALUE)
    public void modify(@PathVariable int id, @RequestBody Sentiment sentiment){
        this.sentimentService.modify(id, sentiment);
    }

    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @DeleteMapping(path="{id}",produces = APPLICATION_JSON_VALUE)
    public void delete(@PathVariable int id){
        this.sentimentService.delete(id);
    }
}
