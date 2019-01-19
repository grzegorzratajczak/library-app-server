package pl.grzex.grzexlibraryserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import pl.grzex.grzexlibraryserver.dao.ReaderRepository;

@CrossOrigin
@RestController
public class ReaderController {

    private ReaderRepository readerRepository;

    @Autowired
    public ReaderController(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }



}
