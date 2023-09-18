package learning.app.demo.entites;

import jakarta.persistence.*;
import learning.app.demo.enums.TypeSentiment;

@Entity
@Table(name = "SENTIMENT")
public class Sentiment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    private TypeSentiment type;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    public Sentiment() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public TypeSentiment getType() {
        return type;
    }

    public void setType(TypeSentiment type) {
        this.type = type;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Sentiment(int id, String text, TypeSentiment type, Client client) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.client = client;
    }
}
