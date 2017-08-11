import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guest on 8/11/17.
 */
public class Team {

    private String name;
    private String description;
    private static ArrayList<Team> instances = new ArrayList<>();
    private LocalDateTime createdAt;
    private int id;
    private String memberName;
    private ArrayList<String> members;

    public Team (String name) {
        this.name = name;
        this.description = description;
        this.createdAt = LocalDateTime.now();
        instances.add(this);
        this.id = instances.size();
        this.memberName = memberName;
        this.members = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> addMember(String memberName) {
        members.add(memberName);
        return members;
    }

    public ArrayList<String> getMembers(){
        return members;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
//
//
//    public static ArrayList<Team> getInstances() {
//        return instances;
//    }
//
//
//
//    public int getId() {
//        return id;
//    }



}
