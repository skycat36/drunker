package com.vsu.drunker.web.bean.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@FeignClient(name = "FileControllerClient", url = "${services.filestorage-service.url}", path = "/api/file", configuration = FileControllerConfigClient.class)
public interface FileControllerApi {

    @PostMapping("/putObject")
    ResponseEntity<String> putObject(@RequestParam MultipartFile file, @RequestParam String bucket, @RequestParam String name) throws IOException;

    @PostMapping("/removeFileFromBucket")
    ResponseEntity<String> removeFileFromBucket(@RequestParam String bucket, @RequestParam String name) throws IOException;

//    @PostMapping("/getObjectInformation")
//    ResponseEntity<ObjectStat> getObjectInformation(@RequestParam String bucket, @RequestParam String name) throws IOException;

    @GetMapping("/getAllObjectNameFromBucket/{bucket}")
    ResponseEntity<List<String>> getAllObjectNameFromBucket(@PathVariable String bucket) throws IOException;

    @PostMapping("/removeListObjects")
    ResponseEntity<String> removeListObjects(@RequestParam String bucket, @RequestBody List<String> names) throws IOException;

    @GetMapping("/getFile/{backet}/{name}")
    ResponseEntity<Object> getFile(@PathVariable String bucket, @PathVariable String name);
}
