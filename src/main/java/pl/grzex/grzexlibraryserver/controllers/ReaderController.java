package pl.grzex.grzexlibraryserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.grzex.grzexlibraryserver.dto.ReaderDto;
import pl.grzex.grzexlibraryserver.models.Reader;
import pl.grzex.grzexlibraryserver.services.ReaderService;

import java.util.Collections;
import java.util.List;

@CrossOrigin
@RestController
public class ReaderController {

    private ReaderService readerService;

    @Autowired
    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @GetMapping(value = "/readers")
    public List<Reader> getAllReaders() {
        return readerService.findAll();
    }

    @GetMapping(value = "/readers/{readerId}")
    public List<Reader> findReaderById(@PathVariable Long readerId) {
        return Collections.singletonList(readerService.findReaderById(readerId));
    }

    @PostMapping(value = "/readers")
    public List<Reader> saveReaderToDB(@RequestBody ReaderDto readerDto) {
        return Collections.singletonList(readerService.saveReader(readerDto));
    }

    @DeleteMapping(value = "/readers/{readerId}")
    public void deleteById(@PathVariable Long readerId) {
        readerService.deleteById(readerId);
    }
}
