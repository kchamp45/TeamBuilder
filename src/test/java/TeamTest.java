import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Created by Guest on 8/11/17.
 */
public class TeamTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        Team.clearAllTeams();
    }
    @Test
    public void NewTeamObjectGetsCorrectlyCreated_true() throws Exception {
        Team team = new Team ("Red");
        assertEquals(true, team instanceof Team);
    }

    @Test
    public void TeamInstantiatesWithValue_true() throws Exception {
        Team team = new Team("Red");
        assertEquals("Red", team.getName());
    }

    @Test
    public void CanAddTeamMember_Perry() throws Exception {
        Team team = new Team("Red");
        ArrayList expectedOutput = new ArrayList<String>();
        expectedOutput.add("Perry");
        assertEquals(expectedOutput, team.addMember("Perry"));
    }

    @Test
    public void CanRetrieveAllTeamMembers() throws Exception {
        Team team = new Team("Red");
        ArrayList expectedOutput = new ArrayList<String>();
        assertEquals(expectedOutput, team.getMembers());
    }

    @Test
    public void getCreatedAt_instantiatesWithCurrentTime_today() throws Exception {
        Team team =  new Team("Red");
        assertEquals(LocalDateTime.now().getDayOfWeek(), team.getCreatedAt().getDayOfWeek());
    }

    @Test
    public void clearAllTeams_checkIfClearsData_0() throws Exception {
        Team backpacking = new Team("Red");
        Team otherBackpacking = new Team ("Blue");
        Team.clearAllTeams();
        assertEquals(0,Team.getAll().size());
    }

    @Test
    public void AllTeamsAreCorrectlyReturned_true() {
        Team team = new Team("Red");
        Team team2 = new Team("Blue");
        assertEquals(2, Team.getAll().size());
    }

    @Test
    public void getId_teamsInstantiateWithAnID_1() throws Exception{
        Team.clearAllTeams();
        Team team = new Team("Red");
        assertEquals(1, team.getId());
    }
//
    @Test
    public void findReturnsCorrectTeam() throws Exception {
        Team team = new Team("Red");
        assertEquals(1, Team.findById(team.getId()).getId());
    }
//
    @Test
    public void findReturnsCorrectTeamWhenMoreThanOneTeamExists() throws Exception {
        Team team = new Team("Red");
        Team team2 = new Team("Blue");
        assertEquals(2, Team.findById(team2.getId()).getId());
    }
//
//    @Test
//    public void updateChangesTeamContent() throws Exception {
//        Team post = setupNewTeam();
//        String formerContent = post.getContent();
//        LocalDateTime formerDate = post.getCreatedAt();
//        int formerId = post.getId();
//
//        post.update("Android: Day 40");
//
//        assertEquals(formerId, post.getId());
//        assertEquals(formerDate, post.getCreatedAt());
//        assertNotEquals(formerContent, post.getContent());
//    }
//
//    @Test
//    public void TeamInstantiatesWithContent_true() throws Exception {
//        Team post = new Team("Day 1: Intro");
//        assertEquals("Day 1: Intro", post.getContent());
//
//    }
//    @Test
//    public void AllTeamsAreCorrectlyReturned_true() {
//        Team post = new Team("Day 1: Intro");
//        Team otherTeam = new Team ("How to pair successfully");
//        assertEquals(2, Team.getAll().size());
//    }
//
//    @Test
//    public void AllTeamsContainsAllTeams_true() {
//        Team post = new Team("Day 1: Intro");
//        Team otherTeam = new Team ("How to pair successfully");
//        assertTrue(Team.getAll().contains(post));
//        assertTrue(Team.getAll().contains(otherTeam));
//    }


    }