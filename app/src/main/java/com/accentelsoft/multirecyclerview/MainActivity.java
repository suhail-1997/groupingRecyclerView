package com.accentelsoft.multirecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    int c = 0;
    int j=0;

    private ArrayList<Integer> groupData;
    private List<Menu> menuList;
    private MenuAdapter menuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        groupData = new ArrayList<>();
        menuList = new ArrayList<>();

        recyclerView = findViewById(R.id.menurecycler);
        progressBar = findViewById(R.id.menu_progress);
        progressBar.setVisibility(View.GONE);

        menuAdapter = new MenuAdapter();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setAdapter(menuAdapter);

        getMenu();

    }
    public void getMenu()
    {
        progressBar.setVisibility(View.VISIBLE);

        String json = "{\"data\":[{\"subcategoryid\":1,\"categoryname\":\"starter\",\"menuid\":1,\"name\":\"idli\",\"price\":50,\"type\":\"veg\"},{\"subcategoryid\":1,\"categoryname\":\"starter\",\"menuid\":2,\"name\":\"upma\",\"price\":30,\"type\":\"veg\"},{\"subcategoryid\":1,\"categoryname\":\"starter\",\"menuid\":9,\"name\":\"masala upma\",\"price\":30,\"type\":\"veg\"},{\"subcategoryid\":1,\"categoryname\":\"starter\",\"menuid\":10,\"name\":\"vada\",\"price\":30,\"type\":\"veg\"},{\"subcategoryid\":1,\"categoryname\":\"starter\",\"menuid\":11,\"name\":\"taco\",\"price\":30,\"type\":\"veg\"},{\"subcategoryid\":2,\"categoryname\":\"liquids\",\"menuid\":3,\"name\":\"lemon juice\",\"price\":10,\"type\":\"veg\"},{\"subcategoryid\":2,\"categoryname\":\"liquids\",\"menuid\":4,\"name\":\"tea\",\"price\":30,\"type\":\"veg\"},{\"subcategoryid\":3,\"categoryname\":\"main course\",\"menuid\":5,\"name\":\"dosa\",\"price\":25,\"type\":\"veg\"},{\"subcategoryid\":3,\"categoryname\":\"main course\",\"menuid\":6,\"name\":\"masala dosa\",\"price\":30,\"type\":\"veg\"},{\"subcategoryid\":3,\"categoryname\":\"main course\",\"menuid\":7,\"name\":\"masala upma dosa\",\"price\":30,\"type\":\"veg\"},{\"subcategoryid\":4,\"categoryname\":\"desert\",\"menuid\":7,\"name\":\"curd\",\"price\":10,\"type\":\"veg\"},{\"subcategoryid\":4,\"categoryname\":\"desert\",\"menuid\":8,\"name\":\"lassi\",\"price\":20,\"type\":\"veg\"}],\"fullError\":null,\"message\":\"success\"}";

        try {
            JSONObject response = new JSONObject(json);
            JSONArray jsonArray = response.getJSONArray("data");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject =jsonArray.getJSONObject(i);
                menuList.add(new Menu(jsonObject.getInt("subcategoryid"),jsonObject.getString("categoryname"),jsonObject.getInt("menuid"),jsonObject.getString("name"),jsonObject.getDouble("price"),jsonObject.getString("type")));
            }
            for (int i = 0; i < menuList.size(); i++) {
                Menu menu = menuList.get(i);
                if (groupData.size() == 0) {
                    groupData.add(c, j);
                    c++;
                    j++;
                } else {
                    if (menu.getCategoryname().equalsIgnoreCase(menuList.get(i - 1).getCategoryname())) {
                        groupData.add(c, j);
                        c++;
                        j++;
                    } else {
                        j = 0;
                        groupData.add(c, j);
                        c++;
                        j++;
                    }
                }
            }
            progressBar.setVisibility(View.GONE);
            menuAdapter.setDataList(menuList,groupData);
        } catch (JSONException e) {
            e.printStackTrace();
        }



//        String url = "your api endpoint";
//        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
//            @Override
//            public void onResponse(JSONObject response) {
//                progressBar.setVisibility(View.GONE);
//                try {
//                    if (response.getString("message").equals("success")) {
//                        //response object
////                        {
////                            "data": [
////                            {
////                                "subcategoryid": 1,
////                                    "categoryname": "starter",
////                                    "menuid": 1,
////                                    "name": "idli",
////                                    "price": 50,
////                                    "type": "veg"
////                            },
////                            {
////                                "subcategoryid": 1,
////                                    "categoryname": "starter",
////                                    "menuid": 2,
////                                    "name": "upma",
////                                    "price": 30,
////                                    "type": "veg"
////                            },
////                            {
////                                "subcategoryid": 2,
////                                    "categoryname": "liquids",
////                                    "menuid": 3,
////                                    "name": "lemon juice",
////                                    "price": 10,
////                                    "type": "veg"
////                            },
////                            {
////                                "subcategoryid": 2,
////                                    "categoryname": "liquids",
////                                    "menuid": 4,
////                                    "name": "tea",
////                                    "price": 30,
////                                    "type": "veg"
////                            },
////                            {
////                                "subcategoryid": 3,
////                                    "categoryname": "main course",
////                                    "menuid": 5,
////                                    "name": "dosa",
////                                    "price": 25,
////                                    "type": "veg"
////                            },
////                            {
////                                "subcategoryid": 3,
////                                    "categoryname": "main course",
////                                    "menuid": 6,
////                                    "name": "masala dosa",
////                                    "price": 30,
////                                    "type": "veg"
////                            },
////                            {
////                                "subcategoryid": 4,
////                                    "categoryname": "desert",
////                                    "menuid": 7,
////                                    "name": "curd",
////                                    "price": 10,
////                                    "type": "veg"
////                            },
////                            {
////                                "subcategoryid": 4,
////                                    "categoryname": "desert",
////                                    "menuid": 8,
////                                    "name": "lassi",
////                                    "price": 20,
////                                    "type": "veg"
////                            }
////                            ],
////                            "fullError": null,
////                                "message": "success"
////                        }
//                        JSONArray jsonArray = response.getJSONArray("data");
//                        for (int i = 0; i < jsonArray.length(); i++) {
//                            JSONObject jsonObject =jsonArray.getJSONObject(i);
//                            menuList.add(new Menu(jsonObject.getInt("subcategoryid"),jsonObject.getString("categoryname"),jsonObject.getInt("menuid"),jsonObject.getString("name"),jsonObject.getDouble("price"),jsonObject.getString("type")));
//                        }
//                            for (int i = 0; i < menuList.size(); i++) {
//                                Menu menu = menuList.get(i);
//                                if (groupData.size() == 0) {
//                                    groupData.add(c, j);
//                                    c++;
//                                    j++;
//                                } else {
//                                    if (menu.getCategoryname().equalsIgnoreCase(menuList.get(i - 1).getCategoryname())) {
//                                        groupData.add(c, j);
//                                        c++;
//                                        j++;
//                                    } else {
//                                        j = 0;
//                                        groupData.add(c, j);
//                                        c++;
//                                        j++;
//                                    }
//                                }
//                            }
//                            progressBar.setVisibility(View.GONE);
//                        menuAdapter.setDataList(menuList,groupData);
//
//
//                    }
//                    else
//                    {
//                        Log.i("menu res", response.getString("message"));
//                    }
//                }catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                error.printStackTrace();
//
//            }
//        });
//        MySingleton.getInstance(MainActivity.this).addToRequestQue(jsonObjectRequest);
    }
}