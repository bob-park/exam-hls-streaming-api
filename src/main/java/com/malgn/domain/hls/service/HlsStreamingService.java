package com.malgn.domain.hls.service;

import java.io.File;
import java.io.IOException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.malgn.configure.properties.AppProperties;

@Slf4j
@RequiredArgsConstructor
@Service
public class HlsStreamingService {

    private static final String MANIFEST_FILE_NAME = "output.m3u8";

    private final AppProperties properties;

    public Resource manifest() throws IOException {

        File baseDir = properties.baseLocation().getFile().getAbsoluteFile();

        return new FileSystemResource(baseDir.getPath() + File.separator + MANIFEST_FILE_NAME);
    }

    public Resource getSegments(String segment) throws IOException {
        File baseDir = properties.baseLocation().getFile().getAbsoluteFile();

        return new FileSystemResource(baseDir.getPath() + File.separator + segment);
    }

}
