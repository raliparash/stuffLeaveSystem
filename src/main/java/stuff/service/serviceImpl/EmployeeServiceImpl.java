package stuff.service.serviceImpl;

import org.springframework.stereotype.Service;
import stuff.models.EmployeeServiceModel;
import stuff.service.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Override
    public EmployeeServiceModel addEmployee(EmployeeServiceModel productServiceModel) {
        return null;
    }

    @Override
    public List<EmployeeServiceModel> findAllProducts() {
        return null;
    }

    @Override
    public EmployeeServiceModel findById(String id) {
        return null;
    }

    @Override
    public void deleteEmployee(String id) {

    }
}
