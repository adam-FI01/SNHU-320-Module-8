package TaskClass;

import java.util.HashMap;

public class TaskService {
	
	int currentId = 0; 
	
	// create hash map
	public static HashMap<String, Task> tasks = new HashMap<String, Task>();
	
	public void addTask(String _name, String _description) {

		String stringID = Integer.toString(currentId);		
		Task tempTask = new Task (stringID, _name, _description);
		tasks.put(stringID, tempTask);	

		currentId++;		
	}
	
	public void deleteTask(String Id) {
		
		if(tasks.containsKey(Id)) {			
			tasks.remove(Id);
		}		
	}
	
	public void updateTask(String Id, String name, String description) {
		
		if(tasks.containsKey(Id)) {
			
			tasks.get(Id).setName(name);
			tasks.get(Id).setDescription(description);
		}
		
	}
}