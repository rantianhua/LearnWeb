import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by rantianhua on 16/12/24.
 * refresh client every 5 seconds
 */
@WebServlet(name = "SetHeaderServlet", urlPatterns = "/SetHeader")
public class SetHeaderServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //刷新时间为5秒
        int refreshTime = (int) request.getAttribute("interval");
        if (refreshTime <=  0) refreshTime = 5;
        response.setIntHeader("Refresh", refreshTime);

        response.setContentType("text/html;charset=UTF-8");

        Calendar cal = Calendar.getInstance();
        Date taskTime = cal.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String nowTime = simpleDateFormat.format(taskTime);

        PrintWriter out = response.getWriter();
        String title = "刷新间隔时间";
        String docType =
                "<!DOCTYPE html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n"+
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<p>当前时间是：" + nowTime + "</p>\n" +
                "<p>刷新间隔是：" + refreshTime + "</p>\n");
    }
}
