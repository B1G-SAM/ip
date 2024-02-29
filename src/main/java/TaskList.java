import java.util.ArrayList;

public class TaskList {
    protected ArrayList<Task> tasks;
    protected Ui userInterface;

    public void generateList(Ui uiComponent){
        tasks = new ArrayList<>();
        userInterface = uiComponent;
    }


    public void insertTask(Task task){
        tasks.add(task);
        userInterface.listInsertionMessage(task.getDescription(), tasks.size());
    }


    public ArrayList<Task> getTasks(){
        return tasks;
    }


    public void setTasks(ArrayList<Task> aList){
        this.tasks = aList;
    }


    public void listTasks(ArrayList<Task> tasks){
        userInterface.printTasks(tasks);
    }


    public void markIndex(int index){
        userInterface.taskMarkedMessage();
        tasks.get(index - 1).markTask();
    }


    public void unmarkIndex(int index){
        userInterface.taskUnmarkedMessage();
        tasks.get(index - 1).unmarkTask();
    }


    public void deleteIndex(int taskNumber){
        userInterface.taskRemovedMessage(taskNumber, tasks.get(taskNumber - 1).getDescription());
        tasks.remove(taskNumber - 1);
    }


    public void findKeyword(String keyword){
        ArrayList<Task> foundTasks = new ArrayList<Task>();
        for (Task item : tasks){
            String[] words = item.getDescription().split("\\s+"); //splits at either 1 or 2 spaces
            for (String word : words){
                if (word.equals(keyword)){
                    foundTasks.add(item);
                    break;
                }
            }
        }
        userInterface.keywordMessage(foundTasks);
    }
}