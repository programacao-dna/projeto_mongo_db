package io.americanas.projeto_mongo_db.service;

import io.americanas.projeto_mongo_db.entinty.Apolice;
import io.americanas.projeto_mongo_db.entinty.SubApolice;
import io.americanas.projeto_mongo_db.exceptions.ApoliceNotFoundException;
import io.americanas.projeto_mongo_db.exceptions.SubApoliceNotFoundException;
import io.americanas.projeto_mongo_db.repository.ApoliceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApoliceService {

    private final ApoliceRepository apoliceRepository;

    public ApoliceService(ApoliceRepository apoliceRepository) {
        this.apoliceRepository = apoliceRepository;
    }

    public List<Apolice> ListarTodasApolices() {
        return apoliceRepository.findAll();
    }

//    public Optional<Apolice> BuscarApolicePorNumeroApolice(String numeroApolice) {
//        return apoliceRepository.findByNumeroApolice(numeroApolice);
//    }

    public Apolice criarApolice(Apolice apolice) {
        Optional<Apolice> existApolice = apoliceRepository.findByNumeroApolice(apolice.getNumeroApolice());
        if (existApolice.isPresent()) {
            throw new RuntimeException("Apolice existente");
        }
        return apoliceRepository.save(apolice);
    }

//    public Apolice criarApoliceComSubApolice(Apolice apolice, SubApolice subApolice) {
//        Optional<Apolice> existApolice = apoliceRepository.findByNumeroApolice(apolice.getNumeroApolice());
//        if (existApolice.isPresent()) {
//            throw new RuntimeException("Apolice existente");
//        }
//        apolice.getSubApolices().add(subApolice);
//        return apoliceRepository.save(apolice);
//    }

    public Apolice criarSubApoliceParaApolice(String numeroApolice, SubApolice child) {
        return apoliceRepository.findByNumeroApolice(numeroApolice)
                .map(parent -> {
                    parent.getSubApolices().add(child);
                    return apoliceRepository.save(parent);
                })
                .orElseThrow(ApoliceNotFoundException::new);
    }

    public Apolice atualizarSubApolice(String apoliceId, String subApoliceNumero, SubApolice updatedChild) {
        Apolice parent = apoliceRepository.findById(apoliceId)
                .orElseThrow(ApoliceNotFoundException::new);

        List<SubApolice> subApolices = parent.getSubApolices();

        for (int i = 0; i < subApolices.size(); i++) {
            SubApolice child = subApolices.get(i);
            if (child.getDescrico().equals(subApoliceNumero)) {

                if (updatedChild.getDescrico() != null) {
                    child.setDescrico(updatedChild.getDescrico());
                }

                return apoliceRepository.save(parent);
            }
        }
        throw new SubApoliceNotFoundException();
    }
}
