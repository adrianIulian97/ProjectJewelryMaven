package Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repositories.JewelryRepository;

@Service
public class JewelryService {

    @Autowired
    private JewelryRepository jewelryRepository;

//    @Transactional (noRollbackFor = RuntimeException.class) // to not rollback the "RuntimeException"
//    @Transactional (rollbackFor = Exception.class)  // to rollback the "Exception"
    @Transactional
    // rollback the RuntimeException but does not rollback the checked exception
    public void addOneJewelry() throws Exception{
        jewelryRepository.addJewelry("Pandora");
//        throw new RuntimeException(":("); // it works; do the rollback with "@Transactional"
//        throw new Exception(":("); // does not rollback with "@Transactional"
        try {
            throw new RuntimeException(":(");
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
