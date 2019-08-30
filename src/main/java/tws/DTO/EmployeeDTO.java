package tws.DTO;

public class EmployeeDTO {
    private String id;
    private String name;
    private String age;
    private String description;
    public EmployeeDTO(){

    }
    public EmployeeDTO(String id, String name, String age, String description){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

