package learning.app.demo.repository;


import learning.app.demo.entites.Sentiment;
import learning.app.demo.enums.TypeSentiment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SentimentRepository extends JpaRepository<Sentiment, Integer> {

        List<Sentiment> findByType(TypeSentiment type);
}
