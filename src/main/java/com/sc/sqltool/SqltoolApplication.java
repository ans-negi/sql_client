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
                    entry("symbol","1 2 3 4 5 6 7 8 9 0 1 2 3 4 5 6 7 8 9 0 8342 432 432 324 324 34 324 33423 3 234 3 243 4342 23 34 2 324 432 3 432 34 342 324 342  32 342 342 34 343 dsfjhdfjdfjhdsjhdsfjdsfh " +
                            "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa 343423432jh dfsdj 24324 324 34 34 2324 43 234 "),
                    entry("colx","dfsfds"),
                    entry("coly","dsfdf"),
                    entry("colt","dfsfds"),
                    entry("colu","dsfdf"),
                    entry("coli","dfsfds"),
                    entry("colo","dsfdf"),
                    entry("cola","dsfdf"),
                    entry("colb","dfsfds"),
                    entry("colc","dsfdf"),
                    entry("cold","dsfdf"),
                    entry("cole","dfsfds"),
                    entry("colf","dsfdf")
            ),
            Map.ofEntries(
                    entry("position", "Helium"),
                    entry("weight","4.0"),
                    entry("symbol","He"),
                    entry("colx","tyewuir"),
                    entry("coly","qewr"),
                    entry("colt","dfsfds"),
                    entry("colu","dsfdf"),
                    entry("coli","dfsfds"),
                    entry("colo","dsfdf"),
                    entry("cola","dsfdf"),
                    entry("colb","dfsfds"),
                    entry("colc","dsfdf"),
                    entry("cold","dsfdf"),
                    entry("cole","dfsfds"),
                    entry("colf","dsfdf")
            ),
            Map.ofEntries(
                    entry("position", "Lithium"),
                    entry("weight","6.9"),
                    entry("symbol","Li"),
                    entry("colx","eeeeeee"),
                    entry("coly","tttttttt"),
                    entry("colt","dfsfds"),
                    entry("colu","dsfdf"),
                    entry("coli","dfsfds"),
                    entry("colo","dsfdf"),
                    entry("cola","dsfdf"),
                    entry("colb","dfsfds"),
                    entry("colc","dsfdf"),
                    entry("cold","dsfdf"),
                    entry("cole","dfsfds"),
                    entry("colf","dsfdf")
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