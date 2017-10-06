package servlets;

import models.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sulaymon on 03.10.2017.
 */
public class CalculatorServlet extends HttpServlet {

    private Float digit, result;
    private String history = "", mathaction;
    private Map<String, Operation> map;

    @Override
    public void init() throws ServletException {
        map = new HashMap<>();
        map.put("+", new Plus());
        map.put("-", new Minus());
        map.put("*", new Multiplication());
        map.put("/", new Division());
        result = 0F;
        history = "";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        init();
        req.getRequestDispatcher("WEB-INF/calculator.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        digit = Float.valueOf(req.getParameter("digit"));
        mathaction = req.getParameter("mathaction");


        if (mathaction.equals("+") || mathaction.equals("-") || !result.equals(0F)) {
            result = map.get(mathaction).compute(result, digit);
        }
        else {
            result = map.get(mathaction).compute( 1F, digit);
        }
        history += (mathaction+" "+String.valueOf(digit)+")");
        history = "("+history;
        req.setAttribute("digits", history);
        req.setAttribute("result",result);
        req.getRequestDispatcher("WEB-INF/jsp/index.jsp").forward(req,resp);
    }
}