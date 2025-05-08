package com.malgn.domain.hls.controller;

import java.io.IOException;

import lombok.RequiredArgsConstructor;

import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.malgn.domain.hls.service.HlsStreamingService;

@RequiredArgsConstructor
@RestController
@RequestMapping("hls/streaming")
public class HlsStreamingController {

    private final HlsStreamingService streamingService;

    @GetMapping(path = "output.m3u8")
    public Resource manifest() throws IOException {
        return streamingService.manifest();
    }

    @GetMapping(path = "{segment:.+}")
    public Resource getSegments(@PathVariable String segment) throws IOException {
        return streamingService.getSegments(segment);
    }

}
