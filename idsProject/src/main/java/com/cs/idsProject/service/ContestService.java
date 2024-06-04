package com.cs.idsProject.service;

import com.cs.idsProject.entity.Contest;
import com.cs.idsProject.repository.ContestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContestService {
    @Autowired
    private ContestRepository contestRepository;

    public List<Contest> getAllContests() {
        return contestRepository.findAll();
    }

    public Optional<Contest> getContestById(int id) {
        return contestRepository.findById(id);
    }

    public Contest addContest(Contest contest) {
        return contestRepository.save(contest);
    }

    public void deleteContest(int id) {
        contestRepository.deleteById(id);
    }
}
