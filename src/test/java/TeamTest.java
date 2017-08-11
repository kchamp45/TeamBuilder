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
//        Team.clearAllTeams();
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
////
// @Test
//    public void AllTeamsAreCorrectlyReturned_true() {
//        Team team = new Team ("Red");
//        Team team2 = new team ("Red");
//        assertEquals(2, Team.getAll().size());
////    }
//

//
//    public Post setupNewPost(){
//        return new Post("Day 1: Intro");
//    }
//
//    @Test
//    public void getId_postsInstantiateWithAnID_1() throws Exception{
//        Post.clearAllPosts();  // Remember, the test will fail without this line! We need to empty leftover Posts from previous tests!
//        Post myPost = new Post("Day 1: Intro");
//        assertEquals(1, myPost.getId());
//    }
//
//    @Test
//    public void findReturnsCorrectPost() throws Exception {
//        Post post = setupNewPost();
//        assertEquals(1, Post.findById(post.getId()).getId());
//    }
//
//    @Test
//    public void findReturnsCorrectPostWhenMoreThanOnePostExists() throws Exception {
//        Post post = setupNewPost();
//        Post otherPost = new Post("How to pair successfully");
//        assertEquals(2, Post.findById(otherPost.getId()).getId());
//    }
//
//    @Test
//    public void updateChangesPostContent() throws Exception {
//        Post post = setupNewPost();
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
//    public void PostInstantiatesWithContent_true() throws Exception {
//        Post post = new Post("Day 1: Intro");
//        assertEquals("Day 1: Intro", post.getContent());
//
//    }
//    @Test
//    public void AllPostsAreCorrectlyReturned_true() {
//        Post post = new Post("Day 1: Intro");
//        Post otherPost = new Post ("How to pair successfully");
//        assertEquals(2, Post.getAll().size());
//    }
//
//    @Test
//    public void AllPostsContainsAllPosts_true() {
//        Post post = new Post("Day 1: Intro");
//        Post otherPost = new Post ("How to pair successfully");
//        assertTrue(Post.getAll().contains(post));
//        assertTrue(Post.getAll().contains(otherPost));
//    }


}