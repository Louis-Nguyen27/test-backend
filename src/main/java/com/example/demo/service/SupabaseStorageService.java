package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class SupabaseStorageService {
    // This class will handle interactions with Supabase storage
    // For example, uploading and downloading files, managing storage buckets, etc.

    // Placeholder for methods to interact with Supabase storage
    // e.g., uploadFile, downloadFile, deleteFile, listFiles, etc.

    private WebClient webClient;
    private String bucket;
    private String apiKey;

    public SupabaseStorageService(
            @Value("${supabase.url}") String supabaseUrl,
            @Value("${supabase.api.key}") String apiKey,
            @Value("${supabase.bucket}") String bucket) {
        this.webClient = WebClient.builder()
                .baseUrl(supabaseUrl + "/storage/v1/object")
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
                .build();
        this.bucket = bucket;
        this.apiKey = apiKey;
    }


    public Mono<String> uploadFile(MultipartFile file, String pathInBucket) throws Exception {
        return webClient.post()
                .uri("/" + bucket + "/" + pathInBucket)
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header("x-upsert", "true") // Optional: overwrite if exists
                .bodyValue(file.getBytes())
                .retrieve()
                .bodyToMono(String.class);
    }
}
