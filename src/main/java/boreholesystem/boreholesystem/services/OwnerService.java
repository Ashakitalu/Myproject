
package boreholesystem.boreholesystem.services;

import boreholesystem.boreholesystem.model.Owner;
import boreholesystem.boreholesystem.model.Owner;
import boreholesystem.boreholesystem.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {
    @Autowired
    private OwnerRepository OwnerRepository;

    public List<Owner> getAll() {
        return OwnerRepository.findAll();
    }

    public Owner addData(Owner Owner) {
        return OwnerRepository.save(Owner);
    }

    public Owner updateOwner(Owner Owner) {
        return OwnerRepository.save(Owner);
    }

    public Optional<Owner> getOwnerById(Integer OwnerId) {
        return OwnerRepository.findById(OwnerId);
    }

    public void deleteMe(int OwnerID) {
        OwnerRepository.deleteById(OwnerID);
    }

    public Optional<Owner> getOwnerById(int ownerID) {
        return null;
    }


}