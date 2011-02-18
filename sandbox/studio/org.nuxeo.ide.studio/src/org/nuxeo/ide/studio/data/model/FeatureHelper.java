/*
 * (C) Copyright 2011 Nuxeo SA (http://nuxeo.com/) and contributors.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * Contributors:
 *     eugen
 */
package org.nuxeo.ide.studio.data.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.nuxeo.ide.studio.StudioPlugin;
import org.nuxeo.ide.studio.data.Tree;
import org.nuxeo.ide.studio.data.TreeImpl;


/**
 * @author eugen
 *
 */
public class FeatureHelper {


    public static Tree buildFeatureTree(String projectName){
        Tree root =  new TreeImpl("root", "root", "Root", null);
        String input = StudioPlugin.getDefault().getProvider().getFeatures(projectName);
        populate(root,input);
        return root;
    }

    protected static void populate(Tree root, String input) {
//        if ( input == null ){
//            input = fakeInput();
//        }

        JSONArray array = JSONArray.fromObject(input);

        Map<String, Group> groups = new HashMap<String, Group>();
        Map<String, Category> categories = new HashMap<String, Category>();

        for ( Object o : array) {
            if ( o instanceof JSONObject) {
                JSONObject jsonObject = (JSONObject) o;
                String id = jsonObject.getString("id");
                String type = jsonObject.getString("type");
                String groupName = jsonObject.getString("typeName");
                String key = jsonObject.getString("key");

                Feature feature = new Feature(id, type, id,  key);

                Group group = groups.get(groupName);
                if ( group == null ){ // create group
                    group = new Group(groupName, groupName);
                    groups.put(groupName, group);

                    String categoryName = getGroupCategory(groupName);
                    if ( categoryName != null) {
                        Category category = categories.get(categoryName);
                        if ( category == null) { // create category
                            category = new Category(categoryName, categoryName);
                            categories.put(categoryName, category);
                            root.getChildren().add(category);
                        }
                        category.getChildren().add(group);
                    } else {
                        root.getChildren().add(group);
                    }

                }
                group.getChildren().add(feature);

            }
        }

    }


    /**
     * @return
     */
    private static String fakeInput() {
        StringBuffer contents = new StringBuffer();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new InputStreamReader(FeatureHelper.class.getResourceAsStream("/features")));
            String text = null;

            // repeat until all lines is read
            while ((text = reader.readLine()) != null) {
                contents.append(text)
                .append(System.getProperty(
                        "line.separator"));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return contents.toString();

    }


    protected static Map<String, String> group2category = new HashMap<String, String>();
    static {
        group2category.put("Life Cycles",           "Content Model");
        group2category.put("Structure Templates",   "Content Model");
        group2category.put("Documents",             "Content Model");
        group2category.put("Schemas",               "Content Model");

        group2category.put("Content Views",         "Search And Listings");
        group2category.put("Virtual Navigations",   "Search And Listings");
        group2category.put("Advanced Search",       "Search And Listings");

        group2category.put("Event Handlers",        "Automation");
        group2category.put("User Actions",          "Automation");
        group2category.put("Automation Chains",     "Automation");

        group2category.put("Mail Templates",        "Templates");
        group2category.put("Document Templates",    "Templates");

        group2category.put("Users and Groups",      "Roles and Permisions");
        group2category.put("Permissions",           "Roles and Permisions");

        group2category.put("XML Extension",           "Advanced Settings");
        group2category.put("Web Services Filtering",  "Advanced Settings");
        group2category.put("Deployment Extensions",   "Advanced Settings");
    }

    private static String getGroupCategory(String groupName) {
        String cat = group2category.get(groupName);
        if ( cat != null ) {
            return cat;
        }
        return "default";
    }




}
