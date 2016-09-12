package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.dao.Dao;
import ru.javawebinar.topjava.dao.DaoForMeal;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealWithExceed;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;


public class MealServlet extends HttpServlet {
    private static final Logger LOG = getLogger(MealServlet.class);
    private static String INSERT_OR_EDIT = "/meal.jsp";
    private static String LIST_MEAL = "/mealList.jsp";
    private static int caloriesPerDay = 2000;

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private static String formatLocalDateTime(LocalDateTime localDateTime) {
        return localDateTime.format(formatter);
    }

    private Dao dao;

    public MealServlet() {
        dao = new DaoForMeal();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String forward;
        String action = request.getParameter("action");
        if (action !=null) {
            if (action.equalsIgnoreCase("delete")) {
                int id = Integer.parseInt(request.getParameter("id"));
                dao.delete(id);
                forward = LIST_MEAL;
                List<MealWithExceed> mealList = MealsUtil.getFilteredWithExceeded(dao.getAll(), LocalTime.MIN, LocalTime.MAX, caloriesPerDay);
                request.setAttribute("mealList", mealList);
                LOG.debug("redirect to mealList");
            } else if (action.equalsIgnoreCase("edit")) {
                forward = INSERT_OR_EDIT;
                int id = Integer.parseInt(request.getParameter("id"));
                Meal meal = dao.getById(id);
                request.setAttribute("meal", meal);
            } else {
                forward = INSERT_OR_EDIT;
            }
        }
        else {
            forward = LIST_MEAL;
            List<MealWithExceed> mealList = MealsUtil.getFilteredWithExceeded(dao.getAll(), LocalTime.MIN, LocalTime.MAX, caloriesPerDay);
            request.setAttribute("mealList", mealList);
        }
        request.getRequestDispatcher(forward).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");

        Meal meal = new Meal();
        LocalDateTime localDateTime = LocalDateTime.parse(request.getParameter("datetime"));
        meal.setDateTime(localDateTime);

        meal.setDescription(request.getParameter("description"));

        meal.setCalories(Integer.parseInt(request.getParameter("calories")));

        String id = request.getParameter("id");
        if (id==null || id.isEmpty()) {
            dao.add(meal);
        } else {
            meal.setId(Integer.parseInt(id));
            dao.update(meal);
        }

        List<MealWithExceed> mealList = MealsUtil.getFilteredWithExceeded(dao.getAll(), LocalTime.MIN, LocalTime.MAX, caloriesPerDay);
        request.setAttribute("mealList", mealList);
        request.getRequestDispatcher(LIST_MEAL).forward(request, response);
    }
}
