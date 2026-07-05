package newbegin;
import java.util.*;
public class StudentMgmt {

	public static void main(String[] args) {
		List<Student> StudentList =new ArrayList<Student>();
		int id=0;
		
		
		String name=null;
		char attendance = 0;
		
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("Enter operation 1.add 2.remove 3.read 4.exit");
			String mode=sc.nextLine();
			if(mode.equalsIgnoreCase("add") || mode.equalsIgnoreCase("remove")||  mode.equalsIgnoreCase("read") || mode.equalsIgnoreCase("Search")|| mode.equalsIgnoreCase("Update")) {
				
					if(mode.equalsIgnoreCase("add") ) {
						System.out.println("enter ID");
						id=sc.nextInt();
						sc.nextLine();
						System.out.println("enter NAME");
						name=sc.nextLine();
						System.out.println("enter attendance");
						attendance=sc.nextLine().charAt(0);
						Student st=new Student(id,name,attendance);
						
						StudentList.add(st);
						System.out.println("Added");
					}
						else if(mode.equalsIgnoreCase("remove")) {
							boolean found=false;
							System.out.println("enter id:");
							id=sc.nextInt();sc.nextLine();
							for(int i=0;i<=StudentList.size()-1;i++) {
								if(StudentList.get(i).getId()==id) {
									found=true;
								StudentList.remove(i);
								System.out.println("Removed");
								break;
								}
								
					}
							if(found==false) {
								System.out.println("student not exist");
							}
						}
						else if(mode.equalsIgnoreCase("read")) {
						for(Student s:StudentList) {
							System.out.println(s);
						}}
				
				
				
			else if(mode.equalsIgnoreCase("search")) {
				boolean done=false;
				System.out.println("Enter ID to search");
				int SearchId=sc.nextInt();
				for(Student s:StudentList) {
					if(s.getId() == SearchId) {
						System.out.println("Found"+" "+s.getName()+" "+s.getAttendance());
						done=true;
						break;
					}}
					if(!done) {
						System.out.println("Not found");
					}
				
				
				
			}
			else if(mode.equalsIgnoreCase("Update")) {
				System.out.println("enter field to update [ name,id,attendance]");
				String field=sc.nextLine();
				
				if(field.equalsIgnoreCase("name")) {
					System.out.println("whose data is need to be updated? Enter their ID");
					int updateId=sc.nextInt();sc.nextLine();
					System.out.println("enter new name");
					String updatename=sc.nextLine();
					for(int i=0;i<StudentList.size();i++) {
						if(StudentList.get(i).getId()==updateId) {
							StudentList.get(i).setName(updatename);
						}
					}
				}
				else if(field.equalsIgnoreCase("ID")) {
					System.out.println("whose data is need to be updated? Enter their ID");
					int updateId=sc.nextInt();sc.nextLine();
					System.out.println("enter new ID");
					int updatingId=sc.nextInt();
					for(int i=0;i<StudentList.size();i++) {
						if(StudentList.get(i).getId()==updateId) {
							StudentList.get(i).setId(updatingId);
						}
					}
				}
				else if(field.equalsIgnoreCase("attendance")) {
					System.out.println("whose data is need to be updated? Enter their ID");
					int updateId=sc.nextInt();sc.nextLine();
					System.out.println("enter new attd");
					char updateatt=sc.nextLine().charAt(0);
					for(int i=0;i<StudentList.size();i++) {
						if(StudentList.get(i).getId()==updateId) {
							StudentList.get(i).setAttendance(updateatt);
						}
					}
				}
				
			}}
				else if(mode.equalsIgnoreCase("exit")) {
					System.out.println("Exitted");
					break;
				}
				else {
					System.out.println("wrong mode or invalid. Enter crrect operation to continue");
					continue;
				}
			}
		}
		
		
	}

class Student{
	int id;
	String name;
	char attendance;
	
	public Student(int id,String name, char attendance) {
		this.id=id;
		this.name=name;
		this.attendance=attendance;
		}
	public int getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public char getAttendance() {
		return this.attendance;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAttendance(char attendance) {
		this.attendance = attendance;
	}
	public String toString() {
		return "id:"+id +" name:"+name+" attendance:"+attendance;
	}
}

