package com.divan.divan_camileri.entity;

import com.divan.divan_camileri.constant.ContentType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "content")
public class ContentP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @ElementCollection
    @CollectionTable(name = "content_images", joinColumns = @JoinColumn(name = "content_id"))
    @Column(name = "image_path")
    private List<String> imagePaths;

    @Enumerated(EnumType.STRING)
    private ContentType type;
}
