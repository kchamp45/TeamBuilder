/**
 * Created by Kimberly Lu on 8/11/17.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        get("/teams/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "team-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/teams/new", (request, response) -> { //URL to make new team on POST route
            Map<String, Object> model = new HashMap<String, Object>();
            String newName = request.queryParams("name");
            String newDescription = request.queryParams("description");
            Team newTeam = new Team(newName, newDescription);
            model.put("teams", newTeam);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/members/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "member-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/members/new", (request, response) -> { //URL to add member on POST route
            Map<String, Object> model = new HashMap<String, Object>();
            String newName = request.queryParams("name");
            String newDescription = request.queryParams("description");
            Team newTeam = new Team(newName, newDescription);
            String newMemberName = request.queryParams("memberName");
            ArrayList<String>members = newTeam.addMember(newMemberName);
            model.put("members", members);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/teams", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Team> teams = Team.getAll();
            model.put("teams", teams);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/teams/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            Team.clearAllTeams();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/teams/:id", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfTeamToFind = Integer.parseInt(req.params("id")); //pull id - must match route segment
            Team foundTeam = Team.findById(idOfTeamToFind); //use it to find team
            model.put("team", foundTeam); //add it to model for template to display
            return new ModelAndView(model, "team-details.hbs"); //individual team page.
        }, new HandlebarsTemplateEngine());

        get("/teams/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfTeamToEdit = Integer.parseInt(req.params("id"));
            Team editTeam = Team.findById(idOfTeamToEdit);
            model.put("editTeam", editTeam);
            return new ModelAndView(model, "team-form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/teams/:id/update", (req, res) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String newName = request.queryParams("name");
            String newDescription = request.queryParams("description");
            Team newTeam = new Team(newName, newDescription);
            int idOfTeamToEdit = Integer.parseInt(req.params("id"));
            Team editTeam = Team.findById(idOfTeamToEdit);
            editTeam.update(newName, newDescription);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        get("/teams/:id/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            int idOfTeamToDelete = Integer.parseInt(req.params("id")); //pull id - must match route segment
            Team deleteTeam = Team.findById(idOfTeamToDelete); //use it to find team
            deleteTeam.deleteTeam();
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

    }

}

