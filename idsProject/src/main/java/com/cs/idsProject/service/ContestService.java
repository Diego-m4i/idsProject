package com.cs.idsProject.service;

import com.cs.idsProject.entity.Contest;
import com.cs.idsProject.entity.Comune;
import com.cs.idsProject.repository.ContestRepository;
import com.cs.idsProject.repository.ComuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContestService {

    @Autowired
    private ContestRepository contestRepository;

    @Autowired
    private ComuneRepository comuneRepository;

    public List<Contest> getAllContests() {
        return contestRepository.findAll();
    }

    public Optional<Contest> getContestById(int id) {
        return contestRepository.findById(id);
    }

    public Contest addContest(Contest contest, Integer idComune) {
        Optional<Comune> comune = comuneRepository.findById(idComune);
        if (comune.isPresent()) {
            return contestRepository.save(contest);
        } else {
            throw new RuntimeException("Comune with ID " + idComune + " not found.");
        }
    }

    public boolean deleteContest(Integer idComune, Integer idContest) {
        Optional<Comune> comune = comuneRepository.findById(idComune);
        if (comune.isPresent()) {
            Optional<Contest> contest = contestRepository.findById(idContest);
            if (contest.isPresent()) {
                contestRepository.deleteById(idContest);
                return true;
            } else {
                throw new RuntimeException("Contest with ID " + idContest + " not found.");
            }
        } else {
            throw new RuntimeException("Comune with ID " + idComune + " not found.");
        }
    }

    public Contest proclaimWinner(Integer idContest, Integer idVincitore) {
        Optional<Contest> contest = contestRepository.findById(idContest);
        if (contest.isPresent()) {
            Contest updatedContest = contest.get();
            updatedContest.setIdVincitore(idVincitore); // Presupponendo che Contest abbia un campo "winner"
            return contestRepository.save(updatedContest);
        } else {
            throw new RuntimeException("Contest with ID " + idContest + " not found.");
        }
    }
}
