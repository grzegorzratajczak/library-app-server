package pl.grzex.grzexlibraryserver.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.grzex.grzexlibraryserver.dto.CopyDto;
import pl.grzex.grzexlibraryserver.models.Copy;
import pl.grzex.grzexlibraryserver.services.CopyService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@CrossOrigin
@RestController
public class CopyController {

    private CopyService copyService;

    @Autowired
    public CopyController(CopyService copyService) {
        this.copyService = copyService;
    }

    @GetMapping(value = "/copies")
    public List<CopyDto> getAllCopy() {
        return copyService.findAllCopy();
    }

    @GetMapping(value = "authors/{authorsId}/books/{bookId}/copies")
    public List<Copy> getCopysByBookId(@PathVariable Long bookId) {
        return new ArrayList<>(copyService.findCopysByBookId(bookId));
    }

    @GetMapping(value = "authors/{authorsId}/books/{bookId}/copies/{copyId}")
    public List<Copy> getCopyById(@PathVariable Long copyId) {
        return Collections.singletonList(copyService.findCopyById(copyId));
    }

    @PostMapping(value = "authors/{authorsId}/books/{bookId}/copies")
    public List<Copy> saveCopyToDB(@PathVariable Long bookId) {
        return Collections.singletonList(copyService.saveCopy(bookId));
    }

    @DeleteMapping("authors/{authorsId}/books/{bookId}/copies/{copyId}")
    public void deleteCopy(@PathVariable Long copyId) {
        copyService.deleteById(copyId);
    }
}
