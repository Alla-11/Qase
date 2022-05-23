package models;

import lombok.Data;
import java.util.ArrayList;

@Data
public class ResultProjects {
    Integer total;
    ArrayList<Project> entities;
}
