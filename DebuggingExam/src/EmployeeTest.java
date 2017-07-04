public class EmployeeTest  {

	public static void main(String[] args) {
		EmployeeList list = new EmployeeList();
		int i = 0;
		Employee emp = null;

		list.addEmployee(new Employee(30, "aaa"));
		list.addEmployee(new Employee(50, "bbb"));
		list.addEmployee(new Employee(10, "ccc"));
 		list.addEmployee(new Employee(20, "ddd"));
		list.addEmployee(new Employee(40, "eee"));

		for(i = 10; i <= 50; i += 10)  {
			emp = list.findEmployee(i);
			System.out.println("ID= " + emp.id + ", Name= " + emp.name); }
	}
}