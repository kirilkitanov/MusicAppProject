package app.user.model;


import app.Review.model.Favourite;
import app.Review.model.Review;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private LocalDateTime createdOn;

    @Column(nullable = false)
    private LocalDateTime updatedOn;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserRole role; //ADMIN, FAN, ARTIST;

    @Column
    private String firstName;

    @Column
    private String lastName;



    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Review> reviews;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Favourite> favourites;



}
