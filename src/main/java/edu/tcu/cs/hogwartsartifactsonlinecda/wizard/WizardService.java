package edu.tcu.cs.hogwartsartifactsonlinecda.wizard;

import jakarta.transaction.Transactional;
import org.hibernate.ObjectNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@Transactional
public class WizardService {
    private final WizardRepository wizardRepository;


    public WizardService(WizardRepository wizardRepository) {
        this.wizardRepository = wizardRepository;

    }

    public Wizard findById(Integer wizardId) {
        return this.wizardRepository.findById(wizardId)
                .orElseThrow(() -> new org.hibernate.ObjectNotFoundException("wizard", wizardId));
    }

    public List<Wizard> findAll() {

        return this.wizardRepository.findAll();
    }

    public Wizard save(Wizard newWizard) {
        return this.wizardRepository.save(newWizard);
    }

    public Wizard update(Integer wizardId, Wizard update) {
        return this.wizardRepository.findById(wizardId)
                .map(oldWizard -> {
                    oldWizard.setName(update.getName());
                    return this.wizardRepository.save(oldWizard);

                })
                .orElseThrow(() -> new org.hibernate.ObjectNotFoundException("wizard", wizardId));

    }

    public void delete(Integer wizardId) {
        Wizard wizardToBeDeleted = this.wizardRepository.findById(wizardId)
                .orElseThrow(() -> new org.hibernate.ObjectNotFoundException("wizard", wizardId));
        wizardToBeDeleted.removeAllArtifacts();
        this.wizardRepository.deleteById(wizardId);

    }
}


