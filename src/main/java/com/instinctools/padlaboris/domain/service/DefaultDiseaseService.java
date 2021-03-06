package com.instinctools.padlaboris.domain.service;

import com.instinctools.padlaboris.domain.exception.ResourceNotFoundException;
import com.instinctools.padlaboris.domain.model.Disease;
import com.instinctools.padlaboris.domain.repository.DiseaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Class that implements the Disease's work and databases.
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DefaultDiseaseService implements DiseaseService {

    private final DiseaseRepository diseaseRepository;

    @Override
    public List<Disease> findAll() {
        return diseaseRepository.findAll();
    }

    @Override
    public List<Disease> findByDiseaseName(final String diseaseName) {
        return diseaseRepository.findByDiseaseName(diseaseName);
    }

    @Override
    public List<Disease> findByDiseaseCode(final String diseaseCode) {
        return diseaseRepository.findByDiseaseCode(diseaseCode);
    }

    @Override
    public List<Disease> findByDiseaseClass(final String diseaseClass) {
        return diseaseRepository.findByDiseaseClass(diseaseClass);
    }

    @Override
    public Disease findById(final Integer id) {
        return Optional.ofNullable(diseaseRepository.findOne(id))
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public Disease save(final Disease disease) {
        return diseaseRepository.save(disease);
    }

    @Override
    public void delete(final Disease disease) {
        diseaseRepository.delete(disease);
    }

    @Override
    public void delete(final Integer id) {
        diseaseRepository.delete(id);
    }

    @Override
    public boolean exists(final Integer id) {
        return diseaseRepository.exists(id);
    }
}
