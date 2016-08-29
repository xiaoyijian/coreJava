package com.xyj.template;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.*;

/**
 * Created by xiaoyijian on 2016/8/27.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@ActiveProfiles("prod")
public class TestJson {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String getJson(String fullFileName){
        File file = new File(fullFileName);
        Scanner scanner = null;
        StringBuilder buffer = new StringBuilder();
        try {
            scanner = new Scanner(file, "utf-8");
            while (scanner.hasNextLine()) {
                buffer.append(scanner.nextLine());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return buffer.toString();
    }

    private Set getAreaNames(String cityCode) {
        Set<String> set = new HashSet<>();
        String result = getJson("E:/china-main-city/"+cityCode+"00.json");
        if(result== null ||result.length() >0) {
            JSONObject jsonObject = JSONObject.parseObject(result);
            JSONArray array = jsonObject.getJSONArray("features");
            for(int i=0;i<array.size();i++) {
                String name = array.getJSONObject(i).getJSONObject("properties").getString("name");
                set.add(name);
            }
        }

        return set;
    }
    @Test
    public void test(){
        String result = getJson("E:/china-main-city/110100.json");
        JSONObject jsonObject = JSONObject.parseObject(result);
        JSONArray array = jsonObject.getJSONArray("features");
        for(int i=0;i<array.size();i++) {
            String name = array.getJSONObject(i).getJSONObject("properties").getString("name");
            System.out.println(name);
        }
    }
    @Test
    public void testJdbcTemplate(){
        Set dirtySet = new HashSet();
        dirtySet.add("市辖区");
        dirtySet.add("矿区");
        List<String> codes = jdbcTemplate.queryForList("select code from d_areas where length(code) = 4 and code not in ('1101','1102','1201','1202','3414','4190','5002')", String.class);
        for(String code:codes) {
            String areaName = jdbcTemplate.queryForObject("select name from d_areas where code = '" + code + "'", String.class);
            Set mapSet = getAreaNames(code);
            if(mapSet.contains(areaName)) {
                System.out.println(areaName);
            }
        }
    }
}
