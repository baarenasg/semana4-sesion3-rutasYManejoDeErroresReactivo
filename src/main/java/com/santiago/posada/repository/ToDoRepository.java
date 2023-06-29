package com.santiago.posada.repository;

import com.santiago.posada.repository.model.ToDo;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ToDoRepository {

    private List<ToDo> list;

    public ToDoRepository(){
        list = new ArrayList<>();
    }

    public Mono<ToDo> addTask(String task){
        ToDo newTask = new ToDo(task);
        list.add(newTask);
        return Mono.just(newTask);
    }

    public Flux<ToDo> getTasks(){
        return Flux.fromIterable(list);
    }

    public Mono<ToDo> updateTask(int id, String newTask){
        return Mono.just(ToDo.from(newTask, id))
                .flatMap(task -> containsTask(task.getId())?
                        Mono.just(task):
                        Mono.error(new IllegalArgumentException("La tarea no está contenida en la lista")))
                .map(task -> {
                    list = list.stream()
                            .map(item -> item.getId() == task.getId() ? task : item)
                            .collect(Collectors.toList());
                    return task;
                 });
    }

    public boolean containsTask(int id){
        return list.stream().anyMatch(item -> item.getId() == id);
    }
}
