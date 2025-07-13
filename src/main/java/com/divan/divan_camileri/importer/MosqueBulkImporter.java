package com.divan.divan_camileri.importer;

import com.divan.divan_camileri.entity.MosqueP;
import com.divan.divan_camileri.repository.MosqueRepository;
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
public class MosqueBulkImporter implements CommandLineRunner {

    private final ObjectMapper objectMapper;   // Spring Boot auto-config
    private final MosqueRepository mosqueRepository;

    @Override
    public void run(String... args) throws Exception {
        Path file = Paths.get("src/main/resources/data/mosques.json");
        if (mosqueRepository.count() != 0L) {
            log.info("💡  İçerik zaten yüklenmiş, atlanıyor.");
            return;
        }

        try (InputStream in = Files.newInputStream(file)) {
            List<MosqueP> mosques =
                    objectMapper.readValue(in,
                            new TypeReference<List<MosqueP>>() {});

            // performans için batch
            int batchSize = 50;
            for (int i = 0; i < mosques.size(); i += batchSize) {
                int end = Math.min(i + batchSize, mosques.size());
                mosqueRepository.saveAll(mosques.subList(i, end));
                mosqueRepository.flush();           // memory’i boşalt
            }
            log.info("✅  {} kayıt import edildi.", mosques.size());
        }
    }
}
