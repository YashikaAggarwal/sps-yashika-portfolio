// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import java.util.*;
import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** Servlet that returns some example content. TODO: modify this file to handle comments data */
@WebServlet("/data")
public class DataServlet extends HttpServlet {
    
    ArrayList<String> list=new ArrayList<String>();
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    // response.setContentType("text/html;");
    // response.getWriter().println("Hello Yashika Aggarwal!<br>");
    // response.getWriter().println("Cool!!");
    // list.add("Hi! Yashika");
    // list.add("Great!");

    //Converting arraylist to jsonarray

    Gson gobj = new Gson() ;
    String json = gobj.toJson(list) ;

    response.setContentType("application/json") ;
    response.getWriter().print(json) ;

  }

   @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    String value = request.getParameter("cmnt");
    String text = "" ;
    if (value != null) {
      text = value;
    }
    list.add(text);
    response.setContentType("text/html;");
    response.getWriter().println(text);
    response.sendRedirect("/index.html");
  }


}
