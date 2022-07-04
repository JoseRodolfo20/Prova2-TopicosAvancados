package com.univas.JoseRodolfo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.univas.JoseRodolfo.Controller.Auditing;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

@Service
public class SalesmanService {

    @Autowired
    private SalesmanDAO salesmanDAO;

    public List<SalesmanDTO> getAllSalesmans(){
        List<Salesman> listSalesman = salesmanDAO.findAll();

        return listSalesman.stream()
            .map(salesman -> new SalesmanDTO(salesman))
            .collect(Collectors.toList());

    }

    public Salesman getSalesmanById(@PathVariable Integer registry){
        if(registry == null){
            throw new InvalidDataException("O id não pode ser null");
        }
        Optional<Salesman> obj = salesmanDAO.findById(registry);

        return obj.orElseThrow(() -> new ObjectNotFoundException("Vendedor não localizado"));
    }

    public void updateSalesman(@Valid SalesmanDTO dto, Integer registry) {
        if(dto == null){
            throw new InvalidDataException("O vendedor não pode ser null");
        }
        Salesman salesman = getSalesmanById(registry);
        updateSalesman(dto, registry);
        salesmanDAO.save(salesman);
    }


    public void createSalesman(@Valid SalesmanDTO dto) {
        Salesman salesman = toSalesman(dto);
        salesmanDAO.save(salesman);
    }

    private Salesman toSalesman(@Valid SalesmanDTO dto) {
        Salesman salesman = new Salesman();

        salesman.setName(dto.getName());
        salesman.setWhatsapp(dto.getWhatsapp());
        salesman.setLastSaleDate(dto.getLastSaleDate());
        salesman.setPerformanceRate(dto.getPerformanceRate());
        return salesman;
    }

    public void deleteSalesman(Integer registry) {
        Salesman salesman = getSalesmanById(registry);
        salesmanDAO.delete(salesman);
    }

    public List<Auditing> getAllAuditing() {
        return null;
    }

}
