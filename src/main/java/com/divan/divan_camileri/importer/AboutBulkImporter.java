package com.divan.divan_camileri.importer;

import com.divan.divan_camileri.entity.AboutP;
import com.divan.divan_camileri.repository.AboutRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class AboutBulkImporter implements CommandLineRunner {

    private final ObjectMapper objectMapper;   // Spring Boot auto-config
    private final AboutRepository aboutRepository;

    @Override
    public void run(String... args) throws Exception {
        Path file = Paths.get("src/main/resources/data/about.json");
        if (aboutRepository.count() != 0L) {
            log.info("💡  İçerik zaten yüklenmiş, atlanıyor.");
            return;
        }

        try (InputStream in = Files.newInputStream(file)) {
            List<AboutP> abouts =
                    objectMapper.readValue(in,
                            new TypeReference<List<AboutP>>() {});

            // performans için batch
            int batchSize = 50;
            for (int i = 0; i < abouts.size(); i += batchSize) {
                int end = Math.min(i + batchSize, abouts.size());
                aboutRepository.saveAll(abouts.subList(i, end));
                aboutRepository.flush();           // memory’i boşalt
            }
            log.info("✅  {} kayıt import edildi.", abouts.size());
        }
    }
}
