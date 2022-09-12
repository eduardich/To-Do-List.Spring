package main.model;

import org.hibernate.annotations.SortNatural;
import org.springframework.scheduling.annotation.Scheduled;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    String task;

    @Enumerated(EnumType.STRING)
    TaskStatus status = TaskStatus.SCHEDULED;

    public Task() {
    }

    public Task(String task) {
        this.task = task;
    }

    public enum TaskStatus {
        SCHEDULED,
        DONE
    }

//    public Task(long id, String task) {
//        this.id = id;
//        this.task = task;
//        this.status = TaskStatus.SCHEDULED;
//    }
//
//    public Task(long id, String task, TaskStatus status) {
//        this.id = id;
//        this.task = task;
//        this.status = status;
//    }


    public long getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", status=" + status +
                '}';
    }
}
