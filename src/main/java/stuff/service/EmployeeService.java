package stuff.service;

import stuff.models.EmployeeServiceModel;

import java.util.List;

public interface EmployeeService {

    EmployeeServiceModel addEmployee(EmployeeServiceModel productServiceModel);

    List<EmployeeServiceModel> findAllProducts();

    EmployeeServiceModel findById(String id);

    void deleteEmployee(String id);
}
