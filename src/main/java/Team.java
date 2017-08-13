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

    public Team (String name, String description) {
        this.name = name;
        this.description = description;
        this.createdAt = LocalDateTime.now();
        this.members = new ArrayList<String>();
        instances.add(this);
        this.id = instances.size();
        this.memberName = memberName;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> addMember(String memberName) {
        this.members.add(memberName);
        return members;
    }

    public ArrayList<String> getMembers(){
        return members;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public static void clearAllTeams(){
        instances.clear();
    }

    public static ArrayList<Team> getAll(){
        return instances;
    }

    public int getId() {
        return id;
    }

    public static Team findById(int id) {
        return instances.get(id-1);
    }

    public void update(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void deleteTeam(){
        instances.remove(id-1); //same reason
    }

    public String getMemberName() {
        return memberName;
    }

    public static ArrayList<Team> getInstances() {
        return instances;
    }

    public static Team findTeam(String teamName) {
        Team aTeam = null;
        for (Team team: instances) {
            String aName = team.getName();
            if(aName.equals(teamName)) {
                aTeam = team;
            }
        }
        return aTeam;
    }

}
