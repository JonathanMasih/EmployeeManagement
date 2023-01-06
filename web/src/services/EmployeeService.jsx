import axios from "axios";

const EMPLOYEE_API_BASE = "http://localhost:8081/api/v1/employees";


class EmployeeService{

    saveEmployee(employee){
        return axios.post(EMPLOYEE_API_BASE,employee);
    }

    getEmplyees(){
        return axios.get(EMPLOYEE_API_BASE);
    }

    deleteEmployee(id){
        return axios.delete(`${EMPLOYEE_API_BASE}/${id}`);
    }
}

export default new EmployeeService();