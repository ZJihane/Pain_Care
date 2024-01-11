package DAO.DAO_Diagnostic;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DownloadResultsServlet")
public class DownloadResultsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve the form parameters
        String weight = request.getParameter("weight");
        String height = request.getParameter("height");
        String first_period = request.getParameter("first_period");
        String cycle_length = request.getParameter("cycle_length");
        String period_duration = request.getParameter("period_duration");
        String nature_period = request.getParameter("nature_period");
        String period_pattern = request.getParameter("period_pattern");
        String pain_trigger[] = request.getParameterValues("pain_trigger");
        String pain_rapport = request.getParameter("pain_rapport");
        String severity_pain = request.getParameter("severity_pain");
        String other_symptom = request.getParameter("other_symptom");
        String endo_history = request.getParameter("endo_history");
        String birth = request.getParameter("birth");
        String trouble_pregnant = request.getParameter("trouble_pregnant");
        String sexual_abuse = request.getParameter("sexual_abuse");
        String riskLevel = request.getParameter("riskLevel");

        // Set the content type and headers for the download
        response.setContentType("text/plain");
        response.setHeader("Content-disposition", "attachment; filename=diagnostic_results.txt");

        try (PrintWriter out = response.getWriter()) {
            // Write the form responses and diagnostic result to the response output stream
            out.println("\t\t\tRésultats du diagnostic");
            out.println("\n");
            out.println("\tAttributs du Diagnostic :");
            out.println("\tPoids : " + weight);
            out.println("\tHauteur : " + height);
            out.println("\tRésultat du Risque : " + riskLevel);

            out.println("\n\tAttributs de la Période :");
            out.println("\tPremier Cycle Menstruel : " + first_period);
            out.println("\tLongueur du Cycle Menstruel : " + cycle_length);
            out.println("\tDurée des Règles : " + period_duration);
            out.println("\tNature des Règles : " + nature_period);
            out.println("\tPattern des Règles : " + period_pattern);

            out.println("\n\tAttributs de la Douleur :");
            out.println("\tDéclencheurs de la Douleur :");
            for (String trigger : pain_trigger) {
                out.println("\t- " + trigger);
            }
            out.println("\tDouleur lors des Rapports Sexuels : " + pain_rapport);
            out.println("\tIntensité de la Douleur : " + severity_pain);
            out.println("\tAutres Symptômes : " + other_symptom);

            out.println("\n\tAttributs de l'Histoire Médicale :");
            out.println("\tAntécédents d'Endométriose : " + endo_history);
            out.println("\tHistoire des Accouchements : " + birth);
            out.println("\tDifficultés à Tomber Enceinte : " + trouble_pregnant);
            out.println("\tAntécédents d'Agressions Sexuelles : " + sexual_abuse);

            // Ensure that the response is committed
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }
    }
}
