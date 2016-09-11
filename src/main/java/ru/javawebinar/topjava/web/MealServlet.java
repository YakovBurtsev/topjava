package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.dao.Dao;
import ru.javawebinar.topjava.dao.DaoImpl;
import ru.javawebinar.topjava.model.MealWithExceed;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;


public class MealServlet extends HttpServlet {
    private static final Logger LOG = getLogger(MealServlet.class);

    private Dao dao;

    public MealServlet() {
        dao = new DaoImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOG.debug("redirect to mealList");

//        int caloriesPerDay = Integer.parseInt(request.getParameter("caloriesPerDay"));
        int caloriesPerDay = 2000;

        List<MealWithExceed> mealList = MealsUtil.getFilteredWithExceeded(dao.getAll(), LocalTime.of(0, 0), LocalTime.of(23, 0), caloriesPerDay);
        request.setAttribute("mealList", mealList);
        request.getRequestDispatcher("/mealList.jsp").forward(request, response);
    }
}
