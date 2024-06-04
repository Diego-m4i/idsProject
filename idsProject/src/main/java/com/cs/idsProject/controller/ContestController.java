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
        if (contest.isPresent()) {
            return ResponseEntity.ok(contest.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Contest addContest(@RequestBody Contest contest) {
        return contestService.addContest(contest);
    }

    @DeleteMapping("/{id}")
    public void deleteContest(@PathVariable int id) {
        contestService.deleteContest(id);
    }
}
