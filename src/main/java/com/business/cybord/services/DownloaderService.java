/**
 * 
 */
package com.business.cybord.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 * @author Ralph
 *
 */
@Service
public class DownloaderService {

	private static final Logger log = LoggerFactory.getLogger(DownloaderService.class);

	public static final String XLS_MIME_TYPE = "application/vnd.ms-excel";

	public void generateExcelReport(List<Map<String, String>> data, String reportName, HttpServletResponse response)
			throws IOException {

		if (!data.isEmpty()) {
			log.info("Generating Excel report for {} data", data.size());
			PrintWriter out = null;

			response.setHeader("Expires", "0");
			response.setHeader("Cache-Control", "must-revalidate, post-check=0, pre-check=0");
			response.setHeader("Pragma", "public");
			response.setContentType(XLS_MIME_TYPE + "; charset=UTF-8");
			response.setHeader("Content-disposition", "attachment;filename="+reportName+".xls");
			response.setHeader("Pragma", "public");
			response.addHeader("Cache-Control", "post-check=0, pre-check=0,max-age=0");

			out = response.getWriter();
			// out= new PrintWriter(System.out);

			out.print("<html>");
			out.print("<body>");

			out.print("<table>");
			out.print("<tr><td></td></tr>");

			out.print("<tr style='background: #FFFFFF;color: #222222;	font: bold 15px tahoma;'><td>");
			out.print(reportName);
			out.print("</td></tr>");

			out.print("<tr><td></td></tr>");
			out.print("<tr><td></td></tr>");

			out.print("</table>");

			out.print("<table border='1'>");
			out.print("<tr style='background: #203f5e;color: #FFFFFF;	font: bold 13px tahoma;'>");

			// Se contruyen las cabeceras de la tabla
			for (String key : data.get(0).keySet()) {
				out.print("<td nowrap='nowrap'>");
				out.print(key.toString());
				out.print("</td>");
			}

			// Se construye la table con sus valores
			int i = 0;
			for (Map<String, String> map : data) {
				i++;
				out.print(
						"<tr style='FONT-WEIGHT:normal;FONT-SIZE: 12px;COLOR:#000000;FONT-FAMILY:Arial, Helvetica, sans-serif;background-color:#ffffff;'>");
				for (String key : map.keySet()) {
					String value = (map.get(key) != null ? map.get(key).toString() : " ");
					if (value.trim().equals("")) {
						out.print("<td nowrap='nowrap'>");
						out.print(" ");
						out.print("</td>");
					} else {

						out.print("<td nowrap='nowrap' style='mso-number-format:\"\\@\";'>");
						out.print(value);
						out.print("</td>");
					}
				}
				out.print("\n");

				if ((i % 1000) == 0) {
					out.flush();// SE ESCRIBE EL CONTENIDO DEL ARCHIVO EN EL STREAM DE SALIDA
				}
				out.print("</tr>");

			}
			out.print("</table>");
			out.print("</body>");
			out.print("</html>");

			// SE ESCRIBE EL CONTENIDO DEL ARCHIVO EN EL STREAM DE SALIDA
			// outStream = response.getOutputStream();
			response.setStatus(HttpServletResponse.SC_OK);
			out.flush();
			out.close();
			return;

		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					" No es posible generar el roporte, no hay dato en el sistema.");
		}

	}

}
