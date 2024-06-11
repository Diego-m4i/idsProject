package com.cs.idsProject.controller;

import com.cs.idsProject.entity.Contest;
import com.cs.idsProject.service.ContestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/contests")
public class ContestController {

    @Autowired
    private ContestService contestService;

    @GetMapping
    public List<Contest> getAllContests() {
        return contestService.getAllContests();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contest> getContestById(@PathVariable int id) {
        Optional<Contest> contest = contestService.getContestById(id);
        return contest.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Contest> addContest(@RequestBody Contest contest, @RequestParam Integer idComune) {
        try {
            Contest savedContest = contestService.addContest(contest, idComune);
            return ResponseEntity.ok(savedContest);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{idComune}/{idContest}")
    public ResponseEntity<Void> deleteContest(@PathVariable Integer idComune, @PathVariable Integer idContest) {
        try {
            boolean isDeleted = contestService.deleteContest(idComune, idContest);
            if (isDeleted) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/proclaim-winner")
    public ResponseEntity<Contest> proclaimWinner(@RequestParam Integer idContest, @RequestParam Integer idVincitore) {
        try {
            Contest updatedContest = contestService.proclaimWinner(idContest, idVincitore);
            return ResponseEntity.ok(updatedContest);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
