package com.example.demo;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Team;

@RestController
public class TeamController{
@GetMapping(name="team")
public List<Team> getTeamsFromList() throws IOException{

Document doc=Jsoup.parse(new URL("https://www.laliga.es/estadisticas-historicas/clasificacion").openStream(), "UTF-8", "https://www.laliga.es/estadisticas-historicas/clasificacion");
doc.outputSettings().charset("UTF-8");
System.out.println(doc.text());
Elements rows=doc.select(".tabla-simple> table> tbody> tr");
List<Team> teams=new ArrayList<>();
rows.stream().forEach(
	t-> {
	Team team =new Team();
	team.setName(t.select("td > .nombre_equipo_clasificacion").text());
	team.setGF(Integer.parseInt(t.select("td").get(8).text()));
	team.setGC(Integer.parseInt(t.select("td").get(9).text()));
	teams.add(team);
	}
);

return teams;
}
}