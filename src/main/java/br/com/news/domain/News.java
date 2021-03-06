package br.com.news.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity(name = "news")
public class News implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 75, nullable = false)
    private String title;

    @Column(columnDefinition = "text")
    private String description;

    @Column(name = "Created_Date", nullable = false, updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date CreatedDate;

    @Getter(onMethod = @__({@JsonIgnore}))
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

}
