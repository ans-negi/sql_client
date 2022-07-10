package com.sc.sqltool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.*;

import java.util.*;

import static java.util.Map.entry;

@SpringBootApplication
@RestController
public class SqltoolApplication {
    public static void main(String[] args) {SpringApplication.run(SqltoolApplication.class, args);}

    public Map<String, Object> get_result(String query)
    {
        Map<String , Object> res = new HashMap<>();
        res.put("message",new String("SUCCESS"));
        res.put("data",new ArrayList<Map<String,String>>());

        if(query.length() >= 14 && query.charAt(14) =='B') res.put("data",boots_data);
        else if(query.length() >= 14 && query.charAt(14) =='D') res.put("data",demos_data);
        else if(query.length() >= 14 && query.charAt(14) =='L') res.put("data",loafer_data);
        else res.put("message","Database not found");

        return res;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/query")
    public Map<String, Object> f(String q) {
        Map<String, Object> res = get_result(q);
        return res;
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/search")
    public List<String> g(){
        return Arrays.asList("Boots", "Loafers", "Demos","gggg","sdffs","rewrewr","ddsfsd","dsdsffe","dfsds","dsfsdsd","fdsdfdsds","afdssdds","dsfdsdsfds","dsfdsdds"
        ,"fddsdfsds","dsfsfds","dsfddsdsdz");
    }

    ArrayList<Map<String,String>> boots_data = new ArrayList<>(Arrays.asList(
            Map.ofEntries(
                entry("position", "Hydrogen"),
                entry("weight","1.442"),
                entry("symbol","H")
            ),
            Map.ofEntries(
                    entry("position", "Helium"),
                    entry("weight","4.0"),
                    entry("symbol","He")
            ),
            Map.ofEntries(
                    entry("position", "Lithium"),
                    entry("weight","6.9"),
                    entry("symbol","Li")
            ),
            Map.ofEntries(
                    entry("position", "Oxygen"),
                    entry("weight","15"),
                    entry("symbol","O")
            ),
            Map.ofEntries(
                    entry("position", "Fluorine"),
                    entry("weight","18.0"),
                    entry("symbol","F")
            ),
            Map.ofEntries(
                    entry("position", "Neon"),
                    entry("weight","20"),
                    entry("symbol","Ne")
            ),
            Map.ofEntries(
                    entry("position", "Silicon"),
                    entry("weight","28"),
                    entry("symbol","Si")
            ),
            Map.ofEntries(
                    entry("position", "Aluminium"),
                    entry("weight","26.9"),
                    entry("symbol","Al")
            ),
            Map.ofEntries(
                    entry("position", "Oxygen"),
                    entry("weight","15"),
                    entry("symbol","O")
            ),
            Map.ofEntries(
                    entry("position", "Fluorine"),
                    entry("weight","18.0"),
                    entry("symbol","F")
            ),
            Map.ofEntries(
                    entry("position", "Neon"),
                    entry("weight","20"),
                    entry("symbol","Ne")
            )
    ));

    ArrayList<Map<String,String>> loafer_data = new ArrayList<>(Arrays.asList(
            Map.ofEntries(
                    entry("position", "Hydrogen"),
                    entry("weight","1.442"),
                    entry("symbol","1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0"),
                    entry("colx","dfsfds"),
                    entry("coly","dsfdf")
            ),
            Map.ofEntries(
                    entry("position", "Helium"),
                    entry("weight","4.0"),
                    entry("symbol","He"),
                    entry("colx","tyewuir"),
                    entry("coly","qewr")
            ),
            Map.ofEntries(
                    entry("position", "Lithium"),
                    entry("weight","6.9"),
                    entry("symbol","Li"),
                    entry("colx","eeeeeee"),
                    entry("coly","tttttttt")
            )
    ));

    ArrayList<Map<String,String>> demos_data = new ArrayList<>(Arrays.asList(
            Map.ofEntries(
                    entry("position", "Hydrogen"),
                    entry("weight","1.442"),
                    entry("symbol","H")
            ),
            Map.ofEntries(
                    entry("position", "Helium"),
                    entry("weight","4.0"),
                    entry("symbol","He")
            ),
            Map.ofEntries(
                    entry("position", "Lithium"),
                    entry("weight","6.9"),
                    entry("symbol","Li")
            ),
            Map.ofEntries(
                    entry("position", "Hydrogen"),
                    entry("weight","1.442"),
                    entry("symbol","H")
            ),
            Map.ofEntries(
                    entry("position", "Helium"),
                    entry("weight","4.0"),
                    entry("symbol","He")
            ),
            Map.ofEntries(
                    entry("position", "Lithium"),
                    entry("weight","6.9"),
                    entry("symbol","Li")
            ),
            Map.ofEntries(
                    entry("position", "Hydrogen"),
                    entry("weight","1.442"),
                    entry("symbol","H")
            ),
            Map.ofEntries(
                    entry("position", "Helium"),
                    entry("weight","4.0"),
                    entry("symbol","He")
            ),
            Map.ofEntries(
                    entry("position", "Lithium"),
                    entry("weight","6.9"),
                    entry("symbol","Li")
            ),
            Map.ofEntries(
                    entry("position", "Hydrogen"),
                    entry("weight","1.442"),
                    entry("symbol","H")
            ),
            Map.ofEntries(
                    entry("position", "Helium"),
                    entry("weight","4.0"),
                    entry("symbol","He")
            ),
            Map.ofEntries(
                    entry("position", "Lithium"),
                    entry("weight","6.9"),
                    entry("symbol","Li")
            )
    ));
}