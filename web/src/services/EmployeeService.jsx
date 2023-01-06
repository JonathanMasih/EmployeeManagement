import axios from "axios";

const EMPLOYEE_API_BASE = "http://localhost:8081/api/v1/employees";


class EmployeeService{

    saveEmployee(employee){
        return axios.post(EMPLOYEE_API_BASE,employee);
    }

    getEmplyees(){
        return axios.get(EMPLOYEE_API_BASE);
    }
}

export default new EmployeeService();