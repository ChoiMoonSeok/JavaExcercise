import java.util.List;
import java.util.ArrayList;

public class EmployeeList {
	private List<Employee> list = new ArrayList<Employee>();
	//private List<Employee> list;
	public boolean addEmployee(Employee emp) {
		int i = 0;
		int id = 0;
		
		
		for(i = 0; i < list.size(); i++) {
			id = (list.get(i)).id;
			if(id > emp.id) {
				list.add(i, emp);
				return true; }

			else if(id == emp.id) 
			{
				return false;   
				}  }
		
		list.add(emp);
		return true;  }
	
	public Employee findEmployee(int targetId)  {
		int lower = 0;
		int upper = 0;
		int middle = 0;
		int id = 0;
		
		lower = 0;
		upper = list.size() - 1;

		while(lower <= upper)  {
			middle = (lower + upper) / 2;
			id = (list.get(middle)).id;

			if(id < targetId)
				lower = middle+1;

			else if(id > targetId)
				upper = middle-1;

			else
				return list.get(middle); }

		return null; }
}