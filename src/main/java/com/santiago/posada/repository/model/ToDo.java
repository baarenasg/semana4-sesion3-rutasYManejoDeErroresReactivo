package com.santiago.posada.repository.model;

public class ToDo {
    public static int counter = 0;

    public int id;
    public String task;

    public ToDo(String task){
        counter++;
        this.id = counter;
        this.task = task;
    }

    private ToDo(String task, int id){
        this.id = id;
        this.task = task;
    }
    public static ToDo from(String task, int id){
        return new ToDo(task, id);
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        ToDo.counter = counter;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
}
