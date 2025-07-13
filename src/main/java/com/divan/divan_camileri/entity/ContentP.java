package com.divan.divan_camileri.entity;

import com.divan.divan_camileri.constant.ContentType;
import com.divan.divan_camileri.constant.Image;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "content")
@Getter
@Setter
@NoArgsConstructor
public class ContentP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ElementCollection
    @CollectionTable(name = "content_images",
            joinColumns = @JoinColumn(name = "content_id"))
    private List<Image> imagePaths;

    @Enumerated(EnumType.STRING)
    private ContentType type;
}