package app.music.model;

import app.Review.model.Favourite;
import app.Review.model.Review;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column
    @Enumerated(EnumType.STRING)
    private Genre genre; //ROCK, CLASSIC, POP, KPOP;

    @Column
    private String imageUrl;

    @Column(nullable = false)
    private LocalDateTime releaseDate;

    @OneToMany(mappedBy = "album", fetch = FetchType.EAGER)
    private List<Review> reviews;

    @OneToMany(mappedBy = "album", fetch = FetchType.EAGER)
    private List<Favourite> favourites;

    @ManyToOne
    private Artist artist;



}
